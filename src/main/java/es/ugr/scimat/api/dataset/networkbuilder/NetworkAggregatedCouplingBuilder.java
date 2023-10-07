/*
 * NetworkCouplingBuilder.java
 *
 * Created on 11-feb-2011, 13:52:18
 */
package es.ugr.scimat.api.dataset.networkbuilder;

import es.ugr.scimat.api.dataset.AggregatedDataset;
import es.ugr.scimat.api.dataset.UndirectNetworkMatrix;
import es.ugr.scimat.api.dataset.exception.NotExistsItemException;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * This class build a network from a dataset using the coupling of the
 * items in each doc.
 *
 * @author mjcobo
 */
public class NetworkAggregatedCouplingBuilder implements NetworkBuilder {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    private AggregatedDataset aggregatedDataset;

    /***************************************************************************/
    /*                            Constructors                                 */

    /***************************************************************************/

    public NetworkAggregatedCouplingBuilder(AggregatedDataset aggregatedDataset) {

        this.aggregatedDataset = aggregatedDataset;
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * Build he network.
     *
     * @param aggregatedDataset The dataset used to extract the coupling values.
     * @return a network based on coupling data.
     */
    public UndirectNetworkMatrix execute() throws NotExistsItemException {

        int i, j;
        ArrayList<Integer> highLevelItems;
        TreeSet<Integer> items, tmp;

        UndirectNetworkMatrix network;

        highLevelItems = this.aggregatedDataset.getHighLevelItems();

        network = new UndirectNetworkMatrix(highLevelItems);

        for (i = 0; i < highLevelItems.size(); i++) {

            items = getAggregatedItems(highLevelItems.get(i));
            tmp = new TreeSet<Integer>();

            for (j = i + 1; j < highLevelItems.size(); j++) {

                tmp = getAggregatedItems(highLevelItems.get(j));

                tmp.retainAll(items);

                network.addEdge(highLevelItems.get(i), highLevelItems.get(j), tmp.size());
            }
        }

        return network;
    }

    /***************************************************************************/
    /*                           Private Methods                               */

    /***************************************************************************/

    private TreeSet<Integer> getAggregatedItems(Integer highLevelItem) {

        int j;
        ArrayList<Integer> docs;
        TreeSet<Integer> items;

        docs = this.aggregatedDataset.getDocumentsInHighLevelItem(highLevelItem);
        items = new TreeSet<Integer>();

        for (j = 0; j < docs.size(); j++) {

            items.addAll(this.aggregatedDataset.getItemsInDocument(docs.get(j)));
        }

        return items;
    }
}
