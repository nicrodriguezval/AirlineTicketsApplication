/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Vuelo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
    
    public Vuelo leerId(Vuelo par){
        EntityManager em = emf.createEntityManager();
        Vuelo vuelo = null;
        Query q = em.createQuery("SELECT v FROM Vuelo v " +
                "WHERE v.id LIKE :id")
                .setParameter("id",par.getId());
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
            object = leerId(object);
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
