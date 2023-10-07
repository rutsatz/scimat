/*
 * ReferenceSourceManager.java
 *
 * Created on 13-mar-2011, 17:17:19
 */
package es.ugr.scimat.gui.components.manager;

import java.util.ArrayList;

import es.ugr.scimat.gui.commands.edit.delete.DeleteReferenceSourceEdit;
import es.ugr.scimat.gui.components.adddialog.AddDialogManager;
import es.ugr.scimat.gui.components.itemslist.ReferenceSourcesListPanel;
import es.ugr.scimat.gui.components.joindialog.JoinEntitiesDialogManager;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.globalslavepanel.ReferenceSourceGlobalSlavePanel;
import es.ugr.scimat.model.knowledgebase.entity.ReferenceSource;

/**
 *
 * @author mjcobo
 */
public class ReferenceSourceManager extends GenericItemManagerPanel<ReferenceSource> {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  public ReferenceSourceManager() {
    super(new ReferenceSourcesListPanel(),
          new ReferenceSourceGlobalSlavePanel());

    setMasterPanelTitle("Sources-reference list");
    setSlavePanelTitle("Sources-reference detail");
  }

  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   *
   */
  @Override
  public void addAction() {
    AddDialogManager.getInstance().showAddReferenceSourceDialog();
  }

  /**
   *
   */
  @Override
  public void moveToAction(ArrayList<ReferenceSource> items) {
    JoinEntitiesDialogManager.getInstance().showReferenceSourcesJoinDialog(items);
  }

  /**
   *
   */
  @Override
  public void removeAction(ArrayList<ReferenceSource> items) {
    (new PerformKnowledgeBaseEditTask(new DeleteReferenceSourceEdit(items), this)).execute();
  }

  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
