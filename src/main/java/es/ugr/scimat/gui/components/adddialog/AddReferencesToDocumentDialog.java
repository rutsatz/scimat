/*
 * AddReferencesToDocumentDialog.java
 *
 * Created on 26-may-2011, 19:12:26
 */
package es.ugr.scimat.gui.components.adddialog;

import java.util.ArrayList;
import javax.swing.JFrame;

import es.ugr.scimat.gui.commands.edit.add.AddReferencesToDocumentEdit;
import es.ugr.scimat.gui.components.itemslist.GenericDynamicItemsListPanel;
import es.ugr.scimat.gui.components.itemslist.GenericSelectManyItemsPanel;
import es.ugr.scimat.gui.components.tablemodel.ReferencesTableModel;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.model.knowledgebase.entity.Document;
import es.ugr.scimat.model.knowledgebase.entity.Reference;
import es.ugr.scimat.project.CurrentProject;

/**
 *
 * @author mjcobo
 */
public class AddReferencesToDocumentDialog extends GenericAddItemsDialog<Document, Reference> {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/
  
  /**
   * 
   * @param frame 
   */
  public AddReferencesToDocumentDialog(JFrame frame) {
    super(frame, 
          new GenericSelectManyItemsPanel<Reference>(new GenericDynamicItemsListPanel<Reference>(new ReferencesTableModel()),
                                                         new GenericDynamicItemsListPanel<Reference>(new ReferencesTableModel())));
  }
  
  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/
  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/
  
  /**
   * 
   * @param masterItem
   * @param itemsToAdd 
   */
  @Override
  public void addAction(Document masterItem, ArrayList<Reference> itemsToAdd) {
    
    (new PerformKnowledgeBaseEditTask(new AddReferencesToDocumentEdit(masterItem, itemsToAdd), rootPane)).execute();
    
    dispose();
  }

  /**
   * 
   */
  @Override
  public void addNewItemAction() {
    AddDialogManager.getInstance().showAddReferenceDialog();
  }

  /**
   * 
   * @param enabled 
   */
  @Override
  public void setEntityObserver(boolean enabled) {
    
    if (enabled) {
    
      CurrentProject.getInstance().getKbObserver().addReferenceObserver(this);
      
    } else {
    
      CurrentProject.getInstance().getKbObserver().removeReferenceObserver(this);
    }
  }
  
  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
