/*
 * NetworkBuilder.java
 *
 * Created on 11-feb-2011, 13:48:56
 */

package es.ugr.scimat.api.dataset.networkbuilder;

import es.ugr.scimat.api.dataset.UndirectNetworkMatrix;
import es.ugr.scimat.api.dataset.exception.NotExistsItemException;

/**
 *
 * @author mjcobo
 */
public interface NetworkBuilder {

  public UndirectNetworkMatrix execute() throws NotExistsItemException;
}
