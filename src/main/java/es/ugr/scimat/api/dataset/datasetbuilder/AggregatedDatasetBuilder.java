/*
 * AggregatedDatasetBuilder.java
 *
 * Created on 15-feb-2011, 17:46:26
 */
package es.ugr.scimat.api.dataset.datasetbuilder;

import es.ugr.scimat.api.dataset.AggregatedDataset;
import es.ugr.scimat.api.dataset.Dataset;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;

/**
 *
 * @author mjcobo
 */
public interface AggregatedDatasetBuilder {

  public AggregatedDataset execute(Dataset dataset) throws KnowledgeBaseException;
}
