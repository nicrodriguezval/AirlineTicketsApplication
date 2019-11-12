/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author alemr
 */
public class ValidarReserva {
    
    public ValidarReserva() {
        
    }
    
    public String verificarReservaIda(String origen, String destino, String fecha, String hora) {
        if(verificarOrigen(origen))
            return "Elija una ciudad de origen";
        
        else if(verificarDestino(destino))
            return "Elija una ciudad de destino";
        
        else if(verificarFecha(fecha))
            return "Elija una fecha para el vuelo";
        
        else if(verificarHora(hora))
            return "Elija una hora para el vuelo";
        
        else
            return "Todo correcto";
    }
    
    public String verificarReservaVuelta(String fecha, String hora) {
        if(verificarFecha(fecha))
            return "Elija una fecha para el vuelo";
        
        else if(verificarHora(hora))
            return "Elija una hora para el vuelo";
        
        else
            return "Todo correcto";
    }
    
    public boolean verificarOrigen(String origen) {
        return(origen.equals("Ninguno"));
    }
    
    public boolean verificarDestino(String destino) {
        return(destino.equals("Ninguno"));
    }
    
    public boolean verificarFecha(String fecha) {
        return(fecha.equals("Ninguna"));
    }
    
    public boolean verificarHora(String hora) {
        return(hora.equals("Ninguna"));
    }
}
