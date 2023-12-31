/*
 * CalculateNormalizedRange.java
 *
 * Created on 17-feb-2011, 20:51:26
 */
package es.ugr.scimat.api.analysis.network.statistics;

import es.ugr.scimat.api.mapping.clustering.result.Cluster;
import es.ugr.scimat.api.mapping.clustering.result.ClusterSet;
import es.ugr.scimat.api.utils.property.DoubleProperty;
import es.ugr.scimat.api.utils.property.Property;
import es.ugr.scimat.api.utils.property.PropertyTypes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author mjcobo
 */
public class CalculateNormalizedRange implements ClusterDeriveMeasure {

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
     * Calculate a measure for all the cluster taking into account the value of
     * a specific property of all the cluster.
     *
     * @param clusterSet  The cluster set
     * @param propertyKey The property's key used to derive the new measure
     * @param newProperty The new property's key where the new measure is located in each cluster.
     */
    public boolean calculateMeasures(ClusterSet clusterSet, final String propertyKey,
                                     final String newProperty) {

        int i;
        ArrayList<Cluster> clusterList;
        Property property;
        boolean flag;

        clusterList = clusterSet.getClusters();
        flag = true;

        // Check if all clusters have the propertyKey and if the type of this
        // property is Double. Moreover, check if the cluster d
        for (i = 0; i < clusterList.size(); i++) {

            property = clusterList.get(i).getProperties().getProperty(propertyKey);

            if ((property == null) || (!property.getType().equals(PropertyTypes.Double))) {

                flag = false;
            }
        }

        if (flag) {

            Collections.sort(clusterList, new Comparator<Cluster>() {

                public int compare(Cluster o1, Cluster o2) {

                    return Double.compare(((DoubleProperty) o1.getProperties().getProperty(propertyKey)).getValue(),
                            ((DoubleProperty) o2.getProperties().getProperty(propertyKey)).getValue());
                }
            });

            for (i = 0; i < clusterList.size(); i++) {

                clusterList.get(i).getProperties().addProperty(newProperty,
                        new DoubleProperty((1.0 + i) / clusterList.size()));
            }

            flag = true;
        }

        return flag;
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
