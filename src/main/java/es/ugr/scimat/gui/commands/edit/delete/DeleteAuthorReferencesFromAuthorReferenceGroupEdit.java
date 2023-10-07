/*
 * DeleteAuthorReferencesFromAuthorReferenceGroupEdit.java
 *
 * Created on 10-abr-2011, 18:37:43
 */
package es.ugr.scimat.gui.commands.edit.delete;

import es.ugr.scimat.gui.commands.edit.KnowledgeBaseEdit;
import es.ugr.scimat.gui.undostack.UndoStack;
import es.ugr.scimat.knowledgebaseevents.KnowledgeBaseEventsReceiver;
import es.ugr.scimat.model.knowledgebase.entity.AuthorReference;
import es.ugr.scimat.model.knowledgebase.entity.AuthorReferenceGroup;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

import javax.swing.undo.CannotUndoException;
import java.util.ArrayList;

/**
 * @authorReference mjcobo
 */
public class DeleteAuthorReferencesFromAuthorReferenceGroupEdit extends KnowledgeBaseEdit {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    private ArrayList<AuthorReference> authorReferencesToDeleteFromAuthorReferenceGroup;
    private AuthorReferenceGroup authorReferenceGroupToDeleteFromAuthorReference;

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param authorReferencesToDeleteFromAuthorReferenceGroup
     * @param authorReferenceGroupToDeleteFromAuthorReference
     */
    public DeleteAuthorReferencesFromAuthorReferenceGroupEdit(ArrayList<AuthorReference> authorReferencesToDeleteFromAuthorReferenceGroup, AuthorReferenceGroup authorReferenceGroupToDeleteFromAuthorReference) {

        this.authorReferencesToDeleteFromAuthorReferenceGroup = authorReferencesToDeleteFromAuthorReferenceGroup;
        this.authorReferenceGroupToDeleteFromAuthorReference = authorReferenceGroupToDeleteFromAuthorReference;
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

        int i;
        boolean successful = false;

        try {

            for (i = 0; i < this.authorReferencesToDeleteFromAuthorReferenceGroup.size(); i++) {

                successful = CurrentProject.getInstance().getFactoryDAO().getAuthorReferenceDAO().setAuthorReferenceGroup(this.authorReferencesToDeleteFromAuthorReferenceGroup.get(i).getAuthorReferenceID(),
                        null, true);
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

        int i;
        boolean successful = false;

        try {

            for (i = 0; i < this.authorReferencesToDeleteFromAuthorReferenceGroup.size(); i++) {

                successful = CurrentProject.getInstance().getFactoryDAO().getAuthorReferenceDAO().setAuthorReferenceGroup(this.authorReferencesToDeleteFromAuthorReferenceGroup.get(i).getAuthorReferenceID(),
                        this.authorReferenceGroupToDeleteFromAuthorReference.getAuthorReferenceGroupID(), true);
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

        int i;
        boolean successful = false;

        try {

            for (i = 0; i < this.authorReferencesToDeleteFromAuthorReferenceGroup.size(); i++) {

                successful = CurrentProject.getInstance().getFactoryDAO().getAuthorReferenceDAO().setAuthorReferenceGroup(this.authorReferencesToDeleteFromAuthorReferenceGroup.get(i).getAuthorReferenceID(), null, true);
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
