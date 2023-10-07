/*
 * MoveAuthorToDifferentAuthorGroupEdit.java
 *
 * Created on 24-may-2011, 17:54:23
 */
package es.ugr.scimat.gui.commands.edit.move;

import java.util.ArrayList;
import javax.swing.undo.CannotUndoException;
import es.ugr.scimat.gui.commands.edit.KnowledgeBaseEdit;
import es.ugr.scimat.gui.undostack.UndoStack;
import es.ugr.scimat.knowledgebaseevents.KnowledgeBaseEventsReceiver;
import es.ugr.scimat.model.knowledgebase.dao.AuthorDAO;
import es.ugr.scimat.model.knowledgebase.dao.AuthorGroupDAO;
import es.ugr.scimat.model.knowledgebase.entity.Author;
import es.ugr.scimat.model.knowledgebase.entity.AuthorGroup;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

/**
 *
 * @author mjcobo
 */
public class MoveAuthorToDifferentAuthorGroupEdit extends KnowledgeBaseEdit {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/
  
  private ArrayList<Author> authorsToMove;
  private AuthorGroup[] authorGroups;
  private ArrayList<AuthorGroup> authorGroupsAdded;
  private boolean[] groupNew; // true if the group i has to be created.
  
  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/
  
  /**
   * 
   */
  public MoveAuthorToDifferentAuthorGroupEdit(ArrayList<Author> authorsToMove) {
    this.authorsToMove = authorsToMove;
  }
  
  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/
  
  /**
   * 
   * @return
   * @throws KnowledgeBaseException 
   */
  @Override
  public boolean execute() throws KnowledgeBaseException {
    
    boolean successful = true;
    int i;
    Integer authorGroupID;
    AuthorGroup authorGroup;
    Author author;
    AuthorGroupDAO authorGroupDAO;
    AuthorDAO authorDAO;
    
    try {
      
      authorGroupDAO = CurrentProject.getInstance().getFactoryDAO().getAuthorGroupDAO();
      authorDAO = CurrentProject.getInstance().getFactoryDAO().getAuthorDAO();
      
      this.authorGroups = new AuthorGroup[this.authorsToMove.size()];
      this.groupNew = new boolean[this.authorsToMove.size()];
      this.authorGroupsAdded = new ArrayList<AuthorGroup>();
      
      for (i = 0; i < this.authorsToMove.size(); i++) {
      
        author = this.authorsToMove.get(i);
        
        authorGroup = authorGroupDAO.getAuthorGroup(author.getAuthorName());
        
        if (authorGroup == null) {
        
          this.groupNew[i] = true;
          
          authorGroupID = authorGroupDAO.addAuthorGroup(author.getAuthorName(), false, true);
          
          authorGroup = authorGroupDAO.getAuthorGroup(authorGroupID);
          
          this.authorGroupsAdded.add(authorGroup);
          
        } else {
        
          this.groupNew[i] = false;
        }
        
        this.authorGroups[i] = authorGroup;
        
        successful = authorDAO.setAuthorGroup(author.getAuthorID(), 
                authorGroup.getAuthorGroupID(), true);
      }

      if (successful) {

        CurrentProject.getInstance().getKnowledgeBase().commit();
        KnowledgeBaseEventsReceiver.getInstance().fireEvents();

        UndoStack.addEdit(this);


      } else {

        CurrentProject.getInstance().getKnowledgeBase().rollback();

        this.errorMessage = "An error happened";

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
    
    boolean successful = true;
    int i;
    AuthorGroupDAO authorGroupDAO;
    AuthorDAO authorDAO;
    
    try {
      
      authorGroupDAO = CurrentProject.getInstance().getFactoryDAO().getAuthorGroupDAO();
      authorDAO = CurrentProject.getInstance().getFactoryDAO().getAuthorDAO();
      
      for (i = 0; i < this.authorsToMove.size(); i++) {
        
        successful = authorDAO.setAuthorGroup(this.authorsToMove.get(i).getAuthorID(), null, true);
        
        if (this.groupNew[i]) {
        
          successful = authorGroupDAO.removeAuthorGroup(this.authorGroups[i].getAuthorGroupID(), true);
        }
      }

      if (successful) {

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
    
    boolean successful = true;
    int i;
    AuthorGroupDAO authorGroupDAO;
    AuthorDAO authorDAO;
    
    try {
      
      authorGroupDAO = CurrentProject.getInstance().getFactoryDAO().getAuthorGroupDAO();
      authorDAO = CurrentProject.getInstance().getFactoryDAO().getAuthorDAO();
      
      for (i = 0; i < this.authorsToMove.size(); i++) {
        
        if (groupNew[i]) {
        
          successful = authorGroupDAO.addAuthorGroup(this.authorGroups[i], true);
        }
        
        successful = authorDAO.setAuthorGroup(this.authorsToMove.get(i).getAuthorID(), authorGroups[i].getAuthorGroupID(), true);
      }

      if (successful) {

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
