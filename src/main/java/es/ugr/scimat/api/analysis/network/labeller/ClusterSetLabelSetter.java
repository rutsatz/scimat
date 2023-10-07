/*
 * NodeLabelAssigner.java
 *
 * Created on 30-mar-2011, 17:44:44
 */
package es.ugr.scimat.api.analysis.network.labeller;

import es.ugr.scimat.api.mapping.clustering.result.Cluster;
import es.ugr.scimat.api.mapping.clustering.result.ClusterSet;
import es.ugr.scimat.api.utils.property.StringProperty;

/**
 *
 * @author mjcobo
 */
public class ClusterSetLabelSetter {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  /**
   * 
   */
  private ClusterLabeller labeller;

  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  public ClusterSetLabelSetter(ClusterLabeller labeller) {
    this.labeller = labeller;
  }

  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   * 
   * @param dataset
   * @param clusterSet
   * @param newPropertyKey
   */
  public void execute(ClusterSet clusterSet, String newPropertyKey) {

    int i;
    Cluster cluster;

    for (i = 0; i < clusterSet.getClustersCount(); i++) {

      cluster = clusterSet.getCluster(i);
      cluster.getProperties().addProperty(newPropertyKey,
              new StringProperty(this.labeller.execute(cluster)));
    }
  }

  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
