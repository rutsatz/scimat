/*
 * UpgradeKnowledgeBaseTask.java
 *
 * Created on 26-ene-2012, 19:59:24
 */
package es.ugr.scimat.gui.commands.task;

import es.ugr.scimat.gui.commands.NoUndoableTask;
import es.ugr.scimat.gui.components.ErrorDialogManager;
import es.ugr.scimat.gui.components.cursor.CursorManager;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.model.upgrade.UpgradeKnowledgeBaseVersion;
import es.ugr.scimat.project.CurrentProject;

import javax.swing.*;
import java.io.File;

/**
 * @author mjcobo
 */
public class UpgradeKnowledgeBaseTask implements NoUndoableTask {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    private String oldKnowledgeBasePath;
    private String newKnowledgeBaseFolderPath;
    private String newKnowledgeBaseFile;

    /**
     *
     */
    private JComponent receiver;

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param oldKnowledgeBasePath
     * @param newKnowledgeBaseFolderPath
     * @param newKnowledgeBaseFile
     * @param receiver
     */
    public UpgradeKnowledgeBaseTask(String oldKnowledgeBasePath,
                                    String newKnowledgeBaseFolderPath, String newKnowledgeBaseFile,
                                    JComponent receiver) {

        this.oldKnowledgeBasePath = oldKnowledgeBasePath;
        this.newKnowledgeBaseFolderPath = newKnowledgeBaseFolderPath;
        this.newKnowledgeBaseFile = newKnowledgeBaseFile;
        this.receiver = receiver;
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     *
     */
    public void execute() {

        File file;
        String fullPath;
        int returnVal;
        boolean flag = true;

        fullPath = this.newKnowledgeBaseFolderPath + File.separator + this.newKnowledgeBaseFile;

        file = new File(fullPath);

        if (file.exists()) {

            returnVal = JOptionPane.showConfirmDialog(this.receiver, "The file already exist. "
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

                (new UpgradeKnowledgeBaseVersion(fullPath, this.oldKnowledgeBasePath)).execute();
                CurrentProject.getInstance().loadProyect(fullPath);
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
