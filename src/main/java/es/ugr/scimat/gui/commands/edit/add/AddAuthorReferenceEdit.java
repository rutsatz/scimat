/*
 * AddAuthorReferenceEdit.java
 *
 * Created on 14-mar-2011, 17:40:03
 */
package es.ugr.scimat.gui.commands.edit.add;

import es.ugr.scimat.gui.commands.edit.KnowledgeBaseEdit;
import es.ugr.scimat.gui.undostack.UndoStack;
import es.ugr.scimat.knowledgebaseevents.KnowledgeBaseEventsReceiver;
import es.ugr.scimat.model.knowledgebase.entity.AuthorReference;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

import javax.swing.undo.CannotUndoException;
import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class AddAuthorReferenceEdit extends KnowledgeBaseEdit {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /**
     *
     */
    private Integer authorReferenceID;

    /**
     *
     */
    private String authorName;

    /**
     * The elements added
     */
    private ArrayList<AuthorReference> authorReferencesAdded;

    /***************************************************************************/
    /*                            Constructors                                 */

    /***************************************************************************/

    public AddAuthorReferenceEdit(String authorName) {
        super();

        this.authorName = authorName;
        this.authorReferencesAdded = new ArrayList<AuthorReference>();
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @throws KnowledgeBaseException
     */
    @Override
    public boolean execute() throws KnowledgeBaseException {

        boolean successful = false;

        try {

            if (this.authorName == null) {

                successful = false;
                this.errorMessage = "The name can not be null.";

            } else if (CurrentProject.getInstance().getFactoryDAO().getAuthorReferenceDAO().checkAuthorReference(authorName)) {

                successful = false;
                this.errorMessage = "An Author reference yet exists with this name.";

            } else {

                this.authorReferenceID = CurrentProject.getInstance().getFactoryDAO().getAuthorReferenceDAO().addAuthorReference(authorName, true);

                if (this.authorReferenceID != null) {

                    CurrentProject.getInstance().getKnowledgeBase().commit();

                    this.authorReferencesAdded.add(CurrentProject.getInstance().getFactoryDAO().getAuthorReferenceDAO().getAuthorReference(authorReferenceID));

                    KnowledgeBaseEventsReceiver.getInstance().fireEvents();

                    successful = true;

                    UndoStack.addEdit(this);

                } else {

                    CurrentProject.getInstance().getKnowledgeBase().rollback();

                    successful = false;
                    this.errorMessage = "An error happened.";
                }
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

        boolean flag;

        try {

            flag = CurrentProject.getInstance().getFactoryDAO().getAuthorReferenceDAO().removeAuthorReference(authorReferenceID, true);

            if (flag) {

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

        boolean flag;

        try {

            flag = CurrentProject.getInstance().getFactoryDAO().getAuthorReferenceDAO().addAuthorReference(authorReferenceID, authorName, true);

            if (flag) {

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
