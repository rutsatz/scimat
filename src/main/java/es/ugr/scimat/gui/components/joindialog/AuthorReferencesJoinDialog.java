/*
 * AuthorReferencesJoinDialog.java
 *
 * Created on 24-may-2011, 12:40:45
 */
package es.ugr.scimat.gui.components.joindialog;

import es.ugr.scimat.gui.commands.edit.join.JoinAuthorReferenceEdit;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.itemslist.GenericItemsListPanel;
import es.ugr.scimat.gui.components.tablemodel.AuthorReferencesTableModel;
import es.ugr.scimat.model.knowledgebase.entity.AuthorReference;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class AuthorReferencesJoinDialog extends GenericJoinEntitiesDialog<AuthorReference> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/
    /***************************************************************************/
    /*                            Constructors                                 */

    /***************************************************************************/

    public AuthorReferencesJoinDialog(JFrame frame) {
        super(frame,
                new GenericItemsListPanel<AuthorReference>(new AuthorReferencesTableModel()));
    }

    /***************************************************************************/
    /*                           Public Methods                                */

    /***************************************************************************/

    @Override
    public void moveToAction(ArrayList<AuthorReference> sourceItems, AuthorReference targetItem) {
        (new PerformKnowledgeBaseEditTask(new JoinAuthorReferenceEdit(sourceItems, targetItem), rootPane)).execute();
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
