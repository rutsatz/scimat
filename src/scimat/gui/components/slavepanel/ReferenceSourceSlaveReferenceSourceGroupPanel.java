/*
 * ReferenceSlaveReferenceGroupPanel.java
 *
 * Created on 21-mar-2011, 11:34:59
 */
package scimat.gui.components.slavepanel;

import java.util.ArrayList;
import scimat.gui.components.ErrorDialogManager;
import scimat.model.knowledgebase.entity.ReferenceSource;
import scimat.model.knowledgebase.entity.ReferenceSourceGroup;
import scimat.model.knowledgebase.exception.KnowledgeBaseException;
import scimat.project.CurrentProject;
import scimat.project.observer.EntityObserver;
import scimat.project.observer.ReferenceSourceGroupRelationReferenceSourceObserver;

/**
 *
 * @author mjcobo
 */
public class ReferenceSourceSlaveReferenceSourceGroupPanel extends GenericOneSlaveItemPanel
        implements ReferenceSourceGroupRelationReferenceSourceObserver, EntityObserver<ReferenceSourceGroup> {

  /** Creates new form WordSlaveWordGroupPanel */
  public ReferenceSourceSlaveReferenceSourceGroupPanel() {
    initComponents();

    CurrentProject.getInstance().getKbObserver().addReferenceSourceGroupRelationReferenceSourcesObserver(this);
    CurrentProject.getInstance().getKbObserver().addReferenceSourceGroupObserver(this);
  }

  /**
   *
   */
  private void refresh() {

    if (this.referenceSourceGroup != null) {

      this.groupNameTextField.setText(this.referenceSourceGroup.getGroupName());
      this.stopGroupCheckBox.setSelected(this.referenceSourceGroup.isStopGroup());
      fireSlaveItemObserver(true);

    } else {

      this.groupNameTextField.setText("");
      this.stopGroupCheckBox.setSelected(false);
    }
  }

  /**
   *
   */
  public void setMasterItem(ReferenceSource referenceSource) {

    this.referenceSource = referenceSource;

    try {

      if (this.referenceSource != null) {

        relationChanged();

      } else {

        this.referenceSourceGroup = null;
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

    if (this.referenceSource != null) {
      
      this.referenceSourceGroup = CurrentProject.getInstance().getFactoryDAO().getReferenceSourceDAO().getReferenceSourceGroup(this.referenceSource.getReferenceSourceID());
      
    } else {
      
      this.referenceSourceGroup = null;
    }
    
    refresh();
  }

  /**
   *
   * @param items
   * @throws KnowledgeBaseException
   */
  public void entityAdded(ArrayList<ReferenceSourceGroup> items) throws KnowledgeBaseException {
    // Do not do nothing
  }

  /**
   *
   * @param entity
   * @throws KnowledgeBaseException
   */
  public void entityRefresh() throws KnowledgeBaseException {

    if (this.referenceSourceGroup != null) {

      this.referenceSourceGroup = CurrentProject.getInstance().getFactoryDAO().getReferenceSourceGroupDAO().getReferenceSourceGroup(this.referenceSourceGroup.getReferenceSourceGroupID());
      refresh();
    }
  }

  /**
   *
   * @param items
   * @throws KnowledgeBaseException
   */
  public void entityRemoved(ArrayList<ReferenceSourceGroup> items) throws KnowledgeBaseException {
    // Do not do nothing
  }

  /**
   *
   * @param items
   * @throws KnowledgeBaseException
   */
  public void entityUpdated(ArrayList<ReferenceSourceGroup> items) throws KnowledgeBaseException {

    int position;

    if (this.referenceSourceGroup != null) {

      position = items.indexOf(this.referenceSourceGroup);

      if (position != -1) {

        this.referenceSourceGroup = items.get(position);
      }
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
  private ReferenceSource referenceSource = null;
  private ReferenceSourceGroup referenceSourceGroup = null;
}
