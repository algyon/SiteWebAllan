/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boitier;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * @author David
 */

@Stateless
public class BoitierDao {

    @PersistenceContext(unitName = "SiteWebAllanPU")
    private EntityManager em;

    public void persist(Boitier Boitier) {
        em.persist(Boitier);
    }

    public List<Boitier> getAllBoitier() {
        Query query = em.createNamedQuery("Boitier.findAll");
        return query.getResultList();
    }
    
    public Boitier getBoitierByNom (String boitierNom){
        TypedQuery <Boitier> query = em.createNamedQuery("Boitier.findByNomBoitier",Boitier.class);
        query.setParameter("nomBoitier", boitierNom);
        return(Boitier) query.getSingleResult();
    }
    
    /*
    public Boitier getBoitier() {
        Query query = em.createNamedQuery("Boitier.findByNomBoitier");
        return(Boitier) query.getSingleResult();
    }*/

    public void update(Boitier Boitier) {
        try {
            em.merge(Boitier);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void delete(Boitier Boitier) {
        try {
            em.remove(em.merge(Boitier));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void save(Boitier Boitier) {
        try {
            em.persist(Boitier);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    

    
}
