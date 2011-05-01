/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UserUI.java
 *
 * Created on Nov 2, 2010, 4:45:08 PM
 */
package com.wordpress.salaboy.emergencyservice.main;

import com.wordpress.salaboy.api.HumanTaskService;
import com.wordpress.salaboy.api.HumanTaskServiceFactory;
import com.wordpress.salaboy.conf.HumanTaskServiceConfiguration;
import com.wordpress.salaboy.emergencyservice.dashboard.EmergenciesDashboard;
import com.wordpress.salaboy.emergencyservice.extrapanels.About;
import com.wordpress.salaboy.emergencyservice.extrapanels.EventGeneratorsConfigPanel;
import com.wordpress.salaboy.emergencyservice.tasklists.ControlSuggestedProceduresTaskListPanel;
import com.wordpress.salaboy.emergencyservice.tasklists.DoctorsUpdateTaskListPanel;
import com.wordpress.salaboy.emergencyservice.tasklists.IncomingPhoneCallsTaskListPanel;
import com.wordpress.salaboy.emergencyservice.tasklists.SelectVehicleTaskListPanel;
import com.wordpress.salaboy.messaging.MessageConsumerWorker;
import com.wordpress.salaboy.messaging.MessageConsumerWorkerHandler;
import com.wordpress.salaboy.model.messages.VehicleDispatchedMessage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTabbedPane;
import com.wordpress.salaboy.model.serviceclient.DistributedPeristenceServerService;
import javax.swing.JFrame;
import com.wordpress.salaboy.smarttasks.jbpm5wrapper.conf.JBPM5MinaHumanTaskClientConfiguration;

/**
 *
 * @author salaboy
 */
public class UserTaskListUI extends javax.swing.JFrame {

    private HumanTaskService humanTaskServiceClient;
    
    public static Long LAST_CALL_ID = null;
    public static Long LAST_DISPATCHED_VEHICLE_ID = null;
    
    
    //Task Lists Panels
    private IncomingPhoneCallsTaskListPanel phoneCallsTaskListPanel;
    private ControlSuggestedProceduresTaskListPanel controlSuggestedProceduresTaskListPanel;
    private SelectVehicleTaskListPanel selectAmbulanceTaskListPanel;
    private DoctorsUpdateTaskListPanel doctorsUpdateTaskListPanel;
  
    private MessageConsumerWorker vehicleDispatchedWorker;


    /** Creates new form UserUI */
    public UserTaskListUI() {
        initComponents();
        initTaskClient();
        initMessageWorkers();
        
        //Initializing Distribtued Persistence Service
        DistributedPeristenceServerService.getInstance();
        
        phoneCallsTaskListPanel = new IncomingPhoneCallsTaskListPanel(this);
        controlSuggestedProceduresTaskListPanel = new ControlSuggestedProceduresTaskListPanel(this);
        selectAmbulanceTaskListPanel = new SelectVehicleTaskListPanel(this);
        doctorsUpdateTaskListPanel = new DoctorsUpdateTaskListPanel(this);
        this.mainJTabbedPane.add(this.phoneCallsTaskListPanel, 0);
        this.mainJTabbedPane.add(this.controlSuggestedProceduresTaskListPanel, 1);
        this.mainJTabbedPane.add(this.selectAmbulanceTaskListPanel, 2);
        this.mainJTabbedPane.add(this.doctorsUpdateTaskListPanel, 3);
        this.mainJTabbedPane.setSelectedComponent(this.phoneCallsTaskListPanel);
        
        
       
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        mainJTabbedPane = new javax.swing.JTabbedPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuItemConfigreEventGenerators = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        org.jdesktop.layout.GroupLayout jDialog1Layout = new org.jdesktop.layout.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout jDialog2Layout = new org.jdesktop.layout.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Emergency Service Console");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        mainJTabbedPane.setPreferredSize(new java.awt.Dimension(300, 400));

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 359, Short.MAX_VALUE)
            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .add(mainJTabbedPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 503, Short.MAX_VALUE)
            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .add(mainJTabbedPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        fileMenu.setText("Emergency Services");

        jMenuItem2.setText("Emergency Dashboard");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseClicked(evt);
            }
        });
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem2);

        menuItemConfigreEventGenerators.setText("Configure Event Generators");
        menuItemConfigreEventGenerators.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemConfigreEventGeneratorsActionPerformed(evt);
            }
        });
        fileMenu.add(menuItemConfigreEventGenerators);

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText("Help");

        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        aboutMenuItem.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                aboutMenuItemMenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            getTaskClient().cleanUpService();
        } catch (Exception ex) {
            Logger.getLogger(UserTaskListUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void aboutMenuItemMenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_aboutMenuItemMenuKeyPressed
        new About().setVisible(true);
    }//GEN-LAST:event_aboutMenuItemMenuKeyPressed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable()    {

            @Override
            public void run() {
                new About().setVisible(true);

            }
        });
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void refreshReportList() {
       // DefaultListModel model = new DefaultListModel();
//        for (String message : GridEmergencyService.logger.getLogs()) {
//            model.addElement(message);
//        }

//        this.lstReports.setModel(model);
    }

    private void menuItemConfigreEventGeneratorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemConfigreEventGeneratorsActionPerformed
        
        java.awt.EventQueue.invokeLater(new Runnable()    {

            @Override
            public void run() {
                JFrame jFrame = new JFrame();
                jFrame.add( new EventGeneratorsConfigPanel());
                jFrame.setSize(300, 600);
                jFrame.setVisible(true);
            }
        });

    }//GEN-LAST:event_menuItemConfigreEventGeneratorsActionPerformed

    private void jMenuItem2MenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jMenuItem2MenuKeyPressed
        // TODO add your handling code here:
         
        
    }//GEN-LAST:event_jMenuItem2MenuKeyPressed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
//        java.awt.EventQueue.invokeLater(new Runnable()    {
//
//            @Override
//            public void run() {
//                JFrame jFrame = new JFrame();
//                jFrame.add( new ServersStatusPanel(getTaskClient()));
//                jFrame.setSize(300, 600);
//                jFrame.setVisible(true);
//            }
//        });
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmergenciesDashboard().setVisible(true);
                
            }
         });
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenuItem2MouseClicked

    public void refreshPatientsTable() {
//        DefaultTableModel tableModel = ((DefaultTableModel) this.patientJTable1.getModel());
//
//        int rowCount = tableModel.getRowCount();
//        for (int i = 0; i < rowCount; i++) {
//            tableModel.removeRow(0);
//        }
//
//        for (Hospital hospital : CityEntities.hospitals) {
//            for (Patient patient : hospital.getPatients()) {
//                tableModel.addRow(new Object[]{patient.getId(), patient.getGender(), patient.getAge(), patient.getGender(), hospital.getName()});
//
//            }
//
//        }
//
//


    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable()     {

            public void run() {
                new UserTaskListUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane mainJTabbedPane;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItemConfigreEventGenerators;
    // End of variables declaration//GEN-END:variables

    private void initTaskClient() {
        //humanTaskServiceClient = HumanTaskServiceFactory.newHumanTaskService(new ClassPathResource("conf/human-tasks-services.xml"));
        HumanTaskServiceConfiguration taskClientConf = new HumanTaskServiceConfiguration();
        taskClientConf.addHumanTaskClientConfiguration("jBPM5-HT-Client",new JBPM5MinaHumanTaskClientConfiguration("127.0.0.1", 9123));
        humanTaskServiceClient = HumanTaskServiceFactory.newHumanTaskService(taskClientConf);
        humanTaskServiceClient.initializeService();
    }

//    public void setUIMap(CityMapUI game) {
//        this.game = game;
     

  //  }

    public void callHandled() {
        this.phoneCallsTaskListPanel.refresh();

    }

//    public void sendAmbulance(EmergencyType emergencyType, Long ambulanceId) {
//        this.currentEmergenciesPanel.addNewEmergency(ambulanceId);
//        mainJTabbedPane.setSelectedComponent(this.currentEmergenciesPanel);
//        
//       
//
//        //@TODO: NOTE: I Don't like this approach because the UI is deciding something that the process should do, not at HT level
//     //   this.game.addAmbulance(GraphicableFactory.newAmbulance(CityEntitiesUtils.getAmbulanceById(ambulanceId)));
////        GridEmergencyService.getInstance().getMapEventsNotifier().addWorldEventNotifier(EventType.AMBULANCE_POSITION, 
////                            new MapAmbulancePositionUpdatedEventNotifier());
////        GridEmergencyService.getInstance().getMapEventsNotifier().addWorldEventNotifier(EventType.AMBULANCE_POSITION,
////                new TaskListUIAmbulancePositionUpdatedEventNotifier(this.currentEmergenciesPanel));
////        GridEmergencyService.getInstance().getMapEventsNotifier().addWorldEventNotifier(EventType.EMERGENCY_REACHED,
////                new TaskListUIEmergencyReachedEventNotifier());
////
////        GridEmergencyService.getInstance().getEmergencyReachedNotified().put(ambulanceId, false);
//
//    }

    public void medicalEvaluationCompleted(int priority, String comment) {
//        try {
//
//            List<TTaskAbstract> taskAbstracts = getTaskClient().getMyTaskAbstracts("", "doctor", "", null, "", "", "", 0, 0);
//            TTaskAbstract taskAbstract = taskAbstracts.get(0);
//
//
//            getTaskClient().setAuthorizedEntityId("doctor");
//            getTaskClient().start(taskAbstract.getId());
//
//
//            List<TAttachmentInfo> attachmentsInfo = getTaskClient().getAttachmentInfos(taskAbstract.getId());
//            TAttachmentInfo firstAttachmentInfo = attachmentsInfo.get(0);
//            TAttachment attachment = getTaskClient().getAttachments(taskAbstract.getId(), firstAttachmentInfo.getName()).get(0);
//            
//            System.out.println("Content= " + attachment.getValue());
//            
//            
//            ByteArrayInputStream bais = new ByteArrayInputStream(((Content)attachment.getValue()).getContent());
//            ObjectInputStream ois = new ObjectInputStream(bais);
//            String taskinfo2 = (String) ois.readObject();
//
//            System.out.println("TaskInfo 2= " + taskinfo2);
//            HashMap<String, Object> info = new HashMap<String, Object>();
//
//
//            info.put("emergency.priority", String.valueOf(priority));
//            ContentData result = new ContentData();
//            result.setAccessType(AccessType.Inline);
//            result.setType("java.util.Map");
//            ByteArrayOutputStream bos = new ByteArrayOutputStream();
//            ObjectOutputStream out = new ObjectOutputStream(bos);
//            out.writeObject(info);
//            out.close();
//            result.setContent(bos.toByteArray());
//            
//            
//            getTaskClient().setAuthorizedEntityId("doctor");
//            getTaskClient().complete(taskAbstract.getId(), result);
//
//        } catch (Exception e) {
//            Logger.getLogger(UserTaskListUI.class.getName()).log(Level.SEVERE, null, e);
//        }
    }

    public JTabbedPane getMainJTabbedPane() {
        return mainJTabbedPane;
    }


    public HumanTaskService getTaskClient() {
        return humanTaskServiceClient;
    }

//    public CurrentEmergenciesPanel getCurrentEmergenciesPanel() {
//        return currentEmergenciesPanel;
//    }

   // public CityMapUI getGame() {
//        return game;
  //  }

    
    private void initMessageWorkers() {
        vehicleDispatchedWorker = new MessageConsumerWorker("TaskListUIVehicleDispatchedWorker", new MessageConsumerWorkerHandler<VehicleDispatchedMessage>() {

            @Override
            public void handleMessage(VehicleDispatchedMessage message) {
                //store only the last vehicle and call id. This is going to
                //be used later by the wiimote event generator.
                LAST_CALL_ID = message.getCallId();
                LAST_DISPATCHED_VEHICLE_ID = message.getVehicleId();
            }
        });
    
        vehicleDispatchedWorker.start();
    }

    @Override
    public void dispose() {
        super.dispose();
        if (vehicleDispatchedWorker != null){
            vehicleDispatchedWorker.stopWorker();
        }
    }
 
    
    
}
