/*
 * FilterByEdgeValue.java
 *
 * Created on 14-feb-2011, 18:34:07
 */
package es.ugr.scimat.api.preprocessing.reduction.network;

import es.ugr.scimat.api.dataset.NetworkPair;
import es.ugr.scimat.api.dataset.UndirectNetworkMatrix;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class FilterByEdgeValue implements NetworkFilter {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    private double minValue;

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param minValue
     */
    public FilterByEdgeValue(double minValue) {
        this.minValue = minValue;
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @param network
     */
    public void execute(UndirectNetworkMatrix network) {

        int i;
        ArrayList<NetworkPair> pairs;
        NetworkPair pair;

        pairs = network.getNetworkPairs();

        for (i = 0; i < pairs.size(); i++) {

            pair = pairs.get(i);

            if (pair.getValue() < this.minValue) {

                network.removeEdge(pair.getID().getElementA(), pair.getID().getElementB());
            }
        }
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
