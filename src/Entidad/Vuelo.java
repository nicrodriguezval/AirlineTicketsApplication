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
public class Vuelo {
    private String origen, destino, hora, fecha;
    private int sillasTotales, id; 
    private double precioClaseTurista, precioClaseEjecutiva, precioPrimeraClase;
    private boolean sillasDisponibles[];

    public Vuelo(int id, String origen, String destino, String fecha, String hora, double precioClaseTurista, double precioClaseEjecutiva, double precioPrimeraClase) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.hora = hora;
        this.precioClaseTurista = precioClaseTurista;
        this.precioClaseEjecutiva = precioClaseEjecutiva;
        this.precioPrimeraClase = precioPrimeraClase;
        sillasDisponibles = new boolean[sillasTotales];
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
