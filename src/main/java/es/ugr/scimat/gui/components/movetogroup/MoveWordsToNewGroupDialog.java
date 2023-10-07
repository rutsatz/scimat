/*
 * MoveWordsToNewGroupDialog.java
 *
 * Created on 25-may-2011, 17:12:02
 */
package es.ugr.scimat.gui.components.movetogroup;

import es.ugr.scimat.gui.commands.edit.move.MoveWordsToNewWordGroupEdit;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.itemslist.GenericItemsListPanel;
import es.ugr.scimat.gui.components.tablemodel.WordsTableModel;
import es.ugr.scimat.model.knowledgebase.entity.Word;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class MoveWordsToNewGroupDialog extends GenericMoveToGroupDialog<Word> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/
    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param frame
     */
    public MoveWordsToNewGroupDialog(JFrame frame) {
        super(frame,
                new GenericItemsListPanel<Word>(new WordsTableModel()));
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @param item
     */
    @Override
    public void setGroupNameFromItem(Word item) {

        if (item != null) {

            super.setGroupNameText(item.getWordName());

        } else {

            super.setGroupNameText("");
        }
    }

    /**
     * @param items
     * @param groupName
     */
    @Override
    public void moveAction(ArrayList<Word> items, String groupName) {

        (new PerformKnowledgeBaseEditTask(new MoveWordsToNewWordGroupEdit(items, groupName), rootPane)).execute();
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
