/*
 * PeriodsInAnalysisTableModel.java
 *
 * Created on 13-mar-2011, 17:19:30
 */
package es.ugr.scimat.gui.components.tablemodel;

import es.ugr.scimat.model.knowledgebase.entity.Period;

/**
 * @author mjcobo
 */
public class PeriodsInAnalysisTableModel extends GenericDynamicTableModel<Period> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     *
     */
    public PeriodsInAnalysisTableModel() {
        super(new String[]{"ID", "Name", "Position"});
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        if ((rowIndex >= 0) && (rowIndex < getRowCount())) {

            Period period = getItem(rowIndex);

            switch (columnIndex) {

                case 0:
                    return period.getPeriodID();

                case 1:
                    return period.getName();

                case 2:
                    return period.getPosition();

                default:
                    return "";
            }

        } else {

            return "";

        }
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
