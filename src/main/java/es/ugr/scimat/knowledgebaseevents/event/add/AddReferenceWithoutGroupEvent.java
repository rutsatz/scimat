/*
 * AddReferenceWithoutGroupEvent.java
 *
 * Created on 28-dic-2011, 20:10:51
 */
package es.ugr.scimat.knowledgebaseevents.event.add;

import es.ugr.scimat.knowledgebaseevents.event.KnowledgeBaseEvent;
import es.ugr.scimat.model.knowledgebase.entity.Reference;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class AddReferenceWithoutGroupEvent implements KnowledgeBaseEvent {

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
    public AddReferenceWithoutGroupEvent(ArrayList<Reference> references) {
        this.references = references;
    }

    /**
     * @param reference
     */
    public AddReferenceWithoutGroupEvent(Reference reference) {
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

        CurrentProject.getInstance().getKbObserver().fireReferenceWithoutGroupAdded(references);
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
