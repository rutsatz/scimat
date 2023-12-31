/*
 * SubjectCategoryGlobalSlavePanel.java
 *
 * Created on 13-mar-2011, 17:11:54
 */
package es.ugr.scimat.gui.components.globalslavepanel;

import es.ugr.scimat.gui.commands.edit.update.UpdateSubjectCategoryEdit;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.HideAndShowPanel;
import es.ugr.scimat.gui.components.detailspanel.SubjectCategoryDetailPanel;
import es.ugr.scimat.gui.components.slavepanel.SubjectCategorySlaveJournalSubjectCategoryPublishDatePanel;
import es.ugr.scimat.model.knowledgebase.entity.SubjectCategory;

import javax.swing.*;

/**
 * @author mjcobo
 */
public class SubjectCategoryGlobalSlavePanel extends GlobalSlavePanel<SubjectCategory> {

    /**
     * Creates new form SubjectCategoryGlobalSlavePanel
     */
    public SubjectCategoryGlobalSlavePanel() {
        initComponents();
    }

    @Override
    public void refresh(SubjectCategory item) {

        setMasterItem(item);

        this.subjectCategoryDetailPanel.refreshItem(item);
        this.subjectCategorySlaveJournalSubjectCategoryPublishDatePanel.setMasterItem(item);

        if (item != null) {

            this.updateSubjectCategoryButton.setEnabled(true);

        } else {

            this.updateSubjectCategoryButton.setEnabled(false);

        }
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

        hideAndShowSubjectCategoryPanel = new HideAndShowPanel();
        subjectCategoryInfoPanel = new javax.swing.JPanel();
        updateSubjectCategoryButton = new javax.swing.JButton();
        subjectCategoryDetailPanel = new SubjectCategoryDetailPanel();
        hideAndShowJournalPanel = new HideAndShowPanel();
        journalInfoPanel = new javax.swing.JPanel();
        subjectCategorySlaveJournalSubjectCategoryPublishDatePanel = new SubjectCategorySlaveJournalSubjectCategoryPublishDatePanel();

        this.hideAndShowSubjectCategoryPanel.setDescription("Subject category info");
        this.hideAndShowSubjectCategoryPanel.setPanel(this.subjectCategoryInfoPanel);

        updateSubjectCategoryButton.setText("Update");
        updateSubjectCategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSubjectCategoryButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout subjectCategoryInfoPanelLayout = new javax.swing.GroupLayout(subjectCategoryInfoPanel);
        subjectCategoryInfoPanel.setLayout(subjectCategoryInfoPanelLayout);
        subjectCategoryInfoPanelLayout.setHorizontalGroup(
                subjectCategoryInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subjectCategoryInfoPanelLayout.createSequentialGroup()
                                .addContainerGap(313, Short.MAX_VALUE)
                                .addComponent(updateSubjectCategoryButton))
                        .addComponent(subjectCategoryDetailPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );
        subjectCategoryInfoPanelLayout.setVerticalGroup(
                subjectCategoryInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subjectCategoryInfoPanelLayout.createSequentialGroup()
                                .addComponent(subjectCategoryDetailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(updateSubjectCategoryButton))
        );

        this.hideAndShowSubjectCategoryPanel.setDescription("Journals info");
        this.hideAndShowSubjectCategoryPanel.setPanel(this.journalInfoPanel);

        javax.swing.GroupLayout journalInfoPanelLayout = new javax.swing.GroupLayout(journalInfoPanel);
        journalInfoPanel.setLayout(journalInfoPanelLayout);
        journalInfoPanelLayout.setHorizontalGroup(
                journalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(subjectCategorySlaveJournalSubjectCategoryPublishDatePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );
        journalInfoPanelLayout.setVerticalGroup(
                journalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(subjectCategorySlaveJournalSubjectCategoryPublishDatePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(journalInfoPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(subjectCategoryInfoPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(hideAndShowSubjectCategoryPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                        .addComponent(hideAndShowJournalPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(hideAndShowSubjectCategoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(subjectCategoryInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hideAndShowJournalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(journalInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateSubjectCategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSubjectCategoryButtonActionPerformed

        PerformKnowledgeBaseEditTask task;

        if (this.subjectCategoryDetailPanel.getSubjectCategoryName().isEmpty()) {

            JOptionPane.showMessageDialog(this, "You have to give a name.\nPlease, " +
                    "give a name for the subject category.", "Invalid name", JOptionPane.ERROR_MESSAGE);

        } else {

            task = new PerformKnowledgeBaseEditTask(new UpdateSubjectCategoryEdit(getMasterItem().getSubjectCategoryID(),
                    this.subjectCategoryDetailPanel.getSubjectCategoryName()), this);

            task.execute();
        }
    }//GEN-LAST:event_updateSubjectCategoryButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private HideAndShowPanel hideAndShowJournalPanel;
    private HideAndShowPanel hideAndShowSubjectCategoryPanel;
    private javax.swing.JPanel journalInfoPanel;
    private SubjectCategoryDetailPanel subjectCategoryDetailPanel;
    private javax.swing.JPanel subjectCategoryInfoPanel;
    private SubjectCategorySlaveJournalSubjectCategoryPublishDatePanel subjectCategorySlaveJournalSubjectCategoryPublishDatePanel;
    private javax.swing.JButton updateSubjectCategoryButton;
    // End of variables declaration//GEN-END:variables
}
