/*
 * SubjectCategoryManager.java
 *
 * Created on 13-mar-2011, 17:16:33
 */
package es.ugr.scimat.gui.components.manager;

import java.util.ArrayList;

import es.ugr.scimat.gui.commands.edit.delete.DeleteSubjectCategoryEdit;
import es.ugr.scimat.gui.components.adddialog.AddDialogManager;
import es.ugr.scimat.gui.components.itemslist.SubjectCategoriesListPanel;
import es.ugr.scimat.gui.components.joindialog.JoinEntitiesDialogManager;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.globalslavepanel.SubjectCategoryGlobalSlavePanel;
import es.ugr.scimat.model.knowledgebase.entity.SubjectCategory;

/**
 *
 * @author mjcobo
 */
public class SubjectCategoryManager extends GenericItemManagerPanel<SubjectCategory> {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  public SubjectCategoryManager() {
    super(new SubjectCategoriesListPanel(),
          new SubjectCategoryGlobalSlavePanel());

    setMasterPanelTitle("Subject categories list");
    setSlavePanelTitle("Subject category detail");
  }

  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   *
   */
  @Override
  public void addAction() {
    AddDialogManager.getInstance().showAddSubjectCategoryDialog();
  }

  /**
   *
   */
  @Override
  public void moveToAction(ArrayList<SubjectCategory> items) {
    JoinEntitiesDialogManager.getInstance().showSubjectCategoriesJoinDialog(items);
  }

  /**
   *
   */
  @Override
  public void removeAction(ArrayList<SubjectCategory> items) {
    (new PerformKnowledgeBaseEditTask(new DeleteSubjectCategoryEdit(items), this)).execute();
  }

  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
