/*
 * AddReferenceEvent.java
 *
 * Created on 28-dic-2011, 20:10:51
 */
package es.ugr.scimat.knowledgebaseevents.event.add;

import java.util.ArrayList;
import es.ugr.scimat.knowledgebaseevents.event.KnowledgeBaseEvent;
import es.ugr.scimat.model.knowledgebase.entity.Reference;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

/**
 *
 * @author mjcobo
 */
public class AddReferenceEvent implements KnowledgeBaseEvent {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/
  
  /**
   * 
   */
  private ArrayList<Reference> references;
  
  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/
  
  /**
   * 
   * @param references 
   */
  public AddReferenceEvent(ArrayList<Reference> references) {
    this.references = references;
  }
  
  /**
   * 
   * @param reference
   */
  public AddReferenceEvent(Reference reference) {
    this.references = new ArrayList<Reference>();
    this.references.add(reference);
  }
  
  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/
  
  /**
   * 
   * @throws KnowledgeBaseException 
   */
  public void fireEvent() throws KnowledgeBaseException {
    
    CurrentProject.getInstance().getKbObserver().fireReferenceAdded(references);
  }
  
  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
