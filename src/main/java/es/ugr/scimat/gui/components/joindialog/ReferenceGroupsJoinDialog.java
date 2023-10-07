/*
 * ReferenceGroupsJoinDialog.java
 *
 * Created on 24-may-2011, 12:40:45
 */
package es.ugr.scimat.gui.components.joindialog;

import es.ugr.scimat.gui.commands.edit.join.JoinReferenceGroupEdit;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.itemslist.GenericItemsListPanel;
import es.ugr.scimat.gui.components.tablemodel.ReferenceGroupsTableModel;
import es.ugr.scimat.model.knowledgebase.entity.ReferenceGroup;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class ReferenceGroupsJoinDialog extends GenericJoinEntitiesDialog<ReferenceGroup> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/
    /***************************************************************************/
    /*                            Constructors                                 */

    /***************************************************************************/

    public ReferenceGroupsJoinDialog(JFrame frame) {
        super(frame,
                new GenericItemsListPanel<ReferenceGroup>(new ReferenceGroupsTableModel()));
    }

    /***************************************************************************/
    /*                           Public Methods                                */

    /***************************************************************************/

    @Override
    public void moveToAction(ArrayList<ReferenceGroup> sourceItems, ReferenceGroup targetItem) {
        (new PerformKnowledgeBaseEditTask(new JoinReferenceGroupEdit(sourceItems, targetItem), rootPane)).execute();
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
