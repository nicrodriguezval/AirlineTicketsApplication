/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Usuario;
//import static Frontera.FramePrincipal.sistema;
import DAO.UsuarioDAO;

/**
 *
 * @author nicro
 */
public class ValidarLogin {
    
    private UsuarioDAO udao = new UsuarioDAO();
    
    public ValidarLogin() {
    }
    
    public String verificarLogin(Usuario usuario) {
        
        if(!verificarLongitudUsername(usuario.getUsername())){
            return("Longitud de username incorrecta");
        } else if (!verificarLongitudPassword(usuario.getPassword())){
            return("Longitud de contraseña incorrecta");
        } else if(cuentaExistente(usuario.getUsername())){
            if(!verificarContrasenia(usuario.getUsername(), usuario.getPassword())){
                return("Contraseña incorrecta. Escríbala nuevamente");
            } else{
                return "¡Bienvenido " + setName(usuario.getUsername()) + '!';
            }
            
                        
        }
        return "Datos incorrectos";
    }
    
    public boolean verificarLongitudUsername (String nombre){
        return (nombre.length() > 3 && nombre.length() < 16);
    }
    
    public boolean verificarLongitudPassword (String password){
        return (password.length() > 4 && password.length() < 19);
    }
    

    
    public boolean cuentaExistente(String username) {
        /*for(Usuario u : sistema.getUsuarios()) {
            if(u.getUsername().equals(username)){
                return true;                    
            }
        }*/
        String query = "u.username LIKE '"+username+"'";
        if(udao.leerquerycount(query) != 0){
            return true;
        }
        return false;
    }
    
    public boolean verificarContrasenia(String username, String password){
        String query = "u.username LIKE '"+username+"' AND u.password LIKE '"+password+"'";
        if(udao.leerquerycount(query) != 0){
            return true;
        }
        return false;
    }

       public String setName(String username) {
        /*for(Usuario u : sistema.getUsuarios()) {
            if(u.getUsername().equals(username)){
                return u.getNombre();
            }
        }*/
        String query = "u.username LIKE '"+username+"'";
        if(udao.leerquerycount(query) != 0){
            return udao.leerusername(username).getNombre();
        }
        return null;
       }
    
    public Usuario findUsuario(String username) {
        /*for(Usuario u : sistema.getUsuarios()) {
            if(u.getUsername().equals(username)) return u;
        }*/
        String query = "u.username LIKE '"+username+"'";
        if(udao.leerquerycount(query) != 0){
            return udao.leerusername(username);
        }
        return null;
    }
}
