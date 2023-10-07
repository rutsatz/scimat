/*
 * RedoToolBarButton.java
 *
 * Created on 08-oct-2008
 */

package es.ugr.scimat.gui.components;

import es.ugr.scimat.gui.undostack.UndoStack;
import es.ugr.scimat.gui.undostack.UndoStackChangeObserver;

import javax.swing.*;

/**
 * @author Manuel Jesus Cobo Martin.
 */
public class RedoToolBarButton extends JButton implements UndoStackChangeObserver {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /***************************************************************************/
    /*                            Constructors                                 */

    /***************************************************************************/

    public RedoToolBarButton() {

        setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit-redo24x24.png")));
        setFocusable(false);
        setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        UndoStack.addUndoStackChangeObserver(this);
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @param canUndo
     * @param canRedo
     */
    public void undoStackChanged(boolean canUndo, boolean canRedo) {
        setEnabled(canRedo);
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/

}
