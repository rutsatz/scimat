/*
 * AuthorReferenceGroupManualSetManager.java
 *
 * Created on 23-mar-2011, 21:49:34
 */
package es.ugr.scimat.gui.components.manager;

import es.ugr.scimat.gui.commands.edit.add.AddAuthorReferencesToAuthorReferenceGroupEdit;
import es.ugr.scimat.gui.commands.edit.delete.DeleteAuthorReferenceEdit;
import es.ugr.scimat.gui.commands.edit.delete.DeleteAuthorReferenceGroupEdit;
import es.ugr.scimat.gui.commands.edit.delete.DeleteAuthorReferencesFromAuthorReferenceGroupEdit;
import es.ugr.scimat.gui.commands.edit.move.MoveAuthorReferenceToDifferentAuthorReferenceGroupEdit;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.adddialog.AddDialogManager;
import es.ugr.scimat.gui.components.editdialog.EditDialogManager;
import es.ugr.scimat.gui.components.itemslist.AuthorReferenceGroupsListPanel;
import es.ugr.scimat.gui.components.itemslist.AuthorReferenceWithoutGroupsListPanel;
import es.ugr.scimat.gui.components.joindialog.JoinEntitiesDialogManager;
import es.ugr.scimat.gui.components.movetogroup.MoveToGroupDialogManager;
import es.ugr.scimat.gui.components.slavepanel.AuthorReferenceGroupSlaveAuthorReferencesPanel;
import es.ugr.scimat.model.knowledgebase.entity.AuthorReference;
import es.ugr.scimat.model.knowledgebase.entity.AuthorReferenceGroup;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class AuthorReferenceGroupManualSetManager extends GenericManualSetGroupPanel<AuthorReferenceGroup, AuthorReference> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     *
     */
    public AuthorReferenceGroupManualSetManager() {
        super(new AuthorReferenceGroupsListPanel(),
                new AuthorReferenceWithoutGroupsListPanel(),
                new AuthorReferenceGroupSlaveAuthorReferencesPanel());

        setDescription("Authors-reference groups", "Authors-reference of the group", "Authors-reference without group");
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     *
     */
    public void addGroupAction() {

        AddDialogManager.getInstance().showAddAuthorReferenceGroupDialog();
    }

    /**
     * @param group
     */
    public void editGroupAction(AuthorReferenceGroup group) {

        EditDialogManager.getInstance().showEditAuthorReferenceGroupDialog(group);
    }

    /**
     * @param groups
     */
    public void moveGroupToAction(ArrayList<AuthorReferenceGroup> groups) {

        JoinEntitiesDialogManager.getInstance().showAuthorReferenceGroupsJoinDialog(groups);
    }

    /**
     * @param groups
     */
    public void deleteGroupAction(ArrayList<AuthorReferenceGroup> groups) {

        (new PerformKnowledgeBaseEditTask(new DeleteAuthorReferenceGroupEdit(groups), this)).execute();
    }

    /**
     * @param itemsWithoutGroup
     */
    public void toNewGroupAction(ArrayList<AuthorReference> itemsWithoutGroup) {

        MoveToGroupDialogManager.getInstance().showMoveAuthorReferencesToNewGroupDialog(itemsWithoutGroup);
    }

    /**
     * @param itemsWithoutGroup
     */
    public void toDifferentGroupAction(ArrayList<AuthorReference> itemsWithoutGroup) {

        (new PerformKnowledgeBaseEditTask(new MoveAuthorReferenceToDifferentAuthorReferenceGroupEdit(itemsWithoutGroup), this)).execute();
    }

    /**
     * @param itemsFromGroup
     * @param group
     */
    public void removeItemFromGroupAction(ArrayList<AuthorReference> itemsFromGroup, AuthorReferenceGroup group) {

        (new PerformKnowledgeBaseEditTask(new DeleteAuthorReferencesFromAuthorReferenceGroupEdit(itemsFromGroup, group), this)).execute();
    }

    /**
     * @param group
     * @param itemsWithoutGroup
     */
    public void addItemToGroupAction(AuthorReferenceGroup group, ArrayList<AuthorReference> itemsWithoutGroup) {

        (new PerformKnowledgeBaseEditTask(new AddAuthorReferencesToAuthorReferenceGroupEdit(itemsWithoutGroup, group), this)).execute();
    }

    /**
     * @param itemsWithoutGroup
     */
    @Override
    public void removeItemsWithoutGroup(ArrayList<AuthorReference> itemsWithoutGroup) {
        (new PerformKnowledgeBaseEditTask(new DeleteAuthorReferenceEdit(itemsWithoutGroup), this)).execute();
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
