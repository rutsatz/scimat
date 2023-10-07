/*
 * DocumentRelationAuthorObserver.java
 *
 * Created on 20-mar-2011, 21:12:34
 */
package es.ugr.scimat.project.observer;

import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;

/**
 *
 * @author mjcobo
 */
public interface DocumentRelationAuthorObserver {

  public void relationChanged() throws KnowledgeBaseException;
}
