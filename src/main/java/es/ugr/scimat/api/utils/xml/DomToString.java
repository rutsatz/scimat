/*
 * DomToString.java
 *
 * Created on 06-abr-2011, 14:30:04
 */
package es.ugr.scimat.api.utils.xml;

import org.w3c.dom.Document;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

/**
 * @author mjcobo
 */
public class DomToString {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /***************************************************************************/
    /*                           Public Methods                                */

    /***************************************************************************/

    public String convert(Document doc) {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;

        try {
            transformer = transformerFactory.newTransformer();
        } catch (javax.xml.transform.TransformerConfigurationException error) {

            return null;
        }

        Source source = new DOMSource(doc);
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        StringWriter writer = new StringWriter();
        Result result = new StreamResult(writer);
        try {

            transformer.transform(source, result);
        } catch (javax.xml.transform.TransformerException error) {

            return null;
        }

        String s = writer.toString();
        return s;
    }

    /***************************************************************************/
    /*                           Private Methods                               */
    /***************************************************************************/
}
