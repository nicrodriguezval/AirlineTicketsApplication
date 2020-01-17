/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.CreditCardDAO;
import DAO.ReservaDAO;
import DAO.TicketDAO;
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
        
        UsuarioDAO udao = new UsuarioDAO();
        CreditCardDAO tdao = new CreditCardDAO();
        VueloDAO vdao = new VueloDAO();
        ReservaDAO rdao = new ReservaDAO();
        TicketDAO tckdao = new TicketDAO();
        
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        
        Usuario admin = new Usuario();
        Usuario a = new Usuario();
        Usuario b = new Usuario();
        Usuario c = new Usuario();
        Usuario d = new Usuario();
        
        admin.setNombre("admin");
        admin.setUsername("admin");
        admin.setPassword("admin");
        
        a.setNombre("Nicolás");
        a.setApellido("Rodríguez");
        a.setEmail("nicrodriguezval@unal.edu.co");
        a.setUsername("nicrodriguezval");
        a.setPassword("123123");
        a.setPoints(1010);
        
        b.setNombre("Lucas");
        b.setApellido("Peña");
        b.setEmail("lucas@gmail.com");
        b.setUsername("lucasps");
        b.setPassword("123456");
        b.setPoints(700);
        
        c.setNombre("Juan");
        c.setApellido("Tovar");
        c.setEmail("juancho@hotmail.com");
        c.setUsername("juancho01");
        c.setPassword("a1b2c3");
        c.setPoints(53);
        
        d.setNombre("Miguel");
        d.setApellido("Peña");
        d.setEmail("miapenahu@unal.edu.co");
        d.setUsername("miapenahu");
        d.setPassword("Abcd1234");
        d.setPoints(1200);
        
        usuarios.add(admin);
        usuarios.add(a);
        usuarios.add(b);
        usuarios.add(c);
        usuarios.add(d);
        
        System.out.println("USUARIOS EXISTENTES");
        System.out.println();

        for(Usuario u: usuarios){
            System.out.println("Nombre(s): " + u.getNombre());
            System.out.println("Apellido(s): " + u.getApellido());
            System.out.println("Username: " + u.getUsername());
            System.out.println("-------");
            udao.crear(u); //ELEMENTOS YA AÑADIDOS A LA BASE DE DATOS
        }
        
        ArrayList<CreditCard> tarjetas = new ArrayList<CreditCard>();
        
        CreditCard t1 = new CreditCard("Bancolombia", "VISA", "01", "25", "Fernando Salazar", "1234567890456789", "101");
        CreditCard t2 = new CreditCard("AV Villas", "MASTERCARD","03","23", "Juan Alberto", "1234567891234567","102");
        CreditCard t3 = new CreditCard("Banco Popular", "AMERICAN EXPRESS","11","19", "José Miguel","4545457878121223","103");
        CreditCard t4 = new CreditCard("Bancolombia", "DINERS CLUB","01","23", "Nicolás", "1234567891234567","104");
        CreditCard t5 = new CreditCard("BBVA", "VISA","01","23", "Miguel", "1234567890123456","105");
        
        t1.setCupoGastado(100.2);
        t1.setCupoMaximo(3000);
        
        t2.setCupoGastado(1000);
        t2.setCupoMaximo(3500);
        
        t3.setCupoGastado(0);
        t3.setCupoMaximo(2000);
        
        t4.setCupoGastado(0);
        t4.setCupoMaximo(20000);
        
        t5.setCupoGastado(0);
        t5.setCupoMaximo(20000);
        
        tarjetas.add(t1);
        tarjetas.add(t2);
        tarjetas.add(t3);
        tarjetas.add(t4);
        tarjetas.add(t5);
        
        System.out.println();
        System.out.println("TARJETAS DE CRÉDITO EXISTENTES");
        System.out.println();
        
        for(CreditCard t : tarjetas){
            System.out.println("Nombre del banco: " + t.getNombreBanco());
            System.out.println("Nombre del titular: " + t.getNombreTitular());
            System.out.println("Numero de la tarjeta: " + t.getNumeroTarjeta());
            System.out.println("Marca internacional: " + t.getMarcaInternacional());
            System.out.println("Fecha de caducidad: " + t.getMesExpiracion() + "/"+ t.getAñoExpiracion());
            System.out.println("-------");
            tdao.crear(t); //ELEMENTOS YA AÑADIDOS A LA BASE DE DATOS
        }

        
        ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
       
        double bog_med_t = 27.51;
        double bog_med_e = 67.34;
        double bog_med_p = bog_med_t*5;
        int bog_med_miles = 153;
        String ciudad_o = "Bogotá";
        String ciudad_d = "Medellín";
        
        String fecha = "01/03/2020"; 
        
        Vuelo v1 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v2 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v3 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v4 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v5 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v6 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        
        Vuelo v7 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v8 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v9 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v10 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v11 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v12 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        
        Vuelo v13 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v14 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v15 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v16 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v17 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v18 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        
        fecha = "02/03/2020";
        
        Vuelo v21 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v22 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v23 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v24 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v25 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v26 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        
        Vuelo v27 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v28 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v29 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v30 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v31 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v32 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        
        Vuelo v33 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v34 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v35 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v36 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v37 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v38 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        
        fecha = "03/03/2020";
        
        Vuelo v41 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v42 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v43 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v44 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v45 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v46 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        
        Vuelo v47 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v48 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v49 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v50 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v51 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v52 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        
        Vuelo v53 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v54 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v55 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v56 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v57 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v58 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles); 
        
        fecha = "04/03/2020";
        
        Vuelo v61 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v62 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v63 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v64 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v65 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v66 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        
        Vuelo v67 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v68 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v69 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v70 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v71 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v72 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        
        Vuelo v73 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v74 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v75 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v76 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v77 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v78 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles); 
        
        fecha = "05/03/2020";
        
        Vuelo v81 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v82 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v83 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v84 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v85 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v86 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        
        Vuelo v87 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v88 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v89 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v90 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v91 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v92 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        
        Vuelo v93 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v94 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v95 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v96 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v97 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v98 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles); 
        
        fecha = "06/03/2020";
        
        Vuelo v101 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v102 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v103 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v104 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v105 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v106 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        
        Vuelo v107 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v108 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v109 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v110 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v111 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v112 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        
        Vuelo v113 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v114 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v115 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v116 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v117 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v118 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles); 
        
        fecha = "07/03/2020";
        
        Vuelo v121 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v122 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v123 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v124 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v125 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v126 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
       
        Vuelo v127 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v128 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v129 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v130 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v131 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v132 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
       
        Vuelo v133 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v134 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v135 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v136 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v137 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v138 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        
        fecha = "08/03/2020";
        
        Vuelo v141 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v142 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v143 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v144 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v145 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v146 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
       
        Vuelo v147 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v148 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v149 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v150 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v151 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v152 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
       
        Vuelo v153 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v154 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v155 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v156 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v157 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v158 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        
        fecha = "09/03/2020";
        
        Vuelo v161 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v162 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v163 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v164 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v165 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v166 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
  
        Vuelo v167 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v168 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v169 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v170 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v171 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v172 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
       
        Vuelo v173 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v174 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v175 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v176 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v177 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v178 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        
        fecha = "10/03/2020";
        
        Vuelo v181 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v182 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v183 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v184 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v185 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v186 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
       
        Vuelo v187 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v188 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v189 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v190 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v191 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v192 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
       
        Vuelo v193 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v194 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v195 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v196 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v197 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v198 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);

        ciudad_o = "Medellín";
        ciudad_d = "Bogotá";
        
        fecha = "01/03/2020";
        
        Vuelo v301 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v302 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v303 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v304 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v305 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v306 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        
        Vuelo v307 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v308 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v309 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v310 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v311 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v312 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        
        Vuelo v313 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v314 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v315 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v316 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v317 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v318 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles); 
        
        fecha = "02/03/2020";
        
        Vuelo v321 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v322 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v323 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v324 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v325 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v326 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
       
        Vuelo v327 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v328 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v329 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v330 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v331 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v332 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
       
        Vuelo v333 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v334 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v335 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v336 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v337 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v338 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        
        fecha = "03/03/2020";
        
        Vuelo v341 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v342 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v343 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v344 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v345 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v346 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
       
        Vuelo v347 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v348 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v349 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v350 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v351 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v352 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
       
        Vuelo v353 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v354 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v355 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v356 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v357 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v358 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        
        fecha = "04/03/2020";
        
        Vuelo v361 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v362 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v363 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v364 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v365 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v366 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
  
        Vuelo v367 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v368 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v369 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v370 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v371 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v372 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
       
        Vuelo v373 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v374 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v375 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v376 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v377 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v378 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        
        fecha = "05/03/2020";
        
        Vuelo v381 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v382 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v383 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v384 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v385 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v386 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
       
        Vuelo v387 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v388 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v389 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v390 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v391 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v392 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
       
        Vuelo v393 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v394 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v395 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v396 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v397 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v398 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        
        fecha = "06/03/2020";
        
        Vuelo v401 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v402 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v403 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v404 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v405 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v406 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        
        Vuelo v407 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v408 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v409 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v410 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v411 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v412 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        
        Vuelo v413 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v414 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v415 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v416 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v417 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v418 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles); 
        
        fecha = "07/03/2020";
        
        Vuelo v421 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v422 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v423 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v424 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v425 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v426 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
       
        Vuelo v427 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v428 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v429 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v430 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v431 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v432 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
       
        Vuelo v433 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v434 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v435 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v436 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v437 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v438 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        
        fecha = "08/03/2020";
        
        Vuelo v441 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v442 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v443 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v444 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v445 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v446 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
       
        Vuelo v447 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v448 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v449 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v450 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v451 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v452 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
       
        Vuelo v453 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v454 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v455 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v456 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v457 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v458 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        
        fecha = "09/03/2020";
        
        Vuelo v461 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v462 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v463 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v464 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v465 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v466 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
  
        Vuelo v467 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v468 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v469 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v470 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v471 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v472 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
       
        Vuelo v473 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v474 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v475 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v476 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v477 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v478 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        
        fecha = "10/03/2020";
        
        Vuelo v481 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v482 = new Vuelo(ciudad_o, ciudad_d, fecha, "05:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v483 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v484 = new Vuelo(ciudad_o, ciudad_d, fecha, "06:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v485 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v486 = new Vuelo(ciudad_o, ciudad_d, fecha, "07:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
       
        Vuelo v487 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v488 = new Vuelo(ciudad_o, ciudad_d, fecha, "11:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v489 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v490 = new Vuelo(ciudad_o, ciudad_d, fecha, "12:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v491 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v492 = new Vuelo(ciudad_o, ciudad_d, fecha, "13:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
       
        Vuelo v493 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v494 = new Vuelo(ciudad_o, ciudad_d, fecha, "18:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v495 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v496 = new Vuelo(ciudad_o, ciudad_d, fecha, "19:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v497 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:00",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        Vuelo v498 = new Vuelo(ciudad_o, ciudad_d, fecha, "20:30",bog_med_t,bog_med_e,bog_med_p,300, bog_med_miles);
        
        /*
        Vuelo v1 = new Vuelo("Bogotá", "Medellín", "01/01/2020", "14:00",100,500,1000,300, 250);
        Vuelo v2 = new Vuelo("Madrid", "Miami", "30/12/2019", "3:00",100,500,1000,400, 4403);
        Vuelo v3 = new Vuelo("Cali", "Bucaramanga", "01/12/2019", "9:00",100,500,1000,300, 470);
        
        Vuelo v4 = new Vuelo("Medellín", "Bogotá", "05/01/2020", "12:00",100,500,1000,400, 250);
        Vuelo v5 = new Vuelo("Miami", "Madrid", "15/01/2020", "5:00",100,500,1000,500, 4403);
        Vuelo v6 = new Vuelo("Bucaramanga", "Cali", "15/12/2019", "11:00",100,500,1000,200, 470);
        
        //TRES VUELOS DE IDA DESDE BOGOTÁ HASTA MEDELLÍN EL MISMO DÍA, A DIFERENTES HORAS
        Vuelo v7 = new Vuelo("Bogotá", "Medellín", "01/01/2020", "16:00",100,500,1000,300, 250);
        Vuelo v8 = new Vuelo("Bogotá", "Medellín", "01/01/2020", "18:00",100,500,1000,300, 250);
        //TRES VUELOS MÁS DESDE BOGOTÁ HACIA DEDELLÍN, EL SIGUIENTE DÍA, A DIFERENTES HORAS
        Vuelo v9 = new Vuelo("Bogotá", "Medellín", "02/01/2020", "12:00",100,500,1000,300, 250);
        Vuelo v10 = new Vuelo("Bogotá", "Medellín", "02/01/2020", "13:00",100,500,1000,300, 250);
        Vuelo v11 = new Vuelo("Bogotá", "Medellín", "02/01/2020", "15:00",100,500,1000,300, 250);
        //DOS UBICACIONES MÁS DESDE BOGOTÁ: MIAMI Y BUCARAMANGA
        Vuelo v12 = new Vuelo("Bogotá", "Miami", "01/01/2020", "20:00",100,500,1000,300, 1509);
        Vuelo v13 = new Vuelo("Bogotá", "Bucaramanga", "01/01/2020", "18:00",100,500,1000,300, 260);
        //LOS VUELOS DE VUELTA PAR LOS ULTIMOS DOS
        Vuelo v14 = new Vuelo("Miami","Bogotá","01/05/2020", "23:00",100,500,1000,300, 1509);
        Vuelo v15 = new Vuelo("Bucaramanga","Bogotá", "01/06/2020", "6:00",100,500,1000,300, 260);
        */
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
        vuelos.add(v16);
        vuelos.add(v17);
        vuelos.add(v18);
        
        vuelos.add(v21);
        vuelos.add(v22);
        vuelos.add(v23);
        vuelos.add(v24);
        vuelos.add(v25);
        vuelos.add(v26);
        vuelos.add(v27);
        vuelos.add(v28);
        vuelos.add(v29);
        vuelos.add(v30);
        vuelos.add(v31);
        vuelos.add(v32);
        vuelos.add(v33);
        vuelos.add(v34);
        vuelos.add(v35);
        vuelos.add(v36);
        vuelos.add(v37);
        vuelos.add(v38);
        
        vuelos.add(v41);
        vuelos.add(v42);
        vuelos.add(v43);
        vuelos.add(v44);
        vuelos.add(v45);
        vuelos.add(v46);
        vuelos.add(v47);
        vuelos.add(v48);
        vuelos.add(v49);
        vuelos.add(v50);
        vuelos.add(v51);
        vuelos.add(v52);
        vuelos.add(v53);
        vuelos.add(v54);
        vuelos.add(v55);
        vuelos.add(v56);
        vuelos.add(v57);
        vuelos.add(v58);
        
        vuelos.add(v61);
        vuelos.add(v62);
        vuelos.add(v63);
        vuelos.add(v64);
        vuelos.add(v65);
        vuelos.add(v66);
        vuelos.add(v67);
        vuelos.add(v68);
        vuelos.add(v69);
        vuelos.add(v70);
        vuelos.add(v71);
        vuelos.add(v72);
        vuelos.add(v73);
        vuelos.add(v74);
        vuelos.add(v75);
        vuelos.add(v76);
        vuelos.add(v77);
        vuelos.add(v78);
        
        vuelos.add(v81);
        vuelos.add(v82);
        vuelos.add(v83);
        vuelos.add(v84);
        vuelos.add(v85);
        vuelos.add(v86);
        vuelos.add(v87);
        vuelos.add(v88);
        vuelos.add(v89);
        vuelos.add(v90);
        vuelos.add(v91);
        vuelos.add(v92);
        vuelos.add(v93);
        vuelos.add(v94);
        vuelos.add(v95);
        vuelos.add(v96);
        vuelos.add(v97);
        vuelos.add(v98);
        
        vuelos.add(v101);
        vuelos.add(v102);
        vuelos.add(v103);
        vuelos.add(v104);
        vuelos.add(v105);
        vuelos.add(v106);
        vuelos.add(v107);
        vuelos.add(v108);
        vuelos.add(v109);
        vuelos.add(v110);
        vuelos.add(v111);
        vuelos.add(v112);
        vuelos.add(v113);
        vuelos.add(v114);
        vuelos.add(v115);
        vuelos.add(v116);
        vuelos.add(v117);
        vuelos.add(v118);
        
        vuelos.add(v121);
        vuelos.add(v122);
        vuelos.add(v123);
        vuelos.add(v124);
        vuelos.add(v125);
        vuelos.add(v126);
        vuelos.add(v127);
        vuelos.add(v128);
        vuelos.add(v129);
        vuelos.add(v130);
        vuelos.add(v131);
        vuelos.add(v132);
        vuelos.add(v133);
        vuelos.add(v134);
        vuelos.add(v135);
        vuelos.add(v136);
        vuelos.add(v137);
        vuelos.add(v138);
        
        vuelos.add(v141);
        vuelos.add(v142);
        vuelos.add(v143);
        vuelos.add(v144);
        vuelos.add(v145);
        vuelos.add(v146);
        vuelos.add(v147);
        vuelos.add(v148);
        vuelos.add(v149);
        vuelos.add(v150);
        vuelos.add(v151);
        vuelos.add(v152);
        vuelos.add(v153);
        vuelos.add(v154);
        vuelos.add(v155);
        vuelos.add(v156);
        vuelos.add(v157);
        vuelos.add(v158);
        
        vuelos.add(v161);
        vuelos.add(v162);
        vuelos.add(v163);
        vuelos.add(v164);
        vuelos.add(v165);
        vuelos.add(v166);
        vuelos.add(v167);
        vuelos.add(v168);
        vuelos.add(v169);
        vuelos.add(v170);
        vuelos.add(v171);
        vuelos.add(v172);
        vuelos.add(v173);
        vuelos.add(v174);
        vuelos.add(v175);
        vuelos.add(v176);
        vuelos.add(v177);
        vuelos.add(v178);
        
        vuelos.add(v181);
        vuelos.add(v182);
        vuelos.add(v183);
        vuelos.add(v184);
        vuelos.add(v185);
        vuelos.add(v186);
        vuelos.add(v187);
        vuelos.add(v188);
        vuelos.add(v189);
        vuelos.add(v190);
        vuelos.add(v191);
        vuelos.add(v192);
        vuelos.add(v193);
        vuelos.add(v194);
        vuelos.add(v195);
        vuelos.add(v196);
        vuelos.add(v197);
        vuelos.add(v198);

        vuelos.add(v301);
        vuelos.add(v302);
        vuelos.add(v303);
        vuelos.add(v304);
        vuelos.add(v305);
        vuelos.add(v306);
        vuelos.add(v307);
        vuelos.add(v308);
        vuelos.add(v309);
        vuelos.add(v310);
        vuelos.add(v311);
        vuelos.add(v312);
        vuelos.add(v313);
        vuelos.add(v314);
        vuelos.add(v315);
        vuelos.add(v316);
        vuelos.add(v317);
        vuelos.add(v318);
        
        vuelos.add(v321);
        vuelos.add(v322);
        vuelos.add(v323);
        vuelos.add(v324);
        vuelos.add(v325);
        vuelos.add(v326);
        vuelos.add(v327);
        vuelos.add(v328);
        vuelos.add(v329);
        vuelos.add(v330);
        vuelos.add(v331);
        vuelos.add(v332);
        vuelos.add(v333);
        vuelos.add(v334);
        vuelos.add(v335);
        vuelos.add(v336);
        vuelos.add(v337);
        vuelos.add(v338);
        
        vuelos.add(v341);
        vuelos.add(v342);
        vuelos.add(v343);
        vuelos.add(v344);
        vuelos.add(v345);
        vuelos.add(v346);
        vuelos.add(v347);
        vuelos.add(v348);
        vuelos.add(v349);
        vuelos.add(v350);
        vuelos.add(v351);
        vuelos.add(v352);
        vuelos.add(v353);
        vuelos.add(v354);
        vuelos.add(v355);
        vuelos.add(v356);
        vuelos.add(v357);
        vuelos.add(v358);
        
        vuelos.add(v361);
        vuelos.add(v362);
        vuelos.add(v363);
        vuelos.add(v364);
        vuelos.add(v365);
        vuelos.add(v366);
        vuelos.add(v367);
        vuelos.add(v368);
        vuelos.add(v369);
        vuelos.add(v370);
        vuelos.add(v371);
        vuelos.add(v372);
        vuelos.add(v373);
        vuelos.add(v374);
        vuelos.add(v375);
        vuelos.add(v376);
        vuelos.add(v377);
        vuelos.add(v378);
        
        vuelos.add(v381);
        vuelos.add(v382);
        vuelos.add(v383);
        vuelos.add(v384);
        vuelos.add(v385);
        vuelos.add(v386);
        vuelos.add(v387);
        vuelos.add(v388);
        vuelos.add(v389);
        vuelos.add(v390);
        vuelos.add(v391);
        vuelos.add(v392);
        vuelos.add(v393);
        vuelos.add(v394);
        vuelos.add(v395);
        vuelos.add(v396);
        vuelos.add(v397);
        vuelos.add(v398);
		
        vuelos.add(v401);
        vuelos.add(v402);
        vuelos.add(v403);
        vuelos.add(v404);
        vuelos.add(v405);
        vuelos.add(v406);
        vuelos.add(v407);
        vuelos.add(v408);
        vuelos.add(v409);
        vuelos.add(v410);
        vuelos.add(v411);
        vuelos.add(v412);
        vuelos.add(v413);
        vuelos.add(v414);
        vuelos.add(v415);
        vuelos.add(v416);
        vuelos.add(v417);
        vuelos.add(v418);
        
        vuelos.add(v421);
        vuelos.add(v422);
        vuelos.add(v423);
        vuelos.add(v424);
        vuelos.add(v425);
        vuelos.add(v426);
        vuelos.add(v427);
        vuelos.add(v428);
        vuelos.add(v429);
        vuelos.add(v430);
        vuelos.add(v431);
        vuelos.add(v432);
        vuelos.add(v433);
        vuelos.add(v434);
        vuelos.add(v435);
        vuelos.add(v436);
        vuelos.add(v437);
        vuelos.add(v438);
        
        vuelos.add(v441);
        vuelos.add(v442);
        vuelos.add(v443);
        vuelos.add(v444);
        vuelos.add(v445);
        vuelos.add(v446);
        vuelos.add(v447);
        vuelos.add(v448);
        vuelos.add(v449);
        vuelos.add(v450);
        vuelos.add(v451);
        vuelos.add(v452);
        vuelos.add(v453);
        vuelos.add(v454);
        vuelos.add(v455);
        vuelos.add(v456);
        vuelos.add(v457);
        vuelos.add(v458);
        
        vuelos.add(v461);
        vuelos.add(v462);
        vuelos.add(v463);
        vuelos.add(v464);
        vuelos.add(v465);
        vuelos.add(v466);
        vuelos.add(v467);
        vuelos.add(v468);
        vuelos.add(v469);
        vuelos.add(v470);
        vuelos.add(v471);
        vuelos.add(v472);
        vuelos.add(v473);
        vuelos.add(v474);
        vuelos.add(v475);
        vuelos.add(v476);
        vuelos.add(v477);
        vuelos.add(v478);
        
        vuelos.add(v481);
        vuelos.add(v482);
        vuelos.add(v483);
        vuelos.add(v484);
        vuelos.add(v485);
        vuelos.add(v486);
        vuelos.add(v487);
        vuelos.add(v488);
        vuelos.add(v489);
        vuelos.add(v490);
        vuelos.add(v491);
        vuelos.add(v492);
        vuelos.add(v493);
        vuelos.add(v494);
        vuelos.add(v495);
        vuelos.add(v496);
        vuelos.add(v497);
        vuelos.add(v498);
        
        System.out.println();
        System.out.println("VUELOS DISPONIBLES");
        System.out.println();
        
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
        
        ArrayList<Reserva> reservas = new ArrayList<Reserva>();
        /*
        CalcularPrecio calcular = new CalcularPrecio();
        boolean idaVuelta[] = {true,true,false};
        boolean Equipajeida[] = {true,false,true};
        boolean Equipajevuelta[] = {true,false,true};
        
        Reserva r1 = new Reserva(v1,1,true,true,1,"Turista",a);
        Reserva r2 = new Reserva(v2,2,true,false,0,"Ejecutiva",b);
        Reserva r3 = new Reserva(v3,3,false,true,3,"Primera clase",c);
        
        r1.setCategoriaVuelta("Turista");
        r1.setEquipajeVuelta(Equipajevuelta[0]);
        r1.setNumeroPuestosvuelta(1);
        r1.setPesoVuelta(1);
        r1.setVueloVuelta(v4);
        r1.setNumeroPuestosvuelta(1);
        int[] puestos_r1 = {1};;
        r1.setPuestosIda(puestos_r1);
        r1.setPuestosVuelta(puestos_r1);
        System.out.println("r1.getNumeroPuestos(): "+ r1.getNumeroPuestos() +", r1.getNumeroPuestosVuelta(): "+r1.getNumeroPuestosVuelta());
        r1.setPrecio(calcular.calcularPrecio(r1) * (r1.getNumeroPuestos() + r1.getNumeroPuestosVuelta()));
        r1.setIva(calcular.calcularIva(r1) * (r1.getNumeroPuestos() + r1.getNumeroPuestosVuelta()));
        
        r2.setCategoriaVuelta("Ejecutiva");
        r2.setEquipajeVuelta(true);
        r2.setNumeroPuestosvuelta(1);
        r2.setPesoVuelta(2);
        r2.setVueloVuelta(v5);
        r2.setNumeroPuestosvuelta(2);
        int[] puestos_r2 = {2,3};
        r2.setPuestosIda(puestos_r2);
        r2.setPuestosVuelta(puestos_r2);
        System.out.println("r2.getNumeroPuestos(): "+ r2.getNumeroPuestos() +", r2.getNumeroPuestosVuelta(): "+r2.getNumeroPuestosVuelta());
        r2.setPrecio(calcular.calcularPrecio(r2) * (r2.getNumeroPuestos() + r2.getNumeroPuestosVuelta()));
        r2.setIva(calcular.calcularIva(r2) * (r2.getNumeroPuestos() + r2.getNumeroPuestosVuelta()));
        
        int[] puestos_r3 = {4,5,6};
        r3.setPuestosIda(puestos_r3);
        int[] empty = {};
        r3.setPuestosVuelta(empty);
        System.out.println("r3.getNumeroPuestos(): "+ r3.getNumeroPuestos() +", r3.getNumeroPuestosVuelta(): "+r3.getNumeroPuestosVuelta());
        r3.setPrecio(calcular.calcularPrecio(r3) * (r3.getNumeroPuestos() + r3.getNumeroPuestosVuelta()));
        r3.setIva(calcular.calcularIva(r3) * (r3.getNumeroPuestos() + r3.getNumeroPuestosVuelta()));
        
        
        reservas.add(r1);
        reservas.add(r2);
        reservas.add(r3);
        */

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
            rdao.crear(r); //ELEMENTOS YA AÑADIDOS A LA BASE DE DATOS
        }
        //REINICIO DE LOS ID'S DE TODAS LAS ENTIDADES
        int act = (int) udao.leerallcount()+1;
        udao.resetId(act);
        act = (int) vdao.leerallcount()+1;
        vdao.resetId(act);
        act = (int) tdao.leerallcount()+1;
        tdao.resetId(act);
        act = (int) rdao.leerallcount()+1;
        rdao.resetId(act);
        act = (int) tckdao.leerallcount()+1;
        tckdao.resetId(act);

    }
}
