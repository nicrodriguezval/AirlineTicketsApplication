/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

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
public class TestValidarReserva {
    
    private static ValidarReserva validarReserva = new ValidarReserva();
    private String ORIG_ERROR = "Ubicación de origen inválida. Por favor escoja una de las opciones";
    private String DEST_ERROR = "Ubicación de destino inválida. Por favor escoja una de las opciones";
    private String DATE_ERROR = "Fecha de vuelo inválida. Por favor escoja una de las opciones";
    private String TIME_ERROR = "Hora de vuelo inválida. Por favor escoja una de las opciones";
    private String SUCCESS = "Todo Correcto";
    
    public TestValidarReserva() {
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
    public void testFechaExisteVuelta(){
        String fecha = "19/21/6801";
        String hora = "12:00";
        assertEquals(DATE_ERROR,validarReserva.VerificarReservaVuelta(fecha,hora));
        
        fecha = "0x/00/asdc";
        hora = "3:00";
        assertEquals(DATE_ERROR,validarReserva.VerificarReservaVuelta(fecha,hora));
    }    
    
    @Test
    public void testHoraExisteVuelta(){
        String fecha = "01/12/2019";
        String hora = "as:df";
        assertEquals(TIME_ERROR,validarReserva.VerificarReservaVuelta(fecha,hora));
        
        fecha = "15/1/2020";
        hora = "25:2d";
        assertEquals(TIME_ERROR,validarReserva.VerificarReservaVuelta(fecha,hora));
    }   
    
    @Test
    public void testAllCorrectVuelta(){
        String fecha = "15/12/2019";
        String hora = "11:00";
        assertEquals(SUCCESS,validarReserva.VerificarReservaVuelta(fecha,hora));
        
        fecha = "01/1/2020";
        hora = "14:00";
        assertEquals(SUCCESS,validarReserva.VerificarReservaVuelta(fecha,hora));
    }   

    @Test
    public void testOrigenExiste(){
        String origen = "El Cairo";
        String destino = "Ámsterdam";
        String fecha = "01/01/2020";
        String hora = "12:00";
        assertEquals(ORIG_ERROR,validarReserva.VerificarReservaIda(origen,destino,fecha,hora));
        
        origen = "San Petesburgo";
        destino = "Jerusalén";
        fecha = "01/01/2020";
        hora = "12:00";
        assertEquals(ORIG_ERROR,validarReserva.VerificarReservaIda(origen,destino,fecha,hora));
    }
    
    @Test
    public void testDestinoExiste(){
        String origen = "Bogotá";
        String destino = "Managua";
        String fecha = "01/01/2020";
        String hora = "12:00";
        assertEquals(DEST_ERROR,validarReserva.VerificarReservaIda(origen,destino,fecha,hora));
        
        origen = "Medellín";
        destino = "Londres";
        fecha = "01/01/2020";
        hora = "12:00";
        assertEquals(DEST_ERROR,validarReserva.VerificarReservaIda(origen,destino,fecha,hora));
    }
    
    @Test
    public void testFechaExisteIda(){
        String origen = "Bogotá";
        String destino = "Medellín";
        String fecha = "99/99/9999";
        String hora = "12:00";
        assertEquals(DATE_ERROR,validarReserva.VerificarReservaIda(origen,destino,fecha,hora));
        
        origen = "Bucaramanga";
        destino = "Cali";
        fecha = "00/00/0000";
        hora = "12:00";
        assertEquals(DATE_ERROR,validarReserva.VerificarReservaIda(origen,destino,fecha,hora));
    }
    
    @Test
    public void testHoraExisteIda(){
        String origen = "Cali";
        String destino = "Bucaramanga";
        String fecha = "01/12/2019";
        String hora = "99:00";
        assertEquals(TIME_ERROR,validarReserva.VerificarReservaIda(origen,destino,fecha,hora));
        
        origen = "Miami";
        destino = "Madrid";
        fecha = "15/1/2020";
        hora = "25:25";
        assertEquals(TIME_ERROR,validarReserva.VerificarReservaIda(origen,destino,fecha,hora));
    }
    
    @Test
    public void testAllCorrectIda(){
        String origen = "Madrid";
        String destino = "Miami";
        String fecha = "30/12/2019";
        String hora = "3:00";
        assertEquals(SUCCESS,validarReserva.VerificarReservaIda(origen,destino,fecha,hora));
        
        origen = "Medellín";
        destino = "Bogotá";
        fecha = "05/1/2020";
        hora = "5:00";
        assertEquals(SUCCESS,validarReserva.VerificarReservaIda(origen,destino,fecha,hora));
    }
}
