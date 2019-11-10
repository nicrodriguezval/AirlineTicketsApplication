/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.CreditCardDAO;
import DAO.UsuarioDAO;
import DAO.VueloDAO;
import Entidad.CreditCard;
import Entidad.Usuario;
import Entidad.Vuelo;
import static Frontera.FramePrincipal.idVuelo;
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
        
        UsuarioDAO udao = new UsuarioDAO();
        CreditCardDAO tdao = new CreditCardDAO();
        VueloDAO vdao = new VueloDAO();
        
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
            //udao.crear(u); //ELEMENTOS YA AÑADIDOS A LA BASE DE DATOS
        }
        
        ArrayList<CreditCard> tarjetas = new ArrayList<CreditCard>();
        
        CreditCard t1 = new CreditCard("Bancolombia", "10/10/2020", "Nicolás Rodríguez", "VISA", "656412345874569");
        CreditCard t2 = new CreditCard("AV Villas", "2/1/2021", "Juan Alberto", "MASTERCARD", "1234567891234567");
        CreditCard t3 = new CreditCard("Banco Popular", "1/11/2019", "José Miguel", "VISA", "4545457878121223");
        
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
            //tdao.crear(t); //ELEMENTOS YA AÑADIDOS A LA BASE DE DATOS
        }

        ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
        
        Vuelo v1 = new Vuelo(idVuelo++, "Bogotá", "Medellín", "01/1/2020", "14:00");
        Vuelo v2 = new Vuelo(idVuelo++, "Madrid", "Miami", "30/12/2019", "3:00");
        Vuelo v3 = new Vuelo(idVuelo++, "Cali", "Bucaramanga", "01/12/2019", "9:00");
        

        v1.setSillasTotales(300);
        v2.setSillasTotales(400);
        v3.setSillasTotales(300);
        
        Vuelo v4 = new Vuelo(idVuelo++, "Medellín", "Bogotá", "05/1/2020", "12:00");
        Vuelo v5 = new Vuelo(idVuelo++, "Miami", "Madrid", "15/1/2020", "5:00");
        Vuelo v6 = new Vuelo(idVuelo++, "Bucaramanga", "Cali", "15/12/2019", "11:00");
        

        v4.setSillasTotales(400);
        v5.setSillasTotales(500);
        v6.setSillasTotales(200);
        
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
            //vdao.crear(v); //ELEMENTOS YA AÑADIDOS A LA BASE DE DATOS
        }
    }
}
