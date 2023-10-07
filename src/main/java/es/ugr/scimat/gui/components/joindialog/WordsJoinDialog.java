/*
 * WordsJoinDialog.java
 *
 * Created on 24-may-2011, 12:40:45
 */
package es.ugr.scimat.gui.components.joindialog;

import es.ugr.scimat.gui.commands.edit.join.JoinWordEdit;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.itemslist.GenericItemsListPanel;
import es.ugr.scimat.gui.components.tablemodel.WordsTableModel;
import es.ugr.scimat.model.knowledgebase.entity.Word;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class WordsJoinDialog extends GenericJoinEntitiesDialog<Word> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/
    /***************************************************************************/
    /*                            Constructors                                 */

    /***************************************************************************/

    public WordsJoinDialog(JFrame frame) {
        super(frame,
                new GenericItemsListPanel<Word>(new WordsTableModel()));
    }

    /***************************************************************************/
    /*                           Public Methods                                */

    /***************************************************************************/

    @Override
    public void moveToAction(ArrayList<Word> sourceItems, Word targetItem) {
        (new PerformKnowledgeBaseEditTask(new JoinWordEdit(sourceItems, targetItem), rootPane)).execute();
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
