/*
 * NewProjectTask.java
 *
 * Created on 28-mar-2011, 19:15:03
 */
package es.ugr.scimat.gui.commands.task;

import es.ugr.scimat.gui.MainFrame;
import es.ugr.scimat.gui.commands.NoUndoableTask;
import es.ugr.scimat.gui.components.ErrorDialogManager;
import es.ugr.scimat.gui.components.cursor.CursorManager;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

import javax.swing.*;

/**
 * @author mjcobo
 */
public class CloseProjectTask implements NoUndoableTask {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    private MainFrame mainFrame;

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param mainFrame
     */
    public CloseProjectTask(MainFrame mainFrame) {

        this.mainFrame = mainFrame;
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     *
     */
    public void execute() {

        int returnVal;

        returnVal = JOptionPane.showConfirmDialog(this.mainFrame,
                "Do you want to close the project?", "Close project",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (returnVal == JOptionPane.OK_OPTION) {

            try {

                CursorManager.getInstance().setWaitCursor();
                CurrentProject.getInstance().close();
                CursorManager.getInstance().setNormalCursor();

                this.mainFrame.clearMainPanel();

            } catch (KnowledgeBaseException e) {

                ErrorDialogManager.getInstance().showException(e);

            }
        }

    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
