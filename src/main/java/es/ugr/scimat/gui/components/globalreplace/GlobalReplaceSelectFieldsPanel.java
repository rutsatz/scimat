/*
 * GlobalReplaceSelectFieldsPanel.java
 *
 * Created on 22-ene-2012, 17:09:43
 */
package es.ugr.scimat.gui.components.globalreplace;

import es.ugr.scimat.gui.components.IncorrectDataObserver;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public abstract class GlobalReplaceSelectFieldsPanel extends javax.swing.JPanel {

    /***************************************************************************/
    /*                        Private attributes                               */
    /***************************************************************************/

    private ArrayList<IncorrectDataObserver> incorrectDataObservers = new ArrayList<IncorrectDataObserver>();

    /***************************************************************************/
    /*                            Constructors                                 */
    /***************************************************************************/

    /**
     *
     */
    public GlobalReplaceSelectFieldsPanel() {
    }

    /***************************************************************************/
    /*                           Public Methods                                */
    /***************************************************************************/

    /**
     * Añade un nuevo observador de datos incorrectos.
     *
     * @param observer observador a añadir.
     */
    public void addIncorrectDataObserver(IncorrectDataObserver observer) {
        incorrectDataObservers.add(observer);
        fireIncorrectDataObservers();
    }

    /**
     *
     */
    public void notifyIncorrectDataObservers(boolean correct, String message) {

        for (int i = 0; i < incorrectDataObservers.size(); i++) {

            incorrectDataObservers.get(i).incorrectData(correct, message);
        }
    }

    /**
     *
     */
    public abstract void fireIncorrectDataObservers();

    /**
     * @param find
     * @param replace
     */
    public abstract void doGlobalReplaceAction(String find, String replace);
}
