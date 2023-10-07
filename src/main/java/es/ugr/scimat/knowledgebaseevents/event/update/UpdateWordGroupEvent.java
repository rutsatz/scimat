/*
 * UpdateWordGroupEvent.java
 *
 * Created on 28-dic-2011, 20:10:51
 */
package es.ugr.scimat.knowledgebaseevents.event.update;

import es.ugr.scimat.knowledgebaseevents.event.KnowledgeBaseEvent;
import es.ugr.scimat.model.knowledgebase.entity.WordGroup;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class UpdateWordGroupEvent implements KnowledgeBaseEvent {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /**
     *
     */
    private ArrayList<WordGroup> wordGroups;

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param wordGroups
     */
    public UpdateWordGroupEvent(ArrayList<WordGroup> wordGroups) {
        this.wordGroups = wordGroups;
    }

    /**
     * @param wordGroup
     */
    public UpdateWordGroupEvent(WordGroup wordGroup) {
        this.wordGroups = new ArrayList<WordGroup>();
        this.wordGroups.add(wordGroup);
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @throws KnowledgeBaseException
     */
    public void fireEvent() throws KnowledgeBaseException {

        CurrentProject.getInstance().getKbObserver().fireWordGroupUpdated(wordGroups);
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
