/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.io.Serializable;
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
@Table(name="vuelos")
public class Vuelo implements Serializable{
    private String origen, destino, hora, fecha;
    private int sillasTotales; 
    private double precioClaseTurista, precioClaseEjecutiva, precioPrimeraClase;
    private boolean sillasDisponibles[];
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Vuelo(){ //NECESARIO PARA HACER PERSITENCIA!
        
    }

    public Vuelo(/*int id,*/ String origen, String destino, String fecha, String hora, double precioClaseTurista, double precioClaseEjecutiva, double precioPrimeraClase, int sillasTotales) {
        //this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.hora = hora;
        this.precioClaseTurista = precioClaseTurista;
        this.precioClaseEjecutiva = precioClaseEjecutiva;
        this.precioPrimeraClase = precioPrimeraClase;
        this.sillasTotales = sillasTotales;
        sillasDisponibles = new boolean[sillasTotales];
        
        for(int i = 0; i < sillasDisponibles.length; i++)
            sillasDisponibles[i] = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getSillasTotales() {
        return sillasTotales;
    }

    public void setSillasTotales(int sillasTotales) {
        this.sillasTotales = sillasTotales;
    }

    public boolean[] getSillasDisponibles() {
        return sillasDisponibles;
    }

    public void setSillasDisponibles(boolean[] sillasDisponibles) {
        this.sillasDisponibles = sillasDisponibles;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getPrecioClaseTurista() {
        return precioClaseTurista;
    }

    public void setPrecioClaseTurista(double precioClaseTurista) {
        this.precioClaseTurista = precioClaseTurista;
    }

    public double getPrecioClaseEjecutiva() {
        return precioClaseEjecutiva;
    }

    public void setPrecioClaseEjecutiva(double precioClaseEjecutiva) {
        this.precioClaseEjecutiva = precioClaseEjecutiva;
    }

    public double getPrecioPrimeraClase() {
        return precioPrimeraClase;
    }

    public void setPrecioPrimeraClase(double precioPrimeraClase) {
        this.precioPrimeraClase = precioPrimeraClase;
    }
    
    
 }
