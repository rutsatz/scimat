/*
 * RefreshJournalEvent.java
 *
 * Created on 28-dic-2011, 20:10:51
 */
package scimat.knowledgebaseevents.event.refresh;

import scimat.knowledgebaseevents.event.KnowledgeBaseEvent;
import scimat.model.knowledgebase.exception.KnowledgeBaseException;
import scimat.project.CurrentProject;

/**
 *
 * @author mjcobo
 */
public class RefreshJournalEvent implements KnowledgeBaseEvent {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/
  
  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/
  
  /**
   * 
   * @param journals 
   */
  public RefreshJournalEvent() {
  
  }
  
  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/
  
  /**
   * 
   * @throws KnowledgeBaseException 
   */
  public void fireEvent() throws KnowledgeBaseException {
    
    CurrentProject.getInstance().getKbObserver().fireJournalRefresh();
  }
  
  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}