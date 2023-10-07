/*
 * ReferenceSourcesJoinDialog.java
 *
 * Created on 24-may-2011, 12:40:45
 */
package es.ugr.scimat.gui.components.joindialog;

import java.util.ArrayList;
import javax.swing.JFrame;

import es.ugr.scimat.gui.commands.edit.join.JoinReferenceSourceEdit;
import es.ugr.scimat.gui.components.tablemodel.ReferenceSourcesTableModel;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.itemslist.GenericItemsListPanel;
import es.ugr.scimat.model.knowledgebase.entity.ReferenceSource;

/**
 *
 * @author mjcobo
 */
public class ReferenceSourcesJoinDialog extends GenericJoinEntitiesDialog<ReferenceSource> {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/
  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/
  
  public ReferenceSourcesJoinDialog(JFrame frame) {
    super(frame, 
          new GenericItemsListPanel<ReferenceSource>(new ReferenceSourcesTableModel()));
  }
  
  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/
  
  @Override
  public void moveToAction(ArrayList<ReferenceSource> sourceItems, ReferenceSource targetItem) {
    (new PerformKnowledgeBaseEditTask(new JoinReferenceSourceEdit(sourceItems, targetItem), rootPane)).execute();
  }
  
  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
