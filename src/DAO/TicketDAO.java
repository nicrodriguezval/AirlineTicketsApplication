/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Ticket;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Miguel Alejandro
 */
public class TicketDAO {

private static EntityManagerFactory
    emf = Persistence.createEntityManagerFactory("AirlineApp_JPAPU");
    
    public void crear(Ticket object){
        
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
    
    public boolean eliminar(Ticket object){
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
    
    public Ticket leerId(Ticket par){
        EntityManager em = emf.createEntityManager();
        Ticket tiquete = null;
        Query q = em.createQuery("SELECT t FROM Ticket t " +
                "WHERE t.id LIKE :id")
                .setParameter("id",par.getId());
        try{
            tiquete = (Ticket) q.getSingleResult();
        } catch(NonUniqueResultException e){
            tiquete = (Ticket) q.getResultList().get(0);
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            em.close();
            return tiquete;
        }
    }
    
        public boolean resetId(int i){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try{
            em.createNativeQuery("ALTER TABLE tickets ALTER COLUMN id RESTART WITH " + i).executeUpdate();
            em.getTransaction().commit();
            ret = true;
        } catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally{
            em.close();
            return ret;
        }
    }    
        
    public long leerallcount(){
        EntityManager em = emf.createEntityManager();
        long count = 0;
        Query q = em.createQuery("SELECT COUNT(tck) FROM Ticket tck");
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
        
    public boolean actualizarId(Ticket object, Ticket nuevoObjeto){
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
