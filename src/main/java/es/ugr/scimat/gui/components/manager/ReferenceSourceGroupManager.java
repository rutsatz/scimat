/*
 * ReferenceSourceGroupManager.java
 *
 * Created on 13-mar-2011, 17:17:26
 */
package es.ugr.scimat.gui.components.manager;

import es.ugr.scimat.gui.commands.edit.delete.DeleteReferenceSourceGroupEdit;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.adddialog.AddDialogManager;
import es.ugr.scimat.gui.components.globalslavepanel.ReferenceSourceGroupGlobalSlavePanel;
import es.ugr.scimat.gui.components.itemslist.ReferenceSourceGroupsListPanel;
import es.ugr.scimat.gui.components.joindialog.JoinEntitiesDialogManager;
import es.ugr.scimat.model.knowledgebase.entity.ReferenceSourceGroup;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class ReferenceSourceGroupManager extends GenericItemManagerPanel<ReferenceSourceGroup> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /***************************************************************************/
    /*                            Constructors                                 */

    /***************************************************************************/

    public ReferenceSourceGroupManager() {
        super(new ReferenceSourceGroupsListPanel(),
                new ReferenceSourceGroupGlobalSlavePanel());

        setMasterPanelTitle("Sources-reference group list");
        setSlavePanelTitle("Sources-reference group detail");
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     *
     */
    @Override
    public void addAction() {
        AddDialogManager.getInstance().showAddReferenceSourceGroupDialog();
    }

    /**
     *
     */
    @Override
    public void moveToAction(ArrayList<ReferenceSourceGroup> items) {
        JoinEntitiesDialogManager.getInstance().showReferenceSourceGroupsJoinDialog(items);
    }

    /**
     *
     */
    @Override
    public void removeAction(ArrayList<ReferenceSourceGroup> items) {
        (new PerformKnowledgeBaseEditTask(new DeleteReferenceSourceGroupEdit(items), this)).execute();
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
