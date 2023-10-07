/*
 * RemoveSubjectCategoryEvent.java
 *
 * Created on 28-dic-2011, 20:10:51
 */
package es.ugr.scimat.knowledgebaseevents.event.remove;

import es.ugr.scimat.knowledgebaseevents.event.KnowledgeBaseEvent;
import es.ugr.scimat.model.knowledgebase.entity.SubjectCategory;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class RemoveSubjectCategoryEvent implements KnowledgeBaseEvent {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /**
     *
     */
    private ArrayList<SubjectCategory> subjectCategories;

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     * @param subjectCategories
     */
    public RemoveSubjectCategoryEvent(ArrayList<SubjectCategory> subjectCategories) {
        this.subjectCategories = subjectCategories;
    }

    /**
     * @param subjectCategories
     */
    public RemoveSubjectCategoryEvent(SubjectCategory subjectCategory) {
        this.subjectCategories = new ArrayList<SubjectCategory>();
        this.subjectCategories.add(subjectCategory);
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * @throws KnowledgeBaseException
     */
    public void fireEvent() throws KnowledgeBaseException {

        CurrentProject.getInstance().getKbObserver().fireSubjectCategoryRemoved(subjectCategories);
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
