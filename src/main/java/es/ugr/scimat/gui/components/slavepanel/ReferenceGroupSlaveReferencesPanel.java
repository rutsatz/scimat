/*
 * ReferenceGroupSlaveReferencesPanel.java
 *
 * Created on 21-mar-2011, 19:19:37
 */
package es.ugr.scimat.gui.components.slavepanel;

import java.util.ArrayList;

import es.ugr.scimat.gui.components.tablemodel.ReferencesTableModel;
import es.ugr.scimat.gui.components.ErrorDialogManager;
import es.ugr.scimat.model.knowledgebase.entity.Reference;
import es.ugr.scimat.model.knowledgebase.entity.ReferenceGroup;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;
import es.ugr.scimat.project.observer.EntityObserver;
import es.ugr.scimat.project.observer.ReferenceGroupRelationReferenceObserver;

/**
 *
 * @author mjcobo
 */
public class ReferenceGroupSlaveReferencesPanel 
        extends GenericSlaveListPanel<ReferenceGroup, Reference>
        implements ReferenceGroupRelationReferenceObserver, EntityObserver<Reference> {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  /**
   * 
   */
  public ReferenceGroupSlaveReferencesPanel() {
    super(new ReferencesTableModel());

    CurrentProject.getInstance().getKbObserver().addReferenceGroupRelationReferencesObserver(this);
    CurrentProject.getInstance().getKbObserver().addReferenceObserver(this);
  }

  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   *
   */
  public void setMasterItem(ReferenceGroup ReferenceGroup) {

    this.masterItem = ReferenceGroup;

    try {

      if (this.masterItem != null) {

        relationChanged();

      } else {

        this.refreshData(new ArrayList<Reference>());

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
      
      refreshData(CurrentProject.getInstance().getFactoryDAO().getReferenceGroupDAO().getReferences(this.masterItem.getReferenceGroupID()));
    }
  }

  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
