/*
 * AuthorReferenceWithoutGroupsListPanel.java
 *
 * Created on 17-nov-2011, 19:38:33
 */
package es.ugr.scimat.gui.components.itemslist;

import es.ugr.scimat.gui.components.tablemodel.AuthorReferencesTableModel;
import es.ugr.scimat.model.knowledgebase.entity.AuthorReference;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;
import es.ugr.scimat.project.observer.EntityObserver;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class AuthorReferenceWithoutGroupsListPanel
        extends GenericDynamicItemsListPanel<AuthorReference>
        implements EntityObserver<AuthorReference> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param tableModel
     */
    public AuthorReferenceWithoutGroupsListPanel() {
        super(new AuthorReferencesTableModel());

        CurrentProject.getInstance().getKbObserver().addAuthorReferenceWithoutGroupObserver(this);
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityAdded(ArrayList<AuthorReference> items) throws KnowledgeBaseException {
        addItems(items);
    }

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityRemoved(ArrayList<AuthorReference> items) throws KnowledgeBaseException {
        removeItems(items);
    }

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityUpdated(ArrayList<AuthorReference> items) throws KnowledgeBaseException {
        updateItems(items);
    }

    /**
     * @throws KnowledgeBaseException
     */
    public void entityRefresh() throws KnowledgeBaseException {
        addItems(CurrentProject.getInstance().getFactoryDAO().getAuthorReferenceDAO().getAuthorReferencesWithoutGroup());
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
