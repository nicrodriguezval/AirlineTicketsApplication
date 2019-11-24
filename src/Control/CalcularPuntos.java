/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Vuelo;

/**
 *
 * @author Nicolás
 */
public class CalcularPuntos { //Por cada milla el usuario obtiene el 4% en puntos, cada punto equivale a 1 dolar

    public CalcularPuntos() {
    }

    public int generarPuntosIda(Vuelo vuelo) {
        return (int) (vuelo.getMillas() * 0.04);
    }

    public int generarPuntosIdaVuelta(Vuelo vueloIda, Vuelo vueloVuelta) {
        return (int) ((vueloIda.getMillas() + vueloVuelta.getMillas()) * 0.4);
    }
}
