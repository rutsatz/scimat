/*
 * UpdatePeriodEvent.java
 *
 * Created on 28-dic-2011, 20:10:51
 */
package es.ugr.scimat.knowledgebaseevents.event.update;

import java.util.ArrayList;
import es.ugr.scimat.knowledgebaseevents.event.KnowledgeBaseEvent;
import es.ugr.scimat.model.knowledgebase.entity.Period;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

/**
 *
 * @author mjcobo
 */
public class UpdatePeriodEvent implements KnowledgeBaseEvent {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/
  
  /**
   * 
   */
  private ArrayList<Period> periods;
  
  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/
  
  /**
   * 
   * @param periods 
   */
  public UpdatePeriodEvent(ArrayList<Period> periods) {
    this.periods = periods;
  }
  
  /**
   * 
   * @param period 
   */
  public UpdatePeriodEvent(Period period) {
    this.periods = new ArrayList<Period>();
    this.periods.add(period);
  }
  
  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/
  
  /**
   * 
   * @throws KnowledgeBaseException 
   */
  public void fireEvent() throws KnowledgeBaseException {
    
    CurrentProject.getInstance().getKbObserver().firePeriodUpdated(periods);
  }
  
  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
