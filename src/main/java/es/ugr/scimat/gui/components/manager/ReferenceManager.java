/*
 * ReferenceManager.java
 *
 * Created on 13-mar-2011, 17:16:46
 */
package es.ugr.scimat.gui.components.manager;

import java.util.ArrayList;

import es.ugr.scimat.gui.commands.edit.delete.DeleteReferenceEdit;
import es.ugr.scimat.gui.components.adddialog.AddDialogManager;
import es.ugr.scimat.gui.components.itemslist.ReferencesListPanel;
import es.ugr.scimat.gui.components.joindialog.JoinEntitiesDialogManager;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.globalslavepanel.ReferenceGlobalSlavePanel;
import es.ugr.scimat.model.knowledgebase.entity.Reference;

/**
 *
 * @author mjcobo
 */
public class ReferenceManager extends GenericItemManagerPanel<Reference> {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  public ReferenceManager() {
    super(new ReferencesListPanel(),
          new ReferenceGlobalSlavePanel());

    setMasterPanelTitle("References list");
    setSlavePanelTitle("Reference detail");
  }

  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   *
   */
  @Override
  public void addAction() {
    AddDialogManager.getInstance().showAddReferenceDialog();
  }

  /**
   *
   */
  @Override
  public void moveToAction(ArrayList<Reference> items) {
    JoinEntitiesDialogManager.getInstance().showReferencesJoinDialog(items);
  }

  /**
   *
   */
  @Override
  public void removeAction(ArrayList<Reference> items) {
    (new PerformKnowledgeBaseEditTask(new DeleteReferenceEdit(items), this)).execute();
  }

  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
