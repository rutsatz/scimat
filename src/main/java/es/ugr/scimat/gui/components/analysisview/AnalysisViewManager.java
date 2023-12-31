/*
 * AddDialogManager.java
 *
 * Created on 18-mar-2011, 13:56:42
 */
package es.ugr.scimat.gui.components.analysisview;

import es.ugr.scimat.gui.components.ErrorDialogManager;
import es.ugr.scimat.gui.components.cursor.CursorManager;

import javax.swing.*;
import java.awt.*;

/**
 * @author mjcobo
 */
public class AnalysisViewManager {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    private AnalysisViewDialog analysisViewDialog;

    /***************************************************************************/
    /*                            Constructors                                 */

    /***************************************************************************/

    private AnalysisViewManager() {
    }

    /***************************************************************************/
    /*                           Public Methods                                */

    /***************************************************************************/

    public static AnalysisViewManager getInstance() {
        return ExperimentViewManagerHolder.INSTANCE;
    }

    private static class ExperimentViewManagerHolder {

        private static final AnalysisViewManager INSTANCE = new AnalysisViewManager();
    }

    /**
     * @param frame
     */
    public void init(JFrame frame) {

        this.analysisViewDialog = new AnalysisViewDialog(frame, true);
    }

    /**
     *
     */
    public void showAnalysisViewDialog() {

        Window oldWindow = CursorManager.getInstance().getWindow();

        CursorManager.getInstance().init(this.analysisViewDialog);
        ErrorDialogManager.getInstance().init(this.analysisViewDialog);

        this.analysisViewDialog.refresh();
        this.analysisViewDialog.setVisible(true);

        CursorManager.getInstance().init(oldWindow);
        ErrorDialogManager.getInstance().init(oldWindow);
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
