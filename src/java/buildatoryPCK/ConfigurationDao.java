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
public class ConfigurationDao {

    @PersistenceContext(unitName = "SiteWebAllanPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public List<Configuration> getAllConfiguration() {
        Query query = em.createNamedQuery("Configuration.findAll");
        return query.getResultList();
    }

    public Configuration getConfiguration() {
        Query query = em.createNamedQuery("Configuraton.findByNomConfiguration");
        return(Configuration) query.getSingleResult();
    }

    public void update(Configuration Config) {
        try {
            em.merge(Config);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void delete(Configuration Config) {
        try {
            em.remove(em.merge(Config));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void save(Configuration Config) {
        try {
            em.persist(Config);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
