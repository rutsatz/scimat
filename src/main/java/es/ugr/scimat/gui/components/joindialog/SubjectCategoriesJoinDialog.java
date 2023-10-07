/*
 * SubjectCategoriesJoinDialog.java
 *
 * Created on 24-may-2011, 12:40:45
 */
package es.ugr.scimat.gui.components.joindialog;

import java.util.ArrayList;
import javax.swing.JFrame;

import es.ugr.scimat.gui.commands.edit.join.JoinSubjectCategoryEdit;
import es.ugr.scimat.gui.components.tablemodel.SubjectCategorysTableModel;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.itemslist.GenericItemsListPanel;
import es.ugr.scimat.model.knowledgebase.entity.SubjectCategory;

/**
 *
 * @author mjcobo
 */
public class SubjectCategoriesJoinDialog extends GenericJoinEntitiesDialog<SubjectCategory> {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/
  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/
  
  public SubjectCategoriesJoinDialog(JFrame frame) {
    super(frame, 
          new GenericItemsListPanel<SubjectCategory>(new SubjectCategorysTableModel()));
  }
  
  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/
  
  @Override
  public void moveToAction(ArrayList<SubjectCategory> sourceItems, SubjectCategory targetItem) {
    (new PerformKnowledgeBaseEditTask(new JoinSubjectCategoryEdit(sourceItems, targetItem), rootPane)).execute();
  }
  
  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
