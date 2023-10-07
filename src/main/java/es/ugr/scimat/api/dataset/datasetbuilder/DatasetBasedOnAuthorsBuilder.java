/*
 * DatasetBasedOnAuthorsBuilder.java
 *
 * Created on 15-feb-2011, 17:48:32
 */
package es.ugr.scimat.api.dataset.datasetbuilder;

import es.ugr.scimat.api.dataset.Dataset;
import es.ugr.scimat.api.dataset.exception.NotExistsItemException;
import es.ugr.scimat.model.knowledgebase.KnowledgeBaseManager;
import es.ugr.scimat.model.knowledgebase.dao.AuthorDAO;
import es.ugr.scimat.model.knowledgebase.dao.DocumentDAO;
import es.ugr.scimat.model.knowledgebase.dao.PublishDateDAO;
import es.ugr.scimat.model.knowledgebase.entity.*;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class DatasetBasedOnAuthorsBuilder implements DatasetBuilder {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    private KnowledgeBaseManager kbm;

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     *
     */
    public DatasetBasedOnAuthorsBuilder(KnowledgeBaseManager kbm) {

        this.kbm = kbm;
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @param publishDateList
     * @return
     * @throws KnowledgeBaseException
     */
    public Dataset execute(ArrayList<PublishDate> publishDateList) throws KnowledgeBaseException {

        int i, j, k;
        PublishDateDAO publishDateDAO = new PublishDateDAO(this.kbm);
        DocumentDAO documentDAO = new DocumentDAO(this.kbm);
        AuthorDAO authorDAO = new AuthorDAO(this.kbm);
        Document document;
        ArrayList<Document> documentsList;
        Author author;
        ArrayList<DocumentAuthor> authorsList;
        AuthorGroup authorGroup;
        Dataset dataset;

        dataset = new Dataset();

        // For each year we retrieved all the documents associated with it.
        for (i = 0; i < publishDateList.size(); i++) {

            documentsList = publishDateDAO.getDocuments(publishDateList.get(i).getPublishDateID());

            // For each document we retrieved its associated authors.
            for (j = 0; j < documentsList.size(); j++) {

                document = documentsList.get(j);

                // Add the document to the dataset
                dataset.addDocument(document.getDocumentID(), document.getCitationsCount());

                authorsList = documentDAO.getDocumentAuthors(document.getDocumentID());

                // For each auhor, if it has a authorGroup associated and this group is
                // not a stopGroup, we add this item to the document in the dataset.
                for (k = 0; k < authorsList.size(); k++) {

                    author = authorsList.get(k).getAuthor();

                    authorGroup = authorDAO.getAuthorGroup(author.getAuthorID());

                    if ((authorGroup != null) && (!authorGroup.isStopGroup())) {

                        try {

                            dataset.addItemToDocument(document.getDocumentID(),
                                    authorGroup.getAuthorGroupID(),
                                    authorGroup.getGroupName());

                        } catch (NotExistsItemException e) {

                            System.err.println("An internal error occurs within the dataset "
                                    + "construction. The document "
                                    + document.getDocumentID() + " does not exist.");

                            e.printStackTrace(System.err);
                        }
                    }
                }
            }

        }

        return dataset;
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
