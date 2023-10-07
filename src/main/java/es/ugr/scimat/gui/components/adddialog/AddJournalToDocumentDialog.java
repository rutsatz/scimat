/*
 * AddJournalToDocumentDialog.java
 *
 * Created on 26-may-2011, 23:52:40
 */
package es.ugr.scimat.gui.components.adddialog;

import javax.swing.JFrame;

import es.ugr.scimat.gui.commands.edit.add.AddJournalToDocumentEdit;
import es.ugr.scimat.gui.components.detailspanel.JournalDetailPanel;
import es.ugr.scimat.gui.components.itemslist.GenericDynamicItemsListPanel;
import es.ugr.scimat.gui.components.itemslist.GenericSelectOneItemPanel;
import es.ugr.scimat.gui.components.tablemodel.JournalsTableModel;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.model.knowledgebase.entity.Document;
import es.ugr.scimat.model.knowledgebase.entity.Journal;
import es.ugr.scimat.project.CurrentProject;

/**
 *
 * @author mjcobo
 */
public class AddJournalToDocumentDialog extends GenericAddItemDialog<Document, Journal> {

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
  public AddJournalToDocumentDialog(JFrame frame) {
    super(frame,
          new GenericSelectOneItemPanel<Journal>(new GenericDynamicItemsListPanel<Journal>(new JournalsTableModel()),
                                                              new JournalDetailPanel()));
  }
  
  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   * 
   */
  @Override
  public void addAction(Document masterItem, Journal itemsToAdd) {
    
    (new PerformKnowledgeBaseEditTask(new AddJournalToDocumentEdit(masterItem, itemsToAdd), rootPane)).execute();
    
    dispose();
  }

  /**
   * 
   */
  @Override
  public void addNewItemAction() {
    AddDialogManager.getInstance().showAddJournalDialog();
    
  }

  /**
   * 
   * @param enabled 
   */
  @Override
  public void setEntityObserver(boolean enabled) {
    
    if (enabled) {
    
      CurrentProject.getInstance().getKbObserver().addJournalObserver(this);
      
    } else {
    
      CurrentProject.getInstance().getKbObserver().removeJournalObserver(this);
    }
  }
  
  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
