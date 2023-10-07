/*
 * FrequencyDistributionPerPeriod.java
 *
 * Created on 25-ene-2012, 20:27:39
 */
package es.ugr.scimat.model.statistic.entity;

import es.ugr.scimat.api.analysis.statistic.StatisticBasedFrequency;
import es.ugr.scimat.model.knowledgebase.entity.Period;

/**
 *
 * @author mjcobo
 */
public class FrequencyDistributionPerPeriod {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/
  
  private Period period;
  private StatisticBasedFrequency stats;
  
  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  /**
   * 
   * @param period
   * @param stats 
   */
  public FrequencyDistributionPerPeriod(Period period, StatisticBasedFrequency stats) {
    this.period = period;
    this.stats = stats;
  }
  
  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   * 
   * @return 
   */
  public Period getPeriod() {
    return period;
  }

  /**
   * 
   * @return 
   */
  public StatisticBasedFrequency getStats() {
    return stats;
  }
  
  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
