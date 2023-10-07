/*
 * JournalRelationSubjectCategoryRelationPublishDateObserver.java
 *
 * Created on 20-mar-2011, 21:13:20
 */
package es.ugr.scimat.project.observer;

import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;

/**
 * @author mjcobo
 */
public interface JournalRelationSubjectCategoryRelationPublishDateObserver {

    public void relationChanged() throws KnowledgeBaseException;
}
