/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author nicro
 */

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable{
    private String nombre, apellido, username, email, password;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
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

public class UsuarioDAO {
    
    private static EntityManagerFactory
            emf = Persistence.createEntityManagerFactory("AirlineApp_JPAPU");
    
    public void crear(Usuario object){
        
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().begin();
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
        Query q = em.createQuery("SELECT u FROM Ususario u " +
                "WHERE u.nombre LIKE :nombre" +
                " AND u.apellido LIKE :apellido" +
                " AND u.username LIKE :username" +
                " AND u.email LIKE :email" +
                " AND u.password LIKE :password")
                .setParameter("nombre", par.getNombre())
                .setParameter("apellido",par.getApellido())
                .setParameter("username",par.getUsername())
                .setParameter("email", par.getEmail())
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
    
        public Usuario leerusername(Usuario par){
        EntityManager em = emf.createEntityManager();
        Usuario usuario = null;
        Query q = em.createQuery("SELECT u FROM Ususario u " +
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
}

*/