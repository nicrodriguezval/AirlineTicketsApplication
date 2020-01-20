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
public class CalcularPrecio {

    public CalcularPrecio() {
    }

    public double precioFinal(Reserva reserva) {
        return calcularPrecio(reserva) + calcularIva(reserva);
    }

    public double calcularPrecio(Reserva reserva) { //Acá falta completar porque no sé cómo calcularemos el precio del viaje teniendo en cuenta si afora equipaje o si el viaje es ida y vuelta, o ambos
        if (reserva.isIdaVuelta() && reserva.getCategoria().equals("Primera clase")) {
            return precioEquipaje(reserva.getPeso()) + reserva.getVueloIda().getPrecioPrimeraClase() + precioEquipaje(reserva.getPesoVuelta()) + reserva.getVueloVuelta().getPrecioPrimeraClase();
        } else if (!reserva.isIdaVuelta() && reserva.getCategoria().equals("Primera clase")) {
            return precioEquipaje(reserva.getPeso()) + reserva.getVueloIda().getPrecioPrimeraClase();
        } else if (reserva.isIdaVuelta() && reserva.getCategoria().equals("Ejecutiva")) {
            return precioEquipaje(reserva.getPeso()) + reserva.getVueloIda().getPrecioClaseEjecutiva() + precioEquipaje(reserva.getPesoVuelta()) + reserva.getVueloVuelta().getPrecioClaseEjecutiva();
        } else if (!reserva.isIdaVuelta() && reserva.getCategoria().equals("Ejecutiva")) {
            return precioEquipaje(reserva.getPeso()) + reserva.getVueloIda().getPrecioClaseEjecutiva();
        } else if (reserva.isIdaVuelta() && reserva.getCategoria().equals("Turista")) {
            return precioEquipaje(reserva.getPeso()) + reserva.getVueloIda().getPrecioClaseTurista() + precioEquipaje(reserva.getPesoVuelta()) + reserva.getVueloVuelta().getPrecioClaseTurista();
        } else if (!reserva.isIdaVuelta() && reserva.getCategoria().equals("Turista")) {
            return precioEquipaje(reserva.getPeso()) + reserva.getVueloIda().getPrecioClaseTurista();
        } else {
            return 0;
        }
    }

    public double calcularIva(Reserva reserva) {
        return calcularPrecio(reserva) * 0.19;
    }

    public double precioEquipaje(int peso) {
        switch (peso) {
            case 0:
                return 0;
            case 1:
                return 5;
            case 2:
                return 10;
            case 3:
                return 20;
            case 4:
                return 40;
            default:
                return 80;
        }
    }
}
