/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Usuario;
import static Frontera.FramePrincipal.sistema;

/**
 *
 * @author nicro
 */
public class ValidarLogin {
    
    public ValidarLogin() {
    }
    
    public String verificarLogin(Usuario usuario) {
        if(cuentaExistene(usuario.getUsername(), usuario.getPassword())) return "¡Bienvenido " + usuario.getUsername() + '!';
        
        else return "Datos incorrectos";
    }
    
    public boolean cuentaExistene(String username, String password) {
        for(Usuario u : sistema.getUsuarios()) {
            if(u.getUsername().equals(username) && u.getPassword().equals(password)) return true;
        }
        
        return false;
    }
}
