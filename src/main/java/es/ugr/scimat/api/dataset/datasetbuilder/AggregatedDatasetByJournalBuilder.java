/*
 * AggregatedDatasetByJournalBuilder.java
 *
 * Created on 02-abr-2011, 17:04:33
 */
package es.ugr.scimat.api.dataset.datasetbuilder;

import java.util.ArrayList;
import es.ugr.scimat.api.dataset.AggregatedDataset;
import es.ugr.scimat.api.dataset.Dataset;
import es.ugr.scimat.model.knowledgebase.KnowledgeBaseManager;
import es.ugr.scimat.model.knowledgebase.dao.DocumentDAO;
import es.ugr.scimat.model.knowledgebase.entity.Journal;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;

/**
 *
 * @author mjcobo
 */
public class AggregatedDatasetByJournalBuilder implements AggregatedDatasetBuilder{

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  /**
   * 
   */
  private KnowledgeBaseManager kbm;
  
  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  /**
   * 
   */
  public AggregatedDatasetByJournalBuilder(KnowledgeBaseManager kbm) {
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
        
    int i;
    AggregatedDataset aggregatedDataset;
    Integer docID;
    Journal journal;
    ArrayList<Integer> documents;
    DocumentDAO documentDAO;
    
    aggregatedDataset = new AggregatedDataset(dataset);
    
    documentDAO = new DocumentDAO(this.kbm);
    
    documents = dataset.getDocuments();
    
    for (i = 0; i < documents.size(); i++) {
    
      docID = documents.get(i);
      
      journal = documentDAO.getJournal(docID);
      
      if (journal != null) {
        
        aggregatedDataset.addHighLevelItem(journal.getJournalID(), journal.getSource());
        aggregatedDataset.addDocumentToHighLevelItem(journal.getJournalID(), docID);
      }
    }
    
    return aggregatedDataset;
  }

  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
