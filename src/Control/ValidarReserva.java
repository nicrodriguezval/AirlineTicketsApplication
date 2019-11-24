/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.ReservaDAO;
import DAO.VueloDAO;
import Entidad.Reserva;
import Entidad.Vuelo;

/**
 *
 * @author Miguel Alejandro
 */
public class ValidarReserva {

    private ReservaDAO rdao = new ReservaDAO();
    private VueloDAO vdao = new VueloDAO();

    public ValidarReserva() {
    }

    public String VerificarReservaIda(String origen, String destino, String fecha, String hora) {
        if (!verificarOrigenSelected(origen)) {
            return "Ubicación de origen inválida. Por favor escoja una de las opciones";
        } else if (!verificarDestinoSelected(destino)) {
            return "Ubicación de destino inválida. Por favor escoja una de las opciones";
        } else if (!verificarFechaSelected(fecha)) {
            return "Fecha de vuelo inválida. Por favor escoja una de las opciones";
        } else if (!verificarHoraSelected(hora)) {
            return "Hora de vuelo inválida. Por favor escoja una de las opciones";
        } else {
            return "Todo Correcto";
        }
    }

    public String VerificarReservaVuelta(String fecha, String hora) {
        if (!verificarFechaSelected(fecha)) {
            return "Fecha de vuelo inválida. Por favor escoja una de las opciones";
        } else if (!verificarHoraSelected(hora)) {
            return "Hora de vuelo inválida. Por favor escoja una de las opciones";
        } else {
            return "Todo Correcto";
        }
    }

    public boolean verificarOrigenSelected(String origen) {
        for (Vuelo v : vdao.leeralltolist()) {
            if (v.getOrigen().equals(origen)) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarDestinoSelected(String destino) {
        for (Vuelo v : vdao.leeralltolist()) {
            if (v.getDestino().equals(destino)) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarFechaSelected(String fecha) {
        for (Vuelo v : vdao.leeralltolist()) {
            if (v.getFecha().equals(fecha)) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarHoraSelected(String hora) {
        for (Vuelo v : vdao.leeralltolist()) {
            if (v.getHora().equals(hora)) {
                return true;
            }
        }
        return false;
    }
}
