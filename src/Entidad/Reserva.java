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
    private Vuelo vuelo;
    private boolean equipaje, idaVuelta;
    private String categoria;
    private int peso, numeroPuestos;
    double precio, iva; /*Si se afora equipaje, el peso del equipaje estará dado en kilogramos.
                                                            El precio es el precio inicial de la reserva,
                                                            cuando el se pague la reserva se genera el tiquete y se asigna el mismo precio del la reserva al ticket, 
                                                            el precio está dado en USD para más comodidad con la cantidad de dígitos*/
    private Usuario usuario;

    public Reserva(Vuelo vuelo, int numeroPuestos, boolean idaVuelta, boolean equipaje, String categoria, Usuario usuario) {
        this.vuelo = vuelo;
        this.equipaje = equipaje;
        this.idaVuelta = idaVuelta;
        this.categoria = categoria;
        this.usuario = usuario;
        this.numeroPuestos = numeroPuestos;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public int getNumeroPuestos() {
        return numeroPuestos;
    }

    public void setNumeroPuestos(int numeroPuestos) {
        this.numeroPuestos = numeroPuestos;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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
