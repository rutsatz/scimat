/*
 * PeriodsListPanel.java
 *
 * Created on 17-nov-2011, 19:38:33
 */
package es.ugr.scimat.gui.components.itemslist;

import es.ugr.scimat.gui.components.tablemodel.PeriodsTableModel;
import es.ugr.scimat.model.knowledgebase.entity.Period;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;
import es.ugr.scimat.project.observer.EntityObserver;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class PeriodsListPanel
        extends GenericDynamicItemsListPanel<Period>
        implements EntityObserver<Period> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param tableModel
     */
    public PeriodsListPanel() {
        super(new PeriodsTableModel());

        CurrentProject.getInstance().getKbObserver().addPeriodObserver(this);
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityAdded(ArrayList<Period> items) throws KnowledgeBaseException {
        addItems(items);
    }

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityRemoved(ArrayList<Period> items) throws KnowledgeBaseException {
        removeItems(items);
    }

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityUpdated(ArrayList<Period> items) throws KnowledgeBaseException {
        updateItems(items);
    }

    /**
     * @throws KnowledgeBaseException
     */
    public void entityRefresh() throws KnowledgeBaseException {
        refreshItems(CurrentProject.getInstance().getFactoryDAO().getPeriodDAO().getPeriods());
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
