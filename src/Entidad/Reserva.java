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
    private int id;
    private Vuelo vueloIda, vueloVuelta;
    private boolean equipaje, idaVuelta;
    private String categoria;
    private int peso, numeroPuestos;
    double precio, iva; /*Si se afora equipaje, el peso del equipaje estará dado en kilogramos.
                                                            El precio es el precio inicial de la reserva,
                                                            cuando el se pague la reserva se genera el tiquete y se asigna el mismo precio del la reserva al ticket, 
                                                            el precio está dado en USD para más comodidad con la cantidad de dígitos*/
    private Usuario usuario;
    
    private boolean equipajeVuelta;
    private String categoriaVuelta;
    private int pesoVuelta, numeroPuestosVuelta;

    public Reserva(int id, Vuelo vueloIda, int numeroPuestos, boolean idaVuelta, boolean equipaje, String categoria, Usuario usuario) {
        this.id = id;
        this.vueloIda = vueloIda;
        this.equipaje = equipaje;
        this.idaVuelta = idaVuelta;
        this.categoria = categoria;
        this.usuario = usuario;
        this.numeroPuestos = numeroPuestos;
    }

    public Vuelo getVueloIda() {
        return vueloIda;
    }

    public void setVueloIda(Vuelo vueloIda) {
        this.vueloIda = vueloIda;
    }

    public Vuelo getVueloVuelta() {
        return vueloVuelta;
    }

    public void setVueloVuelta(Vuelo vueloVuelta) {
        this.vueloVuelta = vueloVuelta;
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

    public boolean isEquipajeVuelta() {
        return equipajeVuelta;
    }

    public void setEquipajeVuelta(boolean equipajeVuelta) {
        this.equipajeVuelta = equipajeVuelta;
    }

    public String getCategoriaVuelta() {
        return categoriaVuelta;
    }

    public void setCategoriaVuelta(String categoriaVuelta) {
        this.categoriaVuelta = categoriaVuelta;
    }

    public int getPesoVuelta() {
        return pesoVuelta;
    }

    public void setPesoVuelta(int pesoVuelta) {
        this.pesoVuelta = pesoVuelta;
    }

    public int getNumeroPuestosVuelta() {
        return numeroPuestosVuelta;
    }

    public void setNumeroPuestosvuelta(int numeroPuestosVuelta) {
        this.numeroPuestosVuelta = numeroPuestosVuelta;
    }
}
