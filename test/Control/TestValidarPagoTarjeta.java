/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.CreditCardDAO;
import DAO.ReservaDAO;
import Entidad.CreditCard;
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
public class TestValidarPagoTarjeta {
    
    private static ValidarPagoTarjeta validarPagoTarjeta = new ValidarPagoTarjeta();
    ReservaDAO rdao = new ReservaDAO();
    CreditCardDAO tdao = new CreditCardDAO();
    
    private String BNAME_ERROR = "Por favor seleccione un banco verificado";
    private String MARCA_ERROR = "Por favor ingrese una de las marcas de tarjeta registradas";
    private String TNAME_ERROR = "Longitud del nombre del titular incorrecta";
    private String T_EXISTENCE = "La persona ingresada no es un titular activo";
    private String CARD_N_ERROR = "Longitud del número de la tarjeta incorrecta";
    private String CARD_E_ERROR = "La tarjeta de crédito no se encuentra registrada";
    private String RESERVA_ERROR = "La reserva no existe";
    private String MES_ERROR = "El mes ingresado no es válido";
    private String MES_EXIST = "El mes ingresado no coincide con los datos registrados";
    private String AÑO_ERROR = "El año ingresado no es válido";
    private String AÑO_EXIST = "El año ingresado no coincide con los datos registrados";
    private String NUM_SEG_ERROR = "El número de seguridad es incorrecto";
    private String VERIFY_CARD = "La tarjeta de crédito no existe";
    private String VAL_COMPRA = "No hay cupo suficiente en la tarjeta para realizar el pago";
    private String SUCCESS = "Todo correcto";
    
    public TestValidarPagoTarjeta() {
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
    public void TestNombreBanco(){
        CreditCard t = new CreditCard();
        int id_reserva = 1;
        double precio = rdao.leerReserva(id_reserva).getPrecio() + rdao.leerReserva(id_reserva).getIva();
        t.setNombreBanco("-Seleccione una opción-");
        t.setMarcaInternacional("AMERICAN EXPRESS");
        t.setNombreTitular("David");
        t.setNumeroTarjeta("1234567890123456");
        t.setMesExpiracion("11");
        t.setAñoExpiracion("09");
        t.setNumeroSeguridad("155");
        
        assertEquals(BNAME_ERROR, validarPagoTarjeta.verificarPagoTarjeta(id_reserva,t, precio));
        
        id_reserva = 2;
        precio = rdao.leerReserva(id_reserva).getPrecio() + rdao.leerReserva(id_reserva).getIva();
        t.setNombreBanco("-Seleccione una opción-");
        t.setMarcaInternacional("MASTERCARD");
        t.setNombreTitular("Michael");
        t.setNumeroTarjeta("2938501927592648");
        t.setMesExpiracion("12");
        t.setAñoExpiracion("88");
        t.setNumeroSeguridad("192");
        
        assertEquals(BNAME_ERROR, validarPagoTarjeta.verificarPagoTarjeta(id_reserva,t, precio));
    }
    
    @Test
    public void TestMarcaInternacional(){
        CreditCard t = new CreditCard();
        int id_reserva = 1;
        double precio = rdao.leerReserva(id_reserva).getPrecio() + rdao.leerReserva(id_reserva).getIva();
        t.setNombreBanco("Banco Popular");
        t.setMarcaInternacional("-Seleccione una opción-");
        t.setNombreTitular("Diego");
        t.setNumeroTarjeta("9988776655443322");
        t.setMesExpiracion("01");
        t.setAñoExpiracion("17");
        t.setNumeroSeguridad("163");
        
        assertEquals(MARCA_ERROR, validarPagoTarjeta.verificarPagoTarjeta(id_reserva,t, precio));
        
        id_reserva = 2;
        precio = rdao.leerReserva(id_reserva).getPrecio() + rdao.leerReserva(id_reserva).getIva();
        t.setNombreBanco("AV Villas");
        t.setMarcaInternacional("-Seleccione una opción-");
        t.setNombreTitular("Karen");
        t.setNumeroTarjeta("1324354657687980");
        t.setMesExpiracion("11");
        t.setAñoExpiracion("23");
        t.setNumeroSeguridad("394");
        
        assertEquals(MARCA_ERROR, validarPagoTarjeta.verificarPagoTarjeta(id_reserva,t, precio));
    }
    
    @Test
    public void TestNombreTitular(){
        CreditCard t = new CreditCard();
        int id_reserva = 1;
        double precio = rdao.leerReserva(id_reserva).getPrecio() + rdao.leerReserva(id_reserva).getIva();
        t.setNombreBanco("AV Villas");
        t.setMarcaInternacional("DINERS CLUB");
        t.setNombreTitular("6");
        t.setNumeroTarjeta("3827564817263458");
        t.setMesExpiracion("04");
        t.setAñoExpiracion("27");
        t.setNumeroSeguridad("1068");
        
        assertEquals(TNAME_ERROR, validarPagoTarjeta.verificarPagoTarjeta(id_reserva,t, precio));
        
        id_reserva = 3;
        precio = rdao.leerReserva(id_reserva).getPrecio();
        t.setNombreBanco("Bancolombia");
        t.setMarcaInternacional("VISA");
        t.setNombreTitular("Adolph Blaine Charles David Earl Frederick Gerald Hubert Irvin");
        t.setNumeroTarjeta("3827145809506830");
        t.setMesExpiracion("09");
        t.setAñoExpiracion("44");
        t.setNumeroSeguridad("192");
        
        assertEquals(TNAME_ERROR, validarPagoTarjeta.verificarPagoTarjeta(id_reserva,t, precio));
    }
    
    @Test
    public void TestExistenciaTitular(){
        CreditCard t = new CreditCard();
        int id_reserva = 1;
        double precio = rdao.leerReserva(id_reserva).getPrecio() + rdao.leerReserva(id_reserva).getIva();
        t.setNombreBanco("BBVA");
        t.setMarcaInternacional("VISA");
        t.setNombreTitular("Luis Alberto");
        t.setNumeroTarjeta("1192662883726048");
        t.setMesExpiracion("07");
        t.setAñoExpiracion("27");
        t.setNumeroSeguridad("111111");
        
        assertEquals(T_EXISTENCE, validarPagoTarjeta.verificarPagoTarjeta(id_reserva,t, precio));
        
        id_reserva = 1;
        precio = rdao.leerReserva(id_reserva).getPrecio();
        t.setNombreBanco("Banco Popular");
        t.setMarcaInternacional("AMERICAN EXPRESS");
        t.setNombreTitular("Alan Brito Delgado");
        t.setNumeroTarjeta("7911202484660289");
        t.setMesExpiracion("05");
        t.setAñoExpiracion("89");
        t.setNumeroSeguridad("1234");
        
        assertEquals(T_EXISTENCE, validarPagoTarjeta.verificarPagoTarjeta(id_reserva,t, precio));
    }
    
    @Test
    public void TestVerificarNumeroTarjeta(){
        CreditCard t = new CreditCard();
        int id_reserva = 3;
        double precio = rdao.leerReserva(id_reserva).getPrecio() + rdao.leerReserva(id_reserva).getIva();
        t.setNombreBanco("Bancolombia");
        t.setMarcaInternacional("VISA");
        t.setNombreTitular("Fernando Salazar");
        t.setNumeroTarjeta("1234");
        t.setMesExpiracion("07");
        t.setAñoExpiracion("22");
        t.setNumeroSeguridad("137");
        
        assertEquals(CARD_N_ERROR, validarPagoTarjeta.verificarPagoTarjeta(id_reserva,t, precio));
        
        id_reserva = 2;
        precio = rdao.leerReserva(id_reserva).getPrecio();
        t.setNombreBanco("AV Villas");
        t.setMarcaInternacional("MASTERCARD");
        t.setNombreTitular("Juan Alberto");
        t.setNumeroTarjeta("123098");
        t.setMesExpiracion("12");
        t.setAñoExpiracion("12");
        t.setNumeroSeguridad("777");
        
        assertEquals(CARD_N_ERROR, validarPagoTarjeta.verificarPagoTarjeta(id_reserva,t, precio));
    }
    
    @Test
    public void TestVerificarExistenciaTarjeta(){
        CreditCard t = new CreditCard();
        int id_reserva = 1;
        double precio = rdao.leerReserva(id_reserva).getPrecio() + rdao.leerReserva(id_reserva).getIva();
        t.setNombreBanco("Banco Popular");
        t.setMarcaInternacional("AMERICAN EXPRESS");
        t.setNombreTitular("Juan Alberto");
        t.setNumeroTarjeta("0000000000000000");
        t.setMesExpiracion("12");
        t.setAñoExpiracion("88");
        t.setNumeroSeguridad("395u");
        
        assertEquals(CARD_E_ERROR, validarPagoTarjeta.verificarPagoTarjeta(id_reserva,t, precio));
        
        id_reserva = 3;
        precio = rdao.leerReserva(id_reserva).getPrecio();
        t.setNombreBanco("BBVA");
        t.setMarcaInternacional("VISA");
        t.setNombreTitular("Miguel");
        t.setNumeroTarjeta("9999999999999999");
        t.setMesExpiracion("02");
        t.setAñoExpiracion("77");
        t.setNumeroSeguridad("1048");
        
        assertEquals(CARD_E_ERROR, validarPagoTarjeta.verificarPagoTarjeta(id_reserva,t, precio));
    }
    
    @Test
    public void TestVerificarMesExpiracion(){
        CreditCard t = new CreditCard();
        int id_reserva = 2;
        double precio = rdao.leerReserva(id_reserva).getPrecio() + rdao.leerReserva(id_reserva).getIva();
        t.setNombreBanco("Banco Popular");
        t.setMarcaInternacional("AMERICAN EXPRESS");
        t.setNombreTitular("José Miguel");
        t.setNumeroTarjeta("4545457878121223");
        t.setMesExpiracion("ax78");
        t.setAñoExpiracion("99");
        t.setNumeroSeguridad("283");
        
        assertEquals(MES_ERROR, validarPagoTarjeta.verificarPagoTarjeta(id_reserva,t, precio));
        
        id_reserva = 3;
        precio = rdao.leerReserva(id_reserva).getPrecio();
        t.setNombreBanco("Bancolombia");
        t.setMarcaInternacional("VISA");
        t.setNombreTitular("Fernando Salazar");
        t.setNumeroTarjeta("1234567890456789");
        t.setMesExpiracion("9999");
        t.setAñoExpiracion("25");
        t.setNumeroSeguridad("101");
        
        assertEquals(MES_ERROR, validarPagoTarjeta.verificarPagoTarjeta(id_reserva,t, precio));
    }
    
    @Test
    public void TestExistenciaMesExpiracion(){
        CreditCard t = new CreditCard();
        int id_reserva = 1;
        double precio = rdao.leerReserva(id_reserva).getPrecio() + rdao.leerReserva(id_reserva).getIva();
        t.setNombreBanco("Bancolombia");
        t.setMarcaInternacional("DINERS CLUB");
        t.setNombreTitular("Nicolás");
        t.setNumeroTarjeta("1234567891234567");
        t.setMesExpiracion("02");
        t.setAñoExpiracion("23");
        t.setNumeroSeguridad("104");
        
        assertEquals(MES_EXIST, validarPagoTarjeta.verificarPagoTarjeta(id_reserva,t, precio));
        
        id_reserva = 3;
        precio = rdao.leerReserva(id_reserva).getPrecio();
        t.setNombreBanco("BBVA");
        t.setMarcaInternacional("VISA");
        t.setNombreTitular("Miguel");
        t.setNumeroTarjeta("1234567890123456");
        t.setMesExpiracion("07");
        t.setAñoExpiracion("23");
        t.setNumeroSeguridad("105");
        
        assertEquals(MES_EXIST, validarPagoTarjeta.verificarPagoTarjeta(id_reserva,t, precio));
    }
    
    @Test
    public void TestVerificarAñoExpiracion(){
        CreditCard t = new CreditCard();
        int id_reserva = 1;
        double precio = rdao.leerReserva(id_reserva).getPrecio() + rdao.leerReserva(id_reserva).getIva();
        t.setNombreBanco("AV Villas");
        t.setMarcaInternacional("MASTERCARD");
        t.setNombreTitular("Juan Alberto");
        t.setNumeroTarjeta("1234567890456789");
        t.setMesExpiracion("03");
        t.setAñoExpiracion("777");
        t.setNumeroSeguridad("101");
        
        assertEquals(AÑO_ERROR, validarPagoTarjeta.verificarPagoTarjeta(id_reserva,t, precio));
        
        id_reserva = 3;
        precio = rdao.leerReserva(id_reserva).getPrecio();
        t.setNombreBanco("Bancolombia");
        t.setMarcaInternacional("DINERS CLUB");
        t.setNombreTitular("Nicolás");
        t.setNumeroTarjeta("1234567891234567");
        t.setMesExpiracion("01");
        t.setAñoExpiracion("ffffff");
        t.setNumeroSeguridad("108");
        
        assertEquals(AÑO_ERROR, validarPagoTarjeta.verificarPagoTarjeta(id_reserva,t, precio));
    }
    
    @Test
    public void TestVerificarExistenciaAñoExpiracion(){
        CreditCard t = new CreditCard();
        int id_reserva = 1;
        double precio = rdao.leerReserva(id_reserva).getPrecio() + rdao.leerReserva(id_reserva).getIva();
        t.setNombreBanco("Bancolombia");
        t.setMarcaInternacional("VISA");
        t.setNombreTitular("Fernando Salazar");
        t.setNumeroTarjeta("1234567890456789");
        t.setMesExpiracion("01");
        t.setAñoExpiracion("26");
        t.setNumeroSeguridad("101");
        
        assertEquals(AÑO_EXIST, validarPagoTarjeta.verificarPagoTarjeta(id_reserva,t, precio));
        
        id_reserva = 2;
        precio = rdao.leerReserva(id_reserva).getPrecio();
        t.setNombreBanco("Bancolombia");
        t.setMarcaInternacional("VISA");
        t.setNombreTitular("Fernando Salazar");
        t.setNumeroTarjeta("1234567890456789");
        t.setMesExpiracion("01");
        t.setAñoExpiracion("17");
        t.setNumeroSeguridad("101");
        
        assertEquals(AÑO_EXIST, validarPagoTarjeta.verificarPagoTarjeta(id_reserva,t, precio));
    }
    
    @Test
    public void TestVerificarNumeroSeguridad(){
        CreditCard t = new CreditCard();
        int id_reserva = 1;
        double precio = rdao.leerReserva(id_reserva).getPrecio() + rdao.leerReserva(id_reserva).getIva();
        t.setNombreBanco("Bancolombia");
        t.setMarcaInternacional("DINERS CLUB");
        t.setNombreTitular("Nicolás");
        t.setNumeroTarjeta("1234567891234567");
        t.setMesExpiracion("01");
        t.setAñoExpiracion("23");
        t.setNumeroSeguridad("114");
        
        assertEquals(NUM_SEG_ERROR, validarPagoTarjeta.verificarPagoTarjeta(id_reserva,t, precio));
        
        id_reserva = 2;
        precio = rdao.leerReserva(id_reserva).getPrecio();
        t.setNombreBanco("AV Villas");
        t.setMarcaInternacional("MASTERCARD");
        t.setNombreTitular("Juan Alberto");
        t.setNumeroTarjeta("1234567890456789");
        t.setMesExpiracion("03");
        t.setAñoExpiracion("23");
        t.setNumeroSeguridad("102313");
        
        assertEquals(NUM_SEG_ERROR, validarPagoTarjeta.verificarPagoTarjeta(id_reserva,t, precio));
    }
    
    @Test
    public void TestVerificarTarjeta(){
        CreditCard t = new CreditCard();
        int id_reserva = 3;
        double precio = rdao.leerReserva(id_reserva).getPrecio() + rdao.leerReserva(id_reserva).getIva();
        t.setNombreBanco("BBVA ES UN BANCO");
        t.setMarcaInternacional("VISA");
        t.setNombreTitular("Miguel");
        t.setNumeroTarjeta("1234567890123456");
        t.setMesExpiracion("01");
        t.setAñoExpiracion("23");
        t.setNumeroSeguridad("105");
        
        assertEquals(VERIFY_CARD, validarPagoTarjeta.verificarPagoTarjeta(id_reserva,t, precio));
        
        id_reserva = 2;
        precio = rdao.leerReserva(id_reserva).getPrecio();
        t.setNombreBanco("AV Villas");
        t.setMarcaInternacional("MASTERCARD Y AMERICAN EXPRESS");
        t.setNombreTitular("Juan Alberto");
        t.setNumeroTarjeta("1234567891234567");
        t.setMesExpiracion("03");
        t.setAñoExpiracion("23");
        t.setNumeroSeguridad("102");
        
        assertEquals(VERIFY_CARD, validarPagoTarjeta.verificarPagoTarjeta(id_reserva,t, precio));
    }
    
    @Test
    public void TestValidarCompra(){
        CreditCard t = new CreditCard();
        int id_reserva = 8;
        double precio = rdao.leerReserva(id_reserva).getPrecio() + rdao.leerReserva(id_reserva).getIva();
        t.setNombreBanco("AV Villas");
        t.setMarcaInternacional("MASTERCARD");
        t.setNombreTitular("Juan Alberto");
        t.setNumeroTarjeta("1234567891234567");
        t.setMesExpiracion("03");
        t.setAñoExpiracion("23");
        t.setNumeroSeguridad("102");
        CreditCard t2 = tdao.leernumtarjeta(t.getNumeroTarjeta());
        t.setCupoGastado(t2.getCupoGastado());
        t.setCupoMaximo(t2.getCupoMaximo());
        
        assertEquals(VAL_COMPRA, validarPagoTarjeta.verificarPagoTarjeta(id_reserva,t, precio));
        
        id_reserva = 8;
        precio = rdao.leerReserva(id_reserva).getPrecio();
        t.setNombreBanco("AV Villas");
        t.setMarcaInternacional("MASTERCARD");
        t.setNombreTitular("Juan Alberto");
        t.setNumeroTarjeta("1234567891234567");
        t.setMesExpiracion("03");
        t.setAñoExpiracion("23");
        t.setNumeroSeguridad("102");
        t2 = tdao.leernumtarjeta(t.getNumeroTarjeta());
        t.setCupoGastado(t2.getCupoGastado());
        t.setCupoMaximo(t2.getCupoMaximo());
        assertEquals(VAL_COMPRA, validarPagoTarjeta.verificarPagoTarjeta(id_reserva,t, precio));
    }
    
        @Test
        public void TestAllCorrect(){
        CreditCard t = new CreditCard();
        int id_reserva = 1;
        double precio = rdao.leerReserva(id_reserva).getPrecio() + rdao.leerReserva(id_reserva).getIva();
        t.setNombreBanco("AV Villas");
        t.setMarcaInternacional("MASTERCARD");
        t.setNombreTitular("Juan Alberto");
        t.setNumeroTarjeta("1234567891234567");
        t.setMesExpiracion("03");
        t.setAñoExpiracion("23");
        t.setNumeroSeguridad("102");
        CreditCard t2 = tdao.leernumtarjeta(t.getNumeroTarjeta());
        t.setCupoGastado(t2.getCupoGastado());
        t.setCupoMaximo(t2.getCupoMaximo());
        assertEquals(SUCCESS, validarPagoTarjeta.verificarPagoTarjeta(id_reserva,t, precio));
        
        id_reserva = 1;
        precio = rdao.leerReserva(id_reserva).getPrecio();
        t.setNombreBanco("Bancolombia");
        t.setMarcaInternacional("VISA");
        t.setNombreTitular("Fernando Salazar");
        t.setNumeroTarjeta("1234567890456789");
        t.setMesExpiracion("01");
        t.setAñoExpiracion("25");
        t.setNumeroSeguridad("101");
        t2 = tdao.leernumtarjeta(t.getNumeroTarjeta());
        t.setCupoGastado(t2.getCupoGastado());
        t.setCupoMaximo(t2.getCupoMaximo());
        
        assertEquals(SUCCESS, validarPagoTarjeta.verificarPagoTarjeta(id_reserva,t, precio));
    }
}
