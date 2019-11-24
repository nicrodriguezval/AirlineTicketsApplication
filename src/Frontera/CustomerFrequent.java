/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontera;

import Control.ValidarLogin;
import Control.ValidarPagoPuntos;
import Control.ValidarPagoTarjeta;
import DAO.ReservaDAO;
import DAO.TicketDAO;
import DAO.UsuarioDAO;
import Entidad.Reserva;
import Entidad.Ticket;
import static Frontera.Login.user;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author SPECTRE
 */
public class CustomerFrequent extends javax.swing.JFrame {

    private Reserva reserva;
    private ReservaDAO rdao;
    private int costo;
    private boolean redimir;

    /**
     * Creates new form CustomerFrequent
     */
    public CustomerFrequent() {
        initComponents();
        this.setTitle("Airline Tickets Application");
        this.setIconImage(new ImageIcon(getClass().getResource("../Imagenes/icono avion.png")).getImage());
        inicializacion();
        visivilidadRedimirPuntos(false);
        visivilidadInfoReserva(false);
        rdao = new ReservaDAO();
        redimir = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tituloL = new javax.swing.JLabel();
        puntosL = new javax.swing.JLabel();
        puntosUsuarioL = new javax.swing.JLabel();
        nombreL = new javax.swing.JLabel();
        nombreUserL = new javax.swing.JLabel();
        idReservacionL = new javax.swing.JLabel();
        idReservacionTF = new javax.swing.JTextField();
        aceptarB = new javax.swing.JButton();
        redimirPuntosB = new javax.swing.JButton();
        volverB = new javax.swing.JButton();
        informacionB = new javax.swing.JButton();
        infoReserva = new javax.swing.JLabel();
        avisoL = new javax.swing.JLabel();
        costoL = new javax.swing.JLabel();
        costoReservaL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloL.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tituloL.setText("Programa Cliente Frecuente");
        jPanel1.add(tituloL, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        puntosL.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        puntosL.setText("Puntos");
        jPanel1.add(puntosL, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        puntosUsuarioL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        puntosUsuarioL.setText("jLabel3");
        jPanel1.add(puntosUsuarioL, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 220, -1));

        nombreL.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nombreL.setText("Nombre");
        jPanel1.add(nombreL, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 60, -1));

        nombreUserL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nombreUserL.setText("jLabel3");
        jPanel1.add(nombreUserL, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 70, 220, -1));

        idReservacionL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idReservacionL.setText("ID reservación");
        jPanel1.add(idReservacionL, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        idReservacionTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idReservacionTFActionPerformed(evt);
            }
        });
        idReservacionTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idReservacionTFKeyTyped(evt);
            }
        });
        jPanel1.add(idReservacionTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 170, -1));

        aceptarB.setText("Aceptar");
        aceptarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarBActionPerformed(evt);
            }
        });
        jPanel1.add(aceptarB, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, -1, -1));

        redimirPuntosB.setText("Redimir puntos");
        jPanel1.add(redimirPuntosB, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        volverB.setText("Volver");
        jPanel1.add(volverB, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        informacionB.setText("Información puntos");
        informacionB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                informacionBActionPerformed(evt);
            }
        });
        jPanel1.add(informacionB, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, -1, -1));

        infoReserva.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoReserva.setText("Jlabel");
        jPanel1.add(infoReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        avisoL.setForeground(java.awt.Color.red);
        jPanel1.add(avisoL, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 290, 20));

        costoL.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        costoL.setText("Costo");
        jPanel1.add(costoL, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        costoReservaL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        costoReservaL.setText("jLabel1");
        jPanel1.add(costoReservaL, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 170, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idReservacionTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idReservacionTFActionPerformed
        // TODO add your handling code here:
        ValidarPagoTarjeta validar = new ValidarPagoTarjeta();

        String id = idReservacionTF.getText();

        if (id.length() != 0) {
            if (validar.verificarReserva(Integer.parseInt(id))) {
                reserva = rdao.leerReserva(Integer.parseInt(id));

                if (reserva.getUsuario().getUsername().equals(user.getUsername())) {
                    if (!reserva.isPagada()) {
                        if (reserva.isIdaVuelta()) {
                            infoReserva.setText(reserva.getVueloIda().getOrigen() + '-' + reserva.getVueloIda().getDestino() + ", "
                                    + reserva.getVueloVuelta().getOrigen() + '-' + reserva.getVueloVuelta().getDestino());
                        } else {
                            infoReserva.setText(reserva.getVueloIda().getOrigen() + '-' + reserva.getVueloIda().getDestino());
                        }

                        costo = (int) (reserva.getPrecio() + reserva.getIva());
                        costoReservaL.setText(costo + " puntos");
                        visivilidadInfoReserva(true);
                        redimir = true;
                    } else {
                        avisoL.setText("La reservación ya fue pagada");
                    }
                } else {
                    avisoL.setText("La reservación no es del usuario activo");
                }
            } else {
                avisoL.setText("La reservación no existe");
            }
        } else {
            avisoL.setText("Ingrese una reservación");
        }
    }//GEN-LAST:event_idReservacionTFActionPerformed

    private void informacionBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informacionBActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "1. Los puntos se calculan teniendo en cuenta las millas por cada vuelo que realiza."
                + "\n2. Cada punto equivale al 4% de las millas voladas en cada viaje."
                + "\n3. Un punto equivale a un USD.", "Información Puntos", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_informacionBActionPerformed

    private void aceptarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarBActionPerformed
        // TODO add your handling code here:
        if (!redimir) {
            ValidarPagoTarjeta validar = new ValidarPagoTarjeta();

            String id = idReservacionTF.getText();

            if (id.length() != 0) {
                if (validar.verificarReserva(Integer.parseInt(id))) {
                    reserva = rdao.leerReserva(Integer.parseInt(id));

                    if (reserva.getUsuario().getUsername().equals(user.getUsername())) {
                        if (!reserva.isPagada()) {
                            if (reserva.isIdaVuelta()) {
                                infoReserva.setText(reserva.getVueloIda().getOrigen() + '-' + reserva.getVueloIda().getDestino() + ", "
                                        + reserva.getVueloVuelta().getOrigen() + '-' + reserva.getVueloVuelta().getDestino());
                            } else {
                                infoReserva.setText(reserva.getVueloIda().getOrigen() + '-' + reserva.getVueloIda().getDestino());
                            }

                            costo = (int) (reserva.getPrecio() + reserva.getIva());
                            costoReservaL.setText(costo + " puntos");
                            visivilidadInfoReserva(true);
                            redimir = true;
                        } else {
                            avisoL.setText("La reservación ya fue pagada");
                        }
                    } else {
                        avisoL.setText("La reservación no es del usuario activo");
                    }
                } else {
                    avisoL.setText("La reservación no existe");
                }
            } else {
                avisoL.setText("Ingrese una reservación");
            }
        } else {
            ValidarPagoPuntos validar = new ValidarPagoPuntos();
            String resultado = validar.verificarPagoPuntos(user, reserva);
            
            if(resultado.equals("Los puntos no son suficientes")) {
                avisoL.setText(resultado);
            } else {
                TicketDAO tckdao = new TicketDAO();
                rdao.actualizaPago(reserva, true);
                Ticket ticketPagado = new Ticket(reserva);

                tckdao.crear(ticketPagado);
                
                //actualizar los puntos del usuario al redimir los puntos
                UsuarioDAO udao = new UsuarioDAO();
                ValidarLogin validarL = new ValidarLogin();
                int puntos = user.getPoints() - costo;
                udao.actualizaPuntos(user, puntos);
                user = validarL.findUsuario(user.getUsername());

                this.setVisible(false);
                MenuInicial menu = new MenuInicial();
                menu.setVisible(true);
                menu.setLocationRelativeTo(this);
                menu.setVisible(true);
                menu.setAlwaysOnTop(true);
            }
        }
    }//GEN-LAST:event_aceptarBActionPerformed

    private void idReservacionTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idReservacionTFKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if (c < '0' || c > '9') //Sólo se puede escribir números
        {
            evt.consume();
        }
    }//GEN-LAST:event_idReservacionTFKeyTyped

    private void redimirPuntosBActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        visivilidadRedimirPuntos(true);
    }

    private void volverBActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        MenuInicial menu = new MenuInicial();
        menu.setLocationRelativeTo(this);
        menu.setVisible(true);
        menu.setAlwaysOnTop(true);
    }

    private void inicializacion() {
        redimirPuntosB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redimirPuntosBActionPerformed(evt);
            }
        });

        volverB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBActionPerformed(evt);
            }
        });

        puntosUsuarioL.setText(("" + user.getPoints()));
        nombreUserL.setText((user.getNombre() + " " + user.getApellido()));
    }

    private void visivilidadRedimirPuntos(boolean actived) {
        idReservacionL.setVisible(actived);
        idReservacionTF.setVisible(actived);
        aceptarB.setVisible(actived);
    }

    private void visivilidadInfoReserva(boolean actived) {
        infoReserva.setVisible(actived);
        costoL.setVisible(actived);
        costoReservaL.setVisible(actived);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarB;
    private javax.swing.JLabel avisoL;
    private javax.swing.JLabel costoL;
    private javax.swing.JLabel costoReservaL;
    private javax.swing.JLabel idReservacionL;
    private javax.swing.JTextField idReservacionTF;
    private javax.swing.JLabel infoReserva;
    private javax.swing.JButton informacionB;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nombreL;
    private javax.swing.JLabel nombreUserL;
    private javax.swing.JLabel puntosL;
    private javax.swing.JLabel puntosUsuarioL;
    private javax.swing.JButton redimirPuntosB;
    private javax.swing.JLabel tituloL;
    private javax.swing.JButton volverB;
    // End of variables declaration//GEN-END:variables
}
