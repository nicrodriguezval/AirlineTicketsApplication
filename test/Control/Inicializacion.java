/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.UsuarioDAO;
import Entidad.Usuario;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Miguel Alejandro
 */
public class Inicializacion {    
    
    public Inicializacion() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void initData(){
        
        UsuarioDAO dao = new UsuarioDAO();
        
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        
        Usuario a = new Usuario();
        Usuario b = new Usuario();
        Usuario c = new Usuario();
        Usuario d = new Usuario();
        
        a.setNombre("Nicolás");
        a.setApellido("Rodríguez");
        a.setEmail("nicrodriguezval@unal.edu.co");
        a.setUsername("nicrodriguezval");
        a.setPassword("123123");
        
        b.setNombre("Lucas");
        b.setApellido("Peña");
        b.setEmail("lucas@gmail.com");
        b.setUsername("lucasps");
        b.setPassword("123456");
        
        c.setNombre("Juan");
        c.setApellido("Tovar");
        c.setEmail("juancho@hotmail.com");
        c.setUsername("juancho01");
        c.setPassword("a1b2c3");
        
        d.setNombre("Miguel");
        d.setApellido("Peña");
        d.setEmail("miapenahu@unal.edu.co");
        d.setUsername("miapenahu");
        d.setPassword("Abcd1234");
        
        usuarios.add(a);
        usuarios.add(b);
        usuarios.add(c);
        usuarios.add(d);
        /*sistema.addUsuarios(a);
        sistema.addUsuarios(b);
        sistema.addUsuarios(c);*/
        
        System.out.println("USUARIOS EXISTENTES");
        System.out.println();
        
        //for(Usuario u : sistema.getUsuarios()) {
        for(Usuario u: usuarios){
            System.out.println("Nombre(s): " + u.getNombre());
            System.out.println("Apellido(s): " + u.getApellido());
            System.out.println("Username: " + u.getUsername());
            System.out.println("-------");
            dao.crear(u);
        }    
    }
}
