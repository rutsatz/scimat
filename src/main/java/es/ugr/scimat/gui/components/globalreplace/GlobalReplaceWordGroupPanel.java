/*
 * GlobalReplaceAffiliationPanel.java
 *
 * Created on 22-ene-2012, 17:52:08
 */
package es.ugr.scimat.gui.components.globalreplace;

import es.ugr.scimat.gui.commands.edit.globalreplace.GlobalReplaceWordGroupsEdit;
import es.ugr.scimat.gui.commands.task.PerformKnowledgeBaseEditTask;

/**
 * @author mjcobo
 */
public class GlobalReplaceWordGroupPanel extends GlobalReplaceSelectFieldsPanel {

    /**
     * Creates new form GlobalReplaceAffiliationPanel
     */
    public GlobalReplaceWordGroupPanel() {
        initComponents();
    }

    /**
     *
     */
    @Override
    public void fireIncorrectDataObservers() {

        if (this.fieldsSelected > 0) {

            notifyIncorrectDataObservers(true, "");

        } else {

            notifyIncorrectDataObservers(false, "A set of fields must be selected");
        }
    }

    /**
     * @param find
     * @param replace
     */
    @Override
    public void doGlobalReplaceAction(String find, String replace) {

        new PerformKnowledgeBaseEditTask(new GlobalReplaceWordGroupsEdit(find,
                replace,
                this.groupNameCheckBox.isSelected()),
                this).execute();
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

        groupNameCheckBox = new javax.swing.JCheckBox();

        groupNameCheckBox.setText("Group name");
        groupNameCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupNameCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(groupNameCheckBox)
                                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(groupNameCheckBox)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param evt
     */
    private void groupNameCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupNameCheckBoxActionPerformed

        if (this.groupNameCheckBox.isSelected()) {

            this.fieldsSelected++;

        } else {

            this.fieldsSelected--;
        }

        fireIncorrectDataObservers();
    }//GEN-LAST:event_groupNameCheckBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox groupNameCheckBox;
    // End of variables declaration//GEN-END:variables
    private int fieldsSelected = 0;
}
