/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Reserva;
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
public class TestValidarPagoPuntos {
    
    private static ValidarPagoPuntos validarPagoPuntos =  new ValidarPagoPuntos();
    
    private String NOT_ENOUGH = "Los puntos no son suficientes";
    private String SUCCESS = "Todo correcto";
    
    public TestValidarPagoPuntos() {
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
    public void TestPuntosNoSuficientes(){
        Reserva r = new Reserva();
        Usuario u = new Usuario();
        
        u.setPoints(1015);
        r.setIva(322.05);
        r.setPrecio(1694.95);
        assertEquals(NOT_ENOUGH, validarPagoPuntos.verificarPagoPuntos(u,r));
        
        u.setPoints(1);
        r.setIva(672.26);
        r.setPrecio(127.74);
        assertEquals(NOT_ENOUGH, validarPagoPuntos.verificarPagoPuntos(u,r));
        
        u.setPoints(-1);
        r.setIva(1293.27);
        r.setPrecio(245.73);
        assertEquals(NOT_ENOUGH, validarPagoPuntos.verificarPagoPuntos(u,r));
        
        u.setPoints(117012);
        r.setIva(98330.25);
        r.setPrecio(18682.75);
        assertEquals(NOT_ENOUGH, validarPagoPuntos.verificarPagoPuntos(u,r));
        
        u.setPoints(700);
        r.setIva(9000);
        r.setPrecio(810);
        assertEquals(NOT_ENOUGH, validarPagoPuntos.verificarPagoPuntos(u,r)); 
    } 
    
        @Test
    public void TestAllCorrect(){
        Reserva r = new Reserva();
        Usuario u = new Usuario();
        
        u.setPoints(20000);
        r.setIva(1);
        r.setPrecio(10);
        assertEquals(SUCCESS, validarPagoPuntos.verificarPagoPuntos(u,r));
        
        u.setPoints(499);
        r.setIva(359);
        r.setPrecio(77);
        assertEquals(SUCCESS, validarPagoPuntos.verificarPagoPuntos(u,r));
        
        u.setPoints(901);
        r.setIva(900.25);
        r.setPrecio(0.75);
        assertEquals(SUCCESS, validarPagoPuntos.verificarPagoPuntos(u,r));
        
        u.setPoints(12000);
        r.setIva(777);
        r.setPrecio(49);
        assertEquals(SUCCESS, validarPagoPuntos.verificarPagoPuntos(u,r));
        
        u.setPoints(1945);
        r.setIva(1937);
        r.setPrecio(7);
        assertEquals(SUCCESS, validarPagoPuntos.verificarPagoPuntos(u,r)); 
    } 
}
