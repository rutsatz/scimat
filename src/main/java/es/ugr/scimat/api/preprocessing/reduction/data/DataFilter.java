/*
 * GenericDataFilter.java
 *
 * Created on 08-feb-2011, 19:09:30
 */
package es.ugr.scimat.api.preprocessing.reduction.data;

import es.ugr.scimat.api.dataset.Dataset;

/**
 * This interface implements a generic filter which performs a data reduction
 * over a dataset.
 *
 * @author mjcobo
 */
public interface DataFilter {

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * Under this method the classes which implement this filter have tp implement
     * the filer.
     * <p>
     * NOTE: the dataset will be modified.
     */
    public void execute(Dataset dataset);

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
