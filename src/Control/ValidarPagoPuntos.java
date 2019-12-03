/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Reserva;
import Entidad.Usuario;

/**
 *
 * @author nicro
 */
public class ValidarPagoPuntos {

    public ValidarPagoPuntos() {
    }

    public String verificarPagoPuntos(Usuario usuario, Reserva reserva) {
        int puntosCosto = (int) (reserva.getPrecio() + reserva.getIva());

        if (!validarRedimirPuntos(usuario.getPoints(), puntosCosto)) {
            return "Los puntos no son suficientes";
        } else {
            return "Todo correcto";
        }
    }

    private boolean validarRedimirPuntos(int puntosUsuario, int puntosCosto) {
        return (puntosUsuario - puntosCosto >= 0);
    }
}
