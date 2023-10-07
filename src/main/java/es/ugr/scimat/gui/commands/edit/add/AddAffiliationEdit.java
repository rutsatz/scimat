/*
 * AddAffiliationEdit.java
 *
 * Created on 14-mar-2011, 17:39:41
 */
package es.ugr.scimat.gui.commands.edit.add;

import java.util.ArrayList;
import javax.swing.undo.CannotUndoException;
import es.ugr.scimat.gui.commands.edit.KnowledgeBaseEdit;
import es.ugr.scimat.gui.undostack.UndoStack;
import es.ugr.scimat.knowledgebaseevents.KnowledgeBaseEventsReceiver;
import es.ugr.scimat.model.knowledgebase.entity.Affiliation;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

/**
 *
 * @author mjcobo
 */
public class AddAffiliationEdit extends KnowledgeBaseEdit {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  /**
   * The ID of the Affiliation
   */
  private Integer affiliationID;

  /**
   * This attribute contains the complete affiliation.
   */
  private String fullAffilliation;

  /**
   * The elements added
   */
  private ArrayList<Affiliation> affiliationsAdded;

  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  /**
   * 
   * @param fullAffilliation
   */
  public AddAffiliationEdit(String fullAffilliation) {
    super();

    this.fullAffilliation = fullAffilliation;
    this.affiliationsAdded = new ArrayList<Affiliation>();
  }

  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   * 
   * @throws KnowledgeBaseException
   */
  @Override
  public boolean execute() throws KnowledgeBaseException {

    boolean successful = false;

    try {

      if (this.fullAffilliation == null) {

        successful = false;
        this.errorMessage = "The full affiliation can not be null.";
      
      } else if (CurrentProject.getInstance().getFactoryDAO().getAffiliationDAO().checkAffiliation(this.fullAffilliation)) { // Check the integrity

        successful = false;
        this.errorMessage = "An Affiliation yet exists with this full affiliation.";

      } else {

        this.affiliationID = CurrentProject.getInstance().getFactoryDAO().getAffiliationDAO().addAffiliation(this.fullAffilliation, true);

        if (this.affiliationID != null) {

          CurrentProject.getInstance().getKnowledgeBase().commit();

          this.affiliationsAdded.add(CurrentProject.getInstance().getFactoryDAO().getAffiliationDAO().getAffiliation(this.affiliationID));

          KnowledgeBaseEventsReceiver.getInstance().fireEvents();

          successful = true;

          UndoStack.addEdit(this);

        } else {

          CurrentProject.getInstance().getKnowledgeBase().rollback();

          successful = false;
          this.errorMessage = "An error happened.";
        }
      }

    } catch (KnowledgeBaseException e) {

      CurrentProject.getInstance().getKnowledgeBase().rollback();

      successful = false;
      this.errorMessage = "An exception happened.";

      throw e;
    }

    return successful;
  
  }

  /**
   *
   * @throws CannotUndoException
   */
  @Override
  public void undo() throws CannotUndoException {
    super.undo();

    boolean flag;

    try {

      flag = CurrentProject.getInstance().getFactoryDAO().getAffiliationDAO().removeAffiliation(this.affiliationID, true);

      if (flag) {

        CurrentProject.getInstance().getKnowledgeBase().commit();

        KnowledgeBaseEventsReceiver.getInstance().fireEvents();

      } else {

        CurrentProject.getInstance().getKnowledgeBase().rollback();
      }

    } catch (KnowledgeBaseException e) {

      e.printStackTrace(System.err);

      try{
        
        CurrentProject.getInstance().getKnowledgeBase().rollback();

      } catch (KnowledgeBaseException e2) {

        e2.printStackTrace(System.err);

      }
    }
  }

  /**
   * 
   * @throws CannotUndoException
   */
  @Override
  public void redo() throws CannotUndoException {
    super.redo();

    boolean flag;

    try {

      flag = CurrentProject.getInstance().getFactoryDAO().getAffiliationDAO().addAffiliation(this.affiliationID, this.fullAffilliation, true);

      if (flag) {

        CurrentProject.getInstance().getKnowledgeBase().commit();

        KnowledgeBaseEventsReceiver.getInstance().fireEvents();

      } else {

        CurrentProject.getInstance().getKnowledgeBase().rollback();
      }

    } catch (KnowledgeBaseException e) {

      e.printStackTrace(System.err);

      try{

        CurrentProject.getInstance().getKnowledgeBase().rollback();

      } catch (KnowledgeBaseException e2) {

        e2.printStackTrace(System.err);

      }
    }
  }

  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
