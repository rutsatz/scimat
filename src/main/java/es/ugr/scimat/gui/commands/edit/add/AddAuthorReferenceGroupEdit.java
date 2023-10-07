/*
 * AddAuthorReferenceGroupEdit.java
 *
 * Created on 14-mar-2011, 17:39:51
 */
package es.ugr.scimat.gui.commands.edit.add;

import es.ugr.scimat.gui.commands.edit.KnowledgeBaseEdit;
import es.ugr.scimat.gui.undostack.UndoStack;
import es.ugr.scimat.knowledgebaseevents.KnowledgeBaseEventsReceiver;
import es.ugr.scimat.model.knowledgebase.entity.AuthorReferenceGroup;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

import javax.swing.undo.CannotUndoException;
import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class AddAuthorReferenceGroupEdit extends KnowledgeBaseEdit {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /**
     *
     */
    private Integer authorReferenceGroupID;

    /**
     *
     */
    private String groupName;

    /**
     *
     */
    private boolean stopGroup;

    /**
     * The elements added
     */
    private ArrayList<AuthorReferenceGroup> authorReferenceGroupsAdded;

    /***************************************************************************/
    /*                            Constructors                                 */

    /***************************************************************************/

    public AddAuthorReferenceGroupEdit(String groupName, boolean stopGroup) {
        super();

        this.groupName = groupName;
        this.stopGroup = stopGroup;
        this.authorReferenceGroupsAdded = new ArrayList<AuthorReferenceGroup>();
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

            if (this.groupName == null) {

                successful = false;
                this.errorMessage = "The name can not be null.";

            } else if (CurrentProject.getInstance().getFactoryDAO().getAuthorReferenceGroupDAO().checkAuthorReferenceGroup(groupName)) {

                successful = false;
                this.errorMessage = "An Author reference group yet exists with this name.";

            } else {

                this.authorReferenceGroupID = CurrentProject.getInstance().getFactoryDAO().getAuthorReferenceGroupDAO().addAuthorReferenceGroup(groupName, stopGroup, true);

                if (this.authorReferenceGroupID != null) {

                    CurrentProject.getInstance().getKnowledgeBase().commit();

                    this.authorReferenceGroupsAdded.add(CurrentProject.getInstance().getFactoryDAO().getAuthorReferenceGroupDAO().getAuthorReferenceGroup(authorReferenceGroupID));

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

            flag = CurrentProject.getInstance().getFactoryDAO().getAuthorReferenceGroupDAO().removeAuthorReferenceGroup(authorReferenceGroupID, true);

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

            flag = CurrentProject.getInstance().getFactoryDAO().getAuthorReferenceGroupDAO().addAuthorReferenceGroup(authorReferenceGroupID, groupName, stopGroup, true);

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
