/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Usuario;
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
public class TestJoin {
    
    private static ValidarJoin validarJoin = new ValidarJoin();
    
    private String LNOM_ERROR = "Longitud de nombre incorrecta";
    private String LAPE_ERROR = "Longitud de apellido incorrecta";
    private String LUSR_ERROR = "Longitud de username incorrecta";
    private String USR_SINTAX = "El primer caracter del username no puede ser un número";
    private String USR_DUPLIC = "El username ya existe";
    private String EMAIL_LONG = "Longitud de email incorrecto";
    private String EMAIL_SINTAX = "Email inválido";
    private String EMAIL_DUPLIC = "El email ya existe";
    private String LPAS_ERROR = "Longitud de contraseña incorrecta";
    private String PASS_DIFF = "Las contraseñas no coinciden";
    private String SUCCESS = "Registro exitoso";
            
            
            
            
    public TestJoin() {
    }
    
    @BeforeClass
    public static void setUpClass() {/*
        Usuario a = new Usuario();
        Usuario b = new Usuario();
        Usuario c = new Usuario();
        
        a.setNombre("Nicolás");
        a.setApellido("Rodríguez");
        a.setEmail("nicrodriguezval@unal.edu.co");
        a.setUsername("nicrodriguezval");
        a.setPassword("12312312");
        
        b.setNombre("Guillermo");
        b.setApellido("Pérez");
        b.setEmail("guillermo@gmail.com");
        b.setUsername("gillermoP");
        b.setPassword("12121212");
        
        c.setNombre("Juan");
        c.setApellido("Tovar");
        c.setEmail("juancho@hotmail.com");
        c.setUsername("juancho01");
        c.setPassword("a1b2c3d4");
        
        sistema.addUsuarios(a);
        sistema.addUsuarios(b);
        sistema.addUsuarios(c);
        
        System.out.println("(test)USUARIOS EXISTENTES");
        System.out.println();
        
        for(Usuario u : sistema.getUsuarios()) {
            System.out.println("Nombre(s): " + u.getNombre());
            System.out.println("Apellido(s): " + u.getApellido());
            System.out.println("Username: " + u.getUsername());
            System.out.println("-------");
        }*/
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
    public void testLongitudNombre(){
    Usuario u = new Usuario();
    u.setNombre("@");
    u.setApellido("Ramírez");
    u.setUsername("aramirez");
    u.setEmail("123abc@gmail.com");
    u.setPassword("abcdef");
    String password2 = "abcdef";
    assertEquals(LNOM_ERROR,validarJoin.verificarJoin(u, password2));

    u.setNombre("uwuwewewe onhetwewewe ughewughmen");
    u.setApellido("osas");
    u.setUsername("uasdaqe");
    u.setEmail("akdcnedl@gmail.com");
    u.setPassword("abcdef");
    password2 = "abcdef";
    assertEquals(LNOM_ERROR,validarJoin.verificarJoin(u, password2));
    }    

    @Test
    public void testLongitudApellido(){
    Usuario u = new Usuario();
    u.setNombre("Carlos");
    u.setApellido("B");
    u.setUsername("carlosb13");
    u.setEmail("uncorreo@hotmail.com");
    u.setPassword("12345678");
    String password2 = "12345678";
    assertEquals(LAPE_ERROR,validarJoin.verificarJoin(u, password2));

    u.setNombre("Gloria");
    u.setApellido("Arietaleanizbeazcoechea");
    u.setUsername("gloriaa34");
    u.setEmail("gloriaarieta@outlook.es");
    u.setPassword("abcdef");
    password2 = "abcdef";
    assertEquals(LAPE_ERROR,validarJoin.verificarJoin(u, password2));
    } 
    
    @Test
    public void testLongitudUsername(){
    Usuario u = new Usuario();
    u.setNombre("Mike");
    u.setApellido("Johnson");
    u.setUsername("mik");
    u.setEmail("mikejson@gmail.com");
    u.setPassword("abcde");
    String password2 = "abcde";
    assertEquals(LUSR_ERROR,validarJoin.verificarJoin(u, password2));

    u.setNombre("Juan");
    u.setApellido("García");
    u.setUsername("juan_garcia_username");
    u.setEmail("juang435@yahoo.es");
    u.setPassword("wsdreaxf");
    password2 = "wsdreaxf";
    assertEquals(LUSR_ERROR,validarJoin.verificarJoin(u, password2));
    } 
    
    @Test
    public void testSintaxisUsername(){
    Usuario u = new Usuario();
    u.setNombre("Diego");
    u.setApellido("Jiménez");
    u.setUsername("123user");
    u.setEmail("gdiego@unal.edu.co");
    u.setPassword("9382sjjdb");
    String password2 = "9382sjjdb";
    assertEquals(USR_SINTAX,validarJoin.verificarJoin(u, password2));

    u.setNombre("Mario");
    u.setApellido("Vélez");
    u.setUsername("98mario64");
    u.setEmail("gentoasd@gmail.com");
    u.setPassword("dkan20d1");
    password2 = "dkan20d1";
    assertEquals(USR_SINTAX,validarJoin.verificarJoin(u, password2));
    }
    
    @Test
    public void testEqualUsernames(){
    Usuario u = new Usuario();
    u.setNombre("Juan");
    u.setApellido("Pérez");
    u.setUsername("juancho01");
    u.setEmail("jiaskfxsd@gmail.com");
    u.setPassword("23wjx29s");
    String password2 = "23wjx29s";
    assertEquals(USR_DUPLIC,validarJoin.verificarJoin(u, password2));

    u.setNombre("Bob");
    u.setApellido("Williams");
    u.setUsername("nicrodriguezval");
    u.setEmail("bobwilliams62@gmail.com");
    u.setPassword("swosn201");
    password2 = "swosn201";
    assertEquals(USR_DUPLIC,validarJoin.verificarJoin(u, password2));
    }
    
    @Test
    public void testVerificarEmail(){
    Usuario u = new Usuario();
    u.setNombre("Mary");
    u.setApellido("Poppins");
    u.setUsername("marypop");
    u.setEmail("m");
    u.setPassword("kdc-qkd3");
    String password2 = "kdc-qkd3";
    assertEquals(EMAIL_LONG,validarJoin.verificarJoin(u, password2));

    u.setNombre("Miguel");
    u.setApellido("Villanueva");
    u.setUsername("migvilla");
    u.setEmail("estecorreodeverdadesdemasiadolargo@hotmail.com");
    u.setPassword("dasce142");
    password2 = "dasce142";
    assertEquals(EMAIL_LONG,validarJoin.verificarJoin(u, password2));
    }
    
    @Test
    public void testVerificarArroba(){
    Usuario u = new Usuario();
    u.setNombre("Ana");
    u.setApellido("Suárez");
    u.setUsername("anasuarez");
    u.setEmail("esteesuncorreosinlaarroba.com");
    u.setPassword("dc8iP9vd");
    String password2 = "dc8iP9vd";
    assertEquals(EMAIL_SINTAX,validarJoin.verificarJoin(u, password2));

    u.setNombre("Joe");
    u.setApellido("Arroyo");
    u.setUsername("joestreams");
    u.setEmail("@alprincipio.hotmail.com");
    u.setPassword("d82d84");
    password2 = "d82d84";
    assertEquals(EMAIL_SINTAX,validarJoin.verificarJoin(u, password2));
    }

    @Test
    public void testEqualEmails(){
    Usuario u = new Usuario();
    u.setNombre("Darío");
    u.setApellido("Gómez");
    u.setUsername("dario_g69");
    u.setEmail("miapenahu@unal.edu.co");
    u.setPassword("s2f49g20s");
    String password2 = "s2f49g20s";
    assertEquals(EMAIL_DUPLIC,validarJoin.verificarJoin(u, password2));

    u.setNombre("Bruce");
    u.setApellido("Wayne");
    u.setUsername("im_not_batman");
    u.setEmail("juancho@hotmail.com");
    u.setPassword("1N2M3B4N5");
    password2 = "1N2M3B4N5";
    assertEquals(EMAIL_DUPLIC,validarJoin.verificarJoin(u, password2));
    }

    @Test
    public void testLongitudPassword(){
    Usuario u = new Usuario();
    u.setNombre("Brayan");
    u.setApellido("Stiven");
    u.setUsername("braystiv");
    u.setEmail("braystiv99@gmail.com");
    u.setPassword("1ac2");
    String password2 = "1ac2";
    assertEquals(LPAS_ERROR,validarJoin.verificarJoin(u, password2));

    u.setNombre("Gabriel");
    u.setApellido("Arias");
    u.setUsername("gab_arias");
    u.setEmail("gab_arias2@outlook.es");
    u.setPassword("123456789abcdef123456789"); 
    password2 = "123456789abcdef123456789";
    assertEquals(LPAS_ERROR,validarJoin.verificarJoin(u, password2));
    }
    
    @Test
    public void testEqualPassword(){
    Usuario u = new Usuario();
    u.setNombre("Kevin");
    u.setApellido("Jackson");
    u.setUsername("val_kevin");
    u.setEmail("kevjack@unal.edu.co");
    u.setPassword("abcd1234");
    String password2 = "1234abcd";
    assertEquals(PASS_DIFF,validarJoin.verificarJoin(u, password2));

    u.setNombre("Trevor");
    u.setApellido("Philips");
    u.setUsername("trev_phil");
    u.setEmail("trevorp@unal.edu.co");
    u.setPassword("a1b2c3d4");
    password2 = "aaaaaaaaa";
    assertEquals(PASS_DIFF,validarJoin.verificarJoin(u, password2));
    }
    
    @Test
    public void testAllCorrect(){
    Usuario u = new Usuario();
    u.setNombre("Marcos");
    u.setApellido("Ayala");
    u.setUsername("ayalam");
    u.setEmail("ayalam@unal.edu.co");
    u.setPassword("wasd1234");
    String password2 = "wasd1234";
    assertEquals(SUCCESS,validarJoin.verificarJoin(u, password2));

    u.setNombre("Jesus");
    u.setApellido("Hernández");
    u.setUsername("jesusher77");
    u.setEmail("jesusher77@gmail.com");
    u.setPassword("strong-pass");
    password2 = "strong-pass";
    assertEquals(SUCCESS,validarJoin.verificarJoin(u, password2));
    }
}

