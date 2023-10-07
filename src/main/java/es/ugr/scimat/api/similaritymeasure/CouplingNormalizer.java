/*
 * CoOccurrenceNormalizer.java
 *
 * Created on 14-feb-2011, 23:47:57
 */
package es.ugr.scimat.api.similaritymeasure;

import es.ugr.scimat.api.dataset.AggregatedDataset;
import es.ugr.scimat.api.dataset.Dataset;
import es.ugr.scimat.api.dataset.NetworkPair;
import es.ugr.scimat.api.dataset.UndirectNetworkMatrix;
import es.ugr.scimat.api.dataset.exception.NotExistsItemException;
import es.ugr.scimat.api.similaritymeasure.direct.DirectSimilarityMeasure;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class CouplingNormalizer implements Normalizer {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /**
     *
     */
    private DirectSimilarityMeasure measure;

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param measure
     */
    public CouplingNormalizer(DirectSimilarityMeasure measure) {
        this.measure = measure;
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @param dataset
     * @param network
     * @throws NotExistsItemException
     */
    public void execute(Dataset dataset, UndirectNetworkMatrix network)
            throws NotExistsItemException {

        int i;
        double normalizedValue;
        ArrayList<NetworkPair> pairs;
        NetworkPair pair;
        AggregatedDataset aggregatedDataset;

        pairs = network.getNetworkPairs();

        for (i = 0; i < pairs.size(); i++) {

            pair = pairs.get(i);

            if (dataset instanceof AggregatedDataset) {

                aggregatedDataset = (AggregatedDataset) dataset;

                normalizedValue = this.measure.calculateMeasure(aggregatedDataset.getDocumentsInHighLevelItemCount(pair.getID().getElementA()),
                        aggregatedDataset.getDocumentsInHighLevelItemCount(pair.getID().getElementB()),
                        pair.getValue());

            } else {

                normalizedValue = this.measure.calculateMeasure(dataset.getDocumentFrequency(pair.getID().getElementA()),
                        dataset.getDocumentFrequency(pair.getID().getElementB()),
                        pair.getValue());
            }

            network.addEdge(pair.getID().getElementA(), pair.getID().getElementB(), normalizedValue);
        }

    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
