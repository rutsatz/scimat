/*
 * LongitudinalResult.java
 *
 * Created on 09-may-2011, 13:18:42
 */
package es.ugr.scimat.analysis;

import es.ugr.scimat.api.analysis.temporal.EvolutionMap;
import es.ugr.scimat.api.analysis.temporal.OverlappingMap;

import java.io.Serializable;

/**
 * @author mjcobo
 */
public class LongitudinalResult implements Serializable {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    private EvolutionMap evolutionMap;
    private OverlappingMap overlappingMap;

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param evolutionMap
     * @param overlappingMap
     */
    public LongitudinalResult(EvolutionMap evolutionMap, OverlappingMap overlappingMap) {
        this.evolutionMap = evolutionMap;
        this.overlappingMap = overlappingMap;
    }

    /***************************************************************************/
    /*                           Public Methods                                */

    /***************************************************************************/

    public EvolutionMap getEvolutionMap() {
        return evolutionMap;
    }

    public OverlappingMap getOverlappingMap() {
        return overlappingMap;
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
