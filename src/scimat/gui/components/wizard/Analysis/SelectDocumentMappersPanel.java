/*
 * SelectDocumentMappersPanel.java
 *
 * Created on 03-abr-2011, 20:01:58
 */
package scimat.gui.components.wizard.Analysis;

import scimat.gui.components.wizard.GenericWizardStepPanel;

/**
 *
 * @author mjcobo
 */
public class SelectDocumentMappersPanel extends GenericWizardStepPanel {

  /** Creates new form SelectDocumentMappersPanel */
  public SelectDocumentMappersPanel() {
    initComponents();
  }

  @Override
  public void refresh() {

    this.documentMappersSelected = 0;

    this.coreMapperCheckBox.setSelected(false);
    this.intersectionMapperCheckBox.setSelected(false);
    this.kCoreMapperCheckBox.setSelected(false);
    this.kSpinner.setEnabled(false);
    this.secondaryMapperCheckBox.setSelected(false);
    this.unionMapperCheckBox.setSelected(false);
  }

  /**
   * 
   */
  @Override
  public void fireIncorrectDataObservers() {

    if (this.documentMappersSelected > 0) {

      notifyIncorrectDataObservers(true, "");

    } else {

      notifyIncorrectDataObservers(false, "A set of document mappers must be selected");
    }
  }

  /**
   *
   * @return true if the mapper is selected.
   */
  public boolean isCoreMapperSelected() {

    return this.coreMapperCheckBox.isSelected();
  }

  /**
   *
   * @return true if the mapper is selected.
   */
  public boolean isIntersectionMapperSelected() {

    return this.intersectionMapperCheckBox.isSelected();
  }

  /**
   *
   * @return true if the mapper is selected.
   */
  public boolean isKCoreMapperSelected() {

    return this.kCoreMapperCheckBox.isSelected();
  }

  /**
   *
   * @return the selected k-core
   */
  public int getKCore() {

    return (Integer)this.kSpinner.getModel().getValue();
  }

  /**
   *
   * @return true if the mapper is selected.
   */
  public boolean isSecondaryMapperSelected() {

    return this.secondaryMapperCheckBox.isSelected();
  }

  /**
   *
   * @return true if the mapper is selected.
   */
  public boolean isUnionMapperSelected() {

    return this.unionMapperCheckBox.isSelected();
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    coreMapperCheckBox = new javax.swing.JCheckBox();
    intersectionMapperCheckBox = new javax.swing.JCheckBox();
    kCoreMapperCheckBox = new javax.swing.JCheckBox();
    kDescriptionLabel = new javax.swing.JLabel();
    kSpinner = new javax.swing.JSpinner();
    secondaryMapperCheckBox = new javax.swing.JCheckBox();
    unionMapperCheckBox = new javax.swing.JCheckBox();

    coreMapperCheckBox.setText("Core mapper");
    coreMapperCheckBox.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        coreMapperCheckBoxActionPerformed(evt);
      }
    });

    intersectionMapperCheckBox.setText("Intersection mapper");
    intersectionMapperCheckBox.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        intersectionMapperCheckBoxActionPerformed(evt);
      }
    });

    kCoreMapperCheckBox.setText("K-core mapper");
    kCoreMapperCheckBox.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        kCoreMapperCheckBoxActionPerformed(evt);
      }
    });

    kDescriptionLabel.setText("K:");

    kSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
    kSpinner.setEnabled(false);

    secondaryMapperCheckBox.setText("Secondary mapper");
    secondaryMapperCheckBox.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        secondaryMapperCheckBoxActionPerformed(evt);
      }
    });

    unionMapperCheckBox.setText("Union mapper");
    unionMapperCheckBox.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        unionMapperCheckBoxActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(coreMapperCheckBox)
      .addComponent(intersectionMapperCheckBox)
      .addComponent(kCoreMapperCheckBox)
      .addGroup(layout.createSequentialGroup()
        .addGap(21, 21, 21)
        .addComponent(kDescriptionLabel)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(kSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
      .addComponent(secondaryMapperCheckBox)
      .addComponent(unionMapperCheckBox)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(coreMapperCheckBox)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(intersectionMapperCheckBox)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(kCoreMapperCheckBox)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(kDescriptionLabel)
          .addComponent(kSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(secondaryMapperCheckBox)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(unionMapperCheckBox))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void kCoreMapperCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kCoreMapperCheckBoxActionPerformed

    if (this.kCoreMapperCheckBox.isSelected()) {

      this.documentMappersSelected ++;
      this.kSpinner.setEnabled(true);

    } else {

      this.documentMappersSelected --;
      this.kSpinner.setEnabled(false);
    }

    fireIncorrectDataObservers();
  }//GEN-LAST:event_kCoreMapperCheckBoxActionPerformed

  /**
   * 
   * @param evt
   */
  private void coreMapperCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coreMapperCheckBoxActionPerformed
    
    if (this.coreMapperCheckBox.isSelected()) {

      this.documentMappersSelected ++;
      
    } else {
      
      this.documentMappersSelected --;
    }

    fireIncorrectDataObservers();
  }//GEN-LAST:event_coreMapperCheckBoxActionPerformed

  /**
   *
   * @param evt
   */
  private void intersectionMapperCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intersectionMapperCheckBoxActionPerformed

    if (this.intersectionMapperCheckBox.isSelected()) {

      this.documentMappersSelected ++;

    } else {

      this.documentMappersSelected --;
    }

    fireIncorrectDataObservers();
  }//GEN-LAST:event_intersectionMapperCheckBoxActionPerformed

  /**
   *
   * @param evt
   */
  private void secondaryMapperCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secondaryMapperCheckBoxActionPerformed

    if (this.secondaryMapperCheckBox.isSelected()) {

      this.documentMappersSelected ++;

    } else {

      this.documentMappersSelected --;
    }

    fireIncorrectDataObservers();
  }//GEN-LAST:event_secondaryMapperCheckBoxActionPerformed

  /**
   *
   * @param evt
   */
  private void unionMapperCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unionMapperCheckBoxActionPerformed

    if (this.unionMapperCheckBox.isSelected()) {

      this.documentMappersSelected ++;

    } else {

      this.documentMappersSelected --;
    }

    fireIncorrectDataObservers();
  }//GEN-LAST:event_unionMapperCheckBoxActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JCheckBox coreMapperCheckBox;
  private javax.swing.JCheckBox intersectionMapperCheckBox;
  private javax.swing.JCheckBox kCoreMapperCheckBox;
  private javax.swing.JLabel kDescriptionLabel;
  private javax.swing.JSpinner kSpinner;
  private javax.swing.JCheckBox secondaryMapperCheckBox;
  private javax.swing.JCheckBox unionMapperCheckBox;
  // End of variables declaration//GEN-END:variables
  private int documentMappersSelected = 0;
}