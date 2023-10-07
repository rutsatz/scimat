/*
 * ReferencesJoinDialog.java
 *
 * Created on 24-may-2011, 12:40:45
 */
package es.ugr.scimat.gui.components.joindialog;

import java.util.ArrayList;
import javax.swing.JFrame;

import es.ugr.scimat.gui.commands.edit.join.JoinReferenceEdit;
import es.ugr.scimat.gui.components.tablemodel.ReferencesTableModel;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.itemslist.GenericItemsListPanel;
import es.ugr.scimat.model.knowledgebase.entity.Reference;

/**
 *
 * @author mjcobo
 */
public class ReferencesJoinDialog extends GenericJoinEntitiesDialog<Reference> {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/
  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/
  
  public ReferencesJoinDialog(JFrame frame) {
    super(frame, 
          new GenericItemsListPanel<Reference>(new ReferencesTableModel()));
  }
  
  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/
  
  @Override
  public void moveToAction(ArrayList<Reference> sourceItems, Reference targetItem) {
    (new PerformKnowledgeBaseEditTask(new JoinReferenceEdit(sourceItems, targetItem), rootPane)).execute();
  }
  
  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
