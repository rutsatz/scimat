/*
 * WordManager.java
 *
 * Created on 13-mar-2011, 17:16:00
 */
package es.ugr.scimat.gui.components.manager;

import java.util.ArrayList;

import es.ugr.scimat.gui.commands.edit.delete.DeleteWordEdit;
import es.ugr.scimat.gui.components.adddialog.AddDialogManager;
import es.ugr.scimat.gui.components.itemslist.WordsListPanel;
import es.ugr.scimat.gui.components.joindialog.JoinEntitiesDialogManager;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.globalslavepanel.WordGlobalSlavePanel;
import es.ugr.scimat.model.knowledgebase.entity.Word;

/**
 *
 * @author mjcobo
 */
public class WordManager extends GenericItemManagerPanel<Word> {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  /**
   * 
   */
  public WordManager() {
    super(new WordsListPanel(),
          new WordGlobalSlavePanel());

    setMasterPanelTitle("Words list");
    setSlavePanelTitle("Word detail");
  }

  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   *
   */
  @Override
  public void addAction() {
    AddDialogManager.getInstance().showAddWordDialog();
  }

  /**
   *
   */
  @Override
  public void moveToAction(ArrayList<Word> items) {
    JoinEntitiesDialogManager.getInstance().showWordsJoinDialog(items);
  }

  /**
   *
   */
  @Override
  public void removeAction(ArrayList<Word> items) {
    (new PerformKnowledgeBaseEditTask(new DeleteWordEdit(items), this)).execute();
  }

  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
