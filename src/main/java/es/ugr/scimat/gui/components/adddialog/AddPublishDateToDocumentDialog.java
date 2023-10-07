/*
 * AddPublishDateToDocumentDialog.java
 *
 * Created on 26-may-2011, 23:52:40
 */
package es.ugr.scimat.gui.components.adddialog;

import es.ugr.scimat.gui.commands.edit.add.AddPublishDateToDocumentEdit;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.detailspanel.PublishDateDetailPanel;
import es.ugr.scimat.gui.components.itemslist.GenericDynamicItemsListPanel;
import es.ugr.scimat.gui.components.itemslist.GenericSelectOneItemPanel;
import es.ugr.scimat.gui.components.tablemodel.PublishDatesTableModel;
import es.ugr.scimat.model.knowledgebase.entity.Document;
import es.ugr.scimat.model.knowledgebase.entity.PublishDate;
import es.ugr.scimat.project.CurrentProject;

import javax.swing.*;

/**
 * @author mjcobo
 */
public class AddPublishDateToDocumentDialog extends GenericAddItemDialog<Document, PublishDate> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param frame
     */
    public AddPublishDateToDocumentDialog(JFrame frame) {
        super(frame,
                new GenericSelectOneItemPanel<PublishDate>(new GenericDynamicItemsListPanel<PublishDate>(new PublishDatesTableModel()),
                        new PublishDateDetailPanel()));
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     *
     */
    @Override
    public void addAction(Document masterItem, PublishDate itemsToAdd) {

        (new PerformKnowledgeBaseEditTask(new AddPublishDateToDocumentEdit(masterItem, itemsToAdd), rootPane)).execute();

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
