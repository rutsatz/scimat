/*
 * SelectCouplingDocumentMappersPanel.java
 *
 * Created on 03-abr-2011, 20:01:58
 */
package es.ugr.scimat.gui.components.wizard.Analysis;

import es.ugr.scimat.gui.components.wizard.GenericWizardStepPanel;

/**
 *
 * @author mjcobo
 */
public class SelectCouplingDocumentMappersPanel extends GenericWizardStepPanel {

  /** Creates new form SelectDocumentMappersPanel */
  public SelectCouplingDocumentMappersPanel() {
    initComponents();
  }

  @Override
  public void refresh() {

    this.mapperCheckBox.setSelected(false);
  }

  @Override
  public void fireIncorrectDataObservers() {

    if (this.mapperCheckBox.isSelected()) {

      notifyIncorrectDataObservers(true, "");

    } else {

      notifyIncorrectDataObservers(false, "A document mapper must be selected");
    }
  }

  /**
   * 
   * @return
   */
  public boolean isSelectedBasicCouplingDocumentMapper() {

    return this.mapperCheckBox.isSelected();
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    mapperCheckBox = new javax.swing.JCheckBox();

    mapperCheckBox.setText("Basic coupling document mapper");
    mapperCheckBox.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mapperCheckBoxActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(mapperCheckBox)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(mapperCheckBox)
    );
  }// </editor-fold>//GEN-END:initComponents

  /**
   * 
   * @param evt
   */
  private void mapperCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mapperCheckBoxActionPerformed
    fireIncorrectDataObservers();
  }//GEN-LAST:event_mapperCheckBoxActionPerformed
  
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JCheckBox mapperCheckBox;
  // End of variables declaration//GEN-END:variables
  
}