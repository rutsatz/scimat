/*
 * ReferencesListPanel.java
 *
 * Created on 17-nov-2011, 19:38:33
 */
package es.ugr.scimat.gui.components.itemslist;

import java.util.ArrayList;

import es.ugr.scimat.gui.components.tablemodel.ReferencesTableModel;
import es.ugr.scimat.model.knowledgebase.entity.Reference;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;
import es.ugr.scimat.project.observer.EntityObserver;

/**
 *
 * @author mjcobo
 */
public class ReferencesListPanel 
extends GenericDynamicItemsListPanel<Reference>
implements EntityObserver<Reference> {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/
  
  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/  

  /**
   * 
   * @param tableModel 
   */
  public ReferencesListPanel() {
    super(new ReferencesTableModel());
    
    CurrentProject.getInstance().getKbObserver().addReferenceObserver(this);
  }
  
  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   * 
   * @param items
   * @throws KnowledgeBaseException
   */
  public void entityAdded(ArrayList<Reference> items) throws KnowledgeBaseException {
    addItems(items);
  }

  /**
   * 
   * @param items
   * @throws KnowledgeBaseException 
   */
  public void entityRemoved(ArrayList<Reference> items) throws KnowledgeBaseException {
    removeItems(items);
  }

  /**
   * 
   * @param items
   * @throws KnowledgeBaseException 
   */
  public void entityUpdated(ArrayList<Reference> items) throws KnowledgeBaseException {
    updateItems(items);
  }

  /**
   * 
   * @throws KnowledgeBaseException 
   */
  public void entityRefresh() throws KnowledgeBaseException {
    refreshItems(CurrentProject.getInstance().getFactoryDAO().getReferenceDAO().getReferences());
  }
  
  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
