/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontera;

import DAO.VueloDAO;
import Entidad.Vuelo;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author nicro
 */
public class ReservationIda extends javax.swing.JFrame {
    private VueloDAO vdao = new VueloDAO();
    //public static int idReserva = 0;
    
    private boolean esIdaVuelta, esEquipaje;
    private String lugarOrigen, lugarDestino, fechaSalida, horaSalida, categoria1, peso1;
    private int puestos, peso;
       
    public ReservationIda() {
        initComponents();
        configuracionInicial();
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
        OrigenCB = new javax.swing.JComboBox<>();
        origen = new javax.swing.JLabel();
        destino = new javax.swing.JLabel();
        destinoCB = new javax.swing.JComboBox<>();
        hora = new javax.swing.JLabel();
        horaCB = new javax.swing.JComboBox<>();
        idaVuelta = new javax.swing.JLabel();
        idaVueltaCB = new javax.swing.JCheckBox();
        noPuestos = new javax.swing.JLabel();
        noPuestosCB = new javax.swing.JComboBox<>();
        categoria = new javax.swing.JLabel();
        categoriaCB = new javax.swing.JComboBox<>();
        equipaje = new javax.swing.JLabel();
        equipajeCB = new javax.swing.JCheckBox();
        pesoEquipaje = new javax.swing.JLabel();
        pesoEquipajeCB = new javax.swing.JComboBox<>();
        cancelar = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();
        fecha = new javax.swing.JLabel();
        fechaCB = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPrincipal.setBackground(java.awt.Color.white);

        titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titulo.setText("Realizar reservación");

        OrigenCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bogotá", "Medellin", "Cali", "Barranquilla" }));
        OrigenCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrigenCBActionPerformed(evt);
            }
        });

        origen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        origen.setText("Origen");

        destino.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        destino.setText("Destino");

        destinoCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bogotá", "Medellin", "Cali", "Barranquilla" }));
        destinoCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinoCBActionPerformed(evt);
            }
        });

        hora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        hora.setText("Hora");

        horaCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horaCBActionPerformed(evt);
            }
        });

        idaVuelta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idaVuelta.setText("Ida y vuelta");

        idaVueltaCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idaVueltaCBActionPerformed(evt);
            }
        });

        noPuestos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        noPuestos.setText("No. puestos");

        noPuestosCB.setModel(new javax.swing.DefaultComboBoxModel<>(new Integer[] { 1, 2, 3, 4, 5 }));
        noPuestosCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noPuestosCBActionPerformed(evt);
            }
        });

        categoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        categoria.setText("Categoría");

        categoriaCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Turista", "Ejecutiva", "Primera clase" }));
        categoriaCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriaCBActionPerformed(evt);
            }
        });

        equipaje.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        equipaje.setText("Equipaje");

        equipajeCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipajeCBActionPerformed(evt);
            }
        });

        pesoEquipaje.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pesoEquipaje.setText("Peso del equipaje");

        pesoEquipajeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10-20 Kg", "21-30 Kg", "30-40 Kg", "40-50 Kg" }));
        pesoEquipajeCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesoEquipajeCBActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        siguiente.setText("Siguiente");
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });

        fecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fecha.setText("Fecha");

        fechaCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaCBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(0, 51, Short.MAX_VALUE)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(pesoEquipaje, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pesoEquipajeCB, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(titulo))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addComponent(idaVuelta)
                                .addGap(6, 6, 6)
                                .addComponent(idaVueltaCB)
                                .addGap(51, 51, 51)
                                .addComponent(equipaje))
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addComponent(categoria)
                                .addGap(18, 18, 18)
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(categoriaCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fechaCB, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(6, 6, 6)
                        .addComponent(equipajeCB))
                    .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelPrincipalLayout.createSequentialGroup()
                            .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(origen)
                                .addComponent(fecha))
                            .addGap(36, 36, 36)
                            .addComponent(OrigenCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(noPuestos)
                                .addGroup(panelPrincipalLayout.createSequentialGroup()
                                    .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(destino)
                                        .addComponent(hora))
                                    .addGap(18, 18, 18)
                                    .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(destinoCB, 0, 115, Short.MAX_VALUE)
                                        .addComponent(horaCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGroup(panelPrincipalLayout.createSequentialGroup()
                            .addGap(209, 209, 209)
                            .addComponent(cancelar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(siguiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(noPuestosCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(0, 52, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(titulo)
                .addGap(33, 33, 33)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(origen)
                    .addComponent(OrigenCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(destino)
                    .addComponent(destinoCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hora)
                    .addComponent(horaCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fecha)
                    .addComponent(fechaCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(categoria)
                    .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(categoriaCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(noPuestos)
                        .addComponent(noPuestosCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idaVuelta)
                            .addComponent(idaVueltaCB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pesoEquipaje, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                            .addComponent(pesoEquipajeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(equipaje)
                            .addComponent(equipajeCB))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar)
                    .addComponent(siguiente))
                .addGap(31, 31, 31))
        );

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idaVueltaCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idaVueltaCBActionPerformed
        esIdaVuelta = idaVueltaCB.isSelected();
    }//GEN-LAST:event_idaVueltaCBActionPerformed

    private void equipajeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipajeCBActionPerformed
        esEquipaje = equipajeCB.isSelected();
        
        if(esEquipaje) {
            pesoEquipaje.setVisible(true);
            pesoEquipajeCB.setVisible(true); 
        }
        
        else {
            pesoEquipaje.setVisible(false);
            pesoEquipajeCB.setVisible(false);
        }
    }//GEN-LAST:event_equipajeCBActionPerformed

    private void categoriaCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriaCBActionPerformed
        // TODO add your handling code here:
        categoria1 = categoriaCB.getItemAt(categoriaCB.getSelectedIndex());
    }//GEN-LAST:event_categoriaCBActionPerformed

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
        categoria1 = categoriaCB.getItemAt(categoriaCB.getSelectedIndex());
        esEquipaje = equipajeCB.isSelected();
        lugarOrigen = OrigenCB.getItemAt(OrigenCB.getSelectedIndex());
        lugarDestino = destinoCB.getItemAt(destinoCB.getSelectedIndex());
        fechaSalida = fechaCB.getItemAt(fechaCB.getSelectedIndex());
        horaSalida = horaCB.getItemAt(horaCB.getSelectedIndex());
        puestos = noPuestosCB.getItemAt(noPuestosCB.getSelectedIndex());
        
        if(esEquipaje){
            peso1 = pesoEquipajeCB.getItemAt(pesoEquipajeCB.getSelectedIndex());
            peso = pesoEquipajeCB.getSelectedIndex() + 1;
        }
        
        else {
            peso1 = "Ninguno";
            peso = 0;
        }
        
        this.setVisible(false);
        
        if(esIdaVuelta) {
            reservationVuelta reservacion = new reservationVuelta(esEquipaje, lugarOrigen, lugarDestino, fechaSalida, horaSalida, categoria1, peso1, puestos, peso);
            reservacion.setLocationRelativeTo(this);
            reservacion.setVisible(true);
        }
        
        else {
            Vuelo vuelo = null;
            
            if(vdao.leer(lugarOrigen, lugarDestino, fechaSalida, horaSalida) != null){
                vuelo = vdao.leer(lugarOrigen, lugarDestino, fechaSalida, horaSalida);
            }

            ReservationResumen rResumen = new ReservationResumen(vuelo, puestos, categoria1, esEquipaje, peso, peso1, false);
            rResumen.setLocationRelativeTo(this);
            rResumen.setVisible(true);
            rResumen.setAlwaysOnTop( true );
        }
    }//GEN-LAST:event_siguienteActionPerformed

    private void pesoEquipajeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesoEquipajeCBActionPerformed
        // TODO add your handling code here:
        peso1 = pesoEquipajeCB.getItemAt(pesoEquipajeCB.getSelectedIndex());
        peso = pesoEquipajeCB.getSelectedIndex() + 1;
    }//GEN-LAST:event_pesoEquipajeCBActionPerformed

    private void OrigenCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrigenCBActionPerformed
        // TODO add your handling code here:
        int count = 0;
        lugarOrigen = OrigenCB.getItemAt(OrigenCB.getSelectedIndex());
        ArrayList<String> al = new ArrayList<>();
        String query = "v.origen LIKE "+"'"+lugarOrigen+"'";
        for(Vuelo v : vdao.leerquerytolist(query)){
                count++;
                al.add(v.getDestino());
            }
        
        String ciudadesDestino[] = new String[(count + 1)];
        ciudadesDestino[0] = "Ninguno";
        
        for(int i = 0; i < count; i++)
            ciudadesDestino[(i + 1)] = al.get(i);
        
        destinoCB.setModel(new javax.swing.DefaultComboBoxModel<>(ciudadesDestino));
    }//GEN-LAST:event_OrigenCBActionPerformed

    private void destinoCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinoCBActionPerformed
        // TODO add your handling code here:
        lugarDestino = destinoCB.getItemAt(destinoCB.getSelectedIndex());
        ArrayList<String> al = new ArrayList<>();
        int count = 0;
        String query = "v.origen LIKE '" + lugarOrigen + "' AND v.destino LIKE '" + lugarDestino + "'";
        
        for(Vuelo v : vdao.leerquerytolist(query)){
            count++;
            System.out.println("");
            al.add(v.getFecha());
        } 
        
        String fechasSalida[] = new String[(count + 1)];
        fechasSalida[0] = "Ninguna";
        
        for(int i = 0; i < count; i++)
            fechasSalida[(i + 1)] = al.get(i);
        
        fechaCB.setModel(new javax.swing.DefaultComboBoxModel<>(fechasSalida));
    }//GEN-LAST:event_destinoCBActionPerformed

    private void noPuestosCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noPuestosCBActionPerformed
        // TODO add your handling code here:
        puestos = noPuestosCB.getItemAt(noPuestosCB.getSelectedIndex());
    }//GEN-LAST:event_noPuestosCBActionPerformed

    private void horaCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horaCBActionPerformed
        // TODO add your handling code here:
        horaSalida = horaCB.getItemAt(horaCB.getSelectedIndex());
    }//GEN-LAST:event_horaCBActionPerformed

    private void fechaCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaCBActionPerformed
        // TODO add your handling code here:
        fechaSalida = fechaCB.getItemAt(fechaCB.getSelectedIndex());
        ArrayList<String> al = new ArrayList<>();
        int count = 0;
        String query = "v.origen LIKE '" + lugarOrigen + "' AND v.destino LIKE '" + lugarDestino + "' AND v.fecha LIKE '" + fechaSalida + "'";
        for(Vuelo v : vdao.leerquerytolist(query)){
                count++;
                System.out.println("");
                al.add(v.getHora());
            }   
        String horasSalida[] = new String[(count + 1)];
        horasSalida[0] = "Ninguna";
        
        for(int i = 0; i < count; i++)
            horasSalida[(i + 1)] = al.get(i);
        
        horaCB.setModel(new javax.swing.DefaultComboBoxModel<>(horasSalida));
    }//GEN-LAST:event_fechaCBActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        MenuInicial menu = new MenuInicial();
        menu.setLocationRelativeTo(this);
        menu.setVisible(true);
        menu.setAlwaysOnTop( true );
    }//GEN-LAST:event_cancelarActionPerformed

    private void configuracionInicial() {
        pesoEquipaje.setVisible(false);
        pesoEquipajeCB.setVisible(false);

        int x = vdao.leeralltolist().size();
        String ciudadesOrigen[] = new String[(x + 1)];
        ciudadesOrigen[0] = "Ninguno";
        
        int i = 1;
        for(Vuelo v : vdao.leeralltolist()){
            ciudadesOrigen[i] = v.getOrigen();
            i++;
        }
        
        OrigenCB.setModel(new javax.swing.DefaultComboBoxModel<>(ciudadesOrigen));
        destinoCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Ninguno"}));
        fechaCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Ninguna"}));
        horaCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Ninguna"}));
        pesoEquipajeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"10-20 Kg", "21-30 Kg", "30-40 Kg", "40-50 Kg"}));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> OrigenCB;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel categoria;
    private javax.swing.JComboBox<String> categoriaCB;
    private javax.swing.JLabel destino;
    private javax.swing.JComboBox<String> destinoCB;
    private javax.swing.JLabel equipaje;
    private javax.swing.JCheckBox equipajeCB;
    private javax.swing.JLabel fecha;
    private javax.swing.JComboBox<String> fechaCB;
    private javax.swing.JLabel hora;
    private javax.swing.JComboBox<String> horaCB;
    private javax.swing.JLabel idaVuelta;
    private javax.swing.JCheckBox idaVueltaCB;
    private javax.swing.JLabel noPuestos;
    private javax.swing.JComboBox<Integer> noPuestosCB;
    private javax.swing.JLabel origen;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JLabel pesoEquipaje;
    public javax.swing.JComboBox<String> pesoEquipajeCB;
    private javax.swing.JButton siguiente;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
