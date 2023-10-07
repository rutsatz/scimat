/*
 * GenericNetworkFilter.java
 *
 * Created on 14-feb-2011, 18:11:38
 */
package es.ugr.scimat.api.preprocessing.reduction.network;

import es.ugr.scimat.api.dataset.UndirectNetworkMatrix;

/**
 * This interface implements a generic filter which performs a network reduction
 * over a network.
 * 
 * @author mjcobo
 */
public interface NetworkFilter {

  /**
   * Under this method the classes which implement this filter have to implement
   * the filer's functionality.
   *
   * NOTE: the dataset will be modified.
   */
  public void execute(UndirectNetworkMatrix network);
}
