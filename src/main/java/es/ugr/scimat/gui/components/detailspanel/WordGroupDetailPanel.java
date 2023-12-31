/*
 * WordGroupDetailPanel.java
 *
 * Created on 28-ene-2009, 11:02:54
 */
package es.ugr.scimat.gui.components.detailspanel;

import es.ugr.scimat.model.knowledgebase.entity.WordGroup;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

import java.util.ArrayList;

/**
 * @author Manuel Jesus Cobo Martin.
 */
public class WordGroupDetailPanel extends GenericDetailPanel<WordGroup> {

    /**
     * Creates new form WordGroupDetailPanel
     */
    public WordGroupDetailPanel() {
        initComponents();

        CurrentProject.getInstance().getKbObserver().addWordGroupObserver(this);
    }

    /**
     *
     */
    public void reset() {

        idTextField.setText("");
        stopGroupCheckBox.setSelected(false);
        nameTextField.setText("");

        setEnableTextField(false);
    }

    /**
     *
     */
    public void setEnableTextField(boolean enabled) {

        idTextField.setEnabled(enabled);
        stopGroupCheckBox.setEnabled(enabled);
        nameTextField.setEnabled(enabled);
    }

    /**
     * @param wordGroup
     */
    public void refreshItem(WordGroup wordGroup) {

        this.wordGroup = wordGroup;

        if (wordGroup != null) {

            idTextField.setText(this.wordGroup.getWordGroupID().toString());
            stopGroupCheckBox.setSelected(this.wordGroup.isStopGroup());
            nameTextField.setText(this.wordGroup.getGroupName());

            setEnableTextField(true);

        } else {

            reset();

        }
    }

    /**
     * @return
     */
    public String getGroupName() {

        return nameTextField.getText();
    }

    /**
     * @return
     */
    public boolean isStopGroup() {

        return stopGroupCheckBox.isSelected();
    }

    public void entityAdded(ArrayList<WordGroup> items) throws KnowledgeBaseException {
        // Do Nothing
    }

    public void entityRefresh() throws KnowledgeBaseException {
        // Do Nothing
    }

    public void entityUpdated(ArrayList<WordGroup> items) throws KnowledgeBaseException {

        int position;

        position = items.indexOf(this.wordGroup);

        if (position != -1) {

            refreshItem(items.get(position));

        }
    }

    public void entityRemoved(ArrayList<WordGroup> items) throws KnowledgeBaseException {
        // Do Nothing
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

        idTextField = new javax.swing.JTextField();
        idDescriptionLabel = new javax.swing.JLabel();
        stopGroupCheckBox = new javax.swing.JCheckBox();
        nameTextField = new javax.swing.JTextField();
        nameDescriptionLabel = new javax.swing.JLabel();

        idTextField.setEditable(false);

        idDescriptionLabel.setText("ID:");

        stopGroupCheckBox.setText("Stop group");

        nameDescriptionLabel.setText("Name:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(idDescriptionLabel)
                                        .addComponent(nameDescriptionLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(stopGroupCheckBox)
                                                .addContainerGap())
                                        .addComponent(nameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(idDescriptionLabel)
                                        .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(stopGroupCheckBox))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameDescriptionLabel)
                                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel idDescriptionLabel;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel nameDescriptionLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JCheckBox stopGroupCheckBox;
    // End of variables declaration//GEN-END:variables
    private WordGroup wordGroup;
}
