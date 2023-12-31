/*
 * KnowledgeBaseEdit.java
 *
 * Created on 14-mar-2011, 17:18:26
 */
package es.ugr.scimat.gui.commands.edit;

import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;

import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotUndoException;

/**
 * @author mjcobo
 */
public abstract class KnowledgeBaseEdit extends AbstractUndoableEdit {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /**
     *
     */
    protected String errorMessage;

    /***************************************************************************/
    /*                            Constructors                                 */

    /***************************************************************************/

    public KnowledgeBaseEdit() {
        super();

        this.errorMessage = "";
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @return
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     *
     */
    public abstract boolean execute() throws KnowledgeBaseException;

    /**
     * @throws CannotUndoException
     */
    @Override
    public void undo() throws CannotUndoException {
        super.undo();
    }

    /**
     * @throws CannotUndoException
     */
    @Override
    public void redo() throws CannotUndoException {
        super.redo();
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
