/*
 * ReferenceGroupsListPanel.java
 *
 * Created on 17-nov-2011, 19:38:33
 */
package es.ugr.scimat.gui.components.itemslist;

import es.ugr.scimat.gui.components.tablemodel.ReferenceGroupsTableModel;
import es.ugr.scimat.model.knowledgebase.entity.ReferenceGroup;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;
import es.ugr.scimat.project.observer.EntityObserver;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class ReferenceGroupsListPanel
        extends GenericDynamicItemsListPanel<ReferenceGroup>
        implements EntityObserver<ReferenceGroup> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param tableModel
     */
    public ReferenceGroupsListPanel() {
        super(new ReferenceGroupsTableModel());

        CurrentProject.getInstance().getKbObserver().addReferenceGroupObserver(this);
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityAdded(ArrayList<ReferenceGroup> items) throws KnowledgeBaseException {
        addItems(items);
    }

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityRemoved(ArrayList<ReferenceGroup> items) throws KnowledgeBaseException {
        removeItems(items);
    }

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityUpdated(ArrayList<ReferenceGroup> items) throws KnowledgeBaseException {
        updateItems(items);
    }

    /**
     * @throws KnowledgeBaseException
     */
    public void entityRefresh() throws KnowledgeBaseException {
        refreshItems(CurrentProject.getInstance().getFactoryDAO().getReferenceGroupDAO().getReferenceGroups());
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
