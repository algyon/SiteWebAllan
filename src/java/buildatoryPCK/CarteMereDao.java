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
public class CarteMereDao {

    @PersistenceContext(unitName = "SiteWebAllanPU")
    private EntityManager em;

    public void persist(CarteMere CM) {
        em.persist(CM);
    }

    public List<CarteMere> getAllCarteMere() {
        Query query = em.createNamedQuery("CarteMere.findAll");
        return query.getResultList();
    }

    public CarteMere getCarteMere() {
        Query query = em.createNamedQuery("CarteMere.findByNomCM");
        return(CarteMere) query.getSingleResult();
    }

    public void update(CarteMere CM) {
        try {
            em.merge(CM);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void delete(CarteMere CM) {
        try {
            em.remove(em.merge(CM));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void save(CarteMere CM) {
        try {
            em.persist(CM);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
