/*
 * MoveAuthorsToNewGroupDialog.java
 *
 * Created on 25-may-2011, 17:12:02
 */
package es.ugr.scimat.gui.components.movetogroup;

import es.ugr.scimat.gui.commands.edit.move.MoveAuthorReferencesToNewAuthorReferenceGroupEdit;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.itemslist.GenericItemsListPanel;
import es.ugr.scimat.gui.components.tablemodel.AuthorReferencesTableModel;
import es.ugr.scimat.model.knowledgebase.entity.AuthorReference;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class MoveAuthorReferencesToNewGroupDialog extends GenericMoveToGroupDialog<AuthorReference> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/
    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     *
     */
    public MoveAuthorReferencesToNewGroupDialog(JFrame frame) {
        super(frame,
                new GenericItemsListPanel<AuthorReference>(new AuthorReferencesTableModel()));
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @param item
     */
    @Override
    public void setGroupNameFromItem(AuthorReference item) {

        if (item != null) {

            super.setGroupNameText(item.getAuthorName());

        } else {

            super.setGroupNameText("");
        }
    }

    /**
     * @param items
     * @param groupName
     */
    @Override
    public void moveAction(ArrayList<AuthorReference> items, String groupName) {

        (new PerformKnowledgeBaseEditTask(new MoveAuthorReferencesToNewAuthorReferenceGroupEdit(items, groupName), rootPane)).execute();
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
