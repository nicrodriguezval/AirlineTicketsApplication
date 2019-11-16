/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.CreditCardDAO;
import DAO.ReservaDAO;
import DAO.UsuarioDAO;
import DAO.VueloDAO;
import Entidad.CreditCard;
import Entidad.Reserva;
import Entidad.Usuario;
import Entidad.Vuelo;
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
        
        int idVuelo = 1;

        UsuarioDAO udao = new UsuarioDAO();
        CreditCardDAO tdao = new CreditCardDAO();
        VueloDAO vdao = new VueloDAO();
        ReservaDAO rdao = new ReservaDAO();
        
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
        //sistema.addUsuarios(a);
        //sistema.addUsuarios(b);
        //sistema.addUsuarios(c);
        
        System.out.println("USUARIOS EXISTENTES");
        System.out.println();
        
        //for(Usuario u : sistema.getUsuarios()) {
        for(Usuario u: usuarios){
            System.out.println("Nombre(s): " + u.getNombre());
            System.out.println("Apellido(s): " + u.getApellido());
            System.out.println("Username: " + u.getUsername());
            System.out.println("-------");
            udao.crear(u); //ELEMENTOS YA AÑADIDOS A LA BASE DE DATOS
        }
        
        ArrayList<CreditCard> tarjetas = new ArrayList<CreditCard>();
        
        CreditCard t1 = new CreditCard("Bancolombia", "10/10/2020", "Nicolás Rodríguez", "VISA", "6564123458745691");
        CreditCard t2 = new CreditCard("AV Villas", "2/1/2021", "Juan Alberto", "MASTERCARD", "1234567891234567");
        CreditCard t3 = new CreditCard("Banco Popular", "1/11/2019", "José Miguel", "VISA", "4545457878121223");
        
        t1.setCupoGastado(100.2);
        t1.setCupoMaximo(3000);
        
        t2.setCupoGastado(1000);
        t2.setCupoMaximo(3500);
        
        t3.setCupoGastado(0);
        t3.setCupoMaximo(2000);
        
        //sistema.addTarjetas(t1);
        //sistema.addTarjetas(t2);
        //sistema.addTarjetas(t3);
        tarjetas.add(t1);
        tarjetas.add(t2);
        tarjetas.add(t3);
        
        System.out.println();
        System.out.println("TARJETAS DE CRÉDITO EXISTENTES");
        System.out.println();
        
        //for(CreditCard t : sistema.getTarjetas()) {
        for(CreditCard t : tarjetas){
            System.out.println("Nombre del banco: " + t.getNombreBanco());
            System.out.println("Nombre del titular: " + t.getNombreTitular());
            System.out.println("Numero de la tarjeta: " + t.getNumeroTarjeta());
            System.out.println("Marca internacional: " + t.getMarcaInternacional());
            System.out.println("Fecha de caducidad: " + t.getFechaCaducidad());
            System.out.println("-------");
            tdao.crear(t); //ELEMENTOS YA AÑADIDOS A LA BASE DE DATOS
        }

        ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
        
        Vuelo v1 = new Vuelo("Bogotá", "Medellín", "01/01/2020", "14:00",100,500,1000,300);
        Vuelo v2 = new Vuelo("Madrid", "Miami", "30/12/2019", "3:00",100,500,1000,400);
        Vuelo v3 = new Vuelo("Cali", "Bucaramanga", "01/12/2019", "9:00",100,500,1000,300);
        
        Vuelo v4 = new Vuelo("Medellín", "Bogotá", "05/01/2020", "12:00",100,500,1000,400);
        Vuelo v5 = new Vuelo("Miami", "Madrid", "15/01/2020", "5:00",100,500,1000,500);
        Vuelo v6 = new Vuelo("Bucaramanga", "Cali", "15/12/2019", "11:00",100,500,1000,200);
        
        //TRES VUELOS DE IDA DESDE BOGOTÁ HASTA MEDELLÍN EL MISMO DÍA, A DIFERENTES HORAS
        Vuelo v7 = new Vuelo("Bogotá", "Medellín", "01/01/2020", "16:00",100,500,1000,300);
        Vuelo v8 = new Vuelo("Bogotá", "Medellín", "01/01/2020", "18:00",100,500,1000,300);
        //TRES VUELOS MÁS DESDE BOGOTÁ HACIA DEDELLÍN, EL SIGUIENTE DÍA, A DIFERENTES HORAS
        Vuelo v9 = new Vuelo("Bogotá", "Medellín", "02/01/2020", "12:00",100,500,1000,300);
        Vuelo v10 = new Vuelo("Bogotá", "Medellín", "02/01/2020", "13:00",100,500,1000,300);
        Vuelo v11 = new Vuelo("Bogotá", "Medellín", "02/01/2020", "15:00",100,500,1000,300);
        //DOS UBICACIONES MÁS DESDE BOGOTÁ: MIAMI Y BUCARAMANGA
        Vuelo v12 = new Vuelo("Bogotá", "Miami", "01/01/2020", "20:00",100,500,1000,300);
        Vuelo v13 = new Vuelo("Bogotá", "Bucaramanga", "01/01/2020", "18:00",100,500,1000,300);
        //LOS VUELOS DE VUELTA PAR LOS ULTIMOS DOS
        Vuelo v14 = new Vuelo("Miami","Bogotá","01/05/2020", "23:00",100,500,1000,300);
        Vuelo v15 = new Vuelo("Bucaramanga","Bogotá", "01/06/2020", "6:00",100,500,1000,300);
        //sistema.addVuelos(v1);
        //sistema.addVuelos(v2);
        //sistema.addVuelos(v3);
        //sistema.addVuelos(v4);
        //sistema.addVuelos(v5);
        //sistema.addVuelos(v6);
        vuelos.add(v1);
        vuelos.add(v2);
        vuelos.add(v3);
        vuelos.add(v4);
        vuelos.add(v5);
        vuelos.add(v6);
        vuelos.add(v7);
        vuelos.add(v8);
        vuelos.add(v9);
        vuelos.add(v10);
        vuelos.add(v11);
        vuelos.add(v12);
        vuelos.add(v13);
        vuelos.add(v14);
        vuelos.add(v15);
        
        System.out.println();
        System.out.println("VUELOS DISPONIBLES");
        System.out.println();
        
        //for(Vuelo v : sistema.getVuelos()) {
        for(Vuelo v : vuelos){
            System.out.println("ID vuelo: " + v.getId());
            System.out.println("Ciudad de origen: " + v.getOrigen());
            System.out.println("Ciudad de destino: " + v.getDestino());
            System.out.println("Fecha del vuelo: " + v.getFecha());
            System.out.println("Hora del vuelo: " + v.getHora());
            System.out.println("Asientos disponibles: " + v.getSillasTotales());
            System.out.println("-------");
            vdao.crear(v); //ELEMENTOS YA AÑADIDOS A LA BASE DE DATOS
        }
       
/*        ArrayList<Reserva> reservas = new ArrayList<Reserva>();
        
        Reserva r1 = new Reserva(v1,1,true,true,20,"Turista",a);
        Reserva r2 = new Reserva(v2,2,true,false,0,"Ejecutiva",b);
        Reserva r3 = new Reserva(v3,3,false,true,10,"Primera clase",c);
         
        r1.setId(10);
        r1.setCategoriaVuelta("Ejecutiva");
        r1.setEquipajeVuelta(true);
        r1.setNumeroPuestosvuelta(1);
        r1.setPesoVuelta(30);
        r1.setVueloVuelta(v4);
        r1.setNumeroPuestosvuelta(1);
        r1.setIva(19.0);
        int[] puestos = new int[] {1};;
        r1.setPuestosIda(puestos);
        
        rdao.crear(r1);
         
        /*reservas.add(r1);
        reservas.add(r2);
        reservas.add(r3);
         
        System.out.println();
        System.out.println("RESERVAS REGISTRADAS");
        System.out.println();
        
        
        for(Reserva r : reservas){
            System.out.println("ID reserva: " + r.getId());
            System.out.println("Vuelo de ida: " + r.getVueloIda());
            System.out.println("Vuelo de vuelta: " + r.getVueloVuelta());
            System.out.println("Número de asientos ida: " + r.getNumeroPuestos());
            System.out.println("Numero de asientos vuelta: " + r.getNumeroPuestosVuelta());
            System.out.println("Categoría vuelo ida: " + r.getCategoria());
            System.out.println("Categoría vuelo vuelta: " + r.getCategoriaVuelta());
            System.out.println("Peso equipaje ida: " + r.getPeso());
            System.out.println("Peso equipaje vuelta: " + r.getPesoVuelta());

            System.out.println("");
            System.out.println("");
            System.out.println("-------");
            //.crear(r1); //ELEMENTOS YA AÑADIDOS A LA BASE DE DATOS
        }*/
        
    }
}
