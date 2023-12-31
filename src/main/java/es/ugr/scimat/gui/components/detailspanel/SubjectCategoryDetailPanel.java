/*
 * WordDetailPanel.java
 *
 * Created on 28-ene-2009, 10:42:51
 */
package es.ugr.scimat.gui.components.detailspanel;

import es.ugr.scimat.model.knowledgebase.entity.SubjectCategory;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

import java.util.ArrayList;

/**
 * @author Manuel Jesús Cobo Martin
 */
public class SubjectCategoryDetailPanel extends GenericDetailPanel<SubjectCategory> {

    /**
     * Creates new form WordDetailPanel
     */
    public SubjectCategoryDetailPanel() {
        initComponents();

        CurrentProject.getInstance().getKbObserver().addSubjectCategoryObserver(this);
    }

    /**
     *
     */
    public void reset() {

        idTextField.setText("");
        nameTextField.setText("");

        setEnableTextField(false);
    }

    /**
     *
     */
    public void setEnableTextField(boolean enabled) {

        idTextField.setEnabled(enabled);
        nameTextField.setEnabled(enabled);
    }

    /**
     * @param subjectCategory
     */
    public void refreshItem(SubjectCategory subjectCategory) {

        this.subjectCategory = subjectCategory;

        if (subjectCategory != null) {

            idTextField.setText(this.subjectCategory.getSubjectCategoryID().toString());
            nameTextField.setText(this.subjectCategory.getSubjectCategoryName());

            setEnableTextField(true);

        } else {

            reset();

        }
    }

    /**
     * @return
     */
    public String getSubjectCategoryName() {

        return nameTextField.getText();
    }

    public void entityAdded(ArrayList<SubjectCategory> items) throws KnowledgeBaseException {
        // Do Nothing
    }

    public void entityRefresh() throws KnowledgeBaseException {
        // Do Nothing
    }

    public void entityUpdated(ArrayList<SubjectCategory> items) throws KnowledgeBaseException {

        int position;

        position = items.indexOf(this.subjectCategory);

        if (position != -1) {

            refreshItem(items.get(position));

        }
    }

    public void entityRemoved(ArrayList<SubjectCategory> items) throws KnowledgeBaseException {
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

        idDescriptionLabel = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        nameDescriptionLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();

        idDescriptionLabel.setText("ID:");

        idTextField.setEnabled(false);

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
                                                .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addComponent(nameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(idDescriptionLabel)
                                        .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    // End of variables declaration//GEN-END:variables
    private SubjectCategory subjectCategory;
}
