/*
 * MaxEdgeAggregation.java
 *
 * Created on 24-feb-2011, 0:57:50
 */
package es.ugr.scimat.api.analysis.network.aggregation;

import es.ugr.scimat.api.dataset.NetworkPair;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class MaxEdgeAggregation implements EdgeAggregation {

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
     * @param pairs
     * @return
     */
    public double aggregate(ArrayList<NetworkPair> pairs) {

        int i;
        double max, tmp;

        max = 0.0;

        if (pairs.size() > 0) {

            max = pairs.get(0).getValue();

            for (i = 1; i < pairs.size(); i++) {

                tmp = pairs.get(i).getValue();

                if (max < tmp) {

                    max = tmp;
                }
            }
        }

        return max;
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
