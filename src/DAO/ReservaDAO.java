/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Reserva;
import java.util.ArrayList;
import java.util.List;
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
    
    public Reserva leerReserva(int ID){
        EntityManager em = emf.createEntityManager();
        Reserva reserva = null;
        Query q = em.createQuery("SELECT r FROM Reserva r " +
                "WHERE r.id = :id")
                .setParameter("id", ID);
        try {
            reserva = (Reserva) q.getSingleResult();
        } catch(NonUniqueResultException e){
            reserva = (Reserva) q.getResultList().get(0);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return reserva;
        }
    }
        
    public List<Reserva> leeralltolist(){
        EntityManager em = emf.createEntityManager();
        List<Reserva> reserva = null;
        TypedQuery<Reserva> q = em.createQuery("SELECT r FROM Reserva r ",Reserva.class);
        try {
            reserva = q.getResultList();
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            em.close();
            return reserva;
        }
    }
    
    public long leerallcount(){
        EntityManager em = emf.createEntityManager();
        long count = 0;
        Query q = em.createQuery("SELECT COUNT(r) FROM Reserva r");
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
    
    public long leerquerycount(String condition){
        EntityManager em = emf.createEntityManager();
        long count = 0;
        Query q = em.createQuery("SELECT COUNT(r) FROM Reserva r WHERE " + condition);
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

    public boolean resetId(int i){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try{
            em.createNativeQuery("ALTER TABLE reservas ALTER COLUMN id RESTART WITH " + i).executeUpdate();
            ret = true;
        } catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally{
            em.close();
            return ret;
        }
    }    
    
    public boolean actualizaPago(Reserva object, boolean isPago) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try{
            object = leerReserva(object.getId());
            object.setPagada(isPago);
            em.merge(object);
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
}


