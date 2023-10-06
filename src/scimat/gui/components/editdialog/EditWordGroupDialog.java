/*
 * AddDocumentDialog.java
 *
 * Created on 16-mar-2011, 14:22:38
 */
package scimat.gui.components.editdialog;

import javax.swing.JOptionPane;
import scimat.gui.commands.edit.update.UpdateWordGroupEdit;
import scimat.gui.commands.task.PerformKnowledgeBaseEditTask;
import scimat.model.knowledgebase.entity.WordGroup;

/**
 *
 * @author mjcobo
 */
public class EditWordGroupDialog extends javax.swing.JDialog {

  /** Creates new form AddDocumentDialog */
  public EditWordGroupDialog(java.awt.Frame parent) {
    super(parent, true);
    initComponents();
  }

  /**
   *
   */
  public void refreshData(WordGroup wordGroup) {

    this.wordGroup = wordGroup;

    if (this.wordGroup != null) {

      this.groupNameTextField.setText(this.wordGroup.getGroupName());
      this.stopGroupCheckBox.setSelected(this.wordGroup.isStopGroup());

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

    groupNameDescriptionLabel = new javax.swing.JLabel();
    groupNameTextField = new javax.swing.JTextField();
    stopGroupCheckBox = new javax.swing.JCheckBox();
    separator = new javax.swing.JSeparator();
    editButton = new javax.swing.JButton();
    cancelButton = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Add word group");
    setAlwaysOnTop(true);
    setModal(true);

    groupNameDescriptionLabel.setLabelFor(groupNameTextField);
    groupNameDescriptionLabel.setText("Group name:");

    stopGroupCheckBox.setText("I stop group?");

    editButton.setText("Edit");
    editButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        editButtonActionPerformed(evt);
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
          .addComponent(separator, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(editButton)
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
        .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(cancelButton)
          .addComponent(editButton))
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
  private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed

    PerformKnowledgeBaseEditTask task;

    // If the name is empty
    if (this.groupNameTextField.getText().isEmpty()) {

      JOptionPane.showMessageDialog(this, "You have to give a group name.\nPlease, " +
        "give a name for the group.", "Invalid group name", JOptionPane.ERROR_MESSAGE);

    } else {

      task = new PerformKnowledgeBaseEditTask(new UpdateWordGroupEdit(this.wordGroup.getWordGroupID(), this.groupNameTextField.getText(),
              this.stopGroupCheckBox.isSelected()), rootPane);

      task.execute();

      if (task.isSuccessful()) {

        dispose();
      }
    }
  }//GEN-LAST:event_editButtonActionPerformed
  
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton cancelButton;
  private javax.swing.JButton editButton;
  private javax.swing.JLabel groupNameDescriptionLabel;
  private javax.swing.JTextField groupNameTextField;
  private javax.swing.JSeparator separator;
  private javax.swing.JCheckBox stopGroupCheckBox;
  // End of variables declaration//GEN-END:variables
  private WordGroup wordGroup = null;
}
