
/*
 * UpdateSubjectCategoryEdit.java
 *
 * Created on 14-mar-2011, 17:38:49
 */
package es.ugr.scimat.gui.commands.edit.update;

import java.util.ArrayList;
import javax.swing.undo.CannotUndoException;

import es.ugr.scimat.gui.commands.edit.KnowledgeBaseEdit;
import es.ugr.scimat.gui.undostack.UndoStack;
import es.ugr.scimat.knowledgebaseevents.KnowledgeBaseEventsReceiver;
import es.ugr.scimat.model.knowledgebase.entity.SubjectCategory;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

/**
 *
 * @author mjcobo
 */
public class UpdateSubjectCategoryEdit extends KnowledgeBaseEdit {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  /**
   *
   */
  private Integer subjectCategoryID;

  /**
   *
   */
  private String subjectCategoryName;

  /**
   * The elements added
   */
  private ArrayList<SubjectCategory> subjectCategoriesOld;
  
  private ArrayList<SubjectCategory> subjectCategoriesUpdated;

  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  public UpdateSubjectCategoryEdit(Integer subjectCategoryID, String subjectCategoryName) {
    super();

    this.subjectCategoryID = subjectCategoryID;
    this.subjectCategoryName = subjectCategoryName;
    this.subjectCategoriesOld = new ArrayList<SubjectCategory>();
    this.subjectCategoriesUpdated = new ArrayList<SubjectCategory>();
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

      if (this.subjectCategoryName == null) {

        successful = false;
        this.errorMessage = "The name can not be null.";

      } else if (CurrentProject.getInstance().getFactoryDAO().getSubjectCategoryDAO().checkSubjectCategory(subjectCategoryName)) {

        successful = false;
        this.errorMessage = "A Subject categoty yet exists with this name.";

      } else {

        this.subjectCategoriesOld.add(CurrentProject.getInstance().getFactoryDAO().getSubjectCategoryDAO().getSubjectCategory(subjectCategoryID));

        successful = CurrentProject.getInstance().getFactoryDAO().getSubjectCategoryDAO().setSubjectCategoryName(subjectCategoryID, subjectCategoryName, true);
        
        this.subjectCategoriesUpdated.add(CurrentProject.getInstance().getFactoryDAO().getSubjectCategoryDAO().getSubjectCategory(subjectCategoryID));

        if (successful) {

          CurrentProject.getInstance().getKnowledgeBase().commit();

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
    SubjectCategory subjectCategory;

    try {

      subjectCategory = this.subjectCategoriesOld.get(0);

      flag = CurrentProject.getInstance().getFactoryDAO().getSubjectCategoryDAO().setSubjectCategoryName(subjectCategory.getSubjectCategoryID(),
              subjectCategory.getSubjectCategoryName(), true);

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

      flag = CurrentProject.getInstance().getFactoryDAO().getSubjectCategoryDAO().setSubjectCategoryName(subjectCategoryID, subjectCategoryName, true);

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
