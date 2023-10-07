/*
 * AuthorManager.java
 *
 * Created on 13-mar-2011, 17:15:25
 */
package es.ugr.scimat.gui.components.manager;

import java.util.ArrayList;

import es.ugr.scimat.gui.commands.edit.delete.DeleteAuthorEdit;
import es.ugr.scimat.gui.components.adddialog.AddDialogManager;
import es.ugr.scimat.gui.components.itemslist.AuthorsListPanel;
import es.ugr.scimat.gui.components.joindialog.JoinEntitiesDialogManager;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.globalslavepanel.AuthorGlobalSlavePanel;
import es.ugr.scimat.model.knowledgebase.entity.Author;

/**
 *
 * @author mjcobo
 */
public class AuthorManager extends GenericItemManagerPanel<Author> {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  public AuthorManager() {
    super(new AuthorsListPanel(),
          new AuthorGlobalSlavePanel());

    setMasterPanelTitle("Authors list");
    setSlavePanelTitle("Author detail");
  }

  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   * 
   */
  @Override
  public void addAction() {
    AddDialogManager.getInstance().showAddAuthorDialog();
  }

  /**
   * 
   * @param items 
   */
  @Override
  public void moveToAction(ArrayList<Author> items) {
    JoinEntitiesDialogManager.getInstance().showAuthorsJoinDialog(items);
  }

  /**
   * 
   * @param items 
   */
  @Override
  public void removeAction(ArrayList<Author> items) {
    (new PerformKnowledgeBaseEditTask(new DeleteAuthorEdit(items), this)).execute();
  }

  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
