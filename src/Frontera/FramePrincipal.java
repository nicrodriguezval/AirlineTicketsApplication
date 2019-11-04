/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontera;

import Entidad.CreditCard;
import Entidad.Sistema;
import Entidad.Usuario;

/**
 *
 * @author nicro
 * icon: <div>Icons made by <a href="https://www.flaticon.es/autores/popcorns-arts" title="Icon Pond">Icon Pond</a> from <a href="https://www.flaticon.es/"
 * title="Flaticon">www.flaticon.com</a></div>
 */
public class FramePrincipal extends javax.swing.JFrame {
    Join registro = new Join();
    Login ingreso = new Login();
    
    public static Sistema sistema = new Sistema();
    
    /**
     * Creates new form FramePrincipal
     */
    public FramePrincipal() {
        initComponents();
        inicializacion();
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
        jPanel1 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        ingresarB = new javax.swing.JButton();
        registrarseB = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 430));

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setLayout(new javax.swing.OverlayLayout(panelPrincipal));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        titulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titulo.setText("Airline tickets application");

        ingresarB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ingresarB.setText("Ingresar");
        ingresarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarBActionPerformed(evt);
            }
        });

        registrarseB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        registrarseB.setText("Registrarse");
        registrarseB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarseBActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono avion.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(titulo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ingresarB, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(registrarseB, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(titulo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1)))
                .addGap(41, 41, 41)
                .addComponent(ingresarB)
                .addGap(30, 30, 30)
                .addComponent(registrarseB)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        panelPrincipal.add(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registrarseBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarseBActionPerformed
        // TODO add your handling code here:
        panelPrincipal.setVisible(false);
        panelPrincipal.removeAll();
        panelPrincipal.add(registro);
        panelPrincipal.setVisible(true);    
    }//GEN-LAST:event_registrarseBActionPerformed

    private void ingresarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarBActionPerformed
        // TODO add your handling code here:
        panelPrincipal.setVisible(false);
        panelPrincipal.removeAll();
        panelPrincipal.add(ingreso);
        panelPrincipal.setVisible(true);
    }//GEN-LAST:event_ingresarBActionPerformed

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
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePrincipal().setVisible(true);
                
            }
        });
    }
    
    public void inicializacion() {
        Usuario a = new Usuario();
        Usuario b = new Usuario();
        Usuario c = new Usuario();
        
        a.setNombre("Nicolás");
        a.setApellido("Rodríguez");
        a.setEmail("nicrodriguezval@unal.edu.co");
        a.setUsername("nicrodriguezval");
        a.setPassword("123123");
        
        b.setNombre("Guillermo");
        b.setApellido("Pérez");
        b.setEmail("guillermo@gmail.com");
        b.setUsername("gillermoP");
        b.setPassword("1212");
        
        c.setNombre("Juan");
        c.setApellido("Tovar");
        c.setEmail("juancho@hotmail.com");
        c.setUsername("juancho01");
        c.setPassword("a1b2c3");
        
        sistema.addUsuarios(a);
        sistema.addUsuarios(b);
        sistema.addUsuarios(c);
        
        System.out.println("USUARIOS EXISTENTES");
        System.out.println();
        
        for(Usuario u : sistema.getUsuarios()) {
            System.out.println("Nombre(s): " + u.getNombre());
            System.out.println("Apellido(s): " + u.getApellido());
            System.out.println("Username: " + u.getUsername());
            System.out.println("-------");
        }
        
        CreditCard t1 = new CreditCard();
        CreditCard t2 = new CreditCard();
        CreditCard t3 = new CreditCard();
        
        t1.setNombreBanco("Bancolombia");
        t1.setFechaCaducidad("10/10/2020");
        t1.setNumeroTarjeta("656412345874569");
        t1.setMarcaInternacional("VISA");
        t1.setNombreTitular("Nicolás Rodríguez");
        
        t2.setNombreBanco("AV Villas");
        t2.setFechaCaducidad("2/1/2021");
        t2.setNumeroTarjeta("1234567891234567");
        t2.setMarcaInternacional("MASTERCARD");
        t2.setNombreTitular("Juan Alberto");
        
        t3.setNombreBanco("Banco Popular");
        t3.setFechaCaducidad("1/11/2019");
        t3.setNumeroTarjeta("4545457878121223");
        t3.setMarcaInternacional("VISA");
        t3.setNombreTitular("José Miguel");
        
        sistema.addTarjetas(t1);
        sistema.addTarjetas(t2);
        sistema.addTarjetas(t3);
        
        System.out.println("TARJETAS DE CRÉDITO EXISTENTES");
        System.out.println();
        
        for(CreditCard t : sistema.getTarjetas()) {
            System.out.println("Nombre del banco: " + t.getNombreBanco());
            System.out.println("Nombre del titular: " + t.getNombreTitular());
            System.out.println("Numero de la tarjeta: " + t.getNumeroTarjeta());
            System.out.println("Marca internacional: " + t.getMarcaInternacional());
            System.out.println("Fecha de caducidad: " + t.getFechaCaducidad());
            System.out.println("-------");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ingresarB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JButton registrarseB;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
