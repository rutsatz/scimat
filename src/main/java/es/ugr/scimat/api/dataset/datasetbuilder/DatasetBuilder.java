/*
 * DatasetBuilder.java
 *
 * Created on 15-feb-2011, 17:46:26
 */
package es.ugr.scimat.api.dataset.datasetbuilder;

import es.ugr.scimat.api.dataset.Dataset;
import es.ugr.scimat.model.knowledgebase.entity.PublishDate;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public interface DatasetBuilder {

    public Dataset execute(ArrayList<PublishDate> publishDateList) throws KnowledgeBaseException;
}
