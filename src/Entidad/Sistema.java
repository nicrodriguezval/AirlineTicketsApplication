/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.util.ArrayList;



/**
 *
 * @author nicro
 */


public class Sistema{
    private ArrayList<Usuario> usuarios;
    private ArrayList<Vuelo> vuelos;
    private ArrayList<Reserva> reservas;
    private ArrayList<CreditCard> tarjetas;
    private ArrayList<Ticket> tickets;

    
    public Sistema() {
        usuarios = new ArrayList<>();
        vuelos = new ArrayList<>();
        reservas = new ArrayList<>();
        tarjetas = new ArrayList<>();
        tickets = new ArrayList<>();
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public void addUsuarios(Usuario usuario) {
        usuarios.add(usuario);
    }

    public ArrayList<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(ArrayList<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }
    
    public void addVuelos(Vuelo vuelo) {
        vuelos.add(vuelo);
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }
    
    public void addReservas(Reserva reserva) {
        reservas.add(reserva);
    }
    
    public ArrayList<CreditCard> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(ArrayList<CreditCard> tarjeta) {
        this.tarjetas = tarjeta;
    }
    
    public void addTarjetas(CreditCard tarjeta) {
        tarjetas.add(tarjeta);
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }
    
    public void addTickets(Ticket ticket) {
        tickets.add(ticket);
    }
}
