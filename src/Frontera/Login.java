/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontera;

import Control.ValidarLogin;
import Entidad.Usuario;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author nicro
 */
public class Login extends javax.swing.JFrame {
    public static Usuario user;
    public static Welcome welcome; //Es para mantener el frame de la clase Welcome relativo a la posición del frame de la clase Login
    
    /**
     * Creates new form NewJFrame
     */
    public Login() {
        initComponents();
        this.setTitle("Airline Tickets Application");
        this.setIconImage(new ImageIcon(getClass().getResource("../Imagenes/icono avion.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        usernameTF = new javax.swing.JTextField();
        aceptarB = new javax.swing.JButton();
        regresarB = new javax.swing.JButton();
        passwordTF = new javax.swing.JPasswordField();
        aviso = new javax.swing.JLabel();
        usernameL = new javax.swing.JLabel();
        passwordL = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usernameTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usernameTFKeyTyped(evt);
            }
        });
        panelPrincipal.add(usernameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 280, -1));

        aceptarB.setBackground(new java.awt.Color(0, 0, 0));
        aceptarB.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        aceptarB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botonAceptarRegistro.png"))); // NOI18N
        aceptarB.setText("Ingresar");
        aceptarB.setContentAreaFilled(false);
        aceptarB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        aceptarB.setOpaque(false);
        aceptarB.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botonAceptarRegistroG.png"))); // NOI18N
        aceptarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarBActionPerformed(evt);
            }
        });
        panelPrincipal.add(aceptarB, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 160, 40));

        regresarB.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        regresarB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botonAceptarRegistro.png"))); // NOI18N
        regresarB.setText("Regresar");
        regresarB.setContentAreaFilled(false);
        regresarB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        regresarB.setOpaque(false);
        regresarB.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botonAceptarRegistroG.png"))); // NOI18N
        regresarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarBActionPerformed(evt);
            }
        });
        panelPrincipal.add(regresarB, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 160, 40));

        passwordTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordTFKeyTyped(evt);
            }
        });
        panelPrincipal.add(passwordTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 280, -1));

        aviso.setForeground(java.awt.Color.red);
        panelPrincipal.add(aviso, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 480, 20));

        usernameL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usernameL.setText("Username");
        panelPrincipal.add(usernameL, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        passwordL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passwordL.setText("Contraseña");
        panelPrincipal.add(passwordL, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LoginFormulario.png"))); // NOI18N
        panelPrincipal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 370));

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarBActionPerformed
        // TODO add your handling code here:
        Usuario usuario = new Usuario();
        usuario.setUsername(usernameTF.getText());
        usuario.setPassword(passwordTF.getText());

        ValidarLogin validar = new ValidarLogin();
        
        user = validar.findUsuario(usernameTF.getText());

        System.out.println("-------");
        String resultado = validar.verificarLogin(usuario);
        System.out.println(resultado);
        
        aviso.setForeground(Color.red);

        if(resultado.equals("Datos incorrectos")){
            aviso.setText("Datos incorrectos");
        } else if (resultado.equals("Longitud de username incorrecta")){
            aviso.setText("Longitud de username incorrecta");
        } else if(resultado.equals("Longitud de contraseña incorrecta")){
            aviso.setText("Longitud de contraseña incorrecta");
        } else if(resultado.equals("Contraseña incorrecta. Escríbala nuevamente")){
            aviso.setText("Contraseña incorrecta. Escríbala nuevamente");
        } else {
            welcome = new Welcome();
            welcome.setLocationRelativeTo(this);
            this.setVisible(false);
            welcome.setVisible(true);
        }
    }//GEN-LAST:event_aceptarBActionPerformed

    private void regresarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarBActionPerformed
        // TODO add your handling code here
        FramePrincipal framePrincipal = new FramePrincipal();
        framePrincipal.setLocationRelativeTo(this);
        this.setVisible(false);
        framePrincipal.setVisible(true);
    }//GEN-LAST:event_regresarBActionPerformed

    private void usernameTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameTFKeyTyped
        char c = evt.getKeyChar();
        if(c == KeyEvent.VK_ENTER){
            aceptarB.doClick();
        }
    }//GEN-LAST:event_usernameTFKeyTyped

    private void passwordTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordTFKeyTyped
        char c = evt.getKeyChar();
        if(c == KeyEvent.VK_ENTER){
            aceptarB.doClick();
        }       
    }//GEN-LAST:event_passwordTFKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarB;
    private javax.swing.JLabel aviso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JLabel passwordL;
    private javax.swing.JPasswordField passwordTF;
    private javax.swing.JButton regresarB;
    private javax.swing.JLabel usernameL;
    private javax.swing.JTextField usernameTF;
    // End of variables declaration//GEN-END:variables
}
