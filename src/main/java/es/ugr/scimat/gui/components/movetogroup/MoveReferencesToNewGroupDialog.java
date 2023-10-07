/*
 * MoveReferencesToNewGroupDialog.java
 *
 * Created on 25-may-2011, 17:12:02
 */
package es.ugr.scimat.gui.components.movetogroup;

import es.ugr.scimat.gui.commands.edit.move.MoveReferencesToNewReferenceGroupEdit;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.itemslist.GenericItemsListPanel;
import es.ugr.scimat.gui.components.tablemodel.ReferencesTableModel;
import es.ugr.scimat.model.knowledgebase.entity.Reference;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class MoveReferencesToNewGroupDialog extends GenericMoveToGroupDialog<Reference> {


    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/
    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param frame
     */
    public MoveReferencesToNewGroupDialog(JFrame frame) {
        super(frame,
                new GenericItemsListPanel<Reference>(new ReferencesTableModel()));
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @param item
     */
    @Override
    public void setGroupNameFromItem(Reference item) {

        if (item != null) {

            super.setGroupNameText(item.getFullReference());

        } else {

            super.setGroupNameText("");
        }
    }

    /**
     * @param items
     * @param groupName
     */
    @Override
    public void moveAction(ArrayList<Reference> items, String groupName) {

        (new PerformKnowledgeBaseEditTask(new MoveReferencesToNewReferenceGroupEdit(items, groupName), rootPane)).execute();
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
