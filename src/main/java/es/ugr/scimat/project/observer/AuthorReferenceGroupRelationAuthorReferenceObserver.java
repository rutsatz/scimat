/*
 * AuthorReferenceGroupRelationAuthorReferenceObserver.java
 *
 * Created on 20-mar-2011, 21:09:38
 */
package es.ugr.scimat.project.observer;

import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;

/**
 * @author mjcobo
 */
public interface AuthorReferenceGroupRelationAuthorReferenceObserver {

    public void relationChanged() throws KnowledgeBaseException;
}
