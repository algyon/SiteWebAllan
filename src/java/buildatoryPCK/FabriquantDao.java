/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildatoryPCK;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Alexandra
 */
@Stateless
public class FabriquantDao {

    @PersistenceContext(unitName = "SiteWebAllanPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public List<Fabriquant> getAllFabriquant() {
        Query query = em.createNamedQuery("Fabriquant.findAll");
        return query.getResultList();
    }

    public Fabriquant getFabriquant() {
        Query query = em.createNamedQuery("Fabriquant.findByNomFabriquant");
        return(Fabriquant) query.getSingleResult();
    }

    public void update(Fabriquant Fabri) {
        try {
            em.merge(Fabri);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void delete(Fabriquant Fabri) {
        try {
            em.remove(em.merge(Fabri));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void save(Fabriquant Fabri) {
        try {
            em.persist(Fabri);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
