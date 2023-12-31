/*
 * ReferenceGroupManualSetManager.java
 *
 * Created on 23-mar-2011, 21:49:34
 */
package es.ugr.scimat.gui.components.manager;

import es.ugr.scimat.gui.commands.edit.add.AddReferencesToReferenceGroupEdit;
import es.ugr.scimat.gui.commands.edit.delete.DeleteReferenceEdit;
import es.ugr.scimat.gui.commands.edit.delete.DeleteReferenceGroupEdit;
import es.ugr.scimat.gui.commands.edit.delete.DeleteReferencesFromReferenceGroupEdit;
import es.ugr.scimat.gui.commands.edit.move.MoveReferenceToDifferentReferenceGroupEdit;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.adddialog.AddDialogManager;
import es.ugr.scimat.gui.components.editdialog.EditDialogManager;
import es.ugr.scimat.gui.components.itemslist.ReferenceGroupsListPanel;
import es.ugr.scimat.gui.components.itemslist.ReferencesWithoutGroupListPanel;
import es.ugr.scimat.gui.components.joindialog.JoinEntitiesDialogManager;
import es.ugr.scimat.gui.components.movetogroup.MoveToGroupDialogManager;
import es.ugr.scimat.gui.components.slavepanel.ReferenceGroupSlaveReferencesPanel;
import es.ugr.scimat.model.knowledgebase.entity.Reference;
import es.ugr.scimat.model.knowledgebase.entity.ReferenceGroup;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class ReferenceGroupManualSetManager extends GenericManualSetGroupPanel<ReferenceGroup, Reference> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     *
     */
    public ReferenceGroupManualSetManager() {
        super(new ReferenceGroupsListPanel(),
                new ReferencesWithoutGroupListPanel(),
                new ReferenceGroupSlaveReferencesPanel());

        setDescription("Reference groups", "References of the group", "References without group");
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     *
     */
    public void addGroupAction() {

        AddDialogManager.getInstance().showAddReferenceGroupDialog();
    }

    /**
     * @param group
     */
    public void editGroupAction(ReferenceGroup group) {

        EditDialogManager.getInstance().showEditReferenceGroupDialog(group);
    }

    /**
     * @param groups
     */
    public void moveGroupToAction(ArrayList<ReferenceGroup> groups) {

        JoinEntitiesDialogManager.getInstance().showReferenceGroupsJoinDialog(groups);
    }

    /**
     * @param groups
     */
    public void deleteGroupAction(ArrayList<ReferenceGroup> groups) {

        (new PerformKnowledgeBaseEditTask(new DeleteReferenceGroupEdit(groups), this)).execute();
    }

    /**
     * @param itemsWithoutGroup
     */
    public void toNewGroupAction(ArrayList<Reference> itemsWithoutGroup) {

        MoveToGroupDialogManager.getInstance().showMoveReferencesToNewGroupDialog(itemsWithoutGroup);
    }

    /**
     * @param itemsWithoutGroup
     */
    public void toDifferentGroupAction(ArrayList<Reference> itemsWithoutGroup) {

        (new PerformKnowledgeBaseEditTask(new MoveReferenceToDifferentReferenceGroupEdit(itemsWithoutGroup), this)).execute();
    }

    /**
     * @param itemsFromGroup
     * @param group
     */
    public void removeItemFromGroupAction(ArrayList<Reference> itemsFromGroup, ReferenceGroup group) {

        (new PerformKnowledgeBaseEditTask(new DeleteReferencesFromReferenceGroupEdit(itemsFromGroup, group), this)).execute();
    }

    /**
     * @param group
     * @param itemsWithoutGroup
     */
    public void addItemToGroupAction(ReferenceGroup group, ArrayList<Reference> itemsWithoutGroup) {

        (new PerformKnowledgeBaseEditTask(new AddReferencesToReferenceGroupEdit(itemsWithoutGroup, group), this)).execute();
    }

    /**
     * @param itemsWithoutGroup
     */
    @Override
    public void removeItemsWithoutGroup(ArrayList<Reference> itemsWithoutGroup) {
        (new PerformKnowledgeBaseEditTask(new DeleteReferenceEdit(itemsWithoutGroup), this)).execute();
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
