/*
 * AddDocumentDialog.java
 *
 * Created on 16-mar-2011, 14:22:38
 */
package es.ugr.scimat.gui.components.adddialog;

import es.ugr.scimat.gui.commands.edit.add.AddDocumentEdit;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;

/**
 * @author mjcobo
 */
public class AddDocumentDialog extends javax.swing.JDialog {

    /**
     * Creates new form AddDocumentDialog
     */
    public AddDocumentDialog(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
    }

    /**
     *
     */
    public void refresh() {

        this.titleTextField.setText("");
        this.typeTextField.setText("");
        this.abstractTextArea.setText("");
        this.citationsSpinner.setValue(0);
        this.sourceIdentifierTextField.setText("");
        this.doiTextField.setText("");
        this.volumeTextField.setText("");
        this.issueTextField.setText("");
        this.beginPageTextField.setText("");
        this.endPageTextField.setText("");
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
        typeDescriptionLabel = new javax.swing.JLabel();
        typeTextField = new javax.swing.JTextField();
        titleDescriptionLabel = new javax.swing.JLabel();
        titleTextField = new javax.swing.JTextField();
        issueDescriptionLabel = new javax.swing.JLabel();
        issueTextField = new javax.swing.JTextField();
        volumeDescriptionLabel = new javax.swing.JLabel();
        volumeTextField = new javax.swing.JTextField();
        beginPageDescriptionLabel = new javax.swing.JLabel();
        beginPageTextField = new javax.swing.JTextField();
        endPageDescriptionLabel = new javax.swing.JLabel();
        endPageTextField = new javax.swing.JTextField();
        doiDescriptionLabel = new javax.swing.JLabel();
        doiTextField = new javax.swing.JTextField();
        abstractDescriptionLabel = new javax.swing.JLabel();
        abstractScrollPane = new javax.swing.JScrollPane();
        abstractTextArea = new javax.swing.JTextArea();
        citationsDescriptionLabel = new javax.swing.JLabel();
        citationsSpinner = new javax.swing.JSpinner();
        sourceIdentifierDescriptionLabel = new javax.swing.JLabel();
        sourceIdentifierTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add document");
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

        typeDescriptionLabel.setText("Type:");

        titleDescriptionLabel.setText("Title:");

        issueDescriptionLabel.setText("Issue:");

        volumeDescriptionLabel.setText("Volume:");

        beginPageDescriptionLabel.setText("Begin page:");

        endPageDescriptionLabel.setText("Begin page:");

        doiDescriptionLabel.setText("Doi:");

        abstractDescriptionLabel.setText("Abstract:");

        abstractTextArea.setColumns(20);
        abstractTextArea.setLineWrap(true);
        abstractTextArea.setRows(5);
        abstractTextArea.setWrapStyleWord(true);
        abstractScrollPane.setViewportView(abstractTextArea);

        citationsDescriptionLabel.setText("Citations:");

        citationsSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        sourceIdentifierDescriptionLabel.setText("Source identifier:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(titleDescriptionLabel)
                                                                        .addComponent(issueDescriptionLabel)
                                                                        .addComponent(doiDescriptionLabel)
                                                                        .addComponent(abstractDescriptionLabel))
                                                                .addGap(5, 5, 5)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(abstractScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                                                                        .addComponent(doiTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                                                                        .addComponent(titleTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(issueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(volumeDescriptionLabel)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(volumeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(beginPageDescriptionLabel)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(beginPageTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(endPageDescriptionLabel)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(endPageTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                                                                        .addComponent(typeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(citationsDescriptionLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(citationsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(sourceIdentifierDescriptionLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(sourceIdentifierTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)))
                                                .addGap(7, 7, 7))
                                        .addComponent(typeDescriptionLabel)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(addButton)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(cancelButton)))
                                                .addContainerGap())))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(typeDescriptionLabel)
                                        .addComponent(typeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(titleDescriptionLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(issueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(issueDescriptionLabel)
                                        .addComponent(volumeDescriptionLabel)
                                        .addComponent(volumeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(beginPageDescriptionLabel)
                                        .addComponent(beginPageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(endPageDescriptionLabel)
                                        .addComponent(endPageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(doiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(doiDescriptionLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(abstractDescriptionLabel)
                                        .addComponent(abstractScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(citationsDescriptionLabel)
                                        .addComponent(citationsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(sourceIdentifierTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(sourceIdentifierDescriptionLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

        task = new PerformKnowledgeBaseEditTask(new AddDocumentEdit(this.typeTextField.getText(),
                this.titleTextField.getText(), this.abstractTextArea.getText(),
                (Integer) this.citationsSpinner.getValue(), this.doiTextField.getText(),
                this.sourceIdentifierTextField.getText(), this.volumeTextField.getText(),
                this.issueTextField.getText(), this.beginPageTextField.getText(),
                this.endPageTextField.getText()), rootPane);

        task.execute();

        if (task.isSuccessful()) {

            dispose();
        }
    }//GEN-LAST:event_addButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel abstractDescriptionLabel;
    private javax.swing.JScrollPane abstractScrollPane;
    private javax.swing.JTextArea abstractTextArea;
    private javax.swing.JButton addButton;
    private javax.swing.JLabel beginPageDescriptionLabel;
    private javax.swing.JTextField beginPageTextField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel citationsDescriptionLabel;
    private javax.swing.JSpinner citationsSpinner;
    private javax.swing.JLabel doiDescriptionLabel;
    private javax.swing.JTextField doiTextField;
    private javax.swing.JLabel endPageDescriptionLabel;
    private javax.swing.JTextField endPageTextField;
    private javax.swing.JLabel issueDescriptionLabel;
    private javax.swing.JTextField issueTextField;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel sourceIdentifierDescriptionLabel;
    private javax.swing.JTextField sourceIdentifierTextField;
    private javax.swing.JLabel titleDescriptionLabel;
    private javax.swing.JTextField titleTextField;
    private javax.swing.JLabel typeDescriptionLabel;
    private javax.swing.JTextField typeTextField;
    private javax.swing.JLabel volumeDescriptionLabel;
    private javax.swing.JTextField volumeTextField;
    // End of variables declaration//GEN-END:variables
}
