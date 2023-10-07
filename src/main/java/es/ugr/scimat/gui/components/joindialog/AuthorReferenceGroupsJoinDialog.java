/*
 * AuthorReferenceGroupsJoinDialog.java
 *
 * Created on 24-may-2011, 12:40:45
 */
package es.ugr.scimat.gui.components.joindialog;

import java.util.ArrayList;
import javax.swing.JFrame;

import es.ugr.scimat.gui.commands.edit.join.JoinAuthorReferenceGroupEdit;
import es.ugr.scimat.gui.components.tablemodel.AuthorReferenceGroupsTableModel;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.itemslist.GenericItemsListPanel;
import es.ugr.scimat.model.knowledgebase.entity.AuthorReferenceGroup;

/**
 *
 * @author mjcobo
 */
public class AuthorReferenceGroupsJoinDialog extends GenericJoinEntitiesDialog<AuthorReferenceGroup> {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/
  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/
  
  public AuthorReferenceGroupsJoinDialog(JFrame frame) {
    super(frame, 
          new GenericItemsListPanel<AuthorReferenceGroup>(new AuthorReferenceGroupsTableModel()));
  }
  
  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/
  
  @Override
  public void moveToAction(ArrayList<AuthorReferenceGroup> sourceItems, AuthorReferenceGroup targetItem) {
    (new PerformKnowledgeBaseEditTask(new JoinAuthorReferenceGroupEdit(sourceItems, targetItem), rootPane)).execute();
  }
  
  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
