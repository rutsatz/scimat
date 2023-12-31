/*
 * MinCitationAggregationMeasure.java
 *
 * Created on 21-feb-2011, 12:30:16
 */
package es.ugr.scimat.api.analysis.performance.quality;

import es.ugr.scimat.api.analysis.performance.DocumentAggregationMeasure;
import es.ugr.scimat.api.analysis.performance.docmapper.DocumentSet;
import es.ugr.scimat.api.dataset.Dataset;
import es.ugr.scimat.api.dataset.exception.NotExistsItemException;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class MinCitationAggregationMeasure implements DocumentAggregationMeasure {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    private Dataset dataset;

    /***************************************************************************/
    /*                            Constructors                                 */

    /***************************************************************************/

    public MinCitationAggregationMeasure(Dataset dataset) {
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

        int i;
        double min, tmp;
        ArrayList<Integer> docsList;

        min = 0.0;
        docsList = documentSet.getDocuments();

        if (docsList.size() > 0) {

            min = dataset.getDocumentCitations(docsList.get(0));

            for (i = 1; i < docsList.size(); i++) {

                tmp = dataset.getDocumentCitations(docsList.get(i));

                if (min > tmp) {

                    min = tmp;
                }
            }
        }

        return min;
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
