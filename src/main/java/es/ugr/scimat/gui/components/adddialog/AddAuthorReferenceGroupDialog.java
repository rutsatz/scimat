/*
 * AddDocumentDialog.java
 *
 * Created on 16-mar-2011, 14:22:38
 */
package es.ugr.scimat.gui.components.adddialog;

import es.ugr.scimat.gui.commands.edit.add.AddAuthorReferenceGroupEdit;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;

import javax.swing.*;

/**
 * @author mjcobo
 */
public class AddAuthorReferenceGroupDialog extends javax.swing.JDialog {

    /**
     * Creates new form AddDocumentDialog
     */
    public AddAuthorReferenceGroupDialog(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
    }

    /**
     *
     */
    public void refresh() {

        this.groupNameTextField.setText("");
        this.stopGroupCheckBox.setSelected(false);
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

        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        groupNameDescriptionLabel = new javax.swing.JLabel();
        groupNameTextField = new javax.swing.JTextField();
        stopGroupCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add author reference group");
        setAlwaysOnTop(true);
        setModal(true);

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        groupNameDescriptionLabel.setLabelFor(groupNameTextField);
        groupNameDescriptionLabel.setText("Group name:");

        stopGroupCheckBox.setText("I stop group?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(addButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cancelButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(groupNameDescriptionLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(groupNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
                                        .addComponent(stopGroupCheckBox))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(groupNameDescriptionLabel)
                                        .addComponent(groupNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(stopGroupCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancelButton)
                                        .addComponent(addButton))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param evt
     */
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * @param evt
     */
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed

        PerformKnowledgeBaseEditTask task;

        // If the name is empty
        if (this.groupNameTextField.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "You have to give a group name.\nPlease, " +
                    "give a name for the group.", "Invalid group name", JOptionPane.ERROR_MESSAGE);

        } else {

            task = new PerformKnowledgeBaseEditTask(new AddAuthorReferenceGroupEdit(this.groupNameTextField.getText(),
                    this.stopGroupCheckBox.isSelected()), rootPane);

            task.execute();

            if (task.isSuccessful()) {

                dispose();
            }
        }
    }//GEN-LAST:event_addButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel groupNameDescriptionLabel;
    private javax.swing.JTextField groupNameTextField;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JCheckBox stopGroupCheckBox;
    // End of variables declaration//GEN-END:variables
}
