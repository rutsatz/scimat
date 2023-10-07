/*
 * SlaveItemObserverButton.java
 *
 * Created on 26-may-2011, 20:39:13
 */
package es.ugr.scimat.gui.components;

import es.ugr.scimat.gui.components.observer.SlaveItemObserver;

import javax.swing.*;

/**
 * @author mjcobo
 */
public class SlaveItemObserverButton extends JButton implements SlaveItemObserver {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/
    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     *
     */
    public SlaveItemObserverButton() {
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     *
     */
    public void slaveItemChanged(boolean isNotNull) {
        setEnabled(isNotNull);
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
