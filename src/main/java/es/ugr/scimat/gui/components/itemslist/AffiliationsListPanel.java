/*
 * AffiliationsListPanel.java
 *
 * Created on 17-nov-2011, 19:38:33
 */
package es.ugr.scimat.gui.components.itemslist;

import es.ugr.scimat.gui.components.tablemodel.AffiliationsTableModel;
import es.ugr.scimat.model.knowledgebase.entity.Affiliation;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;
import es.ugr.scimat.project.observer.EntityObserver;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class AffiliationsListPanel
        extends GenericDynamicItemsListPanel<Affiliation>
        implements EntityObserver<Affiliation> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param tableModel
     */
    public AffiliationsListPanel() {
        super(new AffiliationsTableModel());

        CurrentProject.getInstance().getKbObserver().addAffiliationObserver(this);
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityAdded(ArrayList<Affiliation> items) throws KnowledgeBaseException {

        addItems(items);
    }

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityRemoved(ArrayList<Affiliation> items) throws KnowledgeBaseException {
        removeItems(items);
    }

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityUpdated(ArrayList<Affiliation> items) throws KnowledgeBaseException {
        updateItems(items);
    }

    /**
     * @throws KnowledgeBaseException
     */
    public void entityRefresh() throws KnowledgeBaseException {
        refreshItems(CurrentProject.getInstance().getFactoryDAO().getAffiliationDAO().getAffiliations());
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
