/*
 * CallonDensity.java
 *
 * Created on 17-feb-2011, 17:56:54
 */
package es.ugr.scimat.api.analysis.network.statistics;

import es.ugr.scimat.api.dataset.NetworkPair;
import es.ugr.scimat.api.mapping.WholeNetwork;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class CallonDensity implements NetworkMeasure {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @param network
     * @param nodeList
     * @return
     */
    public double calculateMeasure(WholeNetwork network, ArrayList<Integer> nodeList) {

        int i;
        double sum;
        ArrayList<NetworkPair> pairs;

        sum = 0.0;
        pairs = network.getInternalPairs(nodeList);

        for (i = 0; i < pairs.size(); i++) {

            sum += pairs.get(i).getValue();

        }

        return 100 * (sum / nodeList.size());
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
