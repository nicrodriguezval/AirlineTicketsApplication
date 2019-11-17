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
        if(!verificarReserva(id))
            return "La reserva no existe";
        
        else if(!verificarNombreBanco(tarjeta.getNombreBanco()))
            return "Longitud del nombre del banco incorrecta";
        
        else if(!verificarFechaCaducidad(tarjeta.getFechaCaducidad()))
            return "Formato de fecha incorrecta";
        
        else if(!verificarNombreTitular(tarjeta.getNombreTitular()))
            return "Longitud del nombre del titular incorrecta";
        
        else if(!verificarMarcaInternacional(tarjeta.getMarcaInternacional()))
            return "Longitud de marca internacional incorrecta";
        
        else if(!verificarNumeroTarjeta(tarjeta.getNumeroTarjeta()))
            return "Longitud del numero de la tarjeta incorrecta";
        
        else if(!verificarTarjeta(tarjeta)) 
            return "La tarjeta de crédito no se encuentra registrada";
        
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
        return(nombreBanco.length() > 2 && nombreBanco.length() <= 25);
    }
    
    public boolean verificarFechaCaducidad(String fechaCaducidad) {
        return(fechaCaducidad.length() > 7 && fechaCaducidad.length() <= 10);
    }
    
    public boolean verificarMarcaInternacional(String marcaInternacional) {
        return(marcaInternacional.length() > 2 && marcaInternacional.length() <= 20);
    }
    
    public boolean verificarNombreTitular(String nombreTitular) {
        return(nombreTitular.length() > 2 && nombreTitular.length() <= 30);
    }
    
    public boolean verificarNumeroTarjeta(String numeroTarjeta) {
        return(numeroTarjeta.length() == 16);
    }
    
    public boolean verificarTarjeta(CreditCard tarjeta) {
        
        String query = "t.nombreBanco LIKE '"+tarjeta.getNombreBanco()+"' AND t.fechaCaducidad LIKE '"+tarjeta.getFechaCaducidad()+
        "' AND t.nombreTitular LIKE '"+tarjeta.getNombreTitular()+"' AND t.MarcaInternacional LIKE '"+tarjeta.getMarcaInternacional()+
        "' AND t.numeroTarjeta LIKE '"+tarjeta.getNumeroTarjeta()+"'";
        if(tdao.leerquerycount(query)== 1){
            return true;
        }
        /*for(int i = 0; i < listTarjetas.size(); i++)
            if(listTarjetas.get(i).getNombreBanco().equals(tarjeta.getNombreBanco()) && listTarjetas.get(i).getFechaCaducidad().equals(tarjeta.getFechaCaducidad()) && listTarjetas.get(i).getMarcaInternacional().equals(tarjeta.getMarcaInternacional())
                        && listTarjetas.get(i).getNombreTitular().equals(tarjeta.getNombreTitular()) && listTarjetas.get(i).getNumeroTarjeta().equals(tarjeta.getNumeroTarjeta()))
                return true;*/
        
        return false;
    }

    public boolean validarCompra(double cupoGastado, double cupoMaximo, double precioReserva) {
        return((cupoMaximo - cupoGastado) >= precioReserva);
    }   
}
