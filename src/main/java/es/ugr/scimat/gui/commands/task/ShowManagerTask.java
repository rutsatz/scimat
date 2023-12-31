/*
 * ShowManagerTask.java
 *
 * Created on 10-mar-2011, 18:55:45
 */
package es.ugr.scimat.gui.commands.task;

import es.ugr.scimat.gui.commands.NoUndoableTask;

import javax.swing.*;

/**
 * This class implement an undoable task. It deals with the visualization of a
 * panel (particularly a manager panel) in the main frame.
 * <p>
 * When the {@code execute()} method is called, the task remove all the elements
 * from the receiver, and add the new panel.
 *
 * @author mjcobo
 */
public class ShowManagerTask implements NoUndoableTask {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /**
     * The component where the panel will be added
     */
    private JComponent receiver;

    /**
     * The panel to add.
     */
    private JPanel panel;

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * Contructs a new {@link ShowManagerTask}.
     *
     * @param receiver The component where the panel will be added
     * @param panel    The panel to add
     */
    public ShowManagerTask(JComponent receiver, JPanel panel) {
        this.receiver = receiver;
        this.panel = panel;
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     *
     */
    public void execute() {

        this.receiver.removeAll();
        this.receiver.add(this.panel);
        this.receiver.validate();
        this.receiver.repaint();
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
