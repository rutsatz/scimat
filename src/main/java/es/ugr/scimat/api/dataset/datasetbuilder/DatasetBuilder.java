/*
 * DatasetBuilder.java
 *
 * Created on 15-feb-2011, 17:46:26
 */
package es.ugr.scimat.api.dataset.datasetbuilder;

import java.util.ArrayList;
import es.ugr.scimat.api.dataset.Dataset;
import es.ugr.scimat.model.knowledgebase.entity.PublishDate;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;

/**
 *
 * @author mjcobo
 */
public interface DatasetBuilder {

  public Dataset execute(ArrayList<PublishDate> publishDateList) throws KnowledgeBaseException;
}
