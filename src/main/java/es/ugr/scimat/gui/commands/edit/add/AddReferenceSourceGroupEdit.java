/*
 * AddReferenceSourceGroupEdit.java
 *
 * Created on 14-mar-2011, 17:40:35
 */
package es.ugr.scimat.gui.commands.edit.add;

import es.ugr.scimat.gui.commands.edit.KnowledgeBaseEdit;
import es.ugr.scimat.gui.undostack.UndoStack;
import es.ugr.scimat.knowledgebaseevents.KnowledgeBaseEventsReceiver;
import es.ugr.scimat.model.knowledgebase.entity.ReferenceSourceGroup;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

import javax.swing.undo.CannotUndoException;
import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class AddReferenceSourceGroupEdit extends KnowledgeBaseEdit {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /**
     *
     */
    private Integer referenceSourceGroupID;

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
    private ArrayList<ReferenceSourceGroup> referenceSourceGroupsAdded;

    /***************************************************************************/
    /*                            Constructors                                 */

    /***************************************************************************/

    public AddReferenceSourceGroupEdit(String groupName, boolean stopGroup) {
        super();

        this.groupName = groupName;
        this.stopGroup = stopGroup;
        this.referenceSourceGroupsAdded = new ArrayList<ReferenceSourceGroup>();
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

            } else if (CurrentProject.getInstance().getFactoryDAO().getReferenceSourceGroupDAO().checkReferenceSourceGroup(groupName)) {

                successful = false;
                this.errorMessage = "A Reference source group yet exists with this name.";

            } else {

                this.referenceSourceGroupID = CurrentProject.getInstance().getFactoryDAO().getReferenceSourceGroupDAO().addReferenceSourceGroup(groupName, stopGroup, true);

                if (this.referenceSourceGroupID != null) {

                    CurrentProject.getInstance().getKnowledgeBase().commit();

                    this.referenceSourceGroupsAdded.add(CurrentProject.getInstance().getFactoryDAO().getReferenceSourceGroupDAO().getReferenceSourceGroup(referenceSourceGroupID));

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

            flag = CurrentProject.getInstance().getFactoryDAO().getReferenceSourceGroupDAO().removeReferenceSourceGroup(referenceSourceGroupID, true);

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

            flag = CurrentProject.getInstance().getFactoryDAO().getReferenceSourceGroupDAO().addReferenceSourceGroup(referenceSourceGroupID, groupName, stopGroup, true);

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
