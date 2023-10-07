/*
 * ProgressTaskObserver.java
 *
 * Created on 30-ene-2008
 */

package es.ugr.scimat.observabletask;

/**
 * @author MJCobo
 */
public interface ProgressTaskObserver {

    /**
     * @param determinateMode
     * @param value
     */
    public void progressChanged(boolean determinateMode, int value);
}
