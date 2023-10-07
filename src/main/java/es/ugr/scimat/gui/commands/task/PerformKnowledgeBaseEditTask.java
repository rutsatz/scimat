/*
 * PerformKnowledgeBaseEditTask.java
 *
 * Created on 16-mar-2011, 22:05:26
 */
package es.ugr.scimat.gui.commands.task;

import javax.swing.JComponent;

import es.ugr.scimat.gui.commands.edit.KnowledgeBaseEdit;
import es.ugr.scimat.gui.components.ErrorDialogManager;
import es.ugr.scimat.gui.components.cursor.CursorManager;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;

/**
 *
 * @author mjcobo
 */
public class PerformKnowledgeBaseEditTask {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  /**
   * 
   */
  private KnowledgeBaseEdit edit;
  private JComponent component;

  private boolean successful;


  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  /**
   * 
   * @param edit
   * @param compenent
   */
  public PerformKnowledgeBaseEditTask(KnowledgeBaseEdit edit, JComponent compenent) {

    this.edit = edit;
    this.component = compenent;
    this.successful = false;
  }

  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   * 
   */
  public void execute() {

    try {
      
      CursorManager.getInstance().setWaitCursor();
      this.successful = this.edit.execute();
      CursorManager.getInstance().setNormalCursor();

      if (! this.successful) {

        ErrorDialogManager.getInstance().showError(edit.getErrorMessage());
      }

    } catch (KnowledgeBaseException e) {

      this.successful = false;

      ErrorDialogManager.getInstance().showException(e);

      e.printStackTrace(System.err);

    }
  }

  /**
   * 
   * @return
   */
  public boolean isSuccessful() {
    return successful;
  }

  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
