/*
 * NewProjectTask.java
 *
 * Created on 28-mar-2011, 19:15:03
 */
package es.ugr.scimat.gui.commands.task;

import es.ugr.scimat.gui.commands.NoUndoableTask;
import es.ugr.scimat.gui.components.ErrorDialogManager;
import es.ugr.scimat.gui.components.cursor.CursorManager;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

import javax.swing.*;
import java.io.File;

/**
 * @author mjcobo
 */
public class NewProjectTask implements NoUndoableTask {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    private String folderPath;
    private String filePath;
    private JComponent component;

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param component
     */
    public NewProjectTask(String folderPath, String filePath, JComponent component) {

        this.folderPath = folderPath;
        this.filePath = filePath;
        this.component = component;
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     *
     */
    public void execute() {

        File file;
        int returnVal;
        boolean flag = true;

        file = new File(this.filePath);

        if (file.exists()) {

            returnVal = JOptionPane.showConfirmDialog(this.component, "The file already exist. "
                            + "Would you like to override it?", "Existing file",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

            if (returnVal == JOptionPane.OK_OPTION) {

                flag = true;

            } else {

                flag = false;
            }
        }

        if (flag) {

            try {

                CursorManager.getInstance().setWaitCursor();
                CurrentProject.getInstance().newProyect(this.folderPath, this.filePath);
                CursorManager.getInstance().setNormalCursor();

            } catch (KnowledgeBaseException e) {

                ErrorDialogManager.getInstance().showException(e);
            }
        }

    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
