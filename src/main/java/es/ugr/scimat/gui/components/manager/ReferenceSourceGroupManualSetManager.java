/*
 * ReferenceSourceGroupManualSetManager.java
 *
 * Created on 23-mar-2011, 21:49:34
 */
package es.ugr.scimat.gui.components.manager;

import java.util.ArrayList;

import es.ugr.scimat.gui.commands.edit.add.AddReferenceSourcesToReferenceSourceGroupEdit;
import es.ugr.scimat.gui.commands.edit.delete.DeleteReferenceSourceEdit;
import es.ugr.scimat.gui.commands.edit.delete.DeleteReferenceSourceGroupEdit;
import es.ugr.scimat.gui.commands.edit.delete.DeleteReferenceSourcesFromReferenceSourceGroupEdit;
import es.ugr.scimat.gui.commands.edit.move.MoveReferenceSourceToDifferentReferenceSourceGroupEdit;
import es.ugr.scimat.gui.components.adddialog.AddDialogManager;
import es.ugr.scimat.gui.components.editdialog.EditDialogManager;
import es.ugr.scimat.gui.components.itemslist.ReferenceSourceGroupsListPanel;
import es.ugr.scimat.gui.components.itemslist.ReferenceSourcesWithoutGroupListPanel;
import es.ugr.scimat.gui.components.joindialog.JoinEntitiesDialogManager;
import es.ugr.scimat.gui.components.movetogroup.MoveToGroupDialogManager;
import es.ugr.scimat.gui.components.slavepanel.ReferenceSourceGroupSlaveReferenceSourcesPanel;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.model.knowledgebase.entity.ReferenceSource;
import es.ugr.scimat.model.knowledgebase.entity.ReferenceSourceGroup;

/**
 *
 * @author mjcobo
 */
public class ReferenceSourceGroupManualSetManager extends GenericManualSetGroupPanel<ReferenceSourceGroup, ReferenceSource> {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  /**
   * 
   */
  public ReferenceSourceGroupManualSetManager() {
    super(new ReferenceSourceGroupsListPanel(),
          new ReferenceSourcesWithoutGroupListPanel(),
          new ReferenceSourceGroupSlaveReferenceSourcesPanel());

    setDescription("Sources-reference groups", "Sources-reference of the group", "Sources-reference without group");
  }

  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   *
   */
  public void addGroupAction() {

    AddDialogManager.getInstance().showAddReferenceSourceGroupDialog();
  }

  /**
   * 
   * @param group 
   */
  public void editGroupAction(ReferenceSourceGroup group) {

    EditDialogManager.getInstance().showEditReferenceSourceGroupDialog(group);
  }

  /**
   * 
   * @param groups 
   */
  public void moveGroupToAction(ArrayList<ReferenceSourceGroup> groups) {

    JoinEntitiesDialogManager.getInstance().showReferenceSourceGroupsJoinDialog(groups);
  }

  /**
   * 
   * @param groups 
   */
  public void deleteGroupAction(ArrayList<ReferenceSourceGroup> groups) {

    (new PerformKnowledgeBaseEditTask(new DeleteReferenceSourceGroupEdit(groups), this)).execute();
  }

  /**
   * 
   * @param itemsWithoutGroup 
   */
  public void toNewGroupAction(ArrayList<ReferenceSource> itemsWithoutGroup) {

    MoveToGroupDialogManager.getInstance().showMoveReferenceSourcesToNewGroupDialog(itemsWithoutGroup);
  }

  /**
   * 
   * @param itemsWithoutGroup 
   */
  public void toDifferentGroupAction(ArrayList<ReferenceSource> itemsWithoutGroup) {

    (new PerformKnowledgeBaseEditTask(new MoveReferenceSourceToDifferentReferenceSourceGroupEdit(itemsWithoutGroup), this)).execute();
  }

  /**
   * 
   * @param itemsFromGroup
   * @param group 
   */
  public void removeItemFromGroupAction(ArrayList<ReferenceSource> itemsFromGroup, ReferenceSourceGroup group) {

    (new PerformKnowledgeBaseEditTask(new DeleteReferenceSourcesFromReferenceSourceGroupEdit(itemsFromGroup, group), this)).execute();
  }

  /**
   * 
   * @param group
   * @param itemsWithoutGroup 
   */
  public void addItemToGroupAction(ReferenceSourceGroup group, ArrayList<ReferenceSource> itemsWithoutGroup) {

    (new PerformKnowledgeBaseEditTask(new AddReferenceSourcesToReferenceSourceGroupEdit(itemsWithoutGroup, group), this)).execute();
  }

  /**
   * 
   * @param itemsWithoutGroup 
   */
  @Override
  public void removeItemsWithoutGroup(ArrayList<ReferenceSource> itemsWithoutGroup) {
    (new PerformKnowledgeBaseEditTask(new DeleteReferenceSourceEdit(itemsWithoutGroup), this)).execute();
  }

  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
