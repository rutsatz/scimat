/*
 * DeleteWordEdit.java
 *
 * Created on 14-mar-2011, 17:37:56
 */
package es.ugr.scimat.gui.commands.edit.delete;

import java.util.ArrayList;
import javax.swing.undo.CannotUndoException;
import es.ugr.scimat.gui.commands.edit.KnowledgeBaseEdit;
import es.ugr.scimat.gui.undostack.UndoStack;
import es.ugr.scimat.knowledgebaseevents.KnowledgeBaseEventsReceiver;
import es.ugr.scimat.model.knowledgebase.dao.DocumentWordDAO;
import es.ugr.scimat.model.knowledgebase.dao.WordDAO;
import es.ugr.scimat.model.knowledgebase.entity.DocumentWord;
import es.ugr.scimat.model.knowledgebase.entity.Word;
import es.ugr.scimat.model.knowledgebase.entity.WordGroup;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

/**
 *
 * @author mjcobo
 */
public class DeleteWordEdit extends KnowledgeBaseEdit {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  /**
   * The elements delete
   */
  private ArrayList<Word> wordsToDelete;
  private ArrayList<ArrayList<DocumentWord>> documentWords = new ArrayList<ArrayList<DocumentWord>>();
  private ArrayList<WordGroup> wordGroups = new ArrayList<WordGroup>();

  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  public DeleteWordEdit(ArrayList<Word> wordsToDelete) {
    super();
    
    this.wordsToDelete = wordsToDelete;
  }

  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   *
   * @throws KnowledgeBaseException
   */
  @Override
  public boolean execute() throws KnowledgeBaseException {

    boolean successful = true;
    int i;
    WordDAO wordDAO;
    Word word;

    try {

      i = 0;
      wordDAO = CurrentProject.getInstance().getFactoryDAO().getWordDAO();

      while ((i < this.wordsToDelete.size()) && (successful)) {

        word = this.wordsToDelete.get(i);

        // Retrieve its relation
        this.documentWords.add(wordDAO.getDocumentWords(word.getWordID()));
        this.wordGroups.add(wordDAO.getWordGroup(word.getWordID()));

        successful = wordDAO.removeWord(word.getWordID(), true);

        i++;
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
   *
   * @throws CannotUndoException
   */
  @Override
  public void undo() throws CannotUndoException {
    super.undo();

    int i, j;
    boolean successful = true;
    WordDAO wordDAO;
    Word word;
    DocumentWord documentWord;
    WordGroup wordGroup;
    DocumentWordDAO documentWordDAO;

    try {

      wordDAO = CurrentProject.getInstance().getFactoryDAO().getWordDAO();
      documentWordDAO = CurrentProject.getInstance().getFactoryDAO().getDocumentWordDAO();

      i = 0;

      while ((i < this.wordsToDelete.size()) && (successful)) {

        word = this.wordsToDelete.get(i);

        successful = wordDAO.addWord(word, true);

        j = 0;

        while ((j < this.documentWords.get(i).size()) && (successful)) {

          documentWord = this.documentWords.get(i).get(j);

          successful = documentWordDAO.addDocumentWord(documentWord.getDocument().getDocumentID(),
                                                       word.getWordID(),
                                                       documentWord.isAuthorKeyword(),
                                                       documentWord.isSourceKeyword(),
                                                       documentWord.isAddedKeyword(), true);

          j++;
        }

        wordGroup = this.wordGroups.get(i);

        if ((wordGroup != null) && (successful)) {

          successful = wordDAO.setWordGroup(word.getWordID(),
                                            wordGroup.getWordGroupID(), true);
        }

        i++;
      }

      if (successful) {

        CurrentProject.getInstance().getKnowledgeBase().commit();

        KnowledgeBaseEventsReceiver.getInstance().fireEvents();

      } else {

        CurrentProject.getInstance().getKnowledgeBase().rollback();
      }

    } catch (KnowledgeBaseException e) {

      e.printStackTrace(System.err);

      try{

        CurrentProject.getInstance().getKnowledgeBase().rollback();

      } catch (KnowledgeBaseException e2) {

        e2.printStackTrace(System.err);

      }
    }
  }

  /**
   *
   * @throws CannotUndoException
   */
  @Override
  public void redo() throws CannotUndoException {
    super.redo();

    int i;
    boolean successful = true;
    WordDAO wordDAO;
    Word word;

    try {

      i = 0;
      wordDAO = CurrentProject.getInstance().getFactoryDAO().getWordDAO();

      while ((i < this.wordsToDelete.size()) && (successful)) {

        word = this.wordsToDelete.get(i);

        successful = wordDAO.removeWord(word.getWordID(), true);

        i++;
      }

      if (successful) {

        CurrentProject.getInstance().getKnowledgeBase().commit();

        KnowledgeBaseEventsReceiver.getInstance().fireEvents();

      } else {

        CurrentProject.getInstance().getKnowledgeBase().rollback();
      }

    } catch (KnowledgeBaseException e) {

      e.printStackTrace(System.err);

      try{

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
