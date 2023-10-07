/*
 * JournalRelationSubjectCategoryRelationPublishDateEvent.java
 *
 * Created on 20-mar-2011, 21:13:20
 */
package es.ugr.scimat.knowledgebaseevents.event.relation;

import es.ugr.scimat.knowledgebaseevents.event.KnowledgeBaseEvent;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

/**
 * @author mjcobo
 */
public class JournalRelationSubjectCategoryRelationPublishDateEvent implements KnowledgeBaseEvent {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @throws KnowledgeBaseException
     */
    public void fireEvent() throws KnowledgeBaseException {

        CurrentProject.getInstance().getKbObserver().fireJournalSubjectCategoryPublishDatesChanged();
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/

}
