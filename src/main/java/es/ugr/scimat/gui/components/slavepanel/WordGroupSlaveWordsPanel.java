/*
 * WordGroupSlaveWordsPanel.java
 *
 * Created on 21-mar-2011, 19:19:37
 */
package es.ugr.scimat.gui.components.slavepanel;

import es.ugr.scimat.gui.components.ErrorDialogManager;
import es.ugr.scimat.gui.components.tablemodel.WordsTableModel;
import es.ugr.scimat.model.knowledgebase.entity.Word;
import es.ugr.scimat.model.knowledgebase.entity.WordGroup;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;
import es.ugr.scimat.project.observer.EntityObserver;
import es.ugr.scimat.project.observer.WordGroupRelationWordObserver;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class WordGroupSlaveWordsPanel
        extends GenericSlaveListPanel<WordGroup, Word>
        implements WordGroupRelationWordObserver, EntityObserver<Word> {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     *
     */
    public WordGroupSlaveWordsPanel() {
        super(new WordsTableModel());

        CurrentProject.getInstance().getKbObserver().addWordGroupRelationWordsObserver(this);
        CurrentProject.getInstance().getKbObserver().addWordObserver(this);
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     *
     */
    public void setMasterItem(WordGroup wordGroup) {

        this.masterItem = wordGroup;

        try {

            if (this.masterItem != null) {

                relationChanged();

            } else {

                this.refreshData(new ArrayList<Word>());

            }

        } catch (KnowledgeBaseException e) {

            ErrorDialogManager.getInstance().showException(e);

        }
    }

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityAdded(ArrayList<Word> items) throws KnowledgeBaseException {
        // Do not do nothing
    }

    /**
     * @param entity
     * @throws KnowledgeBaseException
     */
    public void entityRefresh() throws KnowledgeBaseException {

        relationChanged();
    }

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityRemoved(ArrayList<Word> items) throws KnowledgeBaseException {
        // Do not do nothing
    }

    /**
     * @param items
     * @throws KnowledgeBaseException
     */
    public void entityUpdated(ArrayList<Word> items) throws KnowledgeBaseException {
        // Do not do nothing
    }

    /**
     * @throws KnowledgeBaseException
     */
    public void relationChanged() throws KnowledgeBaseException {

        if (this.masterItem != null) {

            refreshData(CurrentProject.getInstance().getFactoryDAO().getWordGroupDAO().getWords(this.masterItem.getWordGroupID()));
        }
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
