/*
 * AuthorGroupsJoinDialog.java
 *
 * Created on 24-may-2011, 12:40:45
 */
package es.ugr.scimat.gui.components.joindialog;

import java.util.ArrayList;
import javax.swing.JFrame;

import es.ugr.scimat.gui.commands.edit.join.JoinAuthorGroupEdit;
import es.ugr.scimat.gui.components.tablemodel.AuthorGroupsTableModel;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.itemslist.GenericItemsListPanel;
import es.ugr.scimat.model.knowledgebase.entity.AuthorGroup;

/**
 *
 * @author mjcobo
 */
public class AuthorGroupsJoinDialog extends GenericJoinEntitiesDialog<AuthorGroup> {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/
  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/
  
  public AuthorGroupsJoinDialog(JFrame frame) {
    super(frame, 
          new GenericItemsListPanel<AuthorGroup>(new AuthorGroupsTableModel()));
  }
  
  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/
  
  @Override
  public void moveToAction(ArrayList<AuthorGroup> sourceItems, AuthorGroup targetItem) {
    (new PerformKnowledgeBaseEditTask(new JoinAuthorGroupEdit(sourceItems, targetItem), rootPane)).execute();
  }
  
  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
