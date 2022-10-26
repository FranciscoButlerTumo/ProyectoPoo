/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.vistas;

import com.clases.ManejoArchivos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Francisco
 */
public class InicioSesion extends javax.swing.JFrame {
    private Scanner sc;
    private int intentos = 3;
    private String usuario, contrasena;
    private ManejoArchivos ma = new ManejoArchivos();

    /**
     * Creates new form InicioSesion
     */
    public InicioSesion() {
        initComponents();
        //valida la existencia del archivo 'usuarios.txt'
        ma.validarArchivo("usuarios.txt");
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTFUsuario = new javax.swing.JTextField();
        jPFContrasena = new javax.swing.JPasswordField();
        jBInicio = new javax.swing.JButton();
        jLUsuario = new javax.swing.JLabel();
        jLContrasena = new javax.swing.JLabel();
        jBRegistro = new javax.swing.JButton();
        jLTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTFUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFUsuarioActionPerformed(evt);
            }
        });

        jPFContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPFContrasenaActionPerformed(evt);
            }
        });

        jBInicio.setText("Iniciar Sesion");
        jBInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBInicioMouseClicked(evt);
            }
        });
        jBInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInicioActionPerformed(evt);
            }
        });

        jLUsuario.setText("Usuario");

        jLContrasena.setText("Contraseña");

        jBRegistro.setText("Registrarse");
        jBRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBRegistroMouseClicked(evt);
            }
        });

        jLTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLTitulo.setText("Bienvenido a AppPlantas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPFContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jBRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jBInicio))
                    .addComponent(jLTitulo))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLUsuario))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLContrasena)
                    .addComponent(jPFContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBInicio)
                    .addComponent(jBRegistro))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFUsuarioActionPerformed

    private void jPFContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPFContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPFContrasenaActionPerformed

    private void jBInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBInicioMouseClicked
        try {
            sc = new Scanner(new File("bd\\usuarios.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
        int nLineas = ma.contarLineasArchivos("bd\\usuarios.txt");
        //almacenar datos arreglo
        String [] usuarios = new String[nLineas];
        String [] contrasenas = new String[nLineas];
        int u = 0, c = 0;
        for(int i = 0; i<nLineas; i++){        
            if(i%2 == 0){
                usuarios[u] = sc.nextLine();
                u++;
             }
            else{
                contrasenas[c] = sc.nextLine();
                c++;
            }    
        }                        
            
        //validacion de usuario y contraseña
        usuario = jTFUsuario.getText();
        contrasena = jPFContrasena.getText();
        validacionInicioSesion(usuarios, contrasenas, usuario, contrasena, intentos);
        intentos--;
    }//GEN-LAST:event_jBInicioMouseClicked

    private void jBInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBInicioActionPerformed

    private void jBRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBRegistroMouseClicked
        // TODO add your handling code here
        
        RegistroUsuario re = new RegistroUsuario();
        re.setVisible(true);
    }//GEN-LAST:event_jBRegistroMouseClicked

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
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBInicio;
    private javax.swing.JButton jBRegistro;
    private javax.swing.JLabel jLContrasena;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JLabel jLUsuario;
    private javax.swing.JPasswordField jPFContrasena;
    private javax.swing.JTextField jTFUsuario;
    // End of variables declaration//GEN-END:variables
    
    private void validacionInicioSesion(String usuarios[], String contrasenas[], String usuario, String contrasena, int intentos){
        boolean encontrado = false;

        for(int i= 0;i< usuarios.length/2;i++){
            //inicio exitoso
            if(usuarios[i].equalsIgnoreCase(usuario) && contrasenas[i].equals(contrasena)){
                encontrado = true;
                JOptionPane.showMessageDialog(null,
                        "Bienvenido",
                        "Sesion Iniciada",
                        JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
            }
        }
        if(intentos==1){
            JOptionPane.showMessageDialog(null,
                    "Alcanzo el manximo de intentos, el programa, el programa se cerrara" ,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        //inicio fallido
        if(encontrado == false){
            JOptionPane.showMessageDialog(null,
                    "Usuario o Contraseña incorrectos, asegurese que los datos que esta ingresando esten correctos,"
                            + "le quedan " + (intentos-1) + "intentos" ,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
