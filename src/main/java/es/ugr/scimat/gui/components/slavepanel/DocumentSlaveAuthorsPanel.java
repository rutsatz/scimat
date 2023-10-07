/*
 * DocumentSlaveAuthorsPanel.java
 *
 * Created on 21-mar-2011, 19:19:37
 */
package es.ugr.scimat.gui.components.slavepanel;

import es.ugr.scimat.gui.components.ErrorDialogManager;
import es.ugr.scimat.gui.components.tablemodel.DocumentSlaveAuthorTableModel;
import es.ugr.scimat.model.knowledgebase.entity.Author;
import es.ugr.scimat.model.knowledgebase.entity.Document;
import es.ugr.scimat.model.knowledgebase.entity.DocumentAuthor;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;
import es.ugr.scimat.project.observer.DocumentRelationAuthorObserver;
import es.ugr.scimat.project.observer.EntityObserver;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class DocumentSlaveAuthorsPanel
        extends GenericSlaveListPanel<Document, DocumentAuthor>
        implements DocumentRelationAuthorObserver, EntityObserver<Author> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     *
     */
    public DocumentSlaveAuthorsPanel() {
        super(new DocumentSlaveAuthorTableModel());

        CurrentProject.getInstance().getKbObserver().addDocumentAuthorObservers(this);
        CurrentProject.getInstance().getKbObserver().addAuthorObserver(this);
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     *
     */
    public void setMasterItem(Document document) {

        this.masterItem = document;

        try {

            if (this.masterItem != null) {

                relationChanged();

            } else {

                this.refreshData(new ArrayList<DocumentAuthor>());

            }

        } catch (KnowledgeBaseException e) {

            ErrorDialogManager.getInstance().showException(e);

        }
    }

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityAdded(ArrayList<Author> items) throws KnowledgeBaseException {
        // Do not do nothing
    }

    /**
     * @param entity
     * @throws KnowledgeBaseException
     */
    public void entityRefresh() throws KnowledgeBaseException {

        relationChanged();
    }

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityRemoved(ArrayList<Author> items) throws KnowledgeBaseException {
        // Do not do nothing
    }

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityUpdated(ArrayList<Author> items) throws KnowledgeBaseException {
        // Do not do nothing
    }

    /**
     * @throws KnowledgeBaseException
     */
    public void relationChanged() throws KnowledgeBaseException {

        if (this.masterItem != null) {
            refreshData(CurrentProject.getInstance().getFactoryDAO().getDocumentDAO().getDocumentAuthors(this.masterItem.getDocumentID()));
        }
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
