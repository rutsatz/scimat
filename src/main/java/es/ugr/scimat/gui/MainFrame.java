/*
 * MainFrame.java
 *
 * Created on 06-mar-2011, 20:58:32
 */
package es.ugr.scimat.gui;

import java.awt.Toolkit;
import javax.swing.JOptionPane;
import es.ugr.scimat.gui.commands.task.CloseProjectTask;
import es.ugr.scimat.gui.commands.task.ExportGroupTask;
import es.ugr.scimat.gui.commands.task.FindSimilarAuthorReferencesWithoutGroupByDistanceTask;
import es.ugr.scimat.gui.commands.task.FindSimilarAuthorsWithoutGroupByDistanceTask;
import es.ugr.scimat.gui.commands.task.FindSimilarReferenceSourcesWithoutGroupByDistanceTask;
import es.ugr.scimat.gui.commands.task.FindSimilarReferencesWithoutGroupByDistanceTask;
import es.ugr.scimat.gui.commands.task.FindSimilarWordGroupsByDistanceTask;
import es.ugr.scimat.gui.commands.task.FindSimilarWordsWithoutGroupByDistanceTask;
import es.ugr.scimat.gui.commands.task.FindSimilarWordsWithoutGroupByPluralsAutomaticTask;
import es.ugr.scimat.gui.commands.task.FindSimilarWordsWithoutGroupByPluralsTask;
import es.ugr.scimat.gui.commands.task.ImportFileTask;
import es.ugr.scimat.gui.commands.task.ImportGroupTask;
import es.ugr.scimat.gui.commands.task.LoadAnalysisTask;
import es.ugr.scimat.gui.commands.task.LoadProjectTask;
import es.ugr.scimat.gui.commands.task.ShowManagerTask;
import es.ugr.scimat.gui.components.*;
import es.ugr.scimat.gui.components.adddialog.AddDialogManager;
import es.ugr.scimat.gui.components.cursor.CursorManager;
import es.ugr.scimat.gui.components.editdialog.EditDialogManager;
import es.ugr.scimat.gui.components.analysisview.AnalysisViewManager;
import es.ugr.scimat.gui.components.globalreplace.GlobalReplaceDialogManager;
import es.ugr.scimat.gui.components.joindialog.JoinEntitiesDialogManager;
import es.ugr.scimat.gui.components.manager.AffiliationManager;
import es.ugr.scimat.gui.components.manager.AuthorGroupManager;
import es.ugr.scimat.gui.components.manager.AuthorGroupManualSetManager;
import es.ugr.scimat.gui.components.manager.AuthorManager;
import es.ugr.scimat.gui.components.manager.AuthorReferenceGroupManager;
import es.ugr.scimat.gui.components.manager.AuthorReferenceGroupManualSetManager;
import es.ugr.scimat.gui.components.manager.AuthorReferenceManager;
import es.ugr.scimat.gui.components.manager.DocumentManager;
import es.ugr.scimat.gui.components.manager.JournalManager;
import es.ugr.scimat.gui.components.manager.PeriodManager;
import es.ugr.scimat.gui.components.manager.PublishDateManager;
import es.ugr.scimat.gui.components.manager.ReferenceGroupManager;
import es.ugr.scimat.gui.components.manager.ReferenceGroupManualSetManager;
import es.ugr.scimat.gui.components.manager.ReferenceManager;
import es.ugr.scimat.gui.components.manager.ReferenceSourceGroupManager;
import es.ugr.scimat.gui.components.manager.ReferenceSourceGroupManualSetManager;
import es.ugr.scimat.gui.components.manager.ReferenceSourceManager;
import es.ugr.scimat.gui.components.manager.SubjectCategoryManager;
import es.ugr.scimat.gui.components.manager.WordGroupManager;
import es.ugr.scimat.gui.components.manager.WordGroupManualSetManager;
import es.ugr.scimat.gui.components.manager.WordManager;
import es.ugr.scimat.gui.components.movetogroup.MoveToGroupDialogManager;
import es.ugr.scimat.gui.components.statistic.StatisticDialogManager;
import es.ugr.scimat.gui.components.wizard.WizardManager;
import es.ugr.scimat.gui.undostack.UndoStack;
import es.ugr.scimat.model.knowledgebase.exception.KnowledgeBaseException;
import es.ugr.scimat.project.CurrentProject;

/**
 *
 * @author mjcobo
 */
public class MainFrame extends javax.swing.JFrame {

  /** Creates new form MainFrame */
  public MainFrame() {
    
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/logoApp.png")));
    
    initComponents();
    
    CursorManager.getInstance().init(this);
    AddDialogManager.getInstance().init(this);
    EditDialogManager.getInstance().init(this);
    JoinEntitiesDialogManager.getInstance().init(this);
    MoveToGroupDialogManager.getInstance().init(this);
    WizardManager.getInstance().init(this);
    AnalysisViewManager.getInstance().init(this);
    ErrorDialogManager.getInstance().init(this);
    GlobalReplaceDialogManager.getInstance().init(this);
    StatisticDialogManager.getInstance().init(this);
  }

  /**
   * Este metodo se encarga de cerrar la apliacion
   */
  private void finish() {

    int returnVal;

    returnVal = JOptionPane.showConfirmDialog(this,
            "Do you want to close the tool?", "Close tool",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

    if (returnVal == JOptionPane.YES_OPTION) {

      if (CurrentProject.getInstance().isKnowledbaseLoaded()) {

        try {

          CurrentProject.getInstance().close();

        } catch (KnowledgeBaseException e) {

          e.printStackTrace(System.err);
        }
      }

      dispose();
      System.out.println("Finish.");
      System.exit(0);
    }
  }

  /**
   * 
   */
  public void clearMainPanel() {
  
    this.mainPanel.removeAll();
    this.mainPanel.validate();
    this.mainPanel.repaint();
  }
  
  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    toolBarPanel = new javax.swing.JPanel();
    fileToolBar = new javax.swing.JToolBar();
    newProjectToolBarButton = new NewProjectToolBarButton();
    openProjectToolBarButton = new OpenProjectToolBarButton();
    editToolBar = new javax.swing.JToolBar();
    jSeparator1 = new javax.swing.JToolBar.Separator();
    undoToolBarButton = new UndoToolBarButton();
    redoToolBarButton = new RedoToolBarButton();
    mainPanel = new javax.swing.JPanel();
    mainMenuBar = new javax.swing.JMenuBar();
    fileMenu = new javax.swing.JMenu();
    newProjectMenuItem = new NewProjectMenuItem();
    openProjectMenuItem = new OpenProjectMenuItem();
    closeProjectMenuItem = new KnowledgeBaseStateObserverMenuItem();
    separator1 = new javax.swing.JPopupMenu.Separator();
    addFilesMenu = new javax.swing.JMenu();
    importFromISIWoSMenuItem = new KnowledgeBaseStateObserverMenuItem();
    importFromRISMenuItem = new KnowledgeBaseStateObserverMenuItem();
    importFromRISMay2014MenuItem = new KnowledgeBaseStateObserverMenuItem();
    importFromCsvMenuItem = new KnowledgeBaseStateObserverMenuItem();
    exportMenu = new javax.swing.JMenu();
    exportGroupsMenuItem = new KnowledgeBaseStateObserverMenuItem();
    importMenu = new javax.swing.JMenu();
    importGroupsMenuItem = new KnowledgeBaseStateObserverMenuItem();
    separator2 = new javax.swing.JPopupMenu.Separator();
    exitMenuItem = new javax.swing.JMenuItem();
    editMenu = new javax.swing.JMenu();
    globalReplaceMenu = new javax.swing.JMenu();
    globalReplaceAffiliationMenuItem = new KnowledgeBaseStateObserverMenuItem();
    globalReplaceAuthorMenuItem = new KnowledgeBaseStateObserverMenuItem();
    globalReplaceAuthorGroupMenuItem = new KnowledgeBaseStateObserverMenuItem();
    globalReplaceAuthorReferenceMenuItem = new KnowledgeBaseStateObserverMenuItem();
    globalReplaceAuthorReferenceGroupMenuItem = new KnowledgeBaseStateObserverMenuItem();
    globalReplaceJournalMenuItem = new KnowledgeBaseStateObserverMenuItem();
    globalReplaceDocumentMenuItem = new KnowledgeBaseStateObserverMenuItem();
    globalReplacePeriodMenuItem = new KnowledgeBaseStateObserverMenuItem();
    globalReplacePublishDateMenuItem = new KnowledgeBaseStateObserverMenuItem();
    globalReplaceReferenceMenuItem = new KnowledgeBaseStateObserverMenuItem();
    globalReplaceReferenceGroupMenuItem = new KnowledgeBaseStateObserverMenuItem();
    globalReplaceReferenceSourceMenuItem = new KnowledgeBaseStateObserverMenuItem();
    globalReplaceReferenceSourceGroupMenuItem = new KnowledgeBaseStateObserverMenuItem();
    globalReplaceSubjectCategoryMenuItem = new KnowledgeBaseStateObserverMenuItem();
    globalReplaceWordMenuItem = new KnowledgeBaseStateObserverMenuItem();
    globalReplaceWordGroupMenuItem = new KnowledgeBaseStateObserverMenuItem();
    separator3 = new javax.swing.JPopupMenu.Separator();
    undoMenuItem1 = new UndoMenuItem();
    redoMenuItem1 = new RedoMenuItem();
    knowledgeBaseMenu = new javax.swing.JMenu();
    authorsMenu = new javax.swing.JMenu();
    authorsManagerMenuItem = new KnowledgeBaseStateObserverMenuItem();
    authorsGroupsManagerMenuItem = new KnowledgeBaseStateObserverMenuItem();
    affiliationsManagerMenuItem = new KnowledgeBaseStateObserverMenuItem();
    documentsMenu = new javax.swing.JMenu();
    documentsManagerMenuItem = new KnowledgeBaseStateObserverMenuItem();
    journalsMenu = new javax.swing.JMenu();
    journalsManagerMenuItem = new KnowledgeBaseStateObserverMenuItem();
    referencesMenu = new javax.swing.JMenu();
    referencesManagerMenuItem = new KnowledgeBaseStateObserverMenuItem();
    referencesGroupsManagerMenuItem = new KnowledgeBaseStateObserverMenuItem();
    authorsReferenceManagerMenuItem = new KnowledgeBaseStateObserverMenuItem();
    authorsReferencesGroupManagerMenuItem = new KnowledgeBaseStateObserverMenuItem();
    referencesSourceManagerMenuItem = new KnowledgeBaseStateObserverMenuItem();
    referencesSourceGroupsManagerMenuItem = new KnowledgeBaseStateObserverMenuItem();
    periodsMenu = new javax.swing.JMenu();
    periodsManagerMenuItem = new KnowledgeBaseStateObserverMenuItem();
    publishDatesMenu = new javax.swing.JMenu();
    publishDatesManagerMenuItem = new KnowledgeBaseStateObserverMenuItem();
    subjectCategoriesMenu = new javax.swing.JMenu();
    subjectCategoriesMenuItem = new KnowledgeBaseStateObserverMenuItem();
    wordsMenu = new javax.swing.JMenu();
    wordsManagerMenuItem = new KnowledgeBaseStateObserverMenuItem();
    wordsGroupsManagerMenuItem = new KnowledgeBaseStateObserverMenuItem();
    groupSetMenu = new javax.swing.JMenu();
    authorGroupMenu = new javax.swing.JMenu();
    authorGroupManualSetMenuItem = new KnowledgeBaseStateObserverMenuItem();
    findSimilarAuthorsByDistanceMenuItem = new KnowledgeBaseStateObserverMenuItem();
    authorReferenceGroupMenu = new javax.swing.JMenu();
    authorReferenceGroupManualSetMenuItem = new KnowledgeBaseStateObserverMenuItem();
    findSimilarAuthorReferencesByDistanceMenuItem = new KnowledgeBaseStateObserverMenuItem();
    referenceGroupMenu = new javax.swing.JMenu();
    referenceGroupManualSetMenuItem = new KnowledgeBaseStateObserverMenuItem();
    findSimilarReferencesByDistanceMenuItem = new KnowledgeBaseStateObserverMenuItem();
    referenceSourceMenu = new javax.swing.JMenu();
    referenceSourceGroupManualSetMenuItem = new KnowledgeBaseStateObserverMenuItem();
    findSimilarReferenceSourcesByDistanceMenuItem = new KnowledgeBaseStateObserverMenuItem();
    wordGroupMenu = new javax.swing.JMenu();
    wordGroupManualSetMenuItem = new KnowledgeBaseStateObserverMenuItem();
    findSimilarWordsByPluralsMenuItem = new KnowledgeBaseStateObserverMenuItem();
    findSimilarWordsByPluralsAutomaticMenuItem = new KnowledgeBaseStateObserverMenuItem();
    findSimilarWordsByDistanceMenuItem = new KnowledgeBaseStateObserverMenuItem();
    findSimilarWordsGroupByDistanceMenuItem = new KnowledgeBaseStateObserverMenuItem();
    analysisMenu = new javax.swing.JMenu();
    makeAnalysisMenuItem = new KnowledgeBaseStateObserverMenuItem();
    loadAnalysisMenuItem = new javax.swing.JMenuItem();
    statisticMenu = new javax.swing.JMenu();
    authorGroupStatisticsMenuItem = new KnowledgeBaseStateObserverMenuItem();
    referenceGroupStatisticsMenuItem = new KnowledgeBaseStateObserverMenuItem();
    wordGroupStatisticsMenuItem = new KnowledgeBaseStateObserverMenuItem();
    helpMenu = new javax.swing.JMenu();
    aboutMenuItem = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    setTitle("SciMAT 1.1.04");
    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosing(java.awt.event.WindowEvent evt) {
        formWindowClosing(evt);
      }
    });

    toolBarPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

    fileToolBar.setFloatable(false);
    fileToolBar.setRollover(true);

    newProjectToolBarButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        newProjectToolBarButtonActionPerformed(evt);
      }
    });
    fileToolBar.add(newProjectToolBarButton);

    openProjectToolBarButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        openProjectToolBarButtonActionPerformed(evt);
      }
    });
    fileToolBar.add(openProjectToolBarButton);

    editToolBar.setFloatable(false);
    editToolBar.setRollover(true);
    editToolBar.add(jSeparator1);

    undoToolBarButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        undoToolBarButtonActionPerformed(evt);
      }
    });
    editToolBar.add(undoToolBarButton);

    redoToolBarButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        redoToolBarButtonActionPerformed(evt);
      }
    });
    editToolBar.add(redoToolBarButton);

    javax.swing.GroupLayout toolBarPanelLayout = new javax.swing.GroupLayout(toolBarPanel);
    toolBarPanel.setLayout(toolBarPanelLayout);
    toolBarPanelLayout.setHorizontalGroup(
      toolBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(toolBarPanelLayout.createSequentialGroup()
        .addComponent(fileToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(editToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(815, Short.MAX_VALUE))
    );
    toolBarPanelLayout.setVerticalGroup(
      toolBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(toolBarPanelLayout.createSequentialGroup()
        .addGroup(toolBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(fileToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(editToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap())
    );

    mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.LINE_AXIS));

    fileMenu.setText("File");

    newProjectMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
    newProjectMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/newProject16x16.png"))); // NOI18N
    newProjectMenuItem.setText("New project");
    newProjectMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        newProjectMenuItemActionPerformed(evt);
      }
    });
    fileMenu.add(newProjectMenuItem);

    openProjectMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
    openProjectMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/openProject16x16.png"))); // NOI18N
    openProjectMenuItem.setText("Open project");
    openProjectMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        openProjectMenuItemActionPerformed(evt);
      }
    });
    fileMenu.add(openProjectMenuItem);

    closeProjectMenuItem.setText("Close project");
    closeProjectMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        closeProjectMenuItemActionPerformed(evt);
      }
    });
    fileMenu.add(closeProjectMenuItem);
    fileMenu.add(separator1);

    addFilesMenu.setText("Add files");

    importFromISIWoSMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Document-Add16x16.png"))); // NOI18N
    importFromISIWoSMenuItem.setText("In ISIWoS format");
    importFromISIWoSMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        importFromISIWoSMenuItemActionPerformed(evt);
      }
    });
    addFilesMenu.add(importFromISIWoSMenuItem);

    importFromRISMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Document-Add16x16.png"))); // NOI18N
    importFromRISMenuItem.setText("In RIS (Old format)");
    importFromRISMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        importFromRISMenuItemActionPerformed(evt);
      }
    });
    addFilesMenu.add(importFromRISMenuItem);

    importFromRISMay2014MenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Document-Add16x16.png"))); // NOI18N
    importFromRISMay2014MenuItem.setText("In RIS (May 2014 format)");
    importFromRISMay2014MenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        importFromRISMay2014MenuItemActionPerformed(evt);
      }
    });
    addFilesMenu.add(importFromRISMay2014MenuItem);

    importFromCsvMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Document-Add16x16.png"))); // NOI18N
    importFromCsvMenuItem.setText("In Csv format");
    importFromCsvMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        importFromCsvMenuItemActionPerformed(evt);
      }
    });
    addFilesMenu.add(importFromCsvMenuItem);

    fileMenu.add(addFilesMenu);

    exportMenu.setText("Export");

    exportGroupsMenuItem.setText("Groups");
    exportGroupsMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        exportGroupsMenuItemActionPerformed(evt);
      }
    });
    exportMenu.add(exportGroupsMenuItem);

    fileMenu.add(exportMenu);

    importMenu.setText("Import");

    importGroupsMenuItem.setText("Groups");
    importGroupsMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        importGroupsMenuItemActionPerformed(evt);
      }
    });
    importMenu.add(importGroupsMenuItem);

    fileMenu.add(importMenu);
    fileMenu.add(separator2);

    exitMenuItem.setText("Exit");
    exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        exitMenuItemActionPerformed(evt);
      }
    });
    fileMenu.add(exitMenuItem);

    mainMenuBar.add(fileMenu);

    editMenu.setText("Edit");

    globalReplaceMenu.setText("Global replace");

    globalReplaceAffiliationMenuItem.setText("Affiliation");
    globalReplaceAffiliationMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        globalReplaceAffiliationMenuItemActionPerformed(evt);
      }
    });
    globalReplaceMenu.add(globalReplaceAffiliationMenuItem);

    globalReplaceAuthorMenuItem.setText("Author");
    globalReplaceAuthorMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        globalReplaceAuthorMenuItemActionPerformed(evt);
      }
    });
    globalReplaceMenu.add(globalReplaceAuthorMenuItem);

    globalReplaceAuthorGroupMenuItem.setText("Author Group");
    globalReplaceAuthorGroupMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        globalReplaceAuthorGroupMenuItemActionPerformed(evt);
      }
    });
    globalReplaceMenu.add(globalReplaceAuthorGroupMenuItem);

    globalReplaceAuthorReferenceMenuItem.setText("Author-Reference");
    globalReplaceAuthorReferenceMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        globalReplaceAuthorReferenceMenuItemActionPerformed(evt);
      }
    });
    globalReplaceMenu.add(globalReplaceAuthorReferenceMenuItem);

    globalReplaceAuthorReferenceGroupMenuItem.setText("Author-Reference Group");
    globalReplaceAuthorReferenceGroupMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        globalReplaceAuthorReferenceGroupMenuItemActionPerformed(evt);
      }
    });
    globalReplaceMenu.add(globalReplaceAuthorReferenceGroupMenuItem);

    globalReplaceJournalMenuItem.setText("Journal");
    globalReplaceJournalMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        globalReplaceJournalMenuItemActionPerformed(evt);
      }
    });
    globalReplaceMenu.add(globalReplaceJournalMenuItem);

    globalReplaceDocumentMenuItem.setText("Document");
    globalReplaceDocumentMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        globalReplaceDocumentMenuItemActionPerformed(evt);
      }
    });
    globalReplaceMenu.add(globalReplaceDocumentMenuItem);

    globalReplacePeriodMenuItem.setText("Period");
    globalReplacePeriodMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        globalReplacePeriodMenuItemActionPerformed(evt);
      }
    });
    globalReplaceMenu.add(globalReplacePeriodMenuItem);

    globalReplacePublishDateMenuItem.setText("Publish date");
    globalReplacePublishDateMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        globalReplacePublishDateMenuItemActionPerformed(evt);
      }
    });
    globalReplaceMenu.add(globalReplacePublishDateMenuItem);

    globalReplaceReferenceMenuItem.setText("Reference");
    globalReplaceReferenceMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        globalReplaceReferenceMenuItemActionPerformed(evt);
      }
    });
    globalReplaceMenu.add(globalReplaceReferenceMenuItem);

    globalReplaceReferenceGroupMenuItem.setText("Reference Group");
    globalReplaceReferenceGroupMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        globalReplaceReferenceGroupMenuItemActionPerformed(evt);
      }
    });
    globalReplaceMenu.add(globalReplaceReferenceGroupMenuItem);

    globalReplaceReferenceSourceMenuItem.setText("Reference-Source");
    globalReplaceReferenceSourceMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        globalReplaceReferenceSourceMenuItemActionPerformed(evt);
      }
    });
    globalReplaceMenu.add(globalReplaceReferenceSourceMenuItem);

    globalReplaceReferenceSourceGroupMenuItem.setText("Reference-Source Group");
    globalReplaceReferenceSourceGroupMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        globalReplaceReferenceSourceGroupMenuItemActionPerformed(evt);
      }
    });
    globalReplaceMenu.add(globalReplaceReferenceSourceGroupMenuItem);

    globalReplaceSubjectCategoryMenuItem.setText("Subject Category");
    globalReplaceSubjectCategoryMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        globalReplaceSubjectCategoryMenuItemActionPerformed(evt);
      }
    });
    globalReplaceMenu.add(globalReplaceSubjectCategoryMenuItem);

    globalReplaceWordMenuItem.setText("Word");
    globalReplaceWordMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        globalReplaceWordMenuItemActionPerformed(evt);
      }
    });
    globalReplaceMenu.add(globalReplaceWordMenuItem);

    globalReplaceWordGroupMenuItem.setText("Word Group");
    globalReplaceWordGroupMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        globalReplaceWordGroupMenuItemActionPerformed(evt);
      }
    });
    globalReplaceMenu.add(globalReplaceWordGroupMenuItem);

    editMenu.add(globalReplaceMenu);
    editMenu.add(separator3);

    undoMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
    undoMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit-undo16x16.png"))); // NOI18N
    editMenu.add(undoMenuItem1);

    redoMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
    redoMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit-redo16x16.png"))); // NOI18N
    editMenu.add(redoMenuItem1);

    mainMenuBar.add(editMenu);

    knowledgeBaseMenu.setText("Knowledge base");

    authorsMenu.setText("Authors");

    authorsManagerMenuItem.setText("Authors manager");
    authorsManagerMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        authorsManagerMenuItemActionPerformed(evt);
      }
    });
    authorsMenu.add(authorsManagerMenuItem);

    authorsGroupsManagerMenuItem.setText("Authors groups manager");
    authorsGroupsManagerMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        authorsGroupsManagerMenuItemActionPerformed(evt);
      }
    });
    authorsMenu.add(authorsGroupsManagerMenuItem);

    affiliationsManagerMenuItem.setText("Affiliations manager");
    affiliationsManagerMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        affiliationsManagerMenuItemActionPerformed(evt);
      }
    });
    authorsMenu.add(affiliationsManagerMenuItem);

    knowledgeBaseMenu.add(authorsMenu);

    documentsMenu.setText("Documents");

    documentsManagerMenuItem.setText("Documents manager");
    documentsManagerMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        documentsManagerMenuItemActionPerformed(evt);
      }
    });
    documentsMenu.add(documentsManagerMenuItem);

    knowledgeBaseMenu.add(documentsMenu);

    journalsMenu.setText("Journals");

    journalsManagerMenuItem.setText("Journals manager");
    journalsManagerMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        journalsManagerMenuItemActionPerformed(evt);
      }
    });
    journalsMenu.add(journalsManagerMenuItem);

    knowledgeBaseMenu.add(journalsMenu);

    referencesMenu.setText("References");

    referencesManagerMenuItem.setText("References manager");
    referencesManagerMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        referencesManagerMenuItemActionPerformed(evt);
      }
    });
    referencesMenu.add(referencesManagerMenuItem);

    referencesGroupsManagerMenuItem.setText("References groups manager");
    referencesGroupsManagerMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        referencesGroupsManagerMenuItemActionPerformed(evt);
      }
    });
    referencesMenu.add(referencesGroupsManagerMenuItem);

    authorsReferenceManagerMenuItem.setText("Authors-reference manager");
    authorsReferenceManagerMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        authorsReferenceManagerMenuItemActionPerformed(evt);
      }
    });
    referencesMenu.add(authorsReferenceManagerMenuItem);

    authorsReferencesGroupManagerMenuItem.setText("Authors-reference groups manager");
    authorsReferencesGroupManagerMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        authorsReferencesGroupManagerMenuItemActionPerformed(evt);
      }
    });
    referencesMenu.add(authorsReferencesGroupManagerMenuItem);

    referencesSourceManagerMenuItem.setText("Sources-reference manager");
    referencesSourceManagerMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        referencesSourceManagerMenuItemActionPerformed(evt);
      }
    });
    referencesMenu.add(referencesSourceManagerMenuItem);

    referencesSourceGroupsManagerMenuItem.setText("Sources-reference groups manager");
    referencesSourceGroupsManagerMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        referencesSourceGroupsManagerMenuItemActionPerformed(evt);
      }
    });
    referencesMenu.add(referencesSourceGroupsManagerMenuItem);

    knowledgeBaseMenu.add(referencesMenu);

    periodsMenu.setText("Periods");

    periodsManagerMenuItem.setText("Periods manager");
    periodsManagerMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        periodsManagerMenuItemActionPerformed(evt);
      }
    });
    periodsMenu.add(periodsManagerMenuItem);

    knowledgeBaseMenu.add(periodsMenu);

    publishDatesMenu.setText("Publish dates");

    publishDatesManagerMenuItem.setText("Publish dates manager");
    publishDatesManagerMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        publishDatesManagerMenuItemActionPerformed(evt);
      }
    });
    publishDatesMenu.add(publishDatesManagerMenuItem);

    knowledgeBaseMenu.add(publishDatesMenu);

    subjectCategoriesMenu.setText("Subject categories");

    subjectCategoriesMenuItem.setText("Subject categories manager");
    subjectCategoriesMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        subjectCategoriesMenuItemActionPerformed(evt);
      }
    });
    subjectCategoriesMenu.add(subjectCategoriesMenuItem);

    knowledgeBaseMenu.add(subjectCategoriesMenu);

    wordsMenu.setText("Words");

    wordsManagerMenuItem.setText("Words manager");
    wordsManagerMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        wordsManagerMenuItemActionPerformed(evt);
      }
    });
    wordsMenu.add(wordsManagerMenuItem);

    wordsGroupsManagerMenuItem.setText("Words groups manager");
    wordsGroupsManagerMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        wordsGroupsManagerMenuItemActionPerformed(evt);
      }
    });
    wordsMenu.add(wordsGroupsManagerMenuItem);

    knowledgeBaseMenu.add(wordsMenu);

    mainMenuBar.add(knowledgeBaseMenu);

    groupSetMenu.setText("Group set");

    authorGroupMenu.setText("Author");

    authorGroupManualSetMenuItem.setText("Author group manual set");
    authorGroupManualSetMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        authorGroupManualSetMenuItemActionPerformed(evt);
      }
    });
    authorGroupMenu.add(authorGroupManualSetMenuItem);

    findSimilarAuthorsByDistanceMenuItem.setText("Find similar authors by distances");
    findSimilarAuthorsByDistanceMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        findSimilarAuthorsByDistanceMenuItemActionPerformed(evt);
      }
    });
    authorGroupMenu.add(findSimilarAuthorsByDistanceMenuItem);

    groupSetMenu.add(authorGroupMenu);

    authorReferenceGroupMenu.setText("Author-reference");

    authorReferenceGroupManualSetMenuItem.setText("Authors-reference group manual set");
    authorReferenceGroupManualSetMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        authorReferenceGroupManualSetMenuItemActionPerformed(evt);
      }
    });
    authorReferenceGroupMenu.add(authorReferenceGroupManualSetMenuItem);

    findSimilarAuthorReferencesByDistanceMenuItem.setText("Find similar author references by distances");
    findSimilarAuthorReferencesByDistanceMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        findSimilarAuthorReferencesByDistanceMenuItemActionPerformed(evt);
      }
    });
    authorReferenceGroupMenu.add(findSimilarAuthorReferencesByDistanceMenuItem);

    groupSetMenu.add(authorReferenceGroupMenu);

    referenceGroupMenu.setText("Reference");

    referenceGroupManualSetMenuItem.setText("Reference group manual set");
    referenceGroupManualSetMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        referenceGroupManualSetMenuItemActionPerformed(evt);
      }
    });
    referenceGroupMenu.add(referenceGroupManualSetMenuItem);

    findSimilarReferencesByDistanceMenuItem.setText("Find similar references by distances");
    findSimilarReferencesByDistanceMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        findSimilarReferencesByDistanceMenuItemActionPerformed(evt);
      }
    });
    referenceGroupMenu.add(findSimilarReferencesByDistanceMenuItem);

    groupSetMenu.add(referenceGroupMenu);

    referenceSourceMenu.setText("Source-reference");

    referenceSourceGroupManualSetMenuItem.setText("Sources-reference group manual set");
    referenceSourceGroupManualSetMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        referenceSourceGroupManualSetMenuItemActionPerformed(evt);
      }
    });
    referenceSourceMenu.add(referenceSourceGroupManualSetMenuItem);

    findSimilarReferenceSourcesByDistanceMenuItem.setText("Find similar sources-reference by distances");
    findSimilarReferenceSourcesByDistanceMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        findSimilarReferenceSourcesByDistanceMenuItemActionPerformed(evt);
      }
    });
    referenceSourceMenu.add(findSimilarReferenceSourcesByDistanceMenuItem);

    groupSetMenu.add(referenceSourceMenu);

    wordGroupMenu.setText("Word");

    wordGroupManualSetMenuItem.setText("Word group manual set");
    wordGroupManualSetMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        wordGroupManualSetMenuItemActionPerformed(evt);
      }
    });
    wordGroupMenu.add(wordGroupManualSetMenuItem);

    findSimilarWordsByPluralsMenuItem.setText("Find similar words by plurals");
    findSimilarWordsByPluralsMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        findSimilarWordsByPluralsMenuItemActionPerformed(evt);
      }
    });
    wordGroupMenu.add(findSimilarWordsByPluralsMenuItem);

    findSimilarWordsByPluralsAutomaticMenuItem.setText("Find similar words by plurals (automatic)");
    findSimilarWordsByPluralsAutomaticMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        findSimilarWordsByPluralsAutomaticMenuItemActionPerformed(evt);
      }
    });
    wordGroupMenu.add(findSimilarWordsByPluralsAutomaticMenuItem);

    findSimilarWordsByDistanceMenuItem.setText("Find similar words by distances");
    findSimilarWordsByDistanceMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        findSimilarWordsByDistanceMenuItemActionPerformed(evt);
      }
    });
    wordGroupMenu.add(findSimilarWordsByDistanceMenuItem);

    findSimilarWordsGroupByDistanceMenuItem.setText("Find similar words group by distances");
    findSimilarWordsGroupByDistanceMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        findSimilarWordsGroupByDistanceMenuItemActionPerformed(evt);
      }
    });
    wordGroupMenu.add(findSimilarWordsGroupByDistanceMenuItem);

    groupSetMenu.add(wordGroupMenu);

    mainMenuBar.add(groupSetMenu);

    analysisMenu.setText("Analysis");

    makeAnalysisMenuItem.setText("Make analysis");
    makeAnalysisMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        makeAnalysisMenuItemActionPerformed(evt);
      }
    });
    analysisMenu.add(makeAnalysisMenuItem);

    loadAnalysisMenuItem.setText("Load analysis");
    loadAnalysisMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        loadAnalysisMenuItemActionPerformed(evt);
      }
    });
    analysisMenu.add(loadAnalysisMenuItem);

    mainMenuBar.add(analysisMenu);

    statisticMenu.setText("Statistics");

    authorGroupStatisticsMenuItem.setText("Author groups statistics");
    authorGroupStatisticsMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        authorGroupStatisticsMenuItemActionPerformed(evt);
      }
    });
    statisticMenu.add(authorGroupStatisticsMenuItem);

    referenceGroupStatisticsMenuItem.setText("Reference groups statistics");
    referenceGroupStatisticsMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        referenceGroupStatisticsMenuItemActionPerformed(evt);
      }
    });
    statisticMenu.add(referenceGroupStatisticsMenuItem);

    wordGroupStatisticsMenuItem.setText("Word groups statistics");
    wordGroupStatisticsMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        wordGroupStatisticsMenuItemActionPerformed(evt);
      }
    });
    statisticMenu.add(wordGroupStatisticsMenuItem);

    mainMenuBar.add(statisticMenu);

    helpMenu.setText("Help");

    aboutMenuItem.setText("About");
    aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        aboutMenuItemActionPerformed(evt);
      }
    });
    helpMenu.add(aboutMenuItem);

    mainMenuBar.add(helpMenu);

    setJMenuBar(mainMenuBar);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(toolBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 959, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(toolBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  /**
   *
   * @param evt
   */
  private void undoToolBarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoToolBarButtonActionPerformed
    UndoStack.undo();
  }//GEN-LAST:event_undoToolBarButtonActionPerformed

  /**
   *
   * @param evt
   */
  private void redoToolBarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoToolBarButtonActionPerformed

    UndoStack.redo();
  }//GEN-LAST:event_redoToolBarButtonActionPerformed

  /**
   *
   * @param evt
   */
  private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
    finish();
  }//GEN-LAST:event_exitMenuItemActionPerformed

  /**
   *
   * @param evt
   */
  /**
   *
   * @param evt
   */
  private void openProjectMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openProjectMenuItemActionPerformed
    (new LoadProjectTask(rootPane)).execute();
  }//GEN-LAST:event_openProjectMenuItemActionPerformed

  /**
   *
   * @param evt
   */
  private void openProjectToolBarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openProjectToolBarButtonActionPerformed
    (new LoadProjectTask(rootPane)).execute();
  }//GEN-LAST:event_openProjectToolBarButtonActionPerformed

  /**
   * 
   * @param evt
   */
  private void documentsManagerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_documentsManagerMenuItemActionPerformed
    (new ShowManagerTask(this.mainPanel, this.documentManager)).execute();
  }//GEN-LAST:event_documentsManagerMenuItemActionPerformed

  /**
   *
   * @param evt
   */
  private void authorsManagerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorsManagerMenuItemActionPerformed
    (new ShowManagerTask(this.mainPanel, this.authorManager)).execute();
  }//GEN-LAST:event_authorsManagerMenuItemActionPerformed

  /**
   * 
   * @param evt
   */
  private void authorsGroupsManagerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorsGroupsManagerMenuItemActionPerformed
    (new ShowManagerTask(this.mainPanel, this.authorGroupManager)).execute();
  }//GEN-LAST:event_authorsGroupsManagerMenuItemActionPerformed

  /**
   *
   * @param evt
   */
  private void affiliationsManagerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_affiliationsManagerMenuItemActionPerformed
    (new ShowManagerTask(this.mainPanel, this.affiliationManger)).execute();
  }//GEN-LAST:event_affiliationsManagerMenuItemActionPerformed

  /**
   *
   * @param evt
   */
  private void journalsManagerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_journalsManagerMenuItemActionPerformed
    (new ShowManagerTask(this.mainPanel, this.journalManager)).execute();
  }//GEN-LAST:event_journalsManagerMenuItemActionPerformed

  /**
   *
   * @param evt
   */
  private void referencesManagerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_referencesManagerMenuItemActionPerformed
    (new ShowManagerTask(this.mainPanel, this.referenceManager)).execute();
  }//GEN-LAST:event_referencesManagerMenuItemActionPerformed

  /**
   *
   * @param evt
   */
  private void referencesGroupsManagerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_referencesGroupsManagerMenuItemActionPerformed
    (new ShowManagerTask(this.mainPanel, this.referenceGroupManager)).execute();
  }//GEN-LAST:event_referencesGroupsManagerMenuItemActionPerformed

  /**
   *
   * @param evt
   */
  private void authorsReferenceManagerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorsReferenceManagerMenuItemActionPerformed
    (new ShowManagerTask(this.mainPanel, this.authorReferenceManager)).execute();
  }//GEN-LAST:event_authorsReferenceManagerMenuItemActionPerformed

  /**
   *
   * @param evt
   */
  private void authorsReferencesGroupManagerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorsReferencesGroupManagerMenuItemActionPerformed
    (new ShowManagerTask(this.mainPanel, this.authorReferenceGroupManager)).execute();
  }//GEN-LAST:event_authorsReferencesGroupManagerMenuItemActionPerformed

  /**
   *
   * @param evt
   */
  private void referencesSourceManagerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_referencesSourceManagerMenuItemActionPerformed
    (new ShowManagerTask(this.mainPanel, this.referenceSourceManager)).execute();
  }//GEN-LAST:event_referencesSourceManagerMenuItemActionPerformed

  /**
   *
   * @param evt
   */
  private void referencesSourceGroupsManagerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_referencesSourceGroupsManagerMenuItemActionPerformed
    (new ShowManagerTask(this.mainPanel, this.referenceSourceGroup)).execute();
  }//GEN-LAST:event_referencesSourceGroupsManagerMenuItemActionPerformed

  /**
   *
   * @param evt
   */
  private void periodsManagerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_periodsManagerMenuItemActionPerformed
    (new ShowManagerTask(this.mainPanel, this.periodManager)).execute();
  }//GEN-LAST:event_periodsManagerMenuItemActionPerformed

  /**
   *
   * @param evt
   */
  private void publishDatesManagerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publishDatesManagerMenuItemActionPerformed
    (new ShowManagerTask(this.mainPanel, this.publishDateManager)).execute();
  }//GEN-LAST:event_publishDatesManagerMenuItemActionPerformed

  /**
   *
   * @param evt
   */
  private void subjectCategoriesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectCategoriesMenuItemActionPerformed
    (new ShowManagerTask(this.mainPanel, this.subjectCategoyManager)).execute();
  }//GEN-LAST:event_subjectCategoriesMenuItemActionPerformed

  /**
   *
   * @param evt
   */
  private void wordsManagerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wordsManagerMenuItemActionPerformed
    (new ShowManagerTask(this.mainPanel, this.wordManager)).execute();
  }//GEN-LAST:event_wordsManagerMenuItemActionPerformed

  /**
   *
   * @param evt
   */
  private void wordsGroupsManagerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wordsGroupsManagerMenuItemActionPerformed
    (new ShowManagerTask(this.mainPanel, this.wordGroupManager)).execute();
  }//GEN-LAST:event_wordsGroupsManagerMenuItemActionPerformed

  /**
   *
   * @param evt
   */
  private void authorGroupManualSetMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorGroupManualSetMenuItemActionPerformed
    (new ShowManagerTask(this.mainPanel, this.authorGroupManualSetManager)).execute();
  }//GEN-LAST:event_authorGroupManualSetMenuItemActionPerformed

  /**
   *
   * @param evt
   */
  private void authorReferenceGroupManualSetMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorReferenceGroupManualSetMenuItemActionPerformed
    (new ShowManagerTask(this.mainPanel, this.authorReferenceGroupManualSetManager)).execute();
  }//GEN-LAST:event_authorReferenceGroupManualSetMenuItemActionPerformed

  /**
   *
   * @param evt
   */
  private void referenceGroupManualSetMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_referenceGroupManualSetMenuItemActionPerformed
    (new ShowManagerTask(this.mainPanel, this.referenceGroupManualSetManager)).execute();
  }//GEN-LAST:event_referenceGroupManualSetMenuItemActionPerformed

  /**
   *
   * @param evt
   */
  private void referenceSourceGroupManualSetMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_referenceSourceGroupManualSetMenuItemActionPerformed
    (new ShowManagerTask(this.mainPanel, this.referenceSourceGroupManualSetManager)).execute();
  }//GEN-LAST:event_referenceSourceGroupManualSetMenuItemActionPerformed

  /**
   * 
   * @param evt
   */
  private void wordGroupManualSetMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wordGroupManualSetMenuItemActionPerformed
    (new ShowManagerTask(this.mainPanel, this.wordGroupManualSetManager)).execute();
  }//GEN-LAST:event_wordGroupManualSetMenuItemActionPerformed

  /**
   * 
   * @param evt
   */
  private void newProjectToolBarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProjectToolBarButtonActionPerformed
    WizardManager.getInstance().showNewProject();
  }//GEN-LAST:event_newProjectToolBarButtonActionPerformed

  /**
   * 
   * @param evt
   */
  private void newProjectMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProjectMenuItemActionPerformed
    WizardManager.getInstance().showNewProject();
  }//GEN-LAST:event_newProjectMenuItemActionPerformed

  /**
   * 
   * @param evt
   */
  private void closeProjectMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeProjectMenuItemActionPerformed
    (new CloseProjectTask(this)).execute();
  }//GEN-LAST:event_closeProjectMenuItemActionPerformed

  /**
   * 
   * @param evt
   */
  private void makeAnalysisMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeAnalysisMenuItemActionPerformed
    WizardManager.getInstance().showMakeAnalysis();
  }//GEN-LAST:event_makeAnalysisMenuItemActionPerformed

  /**
   * 
   * @param evt
   */
  private void loadAnalysisMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadAnalysisMenuItemActionPerformed
    (new LoadAnalysisTask(rootPane)).execute();
  }//GEN-LAST:event_loadAnalysisMenuItemActionPerformed

  /**
   * 
   * @param evt
   */
  private void findSimilarAuthorsByDistanceMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findSimilarAuthorsByDistanceMenuItemActionPerformed
    (new FindSimilarAuthorsWithoutGroupByDistanceTask(this)).execute();
  }//GEN-LAST:event_findSimilarAuthorsByDistanceMenuItemActionPerformed

  /**
   * 
   * @param evt
   */
  private void findSimilarAuthorReferencesByDistanceMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findSimilarAuthorReferencesByDistanceMenuItemActionPerformed
    (new FindSimilarAuthorReferencesWithoutGroupByDistanceTask(this)).execute();
  }//GEN-LAST:event_findSimilarAuthorReferencesByDistanceMenuItemActionPerformed

  /**
   * 
   * @param evt
   */
  private void findSimilarReferencesByDistanceMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findSimilarReferencesByDistanceMenuItemActionPerformed
    (new FindSimilarReferencesWithoutGroupByDistanceTask(this)).execute();
  }//GEN-LAST:event_findSimilarReferencesByDistanceMenuItemActionPerformed

  /**
   * 
   * @param evt
   */
  private void findSimilarReferenceSourcesByDistanceMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findSimilarReferenceSourcesByDistanceMenuItemActionPerformed
    (new FindSimilarReferenceSourcesWithoutGroupByDistanceTask(this)).execute();
  }//GEN-LAST:event_findSimilarReferenceSourcesByDistanceMenuItemActionPerformed
  
  /**
   * 
   * @param evt
   */
  private void findSimilarWordsByDistanceMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findSimilarWordsByDistanceMenuItemActionPerformed
    (new FindSimilarWordsWithoutGroupByDistanceTask(this)).execute();
  }//GEN-LAST:event_findSimilarWordsByDistanceMenuItemActionPerformed

  /**
   * 
   * @param evt
   */
  private void findSimilarWordsByPluralsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findSimilarWordsByPluralsMenuItemActionPerformed
    (new FindSimilarWordsWithoutGroupByPluralsTask(this)).execute();
  }//GEN-LAST:event_findSimilarWordsByPluralsMenuItemActionPerformed

  /**
   * 
   * @param evt 
   */
  private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
    this.aboutDialog.setVisible(true);
  }//GEN-LAST:event_aboutMenuItemActionPerformed

  /**
   * 
   * @param evt 
   */
  private void importFromISIWoSMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importFromISIWoSMenuItemActionPerformed
    (new ImportFileTask(ImportFileTask.FormatAvailable.ISIWoS, this)).execute();
  }//GEN-LAST:event_importFromISIWoSMenuItemActionPerformed

  /**
   * 
   * @param evt 
   */
  private void exportGroupsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportGroupsMenuItemActionPerformed
    (new ExportGroupTask(rootPane)).execute();
  }//GEN-LAST:event_exportGroupsMenuItemActionPerformed

  /**
   * 
   * @param evt 
   */
  private void importGroupsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importGroupsMenuItemActionPerformed
    (new ImportGroupTask(rootPane)).execute();
  }//GEN-LAST:event_importGroupsMenuItemActionPerformed

  private void importFromRISMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importFromRISMenuItemActionPerformed
    (new ImportFileTask(ImportFileTask.FormatAvailable.RIS, this)).execute();
  }//GEN-LAST:event_importFromRISMenuItemActionPerformed
 
  /**
   * 
   * @param evt 
   */
  private void globalReplaceAffiliationMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_globalReplaceAffiliationMenuItemActionPerformed
    GlobalReplaceDialogManager.getInstance().showGlobalAffiliationGlobalReplaceDialog();
  }//GEN-LAST:event_globalReplaceAffiliationMenuItemActionPerformed

  /**
   * 
   * @param evt 
   */
  private void globalReplaceAuthorMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_globalReplaceAuthorMenuItemActionPerformed
    GlobalReplaceDialogManager.getInstance().showGlobalAuthorGlobalReplaceDialog();
  }//GEN-LAST:event_globalReplaceAuthorMenuItemActionPerformed

  /**
   * 
   * @param evt 
   */
  private void globalReplaceAuthorGroupMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_globalReplaceAuthorGroupMenuItemActionPerformed
    GlobalReplaceDialogManager.getInstance().showGlobalAuthorGroupGlobalReplaceDialog();
  }//GEN-LAST:event_globalReplaceAuthorGroupMenuItemActionPerformed

  /**
   * 
   * @param evt 
   */
  private void globalReplaceAuthorReferenceMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_globalReplaceAuthorReferenceMenuItemActionPerformed
    GlobalReplaceDialogManager.getInstance().showGlobalAuthorReferenceGlobalReplaceDialog();
  }//GEN-LAST:event_globalReplaceAuthorReferenceMenuItemActionPerformed

  /**
   * 
   * @param evt 
   */
  private void globalReplaceAuthorReferenceGroupMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_globalReplaceAuthorReferenceGroupMenuItemActionPerformed
    GlobalReplaceDialogManager.getInstance().showGlobalAuthorReferenceGroupGlobalReplaceDialog();
  }//GEN-LAST:event_globalReplaceAuthorReferenceGroupMenuItemActionPerformed

  /**
   * 
   * @param evt 
   */
  private void globalReplaceJournalMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_globalReplaceJournalMenuItemActionPerformed
    GlobalReplaceDialogManager.getInstance().showGlobalJournalGlobalReplaceDialog();
  }//GEN-LAST:event_globalReplaceJournalMenuItemActionPerformed

  /**
   * 
   * @param evt 
   */
  private void globalReplaceDocumentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_globalReplaceDocumentMenuItemActionPerformed
    GlobalReplaceDialogManager.getInstance().showGlobalDocumentGlobalReplaceDialog();
  }//GEN-LAST:event_globalReplaceDocumentMenuItemActionPerformed

  /**
   * 
   * @param evt 
   */
  private void globalReplacePeriodMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_globalReplacePeriodMenuItemActionPerformed
    GlobalReplaceDialogManager.getInstance().showGlobalPeriodGlobalReplaceDialog();
  }//GEN-LAST:event_globalReplacePeriodMenuItemActionPerformed

  /**
   * 
   * @param evt 
   */
  private void globalReplaceSubjectCategoryMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_globalReplaceSubjectCategoryMenuItemActionPerformed
    GlobalReplaceDialogManager.getInstance().showGlobalSubjectCategoryGlobalReplaceDialog();
  }//GEN-LAST:event_globalReplaceSubjectCategoryMenuItemActionPerformed

  /**
   * 
   * @param evt 
   */
  private void globalReplacePublishDateMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_globalReplacePublishDateMenuItemActionPerformed
    GlobalReplaceDialogManager.getInstance().showGlobalPublishDateGlobalReplaceDialog();
  }//GEN-LAST:event_globalReplacePublishDateMenuItemActionPerformed

  /**
   * 
   * @param evt 
   */
  private void globalReplaceReferenceMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_globalReplaceReferenceMenuItemActionPerformed
    GlobalReplaceDialogManager.getInstance().showGlobalReferenceGlobalReplaceDialog();
  }//GEN-LAST:event_globalReplaceReferenceMenuItemActionPerformed

  /**
   * 
   * @param evt 
   */
  private void globalReplaceReferenceGroupMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_globalReplaceReferenceGroupMenuItemActionPerformed
    GlobalReplaceDialogManager.getInstance().showGlobalReferenceGroupGlobalReplaceDialog();
  }//GEN-LAST:event_globalReplaceReferenceGroupMenuItemActionPerformed

  /**
   * 
   * @param evt 
   */
  private void globalReplaceReferenceSourceMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_globalReplaceReferenceSourceMenuItemActionPerformed
    GlobalReplaceDialogManager.getInstance().showGlobalReferenceSourceGlobalReplaceDialog();
  }//GEN-LAST:event_globalReplaceReferenceSourceMenuItemActionPerformed

  /**
   * 
   * @param evt 
   */
  private void globalReplaceReferenceSourceGroupMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_globalReplaceReferenceSourceGroupMenuItemActionPerformed
    GlobalReplaceDialogManager.getInstance().showGlobalReferenceSourceGroupGlobalReplaceDialog();
  }//GEN-LAST:event_globalReplaceReferenceSourceGroupMenuItemActionPerformed

  /**
   * 
   * @param evt 
   */
  private void globalReplaceWordMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_globalReplaceWordMenuItemActionPerformed
    GlobalReplaceDialogManager.getInstance().showGlobalWordGlobalReplaceDialog();
  }//GEN-LAST:event_globalReplaceWordMenuItemActionPerformed

  /**
   * 
   * @param evt 
   */
  private void globalReplaceWordGroupMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_globalReplaceWordGroupMenuItemActionPerformed
    GlobalReplaceDialogManager.getInstance().showGlobalWordGroupGlobalReplaceDialog();
  }//GEN-LAST:event_globalReplaceWordGroupMenuItemActionPerformed

  /**
   * 
   * @param evt 
   */
  private void wordGroupStatisticsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wordGroupStatisticsMenuItemActionPerformed
    StatisticDialogManager.getInstance().showWordGroupStatisticDialog();
  }//GEN-LAST:event_wordGroupStatisticsMenuItemActionPerformed

  /**
   * 
   */
  private void authorGroupStatisticsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorGroupStatisticsMenuItemActionPerformed
    StatisticDialogManager.getInstance().showAuthorGroupStatisticDialog();
  }//GEN-LAST:event_authorGroupStatisticsMenuItemActionPerformed

  /**
   * 
   * @param evt 
   */
  private void referenceGroupStatisticsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_referenceGroupStatisticsMenuItemActionPerformed
    StatisticDialogManager.getInstance().showReferenceGroupStatisticDialog();
  }//GEN-LAST:event_referenceGroupStatisticsMenuItemActionPerformed

  /**
   * 
   * @param evt 
   */
  private void importFromCsvMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importFromCsvMenuItemActionPerformed
    (new ImportFileTask(ImportFileTask.FormatAvailable.CSV, this)).execute();
  }//GEN-LAST:event_importFromCsvMenuItemActionPerformed

  private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    finish();
  }//GEN-LAST:event_formWindowClosing

  private void findSimilarWordsByPluralsAutomaticMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findSimilarWordsByPluralsAutomaticMenuItemActionPerformed
    (new FindSimilarWordsWithoutGroupByPluralsAutomaticTask(this)).execute();
  }//GEN-LAST:event_findSimilarWordsByPluralsAutomaticMenuItemActionPerformed

  private void importFromRISMay2014MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importFromRISMay2014MenuItemActionPerformed
    (new ImportFileTask(ImportFileTask.FormatAvailable.RISMay2014, this)).execute();
  }//GEN-LAST:event_importFromRISMay2014MenuItemActionPerformed

  private void findSimilarWordsGroupByDistanceMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findSimilarWordsGroupByDistanceMenuItemActionPerformed
    (new FindSimilarWordGroupsByDistanceTask(this)).execute();
  }//GEN-LAST:event_findSimilarWordsGroupByDistanceMenuItemActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JMenuItem aboutMenuItem;
  private javax.swing.JMenu addFilesMenu;
  private KnowledgeBaseStateObserverMenuItem affiliationsManagerMenuItem;
  private javax.swing.JMenu analysisMenu;
  private KnowledgeBaseStateObserverMenuItem authorGroupManualSetMenuItem;
  private javax.swing.JMenu authorGroupMenu;
  private KnowledgeBaseStateObserverMenuItem authorGroupStatisticsMenuItem;
  private KnowledgeBaseStateObserverMenuItem authorReferenceGroupManualSetMenuItem;
  private javax.swing.JMenu authorReferenceGroupMenu;
  private KnowledgeBaseStateObserverMenuItem authorsGroupsManagerMenuItem;
  private KnowledgeBaseStateObserverMenuItem authorsManagerMenuItem;
  private javax.swing.JMenu authorsMenu;
  private KnowledgeBaseStateObserverMenuItem authorsReferenceManagerMenuItem;
  private KnowledgeBaseStateObserverMenuItem authorsReferencesGroupManagerMenuItem;
  private KnowledgeBaseStateObserverMenuItem closeProjectMenuItem;
  private KnowledgeBaseStateObserverMenuItem documentsManagerMenuItem;
  private javax.swing.JMenu documentsMenu;
  private javax.swing.JMenu editMenu;
  private javax.swing.JToolBar editToolBar;
  private javax.swing.JMenuItem exitMenuItem;
  private KnowledgeBaseStateObserverMenuItem exportGroupsMenuItem;
  private javax.swing.JMenu exportMenu;
  private javax.swing.JMenu fileMenu;
  private javax.swing.JToolBar fileToolBar;
  private KnowledgeBaseStateObserverMenuItem findSimilarAuthorReferencesByDistanceMenuItem;
  private KnowledgeBaseStateObserverMenuItem findSimilarAuthorsByDistanceMenuItem;
  private KnowledgeBaseStateObserverMenuItem findSimilarReferenceSourcesByDistanceMenuItem;
  private KnowledgeBaseStateObserverMenuItem findSimilarReferencesByDistanceMenuItem;
  private KnowledgeBaseStateObserverMenuItem findSimilarWordsByDistanceMenuItem;
  private KnowledgeBaseStateObserverMenuItem findSimilarWordsByPluralsAutomaticMenuItem;
  private KnowledgeBaseStateObserverMenuItem findSimilarWordsByPluralsMenuItem;
  private KnowledgeBaseStateObserverMenuItem findSimilarWordsGroupByDistanceMenuItem;
  private KnowledgeBaseStateObserverMenuItem globalReplaceAffiliationMenuItem;
  private KnowledgeBaseStateObserverMenuItem globalReplaceAuthorGroupMenuItem;
  private KnowledgeBaseStateObserverMenuItem globalReplaceAuthorMenuItem;
  private KnowledgeBaseStateObserverMenuItem globalReplaceAuthorReferenceGroupMenuItem;
  private KnowledgeBaseStateObserverMenuItem globalReplaceAuthorReferenceMenuItem;
  private KnowledgeBaseStateObserverMenuItem globalReplaceDocumentMenuItem;
  private KnowledgeBaseStateObserverMenuItem globalReplaceJournalMenuItem;
  private javax.swing.JMenu globalReplaceMenu;
  private KnowledgeBaseStateObserverMenuItem globalReplacePeriodMenuItem;
  private KnowledgeBaseStateObserverMenuItem globalReplacePublishDateMenuItem;
  private KnowledgeBaseStateObserverMenuItem globalReplaceReferenceGroupMenuItem;
  private KnowledgeBaseStateObserverMenuItem globalReplaceReferenceMenuItem;
  private KnowledgeBaseStateObserverMenuItem globalReplaceReferenceSourceGroupMenuItem;
  private KnowledgeBaseStateObserverMenuItem globalReplaceReferenceSourceMenuItem;
  private KnowledgeBaseStateObserverMenuItem globalReplaceSubjectCategoryMenuItem;
  private KnowledgeBaseStateObserverMenuItem globalReplaceWordGroupMenuItem;
  private KnowledgeBaseStateObserverMenuItem globalReplaceWordMenuItem;
  private javax.swing.JMenu groupSetMenu;
  private javax.swing.JMenu helpMenu;
  private KnowledgeBaseStateObserverMenuItem importFromCsvMenuItem;
  private KnowledgeBaseStateObserverMenuItem importFromISIWoSMenuItem;
  private KnowledgeBaseStateObserverMenuItem importFromRISMay2014MenuItem;
  private KnowledgeBaseStateObserverMenuItem importFromRISMenuItem;
  private KnowledgeBaseStateObserverMenuItem importGroupsMenuItem;
  private javax.swing.JMenu importMenu;
  private javax.swing.JToolBar.Separator jSeparator1;
  private KnowledgeBaseStateObserverMenuItem journalsManagerMenuItem;
  private javax.swing.JMenu journalsMenu;
  private javax.swing.JMenu knowledgeBaseMenu;
  private javax.swing.JMenuItem loadAnalysisMenuItem;
  private javax.swing.JMenuBar mainMenuBar;
  private javax.swing.JPanel mainPanel;
  private KnowledgeBaseStateObserverMenuItem makeAnalysisMenuItem;
  private NewProjectMenuItem newProjectMenuItem;
  private NewProjectToolBarButton newProjectToolBarButton;
  private OpenProjectMenuItem openProjectMenuItem;
  private OpenProjectToolBarButton openProjectToolBarButton;
  private KnowledgeBaseStateObserverMenuItem periodsManagerMenuItem;
  private javax.swing.JMenu periodsMenu;
  private KnowledgeBaseStateObserverMenuItem publishDatesManagerMenuItem;
  private javax.swing.JMenu publishDatesMenu;
  private RedoMenuItem redoMenuItem1;
  private RedoToolBarButton redoToolBarButton;
  private KnowledgeBaseStateObserverMenuItem referenceGroupManualSetMenuItem;
  private javax.swing.JMenu referenceGroupMenu;
  private KnowledgeBaseStateObserverMenuItem referenceGroupStatisticsMenuItem;
  private KnowledgeBaseStateObserverMenuItem referenceSourceGroupManualSetMenuItem;
  private javax.swing.JMenu referenceSourceMenu;
  private KnowledgeBaseStateObserverMenuItem referencesGroupsManagerMenuItem;
  private KnowledgeBaseStateObserverMenuItem referencesManagerMenuItem;
  private javax.swing.JMenu referencesMenu;
  private KnowledgeBaseStateObserverMenuItem referencesSourceGroupsManagerMenuItem;
  private KnowledgeBaseStateObserverMenuItem referencesSourceManagerMenuItem;
  private javax.swing.JPopupMenu.Separator separator1;
  private javax.swing.JPopupMenu.Separator separator2;
  private javax.swing.JPopupMenu.Separator separator3;
  private javax.swing.JMenu statisticMenu;
  private javax.swing.JMenu subjectCategoriesMenu;
  private KnowledgeBaseStateObserverMenuItem subjectCategoriesMenuItem;
  private javax.swing.JPanel toolBarPanel;
  private UndoMenuItem undoMenuItem1;
  private UndoToolBarButton undoToolBarButton;
  private KnowledgeBaseStateObserverMenuItem wordGroupManualSetMenuItem;
  private javax.swing.JMenu wordGroupMenu;
  private KnowledgeBaseStateObserverMenuItem wordGroupStatisticsMenuItem;
  private KnowledgeBaseStateObserverMenuItem wordsGroupsManagerMenuItem;
  private KnowledgeBaseStateObserverMenuItem wordsManagerMenuItem;
  private javax.swing.JMenu wordsMenu;
  // End of variables declaration//GEN-END:variables
  private final AffiliationManager affiliationManger = new AffiliationManager();
  private final AuthorManager authorManager = new AuthorManager();
  private final AuthorGroupManager authorGroupManager = new AuthorGroupManager();
  private final AuthorReferenceGroupManager authorReferenceGroupManager = new AuthorReferenceGroupManager();
  private final AuthorReferenceManager authorReferenceManager = new AuthorReferenceManager();
  private final DocumentManager documentManager = new DocumentManager();
  private final JournalManager journalManager = new JournalManager();
  private final PeriodManager periodManager = new PeriodManager();
  private final PublishDateManager publishDateManager = new PublishDateManager();
  private final ReferenceManager referenceManager = new ReferenceManager();
  private final ReferenceGroupManager referenceGroupManager = new ReferenceGroupManager();
  private final ReferenceSourceManager referenceSourceManager = new ReferenceSourceManager();
  private final ReferenceSourceGroupManager referenceSourceGroup = new ReferenceSourceGroupManager();
  private final SubjectCategoryManager subjectCategoyManager = new SubjectCategoryManager();
  private final WordGroupManager wordGroupManager = new WordGroupManager();
  private final WordManager wordManager = new WordManager();
  private final AuthorGroupManualSetManager authorGroupManualSetManager = new AuthorGroupManualSetManager();
  private final AuthorReferenceGroupManualSetManager authorReferenceGroupManualSetManager = new AuthorReferenceGroupManualSetManager();
  private final ReferenceGroupManualSetManager referenceGroupManualSetManager = new ReferenceGroupManualSetManager();
  private final ReferenceSourceGroupManualSetManager referenceSourceGroupManualSetManager = new ReferenceSourceGroupManualSetManager();
  private final WordGroupManualSetManager wordGroupManualSetManager = new WordGroupManualSetManager();
  private final AboutDialog aboutDialog = new AboutDialog(this);
}
