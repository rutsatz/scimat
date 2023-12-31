/*
 * GenericOneSlaveItemPanel.java
 *
 * Created on 26-may-2011, 20:29:07
 */
package es.ugr.scimat.gui.components.slavepanel;

import es.ugr.scimat.gui.components.observer.SlaveItemObserver;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class GenericOneSlaveItemPanel extends JPanel {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /**
     *
     */
    private ArrayList<SlaveItemObserver> slaveItemObservers;

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     *
     */
    public GenericOneSlaveItemPanel() {

        this.slaveItemObservers = new ArrayList<SlaveItemObserver>();
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     *
     */
    public void addSlaveItemObserver(SlaveItemObserver o) {

        this.slaveItemObservers.add(o);
    }

    /**
     *
     */
    public void fireSlaveItemObserver(boolean inNoNull) {

        int i;

        for (i = 0; i < this.slaveItemObservers.size(); i++) {

            this.slaveItemObservers.get(i).slaveItemChanged(inNoNull);
        }
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
