/*
 * Normalizer.java
 *
 * Created on 14-feb-2011, 23:47:57
 */

package es.ugr.scimat.api.similaritymeasure;

import es.ugr.scimat.api.dataset.Dataset;
import es.ugr.scimat.api.dataset.UndirectNetworkMatrix;
import es.ugr.scimat.api.dataset.exception.NotExistsItemException;

/**
 * @author mjcobo
 */
public interface Normalizer {

    /**
     * @param dataset
     * @param network
     * @throws NotExistsItemException
     */
    public void execute(Dataset dataset, UndirectNetworkMatrix network) throws NotExistsItemException;
}
