/*
 * AddAuthorWithoutGroupEvent.java
 *
 * Created on 28-dic-2011, 20:10:51
 */
package es.ugr.scimat.knowledgebaseevents.event.add;

import es.ugr.scimat.knowledgebaseevents.event.KnowledgeBaseEvent;
import es.ugr.scimat.model.knowledgebase.entity.Author;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class AddAuthorWithoutGroupEvent implements KnowledgeBaseEvent {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /**
     *
     */
    private ArrayList<Author> authors;

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param authors
     */
    public AddAuthorWithoutGroupEvent(ArrayList<Author> authors) {
        this.authors = authors;
    }

    /**
     * @param author
     */
    public AddAuthorWithoutGroupEvent(Author author) {
        this.authors = new ArrayList<Author>();
        this.authors.add(author);
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @throws KnowledgeBaseException
     */
    public void fireEvent() throws KnowledgeBaseException {

        CurrentProject.getInstance().getKbObserver().fireAuthorWithoutGroupAdded(authors);
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
