/*
 * WholeNetworkAggregationDocumentsMeasureSetter.java
 *
 * Created on 30-mar-2011, 20:29:10
 */
package es.ugr.scimat.api.analysis.performance;

import es.ugr.scimat.api.dataset.Dataset;
import es.ugr.scimat.api.mapping.Node;
import es.ugr.scimat.api.mapping.WholeNetwork;
import es.ugr.scimat.api.utils.property.DocumentsProperty;
import es.ugr.scimat.api.utils.property.DoubleProperty;
import es.ugr.scimat.api.utils.property.Property;
import es.ugr.scimat.api.utils.property.PropertyTypes;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class WholeNetworkAggregationDocumentsMeasureSetter {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /**
     *
     */
    private DocumentAggregationMeasure documentAggregationMeasure;

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param documentAggregationMeasure
     */
    public WholeNetworkAggregationDocumentsMeasureSetter(DocumentAggregationMeasure documentAggregationMeasure) {
        this.documentAggregationMeasure = documentAggregationMeasure;
    }

    /***************************************************************************/
    /*                           Public Methods                                */

    /***************************************************************************/

    public boolean execute(Dataset dataset, WholeNetwork wholeNetwork, final String propertyKey,
                           final String newProperty) {

        int i;
        ArrayList<Node> nodes;
        Node node;
        Property property;
        DocumentsProperty documentsProperty;
        boolean flag;

        nodes = wholeNetwork.getNodes();
        flag = true;

        // Check if all clusters have the propertyKey and if the type of this
        // property is Double. Moreover, check if the cluster d
        for (i = 0; i < nodes.size(); i++) {

            property = nodes.get(i).getProperties().getProperty(propertyKey);

            if ((property == null) || (!property.getType().equals(PropertyTypes.DocumentsProperty))) {

                flag = false;
            }
        }

        if (flag) {

            for (i = 0; i < nodes.size(); i++) {

                node = nodes.get(i);
                documentsProperty = (DocumentsProperty) node.getProperties().getProperty(propertyKey);

                node.getProperties().addProperty(newProperty,
                        new DoubleProperty(this.documentAggregationMeasure.calculateMeasure(documentsProperty.getValue())));
            }

            flag = true;
        }

        return flag;
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
