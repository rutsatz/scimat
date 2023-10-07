/*
 * UpdateSubjectCategoryEvent.java
 *
 * Created on 28-dic-2011, 20:10:51
 */
package es.ugr.scimat.knowledgebaseevents.event.update;

import java.util.ArrayList;
import es.ugr.scimat.knowledgebaseevents.event.KnowledgeBaseEvent;
import es.ugr.scimat.model.knowledgebase.entity.SubjectCategory;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

/**
 *
 * @author mjcobo
 */
public class UpdateSubjectCategoryEvent implements KnowledgeBaseEvent {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/
  
  /**
   * 
   */
  private ArrayList<SubjectCategory> subjectCategories;
  
  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/
  
  /**
   * 
   * @param subjectCategories 
   */
  public UpdateSubjectCategoryEvent(ArrayList<SubjectCategory> subjectCategories) {
    this.subjectCategories = subjectCategories;
  }
  
  /**
   * 
   * @param subjectCategories 
   */
  public UpdateSubjectCategoryEvent(SubjectCategory subjectCategory) {
    this.subjectCategories = new ArrayList<SubjectCategory>();
    this.subjectCategories.add(subjectCategory);
  }
  
  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/
  
  /**
   * 
   * @throws KnowledgeBaseException 
   */
  public void fireEvent() throws KnowledgeBaseException {
    
    CurrentProject.getInstance().getKbObserver().fireSubjectCategoryUpdated(subjectCategories);
  }
  
  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
