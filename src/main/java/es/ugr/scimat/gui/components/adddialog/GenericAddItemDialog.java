/*
 * GenericAddItemDialog.java
 *
 * Created on 26-may-2011, 18:53:29
 */
package es.ugr.scimat.gui.components.adddialog;

import java.util.ArrayList;

import es.ugr.scimat.gui.components.itemslist.GenericSelectOneItemPanel;
import es.ugr.scimat.gui.components.observer.TargetItemSelectedObserver;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.observer.EntityObserver;

/**
 *
 * @author mjcobo
 */
public abstract class GenericAddItemDialog<M extends Comparable<M>, I extends Comparable<I>>
        extends javax.swing.JDialog implements TargetItemSelectedObserver, EntityObserver<I> {

  /** Creates new form GenericAddItemsDialog */
  public GenericAddItemDialog(java.awt.Frame parent, GenericSelectOneItemPanel<I> genericSelectOneItemPanel) {
    super(parent, true);

    this.oneItemPanel = genericSelectOneItemPanel;

    initComponents();

    this.itemsPanel.add(this.oneItemPanel);
    this.oneItemPanel.addTargetItemSelectedObserver(this);

  }

  /**
   * 
   */
  public void reset() {

    this.masterItem = null;
    this.setButton.setEnabled(false);
    this.oneItemPanel.refreshSourceItems(new ArrayList<I>());
  }

  /**
   * 
   * @param items 
   */
  public void refreshData(M masterItem, ArrayList<I> items) {

    this.masterItem = masterItem;
    this.oneItemPanel.refreshSourceItems(items);
    this.setButton.setEnabled(false);
  }

  /**
   * 
   * @param masterItem
   * @param itemToAdd 
   */
  public abstract void addAction(M masterItem, I itemToAdd);

  /**
   * 
   */
  public abstract void addNewItemAction();

  public abstract void setEntityObserver(boolean enabled);

  /**
   * 
   * @param items
   * @throws KnowledgeBaseException
   */
  public void entityAdded(ArrayList<I> items) throws KnowledgeBaseException {

    this.oneItemPanel.addNewSourceItem(items);
  }

  /**
   * 
   * @param items
   * @throws KnowledgeBaseException 
   */
  public void entityUpdated(ArrayList<I> items) throws KnowledgeBaseException {
  }

  /**
   * 
   * @throws KnowledgeBaseException 
   */
  public void entityRefresh() throws KnowledgeBaseException {
  }

  /**
   * 
   * @param items
   * @throws KnowledgeBaseException 
   */
  public void entityRemoved(ArrayList<I> items) throws KnowledgeBaseException {
  }

  /**
   * 
   */
  public void targetItemSelectionChanged(boolean selected) {

    this.setButton.setEnabled(selected);
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        itemsPanel = new javax.swing.JPanel();
        separator = new javax.swing.JSeparator();
        setButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        newItemButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        itemsPanel.setLayout(new javax.swing.BoxLayout(itemsPanel, javax.swing.BoxLayout.LINE_AXIS));

        setButton.setText("Set");
        setButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        newItemButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add-icon-16x16.png"))); // NOI18N
        newItemButton.setToolTipText("New item");
        newItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newItemButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(separator, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(itemsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(newItemButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
                        .addComponent(setButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(itemsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(setButton)
                        .addComponent(cancelButton))
                    .addComponent(newItemButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  /**
   * 
   * @param evt 
   */
  private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
    dispose();
  }//GEN-LAST:event_cancelButtonActionPerformed

  /**
   * 
   * @param evt 
   */
  private void setButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setButtonActionPerformed

    addAction(this.masterItem, this.oneItemPanel.getSelectedItem());
  }//GEN-LAST:event_setButtonActionPerformed

  /**
   * 
   * @param evt 
   */
  private void newItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newItemButtonActionPerformed

    addNewItemAction();   }//GEN-LAST:event_newItemButtonActionPerformed

  /**
   * 
   * @param evt 
   */
  private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    setEntityObserver(false);
  }//GEN-LAST:event_formWindowClosed

  private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    setEntityObserver(true);
  }//GEN-LAST:event_formWindowActivated
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel itemsPanel;
    private javax.swing.JButton newItemButton;
    private javax.swing.JSeparator separator;
    private javax.swing.JButton setButton;
    // End of variables declaration//GEN-END:variables
  private M masterItem;
  private GenericSelectOneItemPanel<I> oneItemPanel;
}