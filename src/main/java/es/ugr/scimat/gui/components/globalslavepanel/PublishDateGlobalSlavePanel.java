/*
 * PublishDateGlobalSlavePanel.java
 *
 * Created on 13-mar-2011, 17:11:31
 */
package es.ugr.scimat.gui.components.globalslavepanel;

import javax.swing.JOptionPane;

import es.ugr.scimat.gui.commands.edit.update.UpdatePublishDateEdit;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.HideAndShowPanel;
import es.ugr.scimat.gui.components.detailspanel.PublishDateDetailPanel;
import es.ugr.scimat.gui.components.slavepanel.PublishDateSlaveDocumentsPanel;
import es.ugr.scimat.gui.components.slavepanel.PublishDateSlaveJournalSubjectCategoryPublishDatePanel;
import es.ugr.scimat.gui.components.slavepanel.PublishDateSlavePeriodsPanel;
import es.ugr.scimat.model.knowledgebase.entity.PublishDate;

/**
 *
 * @author mjcobo
 */
public class PublishDateGlobalSlavePanel extends GlobalSlavePanel<PublishDate> {

  /** Creates new form PublishDateGlobalSlavePanel */
  public PublishDateGlobalSlavePanel() {
    initComponents();
  }

  @Override
  public void refresh(PublishDate item) {

    setMasterItem(item);

    this.publishDatesDetailPanel.refreshItem(item);
    this.publishDateSlaveDocumentsPanel.setMasterItem(item);
    this.publishDateSlaveJournalSubjectCategoryPublishDatePanel.setMasterItem(item);
    this.publishDateSlavePeriodsPanel.setMasterItem(item);

    if (item != null) {

      
      this.updatePublishDateButton.setEnabled(true);

    } else {
      
      this.updatePublishDateButton.setEnabled(false);

    }
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    hideAndShowPublishDatePanel = new HideAndShowPanel();
    publishDateInfoPanel = new javax.swing.JPanel();
    updatePublishDateButton = new javax.swing.JButton();
    publishDatesDetailPanel = new PublishDateDetailPanel();
    hideAndShowDocumentPanel = new HideAndShowPanel();
    documentInfoPanel = new javax.swing.JPanel();
    publishDateSlaveDocumentsPanel = new PublishDateSlaveDocumentsPanel();
    hideAndShowSubjectCategoryPanel = new HideAndShowPanel();
    subjectCategoryInfoPanel = new javax.swing.JPanel();
    publishDateSlaveJournalSubjectCategoryPublishDatePanel = new PublishDateSlaveJournalSubjectCategoryPublishDatePanel();
    hideAndShowPeriodPanel = new HideAndShowPanel();
    periodInfoPanel = new javax.swing.JPanel();
    publishDateSlavePeriodsPanel = new PublishDateSlavePeriodsPanel();

    this.hideAndShowPublishDatePanel.setDescription("Publish date info");
    this.hideAndShowPublishDatePanel.setPanel(this.publishDateInfoPanel);

    updatePublishDateButton.setText("Update");
    updatePublishDateButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        updatePublishDateButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout publishDateInfoPanelLayout = new javax.swing.GroupLayout(publishDateInfoPanel);
    publishDateInfoPanel.setLayout(publishDateInfoPanelLayout);
    publishDateInfoPanelLayout.setHorizontalGroup(
      publishDateInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, publishDateInfoPanelLayout.createSequentialGroup()
        .addContainerGap(313, Short.MAX_VALUE)
        .addComponent(updatePublishDateButton))
      .addComponent(publishDatesDetailPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
    );
    publishDateInfoPanelLayout.setVerticalGroup(
      publishDateInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, publishDateInfoPanelLayout.createSequentialGroup()
        .addComponent(publishDatesDetailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(updatePublishDateButton))
    );

    this.hideAndShowDocumentPanel.setDescription("Documents info");
    this.hideAndShowDocumentPanel.setPanel(this.documentInfoPanel);

    javax.swing.GroupLayout documentInfoPanelLayout = new javax.swing.GroupLayout(documentInfoPanel);
    documentInfoPanel.setLayout(documentInfoPanelLayout);
    documentInfoPanelLayout.setHorizontalGroup(
      documentInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(publishDateSlaveDocumentsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
    );
    documentInfoPanelLayout.setVerticalGroup(
      documentInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(publishDateSlaveDocumentsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
    );

    this.hideAndShowSubjectCategoryPanel.setDescription("Subject Categories info");
    this.hideAndShowSubjectCategoryPanel.setPanel(this.subjectCategoryInfoPanel);

    javax.swing.GroupLayout subjectCategoryInfoPanelLayout = new javax.swing.GroupLayout(subjectCategoryInfoPanel);
    subjectCategoryInfoPanel.setLayout(subjectCategoryInfoPanelLayout);
    subjectCategoryInfoPanelLayout.setHorizontalGroup(
      subjectCategoryInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(publishDateSlaveJournalSubjectCategoryPublishDatePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
    );
    subjectCategoryInfoPanelLayout.setVerticalGroup(
      subjectCategoryInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(publishDateSlaveJournalSubjectCategoryPublishDatePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
    );

    this.hideAndShowPeriodPanel.setDescription("Periods info");
    this.hideAndShowPeriodPanel.setPanel(this.periodInfoPanel);

    javax.swing.GroupLayout periodInfoPanelLayout = new javax.swing.GroupLayout(periodInfoPanel);
    periodInfoPanel.setLayout(periodInfoPanelLayout);
    periodInfoPanelLayout.setHorizontalGroup(
      periodInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(publishDateSlavePeriodsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
    );
    periodInfoPanelLayout.setVerticalGroup(
      periodInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(publishDateSlavePeriodsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(periodInfoPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(subjectCategoryInfoPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(documentInfoPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(publishDateInfoPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(hideAndShowPublishDatePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
          .addComponent(hideAndShowDocumentPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
          .addComponent(hideAndShowSubjectCategoryPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
          .addComponent(hideAndShowPeriodPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(hideAndShowPublishDatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(publishDateInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(hideAndShowDocumentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(documentInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(hideAndShowSubjectCategoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(subjectCategoryInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(hideAndShowPeriodPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(periodInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents

  private void updatePublishDateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePublishDateButtonActionPerformed

    PerformKnowledgeBaseEditTask task;

    if (this.publishDatesDetailPanel.getYear().isEmpty()) {

      JOptionPane.showMessageDialog(this, "You have to give a year.\nPlease, " +
        "give a year for the publish date.", "Invalid year", JOptionPane.ERROR_MESSAGE);

    } else if (this.publishDatesDetailPanel.getDate().isEmpty()) {

      JOptionPane.showMessageDialog(this, "You have to give a date.\nPlease, " +
        "give a date for the publish date.", "Invalid date", JOptionPane.ERROR_MESSAGE);

    } else {

      task = new PerformKnowledgeBaseEditTask(new UpdatePublishDateEdit(getMasterItem().getPublishDateID(),
              this.publishDatesDetailPanel.getYear(),
              this.publishDatesDetailPanel.getDate()), this);

      task.execute();
    }
  }//GEN-LAST:event_updatePublishDateButtonActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel documentInfoPanel;
  private HideAndShowPanel hideAndShowDocumentPanel;
  private HideAndShowPanel hideAndShowPeriodPanel;
  private HideAndShowPanel hideAndShowPublishDatePanel;
  private HideAndShowPanel hideAndShowSubjectCategoryPanel;
  private javax.swing.JPanel periodInfoPanel;
  private javax.swing.JPanel publishDateInfoPanel;
  private PublishDateSlaveDocumentsPanel publishDateSlaveDocumentsPanel;
  private PublishDateSlaveJournalSubjectCategoryPublishDatePanel publishDateSlaveJournalSubjectCategoryPublishDatePanel;
  private PublishDateSlavePeriodsPanel publishDateSlavePeriodsPanel;
  private PublishDateDetailPanel publishDatesDetailPanel;
  private javax.swing.JPanel subjectCategoryInfoPanel;
  private javax.swing.JButton updatePublishDateButton;
  // End of variables declaration//GEN-END:variables
}