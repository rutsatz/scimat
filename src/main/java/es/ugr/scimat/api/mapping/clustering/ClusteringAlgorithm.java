/*
 * ClusteringAlgorithm.java
 *
 * Created on 15-feb-2011, 18:52:14
 */
package es.ugr.scimat.api.mapping.clustering;

import es.ugr.scimat.api.dataset.UndirectNetworkMatrix;
import es.ugr.scimat.api.mapping.clustering.result.ClusterSet;

/**
 * @author mjcobo
 */
public interface ClusteringAlgorithm {

    /**
     * @param network
     * @return
     */
    public ClusterSet execute(UndirectNetworkMatrix network);
}
