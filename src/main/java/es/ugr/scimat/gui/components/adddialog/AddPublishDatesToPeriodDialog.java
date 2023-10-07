/*
 * AddPublishDatesToPeriodDialog.java
 *
 * Created on 26-may-2011, 19:12:26
 */
package es.ugr.scimat.gui.components.adddialog;

import es.ugr.scimat.gui.commands.edit.add.AddPublishDatesToPeriodEdit;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.itemslist.GenericDynamicItemsListPanel;
import es.ugr.scimat.gui.components.itemslist.GenericSelectManyItemsPanel;
import es.ugr.scimat.gui.components.tablemodel.PublishDatesTableModel;
import es.ugr.scimat.model.knowledgebase.entity.Period;
import es.ugr.scimat.model.knowledgebase.entity.PublishDate;
import es.ugr.scimat.project.CurrentProject;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class AddPublishDatesToPeriodDialog extends GenericAddItemsDialog<Period, PublishDate> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /**
     *
     */
    public AddPublishDatesToPeriodDialog(JFrame frame) {
        super(frame,
                new GenericSelectManyItemsPanel<PublishDate>(new GenericDynamicItemsListPanel<PublishDate>(new PublishDatesTableModel()),
                        new GenericDynamicItemsListPanel<PublishDate>(new PublishDatesTableModel())));
    }

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/
    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @param masterItem
     * @param itemsToAdd
     */
    @Override
    public void addAction(Period masterItem, ArrayList<PublishDate> itemsToAdd) {

        (new PerformKnowledgeBaseEditTask(new AddPublishDatesToPeriodEdit(masterItem, itemsToAdd), rootPane)).execute();

        dispose();
    }

    /**
     *
     */
    @Override
    public void addNewItemAction() {
        AddDialogManager.getInstance().showAddPublishDateDialog();
    }

    /**
     * @param enabled
     */
    @Override
    public void setEntityObserver(boolean enabled) {

        if (enabled) {

            CurrentProject.getInstance().getKbObserver().addPublishDateObserver(this);

        } else {

            CurrentProject.getInstance().getKbObserver().removePublishDateObserver(this);
        }
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
