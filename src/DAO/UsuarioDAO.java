/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Miguel Alejandro
 */
public class UsuarioDAO {
    private static EntityManagerFactory
    emf = Persistence.createEntityManagerFactory("AirlineApp_JPAPU");
    
    public void crear(Usuario object){
        
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
    
    public boolean eliminar(Usuario object){
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
    

    
    public Usuario leer(Usuario par){
        EntityManager em = emf.createEntityManager();
        Usuario usuario = null;
        Query q = em.createQuery("SELECT u FROM Usuario u " +
                "WHERE u.username LIKE :username" + 
                " AND u.password LIKE :password")
                .setParameter("username",par.getUsername())
                .setParameter("password",par.getPassword());
        try{
            usuario = (Usuario) q.getSingleResult();
        } catch(NonUniqueResultException e){
            usuario = (Usuario) q.getResultList().get(0);
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            em.close();
            return usuario;
        }
    }
        
    public Usuario leerusername(String username){
        EntityManager em = emf.createEntityManager();
        Usuario usuario = null;
        Query q = em.createQuery("SELECT u FROM Usuario u " +
                "WHERE u.username LIKE :username")
                .setParameter("username",username);
        try{
            usuario = (Usuario) q.getSingleResult();
        } catch(NonUniqueResultException e){
            usuario = (Usuario) q.getResultList().get(0);
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            em.close();
            return usuario;
        }
    }
    
    public long leerquerycount(String condition){
        EntityManager em = emf.createEntityManager();
        long count = 0;
        Query q = em.createQuery("SELECT COUNT(u) FROM Usuario u WHERE " + condition);
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
    
    public Usuario leeremail(String email){
        EntityManager em = emf.createEntityManager();
        Usuario usuario = null;
        Query q = em.createQuery("SELECT u FROM Usuario u " +
                "WHERE u.email LIKE :email")
                .setParameter("email",email);
        try{
            usuario = (Usuario) q.getSingleResult();
        } catch(NonUniqueResultException e){
            usuario = (Usuario) q.getResultList().get(0);
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            em.close();
            return usuario;
        }
    }
                
    public boolean actualizar(Usuario object, Usuario nuevoObjeto){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try{
            object = leer(object);
            object.setNombre(nuevoObjeto.getNombre());
            object.setApellido(nuevoObjeto.getApellido());
            object.setEmail(nuevoObjeto.getEmail());
            object.setUsername(nuevoObjeto.getUsername());
            object.setPassword(nuevoObjeto.getPassword());
            ret = true;
        } catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally{
            em.close();
            return ret;
        }
    }
    
    public boolean actualizaPuntos(Usuario object, int puntos){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try{
            object = leerusername(object.getUsername());
            object.setPoints(puntos);
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
