/*
 * AddReferencesToDocumentEdit.java
 *
 * Created on 25-may-2011, 18:30:11
 */
package es.ugr.scimat.gui.commands.edit.delete;

import es.ugr.scimat.gui.commands.edit.KnowledgeBaseEdit;
import es.ugr.scimat.gui.undostack.UndoStack;
import es.ugr.scimat.knowledgebaseevents.KnowledgeBaseEventsReceiver;
import es.ugr.scimat.model.knowledgebase.dao.DocumentReferenceDAO;
import es.ugr.scimat.model.knowledgebase.entity.Document;
import es.ugr.scimat.model.knowledgebase.entity.Reference;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

import javax.swing.undo.CannotUndoException;
import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class DeleteReferencesFromDocumentEdit extends KnowledgeBaseEdit {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    private Document document;
    private ArrayList<Reference> referencesToDelete;

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param document
     * @param referencesToDelete
     */
    public DeleteReferencesFromDocumentEdit(Document document, ArrayList<Reference> referencesToDelete) {
        this.document = document;
        this.referencesToDelete = referencesToDelete;
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
        DocumentReferenceDAO documentReferenceDAO;

        try {

            documentReferenceDAO = CurrentProject.getInstance().getFactoryDAO().getDocumentReferenceDAO();

            for (i = 0; i < this.referencesToDelete.size(); i++) {

                documentReferenceDAO.removeDocumentReference(this.document.getDocumentID(),
                        this.referencesToDelete.get(i).getReferenceID(), true);
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
        DocumentReferenceDAO documentReferenceDAO;

        try {

            documentReferenceDAO = CurrentProject.getInstance().getFactoryDAO().getDocumentReferenceDAO();

            for (i = 0; i < this.referencesToDelete.size(); i++) {

                documentReferenceDAO.addDocumentReference(this.document.getDocumentID(),
                        this.referencesToDelete.get(i).getReferenceID(), true);
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
        DocumentReferenceDAO documentReferenceDAO;

        try {

            documentReferenceDAO = CurrentProject.getInstance().getFactoryDAO().getDocumentReferenceDAO();

            for (i = 0; i < this.referencesToDelete.size(); i++) {

                documentReferenceDAO.removeDocumentReference(this.document.getDocumentID(),
                        this.referencesToDelete.get(i).getReferenceID(), true);
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
