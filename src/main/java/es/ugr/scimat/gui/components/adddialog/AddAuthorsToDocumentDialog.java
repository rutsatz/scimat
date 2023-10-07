/*
 * AddAuthorsToDocumentDialog.java
 *
 * Created on 26-may-2011, 19:12:26
 */
package es.ugr.scimat.gui.components.adddialog;

import es.ugr.scimat.gui.commands.edit.add.AddAuthorsToDocumentEdit;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.itemslist.GenericDynamicItemsListPanel;
import es.ugr.scimat.gui.components.itemslist.GenericSelectManyItemsPanel;
import es.ugr.scimat.gui.components.tablemodel.AuthorsTableModel;
import es.ugr.scimat.model.knowledgebase.entity.Author;
import es.ugr.scimat.model.knowledgebase.entity.Document;
import es.ugr.scimat.project.CurrentProject;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class AddAuthorsToDocumentDialog extends GenericAddItemsDialog<Document, Author> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /**
     *
     */
    public AddAuthorsToDocumentDialog(JFrame frame) {
        super(frame,
                new GenericSelectManyItemsPanel<Author>(new GenericDynamicItemsListPanel<Author>(new AuthorsTableModel()),
                        new GenericDynamicItemsListPanel<Author>(new AuthorsTableModel())));
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
    public void addAction(Document masterItem, ArrayList<Author> itemsToAdd) {

        (new PerformKnowledgeBaseEditTask(new AddAuthorsToDocumentEdit(masterItem, itemsToAdd), rootPane)).execute();

        dispose();
    }

    /**
     *
     */
    @Override
    public void addNewItemAction() {
        AddDialogManager.getInstance().showAddAuthorDialog();
    }

    /**
     * @param enabled
     */
    @Override
    public void setEntityObserver(boolean enabled) {

        if (enabled) {

            CurrentProject.getInstance().getKbObserver().addAuthorObserver(this);

        } else {

            CurrentProject.getInstance().getKbObserver().removeAuthorObserver(this);
        }
    }


    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
