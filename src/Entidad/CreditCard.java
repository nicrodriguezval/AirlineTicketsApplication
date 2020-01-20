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
@Table(name = "tarjetas")
public class CreditCard implements Serializable {

    private String nombreBanco, mesExpiracion, añoExpiracion, nombreTitular, MarcaInternacional, numeroTarjeta, numeroSeguridad;
    private double cupoGastado, cupoMaximo;

    public CreditCard() {//NECESARIO PARA HACER PERSITENCIA!
    }

    public CreditCard(String nombreBanco, String MarcaInternacional, String mesExpiracion, String añoExpiracion, String nombreTitular, String numeroTarjeta, String numeroSeguridad) {
        this.nombreBanco = nombreBanco;
        this.MarcaInternacional = MarcaInternacional;
        this.mesExpiracion = mesExpiracion;
        this.añoExpiracion = añoExpiracion;
        this.nombreTitular = nombreTitular;
        this.numeroTarjeta = numeroTarjeta;
        this.numeroSeguridad = numeroSeguridad;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroSeguridad() {
        return numeroSeguridad;
    }

    public void setNumeroSeguridad(String numeroSeguridad) {
        this.numeroSeguridad = numeroSeguridad;
    }

    public String getMesExpiracion() {
        return mesExpiracion;
    }

    public void setMesExpiracion(String mesExpiracion) {
        this.mesExpiracion = mesExpiracion;
    }

    public String getAñoExpiracion() {
        return añoExpiracion;
    }

    public void setAñoExpiracion(String añoExpiracion) {
        this.añoExpiracion = añoExpiracion;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getMarcaInternacional() {
        return MarcaInternacional;
    }

    public void setMarcaInternacional(String MarcaInternacional) {
        this.MarcaInternacional = MarcaInternacional;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public double getCupoGastado() {
        return cupoGastado;
    }

    public void setCupoGastado(double cupoGastado) {
        this.cupoGastado = cupoGastado;
    }

    public double getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(double cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }
}
