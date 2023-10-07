/*
 * DocumentManager.java
 *
 * Created on 13-mar-2011, 16:04:49
 */
package es.ugr.scimat.gui.components.manager;

import java.util.ArrayList;

import es.ugr.scimat.gui.commands.edit.delete.DeleteDocumentEdit;
import es.ugr.scimat.gui.components.adddialog.AddDialogManager;
import es.ugr.scimat.gui.components.itemslist.DocumentsListPanel;
import es.ugr.scimat.gui.components.joindialog.JoinEntitiesDialogManager;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.globalslavepanel.DocumentGlobalSlavePanel;
import es.ugr.scimat.model.knowledgebase.entity.Document;

/**
 *
 * @author mjcobo
 */
public class DocumentManager extends GenericItemManagerPanel<Document> {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  /**
   * 
   */
  public DocumentManager() {
    super(new DocumentsListPanel(),
          new DocumentGlobalSlavePanel());

    setMasterPanelTitle("Documents list");
    setSlavePanelTitle("Document detail");
  }

  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  @Override
  public void addAction() {
    AddDialogManager.getInstance().showAddDocumentDialog();
  }

  @Override
  public void moveToAction(ArrayList<Document> items) {
    JoinEntitiesDialogManager.getInstance().showDocumentsJoinDialog(items);
  }

  @Override
  public void removeAction(ArrayList<Document> items) {
    (new PerformKnowledgeBaseEditTask(new DeleteDocumentEdit(items), this)).execute();
  }

  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
