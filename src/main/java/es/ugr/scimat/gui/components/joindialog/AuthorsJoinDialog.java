/*
 * AuthorsJoinDialog.java
 *
 * Created on 24-may-2011, 12:40:45
 */
package es.ugr.scimat.gui.components.joindialog;

import es.ugr.scimat.gui.commands.edit.join.JoinAuthorEdit;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.itemslist.GenericItemsListPanel;
import es.ugr.scimat.gui.components.tablemodel.AuthorsTableModel;
import es.ugr.scimat.model.knowledgebase.entity.Author;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class AuthorsJoinDialog extends GenericJoinEntitiesDialog<Author> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/
    /***************************************************************************/
    /*                            Constructors                                 */

    /***************************************************************************/

    public AuthorsJoinDialog(JFrame frame) {
        super(frame,
                new GenericItemsListPanel<Author>(new AuthorsTableModel()));
    }

    /***************************************************************************/
    /*                           Public Methods                                */

    /***************************************************************************/

    @Override
    public void moveToAction(ArrayList<Author> sourceItems, Author targetItem) {
        (new PerformKnowledgeBaseEditTask(new JoinAuthorEdit(sourceItems, targetItem), rootPane)).execute();
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
