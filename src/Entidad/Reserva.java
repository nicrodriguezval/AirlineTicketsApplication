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
public class Reserva {
    private String hora, origen, destino, silla;
    private boolean equipaje, idaVuelta;
    private int peso;
    double precio, iva; /*Si se afora equipaje, el peso del equipaje estará dado en kilogramos.
                                                            El precio es el precio inicial de la reserva,
                                                            cuando el se pague la reserva se genera el tiquete y se asigna el mismo precio del la reserva al ticket, 
                                                            el precio está dado en USD para más comodidad con la cantidad de dígitos*/
    private Usuario usuario;

    public Reserva(String hora, String origen, String destino, String silla, boolean idaVuelta, boolean equipaje, Usuario usuario) {
        this.hora = hora;
        this.origen = origen;
        this.destino = destino;
        this.silla = silla;
        this.equipaje = equipaje;
        this.idaVuelta = idaVuelta;
        this.usuario = usuario;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getSilla() {
        return silla;
    }

    public void setSilla(String silla) {
        this.silla = silla;
    }

    public boolean isEquipaje() {
        return equipaje;
    }

    public void setEquipaje(boolean equipaje) {
        this.equipaje = equipaje;
    }

    public boolean isIdaVuelta() {
        return idaVuelta;
    }

    public void setIdaVuelta(boolean idaVuelta) {
        this.idaVuelta = idaVuelta;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }
}
