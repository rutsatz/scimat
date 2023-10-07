/*
 * ClusterLabeller.java
 *
 * Created on 30-mar-2011, 16:59:09
 */
package es.ugr.scimat.api.analysis.network.labeller;

import es.ugr.scimat.api.mapping.clustering.result.Cluster;

/**
 * @author mjcobo
 */
public interface ClusterLabeller {

    public String execute(Cluster cluster);
}
