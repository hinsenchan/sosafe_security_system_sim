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
//panel for bill screen
public class SimBillPanel extends javax.swing.JPanel {
    private static SimBillPanel instance;
    private SecuritySimController securitySimController;
    
    //return single instance
    public synchronized static SimBillPanel getInstance() {
        if (instance == null) {
            instance = new SimBillPanel();
        }
        return instance;
    }

    /**
     * Creates new form SimSensorSetupPanel
     */
    private SimBillPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        mainScrollPane = new javax.swing.JScrollPane();
        mainTextArea = new javax.swing.JTextArea();

        mainTextArea.setColumns(20);
        mainTextArea.setRows(5);
        mainScrollPane.setViewportView(mainTextArea);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(mainScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane mainScrollPane;
    private javax.swing.JTextArea mainTextArea;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the mainTextArea
     */
    public javax.swing.JTextArea getMainTextArea() {
        return mainTextArea;
    }
            
    //set controller for this view
    public void setController(SecuritySimController securitySimController) {
        this.securitySimController = securitySimController;
    }
}
