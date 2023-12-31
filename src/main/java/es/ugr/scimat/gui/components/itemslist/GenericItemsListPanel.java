/*
 * GenericItemsListPanel.java
 *
 * Created on 12-mar-2011, 19:39:54
 */
package es.ugr.scimat.gui.components.itemslist;

import es.ugr.scimat.gui.components.observer.ElementsCountObserver;
import es.ugr.scimat.gui.components.observer.SelectionObserver;
import es.ugr.scimat.gui.components.tablemodel.GenericTableModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;
import java.util.ArrayList;

/**
 * @param <E>
 * @author mjcobo
 */
public class GenericItemsListPanel<E>
        extends javax.swing.JPanel implements ElementsCountObserver {

    /**
     * Creates new form DocumentListPanel
     */
    public GenericItemsListPanel(GenericTableModel<E> tableModel) {

        this.tableModel = tableModel;
        this.tableRowSorter = new TableRowSorter<GenericTableModel<E>>(tableModel);

        this.tableModel.addElementsCountObserver(this);

        this.selectionObservers = new ArrayList<SelectionObserver>();
        this.selectedRows = new int[0];

        initComponents();

        this.table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {

                if (!e.getValueIsAdjusting()) {

                    notifySelectionObserver(table.getSelectedRows());
                }
            }
        });

        this.filterTextField.getDocument().addDocumentListener(new DocumentListener() {

            public void insertUpdate(DocumentEvent e) {
                enableFilterButton();
            }

            public void removeUpdate(DocumentEvent e) {
                enableFilterButton();
            }

            public void changedUpdate(DocumentEvent e) {
                enableFilterButton();
            }
        });
    }

    /**
     *
     */
    private void enableFilterButton() {

        if (this.filterTextField.getText().isEmpty()) {

            this.filterButton.doClick();
            this.filterButton.setEnabled(false);

        } else {

            this.filterButton.setEnabled(true);
        }
    }

    /**
     * @param rowIndex
     * @return
     */
    public E getItem(int rowIndex) {

        return this.tableModel.getItem(rowIndex);
    }

    /**
     *
     */
    public ArrayList<E> getItems() {
        return this.tableModel.getItems();
    }

    /**
     * @param rowIndexes
     * @return
     */
    public ArrayList<E> getSelectedItems() {

        int i;
        ArrayList<E> items = new ArrayList<E>();

        for (i = 0; i < this.selectedRows.length; i++) {

            items.add(getItem(this.selectedRows[i]));
        }

        return items;
    }

    /**
     * @return
     */
    public int[] getSelectedRows() {

        return this.selectedRows;
    }

    /**
     * @param items
     */
    public void refreshItems(ArrayList<E> items) {

        this.tableModel.refreshItems(items);
    }

    /**
     * @return
     */
    protected GenericTableModel<E> getTableModel() {

        return this.tableModel;
    }

    /**
     * @param o
     */
    public void addSelectionObserver(SelectionObserver o) {

        selectionObservers.add(o);
    }

    /**
     * @param selection
     */
    private void notifySelectionObserver(int[] selection) {

        int i;

        this.selectedRows = new int[selection.length];

        for (i = 0; i < selection.length; i++) {

            this.selectedRows[i] = table.convertRowIndexToModel(selection[i]);
        }

        for (i = 0; i < this.selectionObservers.size(); i++) {
            this.selectionObservers.get(i).selectionChangeHappened(this.selectedRows);
        }
    }

    /**
     * @param observer
     */
    public void addElementsCountObserver(ElementsCountObserver observer) {

        this.tableModel.addElementsCountObserver(observer);
    }

    /**
     * @param newElementsCount
     */
    public void elementsCountChanged(int newElementsCount) {
        this.itemsCountLabel.setText(String.valueOf(newElementsCount));
    }

    /**
     * Sets the table's selection mode to allow only single selections, a single
     * contiguous interval, or multiple intervals
     * <p>
     * The selection mode used by the row and column selection models:
     * SINGLE_SELECTION            ListSelectionModel.SINGLE_SELECTION
     * SINGLE_INTERVAL_SELECTION   ListSelectionModel.SINGLE_INTERVAL_SELECTION
     * MULTIPLE_INTERVAL_SELECTION ListSelectionModel.MULTIPLE_INTERVAL_SELECTION
     *
     * @see JList#setSelectionMode
     */
    public void setSelectionMode(int selection) {

        this.table.setSelectionMode(selection);
    }

    /**
     *
     */
    public void selectLastInsertedRow() {

        int position = this.table.convertRowIndexToView(this.tableModel.getRowCount() - 1);

        this.table.setRowSelectionInterval(position, position);
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPanel = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        filterDescriptionLabel = new javax.swing.JLabel();
        filterTextField = new javax.swing.JTextField();
        filterButton = new javax.swing.JButton();
        itemsCountDescriptionLabel = new javax.swing.JLabel();
        itemsCountLabel = new javax.swing.JLabel();

        table.setModel(this.tableModel);
        table.setRowSorter(this.tableRowSorter);
        scrollPanel.setViewportView(table);

        filterDescriptionLabel.setText("Filter:");

        filterButton.setText("Filter");
        filterButton.setEnabled(false);
        filterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtonActionPerformed(evt);
            }
        });

        itemsCountDescriptionLabel.setText("Items:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(filterDescriptionLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filterTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filterButton)
                                .addGap(4, 4, 4)
                                .addComponent(itemsCountDescriptionLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(itemsCountLabel)
                                .addGap(4, 4, 4))
                        .addComponent(scrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(scrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(filterDescriptionLabel)
                                        .addComponent(filterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(filterButton)
                                        .addComponent(itemsCountLabel)
                                        .addComponent(itemsCountDescriptionLabel)))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param evt
     */
    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterButtonActionPerformed

        // Si el usuario no ha introducido ningun filtro mostraremos
        // todos los registros.
        if (filterTextField.getText().isEmpty()) {

            tableRowSorter.setRowFilter(null);

        } else {

            try {

                tableRowSorter.setRowFilter(RowFilter.regexFilter(filterTextField.getText()));

            } catch (Exception e) {

                JOptionPane.showMessageDialog(this, "The filter expresion given is " +
                        "invalid.\nPlease give a valid filter expresion.", "Invalid " +
                        "filter expresion", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_filterButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton filterButton;
    private javax.swing.JLabel filterDescriptionLabel;
    private javax.swing.JTextField filterTextField;
    private javax.swing.JLabel itemsCountDescriptionLabel;
    private javax.swing.JLabel itemsCountLabel;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
    protected GenericTableModel<E> tableModel;
    private ArrayList<SelectionObserver> selectionObservers;
    private TableRowSorter<GenericTableModel<E>> tableRowSorter;
    private int[] selectedRows;
}
