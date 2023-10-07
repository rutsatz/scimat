/*
 * AuthorReferenceSlaveReferencesPanel.java
 *
 * Created on 21-mar-2011, 19:19:37
 */
package es.ugr.scimat.gui.components.slavepanel;

import java.util.ArrayList;

import es.ugr.scimat.gui.components.tablemodel.AuthorReferenceSlaveReferenceTableModel;
import es.ugr.scimat.gui.components.ErrorDialogManager;
import es.ugr.scimat.model.knowledgebase.entity.AuthorReference;
import es.ugr.scimat.model.knowledgebase.entity.AuthorReferenceReference;
import es.ugr.scimat.model.knowledgebase.entity.Reference;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;
import es.ugr.scimat.project.observer.EntityObserver;
import es.ugr.scimat.project.observer.ReferenceRelationAuthorReferenceObserver;

/**
 *
 * @author mjcobo
 */
public class AuthorReferenceSlaveReferencesPanel 
        extends GenericSlaveListPanel<AuthorReference, AuthorReferenceReference>
        implements ReferenceRelationAuthorReferenceObserver, EntityObserver<Reference> {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  /**
   * 
   */
  public AuthorReferenceSlaveReferencesPanel() {
    super(new AuthorReferenceSlaveReferenceTableModel());

    CurrentProject.getInstance().getKbObserver().addReferenceRelationAuthorReferenceObserver(this);
    CurrentProject.getInstance().getKbObserver().addReferenceObserver(this);
  }

  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   *
   */
  public void setMasterItem(AuthorReference authorReference) {

    this.masterItem = authorReference;

    try {

      if (this.masterItem != null) {

        relationChanged();

      } else {

        this.refreshData(new ArrayList<AuthorReferenceReference>());

      }

    } catch (KnowledgeBaseException e) {
    
      ErrorDialogManager.getInstance().showException(e);

    }
  }

  /**
   *
   * @param items
   * @throws KnowledgeBaseException
   */
  public void entityAdded(ArrayList<Reference> items) throws KnowledgeBaseException {
    // Do not do nothing
  }

  /**
   *
   * @param entity
   * @throws KnowledgeBaseException
   */
  public void entityRefresh() throws KnowledgeBaseException {

    relationChanged();
  }

  /**
   *
   * @param items
   * @throws KnowledgeBaseException
   */
  public void entityRemoved(ArrayList<Reference> items) throws KnowledgeBaseException {
    // Do not do nothing
  }

  /**
   * 
   * @param items
   * @throws KnowledgeBaseException
   */
  public void entityUpdated(ArrayList<Reference> items) throws KnowledgeBaseException {
    // Do not do nothing
  }

  /**
   * 
   * @throws KnowledgeBaseException
   */
  public void relationChanged() throws KnowledgeBaseException {

    if (this.masterItem != null) {
      refreshData(CurrentProject.getInstance().getFactoryDAO().getAuthorReferenceDAO().getReferences(this.masterItem.getAuthorReferenceID()));
    }
  }

  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
