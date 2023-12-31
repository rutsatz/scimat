/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrequencyDistributionPanel.java
 *
 * Created on 26-ene-2012, 14:00:12
 */
package es.ugr.scimat.gui.components.statistic;

import es.ugr.scimat.model.statistic.entity.FrequencyDistributionPerPeriod;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public class FrequencyDistributionPanel extends javax.swing.JPanel {

    /**
     * Creates new form FrequencyDistributionPanel
     */
    public FrequencyDistributionPanel() {
        initComponents();

        this.dataset = new XYSeriesCollection();

        this.chart = ChartFactory.createXYLineChart("Frequency distribution",
                "Units", "Documents", dataset, PlotOrientation.VERTICAL,
                true, false, false);

        this.chartPanel = new ChartPanel(chart);

        add(this.chartPanel);
    }

    /**
     * @param frequencies
     */
    public void refresh(ArrayList<FrequencyDistributionPerPeriod> frequencies) {

        this.frequencies = frequencies;

        refreshChart();
    }

    /**
     *
     */
    private void refreshChart() {

        int i, j;
        long maxFreq;
        FrequencyDistributionPerPeriod periodFrequency;
        XYSeries xySeries;

        this.dataset.removeAllSeries();

        for (i = 0; i < this.frequencies.size(); i++) {

            periodFrequency = this.frequencies.get(i);

            xySeries = new XYSeries(periodFrequency.getPeriod().getName());

            maxFreq = periodFrequency.getStats().getMaxFrequency();

            for (j = 1; j <= maxFreq; j++) {

                xySeries.add(j, periodFrequency.getStats().getCumFrequency(j));
            }

            this.dataset.addSeries(xySeries);
        }

        this.chart = ChartFactory.createXYLineChart("Frequency distribution",
                "", "Documents", dataset, PlotOrientation.VERTICAL,
                true, true, false);

        this.chartPanel.setChart(this.chart);
        this.chart.fireChartChanged();
    }

    /**
     * This method is called from within the constructor to
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
    private ArrayList<FrequencyDistributionPerPeriod> frequencies;
    private ChartPanel chartPanel;
    private JFreeChart chart;
    private XYSeriesCollection dataset;
}
