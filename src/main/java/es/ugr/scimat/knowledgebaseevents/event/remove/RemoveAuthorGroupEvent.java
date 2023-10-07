/*
 * RemoveAuthorGroupEvent.java
 *
 * Created on 28-dic-2011, 20:10:51
 */
package es.ugr.scimat.knowledgebaseevents.event.remove;

import java.util.ArrayList;
import es.ugr.scimat.knowledgebaseevents.event.KnowledgeBaseEvent;
import es.ugr.scimat.model.knowledgebase.entity.AuthorGroup;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

/**
 *
 * @author mjcobo
 */
public class RemoveAuthorGroupEvent implements KnowledgeBaseEvent {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/
  
  /**
   * 
   */
  private ArrayList<AuthorGroup> authorGroups;
  
  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/
  
  /**
   * 
   * @param authorGroups 
   */
  public RemoveAuthorGroupEvent(ArrayList<AuthorGroup> authorGroups) {
    this.authorGroups = authorGroups;
  }
  
  /**
   * 
   * @param authorGroup
   */
  public RemoveAuthorGroupEvent(AuthorGroup authorGroup) {
    this.authorGroups = new ArrayList<AuthorGroup>();
    this.authorGroups.add(authorGroup);
  }
  
  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/
  
  /**
   * 
   * @throws KnowledgeBaseException 
   */
  public void fireEvent() throws KnowledgeBaseException {
    
    CurrentProject.getInstance().getKbObserver().fireAuthorGroupRemoved(authorGroups);
  }
  
  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
