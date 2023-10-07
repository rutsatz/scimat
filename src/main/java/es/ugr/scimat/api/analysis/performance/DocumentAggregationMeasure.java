/*
 * DocumentAggregationMeasure.java
 *
 * Created on 21-feb-2011, 12:27:49
 */
package es.ugr.scimat.api.analysis.performance;

import es.ugr.scimat.api.analysis.performance.docmapper.DocumentSet;

/**
 *
 * @author mjcobo
 */
public interface DocumentAggregationMeasure {

  /**
   * 
   * @param documentSet
   * @return
   */
  public double calculateMeasure(DocumentSet documentSet);
}
