/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.company.panel;

/**
 *
 * @author Shireli
 */
public class AzeToEngPanel extends javax.swing.JPanel {

    /**
     * Creates new form AzeToEngPanel
     */
    public AzeToEngPanel() {
        initComponents();
    }

    public void correctAnswer() {
//        lblCorrect.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAze = new javax.swing.JLabel();
        lblEng = new javax.swing.JLabel();
        txtAze = new javax.swing.JTextField();
        txtEng = new javax.swing.JTextField();
        btnTranslate = new javax.swing.JButton();

        lblAze.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblAze.setText("Azerbaijan:");

        lblEng.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblEng.setText("English:");

        txtAze.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtAze.setText("enter the word");

        txtEng.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        btnTranslate.setText("translate");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAze, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEng))
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtEng)
                    .addComponent(txtAze))
                .addGap(57, 57, 57)
                .addComponent(btnTranslate)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAze)
                    .addComponent(txtAze, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEng)
                    .addComponent(txtEng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTranslate))
                .addContainerGap(233, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTranslate;
    private javax.swing.JLabel lblAze;
    private javax.swing.JLabel lblEng;
    private javax.swing.JTextField txtAze;
    private javax.swing.JTextField txtEng;
    // End of variables declaration//GEN-END:variables
}