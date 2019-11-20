/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.CreditCardDAO;
import DAO.ReservaDAO;
import Entidad.CreditCard;
import Entidad.Reserva;
import java.util.List;

/**
 *
 * @author nicro
 */
public class ValidarPagoTarjeta {
    private ReservaDAO rdao = new ReservaDAO();
    private CreditCardDAO tdao = new CreditCardDAO();

    public ValidarPagoTarjeta() {
    }
    
    public String verificarPagoTarjeta(int id, CreditCard tarjeta, double precioReserva) {
        if(!verificarNombreBanco(tarjeta.getNombreBanco()))
            return "Por favor seleccione un banco verificado";
        
        else if(!verificarMarcaInternacional(tarjeta.getMarcaInternacional()))
            return "Por favor ingrese una de las marcas de tarjeta registradas";
        
        else if(!verificarNombreTitular(tarjeta.getNombreTitular()))
            return "Longitud del nombre del titular incorrecta";
        
        else if(!verificarExistenciaTitular(tarjeta.getNombreTitular()))
            return "La persona ingresada no es un titular activo";
                 
        else if(!verificarNumeroTarjeta(tarjeta.getNumeroTarjeta()))
            return "Longitud del número de la tarjeta incorrecta";
                         
        else if(!verificarExistenciaTarjeta(tarjeta.getNumeroTarjeta()))
            return "La tarjeta de crédito no se encuentra registrada";

        else if(!verificarReserva(id))
            return "La reserva no existe";
        
        else if(!verificarMesExpiracion(tarjeta.getMesExpiracion()))
            return "El mes ingresado no es válido";
        
        else if(!verificarExistenciaMesExpiracion(tarjeta.getMesExpiracion()))
            return "El mes ingresado no coincide con los datos registrados";
                
        else if(!verificarAñoExpiracion(tarjeta.getAñoExpiracion()))
            return "El año ingresado no es válido";
        
        else if(!verificarExistenciaAñoExpiracion(tarjeta.getAñoExpiracion()))
            return "El año ingresado no coincide con los datos registrados";
                        
        else if(!verificarNumeroSeguridad(tarjeta.getNumeroSeguridad()))
            return "El número de seguridad es incorrecto";
        
        else if(!verificarTarjeta(tarjeta)) 
            return "La tarjeta de crédito no existe";
        
        else if(!validarCompra(tarjeta.getCupoGastado(), tarjeta.getCupoMaximo(), precioReserva))
            return "No hay cupo suficiente en la tarjeta para realizar el pago";
        
        else
            return "Todo correcto";
    }
    
    public boolean verificarReserva(int id) {
        String query = "r.id = "+id;
        if(rdao.leerquerycount(query)== 1){
            return true;
        }
        /*for(int i = 0; i < listReservas.size(); i++)
            if(listReservas.get(i).getId() == id)
                return true;*/
        
        return false;
    }
    
    public boolean verificarNombreBanco(String nombreBanco) {
        return(!nombreBanco.equals("-Seleccione una opción-"));
    }
    
    public boolean verificarMesExpiracion(String mesExpiracion){
        char[] ch = mesExpiracion.toCharArray();
        boolean ret = true;
        if(!mesExpiracion.isEmpty()){
            for (char c : ch){
                if(c < '0' || c > '9'){
                    ret = false;
                    }   
            }
            if(mesExpiracion.length() == 2 && ret == true){
            int mes = Integer.parseInt(mesExpiracion);     
                if(mes > 0 && mes <= 12){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean verificarAñoExpiracion(String añoExpiracion){
        char[] ch = añoExpiracion.toCharArray();
        boolean ret = true;
        if (!añoExpiracion.isEmpty()) {
            for (char c : ch){
                if(c < '0' || c > '9')
                    ret = false;
            }
            if (añoExpiracion.length() == 2 && ret == true) {
            int año = Integer.parseInt(añoExpiracion);
                if (año > 0 && año <= 99) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean verificarMarcaInternacional(String marcaInternacional) {
        return(!marcaInternacional.equals("-Seleccione una opción-"));
    }
    
    public boolean verificarNombreTitular(String nombreTitular) {
        return(nombreTitular.length() > 2 && nombreTitular.length() <= 30);
    }
    
    public boolean verificarExistenciaTitular(String nombreTitular){
        List<String> val = tdao.leerdiffallparametertolist("nombreTitular");
        for(int i = 0; i < val.size();i++){
            if(nombreTitular.equals(val.get(i))){
                return true;
            }
        }
        return false;
    }
    
    public boolean verificarExistenciaTarjeta(String numeroTarjeta){
        List<String> val = tdao.leerdiffallparametertolist("numeroTarjeta");
        for(int i = 0; i < val.size();i++){
            if(numeroTarjeta.equals(val.get(i))){
                return true;
            }
        }
        return false;
    }
    
    public boolean verificarExistenciaMesExpiracion(String mesExpiracion){
        List<String> val = tdao.leerdiffallparametertolist("mesExpiracion");
        for(int i = 0; i < val.size();i++){
            if(mesExpiracion.equals(val.get(i))){
                return true;
            }
        }
        return false;
    }
    
    public boolean verificarExistenciaAñoExpiracion(String añoExpiracion){
        List<String> val = tdao.leerdiffallparametertolist("añoExpiracion");
        for(int i = 0; i < val.size();i++){
            if(añoExpiracion.equals(val.get(i))){
                return true;
            }
        }
        return false;
    }
    
    public boolean verificarNumeroTarjeta(String numeroTarjeta) {
        return(numeroTarjeta.length() == 16);
    }
    
    public boolean verificarNumeroSeguridad(String numeroSeguridad){
        List<String> val = tdao.leerdiffallparametertolist("numeroSeguridad");
        for(int i = 0; i < val.size();i++){
            if(numeroSeguridad.equals(val.get(i))){
                return true;
            }
        }
        return false;   
    }
    
    public boolean verificarTarjeta(CreditCard tarjeta) {
        String query = "t.nombreBanco LIKE '"+tarjeta.getNombreBanco()+
                "' AND t.nombreTitular LIKE '"+tarjeta.getNombreTitular()+
                "' AND t.numeroTarjeta LIKE '"+tarjeta.getNumeroTarjeta()+
                "' AND t.MarcaInternacional LIKE '"+tarjeta.getMarcaInternacional()+"'";
        if(tdao.leerquerycount(query)== 1){
            return true;
        }        
        return false;
    }

    public boolean validarCompra(double cupoGastado, double cupoMaximo, double precioReserva) {
        return((cupoMaximo - cupoGastado) >= precioReserva);
    }   
}
