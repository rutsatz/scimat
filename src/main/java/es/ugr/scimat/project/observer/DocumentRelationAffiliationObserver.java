/*
 * DocumentRelationAffiliationObserver.java
 *
 * Created on 20-mar-2011, 21:11:52
 */
package es.ugr.scimat.project.observer;

import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;

/**
 * @author mjcobo
 */
public interface DocumentRelationAffiliationObserver {

    public void relationChanged() throws KnowledgeBaseException;
}
