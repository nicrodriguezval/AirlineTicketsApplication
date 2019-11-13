/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Vuelo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Miguel Alejandro
 */
public class VueloDAO {

private static EntityManagerFactory
    emf = Persistence.createEntityManagerFactory("AirlineApp_JPAPU");
    
    public void crear(Vuelo object){
        
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally{
            em.close();
        }
    }
    
    public boolean eliminar(Vuelo object){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try{
            em.remove(object);
            em.getTransaction().commit();
            ret = true;
        } catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            return ret;
        }
    }
    
    public Vuelo leerId(int id){
        EntityManager em = emf.createEntityManager();
        Vuelo vuelo = null;
        Query q = em.createQuery("SELECT v FROM Vuelo v " +
                "WHERE v.id = :id")
                .setParameter("id",id);
        try{
            vuelo = (Vuelo) q.getSingleResult();
        } catch(NonUniqueResultException e){
            vuelo = (Vuelo) q.getResultList().get(0);
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            em.close();
            return vuelo;
        }
    }
    
    public List<Vuelo> leeralltolist(){ //RETORNA UNA LISTA CON TODOS LOS VUELOS EN LA DATABASE
        EntityManager em = emf.createEntityManager();
        List<Vuelo> vuelo = null;
        TypedQuery<Vuelo> q = em.createQuery("SELECT v FROM Vuelo v ",Vuelo.class);
        try{
            vuelo = q.getResultList();
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            em.close();
            return vuelo;
        }
    }
    
        public List<Vuelo> leerquerytolist(String condition){
        EntityManager em = emf.createEntityManager();
        List<Vuelo> vuelo = null;
        TypedQuery<Vuelo> q = em.createQuery("SELECT v FROM Vuelo v WHERE " + 
                condition,Vuelo.class);
        try{
            vuelo = q.getResultList();
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            em.close();
            return vuelo;
        }
    }
    
    public long leerquerycount(String condition){
        EntityManager em = emf.createEntityManager();
        long count = 0;
        Query q = em.createQuery("SELECT COUNT(v) FROM Vuelo v WHERE " + condition);
        try{
            count = (long) q.getSingleResult();
        } catch(NonUniqueResultException e){
            count = (long) q.getResultList().get(0);
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            em.close();
            return count;
        }
    }
        
    public List<String> leerdiffparametertolist(String param, String condition){
        EntityManager em = emf.createEntityManager();
        List<String> par = new ArrayList<String>();
        List<Vuelo> result = null;
        List<String> uniques = new ArrayList<String>();
        TypedQuery<Vuelo> q = em.createQuery("SELECT v FROM Vuelo v WHERE " +
                condition,Vuelo.class);
        try{
            result = q.getResultList();
            for(Vuelo v : result){
                if(param.equals("origen")){par.add(v.getOrigen());}
                else if(param.equals("destino")){par.add(v.getDestino());}
                else if(param.equals("fecha")){par.add(v.getFecha());}
                else if(param.equals("hora")){par.add(v.getHora());}
                else if(param.equals("id")){par.add("" + v.getId());}
                else if(param.equals("sillasTotales")){par.add("" + v.getSillasTotales());}
                else if(param.equals("precioClaseEjecutiva")){par.add("" + v.getPrecioClaseEjecutiva());}
                else if(param.equals("precioClaseTurista")){par.add("" + v.getPrecioClaseTurista());}
                else if(param.equals("precioPrimeraClase")){par.add("" + v.getPrecioPrimeraClase());}
                else {uniques = null;}
                }
            for(String s : par){
                if(!uniques.contains(s)){
                    uniques.add(s);
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            em.close();
            return uniques;
        }
    }
    
        public List<String> leerdiffallparametertolist(String param){
        EntityManager em = emf.createEntityManager();
        List<String> par = new ArrayList<String>();
        List<Vuelo> result = null;
        List<String> uniques = new ArrayList<String>();
        TypedQuery<Vuelo> q = em.createQuery("SELECT v FROM Vuelo v",Vuelo.class);
        try{
            result = q.getResultList();
            for(Vuelo v : result){
                if(param.equals("origen")){par.add(v.getOrigen());}
                else if(param.equals("destino")){par.add(v.getDestino());}
                else if(param.equals("fecha")){par.add(v.getFecha());}
                else if(param.equals("hora")){par.add(v.getHora());}
                else if(param.equals("id")){par.add("" + v.getId());}
                else if(param.equals("sillasTotales")){par.add("" + v.getSillasTotales());}
                else if(param.equals("precioClaseEjecutiva")){par.add("" + v.getPrecioClaseEjecutiva());}
                else if(param.equals("precioClaseTurista")){par.add("" + v.getPrecioClaseTurista());}
                else if(param.equals("precioPrimeraClase")){par.add("" + v.getPrecioPrimeraClase());}
                else {uniques = null;}
                }
            for(String s : par){
                if(!uniques.contains(s)){
                    uniques.add(s);
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            em.close();
            return uniques;
        }
    }
    
    public Vuelo leerIdObj(Vuelo vu){
        EntityManager em = emf.createEntityManager();
        Vuelo vuelo = null;
        Query q = em.createQuery("SELECT v FROM Vuelo v " +
                "WHERE v.id LIKE :id")
                .setParameter("id",vu.getId());
        try{
            vuelo = (Vuelo) q.getSingleResult();
        } catch(NonUniqueResultException e){
            vuelo = (Vuelo) q.getResultList().get(0);
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            em.close();
            return vuelo;
        }
    }
    
    
    public Vuelo leer(String origen, String destino, String fecha, String hora){
        EntityManager em = emf.createEntityManager();
        Vuelo vuelo = null;
        Query q = em.createQuery("SELECT v FROM Vuelo v " +
                "WHERE v.origen LIKE :origen " +
                "AND v.destino LIKE :destino " +
                "AND v.fecha LIKE :fecha " +
                "AND v.hora LIKE :hora")
                .setParameter("origen",origen)
                .setParameter("destino",destino)
                .setParameter("fecha", fecha)
                .setParameter("hora", hora);
        try{
            vuelo = (Vuelo) q.getSingleResult();
        } catch(NonUniqueResultException e){
            vuelo = (Vuelo) q.getResultList().get(0);
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            em.close();
            return vuelo;
        }
    }
    
    public boolean actualizarId(Vuelo object, Vuelo nuevoObjeto){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try{
            object = leerIdObj(object);
            object.setId(nuevoObjeto.getId());
            ret = true;
        } catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally{
            em.close();
            return ret;
        }
    }

}
