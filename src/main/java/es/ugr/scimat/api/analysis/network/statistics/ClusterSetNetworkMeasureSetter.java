/*
 * ClusterSetDocumentsSetter.java
 *
 * Created on 30-mar-2011, 20:29:10
 */
package es.ugr.scimat.api.analysis.network.statistics;

import java.util.ArrayList;

import es.ugr.scimat.api.mapping.clustering.result.Cluster;
import es.ugr.scimat.api.mapping.clustering.result.ClusterSet;
import es.ugr.scimat.api.utils.property.DoubleProperty;

/**
 *
 * @author mjcobo
 */
public class ClusterSetNetworkMeasureSetter {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  /**
   * 
   */
  private NetworkMeasure networkMeasure;

  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  /**
   * 
   * @param networkMeasure
   */
  public ClusterSetNetworkMeasureSetter(NetworkMeasure networkMeasure) {
    this.networkMeasure = networkMeasure;
  }

  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  public void execute(ClusterSet clusterSet, String newProperty) {

    int i;
    ArrayList<Cluster> clusterList;
    Cluster cluster;

    clusterList = clusterSet.getClusters();

    for (i = 0; i < clusterList.size(); i++) {

      cluster = clusterList.get(i);

      cluster.getProperties().addProperty(newProperty,
              new DoubleProperty(this.networkMeasure.calculateMeasure(clusterSet.getWholeNetwork(),
              cluster.getNodes())));
    }
  }

  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
