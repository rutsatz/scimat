/*
 * InterimResultTaskObserver.java
 *
 * Created on 30-ene-2008
 */

package es.ugr.scimat.observabletask;

/**
 * @author MJCobo
 */
public interface InterimResultTaskObserver<V> {

    /**
     * @param iterimResult
     */
    public void interimResultChanged(V iterimResult);
}
