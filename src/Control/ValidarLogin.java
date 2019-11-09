/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Usuario;
//import static Frontera.FramePrincipal.sistema;
import DAO.UsuarioDAO;
import static Frontera.Login.user;

/**
 *
 * @author nicro
 */
public class ValidarLogin {
    
    private UsuarioDAO dao = new UsuarioDAO();
    
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
        if(dao.leerusername(username) != null){
            return true;
        }
        return false;
    }
    
    public boolean verificarContrasenia(String username, String password){
        /*for(Usuario u : sistema.getUsuarios()) {
            if(u.getUsername().equals(username)&& u.getPassword().equals(password)){
                return true;                    
            }
        }*/
        Usuario u = new Usuario();
        u.setUsername(username);
        u.setPassword(password);
        if(dao.leer(u) != null){
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
        if(dao.leerusername(username)!= null){
            return dao.leerusername(username).getNombre();
        }
        return null;
       }
    
    public Usuario findUsuario(String username) {
        /*for(Usuario u : sistema.getUsuarios()) {
            if(u.getUsername().equals(username)) return u;
        }*/
        if(dao.leerusername(username) != null){
            return dao.leerusername(username);
        }
        return null;
    }
}
