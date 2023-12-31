/*
 * ClusterSetDocumentsSetter.java
 *
 * Created on 30-mar-2011, 20:29:10
 */
package es.ugr.scimat.api.analysis.performance.docmapper;

import es.ugr.scimat.api.mapping.clustering.result.Cluster;
import es.ugr.scimat.api.mapping.clustering.result.ClusterSet;
import es.ugr.scimat.api.utils.property.DocumentsProperty;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class ClusterSetDocumentsSetter {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /**
     *
     */
    private DocumentMapper documentMapper;

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param documentMapper
     */
    public ClusterSetDocumentsSetter(DocumentMapper documentMapper) {
        this.documentMapper = documentMapper;
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
                    new DocumentsProperty(this.documentMapper.executeMapper(cluster.getNodes())));
        }
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
