/*
 * AuthorReferenceGroupManager.java
 *
 * Created on 13-mar-2011, 17:16:59
 */
package es.ugr.scimat.gui.components.manager;

import es.ugr.scimat.gui.commands.edit.delete.DeleteAuthorReferenceGroupEdit;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.adddialog.AddDialogManager;
import es.ugr.scimat.gui.components.globalslavepanel.AuthorReferenceGroupGlobalSlavePanel;
import es.ugr.scimat.gui.components.itemslist.AuthorReferenceGroupsListPanel;
import es.ugr.scimat.gui.components.joindialog.JoinEntitiesDialogManager;
import es.ugr.scimat.model.knowledgebase.entity.AuthorReferenceGroup;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class AuthorReferenceGroupManager extends GenericItemManagerPanel<AuthorReferenceGroup> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /***************************************************************************/
    /*                            Constructors                                 */

    /***************************************************************************/

    public AuthorReferenceGroupManager() {
        super(new AuthorReferenceGroupsListPanel(),
                new AuthorReferenceGroupGlobalSlavePanel());

        setMasterPanelTitle("Author reference groups list");
        setSlavePanelTitle("Author reference group detail");
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     *
     */
    @Override
    public void addAction() {
        AddDialogManager.getInstance().showAddAuthorReferenceGroupDialog();
    }

    /**
     *
     */
    @Override
    public void moveToAction(ArrayList<AuthorReferenceGroup> items) {
        JoinEntitiesDialogManager.getInstance().showAuthorReferenceGroupsJoinDialog(items);
    }

    /**
     *
     */
    @Override
    public void removeAction(ArrayList<AuthorReferenceGroup> items) {
        (new PerformKnowledgeBaseEditTask(new DeleteAuthorReferenceGroupEdit(items), this)).execute();
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
