/*
 * MakeReportLaTeXTask.java
 *
 * Created on 06-jun-2011, 18:51:31
 */
package es.ugr.scimat.gui.commands.task;

import java.io.File;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import es.ugr.scimat.analysis.GlobalAnalysisResult;
import es.ugr.scimat.api.report.MakeReportLaTeX;
import es.ugr.scimat.gui.commands.NoUndoableTask;
import es.ugr.scimat.gui.components.ErrorDialogManager;
import es.ugr.scimat.gui.components.cursor.CursorManager;
import es.ugr.scimat.project.CurrentProject;

/**
 *
 * @author mjcobo
 */
public class MakeReportLaTeXTask implements NoUndoableTask {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/
  
  private JComponent component;
  
  private GlobalAnalysisResult globalExperimentResult;
  
  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/
  
  public MakeReportLaTeXTask(JComponent component, GlobalAnalysisResult globalExperimentResult) {
    this.component = component;
    this.globalExperimentResult = globalExperimentResult;
  }
  
  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/
  
  public void execute() {
    
    String path;
    int returnVal;

    JFileChooser fileChooser = new JFileChooser();

    fileChooser.setDialogTitle("Select a directory");
    fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    fileChooser.setMultiSelectionEnabled(false);
    
    if (CurrentProject.getInstance().getCurrentProjectPath() != null) {
    
      fileChooser.setCurrentDirectory(new File (CurrentProject.getInstance().getCurrentProjectPath()));
    }

    returnVal = fileChooser.showSaveDialog(this.component);

    if (returnVal == JFileChooser.APPROVE_OPTION) {

      path = fileChooser.getSelectedFile().getAbsolutePath();
      
      try {

        CursorManager.getInstance().setWaitCursor();
        (new MakeReportLaTeX(path, this.globalExperimentResult)).execute();
        CursorManager.getInstance().setNormalCursor();

      } catch (Exception e) {
    
        ErrorDialogManager.getInstance().showException(e);
      }
      
    }
  }
  
  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
