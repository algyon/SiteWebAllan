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
 * @author David
 */

@Stateless
public class RamDao {

    @PersistenceContext(unitName = "RamPU")
    private EntityManager em;

    public List<Ram> getAllRam() {
        Query query = em.createNamedQuery("Ram.findAll");
        return query.getResultList();
    }

    public Ram getRam() {
        Query query = em.createNamedQuery("Ram.findByNomRam");
        return(Ram) query.getSingleResult();
    }

    public void update(Ram Ram) {
        try {
            em.merge(Ram);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void delete(Ram Ram) {
        try {
            em.remove(em.merge(Ram));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void save(Ram Ram) {
        try {
            em.persist(Ram);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
