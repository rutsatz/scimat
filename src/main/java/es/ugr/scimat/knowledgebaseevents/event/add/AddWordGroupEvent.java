/*
 * AddWordGroupEvent.java
 *
 * Created on 28-dic-2011, 20:10:51
 */
package es.ugr.scimat.knowledgebaseevents.event.add;

import es.ugr.scimat.knowledgebaseevents.event.KnowledgeBaseEvent;
import es.ugr.scimat.model.knowledgebase.entity.WordGroup;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class AddWordGroupEvent implements KnowledgeBaseEvent {

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
    public AddWordGroupEvent(ArrayList<WordGroup> wordGroups) {
        this.wordGroups = wordGroups;
    }

    /**
     * @param wordGroup
     */
    public AddWordGroupEvent(WordGroup wordGroup) {
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

        CurrentProject.getInstance().getKbObserver().fireWordGroupAdded(wordGroups);
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
