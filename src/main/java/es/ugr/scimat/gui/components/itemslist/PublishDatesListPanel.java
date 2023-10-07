/*
 * PublishDatesListPanel.java
 *
 * Created on 17-nov-2011, 19:38:33
 */
package es.ugr.scimat.gui.components.itemslist;

import es.ugr.scimat.gui.components.tablemodel.PublishDatesTableModel;
import es.ugr.scimat.model.knowledgebase.entity.PublishDate;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;
import es.ugr.scimat.project.observer.EntityObserver;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class PublishDatesListPanel
        extends GenericDynamicItemsListPanel<PublishDate>
        implements EntityObserver<PublishDate> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param tableModel
     */
    public PublishDatesListPanel() {
        super(new PublishDatesTableModel());

        CurrentProject.getInstance().getKbObserver().addPublishDateObserver(this);
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityAdded(ArrayList<PublishDate> items) throws KnowledgeBaseException {
        addItems(items);
    }

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityRemoved(ArrayList<PublishDate> items) throws KnowledgeBaseException {
        removeItems(items);
    }

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityUpdated(ArrayList<PublishDate> items) throws KnowledgeBaseException {
        updateItems(items);
    }

    /**
     * @throws KnowledgeBaseException
     */
    public void entityRefresh() throws KnowledgeBaseException {
        refreshItems(CurrentProject.getInstance().getFactoryDAO().getPublishDateDAO().getPublishDates());
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
