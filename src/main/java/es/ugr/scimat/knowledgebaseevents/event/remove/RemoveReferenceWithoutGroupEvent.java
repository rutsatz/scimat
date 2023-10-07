/*
 * RemoveReferenceWithoutGroupEvent.java
 *
 * Created on 28-dic-2011, 20:10:51
 */
package es.ugr.scimat.knowledgebaseevents.event.remove;

import es.ugr.scimat.knowledgebaseevents.event.KnowledgeBaseEvent;
import es.ugr.scimat.model.knowledgebase.entity.Reference;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class RemoveReferenceWithoutGroupEvent implements KnowledgeBaseEvent {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /**
     *
     */
    private ArrayList<Reference> references;

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param references
     */
    public RemoveReferenceWithoutGroupEvent(ArrayList<Reference> references) {
        this.references = references;
    }

    /**
     * @param reference
     */
    public RemoveReferenceWithoutGroupEvent(Reference reference) {
        this.references = new ArrayList<Reference>();
        this.references.add(reference);
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @throws KnowledgeBaseException
     */
    public void fireEvent() throws KnowledgeBaseException {

        CurrentProject.getInstance().getKbObserver().fireReferenceWithoutGroupRemoved(references);
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
