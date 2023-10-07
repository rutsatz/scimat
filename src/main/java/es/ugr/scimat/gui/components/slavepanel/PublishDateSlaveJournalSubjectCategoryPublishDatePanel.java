/*
 * PublishDateSlaveJournalSubjectCategoryPublishDatePanel.java
 *
 * Created on 21-mar-2011, 19:19:37
 */
package es.ugr.scimat.gui.components.slavepanel;

import java.util.ArrayList;

import es.ugr.scimat.gui.components.tablemodel.SubjectCategorySlaveJournalSubjectCategoryPublishDateTableModel;
import es.ugr.scimat.gui.components.ErrorDialogManager;
import es.ugr.scimat.model.knowledgebase.entity.Journal;
import es.ugr.scimat.model.knowledgebase.entity.JournalSubjectCategoryPublishDate;
import es.ugr.scimat.model.knowledgebase.entity.PublishDate;
import es.ugr.scimat.model.knowledgebase.entity.SubjectCategory;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;
import es.ugr.scimat.project.observer.EntityObserver;
import es.ugr.scimat.project.observer.JournalRelationSubjectCategoryRelationPublishDateObserver;

/**
 *
 * @author mjcobo
 */
public class PublishDateSlaveJournalSubjectCategoryPublishDatePanel 
        extends GenericSlaveListPanel<PublishDate, JournalSubjectCategoryPublishDate>
        implements JournalRelationSubjectCategoryRelationPublishDateObserver {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  /**
   * 
   */
  public PublishDateSlaveJournalSubjectCategoryPublishDatePanel() {
    super(new SubjectCategorySlaveJournalSubjectCategoryPublishDateTableModel());
    
    CurrentProject.getInstance().getKbObserver().addJournalSubjectCategoryPublishDate(this);
    CurrentProject.getInstance().getKbObserver().addJournalObserver(new JournalWrapper());
    CurrentProject.getInstance().getKbObserver().addSubjectCategoryObserver(new SubjectCategoryWrapper());
  }

  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   *
   */
  public void setMasterItem(PublishDate publishDate) {

    this.masterItem = publishDate;

    try {

      if (this.masterItem != null) {

        relationChanged();

      } else {

        this.refreshData(new ArrayList<JournalSubjectCategoryPublishDate>());

      }

    } catch (KnowledgeBaseException e) {
    
      ErrorDialogManager.getInstance().showException(e);

    }
  }

  

  /**
   * 
   * @throws KnowledgeBaseException
   */
  public void relationChanged() throws KnowledgeBaseException {

    if (this.masterItem != null) {
      refreshData(CurrentProject.getInstance().getFactoryDAO().getPublishDateDAO().getSubjectCategories(this.masterItem.getPublishDateID()));
    }
  }

  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/

  /***************************************************************************/
  /*                           Private Classes                               */
  /***************************************************************************/

  /**
   *
   */
  private class JournalWrapper implements EntityObserver<Journal> {

    /**
     *
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityAdded(ArrayList<Journal> items) throws KnowledgeBaseException {
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
    public void entityRemoved(ArrayList<Journal> items) throws KnowledgeBaseException {
      // Do not do nothing
    }

    /**
     *
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityUpdated(ArrayList<Journal> items) throws KnowledgeBaseException {
      // Do not do nothing
    }
  }

  /**
   *
   */
  private class SubjectCategoryWrapper implements EntityObserver<SubjectCategory> {

    /**
     *
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityAdded(ArrayList<SubjectCategory> items) throws KnowledgeBaseException {
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
    public void entityRemoved(ArrayList<SubjectCategory> items) throws KnowledgeBaseException {
      // Do not do nothing
    }

    /**
     *
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityUpdated(ArrayList<SubjectCategory> items) throws KnowledgeBaseException {
      // Do not do nothing
    }
  }
}
