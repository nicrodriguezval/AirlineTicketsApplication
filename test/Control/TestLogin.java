/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Usuario;
import static Frontera.FramePrincipal.sistema;
import static Frontera.Login.user;
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
public class TestLogin {
    
    private static ValidarLogin validarLogin = new ValidarLogin();

    private String LUSR_ERROR = "Longitud de username incorrecta";
    private String LPAS_ERROR = "Longitud de contraseña incorrecta";
    private String WRONG_PASS = "Contraseña incorrecta. Escríbala nuevamente";
    private String DATA_ERROR = "Datos incorrectos";
    private String SUCCESS(String nombre){
        return "¡Bienvenido " + nombre + "!";
    }

    
    public TestLogin() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Usuario a = new Usuario();
        Usuario b = new Usuario();
        Usuario c = new Usuario();
        
        a.setNombre("Nicolás");
        a.setApellido("Rodríguez");
        a.setEmail("nicrodriguezval@unal.edu.co");
        a.setUsername("nicrodriguezval");
        a.setPassword("123123");
        
        b.setNombre("Guillermo");
        b.setApellido("Pérez");
        b.setEmail("guillermo@gmail.com");
        b.setUsername("gillermoP");
        b.setPassword("121212");
        
        c.setNombre("Juan");
        c.setApellido("Tovar");
        c.setEmail("juancho@hotmail.com");
        c.setUsername("juancho01");
        c.setPassword("a1b2c3");
        
        sistema.addUsuarios(a);
        sistema.addUsuarios(b);
        sistema.addUsuarios(c);
        
        System.out.println("(test) USUARIOS EXISTENTES");
        System.out.println();
        
        for(Usuario u : sistema.getUsuarios()) {
            System.out.println("Nombre(s): " + u.getNombre());
            System.out.println("Apellido(s): " + u.getApellido());
            System.out.println("Username: " + u.getUsername());
            System.out.println("-------");
        }
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
    public void testLongitudUsername(){
    Usuario u = new Usuario();
    u.setUsername("abcdefghijklmnopqrstuvwxyz");
    u.setPassword("abcdef");
    assertEquals(LUSR_ERROR,validarLogin.verificarLogin(u));

    u.setUsername("use");
    u.setPassword("abcde");
    assertEquals(LUSR_ERROR,validarLogin.verificarLogin(u));
    } 
    
    @Test
    public void testLongitudPassword(){
    Usuario u = new Usuario();
    u.setUsername("nicrodriguezval");
    u.setPassword("123456789abcdef1234");
    assertEquals(LPAS_ERROR,validarLogin.verificarLogin(u));

    u.setUsername("nicrodriguezval");
    u.setPassword("1234");
    assertEquals(LPAS_ERROR,validarLogin.verificarLogin(u));
    } 
    
    @Test
    public void testCuentaExistente(){
    Usuario u = new Usuario();
    u.setUsername("miapenahu");
    u.setPassword("abcdefg");
    assertEquals(DATA_ERROR,validarLogin.verificarLogin(u));

    u.setUsername("juangarciau");
    u.setPassword("wsdreaxf");
    assertEquals(DATA_ERROR,validarLogin.verificarLogin(u));
    }
    
    @Test
    public void testContraseniaIncorrecta(){
    Usuario u = new Usuario();
    u.setUsername("nicrodriguezval");
    u.setPassword("9382sjjdb");
    assertEquals(WRONG_PASS,validarLogin.verificarLogin(u));

    u.setUsername("juancho01");
    u.setPassword("dkan20d1");
    assertEquals(WRONG_PASS,validarLogin.verificarLogin(u));
    }

    @Test
    public void testAllCorrect(){
    Usuario u = new Usuario();
    u.setUsername("nicrodriguezval");
    u.setPassword("123123");
    u.setNombre("Nicolás");
    assertEquals(SUCCESS(u.getNombre()),validarLogin.verificarLogin(u));

    u.setUsername("gillermoP");
    u.setPassword("121212");
    u.setNombre("Guillermo");
    assertEquals(SUCCESS(u.getNombre()),validarLogin.verificarLogin(u));
    }
}
