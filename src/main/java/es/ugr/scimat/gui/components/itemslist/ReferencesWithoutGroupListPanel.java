/*
 * ReferencesWithoutGroupListPanel.java
 *
 * Created on 17-nov-2011, 19:38:33
 */
package es.ugr.scimat.gui.components.itemslist;

import es.ugr.scimat.gui.components.tablemodel.ReferencesTableModel;
import es.ugr.scimat.model.knowledgebase.entity.Reference;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;
import es.ugr.scimat.project.observer.EntityObserver;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class ReferencesWithoutGroupListPanel
        extends GenericDynamicItemsListPanel<Reference>
        implements EntityObserver<Reference> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param tableModel
     */
    public ReferencesWithoutGroupListPanel() {
        super(new ReferencesTableModel());

        CurrentProject.getInstance().getKbObserver().addReferenceWithoutGroupObserver(this);
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityAdded(ArrayList<Reference> items) throws KnowledgeBaseException {
        addItems(items);
    }

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityRemoved(ArrayList<Reference> items) throws KnowledgeBaseException {
        removeItems(items);
    }

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityUpdated(ArrayList<Reference> items) throws KnowledgeBaseException {
        updateItems(items);
    }

    /**
     * @throws KnowledgeBaseException
     */
    public void entityRefresh() throws KnowledgeBaseException {
        refreshItems(CurrentProject.getInstance().getFactoryDAO().getReferenceDAO().getReferencesWithoutGroup());
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
