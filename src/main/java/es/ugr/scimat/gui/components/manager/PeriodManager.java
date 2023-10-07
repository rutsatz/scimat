/*
 * PeriodManager.java
 *
 * Created on 13-mar-2011, 17:16:14
 */
package es.ugr.scimat.gui.components.manager;

import es.ugr.scimat.gui.commands.edit.delete.DeletePeriodEdit;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.adddialog.AddDialogManager;
import es.ugr.scimat.gui.components.globalslavepanel.PeriodGlobalSlavePanel;
import es.ugr.scimat.gui.components.itemslist.PeriodsListPanel;
import es.ugr.scimat.gui.components.joindialog.JoinEntitiesDialogManager;
import es.ugr.scimat.model.knowledgebase.entity.Period;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class PeriodManager extends GenericItemManagerPanel<Period> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /***************************************************************************/
    /*                            Constructors                                 */

    /***************************************************************************/

    public PeriodManager() {
        super(new PeriodsListPanel(),
                new PeriodGlobalSlavePanel());

        setMasterPanelTitle("Periods list");
        setSlavePanelTitle("Period detail");
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     *
     */
    @Override
    public void addAction() {
        AddDialogManager.getInstance().showAddPeriodDialog();
    }

    /**
     *
     */
    @Override
    public void moveToAction(ArrayList<Period> items) {
        JoinEntitiesDialogManager.getInstance().showPeriodsJoinDialog(items);
    }

    /**
     *
     */
    @Override
    public void removeAction(ArrayList<Period> items) {
        (new PerformKnowledgeBaseEditTask(new DeletePeriodEdit(items), this)).execute();
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
