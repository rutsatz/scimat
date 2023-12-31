/*
 * WordGlobalSlavePanel.java
 *
 * Created on 13-mar-2011, 17:11:10
 */
package es.ugr.scimat.gui.components.globalslavepanel;

import es.ugr.scimat.gui.commands.edit.update.UpdateWordEdit;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import es.ugr.scimat.gui.components.HideAndShowPanel;
import es.ugr.scimat.gui.components.detailspanel.WordDetailPanel;
import es.ugr.scimat.gui.components.slavepanel.WordSlaveDocumentsPanel;
import es.ugr.scimat.gui.components.slavepanel.WordSlaveWordGroupPanel;
import es.ugr.scimat.model.knowledgebase.entity.Word;

import javax.swing.*;

/**
 * @author mjcobo
 */
public class WordGlobalSlavePanel extends GlobalSlavePanel<Word> {

    /**
     * Creates new form WordGlobalSlavePanel
     */
    public WordGlobalSlavePanel() {
        initComponents();
    }

    @Override
    public void refresh(Word item) {

        setMasterItem(item);

        this.wordDetailPanel.refreshItem(item);
        this.wordSlaveWordGroupPanel.setMasterItem(item);
        this.wordSlaveDocumentsPanel.setMasterItem(item);

        if (item != null) {

            this.updateWordButton.setEnabled(true);

        } else {

            this.updateWordButton.setEnabled(false);

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

        hideAndShowWordPanel = new HideAndShowPanel();
        wordInfoPanel = new javax.swing.JPanel();
        updateWordButton = new javax.swing.JButton();
        wordDetailPanel = new WordDetailPanel();
        hideAndShowWordGroupPanel = new HideAndShowPanel();
        this.hideAndShowWordGroupPanel.setDescription("Word group info");
        this.hideAndShowWordGroupPanel.setPanel(this.wordSlaveWordGroupPanel);
        wordGroupInfoPanel = new javax.swing.JPanel();
        wordSlaveWordGroupPanel = new WordSlaveWordGroupPanel();
        hideAndShowDocumentPanel = new HideAndShowPanel();
        documentInfoPanel = new javax.swing.JPanel();
        wordSlaveDocumentsPanel = new WordSlaveDocumentsPanel();

        this.hideAndShowWordPanel.setDescription("Word info");
        this.hideAndShowWordPanel.setPanel(this.wordInfoPanel);

        updateWordButton.setText("Update");
        updateWordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateWordButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout wordInfoPanelLayout = new javax.swing.GroupLayout(wordInfoPanel);
        wordInfoPanel.setLayout(wordInfoPanelLayout);
        wordInfoPanelLayout.setHorizontalGroup(
                wordInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wordInfoPanelLayout.createSequentialGroup()
                                .addContainerGap(313, Short.MAX_VALUE)
                                .addComponent(updateWordButton))
                        .addComponent(wordDetailPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );
        wordInfoPanelLayout.setVerticalGroup(
                wordInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wordInfoPanelLayout.createSequentialGroup()
                                .addComponent(wordDetailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(updateWordButton))
        );

        javax.swing.GroupLayout wordGroupInfoPanelLayout = new javax.swing.GroupLayout(wordGroupInfoPanel);
        wordGroupInfoPanel.setLayout(wordGroupInfoPanelLayout);
        wordGroupInfoPanelLayout.setHorizontalGroup(
                wordGroupInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(wordSlaveWordGroupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );
        wordGroupInfoPanelLayout.setVerticalGroup(
                wordGroupInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(wordSlaveWordGroupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        this.hideAndShowDocumentPanel.setDescription("Documents info");
        this.hideAndShowDocumentPanel.setPanel(this.wordSlaveDocumentsPanel);

        javax.swing.GroupLayout documentInfoPanelLayout = new javax.swing.GroupLayout(documentInfoPanel);
        documentInfoPanel.setLayout(documentInfoPanelLayout);
        documentInfoPanelLayout.setHorizontalGroup(
                documentInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(wordSlaveDocumentsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );
        documentInfoPanelLayout.setVerticalGroup(
                documentInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(wordSlaveDocumentsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(wordGroupInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(wordInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(hideAndShowWordPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                        .addComponent(hideAndShowWordGroupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                        .addComponent(hideAndShowDocumentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(documentInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(hideAndShowWordPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(wordInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hideAndShowWordGroupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(wordGroupInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hideAndShowDocumentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(documentInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateWordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateWordButtonActionPerformed

        PerformKnowledgeBaseEditTask task;

        if (this.wordDetailPanel.getWordName().isEmpty()) {

            JOptionPane.showMessageDialog(this, "You have to give a name.\nPlease, " +
                    "give a name for the word.", "Invalid name", JOptionPane.ERROR_MESSAGE);

        } else {

            task = new PerformKnowledgeBaseEditTask(new UpdateWordEdit(getMasterItem().getWordID(),
                    this.wordDetailPanel.getWordName()), this);

            task.execute();
        }
    }//GEN-LAST:event_updateWordButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel documentInfoPanel;
    private HideAndShowPanel hideAndShowDocumentPanel;
    private HideAndShowPanel hideAndShowWordGroupPanel;
    private HideAndShowPanel hideAndShowWordPanel;
    private javax.swing.JButton updateWordButton;
    private WordDetailPanel wordDetailPanel;
    private javax.swing.JPanel wordGroupInfoPanel;
    private javax.swing.JPanel wordInfoPanel;
    private WordSlaveDocumentsPanel wordSlaveDocumentsPanel;
    private WordSlaveWordGroupPanel wordSlaveWordGroupPanel;
    // End of variables declaration//GEN-END:variables
}
