/*
 * AggregatedDatasetByAuthorBuilder.java
 *
 * Created on 02-abr-2011, 17:04:43
 */
package es.ugr.scimat.api.dataset.datasetbuilder;

import java.util.ArrayList;
import es.ugr.scimat.api.dataset.AggregatedDataset;
import es.ugr.scimat.api.dataset.Dataset;
import es.ugr.scimat.model.knowledgebase.KnowledgeBaseManager;
import es.ugr.scimat.model.knowledgebase.dao.DocumentDAO;
import es.ugr.scimat.model.knowledgebase.entity.DocumentAuthor;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;

/**
 *
 * @author mjcobo
 */
public class AggregatedDatasetByAuthorBuilder implements AggregatedDatasetBuilder {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  private KnowledgeBaseManager kbm;
  
  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  /**
   * 
   * @param kbm 
   */
  public AggregatedDatasetByAuthorBuilder(KnowledgeBaseManager kbm) {
    this.kbm = kbm;
  }
  
  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   * 
   * @param dataset
   * @return
   * @throws KnowledgeBaseException
   */
  public AggregatedDataset execute(Dataset dataset) throws KnowledgeBaseException {
    
    int i, j;
    AggregatedDataset aggregatedDataset;
    Integer docID;
    ArrayList<DocumentAuthor> documentAuthors;
    DocumentAuthor documentAuthor;
    ArrayList<Integer> documents;
    DocumentDAO documentDAO;
    
    aggregatedDataset = new AggregatedDataset(dataset);
    
    documentDAO = new DocumentDAO(this.kbm);
    
    documents = dataset.getDocuments();
    
    for (i = 0; i < documents.size(); i++) {
    
      docID = documents.get(i);
      
      documentAuthors = documentDAO.getDocumentAuthors(docID);
      
      for (j = 0; j < documentAuthors.size(); j++) {
      
        documentAuthor = documentAuthors.get(j);

        aggregatedDataset.addHighLevelItem(documentAuthor.getAuthor().getAuthorID(), documentAuthor.getAuthor().getAuthorName());
        aggregatedDataset.addDocumentToHighLevelItem(documentAuthor.getAuthor().getAuthorID(), docID);
      }
    }
    
    return aggregatedDataset;
  }

  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
