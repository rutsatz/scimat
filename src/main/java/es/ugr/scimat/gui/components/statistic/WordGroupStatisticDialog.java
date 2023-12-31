/*
 * WordGroupStatisticDialog.java
 *
 * Created on 26-ene-2012, 12:56:54
 */
package es.ugr.scimat.gui.components.statistic;

import es.ugr.scimat.gui.components.ErrorDialogManager;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class WordGroupStatisticDialog extends GenericStatisticDialog {


    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/
    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param parent
     */
    public WordGroupStatisticDialog(Frame parent) {
        super(parent, "Word groups statistics");
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @param periodID
     * @return
     */
    @Override
    public int getUniqueGroups(Integer periodID) {

        int result;

        try {

            result = CurrentProject.getInstance().getFactoryDAO().getStatisticDAO().getUniqueWordGroupsCount(periodID);

        } catch (KnowledgeBaseException e) {

            result = 0;

            ErrorDialogManager.getInstance().showException(e);
        }

        return result;
    }

    /**
     * @param periodID
     * @return
     */
    @Override
    public ArrayList<Integer> retrieveStatistic(Integer periodID) {

        ArrayList<Integer> freqs;

        try {

            freqs = CurrentProject.getInstance().getFactoryDAO().getStatisticDAO().getWordGroupsCountPerDocument(periodID);

        } catch (KnowledgeBaseException e) {

            freqs = new ArrayList<Integer>();

            ErrorDialogManager.getInstance().showException(e);
        }

        return freqs;
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
