/*
 * LoadExperimentTask.java
 *
 * Created on 06-apr-2011
 */

package es.ugr.scimat.gui.commands.task;

import es.ugr.scimat.analysis.CurrentAnalysis;
import es.ugr.scimat.gui.commands.NoUndoableTask;
import es.ugr.scimat.gui.components.analysisview.AnalysisViewManager;
import es.ugr.scimat.gui.components.cursor.CursorManager;
import es.ugr.scimat.project.CurrentProject;

import javax.swing.*;
import java.io.File;

/**
 * @author Manuel Jesus Cobo Martin.
 */
public class LoadAnalysisTask implements NoUndoableTask {

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
    public LoadAnalysisTask(JComponent component) {
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
        fileChooser.setMultiSelectionEnabled(false);

        if (CurrentProject.getInstance().isKnowledbaseLoaded()) {

            fileChooser.setCurrentDirectory(new File(CurrentProject.getInstance().getCurrentProjectPath()));
        }

        int returnVal = fileChooser.showOpenDialog(this.receiver);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            path = fileChooser.getSelectedFile().getAbsolutePath();

            try {

                CursorManager.getInstance().setWaitCursor();
                CurrentAnalysis.getInstance().loadResults(path);
                CursorManager.getInstance().setNormalCursor();

            } catch (Exception e) {

                CursorManager.getInstance().setNormalCursor();
                e.printStackTrace(System.err);

                JOptionPane.showMessageDialog(receiver, "The file's format is "
                                + "incorrect.\nAn error happened.\n"
                                + "Please choose other file.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }

            AnalysisViewManager.getInstance().showAnalysisViewDialog();
        }
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/

}
