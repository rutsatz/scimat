/*
 * ReferenceSourceGlobalSlavePanel.java
 *
 * Created on 13-mar-2011, 17:13:00
 */
package es.ugr.scimat.gui.components.globalslavepanel;

import es.ugr.scimat.gui.commands.edit.update.UpdateReferenceSourceEdit;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.HideAndShowPanel;
import es.ugr.scimat.gui.components.detailspanel.ReferenceSourceDetailPanel;
import es.ugr.scimat.gui.components.slavepanel.ReferenceSourceSlaveReferenceSourceGroupPanel;
import es.ugr.scimat.gui.components.slavepanel.ReferenceSourceSlaveReferencesPanel;
import es.ugr.scimat.model.knowledgebase.entity.ReferenceSource;

import javax.swing.*;

/**
 * @author mjcobo
 */
public class ReferenceSourceGlobalSlavePanel extends GlobalSlavePanel<ReferenceSource> {

    /**
     * Creates new form ReferenceSourceGlobalSlavePanel
     */
    public ReferenceSourceGlobalSlavePanel() {
        initComponents();
    }

    @Override
    public void refresh(ReferenceSource item) {

        setMasterItem(item);

        this.referenceSourceDetailPanel.refreshItem(item);
        this.referenceSourceSlaveReferencesPanel.setMasterItem(item);
        this.referenceSourceSlaveReferenceSourceGroupPanel.setMasterItem(item);

        if (item != null) {

            this.updateReferenceSourceButton.setEnabled(true);

        } else {

            this.updateReferenceSourceButton.setEnabled(false);

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

        hideAndShowReferenceSourcePanel = new HideAndShowPanel();
        referenceSourceInfoPanel = new javax.swing.JPanel();
        updateReferenceSourceButton = new javax.swing.JButton();
        referenceSourceDetailPanel = new ReferenceSourceDetailPanel();
        hideAndShowReferenceSourceGroupPanel = new HideAndShowPanel();
        referenceSourceGroupInfoPanel = new javax.swing.JPanel();
        referenceSourceSlaveReferenceSourceGroupPanel = new ReferenceSourceSlaveReferenceSourceGroupPanel();
        hideAndShowReferencePanel = new HideAndShowPanel();
        referenceInfoPanel = new javax.swing.JPanel();
        referenceSourceSlaveReferencesPanel = new ReferenceSourceSlaveReferencesPanel();

        this.hideAndShowReferenceSourcePanel.setDescription("Source-reference");
        this.hideAndShowReferenceSourcePanel.setPanel(this.referenceSourceInfoPanel);

        updateReferenceSourceButton.setText("Update");
        updateReferenceSourceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateReferenceSourceButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout referenceSourceInfoPanelLayout = new javax.swing.GroupLayout(referenceSourceInfoPanel);
        referenceSourceInfoPanel.setLayout(referenceSourceInfoPanelLayout);
        referenceSourceInfoPanelLayout.setHorizontalGroup(
                referenceSourceInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, referenceSourceInfoPanelLayout.createSequentialGroup()
                                .addContainerGap(313, Short.MAX_VALUE)
                                .addComponent(updateReferenceSourceButton))
                        .addComponent(referenceSourceDetailPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );
        referenceSourceInfoPanelLayout.setVerticalGroup(
                referenceSourceInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, referenceSourceInfoPanelLayout.createSequentialGroup()
                                .addComponent(referenceSourceDetailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(updateReferenceSourceButton))
        );

        this.hideAndShowReferenceSourceGroupPanel.setDescription("Sources-reference group info");
        this.hideAndShowReferenceSourceGroupPanel.setPanel(this.referenceSourceGroupInfoPanel);

        javax.swing.GroupLayout referenceSourceGroupInfoPanelLayout = new javax.swing.GroupLayout(referenceSourceGroupInfoPanel);
        referenceSourceGroupInfoPanel.setLayout(referenceSourceGroupInfoPanelLayout);
        referenceSourceGroupInfoPanelLayout.setHorizontalGroup(
                referenceSourceGroupInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(referenceSourceSlaveReferenceSourceGroupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );
        referenceSourceGroupInfoPanelLayout.setVerticalGroup(
                referenceSourceGroupInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(referenceSourceSlaveReferenceSourceGroupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        this.hideAndShowReferencePanel.setDescription("References info");
        this.hideAndShowReferencePanel.setPanel(this.referenceInfoPanel);

        javax.swing.GroupLayout referenceInfoPanelLayout = new javax.swing.GroupLayout(referenceInfoPanel);
        referenceInfoPanel.setLayout(referenceInfoPanelLayout);
        referenceInfoPanelLayout.setHorizontalGroup(
                referenceInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(referenceSourceSlaveReferencesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );
        referenceInfoPanelLayout.setVerticalGroup(
                referenceInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(referenceSourceSlaveReferencesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(referenceSourceGroupInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(referenceSourceInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(hideAndShowReferenceSourcePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                        .addComponent(hideAndShowReferenceSourceGroupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                        .addComponent(hideAndShowReferencePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(referenceInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(hideAndShowReferenceSourcePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(referenceSourceInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hideAndShowReferenceSourceGroupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(referenceSourceGroupInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hideAndShowReferencePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(referenceInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateReferenceSourceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateReferenceSourceButtonActionPerformed

        PerformKnowledgeBaseEditTask task;

        if (this.referenceSourceDetailPanel.getSource().isEmpty()) {

            JOptionPane.showMessageDialog(this, "You have to give a source.\nPlease, " +
                    "give a source for the reference source.", "Invalid source", JOptionPane.ERROR_MESSAGE);

        } else {

            task = new PerformKnowledgeBaseEditTask(new UpdateReferenceSourceEdit(getMasterItem().getReferenceSourceID(),
                    this.referenceSourceDetailPanel.getSource()), this);

            task.execute();
        }
    }//GEN-LAST:event_updateReferenceSourceButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private HideAndShowPanel hideAndShowReferencePanel;
    private HideAndShowPanel hideAndShowReferenceSourceGroupPanel;
    private HideAndShowPanel hideAndShowReferenceSourcePanel;
    private javax.swing.JPanel referenceInfoPanel;
    private ReferenceSourceDetailPanel referenceSourceDetailPanel;
    private javax.swing.JPanel referenceSourceGroupInfoPanel;
    private javax.swing.JPanel referenceSourceInfoPanel;
    private ReferenceSourceSlaveReferenceSourceGroupPanel referenceSourceSlaveReferenceSourceGroupPanel;
    private ReferenceSourceSlaveReferencesPanel referenceSourceSlaveReferencesPanel;
    private javax.swing.JButton updateReferenceSourceButton;
    // End of variables declaration//GEN-END:variables
}
