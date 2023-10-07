/*
 * ReferenceGroupManager.java
 *
 * Created on 13-mar-2011, 17:16:40
 */
package es.ugr.scimat.gui.components.manager;

import java.util.ArrayList;

import es.ugr.scimat.gui.commands.edit.delete.DeleteReferenceGroupEdit;
import es.ugr.scimat.gui.components.adddialog.AddDialogManager;
import es.ugr.scimat.gui.components.itemslist.ReferenceGroupsListPanel;
import es.ugr.scimat.gui.components.joindialog.JoinEntitiesDialogManager;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.globalslavepanel.ReferenceGroupGlobalSlavePanel;
import es.ugr.scimat.model.knowledgebase.entity.ReferenceGroup;

/**
 *
 * @author mjcobo
 */
public class ReferenceGroupManager extends GenericItemManagerPanel<ReferenceGroup> {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  public ReferenceGroupManager() {
    super(new ReferenceGroupsListPanel(),
          new ReferenceGroupGlobalSlavePanel());

    setMasterPanelTitle("Reference groups list");
    setSlavePanelTitle("Reference group detail");
  }

  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   *
   */
  @Override
  public void addAction() {
    AddDialogManager.getInstance().showAddReferenceGroupDialog();
  }

  /**
   *
   */
  @Override
  public void moveToAction(ArrayList<ReferenceGroup> items) {
    JoinEntitiesDialogManager.getInstance().showReferenceGroupsJoinDialog(items);
  }

  /**
   *
   */
  @Override
  public void removeAction(ArrayList<ReferenceGroup> items) {
    (new PerformKnowledgeBaseEditTask(new DeleteReferenceGroupEdit(items), this)).execute();
  }

  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
