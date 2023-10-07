/*
 * ReferenceSourceGroupSlaveReferenceSourcesPanel.java
 *
 * Created on 21-mar-2011, 19:19:37
 */
package es.ugr.scimat.gui.components.slavepanel;

import es.ugr.scimat.gui.components.ErrorDialogManager;
import es.ugr.scimat.gui.components.tablemodel.ReferenceSourcesTableModel;
import es.ugr.scimat.model.knowledgebase.entity.ReferenceSource;
import es.ugr.scimat.model.knowledgebase.entity.ReferenceSourceGroup;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;
import es.ugr.scimat.project.observer.EntityObserver;
import es.ugr.scimat.project.observer.ReferenceSourceGroupRelationReferenceSourceObserver;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class ReferenceSourceGroupSlaveReferenceSourcesPanel
        extends GenericSlaveListPanel<ReferenceSourceGroup, ReferenceSource>
        implements ReferenceSourceGroupRelationReferenceSourceObserver, EntityObserver<ReferenceSource> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     *
     */
    public ReferenceSourceGroupSlaveReferenceSourcesPanel() {
        super(new ReferenceSourcesTableModel());

        CurrentProject.getInstance().getKbObserver().addReferenceSourceGroupRelationReferenceSourcesObserver(this);
        CurrentProject.getInstance().getKbObserver().addReferenceSourceObserver(this);
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     *
     */
    public void setMasterItem(ReferenceSourceGroup referenceSourceGroup) {

        this.masterItem = referenceSourceGroup;

        try {

            if (this.masterItem != null) {

                relationChanged();

            } else {

                this.refreshData(new ArrayList<ReferenceSource>());

            }

        } catch (KnowledgeBaseException e) {

            ErrorDialogManager.getInstance().showException(e);

        }
    }

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityAdded(ArrayList<ReferenceSource> items) throws KnowledgeBaseException {
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
    public void entityRemoved(ArrayList<ReferenceSource> items) throws KnowledgeBaseException {
        // Do not do nothing
    }

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityUpdated(ArrayList<ReferenceSource> items) throws KnowledgeBaseException {
        // Do not do nothing
    }

    /**
     * @throws KnowledgeBaseException
     */
    public void relationChanged() throws KnowledgeBaseException {

        if (this.masterItem != null) {

            refreshData(CurrentProject.getInstance().getFactoryDAO().getReferenceSourceGroupDAO().getReferenceSources(this.masterItem.getReferenceSourceGroupID()));
        }
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
