/*
 * GenericJoinEntitiesDialog.java
 *
 * Created on 23-may-2011, 20:15:30
 */
package es.ugr.scimat.gui.components.joindialog;

import es.ugr.scimat.gui.components.itemslist.GenericItemsListPanel;
import es.ugr.scimat.gui.components.observer.SelectionObserver;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @param <E>
 * @author mjcobo
 */
public abstract class GenericJoinEntitiesDialog<E extends Comparable<E>>
        extends javax.swing.JDialog
        implements SelectionObserver {

    /**
     * Creates new form GenericJoinEntitiesDialog
     *
     * @param parent
     * @param itemListPanel
     */
    public GenericJoinEntitiesDialog(java.awt.Frame parent,
                                     GenericItemsListPanel<E> itemListPanel) {
        super(parent, true);

        this.itemListPanel = itemListPanel;
        this.itemListPanel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        initComponents();

        this.itemsPanel.add(this.itemListPanel);

        this.itemListPanel.addSelectionObserver(this);
    }

    /**
     *
     */
    public void reset() {

        this.targetItem = null;
        this.moveButton.setEnabled(false);
        this.itemListPanel.refreshItems(new ArrayList<E>());
        this.cancelled = false;
    }

    /**
     * @param items
     */
    public void refreshData(ArrayList<E> items) {

        this.targetItem = null;
        this.moveButton.setEnabled(false);
        this.itemListPanel.refreshItems(items);
        this.cancelled = false;
    }

    /**
     * @param selection
     */
    @Override
    public void selectionChangeHappened(int[] selection) {

        if (selection.length == 1) {

            this.targetItem = this.itemListPanel.getItem(selection[0]);
            this.moveButton.setEnabled(true);

        } else {

            reset();
        }
    }

    /**
     * @return
     */
    public boolean isCancelled() {
        return cancelled;
    }

    public ArrayList<E> getItems() {

        return this.itemListPanel.getItems();
    }

    /**
     * @param sourceItems
     * @param targetItem
     */
    public abstract void moveToAction(ArrayList<E> sourceItems, E targetItem);

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        itemsPanel = new javax.swing.JPanel();
        separator = new javax.swing.JSeparator();
        moveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Move to");

        itemsPanel.setLayout(new javax.swing.BoxLayout(itemsPanel, javax.swing.BoxLayout.LINE_AXIS));

        moveButton.setText("Move");
        moveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(itemsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                        .addComponent(separator, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(moveButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cancelButton)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(itemsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancelButton)
                                        .addComponent(moveButton))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param evt
     */
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.cancelled = true;
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * @param evt
     */
    private void moveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveButtonActionPerformed

        ArrayList<E> sourceItems = this.itemListPanel.getItems();

        sourceItems.remove(this.targetItem);

        moveToAction(sourceItems, targetItem);

        dispose();
    }//GEN-LAST:event_moveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel itemsPanel;
    private javax.swing.JButton moveButton;
    private javax.swing.JSeparator separator;
    // End of variables declaration//GEN-END:variables
    private final GenericItemsListPanel<E> itemListPanel;
    private E targetItem = null;
    private boolean cancelled;
}
