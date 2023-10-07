/*
 * GenericStatisticDialog.java
 *
 * Created on 25-ene-2012, 18:29:30
 */
package es.ugr.scimat.gui.components.statistic;

import es.ugr.scimat.api.analysis.statistic.StatisticBasedFrequency;
import es.ugr.scimat.gui.components.ErrorDialogManager;
import es.ugr.scimat.gui.components.itemslist.StatisticPerPeriodListPanel;
import es.ugr.scimat.model.knowledgebase.entity.Period;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.model.statistic.entity.FrequencyDistributionPerPeriod;
import es.ugr.scimat.model.statistic.entity.StatisticPerPeriod;
import es.ugr.scimat.project.CurrentProject;

import java.util.ArrayList;

/**
 * @author mjcobo
 */
public abstract class GenericStatisticDialog extends javax.swing.JDialog {

    /**
     * Creates new form GenericStatisticDialog
     */
    public GenericStatisticDialog(java.awt.Frame parent, String title) {
        super(parent, true);
        initComponents();

        setTitle("SciMAT v1.1 - " + title);
    }

    /**
     *
     */
    public void refresh() {

        int i;
        ArrayList<Period> periods;
        Period period;
        ArrayList<StatisticPerPeriod> stats;
        ArrayList<FrequencyDistributionPerPeriod> freqs;
        StatisticBasedFrequency stat;

        stats = new ArrayList<StatisticPerPeriod>();
        freqs = new ArrayList<FrequencyDistributionPerPeriod>();

        try {

            periods = CurrentProject.getInstance().getFactoryDAO().getPeriodDAO().getPeriods();

            for (i = 0; i < periods.size(); i++) {

                period = periods.get(i);

                stat = new StatisticBasedFrequency(retrieveStatistic(period.getPeriodID()));

                stats.add(new StatisticPerPeriod(period,
                        getUniqueGroups(period.getPeriodID()),
                        stat.getMax(),
                        stat.getMin(),
                        stat.getMean(),
                        stat.getMedian(),
                        stat.getStandardDesviation(),
                        stat.getVariance()));

                freqs.add(new FrequencyDistributionPerPeriod(period, stat));
            }

            this.statisticPerPeriodListPanel.refreshItems(stats);
            this.statisticBarChartPanel.refresh(stats);
            this.frequencyDistributionPanel.refresh(freqs);

        } catch (KnowledgeBaseException e) {

            ErrorDialogManager.getInstance().showException(e);
        }

    }

    /**
     *
     */
    public abstract ArrayList<Integer> retrieveStatistic(Integer periodID);

    /**
     *
     */
    public abstract int getUniqueGroups(Integer periodID);

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statisticPanel = new javax.swing.JPanel();
        statisticPerPeriodListPanel = new StatisticPerPeriodListPanel();
        chartPanel = new javax.swing.JPanel();
        statisticBarChartPanel = new StatisticBarChartPanel();
        frequencyDistributionPanel = new FrequencyDistributionPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        statisticPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Statistic information"));

        javax.swing.GroupLayout statisticPanelLayout = new javax.swing.GroupLayout(statisticPanel);
        statisticPanel.setLayout(statisticPanelLayout);
        statisticPanelLayout.setHorizontalGroup(
                statisticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(statisticPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(statisticPerPeriodListPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
                                .addContainerGap())
        );
        statisticPanelLayout.setVerticalGroup(
                statisticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(statisticPanelLayout.createSequentialGroup()
                                .addComponent(statisticPerPeriodListPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        chartPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Charts"));

        javax.swing.GroupLayout chartPanelLayout = new javax.swing.GroupLayout(chartPanel);
        chartPanel.setLayout(chartPanelLayout);
        chartPanelLayout.setHorizontalGroup(
                chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(chartPanelLayout.createSequentialGroup()
                                .addComponent(statisticBarChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(frequencyDistributionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
        );
        chartPanelLayout.setVerticalGroup(
                chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(frequencyDistributionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                        .addComponent(statisticBarChartPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(statisticPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(chartPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(statisticPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel chartPanel;
    private FrequencyDistributionPanel frequencyDistributionPanel;
    private StatisticBarChartPanel statisticBarChartPanel;
    private javax.swing.JPanel statisticPanel;
    private StatisticPerPeriodListPanel statisticPerPeriodListPanel;
    // End of variables declaration//GEN-END:variables
}
