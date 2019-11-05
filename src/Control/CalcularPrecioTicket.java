/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Reserva;

/**
 *
 * @author nicro
 */
public class CalcularPrecioTicket {

    public CalcularPrecioTicket() {
    }
    
    public double precioFinal(Reserva reserva) {
        return calcularPrecio(reserva) + calcularIva(reserva);
    }
    
    public double calcularPrecio(Reserva reserva) { //Acá falta completar porque no sé cómo calcularemos el precio del viaje teniendo en cuenta si afora equipaje o si el viaje es ida y vuelta, o ambos
        if(reserva.isEquipaje() && reserva.isIdaVuelta()) {
            return 100;
        }
        
        else if(reserva.isEquipaje() && !reserva.isIdaVuelta()) {
            return 200;
        }
        
        else if(!reserva.isEquipaje() && reserva.isIdaVuelta()) {
            return 300;
        }
        
        else {
            return 400;
        }
    }
    
    public double calcularIva(Reserva reserva) { //Por el momento pondré el 16 por ciento
        return calcularPrecio(reserva) * 0.16;
    }
}
