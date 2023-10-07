/*
 * RemoveReferenceSourceWithoutGroupEvent.java
 *
 * Created on 28-dic-2011, 20:10:51
 */
package es.ugr.scimat.knowledgebaseevents.event.remove;

import java.util.ArrayList;
import es.ugr.scimat.knowledgebaseevents.event.KnowledgeBaseEvent;
import es.ugr.scimat.model.knowledgebase.entity.ReferenceSource;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

/**
 *
 * @author mjcobo
 */
public class RemoveReferenceSourceWithoutGroupEvent implements KnowledgeBaseEvent {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/
  
  /**
   * 
   */
  private ArrayList<ReferenceSource> referenceSources;
  
  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/
  
  /**
   * 
   * @param referenceSources 
   */
  public RemoveReferenceSourceWithoutGroupEvent(ArrayList<ReferenceSource> referenceSources) {
    this.referenceSources = referenceSources;
  }
  
  /**
   * 
   * @param referenceSource 
   */
  public RemoveReferenceSourceWithoutGroupEvent(ReferenceSource referenceSource) {
    this.referenceSources = new ArrayList<ReferenceSource>();
    this.referenceSources.add(referenceSource);
  }
  
  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/
  
  /**
   * 
   * @throws KnowledgeBaseException 
   */
  public void fireEvent() throws KnowledgeBaseException {
    
    CurrentProject.getInstance().getKbObserver().fireReferenceSourceWithoutGroupRemoved(referenceSources);
  }
  
  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
