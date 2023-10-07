/*
 * WordDetailPanel.java
 *
 * Created on 28-ene-2009, 10:42:51
 */
package es.ugr.scimat.gui.components.detailspanel;

import java.util.ArrayList;
import es.ugr.scimat.model.knowledgebase.entity.Word;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

/**
 *
 * @author Manuel Jesús Cobo Martin
 */
public class WordDetailPanel extends GenericDetailPanel<Word> {

  /** 
   * Creates new form WordDetailPanel
   */
  public WordDetailPanel() {
    initComponents();

    CurrentProject.getInstance().getKbObserver().addWordObserver(this);
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
   * 
   * @param word
   */
  public void refreshItem(Word word) {

    this.word = word;

    if (word != null) {

      idTextField.setText(this.word.getWordID().toString());
      nameTextField.setText(this.word.getWordName());

      setEnableTextField(true);

    } else {

      reset();

    }
  }

  public String getWordName() {

    return nameTextField.getText();
  }

  public void entityAdded(ArrayList<Word> items) throws KnowledgeBaseException {
    // Do Nothing
  }

  public void entityRefresh() throws KnowledgeBaseException {
    // Do Nothing
  }

  public void entityUpdated(ArrayList<Word> items) throws KnowledgeBaseException {

    int position;

    position = items.indexOf(this.word);

    if (position != -1) {

      refreshItem(items.get(position));

    }
  }

  public void entityRemoved(ArrayList<Word> items) throws KnowledgeBaseException {
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
  private Word word;
}