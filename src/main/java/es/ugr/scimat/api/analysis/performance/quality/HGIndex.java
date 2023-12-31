/*
 * HGIndex.java
 *
 * Created on 18-may-2011, 12:49:21
 */
package es.ugr.scimat.api.analysis.performance.quality;

import es.ugr.scimat.api.analysis.performance.DocumentAggregationMeasure;
import es.ugr.scimat.api.analysis.performance.docmapper.DocumentSet;
import es.ugr.scimat.api.dataset.Dataset;
import es.ugr.scimat.api.dataset.exception.NotExistsItemException;

/**
 * @author mjcobo
 */
public class HGIndex implements DocumentAggregationMeasure {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    private Dataset dataset;

    /***************************************************************************/
    /*                            Constructors                                 */

    /***************************************************************************/

    public HGIndex(Dataset dataset) {
        this.dataset = dataset;
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @param docsList
     * @return
     * @throws NotExistsItemException if a doc is not present in the dataset.
     */
    public double calculateMeasure(DocumentSet documentSet) {

        HIndex hIndex = new HIndex(dataset);
        GIndex gIndex = new GIndex(dataset);

        return Math.sqrt(hIndex.calculateMeasure(documentSet) * gIndex.calculateMeasure(documentSet));
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
