/*
 * AverageCitationAggregationMeasure.java
 *
 * Created on 21-feb-2011, 12:30:16
 */
package es.ugr.scimat.api.analysis.performance.quality;

import es.ugr.scimat.api.analysis.performance.docmapper.DocumentSet;
import es.ugr.scimat.api.dataset.Dataset;
import es.ugr.scimat.api.dataset.exception.NotExistsItemException;
import es.ugr.scimat.api.analysis.performance.DocumentAggregationMeasure;

import java.util.ArrayList;

/**
 *
 * @author mjcobo
 */
public class AverageCitationAggregationMeasure implements DocumentAggregationMeasure {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  private Dataset dataset;

  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  public AverageCitationAggregationMeasure(Dataset dataset) {
    this.dataset = dataset;
  }

  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   *
   * @param docsList
   * @return
   *
   * @throws NotExistsItemException if a doc is not present in the dataset.
   */
  public double calculateMeasure(DocumentSet documentSet) {

    int i;
    double result;
    ArrayList<Integer> docsList;
    
    docsList = documentSet.getDocuments();
    result = 0;

    for (i = 0; i < docsList.size(); i++) {
        
      result += dataset.getDocumentCitations(docsList.get(i));
    }

    if (documentSet.getDocumentsCount() > 0) {
    
      return result / documentSet.getDocumentsCount();
      
    } else {
    
      return 0.0;
    }
  }

  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
