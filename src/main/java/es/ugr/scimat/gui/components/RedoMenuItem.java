/*
 * RedoMenuItem.java
 *
 * Created on 15-abr-2008
 */

package es.ugr.scimat.gui.components;

import es.ugr.scimat.gui.undostack.UndoStack;
import es.ugr.scimat.gui.undostack.UndoStackChangeObserver;

import javax.swing.*;

/**
 * @author Manuel Jesus Cobo Martin
 */
public class RedoMenuItem extends JMenuItem implements UndoStackChangeObserver {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * Crea una instancia de RedoMenuItem por defecto.
     */
    public RedoMenuItem() {
        super("Redo");

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
