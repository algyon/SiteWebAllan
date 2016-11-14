/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cooling;

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
public class CoolingDao {

    @PersistenceContext(unitName = "SiteWebAllanPU")
    private EntityManager em;
    
    public void persist(Cooling Cooling) {
        em.persist(Cooling);
    }

    public List<Cooling> getAllCooling() {
        Query query = em.createNamedQuery("Cooling.findAll");
        return query.getResultList();
    }

    public Cooling getCooling() {
        Query query = em.createNamedQuery("Cooling.findByNomCooling");
        return(Cooling) query.getSingleResult();
    }
    
    public Cooling getCoolingByNom(String coolingNom) {
        TypedQuery<Cooling> query = em.createNamedQuery("Cooling.findByNomCooling", Cooling.class);
        query.setParameter("nomCooling", coolingNom);
        return(Cooling) query.getSingleResult();
    }

    public void update(Cooling Cooling) {
        try {
            em.merge(Cooling);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void delete(Cooling Cooling) {
        try {
            em.remove(em.merge(Cooling));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void save(Cooling Cooling) {
        try {
            em.persist(Cooling);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
