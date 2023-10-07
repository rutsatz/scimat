/*
 * AddJournalEdit.java
 *
 * Created on 14-mar-2011, 17:38:03
 */
package es.ugr.scimat.gui.commands.edit.add;

import es.ugr.scimat.gui.commands.edit.KnowledgeBaseEdit;
import es.ugr.scimat.gui.undostack.UndoStack;
import es.ugr.scimat.knowledgebaseevents.KnowledgeBaseEventsReceiver;
import es.ugr.scimat.model.knowledgebase.entity.Journal;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

import javax.swing.undo.CannotUndoException;
import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class AddJournalEdit extends KnowledgeBaseEdit {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /**
     *
     */
    private Integer journalID;

    /**
     *
     */
    private String source;

    /**
     *
     */
    private String conferenceInformation;

    /**
     * The elements added
     */
    private ArrayList<Journal> journalsAdded;

    /***************************************************************************/
    /*                            Constructors                                 */

    /***************************************************************************/

    public AddJournalEdit(String source, String conferenceInformation) {
        super();

        this.source = source;
        this.conferenceInformation = conferenceInformation;
        this.journalsAdded = new ArrayList<Journal>();
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

            if (this.source == null) {

                successful = false;
                this.errorMessage = "The source can not be null.";

            } else if (CurrentProject.getInstance().getFactoryDAO().getJournalDAO().checkJournal(source)) {

                successful = false;
                this.errorMessage = "A journal yet exists with this source.";

            } else {

                this.journalID = CurrentProject.getInstance().getFactoryDAO().getJournalDAO().addJournal(source, conferenceInformation, true);

                if (this.journalID != null) {

                    CurrentProject.getInstance().getKnowledgeBase().commit();

                    this.journalsAdded.add(CurrentProject.getInstance().getFactoryDAO().getJournalDAO().getJournal(journalID));

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

            flag = CurrentProject.getInstance().getFactoryDAO().getJournalDAO().removeJournal(journalID, true);

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

            flag = CurrentProject.getInstance().getFactoryDAO().getJournalDAO().addJournal(journalID, source, conferenceInformation, true);

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
