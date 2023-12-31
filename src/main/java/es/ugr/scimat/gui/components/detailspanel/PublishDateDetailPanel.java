/*
 * PublishDateDetailPanel.java
 *
 * Created on 27-nov-2008, 20:19:32
 */
package es.ugr.scimat.gui.components.detailspanel;

import es.ugr.scimat.model.knowledgebase.entity.PublishDate;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

import java.util.ArrayList;


/**
 * @author Manuel Jesus Cobo Martin.
 */
public class PublishDateDetailPanel extends GenericDetailPanel<PublishDate> {

    /**
     * Creates new form PublishDateDetailPanel
     */
    public PublishDateDetailPanel() {
        initComponents();

        CurrentProject.getInstance().getKbObserver().addPublishDateObserver(this);
    }

    /**
     *
     */
    public void reset() {

        idTextField.setText("");
        yearTextField.setText("");
        dateTextField.setText("");

        setEnableTextField(false);
    }

    /**
     *
     */
    public void setEnableTextField(boolean enabled) {

        idTextField.setEnabled(enabled);
        yearTextField.setEnabled(enabled);
        dateTextField.setEnabled(enabled);
    }

    /**
     * @param publishDate
     */
    public void refreshItem(PublishDate publishDate) {

        this.publishDate = publishDate;

        if (publishDate != null) {

            idTextField.setText(this.publishDate.getPublishDateID().toString());
            yearTextField.setText(this.publishDate.getYear());
            dateTextField.setText(this.publishDate.getDate());

            setEnableTextField(true);

        } else {

            reset();

        }
    }

    /**
     * @return
     */
    public String getYear() {

        return yearTextField.getText();
    }

    /**
     * @return
     */
    public String getDate() {

        return dateTextField.getText();
    }

    public void entityAdded(ArrayList<PublishDate> items) throws KnowledgeBaseException {
        // Do Nothing
    }

    public void entityRefresh() throws KnowledgeBaseException {
        // Do Nothing
    }

    public void entityUpdated(ArrayList<PublishDate> items) throws KnowledgeBaseException {

        int position;

        position = items.indexOf(this.publishDate);

        if (position != -1) {

            refreshItem(items.get(position));

        }
    }

    public void entityRemoved(ArrayList<PublishDate> items) throws KnowledgeBaseException {
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
        yearDescriptionLabel = new javax.swing.JLabel();
        yearTextField = new javax.swing.JTextField();
        dateDescriptionLabel = new javax.swing.JLabel();
        dateTextField = new javax.swing.JTextField();

        idDescriptionLabel.setText("ID:");

        idTextField.setEnabled(false);

        yearDescriptionLabel.setText("Year:");

        dateDescriptionLabel.setText("Date:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(idDescriptionLabel)
                                        .addComponent(dateDescriptionLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dateTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(yearDescriptionLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(yearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(idDescriptionLabel)
                                        .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(yearDescriptionLabel)
                                        .addComponent(yearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(dateDescriptionLabel)
                                        .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateDescriptionLabel;
    private javax.swing.JTextField dateTextField;
    private javax.swing.JLabel idDescriptionLabel;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel yearDescriptionLabel;
    private javax.swing.JTextField yearTextField;
    // End of variables declaration//GEN-END:variables
    private PublishDate publishDate;
}
