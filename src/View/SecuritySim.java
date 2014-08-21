/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import Controller.SecuritySimController;

/**
 *
 * @author hinsenchan
 */
public class SecuritySim extends javax.swing.JFrame {
    private SimBillPanel billPanel;
    private SimCustomerPanel customerPanel;
    private SimMapPanel mapPanel;
    private SimSensorSetupPanel sensorSetupPanel;
    private SimSensorDisplayPanel sensorDisplayPanel;
    private SimControlPanel controlPanel;
    private SecuritySimController securitySimController;

    /**
     * Creates new form SecuritySim
     */
    public SecuritySim() {
        initComponents(); 
        billPanel = new SimBillPanel();
        customerPanel = new SimCustomerPanel();
        mapPanel = new SimMapPanel();
        sensorSetupPanel = new SimSensorSetupPanel();
        sensorDisplayPanel = new SimSensorDisplayPanel();
        controlPanel = new SimControlPanel();        
        securitySimController = new SecuritySimController(this);        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        simScrollPane = new javax.swing.JScrollPane();
        simPanel = new javax.swing.JPanel();
        simTabbedPane = new javax.swing.JTabbedPane();
        accountPanel = new javax.swing.JPanel();
        accountLeftPanel = new javax.swing.JPanel();
        accountRightPanel = new javax.swing.JPanel();
        setupPanel = new javax.swing.JPanel();
        setupLeftPanel = new javax.swing.JPanel();
        setupRightPanel = new javax.swing.JPanel();
        simulationPanel = new javax.swing.JPanel();
        simulationLeftPanel = new javax.swing.JPanel();
        simulationRightPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout accountLeftPanelLayout = new javax.swing.GroupLayout(accountLeftPanel);
        accountLeftPanel.setLayout(accountLeftPanelLayout);
        accountLeftPanelLayout.setHorizontalGroup(
            accountLeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
        );
        accountLeftPanelLayout.setVerticalGroup(
            accountLeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout accountRightPanelLayout = new javax.swing.GroupLayout(accountRightPanel);
        accountRightPanel.setLayout(accountRightPanelLayout);
        accountRightPanelLayout.setHorizontalGroup(
            accountRightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 486, Short.MAX_VALUE)
        );
        accountRightPanelLayout.setVerticalGroup(
            accountRightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout accountPanelLayout = new javax.swing.GroupLayout(accountPanel);
        accountPanel.setLayout(accountPanelLayout);
        accountPanelLayout.setHorizontalGroup(
            accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountPanelLayout.createSequentialGroup()
                .addComponent(accountLeftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(accountRightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        accountPanelLayout.setVerticalGroup(
            accountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(accountLeftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(accountRightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        simTabbedPane.addTab("Account", accountPanel);

        javax.swing.GroupLayout setupLeftPanelLayout = new javax.swing.GroupLayout(setupLeftPanel);
        setupLeftPanel.setLayout(setupLeftPanelLayout);
        setupLeftPanelLayout.setHorizontalGroup(
            setupLeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 486, Short.MAX_VALUE)
        );
        setupLeftPanelLayout.setVerticalGroup(
            setupLeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout setupRightPanelLayout = new javax.swing.GroupLayout(setupRightPanel);
        setupRightPanel.setLayout(setupRightPanelLayout);
        setupRightPanelLayout.setHorizontalGroup(
            setupRightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
        );
        setupRightPanelLayout.setVerticalGroup(
            setupRightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout setupPanelLayout = new javax.swing.GroupLayout(setupPanel);
        setupPanel.setLayout(setupPanelLayout);
        setupPanelLayout.setHorizontalGroup(
            setupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setupPanelLayout.createSequentialGroup()
                .addComponent(setupLeftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(setupRightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        setupPanelLayout.setVerticalGroup(
            setupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(setupLeftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(setupRightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        simTabbedPane.addTab("Setup", setupPanel);

        javax.swing.GroupLayout simulationLeftPanelLayout = new javax.swing.GroupLayout(simulationLeftPanel);
        simulationLeftPanel.setLayout(simulationLeftPanelLayout);
        simulationLeftPanelLayout.setHorizontalGroup(
            simulationLeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 486, Short.MAX_VALUE)
        );
        simulationLeftPanelLayout.setVerticalGroup(
            simulationLeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout simulationRightPanelLayout = new javax.swing.GroupLayout(simulationRightPanel);
        simulationRightPanel.setLayout(simulationRightPanelLayout);
        simulationRightPanelLayout.setHorizontalGroup(
            simulationRightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
        );
        simulationRightPanelLayout.setVerticalGroup(
            simulationRightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout simulationPanelLayout = new javax.swing.GroupLayout(simulationPanel);
        simulationPanel.setLayout(simulationPanelLayout);
        simulationPanelLayout.setHorizontalGroup(
            simulationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(simulationPanelLayout.createSequentialGroup()
                .addComponent(simulationLeftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(simulationRightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        simulationPanelLayout.setVerticalGroup(
            simulationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(simulationLeftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(simulationRightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        simTabbedPane.addTab("Simulation", simulationPanel);

        javax.swing.GroupLayout simPanelLayout = new javax.swing.GroupLayout(simPanel);
        simPanel.setLayout(simPanelLayout);
        simPanelLayout.setHorizontalGroup(
            simPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(simTabbedPane)
        );
        simPanelLayout.setVerticalGroup(
            simPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(simTabbedPane)
        );

        simScrollPane.setViewportView(simPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(simScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(simScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SecuritySim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SecuritySim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SecuritySim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SecuritySim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SecuritySim().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accountLeftPanel;
    private javax.swing.JPanel accountPanel;
    private javax.swing.JPanel accountRightPanel;
    private javax.swing.JPanel setupLeftPanel;
    private javax.swing.JPanel setupPanel;
    private javax.swing.JPanel setupRightPanel;
    private javax.swing.JPanel simPanel;
    private javax.swing.JScrollPane simScrollPane;
    private javax.swing.JTabbedPane simTabbedPane;
    private javax.swing.JPanel simulationLeftPanel;
    private javax.swing.JPanel simulationPanel;
    private javax.swing.JPanel simulationRightPanel;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the accountLeftPanel
     */
    public javax.swing.JPanel getAccountLeftPanel() {
        return accountLeftPanel;
    }

    /**
     * @return the accountRightPanel
     */
    public javax.swing.JPanel getAccountRightPanel() {
        return accountRightPanel;
    }

    /**
     * @return the setupLeftPanel
     */
    public javax.swing.JPanel getSetupLeftPanel() {
        return setupLeftPanel;
    }

    /**
     * @return the setupRightPanel
     */
    public javax.swing.JPanel getSetupRightPanel() {
        return setupRightPanel;
    }

    /**
     * @return the simulationLeftPanel
     */
    public javax.swing.JPanel getSimulationLeftPanel() {
        return simulationLeftPanel;
    }

    /**
     * @return the simulationRightPanel
     */
    public javax.swing.JPanel getSimulationRightPanel() {
        return simulationRightPanel;
    }

    /**
     * @return the billPanel
     */
    public SimBillPanel getBillPanel() {
        return billPanel;
    }

    /**
     * @return the customerPanel
     */
    public SimCustomerPanel getCustomerPanel() {
        return customerPanel;
    }

    /**
     * @return the mapPanel
     */
    public SimMapPanel getMapPanel() {
        return mapPanel;
    }

    /**
     * @return the sensorSetupPanel
     */
    public SimSensorSetupPanel getSensorSetupPanel() {
        return sensorSetupPanel;
    }

    /**
     * @return the sensorDisplayPanel
     */
    public SimSensorDisplayPanel getSensorDisplayPanel() {
        return sensorDisplayPanel;
    }

    /**
     * @return the controlPanel
     */
    public SimControlPanel getControlPanel() {
        return controlPanel;
    }
}
