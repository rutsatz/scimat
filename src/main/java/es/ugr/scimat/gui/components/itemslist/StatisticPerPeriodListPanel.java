/*
 * StatisticPerPeriodListPanel.java
 *
 * Created on 25-ene-2012, 19:05:22
 */
package es.ugr.scimat.gui.components.itemslist;

import es.ugr.scimat.gui.components.tablemodel.StatisticPerPeriodTableModel;
import es.ugr.scimat.model.statistic.entity.StatisticPerPeriod;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class StatisticPerPeriodListPanel extends GenericItemsListPanel<StatisticPerPeriod> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /**
     *
     */
    public StatisticPerPeriodListPanel() {
        super(new StatisticPerPeriodTableModel());
    }

    /***************************************************************************/
    /*                            Constructors                                 */

    /***************************************************************************/

    @Override
    public void refreshItems(ArrayList<StatisticPerPeriod> items) {
        super.refreshItems(items);
    }
    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/


    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
