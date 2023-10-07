/*
 * ReferenceSourceGroupsListPanel.java
 *
 * Created on 17-nov-2011, 19:38:33
 */
package es.ugr.scimat.gui.components.itemslist;

import java.util.ArrayList;

import es.ugr.scimat.gui.components.tablemodel.ReferenceSourceGroupsTableModel;
import es.ugr.scimat.model.knowledgebase.entity.ReferenceSourceGroup;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;
import es.ugr.scimat.project.observer.EntityObserver;

/**
 *
 * @author mjcobo
 */
public class ReferenceSourceGroupsListPanel 
extends GenericDynamicItemsListPanel<ReferenceSourceGroup>
implements EntityObserver<ReferenceSourceGroup> {

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
  public ReferenceSourceGroupsListPanel() {
    super(new ReferenceSourceGroupsTableModel());
    
    CurrentProject.getInstance().getKbObserver().addReferenceSourceGroupObserver(this);
  }
  
  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   * 
   * @param items
   * @throws KnowledgeBaseException
   */
  public void entityAdded(ArrayList<ReferenceSourceGroup> items) throws KnowledgeBaseException {
    addItems(items);
  }

  /**
   * 
   * @param items
   * @throws KnowledgeBaseException 
   */
  public void entityRemoved(ArrayList<ReferenceSourceGroup> items) throws KnowledgeBaseException {
    removeItems(items);
  }

  /**
   * 
   * @param items
   * @throws KnowledgeBaseException 
   */
  public void entityUpdated(ArrayList<ReferenceSourceGroup> items) throws KnowledgeBaseException {
    updateItems(items);
  }

  /**
   * 
   * @throws KnowledgeBaseException 
   */
  public void entityRefresh() throws KnowledgeBaseException {
    refreshItems(CurrentProject.getInstance().getFactoryDAO().getReferenceSourceGroupDAO().getReferenceSourceGroups());
  }
  
  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}