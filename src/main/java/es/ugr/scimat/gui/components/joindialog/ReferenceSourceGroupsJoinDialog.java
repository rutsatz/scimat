/*
 * ReferenceSourceGroupsJoinDialog.java
 *
 * Created on 24-may-2011, 12:40:45
 */
package es.ugr.scimat.gui.components.joindialog;

import java.util.ArrayList;
import javax.swing.JFrame;

import es.ugr.scimat.gui.commands.edit.join.JoinReferenceSourceGroupEdit;
import es.ugr.scimat.gui.components.tablemodel.ReferenceSourceGroupsTableModel;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.itemslist.GenericItemsListPanel;
import es.ugr.scimat.model.knowledgebase.entity.ReferenceSourceGroup;

/**
 *
 * @author mjcobo
 */
public class ReferenceSourceGroupsJoinDialog extends GenericJoinEntitiesDialog<ReferenceSourceGroup> {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/
  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/
  
  public ReferenceSourceGroupsJoinDialog(JFrame frame) {
    super(frame, 
          new GenericItemsListPanel<ReferenceSourceGroup>(new ReferenceSourceGroupsTableModel()));
  }
  
  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/
  
  @Override
  public void moveToAction(ArrayList<ReferenceSourceGroup> sourceItems, ReferenceSourceGroup targetItem) {
    (new PerformKnowledgeBaseEditTask(new JoinReferenceSourceGroupEdit(sourceItems, targetItem), rootPane)).execute();
  }
  
  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
