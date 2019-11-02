/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author nicro
 */
public class Ticket {
    Reserva reserva;
    Usuario usuario;
    double precio, iva;
    String origen, destino;

    public Ticket(Reserva reserva) {
        this.reserva = reserva;
        usuario = reserva.getUsuario();
        precio = reserva.getPrecio();
        iva = reserva.getIva();
    }
}
