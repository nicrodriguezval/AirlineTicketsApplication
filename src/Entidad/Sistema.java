/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.util.ArrayList;

/**
 *
 * @author nicro
 */
public class Sistema {
    private ArrayList<Usuario> usuarios;
    private ArrayList<CreditCard> tarjetas;

    public Sistema() {
        usuarios = new ArrayList<> ();
        tarjetas = new ArrayList<> ();
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public void addUsuarios(Usuario usuario) {
        usuarios.add(usuario);
    }

    public ArrayList<CreditCard> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(ArrayList<CreditCard> tarjeta) {
        this.tarjetas = tarjeta;
    }
    
    public void addTarjetas(CreditCard tarjeta) {
        tarjetas.add(tarjeta);
    }
}
