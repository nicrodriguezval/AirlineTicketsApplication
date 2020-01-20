/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.CreditCard;
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
public class CreditCardDAO {

    private static EntityManagerFactory
    emf = Persistence.createEntityManagerFactory("AirlineApp_JPAPU");
    
    public void crear(CreditCard object){
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
    
    public boolean eliminar(CreditCard object){
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
    
    public CreditCard leerId(int par){
        EntityManager em = emf.createEntityManager();
        CreditCard tarjeta = null;
        Query q = em.createQuery("SELECT t FROM CreditCard t " +
                "WHERE t.id = :id")
                .setParameter("id",par);
        try{
            tarjeta = (CreditCard) q.getSingleResult();
        } catch(NonUniqueResultException e){
            tarjeta = (CreditCard) q.getResultList().get(0);
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            em.close();
            return tarjeta;
        }
    }
        
        public CreditCard leernumtarjeta(String par){
        EntityManager em = emf.createEntityManager();
        CreditCard tarjeta = null;
        Query q = em.createQuery("SELECT t FROM CreditCard t " +
                "WHERE t.numeroTarjeta = :id")
                .setParameter("id",par);
        try{
            tarjeta = (CreditCard) q.getSingleResult();
        } catch(NonUniqueResultException e){
            tarjeta = (CreditCard) q.getResultList().get(0);
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            em.close();
            return tarjeta;
        }
    }
    
    public boolean actualizarId(CreditCard object, CreditCard nuevoObjeto){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try{
            object = leerId(object.getId());
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
 
    public boolean actualizarcupo(CreditCard object, double cupo){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try{
            object = leerId(object.getId());
            object.setCupoGastado(cupo);
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
    
    public List<CreditCard> leeralltolist(){
        EntityManager em = emf.createEntityManager();
        List<CreditCard> creditCard = null;
        TypedQuery<CreditCard> q = em.createQuery("SELECT t FROM CreditCard t ", CreditCard.class);
        try {
            creditCard = q.getResultList();
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            em.close();
            return creditCard;
        }
    }
        
    public List<CreditCard> leerquerytolist(String condition){
        EntityManager em = emf.createEntityManager();
        List<CreditCard> vuelo = null;
        TypedQuery<CreditCard> q = em.createQuery("SELECT t FROM CreditCard t WHERE " + 
                condition,CreditCard.class);
        try{
            vuelo = q.getResultList();
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            em.close();
            return vuelo;
        }
    }
    
    public List<String> leerdiffallparametertolist(String param){
        EntityManager em = emf.createEntityManager();
        List<String> par = new ArrayList<String>();
        List<CreditCard> result = null;
        List<String> uniques = new ArrayList<String>();
        TypedQuery<CreditCard> q = em.createQuery("SELECT t FROM CreditCard t",CreditCard.class);
        try{
            result = q.getResultList();
            for(CreditCard t : result){
                if(param.equals("nombreBanco")){par.add(t.getNombreBanco());}
                else if(param.equals("marcaInternacional")){par.add(t.getMarcaInternacional());}
                else if(param.equals("nombreTitular")){par.add(t.getNombreTitular());}
                else if(param.equals("numeroSeguridad")){par.add(t.getNumeroSeguridad());}
                else if(param.equals("numeroTarjeta")){par.add(t.getNumeroTarjeta());}
                else if(param.equals("mesExpiracion")){par.add(t.getMesExpiracion());}
                else if(param.equals("añoExpiracion")){par.add(t.getAñoExpiracion());}
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
    
        public boolean resetId(int i){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try{
            em.createNativeQuery("ALTER TABLE tarjetas ALTER COLUMN id RESTART WITH " + i).executeUpdate();
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
        Query q = em.createQuery("SELECT COUNT(t) FROM CreditCard t");
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
        Query q = em.createQuery("SELECT COUNT(t) FROM CreditCard t WHERE " + condition );
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
    
}


