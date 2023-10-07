/*
 * AddAuthorsToAuthorGroupEdit.java
 *
 * Created on 10-abr-2011, 18:37:43
 */
package es.ugr.scimat.gui.commands.edit.add;

import es.ugr.scimat.gui.commands.edit.KnowledgeBaseEdit;
import es.ugr.scimat.gui.undostack.UndoStack;
import es.ugr.scimat.knowledgebaseevents.KnowledgeBaseEventsReceiver;
import es.ugr.scimat.model.knowledgebase.entity.Author;
import es.ugr.scimat.model.knowledgebase.entity.AuthorGroup;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

import javax.swing.undo.CannotUndoException;
import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class AddAuthorsToAuthorGroupEdit extends KnowledgeBaseEdit {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    private ArrayList<Author> authorsToAdd;
    private ArrayList<AuthorGroup> oldAuthorGroupOfAuthors;
    private AuthorGroup targetAuthorGroup;

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param authorsToAdd
     * @param targetAuthorGroup
     */
    public AddAuthorsToAuthorGroupEdit(ArrayList<Author> authorsToAdd, AuthorGroup targetAuthorGroup) {

        this.authorsToAdd = authorsToAdd;
        this.targetAuthorGroup = targetAuthorGroup;

        this.oldAuthorGroupOfAuthors = new ArrayList<AuthorGroup>();
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
        Author author;
        boolean successful = false;

        try {

            for (i = 0; i < this.authorsToAdd.size(); i++) {

                author = this.authorsToAdd.get(i);

                this.oldAuthorGroupOfAuthors.add(CurrentProject.getInstance().getFactoryDAO().getAuthorDAO().getAuthorGroup(author.getAuthorID()));

                successful = CurrentProject.getInstance().getFactoryDAO().getAuthorDAO().setAuthorGroup(author.getAuthorID(),
                        this.targetAuthorGroup.getAuthorGroupID(), true);
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
        AuthorGroup authorGroup;
        boolean successful = false;

        try {

            for (i = 0; i < this.authorsToAdd.size(); i++) {

                authorGroup = this.oldAuthorGroupOfAuthors.get(i);

                if (authorGroup != null) {

                    successful = CurrentProject.getInstance().getFactoryDAO().getAuthorDAO().setAuthorGroup(this.authorsToAdd.get(i).getAuthorID(),
                            authorGroup.getAuthorGroupID(), true);

                } else {

                    successful = CurrentProject.getInstance().getFactoryDAO().getAuthorDAO().setAuthorGroup(this.authorsToAdd.get(i).getAuthorID(), null, true);
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

        int i;
        boolean successful = false;

        try {

            for (i = 0; i < this.authorsToAdd.size(); i++) {

                successful = CurrentProject.getInstance().getFactoryDAO().getAuthorDAO().setAuthorGroup(this.authorsToAdd.get(i).getAuthorID(),
                        this.targetAuthorGroup.getAuthorGroupID(), true);
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
