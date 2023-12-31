/*
 * EdgeAggregation.java
 *
 * Created on 24-feb-2011, 0:57:19
 */
package es.ugr.scimat.api.analysis.network.aggregation;

import es.ugr.scimat.api.dataset.NetworkPair;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public interface EdgeAggregation {

    /**
     * @param pairs
     * @return
     */
    public double aggregate(ArrayList<NetworkPair> pairs);
}
