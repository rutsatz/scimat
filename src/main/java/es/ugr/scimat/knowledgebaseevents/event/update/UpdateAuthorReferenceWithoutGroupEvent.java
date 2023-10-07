/*
 * UpdateAuthorReferenceWithoutGroupEvent.java
 *
 * Created on 28-dic-2011, 20:10:51
 */
package es.ugr.scimat.knowledgebaseevents.event.update;

import es.ugr.scimat.knowledgebaseevents.event.KnowledgeBaseEvent;
import es.ugr.scimat.model.knowledgebase.entity.AuthorReference;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class UpdateAuthorReferenceWithoutGroupEvent implements KnowledgeBaseEvent {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /**
     *
     */
    private ArrayList<AuthorReference> authorReferences;

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param authorReferences
     */
    public UpdateAuthorReferenceWithoutGroupEvent(ArrayList<AuthorReference> authorReferences) {
        this.authorReferences = authorReferences;
    }

    /**
     * @param authorReference
     */
    public UpdateAuthorReferenceWithoutGroupEvent(AuthorReference authorReference) {
        this.authorReferences = new ArrayList<AuthorReference>();
        this.authorReferences.add(authorReference);
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @throws KnowledgeBaseException
     */
    public void fireEvent() throws KnowledgeBaseException {

        CurrentProject.getInstance().getKbObserver().fireAuthorReferenceWithoutGroupUpdated(authorReferences);
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
