/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Usuario;
import static Frontera.FramePrincipal.sistema;
import static Frontera.Login.user;

/**
 *
 * @author nicro
 */
public class ValidarLogin {
    
    public ValidarLogin() {
    }
    
    public String verificarLogin(Usuario usuario) {
        
        if(!verificarLongitudNombre(usuario.getUsername())){
            return("Longitud nombre incorrecta");
        } else if (!verificarLongitudPassword(usuario.getPassword())){
            return("Longitud contraseña incorrecta");
        } else if(cuentaExistente(usuario.getUsername(), usuario.getPassword())){
            return "¡Bienvenido " + user.getNombre() + '!';
        }
        return "Datos incorrectos";
    }
    
    public boolean verificarLongitudNombre (String nombre){
        return (nombre.length() > 1 && nombre.length() <= 15);
    }
    
    public boolean verificarLongitudPassword (String password){
        return (password.length() > 4 && password.length() <= 12);
    }
    
    public boolean cuentaExistente(String username, String password) {
        for(Usuario u : sistema.getUsuarios()) {
            if(u.getUsername().equals(username) && u.getPassword().equals(password)){
                return true;                    
            }
        }
        
        return false;
    }
    
    public Usuario findUsuario(String username) {
        for(Usuario u : sistema.getUsuarios()) {
            if(u.getUsername().equals(username)) return u;
        }
        
        return null;
    }
}
