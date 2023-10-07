/*
 * WordSlaveDocumentsPanel.java
 *
 * Created on 21-mar-2011, 19:19:37
 */
package es.ugr.scimat.gui.components.slavepanel;

import es.ugr.scimat.gui.components.ErrorDialogManager;
import es.ugr.scimat.gui.components.tablemodel.WordSlaveDocumentTableModel;
import es.ugr.scimat.model.knowledgebase.entity.Document;
import es.ugr.scimat.model.knowledgebase.entity.DocumentWord;
import es.ugr.scimat.model.knowledgebase.entity.Word;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;
import es.ugr.scimat.project.observer.DocumentRelationWordObserver;
import es.ugr.scimat.project.observer.EntityObserver;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class WordSlaveDocumentsPanel
        extends GenericSlaveListPanel<Word, DocumentWord>
        implements DocumentRelationWordObserver, EntityObserver<Document> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     *
     */
    public WordSlaveDocumentsPanel() {
        super(new WordSlaveDocumentTableModel());

        CurrentProject.getInstance().getKbObserver().addDocumentWordObservers(this);
        CurrentProject.getInstance().getKbObserver().addDocumentObserver(this);
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     *
     */
    public void setMasterItem(Word word) {

        this.masterItem = word;

        try {

            if (this.masterItem != null) {

                relationChanged();

            } else {

                this.refreshData(new ArrayList<DocumentWord>());

            }

        } catch (KnowledgeBaseException e) {

            ErrorDialogManager.getInstance().showException(e);

        }
    }

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityAdded(ArrayList<Document> items) throws KnowledgeBaseException {
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
    public void entityRemoved(ArrayList<Document> items) throws KnowledgeBaseException {
        // Do not do nothing
    }

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityUpdated(ArrayList<Document> items) throws KnowledgeBaseException {
        // Do not do nothing
    }

    /**
     * @throws KnowledgeBaseException
     */
    public void relationChanged() throws KnowledgeBaseException {

        if (this.masterItem != null) {

            refreshData(CurrentProject.getInstance().getFactoryDAO().getWordDAO().getDocumentWords(this.masterItem.getWordID()));
        }
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
