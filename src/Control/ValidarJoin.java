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
public class ValidarJoin {

    public ValidarJoin() {
    }
    
    public String verificarJoin(Usuario usuario, String verificarPassword) {
        if(!verificarLongitudNombre(usuario.getNombre())) return "Longitud de nombre incorrecta";
        
        else if(!verificarLongitudApellido(usuario.getApellido())) return "Longitud de apellido incorrecta";
       
        else if(!verificarLongitudUsername(usuario.getUsername())) return "Longitud de username incorrecta";
       
        else if(!sintaxisUsername(usuario.getUsername())) return "El primer caracter del username no puede ser un número";
        
        else if(equalUsernames(usuario.getUsername())) return "El username ya existe";
        
        else if(!verificarEmail(usuario.getEmail())) return "Longitud de email incorrecto";
        
        else if(!verificarArroba(usuario.getEmail())) return "Email inválido";
        
        else if(equalEmails(usuario.getEmail())) return "El email ya existe";
        
        else if(!verificarLongitudPassword(usuario.getPassword())) return "Longitud de contraseña incorrecta";
        
        else if(!equalPassword(usuario.getPassword(), verificarPassword)) return "Las contraseñas no coinciden";
        
        else return "Registro exitoso";
    }
    
    public boolean verificarLongitudNombre(String nombre) {
        return(nombre.length() > 1 && nombre.length() <= 15);
    }
    
    public boolean verificarLongitudApellido(String apellido) {
        return(apellido.length() > 1 && apellido.length() <= 20);
    }
    
    public boolean verificarLongitudUsername(String username) {
        if (username.length() <= 4 || username.length() > 15) {
            return false;
        }
        
        return true;
    }
    
    public boolean sintaxisUsername(String username) { //la primera letra del username no debe ser un número
        String name = Character.toString(username.charAt(0));
        
        for(int i = 0; i < 10; i++) {
            String numero = String.valueOf(i);
            if(name.equals(numero)) return false;          
        }
        
        return true;
    }
    
    public boolean equalUsernames(String username) {
        for(Usuario u: sistema.getUsuarios()) {
            if(u.getUsername().equals(username)) return true;
        }
        
        return false;
    }
    
    public boolean verificarEmail(String email) {
        if(email.length() <= 0 && email.length() > 30) return false;
        
        return true;
    }
    
    public boolean verificarArroba(String email) {
        for (int i = 0; i < email.length(); i++) {
            if(email.charAt(i) == '@' && i != 0 && i != email.length() - 1) return true;
        }
        
        return false;
    }
    
    public boolean equalEmails(String email) {
        for(Usuario u : sistema.getUsuarios()) {
            if(u.getEmail().equals(email)) return true;
        }
        
        return false;
    }
    
    public boolean verificarLongitudPassword(String password) {
        return(password.length() > 4 && password.length() <= 12);
    }
    
    public boolean equalPassword(String password1, String password2) {
        return(password1.equals(password2));
    }
}
