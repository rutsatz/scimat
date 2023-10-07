/*
 * PublishDatesJoinDialog.java
 *
 * Created on 24-may-2011, 12:40:45
 */
package es.ugr.scimat.gui.components.joindialog;

import es.ugr.scimat.gui.commands.edit.join.JoinPublishDateEdit;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.itemslist.GenericItemsListPanel;
import es.ugr.scimat.gui.components.tablemodel.PublishDatesTableModel;
import es.ugr.scimat.model.knowledgebase.entity.PublishDate;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class PublishDatesJoinDialog extends GenericJoinEntitiesDialog<PublishDate> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/
    /***************************************************************************/
    /*                            Constructors                                 */

    /***************************************************************************/

    public PublishDatesJoinDialog(JFrame frame) {
        super(frame,
                new GenericItemsListPanel<PublishDate>(new PublishDatesTableModel()));
    }

    /***************************************************************************/
    /*                           Public Methods                                */

    /***************************************************************************/

    @Override
    public void moveToAction(ArrayList<PublishDate> sourceItems, PublishDate targetItem) {
        (new PerformKnowledgeBaseEditTask(new JoinPublishDateEdit(sourceItems, targetItem), rootPane)).execute();
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
