/*
 * AffiliationsJoinDialog.java
 *
 * Created on 24-may-2011, 12:40:45
 */
package es.ugr.scimat.gui.components.joindialog;

import java.util.ArrayList;
import javax.swing.JFrame;

import es.ugr.scimat.gui.commands.edit.join.JoinAffiliationEdit;
import es.ugr.scimat.gui.components.tablemodel.AffiliationsTableModel;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.itemslist.GenericItemsListPanel;
import es.ugr.scimat.model.knowledgebase.entity.Affiliation;

/**
 *
 * @author mjcobo
 */
public class AffiliationsJoinDialog extends GenericJoinEntitiesDialog<Affiliation> {

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
  public AffiliationsJoinDialog(JFrame frame) {
    super(frame, 
          new GenericItemsListPanel<Affiliation>(new AffiliationsTableModel()));
  }
  
  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/
  
  @Override
  public void moveToAction(ArrayList<Affiliation> sourceItems, Affiliation targetItem) {
    (new PerformKnowledgeBaseEditTask(new JoinAffiliationEdit(sourceItems, targetItem), rootPane)).execute();
  }
  
  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
