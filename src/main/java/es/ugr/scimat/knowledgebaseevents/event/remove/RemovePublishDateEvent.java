/*
 * RemovePublishDateEvent.java
 *
 * Created on 28-dic-2011, 20:10:51
 */
package es.ugr.scimat.knowledgebaseevents.event.remove;

import es.ugr.scimat.knowledgebaseevents.event.KnowledgeBaseEvent;
import es.ugr.scimat.model.knowledgebase.entity.PublishDate;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class RemovePublishDateEvent implements KnowledgeBaseEvent {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /**
     *
     */
    private ArrayList<PublishDate> publishDates;

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param publishDates
     */
    public RemovePublishDateEvent(ArrayList<PublishDate> publishDates) {
        this.publishDates = publishDates;
    }

    /**
     * @param publishDate
     */
    public RemovePublishDateEvent(PublishDate publishDate) {
        this.publishDates = new ArrayList<PublishDate>();
        this.publishDates.add(publishDate);
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @throws KnowledgeBaseException
     */
    public void fireEvent() throws KnowledgeBaseException {

        CurrentProject.getInstance().getKbObserver().firePublishDateRemoved(publishDates);
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
