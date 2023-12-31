/*
 * AuthorReferenceSlaveAuthorReferenceGroupPanel.java
 *
 * Created on 21-mar-2011, 11:34:59
 */
package es.ugr.scimat.gui.components.slavepanel;

import es.ugr.scimat.gui.components.ErrorDialogManager;
import es.ugr.scimat.model.knowledgebase.entity.AuthorReference;
import es.ugr.scimat.model.knowledgebase.entity.AuthorReferenceGroup;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;
import es.ugr.scimat.project.observer.AuthorReferenceGroupRelationAuthorReferenceObserver;
import es.ugr.scimat.project.observer.EntityObserver;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class AuthorReferenceSlaveAuthorReferenceGroupPanel extends GenericOneSlaveItemPanel
        implements AuthorReferenceGroupRelationAuthorReferenceObserver, EntityObserver<AuthorReferenceGroup> {

    /**
     * Creates new form WordSlaveWordGroupPanel
     */
    public AuthorReferenceSlaveAuthorReferenceGroupPanel() {
        initComponents();

        CurrentProject.getInstance().getKbObserver().addAuthorReferenceGroupRelationAuthorReferenceObserver(this);
        CurrentProject.getInstance().getKbObserver().addAuthorReferenceGroupObserver(this);
    }

    /**
     *
     */
    private void refresh() {

        if (this.authorReferenceGroup != null) {

            this.groupNameTextField.setText(this.authorReferenceGroup.getGroupName());
            this.stopGroupCheckBox.setSelected(this.authorReferenceGroup.isStopGroup());
            fireSlaveItemObserver(true);

        } else {

            this.groupNameTextField.setText("");
            this.stopGroupCheckBox.setSelected(false);
        }
    }

    /**
     *
     */
    public void setMasterItem(AuthorReference authorReference) {

        this.authorReference = authorReference;

        try {

            if (this.authorReference != null) {

                relationChanged();

            } else {

                this.authorReferenceGroup = null;
                refresh();

            }

        } catch (KnowledgeBaseException e) {

            ErrorDialogManager.getInstance().showException(e);

        }
    }

    /**
     *
     */
    public void relationChanged() throws KnowledgeBaseException {

        if (this.authorReference != null) {

            this.authorReferenceGroup = CurrentProject.getInstance().getFactoryDAO().getAuthorReferenceDAO().getAuthorReferenceGroup(this.authorReference.getAuthorReferenceID());

        } else {

            this.authorReferenceGroup = null;
        }

        refresh();
    }

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityAdded(ArrayList<AuthorReferenceGroup> items) throws KnowledgeBaseException {
        // Do not do nothing
    }

    /**
     * @param entity
     * @throws KnowledgeBaseException
     */
    public void entityRefresh() throws KnowledgeBaseException {

        if (this.authorReferenceGroup != null) {

            this.authorReferenceGroup = CurrentProject.getInstance().getFactoryDAO().getAuthorReferenceGroupDAO().getAuthorReferenceGroup(this.authorReferenceGroup.getAuthorReferenceGroupID());
            refresh();
        }
    }

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityRemoved(ArrayList<AuthorReferenceGroup> items) throws KnowledgeBaseException {
        // Do not do nothing
    }

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityUpdated(ArrayList<AuthorReferenceGroup> items) throws KnowledgeBaseException {

        int position;

        if (this.authorReferenceGroup != null) {

            position = items.indexOf(this.authorReferenceGroup);

            if (position != -1) {

                this.authorReferenceGroup = items.get(position);
            }
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

        groupNameDescriptionLabel = new javax.swing.JLabel();
        groupNameTextField = new javax.swing.JTextField();
        stopGroupCheckBox = new javax.swing.JCheckBox();

        groupNameDescriptionLabel.setText("Group name:");

        groupNameTextField.setEditable(false);

        stopGroupCheckBox.setText("is stop group?");
        stopGroupCheckBox.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(groupNameDescriptionLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(groupNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(stopGroupCheckBox)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(groupNameDescriptionLabel)
                                        .addComponent(groupNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stopGroupCheckBox))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel groupNameDescriptionLabel;
    private javax.swing.JTextField groupNameTextField;
    private javax.swing.JCheckBox stopGroupCheckBox;
    // End of variables declaration//GEN-END:variables
    private AuthorReference authorReference = null;
    private AuthorReferenceGroup authorReferenceGroup = null;
}
