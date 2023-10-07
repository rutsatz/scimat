/*
 * ClusterTableModel.java
 *
 * Created on 05-abr-2011, 13:27:43
 */
package es.ugr.scimat.gui.components.tablemodel;

import es.ugr.scimat.api.mapping.Node;
import es.ugr.scimat.api.utils.property.Property;
import es.ugr.scimat.analysis.KeyProperties;

/**
 *
 * @author mjcobo
 */
public class NodeTableModel extends GenericTableModel<Node> {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  public NodeTableModel() {
    super(new String[] {"Name", "Documents"});
  }

  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   * 
   * @param rowIndex
   * @param columnIndex
   * @return
   */
  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {

    if ((rowIndex >= 0) && (rowIndex < getRowCount())) {

      Property property;

      switch (columnIndex) {

        case 0:

          property = getItem(rowIndex).getProperties().getProperty(KeyProperties.__KEY_NODE_LABEL);

          return (property != null) ? property.toString() : "";

        case 1:

          property = getItem(rowIndex).getProperties().getProperty(KeyProperties.__KEY_NODE_FREQUENCY);

          return (property != null) ? property.getValue() : "";
          
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
