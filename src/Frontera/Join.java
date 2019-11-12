/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontera;

import Control.ValidarJoin;
import DAO.UsuarioDAO;
import Entidad.Usuario;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author nicro
 */
public class Join extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public Join() {
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
        titulo = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        apellido = new javax.swing.JLabel();
        aceptar = new javax.swing.JButton();
        regresar = new javax.swing.JButton();
        nombreTF = new javax.swing.JTextField();
        apellidoTF = new javax.swing.JTextField();
        email = new javax.swing.JLabel();
        emailTF = new javax.swing.JTextField();
        username = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        verificarPassword = new javax.swing.JLabel();
        usernameTF = new javax.swing.JTextField();
        passwordTF = new javax.swing.JPasswordField();
        verificarPasswordTF = new javax.swing.JPasswordField();
        aviso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(550, 480));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setPreferredSize(new java.awt.Dimension(550, 600));

        titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titulo.setText("Registrarse");

        nombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nombre.setText("Nombres");

        apellido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        apellido.setText("Apellidos");

        aceptar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        regresar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        email.setText("Email");

        username.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        username.setText("Username");

        password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        password.setText("Contraseña");

        verificarPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        verificarPassword.setText("Verificar contraseña");

        aviso.setForeground(new java.awt.Color(255, 0, 0));
        aviso.setEnabled(false);

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(verificarPasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panelPrincipalLayout.createSequentialGroup()
                            .addComponent(regresar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(aviso, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(usernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nombreTF, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(apellidoTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                            .addComponent(emailTF, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addComponent(passwordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelPrincipalLayout.createSequentialGroup()
                    .addGap(0, 52, Short.MAX_VALUE)
                    .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelPrincipalLayout.createSequentialGroup()
                            .addGap(169, 169, 169)
                            .addComponent(titulo))
                        .addGroup(panelPrincipalLayout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(nombre))
                        .addGroup(panelPrincipalLayout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(apellido))
                        .addComponent(password)
                        .addGroup(panelPrincipalLayout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(verificarPassword))
                        .addGroup(panelPrincipalLayout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(username)
                                .addComponent(email))))
                    .addGap(0, 211, Short.MAX_VALUE)))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(nombreTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(apellidoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(usernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwordTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(verificarPasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(aviso, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regresar)
                    .addComponent(aceptar))
                .addGap(45, 45, 45))
            .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelPrincipalLayout.createSequentialGroup()
                    .addGap(0, 40, Short.MAX_VALUE)
                    .addComponent(titulo)
                    .addGap(32, 32, 32)
                    .addComponent(nombre)
                    .addGap(29, 29, 29)
                    .addComponent(apellido)
                    .addGap(26, 26, 26)
                    .addComponent(email)
                    .addGap(26, 26, 26)
                    .addComponent(username)
                    .addGap(29, 29, 29)
                    .addComponent(password)
                    .addGap(32, 32, 32)
                    .addComponent(verificarPassword)
                    .addGap(0, 116, Short.MAX_VALUE)))
        );

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        // TODO add your handling code here:
        Usuario usuario = new Usuario();
        UsuarioDAO udao = new UsuarioDAO();
        
        String nombre = nombreTF.getText(), apellido = apellidoTF.getText(), email = emailTF.getText(),
        username = usernameTF.getText(), password = passwordTF.getText();

        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setEmail(email);
        usuario.setUsername(username);
        usuario.setPassword(password);
        String verificarPassword = verificarPasswordTF.getText();

        ValidarJoin verificar = new ValidarJoin();

        String respuesta = verificar.verificarJoin(usuario, verificarPassword);
        
        aviso.setForeground(Color.red);
        
        if(respuesta.equals("Longitud de nombre incorrecta")) 
            aviso.setText("Longitud de nombre incorrecta");
        
        else if(respuesta.equals("Longitud de apellido incorrecta")) 
            aviso.setText("Longitud de apellido incorrecta");
        
        else if(respuesta.equals("Longitud de email incorrecto"))
            aviso.setText("Longitud de email incorrecto");

        else if(respuesta.equals("Email inválido"))
            aviso.setText("Email inválido");

        else if(respuesta.equals("Longitud de username incorrecta"))
            aviso.setText("Longitud de username incorrecta");

        else if(respuesta.equals("El primer caracter del username no puede ser un número"))
            aviso.setText("El primer caracter del username no puede ser un número");

        else if(respuesta.equals("El username ya existe"))
            aviso.setText("El username ya existe");

        else if(respuesta.equals("El email ya existe"))
            aviso.setText("El email ya está registrado");
        
        else if(respuesta.equals("Longitud de contraseña incorrecta"))
            aviso.setText("Longitud de contraseña incorrecta");
         
        else if(respuesta.equals("Las contraseñas no coinciden"))
            aviso.setText("Las contraseñas no coinciden");
        
        else {
            aviso.setText("Registro exitoso");
            //sistema.addUsuarios(usuario);
            System.out.println("-------");
            System.out.println("NUEVO USUARIO AÑADIDO");
            System.out.println("Nombre: " + nombre);
            System.out.println("Apellido: " + apellido);
            System.out.println("Email: " + email);
            System.out.println("Username: " + username);
            udao.crear(usuario);
        }

        System.out.println("-------");
        System.out.println(respuesta);
    }//GEN-LAST:event_aceptarActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        // TODO add your handling code here:
        FramePrincipal framePrincipal = new FramePrincipal();
        this.setVisible(false);
        framePrincipal.setLocationRelativeTo(this);
        framePrincipal.setVisible(true);
    }//GEN-LAST:event_regresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JLabel apellido;
    private javax.swing.JTextField apellidoTF;
    private javax.swing.JLabel aviso;
    private javax.swing.JLabel email;
    private javax.swing.JTextField emailTF;
    private javax.swing.JLabel nombre;
    private javax.swing.JTextField nombreTF;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JLabel password;
    private javax.swing.JPasswordField passwordTF;
    private javax.swing.JButton regresar;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel username;
    private javax.swing.JTextField usernameTF;
    private javax.swing.JLabel verificarPassword;
    private javax.swing.JPasswordField verificarPasswordTF;
    // End of variables declaration//GEN-END:variables
}
