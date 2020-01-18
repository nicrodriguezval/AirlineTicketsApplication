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
        String query = "v.origen LIKE '" + origen + "'";
        if (vdao.leerquerycount(query) != 0) {
            return true;
        }
        return false;
    }

    public boolean verificarDestinoSelected(String destino) {
        String query = "v.destino LIKE '" + destino + "'";
        if (vdao.leerquerycount(query) != 0) {
            return true;
        }
        return false;
    }

    public boolean verificarFechaSelected(String fecha) {
        String query = "v.fecha LIKE '" + fecha + "'";
        if (vdao.leerquerycount(query) != 0) {
            return true;
        }
        return false;
    }

    public boolean verificarHoraSelected(String hora) {
        String query = "v.hora LIKE '" + hora + "'";
        if (vdao.leerquerycount(query) != 0) {
            return true;
        }
        return false;
    }
}
