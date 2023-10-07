/*
 * MoveSimilarReferencesToNewGroupDialog.java
 *
 * Created on 25-may-2011, 17:12:02
 */
package es.ugr.scimat.gui.components.movetogroup;

import java.util.ArrayList;
import javax.swing.JFrame;

import es.ugr.scimat.gui.commands.edit.move.MoveReferencesToNewReferenceGroupEdit;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.itemslist.GenericDynamicItemsListPanel;
import es.ugr.scimat.gui.components.tablemodel.ReferencesTableModel;
import es.ugr.scimat.model.knowledgebase.entity.Reference;

/**
 *
 * @author mjcobo
 */
public class MoveSimilarReferencesToNewGroupDialog extends GenericMoveSimilarItemToGroupDialog<Reference> {

  

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/
  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/
  
  /**
   * 
   * @param frame 
   */
  public MoveSimilarReferencesToNewGroupDialog(JFrame frame) {
    super(frame, new GenericDynamicItemsListPanel<Reference>(new ReferencesTableModel()));
  }
  
  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/
  
  /**
   * 
   * @param item 
   */
  @Override
  public void setGroupNameFromItem(Reference item) {
    
    if (item != null) {
    
      super.setGroupNameText(item.getFullReference());
      
    } else {
    
      super.setGroupNameText("");
    }
  }

  /**
   * 
   * @param items
   * @param groupName 
   */
  @Override
  public void moveAction(ArrayList<Reference> items, String groupName) {
    
    (new PerformKnowledgeBaseEditTask(new MoveReferencesToNewReferenceGroupEdit(items, groupName), rootPane)).execute();
  }
  
  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
