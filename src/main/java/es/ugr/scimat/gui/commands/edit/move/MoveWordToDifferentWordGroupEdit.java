/*
 * MoveWordToDifferentWordGroupEdit.java
 *
 * Created on 24-may-2011, 17:54:23
 */
package es.ugr.scimat.gui.commands.edit.move;

import es.ugr.scimat.gui.commands.edit.KnowledgeBaseEdit;
import es.ugr.scimat.gui.undostack.UndoStack;
import es.ugr.scimat.knowledgebaseevents.KnowledgeBaseEventsReceiver;
import es.ugr.scimat.model.knowledgebase.dao.WordDAO;
import es.ugr.scimat.model.knowledgebase.dao.WordGroupDAO;
import es.ugr.scimat.model.knowledgebase.entity.Word;
import es.ugr.scimat.model.knowledgebase.entity.WordGroup;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

import javax.swing.undo.CannotUndoException;
import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class MoveWordToDifferentWordGroupEdit extends KnowledgeBaseEdit {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    private ArrayList<Word> wordsToMove;
    private WordGroup[] wordGroups;
    private ArrayList<WordGroup> wordGroupsAdded;
    private boolean[] groupNew; // true if the group i has to be created.

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     *
     */
    public MoveWordToDifferentWordGroupEdit(ArrayList<Word> wordsToMove) {
        this.wordsToMove = wordsToMove;
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @return
     * @throws KnowledgeBaseException
     */
    @Override
    public boolean execute() throws KnowledgeBaseException {

        boolean successful = true;
        int i;
        Integer wordGroupID;
        WordGroup wordGroup;
        Word word;
        WordGroupDAO wordGroupDAO;
        WordDAO wordDAO;

        try {

            wordGroupDAO = CurrentProject.getInstance().getFactoryDAO().getWordGroupDAO();
            wordDAO = CurrentProject.getInstance().getFactoryDAO().getWordDAO();

            this.wordGroups = new WordGroup[this.wordsToMove.size()];
            this.wordGroupsAdded = new ArrayList<WordGroup>();
            this.groupNew = new boolean[this.wordsToMove.size()];

            for (i = 0; i < this.wordsToMove.size(); i++) {

                word = this.wordsToMove.get(i);

                wordGroup = wordGroupDAO.getWordGroup(word.getWordName());

                if (wordGroup == null) {

                    this.groupNew[i] = true;

                    wordGroupID = wordGroupDAO.addWordGroup(word.getWordName(), false, true);

                    wordGroup = wordGroupDAO.getWordGroup(wordGroupID);

                    this.wordGroupsAdded.add(wordGroup);

                } else {

                    this.groupNew[i] = false;
                }

                this.wordGroups[i] = wordGroup;

                successful = wordDAO.setWordGroup(word.getWordID(), wordGroup.getWordGroupID(), true);
            }

            if (successful) {

                CurrentProject.getInstance().getKnowledgeBase().commit();
                KnowledgeBaseEventsReceiver.getInstance().fireEvents();

                UndoStack.addEdit(this);


            } else {

                CurrentProject.getInstance().getKnowledgeBase().rollback();

                this.errorMessage = "An error happened";

            }


        } catch (KnowledgeBaseException e) {

            CurrentProject.getInstance().getKnowledgeBase().rollback();

            successful = false;
            this.errorMessage = "An exception happened.";

            throw e;
        }

        return successful;
    }

    /**
     * @throws CannotUndoException
     */
    @Override
    public void undo() throws CannotUndoException {
        super.undo();

        boolean successful = true;
        int i;
        WordGroupDAO wordGroupDAO;
        WordDAO wordDAO;

        try {

            wordGroupDAO = CurrentProject.getInstance().getFactoryDAO().getWordGroupDAO();
            wordDAO = CurrentProject.getInstance().getFactoryDAO().getWordDAO();

            for (i = 0; i < this.wordsToMove.size(); i++) {

                successful = wordDAO.setWordGroup(this.wordsToMove.get(i).getWordID(), null, true);

                if (this.groupNew[i]) {

                    successful = wordGroupDAO.removeWordGroup(this.wordGroups[i].getWordGroupID(), true);
                }
            }

            if (successful) {

                CurrentProject.getInstance().getKnowledgeBase().commit();
                KnowledgeBaseEventsReceiver.getInstance().fireEvents();

            } else {

                CurrentProject.getInstance().getKnowledgeBase().rollback();
            }

        } catch (KnowledgeBaseException e) {

            e.printStackTrace(System.err);

            try {

                CurrentProject.getInstance().getKnowledgeBase().rollback();

            } catch (KnowledgeBaseException e2) {

                e2.printStackTrace(System.err);

            }
        }
    }

    /**
     * @throws CannotUndoException
     */
    @Override
    public void redo() throws CannotUndoException {
        super.redo();

        boolean successful = true;
        int i;
        WordGroupDAO wordGroupDAO;
        WordDAO wordDAO;

        try {

            wordGroupDAO = CurrentProject.getInstance().getFactoryDAO().getWordGroupDAO();
            wordDAO = CurrentProject.getInstance().getFactoryDAO().getWordDAO();

            for (i = 0; i < this.wordsToMove.size(); i++) {

                if (groupNew[i]) {

                    successful = wordGroupDAO.addWordGroup(this.wordGroups[i], true);
                }

                successful = wordDAO.setWordGroup(this.wordsToMove.get(i).getWordID(), wordGroups[i].getWordGroupID(), true);
            }

            if (successful) {

                CurrentProject.getInstance().getKnowledgeBase().commit();
                KnowledgeBaseEventsReceiver.getInstance().fireEvents();

            } else {

                CurrentProject.getInstance().getKnowledgeBase().rollback();
            }

        } catch (KnowledgeBaseException e) {

            e.printStackTrace(System.err);

            try {

                CurrentProject.getInstance().getKnowledgeBase().rollback();

            } catch (KnowledgeBaseException e2) {

                e2.printStackTrace(System.err);

            }
        }
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
