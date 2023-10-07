/*
 * NetworkMeasure.java
 *
 * Created on 17-feb-2011, 17:59:21
 */
package es.ugr.scimat.api.analysis.network.statistics;

import es.ugr.scimat.api.mapping.WholeNetwork;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public interface NetworkMeasure {

    /**
     * @param network
     * @param nodeList
     * @return
     */
    public double calculateMeasure(WholeNetwork network, ArrayList<Integer> nodeList);
}
