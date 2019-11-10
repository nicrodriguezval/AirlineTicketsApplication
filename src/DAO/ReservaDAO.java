/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Reserva;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Miguel Alejandro
 */
public class ReservaDAO {

private static EntityManagerFactory
    emf = Persistence.createEntityManagerFactory("AirlineApp_JPAPU");
    
    public void crear(Reserva object){
        
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
    
    public boolean eliminar(Reserva object){
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
    
    public Reserva leerId(Reserva par){
        EntityManager em = emf.createEntityManager();
        Reserva reserva = null;
        Query q = em.createQuery("SELECT r FROM Reserva r " +
                "WHERE r.id LIKE :id")
                .setParameter("id",par.getId());
        try{
            reserva = (Reserva) q.getSingleResult();
        } catch(NonUniqueResultException e){
            reserva = (Reserva) q.getResultList().get(0);
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            em.close();
            return reserva;
        }
    }
        
    public boolean actualizarId(Reserva object, Reserva nuevoObjeto){
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
