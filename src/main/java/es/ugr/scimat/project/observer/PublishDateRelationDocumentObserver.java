/*
 * PublishDateRelationDocumentObserver.java
 *
 * Created on 20-mar-2011, 21:10:40
 */
package es.ugr.scimat.project.observer;

import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;

/**
 * @author mjcobo
 */
public interface PublishDateRelationDocumentObserver {

    public void relationChanged() throws KnowledgeBaseException;
}
