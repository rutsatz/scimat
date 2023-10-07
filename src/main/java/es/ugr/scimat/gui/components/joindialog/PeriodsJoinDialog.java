/*
 * PeriodsJoinDialog.java
 *
 * Created on 24-may-2011, 12:40:45
 */
package es.ugr.scimat.gui.components.joindialog;

import java.util.ArrayList;
import javax.swing.JFrame;

import es.ugr.scimat.gui.commands.edit.join.JoinPeriodEdit;
import es.ugr.scimat.gui.components.tablemodel.PeriodsTableModel;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.itemslist.GenericItemsListPanel;
import es.ugr.scimat.model.knowledgebase.entity.Period;

/**
 *
 * @author mjcobo
 */
public class PeriodsJoinDialog extends GenericJoinEntitiesDialog<Period> {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/
  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/
  
  public PeriodsJoinDialog(JFrame frame) {
    super(frame, 
          new GenericItemsListPanel<Period>(new PeriodsTableModel()));
  }
  
  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/
  
  @Override
  public void moveToAction(ArrayList<Period> sourceItems, Period targetItem) {
    (new PerformKnowledgeBaseEditTask(new JoinPeriodEdit(sourceItems, targetItem), rootPane)).execute();
  }
  
  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
