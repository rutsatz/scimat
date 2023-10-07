/*
 * JournalManager.java
 *
 * Created on 13-mar-2011, 17:16:25
 */
package es.ugr.scimat.gui.components.manager;

import java.util.ArrayList;

import es.ugr.scimat.gui.commands.edit.delete.DeleteJournalEdit;
import es.ugr.scimat.gui.components.adddialog.AddDialogManager;
import es.ugr.scimat.gui.components.itemslist.JournalsListPanel;
import es.ugr.scimat.gui.components.joindialog.JoinEntitiesDialogManager;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.globalslavepanel.JournalGlobalSlavePanel;
import es.ugr.scimat.model.knowledgebase.entity.Journal;

/**
 *
 * @author mjcobo
 */
public class JournalManager extends GenericItemManagerPanel<Journal> {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  public JournalManager() {
    super(new JournalsListPanel(),
          new JournalGlobalSlavePanel());

    setMasterPanelTitle("Journals list");
    setSlavePanelTitle("Journal detail");
  }

  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   *
   */
  @Override
  public void addAction() {
    AddDialogManager.getInstance().showAddJournalDialog();
  }

  /**
   *
   */
  @Override
  public void moveToAction(ArrayList<Journal> items) {
    JoinEntitiesDialogManager.getInstance().showJournalsJoinDialog(items);
  }

  /**
   *
   */
  @Override
  public void removeAction(ArrayList<Journal> items) {
    (new PerformKnowledgeBaseEditTask(new DeleteJournalEdit(items), this)).execute();
  }

  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
