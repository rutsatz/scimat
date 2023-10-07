/*
 * AddAuthorGroupEvent.java
 *
 * Created on 28-dic-2011, 20:10:51
 */
package es.ugr.scimat.knowledgebaseevents.event.add;

import es.ugr.scimat.knowledgebaseevents.event.KnowledgeBaseEvent;
import es.ugr.scimat.model.knowledgebase.entity.AuthorGroup;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class AddAuthorGroupEvent implements KnowledgeBaseEvent {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /**
     *
     */
    private ArrayList<AuthorGroup> authorGroups;

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param authorGroups
     */
    public AddAuthorGroupEvent(ArrayList<AuthorGroup> authorGroups) {
        this.authorGroups = authorGroups;
    }

    /**
     * @param authorGroup
     */
    public AddAuthorGroupEvent(AuthorGroup authorGroup) {
        this.authorGroups = new ArrayList<AuthorGroup>();
        this.authorGroups.add(authorGroup);
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @throws KnowledgeBaseException
     */
    public void fireEvent() throws KnowledgeBaseException {

        CurrentProject.getInstance().getKbObserver().fireAuthorGroupAdded(authorGroups);
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
