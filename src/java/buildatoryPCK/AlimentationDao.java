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
 * @author David
 */
@Stateless
public class AlimentationDao {

    @PersistenceContext(unitName = "SiteWebAllanPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public List<Alimentation> getAllAlimentation() {
        Query query = em.createNamedQuery("Alimentation.findAll");
        return query.getResultList();
    }

    public Alimentation getAlimentation() {
        Query query = em.createNamedQuery("Alimentation.findByNomAlimentation");
        return(Alimentation) query.getSingleResult();
    }

    public void update(Alimentation Alim) {
        try {
            em.merge(Alim);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void delete(Alimentation Alim) {
        try {
            em.remove(em.merge(Alim));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void save(Alimentation Alim) {
        try {
            em.persist(Alim);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
