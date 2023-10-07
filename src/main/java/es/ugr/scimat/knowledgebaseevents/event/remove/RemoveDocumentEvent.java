/*
 * RemoveDocumentEvent.java
 *
 * Created on 28-dic-2011, 20:10:51
 */
package es.ugr.scimat.knowledgebaseevents.event.remove;

import es.ugr.scimat.knowledgebaseevents.event.KnowledgeBaseEvent;
import es.ugr.scimat.model.knowledgebase.entity.Document;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class RemoveDocumentEvent implements KnowledgeBaseEvent {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /**
     *
     */
    private ArrayList<Document> documents;

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param documents
     */
    public RemoveDocumentEvent(ArrayList<Document> documents) {
        this.documents = documents;
    }

    /**
     * @param document
     */
    public RemoveDocumentEvent(Document document) {
        this.documents = new ArrayList<Document>();
        this.documents.add(document);
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @throws KnowledgeBaseException
     */
    public void fireEvent() throws KnowledgeBaseException {

        CurrentProject.getInstance().getKbObserver().fireDocumentRemoved(documents);
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
