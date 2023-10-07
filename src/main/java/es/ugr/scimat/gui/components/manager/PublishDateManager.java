/*
 * PublishDateManager.java
 *
 * Created on 13-mar-2011, 17:16:08
 */
package es.ugr.scimat.gui.components.manager;

import java.util.ArrayList;

import es.ugr.scimat.gui.commands.edit.delete.DeletePublishDateEdit;
import es.ugr.scimat.gui.components.adddialog.AddDialogManager;
import es.ugr.scimat.gui.components.itemslist.PublishDatesListPanel;
import es.ugr.scimat.gui.components.joindialog.JoinEntitiesDialogManager;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.globalslavepanel.PublishDateGlobalSlavePanel;
import es.ugr.scimat.model.knowledgebase.entity.PublishDate;

/**
 *
 * @author mjcobo
 */
public class PublishDateManager extends GenericItemManagerPanel<PublishDate> {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  public PublishDateManager() {
    super(new PublishDatesListPanel(),
          new PublishDateGlobalSlavePanel());

    setMasterPanelTitle("Publish dates list");
    setSlavePanelTitle("Publish date detail");
  }

  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   *
   */
  @Override
  public void addAction() {
    AddDialogManager.getInstance().showAddPublishDateDialog();
  }

  /**
   *
   */
  @Override
  public void moveToAction(ArrayList<PublishDate> items) {
    JoinEntitiesDialogManager.getInstance().showPublishDatesJoinDialog(items);
  }

  /**
   *
   */
  @Override
  public void removeAction(ArrayList<PublishDate> items) {
    (new PerformKnowledgeBaseEditTask(new DeletePublishDateEdit(items), this)).execute();
  }

  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
