/*
 * RemoveReferenceSourceGrouptEvent.java
 *
 * Created on 28-dic-2011, 20:10:51
 */
package es.ugr.scimat.knowledgebaseevents.event.remove;

import es.ugr.scimat.knowledgebaseevents.event.KnowledgeBaseEvent;
import es.ugr.scimat.model.knowledgebase.entity.ReferenceSourceGroup;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class RemoveReferenceSourceGroupEvent implements KnowledgeBaseEvent {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /**
     *
     */
    private ArrayList<ReferenceSourceGroup> referenceSourceGroups;

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param referenceSourceGroups
     */
    public RemoveReferenceSourceGroupEvent(ArrayList<ReferenceSourceGroup> referenceSourceGroups) {
        this.referenceSourceGroups = referenceSourceGroups;
    }

    /**
     * @param referenceSourceGroup
     */
    public RemoveReferenceSourceGroupEvent(ReferenceSourceGroup referenceSourceGroup) {
        this.referenceSourceGroups = new ArrayList<ReferenceSourceGroup>();
        this.referenceSourceGroups.add(referenceSourceGroup);
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @throws KnowledgeBaseException
     */
    public void fireEvent() throws KnowledgeBaseException {

        CurrentProject.getInstance().getKbObserver().fireReferenceSourceGroupRemoved(referenceSourceGroups);
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
