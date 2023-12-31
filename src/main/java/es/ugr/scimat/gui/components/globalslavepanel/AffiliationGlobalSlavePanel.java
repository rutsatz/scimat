/*
 * AffiliationGlobalSlavePanel.java
 *
 * Created on 13-mar-2011, 17:12:10
 */
package es.ugr.scimat.gui.components.globalslavepanel;

import es.ugr.scimat.gui.commands.edit.update.UpdateAffiliationEdit;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.HideAndShowPanel;
import es.ugr.scimat.gui.components.detailspanel.AffiliationDetailPanel;
import es.ugr.scimat.gui.components.slavepanel.AffiliationSlaveAuthorsPanel;
import es.ugr.scimat.gui.components.slavepanel.AffiliationSlaveDocumentsPanel;
import es.ugr.scimat.model.knowledgebase.entity.Affiliation;

import javax.swing.*;

/**
 * @author mjcobo
 */
public class AffiliationGlobalSlavePanel extends GlobalSlavePanel<Affiliation> {

    /**
     * Creates new form AffiliationGlobalSlavePanel
     */
    public AffiliationGlobalSlavePanel() {
        initComponents();
    }

    @Override
    public void refresh(Affiliation item) {

        setMasterItem(item);

        this.affiliationDetailPanel.refreshItem(item);
        this.affiliationSlaveAuthorsPanel.setMasterItem(item);
        this.affiliationSlaveDocumentsPanel.setMasterItem(item);

        if (item != null) {

            this.updateAffiliationButton.setEnabled(true);

        } else {

            this.updateAffiliationButton.setEnabled(false);

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

        hideAndShowAffiliationPanel = new HideAndShowPanel();
        affiliationInfoPanel = new javax.swing.JPanel();
        affiliationDetailPanel = new AffiliationDetailPanel();
        updateAffiliationButton = new javax.swing.JButton();
        hideAndShowAuthorPanel = new HideAndShowPanel();
        authorInfoPanel = new javax.swing.JPanel();
        affiliationSlaveAuthorsPanel = new AffiliationSlaveAuthorsPanel();
        hideAndShowDocumentPanel = new HideAndShowPanel();
        documentInfoPanel = new javax.swing.JPanel();
        affiliationSlaveDocumentsPanel = new AffiliationSlaveDocumentsPanel();

        this.hideAndShowAffiliationPanel.setDescription("Affiliation info");
        this.hideAndShowAffiliationPanel.setPanel(this.affiliationInfoPanel);

        updateAffiliationButton.setText("Update");
        updateAffiliationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateAffiliationButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout affiliationInfoPanelLayout = new javax.swing.GroupLayout(affiliationInfoPanel);
        affiliationInfoPanel.setLayout(affiliationInfoPanelLayout);
        affiliationInfoPanelLayout.setHorizontalGroup(
                affiliationInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(affiliationDetailPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, affiliationInfoPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(updateAffiliationButton))
        );
        affiliationInfoPanelLayout.setVerticalGroup(
                affiliationInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(affiliationInfoPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(affiliationDetailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(updateAffiliationButton))
        );

        this.hideAndShowAuthorPanel.setDescription("Authors info");
        this.hideAndShowAuthorPanel.setPanel(this.authorInfoPanel);

        javax.swing.GroupLayout authorInfoPanelLayout = new javax.swing.GroupLayout(authorInfoPanel);
        authorInfoPanel.setLayout(authorInfoPanelLayout);
        authorInfoPanelLayout.setHorizontalGroup(
                authorInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(affiliationSlaveAuthorsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );
        authorInfoPanelLayout.setVerticalGroup(
                authorInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(affiliationSlaveAuthorsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );

        this.hideAndShowDocumentPanel.setDescription("Documents info");
        this.hideAndShowDocumentPanel.setPanel(this.documentInfoPanel);

        javax.swing.GroupLayout documentInfoPanelLayout = new javax.swing.GroupLayout(documentInfoPanel);
        documentInfoPanel.setLayout(documentInfoPanelLayout);
        documentInfoPanelLayout.setHorizontalGroup(
                documentInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(affiliationSlaveDocumentsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );
        documentInfoPanelLayout.setVerticalGroup(
                documentInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(affiliationSlaveDocumentsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(documentInfoPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(authorInfoPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(affiliationInfoPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(hideAndShowAffiliationPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                        .addComponent(hideAndShowAuthorPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                        .addComponent(hideAndShowDocumentPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(hideAndShowAffiliationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(affiliationInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hideAndShowAuthorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(authorInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hideAndShowDocumentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(documentInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param evt
     */
    private void updateAffiliationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateAffiliationButtonActionPerformed

        PerformKnowledgeBaseEditTask task;

        // If the name is empty
        if (this.affiliationDetailPanel.getFullAffiliation().isEmpty()) {

            JOptionPane.showMessageDialog(this, "You have to give a full affiliation.\nPlease, " +
                    "give a full affiliation.", "Invalid full affiliation", JOptionPane.ERROR_MESSAGE);

        } else {

            task = new PerformKnowledgeBaseEditTask(new UpdateAffiliationEdit(getMasterItem().getAffiliationID(),
                    this.affiliationDetailPanel.getFullAffiliation()), this);

            task.execute();
        }
    }//GEN-LAST:event_updateAffiliationButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private AffiliationDetailPanel affiliationDetailPanel;
    private javax.swing.JPanel affiliationInfoPanel;
    private AffiliationSlaveAuthorsPanel affiliationSlaveAuthorsPanel;
    private AffiliationSlaveDocumentsPanel affiliationSlaveDocumentsPanel;
    private javax.swing.JPanel authorInfoPanel;
    private javax.swing.JPanel documentInfoPanel;
    private HideAndShowPanel hideAndShowAffiliationPanel;
    private HideAndShowPanel hideAndShowAuthorPanel;
    private HideAndShowPanel hideAndShowDocumentPanel;
    private javax.swing.JButton updateAffiliationButton;
    // End of variables declaration//GEN-END:variables
}
