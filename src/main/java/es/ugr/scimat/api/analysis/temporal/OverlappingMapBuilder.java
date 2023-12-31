/*
 * OverlappingMapBuilder.java
 *
 * Created on 09-may-2011, 19:14:11
 */
package es.ugr.scimat.api.analysis.temporal;

import es.ugr.scimat.api.dataset.Dataset;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class OverlappingMapBuilder {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    private OverlappingMeasure measure;

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param measure
     */
    public OverlappingMapBuilder(OverlappingMeasure measure) {
        this.measure = measure;
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @param datasets
     * @return
     */
    public OverlappingMap buildOverlappingMap(ArrayList<Dataset> datasets) {

        int i;
        OverlappingMap overlappingMap = new OverlappingMap();

        for (i = 0; i < datasets.size(); i++) {

            overlappingMap.addItem(datasets.get(i).getItems(), this.measure);
        }

        return overlappingMap;
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
