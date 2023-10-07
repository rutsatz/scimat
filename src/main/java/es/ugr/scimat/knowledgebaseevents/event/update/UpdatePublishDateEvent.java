/*
 * UpdatePublishDateEvent.java
 *
 * Created on 28-dic-2011, 20:10:51
 */
package es.ugr.scimat.knowledgebaseevents.event.update;

import es.ugr.scimat.knowledgebaseevents.event.KnowledgeBaseEvent;
import es.ugr.scimat.model.knowledgebase.entity.PublishDate;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class UpdatePublishDateEvent implements KnowledgeBaseEvent {

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
    public UpdatePublishDateEvent(ArrayList<PublishDate> publishDates) {
        this.publishDates = publishDates;
    }

    /**
     * @param publishDate
     */
    public UpdatePublishDateEvent(PublishDate publishDate) {
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

        CurrentProject.getInstance().getKbObserver().firePublishDateUpdated(publishDates);
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
