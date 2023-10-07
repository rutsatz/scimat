/*
 * MoveReferenceSourcesToNewGroupDialog.java
 *
 * Created on 25-may-2011, 17:12:02
 */
package es.ugr.scimat.gui.components.movetogroup;

import es.ugr.scimat.gui.commands.edit.move.MoveReferenceSourcesToNewReferenceSourceGroupEdit;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.itemslist.GenericItemsListPanel;
import es.ugr.scimat.gui.components.tablemodel.ReferenceSourcesTableModel;
import es.ugr.scimat.model.knowledgebase.entity.ReferenceSource;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class MoveReferenceSourcesToNewGroupDialog extends GenericMoveToGroupDialog<ReferenceSource> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/
    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     *
     */
    public MoveReferenceSourcesToNewGroupDialog(JFrame frame) {
        super(frame, new GenericItemsListPanel<ReferenceSource>(new ReferenceSourcesTableModel()));
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @param item
     */
    @Override
    public void setGroupNameFromItem(ReferenceSource item) {

        if (item != null) {

            super.setGroupNameText(item.getSource());

        } else {

            super.setGroupNameText("");
        }
    }

    /**
     *
     */
    @Override
    public void moveAction(ArrayList<ReferenceSource> items, String groupName) {

        (new PerformKnowledgeBaseEditTask(new MoveReferenceSourcesToNewReferenceSourceGroupEdit(items, groupName), rootPane)).execute();
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
