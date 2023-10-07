/*
 * WordGroupManager.java
 *
 * Created on 13-mar-2011, 17:15:54
 */
package es.ugr.scimat.gui.components.manager;

import es.ugr.scimat.gui.commands.edit.delete.DeleteWordGroupEdit;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.adddialog.AddDialogManager;
import es.ugr.scimat.gui.components.globalslavepanel.WordGroupGlobalSlavePanel;
import es.ugr.scimat.gui.components.itemslist.WordGroupsListPanel;
import es.ugr.scimat.gui.components.joindialog.JoinEntitiesDialogManager;
import es.ugr.scimat.model.knowledgebase.entity.WordGroup;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class WordGroupManager extends GenericItemManagerPanel<WordGroup> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /***************************************************************************/
    /*                            Constructors                                 */

    /***************************************************************************/

    public WordGroupManager() {
        super(new WordGroupsListPanel(),
                new WordGroupGlobalSlavePanel());

        setMasterPanelTitle("Word groups list");
        setSlavePanelTitle("Word groups detail");
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     *
     */
    @Override
    public void addAction() {
        AddDialogManager.getInstance().showAddWordGroupDialog();
    }

    /**
     *
     */
    @Override
    public void moveToAction(ArrayList<WordGroup> items) {
        JoinEntitiesDialogManager.getInstance().showWordGroupsJoinDialog(items);
    }

    /**
     *
     */
    @Override
    public void removeAction(ArrayList<WordGroup> items) {
        (new PerformKnowledgeBaseEditTask(new DeleteWordGroupEdit(items), this)).execute();
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
