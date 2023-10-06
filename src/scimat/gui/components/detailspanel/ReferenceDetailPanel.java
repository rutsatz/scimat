/*
 * ArticleDetailPanel.java
 *
 * Created on 26-nov-2008, 12:17:56
 */
package scimat.gui.components.detailspanel;

import java.util.ArrayList;
import scimat.model.knowledgebase.entity.Reference;
import scimat.model.knowledgebase.exception.KnowledgeBaseException;
import scimat.project.CurrentProject;

/**
 *
 * @author Manuel Jesus Cobo Martin.
 */
public class ReferenceDetailPanel extends GenericDetailPanel<Reference> {

  /** 
   * Creates new form ArticleDetailPanel
   */
  public ReferenceDetailPanel() {
    initComponents();

    CurrentProject.getInstance().getKbObserver().addReferenceObserver(this);
  }

  /**
   * 
   */
  public void reset() {

    idTextField.setText("");
    formatTextField.setText("");
    fullReferenceTextField.setText("");
    issueTextField.setText("");
    volumeTextField.setText("");
    pagesTextField.setText("");
    yearTextField.setText("");
    doiTextField.setText("");

    setEnableTextField(false);
  }

  /**
   *
   */
  public void setEnableTextField(boolean enabled) {

    idTextField.setEnabled(enabled);
    formatTextField.setEnabled(enabled);
    fullReferenceTextField.setEnabled(enabled);
    issueTextField.setEnabled(enabled);
    volumeTextField.setEnabled(enabled);
    pagesTextField.setEnabled(enabled);
    yearTextField.setEnabled(enabled);
    doiTextField.setEnabled(enabled);
  }

  /**
   * 
   * @param reference
   */
  public void refreshItem(Reference reference) {

    this.reference = reference;

    // Si existe un articulo con ese identificador.
    if (reference != null) {

      idTextField.setText(this.reference.getReferenceID().toString());
      formatTextField.setText(this.reference.getFormat());
      fullReferenceTextField.setText(this.reference.getFullReference());
      issueTextField.setText(this.reference.getIssue());
      volumeTextField.setText(this.reference.getVolume());
      pagesTextField.setText(this.reference.getPage());
      yearTextField.setText(this.reference.getYear());
      doiTextField.setText(this.reference.getDoi());

      setEnableTextField(true);

    } else {

      reset();
    }
  }

  /**
   * 
   * @return
   */
  public String getFormat() {

    return formatTextField.getText();
  }

  /**
   *
   * @return
   */
  public String getFullReference() {

    return fullReferenceTextField.getText();
  }

  /**
   *
   * @return
   */
  public String getIssue() {

    return issueTextField.getText();
  }

  /**
   *
   * @return
   */
  public String getVolume() {

    return volumeTextField.getText();
  }

  /**
   * 
   * @return
   */
  public String getPage() {

    return pagesTextField.getText();
  }

  /**
   * 
   * @return
   */
  public String getYear() {

    return yearTextField.getText();
  }

  /**
   * 
   * @return
   */
  public String getDoi() {

    return doiTextField.getText();
  }

  public void entityAdded(ArrayList<Reference> items) throws KnowledgeBaseException {
    // Do Nothing
  }

  public void entityRefresh() throws KnowledgeBaseException {
    // Do Nothing
  }

  public void entityUpdated(ArrayList<Reference> items) throws KnowledgeBaseException {

    int position;

    position = items.indexOf(this.reference);

    if (position != -1) {

      refreshItem(items.get(position));

    }
  }

  public void entityRemoved(ArrayList<Reference> items) throws KnowledgeBaseException {
    // Do Nothing
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    idDescriptionLabel = new javax.swing.JLabel();
    idTextField = new javax.swing.JTextField();
    formatDescriptionLabel = new javax.swing.JLabel();
    formatTextField = new javax.swing.JTextField();
    fullReferenceDescriptionLabel = new javax.swing.JLabel();
    fullReferenceTextField = new javax.swing.JTextField();
    issueDescriptionLabel = new javax.swing.JLabel();
    volumeDescriptionLabel = new javax.swing.JLabel();
    volumeTextField = new javax.swing.JTextField();
    pagesDescriptionLabel = new javax.swing.JLabel();
    pagesTextField = new javax.swing.JTextField();
    yearDescriptionLabel = new javax.swing.JLabel();
    yearTextField = new javax.swing.JTextField();
    doiDescriptionLabel = new javax.swing.JLabel();
    doiTextField = new javax.swing.JTextField();
    issueTextField = new javax.swing.JTextField();

    idDescriptionLabel.setText("ID:");

    idTextField.setEditable(false);

    formatDescriptionLabel.setText("Format:");

    fullReferenceDescriptionLabel.setText("Full reference:");

    issueDescriptionLabel.setText("Issue:");

    volumeDescriptionLabel.setText("Volume:");

    pagesDescriptionLabel.setText("Pages:");

    yearDescriptionLabel.setText("Year:");

    doiDescriptionLabel.setText("Doi:");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(idDescriptionLabel)
          .addComponent(fullReferenceDescriptionLabel)
          .addComponent(issueDescriptionLabel)
          .addComponent(doiDescriptionLabel))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(formatDescriptionLabel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(formatTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
          .addComponent(doiTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
          .addComponent(fullReferenceTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addComponent(issueTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(volumeDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(volumeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(pagesDescriptionLabel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(pagesTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(yearDescriptionLabel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(yearTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(idDescriptionLabel)
          .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(formatDescriptionLabel)
          .addComponent(formatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(fullReferenceDescriptionLabel)
          .addComponent(fullReferenceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(issueDescriptionLabel)
          .addComponent(volumeDescriptionLabel)
          .addComponent(volumeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(pagesDescriptionLabel)
          .addComponent(pagesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(yearDescriptionLabel)
          .addComponent(yearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(issueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(doiDescriptionLabel)
          .addComponent(doiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
    );
  }// </editor-fold>//GEN-END:initComponents

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel doiDescriptionLabel;
  private javax.swing.JTextField doiTextField;
  private javax.swing.JLabel formatDescriptionLabel;
  private javax.swing.JTextField formatTextField;
  private javax.swing.JLabel fullReferenceDescriptionLabel;
  private javax.swing.JTextField fullReferenceTextField;
  private javax.swing.JLabel idDescriptionLabel;
  private javax.swing.JTextField idTextField;
  private javax.swing.JLabel issueDescriptionLabel;
  private javax.swing.JTextField issueTextField;
  private javax.swing.JLabel pagesDescriptionLabel;
  private javax.swing.JTextField pagesTextField;
  private javax.swing.JLabel volumeDescriptionLabel;
  private javax.swing.JTextField volumeTextField;
  private javax.swing.JLabel yearDescriptionLabel;
  private javax.swing.JTextField yearTextField;
  // End of variables declaration//GEN-END:variables
  private Reference reference;
}
