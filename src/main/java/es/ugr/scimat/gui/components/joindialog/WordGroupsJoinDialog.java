/*
 * WordGroupsJoinDialog.java
 *
 * Created on 24-may-2011, 12:40:45
 */
package es.ugr.scimat.gui.components.joindialog;

import java.util.ArrayList;
import javax.swing.JFrame;

import es.ugr.scimat.gui.commands.edit.join.JoinWordGroupEdit;
import es.ugr.scimat.gui.components.tablemodel.WordGroupsTableModel;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.itemslist.GenericItemsListPanel;
import es.ugr.scimat.model.knowledgebase.entity.WordGroup;

/**
 *
 * @author mjcobo
 */
public class WordGroupsJoinDialog extends GenericJoinEntitiesDialog<WordGroup> {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/
  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/
  
  public WordGroupsJoinDialog(JFrame frame) {
    super(frame, 
          new GenericItemsListPanel<WordGroup>(new WordGroupsTableModel()));
  }
  
  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/
  
  @Override
  public void moveToAction(ArrayList<WordGroup> sourceItems, WordGroup targetItem) {
    (new PerformKnowledgeBaseEditTask(new JoinWordGroupEdit(sourceItems, targetItem), rootPane)).execute();
  }
  
  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
