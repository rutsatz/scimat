/*
 * DeleteAuthorsFromDocumentEdit.java
 *
 * Created on 25-may-2011, 18:30:11
 */
package es.ugr.scimat.gui.commands.edit.delete;

import es.ugr.scimat.gui.commands.edit.KnowledgeBaseEdit;
import es.ugr.scimat.gui.undostack.UndoStack;
import es.ugr.scimat.knowledgebaseevents.KnowledgeBaseEventsReceiver;
import es.ugr.scimat.model.knowledgebase.dao.DocumentAuthorDAO;
import es.ugr.scimat.model.knowledgebase.entity.Document;
import es.ugr.scimat.model.knowledgebase.entity.DocumentAuthor;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

import javax.swing.undo.CannotUndoException;
import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class DeleteAuthorsFromDocumentEdit extends KnowledgeBaseEdit {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    private Document document;
    private ArrayList<DocumentAuthor> documentAuthors;

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param document
     * @param documentAuthors
     */
    public DeleteAuthorsFromDocumentEdit(Document document, ArrayList<DocumentAuthor> documentAuthors) {
        this.document = document;
        this.documentAuthors = documentAuthors;
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
        DocumentAuthorDAO documentAuthorDAO;

        try {

            documentAuthorDAO = CurrentProject.getInstance().getFactoryDAO().getDocumentAuthorDAO();

            for (i = 0; i < this.documentAuthors.size(); i++) {

                documentAuthorDAO.removeDocumentAuthor(this.document.getDocumentID(),
                        this.documentAuthors.get(i).getAuthor().getAuthorID(), true);
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
        DocumentAuthorDAO documentAuthorDAO;
        DocumentAuthor documentAuthor;

        try {

            documentAuthorDAO = CurrentProject.getInstance().getFactoryDAO().getDocumentAuthorDAO();

            for (i = 0; i < this.documentAuthors.size(); i++) {

                documentAuthor = this.documentAuthors.get(i);

                documentAuthorDAO.addDocumentAuthor(this.document.getDocumentID(),
                        documentAuthor.getAuthor().getAuthorID(),
                        documentAuthor.getPosition(), true);
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
        DocumentAuthorDAO documentAuthorDAO;

        try {

            documentAuthorDAO = CurrentProject.getInstance().getFactoryDAO().getDocumentAuthorDAO();

            for (i = 0; i < this.documentAuthors.size(); i++) {

                documentAuthorDAO.removeDocumentAuthor(this.document.getDocumentID(),
                        this.documentAuthors.get(i).getAuthor().getAuthorID(), true);
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
