/*
 * AddAuthorReferenceGroupEvent.java
 *
 * Created on 28-dic-2011, 20:10:51
 */
package es.ugr.scimat.knowledgebaseevents.event.add;

import es.ugr.scimat.knowledgebaseevents.event.KnowledgeBaseEvent;
import es.ugr.scimat.model.knowledgebase.entity.AuthorReferenceGroup;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class AddAuthorReferenceGroupEvent implements KnowledgeBaseEvent {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /**
     *
     */
    private ArrayList<AuthorReferenceGroup> authorReferenceGroups;

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param authorReferenceGroups
     */
    public AddAuthorReferenceGroupEvent(ArrayList<AuthorReferenceGroup> authorReferenceGroups) {
        this.authorReferenceGroups = authorReferenceGroups;
    }

    /**
     * @param authorReferenceGroup
     */
    public AddAuthorReferenceGroupEvent(AuthorReferenceGroup authorReferenceGroup) {
        this.authorReferenceGroups = new ArrayList<AuthorReferenceGroup>();
        this.authorReferenceGroups.add(authorReferenceGroup);
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @throws KnowledgeBaseException
     */
    public void fireEvent() throws KnowledgeBaseException {

        CurrentProject.getInstance().getKbObserver().fireAuthorReferenceGroupAdded(authorReferenceGroups);
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
