/*
 * AddAffiliationEvent.java
 *
 * Created on 28-dic-2011, 20:10:51
 */
package es.ugr.scimat.knowledgebaseevents.event.add;

import es.ugr.scimat.knowledgebaseevents.event.KnowledgeBaseEvent;
import es.ugr.scimat.model.knowledgebase.entity.Affiliation;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class AddAffiliationEvent implements KnowledgeBaseEvent {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /**
     *
     */
    private ArrayList<Affiliation> affiliations;

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param affiliations
     */
    public AddAffiliationEvent(ArrayList<Affiliation> affiliations) {
        this.affiliations = affiliations;
    }

    /**
     * @param affiliation
     */
    public AddAffiliationEvent(Affiliation affiliation) {
        this.affiliations = new ArrayList<Affiliation>();
        this.affiliations.add(affiliation);
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @throws KnowledgeBaseException
     */
    public void fireEvent() throws KnowledgeBaseException {

        CurrentProject.getInstance().getKbObserver().fireAffiliationAdded(affiliations);
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
