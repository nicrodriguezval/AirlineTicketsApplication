/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author nicro
 */
@Entity
@Table(name = "reservas")
public class Reserva {

    private Vuelo vueloIda, vueloVuelta;
    private boolean equipaje, idaVuelta, pagada;
    private String categoria;
    private int peso, numeroPuestos;
    double precio, iva;
    /*Si se afora equipaje, el peso del equipaje estará dado en kilogramos.
                                                            El precio es el precio inicial de la reserva,
                                                            cuando el se pague la reserva se genera el tiquete y se asigna el mismo precio del la reserva al ticket, 
                                                            el precio está dado en USD para más comodidad con la cantidad de dígitos*/
    private Usuario usuario;

    private boolean equipajeVuelta;
    private String categoriaVuelta;
    private int pesoVuelta, numeroPuestosVuelta;
    private int puestosIda[], puestosVuelta[];

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //ALTER TABLE reservas AUTO_INCREMENT = 0 para resetear
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Reserva() { //NECESARIO PARA HACER PERSISTENCIA!
    }

    public Reserva(/*int id,*/Vuelo vueloIda, int numeroPuestos, boolean idaVuelta, boolean equipaje, int peso, String categoria, Usuario usuario) {
        //this.id = id;
        this.vueloIda = vueloIda;
        this.equipaje = equipaje;
        this.idaVuelta = idaVuelta;
        this.peso = peso;
        this.categoria = categoria;
        this.usuario = usuario;
        this.numeroPuestos = numeroPuestos;
        puestosIda = new int[numeroPuestos];
        puestosIda = new int[numeroPuestosVuelta];
        pagada = false;
    }

    public int[] getPuestosIda() {
        return puestosIda;
    }

    public void setPuestosIda(int[] puestosIda) {
        this.puestosIda = puestosIda;
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

    public int[] getPuestosVuelta() {
        return puestosVuelta;
    }

    public void setPuestosVuelta(int[] puestosVuelta) {
        this.puestosVuelta = puestosVuelta;
    }

    public boolean isPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }
}
