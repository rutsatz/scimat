/*
 * WordGroupManualSetManager.java
 *
 * Created on 23-mar-2011, 21:49:34
 */
package es.ugr.scimat.gui.components.manager;

import es.ugr.scimat.gui.commands.edit.add.AddWordsToWordGroupEdit;
import es.ugr.scimat.gui.commands.edit.delete.DeleteWordEdit;
import es.ugr.scimat.gui.commands.edit.delete.DeleteWordGroupEdit;
import es.ugr.scimat.gui.commands.edit.delete.DeleteWordsFromWordGroupEdit;
import es.ugr.scimat.gui.commands.edit.move.MoveWordToDifferentWordGroupEdit;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.adddialog.AddDialogManager;
import es.ugr.scimat.gui.components.editdialog.EditDialogManager;
import es.ugr.scimat.gui.components.itemslist.WordGroupsListPanel;
import es.ugr.scimat.gui.components.itemslist.WordsWithoutGroupListPanel;
import es.ugr.scimat.gui.components.joindialog.JoinEntitiesDialogManager;
import es.ugr.scimat.gui.components.movetogroup.MoveToGroupDialogManager;
import es.ugr.scimat.gui.components.slavepanel.WordGroupSlaveWordsPanel;
import es.ugr.scimat.model.knowledgebase.entity.Word;
import es.ugr.scimat.model.knowledgebase.entity.WordGroup;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class WordGroupManualSetManager extends GenericManualSetGroupPanel<WordGroup, Word> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     *
     */
    public WordGroupManualSetManager() {
        super(new WordGroupsListPanel(),
                new WordsWithoutGroupListPanel(),
                new WordGroupSlaveWordsPanel());

        setDescription("Word groups", "Words of the group", "Words without group");
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     *
     */
    public void addGroupAction() {

        AddDialogManager.getInstance().showAddWordGroupDialog();
    }

    /**
     * @param group
     */
    public void editGroupAction(WordGroup group) {

        EditDialogManager.getInstance().showEditWordGroupDialog(group);
    }

    /**
     * @param groups
     */
    public void moveGroupToAction(ArrayList<WordGroup> groups) {

        JoinEntitiesDialogManager.getInstance().showWordGroupsJoinDialog(groups);
    }

    /**
     * @param groups
     */
    public void deleteGroupAction(ArrayList<WordGroup> groups) {

        (new PerformKnowledgeBaseEditTask(new DeleteWordGroupEdit(groups), this)).execute();
    }

    /**
     * @param itemsWithoutGroup
     */
    public void toNewGroupAction(ArrayList<Word> itemsWithoutGroup) {

        MoveToGroupDialogManager.getInstance().showMoveWordsToNewGroupDialog(itemsWithoutGroup);
    }

    /**
     * @param itemsWithoutGroup
     */
    public void toDifferentGroupAction(ArrayList<Word> itemsWithoutGroup) {

        (new PerformKnowledgeBaseEditTask(new MoveWordToDifferentWordGroupEdit(itemsWithoutGroup), this)).execute();
    }

    /**
     * @param itemsFromGroup
     * @param group
     */
    public void removeItemFromGroupAction(ArrayList<Word> itemsFromGroup, WordGroup group) {

        (new PerformKnowledgeBaseEditTask(new DeleteWordsFromWordGroupEdit(itemsFromGroup, group), this)).execute();
    }

    /**
     * @param group
     * @param itemsWithoutGroup
     */
    public void addItemToGroupAction(WordGroup group, ArrayList<Word> itemsWithoutGroup) {

        (new PerformKnowledgeBaseEditTask(new AddWordsToWordGroupEdit(itemsWithoutGroup, group), this)).execute();
    }

    /**
     * @param itemsWithoutGroup
     */
    @Override
    public void removeItemsWithoutGroup(ArrayList<Word> itemsWithoutGroup) {
        (new PerformKnowledgeBaseEditTask(new DeleteWordEdit(itemsWithoutGroup), this)).execute();
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
