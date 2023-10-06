/*
 * OverlappingMapPanel.java
 *
 * Created on 10-may-2011, 12:30:41
 */
package scimat.gui.components.analysisview;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.swing.JSVGScrollPane;
import org.w3c.dom.Document;
import scimat.api.analysis.temporal.EvolutionMap;
import scimat.api.mapping.clustering.result.ClusterSet;
import scimat.api.visualization.temporal.EvolutionMapSVG;

/**
 *
 * @author mjcobo
 */
public class EvolutionMapPanel extends javax.swing.JPanel {

  /** Creates new form OverlappingMapPanel */
  public EvolutionMapPanel() {

    this.svgCanvas = new JSVGCanvas();
    this.svgScrollPane = new JSVGScrollPane(svgCanvas);
    this.evolutionMapSVG = new EvolutionMapSVG(5, 30, 150, 0, 10);
    this.svgCanvas.setEnableImageZoomInteractor(true);
    this.svgCanvas.setEnablePanInteractor(true);
    this.svgCanvas.setEnableZoomInteractor(true);

    initComponents();

    this.addComponentListener(new ComponentAdapter() {

      @Override
      public void componentResized(ComponentEvent e) {

        svgCanvas.setDocument(document);
        svgCanvas.setRenderingTransform(new AffineTransform(50.0, 1, 1, 50.0, 1, 1));
      }
    });

    this.svgCanvas.setDocumentState(JSVGCanvas.ALWAYS_DYNAMIC);

    add(this.svgScrollPane);
  }
  
  /**
   * 
   * @param clusterSets
   * @param evolutionMap
   * @param volumePropertyName 
   */
  public void refreshItems(ArrayList<ClusterSet> clusterSets, EvolutionMap evolutionMap, String volumePropertyName, String labelPropertyName) {

    this.document = this.evolutionMapSVG.buildXML(clusterSets, evolutionMap, volumePropertyName, labelPropertyName);
     
    this.svgCanvas.setDocument(document);
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));
  }// </editor-fold>//GEN-END:initComponents
  // Variables declaration - do not modify//GEN-BEGIN:variables
  // End of variables declaration//GEN-END:variables
  private JSVGCanvas svgCanvas;
  private JSVGScrollPane svgScrollPane;
  private Document document;
  private EvolutionMapSVG evolutionMapSVG;
}
