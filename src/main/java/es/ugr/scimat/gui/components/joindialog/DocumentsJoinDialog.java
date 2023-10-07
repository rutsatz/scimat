/*
 * DocumentsJoinDialog.java
 *
 * Created on 24-may-2011, 12:40:45
 */
package es.ugr.scimat.gui.components.joindialog;

import java.util.ArrayList;
import javax.swing.JFrame;

import es.ugr.scimat.gui.commands.edit.join.JoinDocumentEdit;
import es.ugr.scimat.gui.components.tablemodel.DocumentsTableModel;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.itemslist.GenericItemsListPanel;
import es.ugr.scimat.model.knowledgebase.entity.Document;

/**
 *
 * @author mjcobo
 */
public class DocumentsJoinDialog extends GenericJoinEntitiesDialog<Document> {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/
  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/
  
  public DocumentsJoinDialog(JFrame frame) {
    super(frame, 
          new GenericItemsListPanel<Document>(new DocumentsTableModel()));
  }
  
  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/
  
  @Override
  public void moveToAction(ArrayList<Document> sourceItems, Document targetItem) {
    (new PerformKnowledgeBaseEditTask(new JoinDocumentEdit(sourceItems, targetItem), rootPane)).execute();
  }
  
  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
