/*
 * AddReferenceGroupEvent.java
 *
 * Created on 28-dic-2011, 20:10:51
 */
package es.ugr.scimat.knowledgebaseevents.event.add;

import java.util.ArrayList;
import es.ugr.scimat.knowledgebaseevents.event.KnowledgeBaseEvent;
import es.ugr.scimat.model.knowledgebase.entity.ReferenceGroup;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

/**
 *
 * @author mjcobo
 */
public class AddReferenceGroupEvent implements KnowledgeBaseEvent {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/
  
  /**
   * 
   */
  private ArrayList<ReferenceGroup> referenceGroups;
  
  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/
  
  /**
   * 
   * @param referenceGroups 
   */
  public AddReferenceGroupEvent(ArrayList<ReferenceGroup> referenceGroups) {
    this.referenceGroups = referenceGroups;
  }
  
  /**
   * 
   * @param referenceGroup 
   */
  public AddReferenceGroupEvent(ReferenceGroup referenceGroup) {
    this.referenceGroups = new ArrayList<ReferenceGroup>();
    this.referenceGroups.add(referenceGroup);
  }
  
  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/
  
  /**
   * 
   * @throws KnowledgeBaseException 
   */
  public void fireEvent() throws KnowledgeBaseException {
    
    CurrentProject.getInstance().getKbObserver().fireReferenceGroupAdded(referenceGroups);
  }
  
  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
