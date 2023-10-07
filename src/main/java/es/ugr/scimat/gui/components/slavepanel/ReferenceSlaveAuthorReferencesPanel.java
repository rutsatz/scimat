/*
 * AuthorReferenceSlaveReferencesPanel.java
 *
 * Created on 21-mar-2011, 19:19:37
 */
package es.ugr.scimat.gui.components.slavepanel;

import es.ugr.scimat.gui.components.ErrorDialogManager;
import es.ugr.scimat.gui.components.tablemodel.ReferenceSlaveAuthorReferenceTableModel;
import es.ugr.scimat.model.knowledgebase.entity.AuthorReference;
import es.ugr.scimat.model.knowledgebase.entity.AuthorReferenceReference;
import es.ugr.scimat.model.knowledgebase.entity.Reference;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;
import es.ugr.scimat.project.observer.EntityObserver;
import es.ugr.scimat.project.observer.ReferenceRelationAuthorReferenceObserver;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class ReferenceSlaveAuthorReferencesPanel
        extends GenericSlaveListPanel<Reference, AuthorReferenceReference>
        implements ReferenceRelationAuthorReferenceObserver, EntityObserver<AuthorReference> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     *
     */
    public ReferenceSlaveAuthorReferencesPanel() {
        super(new ReferenceSlaveAuthorReferenceTableModel());

        CurrentProject.getInstance().getKbObserver().addReferenceRelationAuthorReferenceObserver(this);
        CurrentProject.getInstance().getKbObserver().addAuthorReferenceObserver(this);
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     *
     */
    public void setMasterItem(Reference reference) {

        this.masterItem = reference;

        try {

            if (this.masterItem != null) {

                relationChanged();

            } else {

                this.refreshData(new ArrayList<AuthorReferenceReference>());

            }

        } catch (KnowledgeBaseException e) {

            ErrorDialogManager.getInstance().showException(e);

        }
    }

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityAdded(ArrayList<AuthorReference> items) throws KnowledgeBaseException {
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
    public void entityRemoved(ArrayList<AuthorReference> items) throws KnowledgeBaseException {
        // Do not do nothing
    }

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityUpdated(ArrayList<AuthorReference> items) throws KnowledgeBaseException {
        // Do not do nothing
    }

    /**
     * @throws KnowledgeBaseException
     */
    public void relationChanged() throws KnowledgeBaseException {

        if (this.masterItem != null) {
            refreshData(CurrentProject.getInstance().getFactoryDAO().getReferenceDAO().getAuthorReferenceReferences(this.masterItem.getReferenceID()));
        }
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
