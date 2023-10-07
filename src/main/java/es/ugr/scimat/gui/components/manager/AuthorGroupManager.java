/*
 * AuthorGroupManager.java
 *
 * Created on 13-mar-2011, 17:15:32
 */
package es.ugr.scimat.gui.components.manager;

import java.util.ArrayList;

import es.ugr.scimat.gui.commands.edit.delete.DeleteAuthorGroupEdit;
import es.ugr.scimat.gui.components.adddialog.AddDialogManager;
import es.ugr.scimat.gui.components.itemslist.AuthorGroupsListPanel;
import es.ugr.scimat.gui.components.joindialog.JoinEntitiesDialogManager;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.globalslavepanel.AuthorGroupGlobalSlavePanel;
import es.ugr.scimat.model.knowledgebase.entity.AuthorGroup;

/**
 *
 * @author mjcobo
 */
public class AuthorGroupManager extends GenericItemManagerPanel<AuthorGroup> {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  public AuthorGroupManager() {
    super(new AuthorGroupsListPanel(),
          new AuthorGroupGlobalSlavePanel());

    setMasterPanelTitle("Author groups list");
    setSlavePanelTitle("Author group detail");
  }

  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   *
   */
  @Override
  public void addAction() {
    AddDialogManager.getInstance().showAddAuthorGroupDialog();
  }

  /**
   *
   */
  @Override
  public void moveToAction(ArrayList<AuthorGroup> items) {
    JoinEntitiesDialogManager.getInstance().showAuthorGroupsJoinDialog(items);
  }

  /**
   *
   */
  @Override
  public void removeAction(ArrayList<AuthorGroup> items) {
    (new PerformKnowledgeBaseEditTask(new DeleteAuthorGroupEdit(items), this)).execute();
  }

  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
