/*
 * AuthorWithoutGroupsListPanel.java
 *
 * Created on 17-nov-2011, 19:38:33
 */
package es.ugr.scimat.gui.components.itemslist;

import es.ugr.scimat.gui.components.tablemodel.AuthorsTableModel;
import es.ugr.scimat.model.knowledgebase.entity.Author;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;
import es.ugr.scimat.project.observer.EntityObserver;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class AuthorWithoutGroupsListPanel
        extends GenericDynamicItemsListPanel<Author>
        implements EntityObserver<Author> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param tableModel
     */
    public AuthorWithoutGroupsListPanel() {
        super(new AuthorsTableModel());

        CurrentProject.getInstance().getKbObserver().addAuthorWithoutGroupObserver(this);
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityAdded(ArrayList<Author> items) throws KnowledgeBaseException {
        addItems(items);
    }

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityRemoved(ArrayList<Author> items) throws KnowledgeBaseException {
        removeItems(items);
    }

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityUpdated(ArrayList<Author> items) throws KnowledgeBaseException {
        updateItems(items);
    }

    /**
     * @throws KnowledgeBaseException
     */
    public void entityRefresh() throws KnowledgeBaseException {
        addItems(CurrentProject.getInstance().getFactoryDAO().getAuthorDAO().getAuthorsWithoutGroup());
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
