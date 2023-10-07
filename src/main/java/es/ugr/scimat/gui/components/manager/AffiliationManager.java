/*
 * AffiliationManager.java
 *
 * Created on 13-mar-2011, 17:15:41
 */
package es.ugr.scimat.gui.components.manager;

import es.ugr.scimat.gui.commands.edit.delete.DeleteAffiliationEdit;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.adddialog.AddDialogManager;
import es.ugr.scimat.gui.components.globalslavepanel.AffiliationGlobalSlavePanel;
import es.ugr.scimat.gui.components.itemslist.AffiliationsListPanel;
import es.ugr.scimat.gui.components.joindialog.JoinEntitiesDialogManager;
import es.ugr.scimat.model.knowledgebase.entity.Affiliation;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class AffiliationManager extends GenericItemManagerPanel<Affiliation> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     *
     */
    public AffiliationManager() {
        super(new AffiliationsListPanel(),
                new AffiliationGlobalSlavePanel());

        setMasterPanelTitle("Affiliations list");
        setSlavePanelTitle("Affiliation detail");
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     *
     */
    @Override
    public void addAction() {
        AddDialogManager.getInstance().showAddAffiliationDialog();
    }

    /**
     * @param items
     */
    @Override
    public void moveToAction(ArrayList<Affiliation> items) {
        JoinEntitiesDialogManager.getInstance().showAffiliationsJoinDialog(items);
    }

    /**
     * @param items
     */
    @Override
    public void removeAction(ArrayList<Affiliation> items) {

        (new PerformKnowledgeBaseEditTask(new DeleteAffiliationEdit(items), this)).execute();
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
