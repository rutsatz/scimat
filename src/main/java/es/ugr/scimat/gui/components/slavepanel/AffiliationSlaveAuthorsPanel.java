/*
 * AffiliationSlaveAuthorsPanel.java
 *
 * Created on 21-mar-2011, 19:19:37
 */
package es.ugr.scimat.gui.components.slavepanel;

import java.util.ArrayList;

import es.ugr.scimat.gui.components.tablemodel.AuthorsTableModel;
import es.ugr.scimat.gui.components.ErrorDialogManager;
import es.ugr.scimat.model.knowledgebase.entity.Affiliation;
import es.ugr.scimat.model.knowledgebase.entity.Author;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;
import es.ugr.scimat.project.observer.AuthorRelationAffiliationObserver;
import es.ugr.scimat.project.observer.EntityObserver;

/**
 *
 * @author mjcobo
 */
public class AffiliationSlaveAuthorsPanel 
        extends GenericSlaveListPanel<Affiliation, Author>
        implements AuthorRelationAffiliationObserver, EntityObserver<Author> {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  /**
   * 
   */
  public AffiliationSlaveAuthorsPanel() {
    super(new AuthorsTableModel());

    CurrentProject.getInstance().getKbObserver().addAuthorRelationAffiliationsObservers(this);
    CurrentProject.getInstance().getKbObserver().addAuthorObserver(this);
  }

  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   *
   */
  public void setMasterItem(Affiliation affiliation) {

    this.masterItem = affiliation;

    try {

      if (this.masterItem != null) {

        relationChanged();

      } else {

        this.refreshData(new ArrayList<Author>());

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
  public void entityAdded(ArrayList<Author> items) throws KnowledgeBaseException {
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
  public void entityRemoved(ArrayList<Author> items) throws KnowledgeBaseException {
    // Do not do nothing
  }

  /**
   * 
   * @param items
   * @throws KnowledgeBaseException
   */
  public void entityUpdated(ArrayList<Author> items) throws KnowledgeBaseException {
    // Do not do nothing
  }

  /**
   * 
   * @throws KnowledgeBaseException
   */
  public void relationChanged() throws KnowledgeBaseException {

    if (this.masterItem != null) {
      
      refreshData(CurrentProject.getInstance().getFactoryDAO().getAffiliationDAO().getAuthors(this.masterItem.getAffiliationID()));
    }
  }

  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
