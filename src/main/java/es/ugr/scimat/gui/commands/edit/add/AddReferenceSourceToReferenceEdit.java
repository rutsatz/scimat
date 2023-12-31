/*
 * AddPublishDateToReferenceEdit.java
 *
 * Created on 25-may-2011, 18:30:11
 */
package es.ugr.scimat.gui.commands.edit.add;

import es.ugr.scimat.gui.commands.edit.KnowledgeBaseEdit;
import es.ugr.scimat.gui.undostack.UndoStack;
import es.ugr.scimat.knowledgebaseevents.KnowledgeBaseEventsReceiver;
import es.ugr.scimat.model.knowledgebase.dao.ReferenceDAO;
import es.ugr.scimat.model.knowledgebase.entity.Reference;
import es.ugr.scimat.model.knowledgebase.entity.ReferenceSource;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

import javax.swing.undo.CannotUndoException;

/**
 * @author mjcobo
 */
public class AddReferenceSourceToReferenceEdit extends KnowledgeBaseEdit {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    private Reference reference;
    private ReferenceSource referenceSource;
    private ReferenceSource oldReferenceSource;

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param reference
     * @param referenceSource
     */
    public AddReferenceSourceToReferenceEdit(Reference reference, ReferenceSource referenceSource) {
        this.reference = reference;
        this.referenceSource = referenceSource;
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
        ReferenceDAO referenceDAO;

        try {

            referenceDAO = CurrentProject.getInstance().getFactoryDAO().getReferenceDAO();

            this.oldReferenceSource = referenceDAO.getReferenceSource(this.reference.getReferenceID());

            if (this.referenceSource != null) {

                referenceDAO.setReferenceSource(reference.getReferenceID(),
                        this.referenceSource.getReferenceSourceID(), true);

            } else {

                referenceDAO.setReferenceSource(reference.getReferenceID(), null, true);
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
        ReferenceDAO referenceDAO;

        try {

            referenceDAO = CurrentProject.getInstance().getFactoryDAO().getReferenceDAO();

            if (this.oldReferenceSource != null) {

                referenceDAO.setReferenceSource(reference.getReferenceID(),
                        this.oldReferenceSource.getReferenceSourceID(), true);

            } else {

                referenceDAO.setReferenceSource(reference.getReferenceID(), null, true);
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
        ReferenceDAO referenceDAO;

        try {

            referenceDAO = CurrentProject.getInstance().getFactoryDAO().getReferenceDAO();

            if (this.referenceSource != null) {

                referenceDAO.setReferenceSource(reference.getReferenceID(),
                        this.referenceSource.getReferenceSourceID(), true);

            } else {

                referenceDAO.setReferenceSource(reference.getReferenceID(), null, true);
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
