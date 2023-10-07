/*
 * SaveExperimentTask.java
 *
 * Created on 06-apr-2011
 */

package es.ugr.scimat.gui.commands.task;

import es.ugr.scimat.analysis.CurrentAnalysis;
import es.ugr.scimat.gui.commands.NoUndoableTask;
import es.ugr.scimat.gui.components.cursor.CursorManager;
import es.ugr.scimat.project.CurrentProject;

import javax.swing.*;
import java.io.File;

/**
 * @author Manuel Jesus Cobo Martin.
 */
public class SaveAnalysisTask implements NoUndoableTask {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    private JComponent receiver;

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param component
     */
    public SaveAnalysisTask(JComponent component) {
        this.receiver = component;
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * Tarea a realizar por el objeto.
     */
    public void execute() {

        String path;

        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setCurrentDirectory(new File(CurrentProject.getInstance().getCurrentProjectPath()));
        fileChooser.setMultiSelectionEnabled(false);

        int returnVal = fileChooser.showSaveDialog(this.receiver);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            path = fileChooser.getSelectedFile().getAbsolutePath();

            CursorManager.getInstance().setWaitCursor();

            try {

                CurrentAnalysis.getInstance().saveResults(path);

            } catch (Exception e) {


                e.printStackTrace(System.err);

                JOptionPane.showMessageDialog(receiver, "The file's format is "
                                + "incorrect.\nAn error happened.\n"
                                + "Please choose other file.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }

            CursorManager.getInstance().setNormalCursor();
        }
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/

}
