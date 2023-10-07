/*
 * JaccardIndexMeasure.java
 *
 * Created on 14-feb-2011, 20:07:13
 */
package es.ugr.scimat.api.similaritymeasure.direct;

/**
 * @author mjcobo
 */
public class JaccardIndexMeasure implements DirectSimilarityMeasure {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /***************************************************************************/
    /*                           Public Methods                                */

    /***************************************************************************/

    public double calculateMeasure(int frequencyNodeI, int frequencyNodeJ, double coOccurrenceIJ) {

        return coOccurrenceIJ / (frequencyNodeI + frequencyNodeJ - coOccurrenceIJ);
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
