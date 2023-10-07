/*
 * UpdateWordWithoutGroupEvent.java
 *
 * Created on 28-dic-2011, 20:10:51
 */
package es.ugr.scimat.knowledgebaseevents.event.update;

import es.ugr.scimat.knowledgebaseevents.event.KnowledgeBaseEvent;
import es.ugr.scimat.model.knowledgebase.entity.Word;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class UpdateWordWithoutGroupEvent implements KnowledgeBaseEvent {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /**
     *
     */
    private ArrayList<Word> words;

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param words
     */
    public UpdateWordWithoutGroupEvent(ArrayList<Word> words) {
        this.words = words;
    }

    /**
     * @param wordGroup
     */
    public UpdateWordWithoutGroupEvent(Word word) {
        this.words = new ArrayList<Word>();
        this.words.add(word);
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @throws KnowledgeBaseException
     */
    public void fireEvent() throws KnowledgeBaseException {

        CurrentProject.getInstance().getKbObserver().fireWordWithoutGroupUpdated(words);
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
