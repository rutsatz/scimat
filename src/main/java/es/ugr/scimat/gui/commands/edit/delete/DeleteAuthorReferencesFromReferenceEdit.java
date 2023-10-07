/*
 * DeleteAuthorReferencesFromReferenceEdit.java
 *
 * Created on 25-may-2011, 18:30:11
 */
package es.ugr.scimat.gui.commands.edit.delete;

import es.ugr.scimat.gui.commands.edit.KnowledgeBaseEdit;
import es.ugr.scimat.gui.undostack.UndoStack;
import es.ugr.scimat.knowledgebaseevents.KnowledgeBaseEventsReceiver;
import es.ugr.scimat.model.knowledgebase.dao.AuthorReferenceReferenceDAO;
import es.ugr.scimat.model.knowledgebase.entity.AuthorReferenceReference;
import es.ugr.scimat.model.knowledgebase.entity.Reference;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

import javax.swing.undo.CannotUndoException;
import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class DeleteAuthorReferencesFromReferenceEdit extends KnowledgeBaseEdit {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    private Reference reference;
    private ArrayList<AuthorReferenceReference> authorReferenceReferences;

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param reference
     * @param authorReferenceReferences
     */
    public DeleteAuthorReferencesFromReferenceEdit(Reference reference, ArrayList<AuthorReferenceReference> authorReferenceReferences) {
        this.reference = reference;
        this.authorReferenceReferences = authorReferenceReferences;
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
        AuthorReferenceReferenceDAO authorReferenceReferenceDAO;

        try {

            authorReferenceReferenceDAO = CurrentProject.getInstance().getFactoryDAO().getAuthorReferenceReferenceDAO();

            for (i = 0; i < this.authorReferenceReferences.size(); i++) {

                authorReferenceReferenceDAO.removeAuthorReferenceReference(this.reference.getReferenceID(),
                        this.authorReferenceReferences.get(i).getAuthorReference().getAuthorReferenceID(), true);
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
        AuthorReferenceReferenceDAO authorReferenceReferenceDAO;
        AuthorReferenceReference authorReferenceReference;

        try {

            authorReferenceReferenceDAO = CurrentProject.getInstance().getFactoryDAO().getAuthorReferenceReferenceDAO();

            for (i = 0; i < this.authorReferenceReferences.size(); i++) {

                authorReferenceReference = this.authorReferenceReferences.get(i);

                authorReferenceReferenceDAO.addAuthorReferenceReference(this.reference.getReferenceID(),
                        authorReferenceReference.getAuthorReference().getAuthorReferenceID(),
                        authorReferenceReference.getPosition(), true);
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
        AuthorReferenceReferenceDAO authorReferenceReferenceDAO;

        try {

            authorReferenceReferenceDAO = CurrentProject.getInstance().getFactoryDAO().getAuthorReferenceReferenceDAO();

            for (i = 0; i < this.authorReferenceReferences.size(); i++) {

                authorReferenceReferenceDAO.removeAuthorReferenceReference(this.reference.getReferenceID(),
                        this.authorReferenceReferences.get(i).getAuthorReference().getAuthorReferenceID(), true);
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
