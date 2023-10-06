/*
 * BasicClusterLabellerBasedOnMainNode.java
 *
 * Created on 30-mar-2011, 17:01:53
 */
package scimat.api.analysis.network.labeller;

import scimat.api.dataset.Dataset;
import scimat.api.mapping.clustering.result.Cluster;

/**
 *
 * @author mjcobo
 */
public class BasicClusterLabellerBasedOnMainNode implements ClusterLabeller {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  private Dataset dataset;

  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  /**
   * 
   * @param dataset
   */
  public BasicClusterLabellerBasedOnMainNode(Dataset dataset) {
    this.dataset = dataset;
  }

  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   * 
   * @param cluster
   * @return
   */
  public String execute(Cluster cluster) {

    String label;
    Integer mainNode;

    label = "";

    mainNode = cluster.getMainNode();

    if (mainNode != null) {

      label = this.dataset.getItemLabel(mainNode);
      
    }

    return label;
  }

  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
