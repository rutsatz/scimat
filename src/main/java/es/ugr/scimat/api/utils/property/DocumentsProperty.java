/*
 * CollectionProperty.java
 *
 * Created on 15-feb-2011, 19:07:53
 */
package es.ugr.scimat.api.utils.property;

import es.ugr.scimat.api.analysis.performance.docmapper.DocumentSet;

/**
 *
 * @author mjcobo
 */
public class DocumentsProperty extends Property<DocumentSet> {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  /**
   * 
   * @param elementsList
   */
  public DocumentsProperty(DocumentSet documentSet) {
    super(documentSet, PropertyTypes.DocumentsProperty);
    
  }

  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/

}
