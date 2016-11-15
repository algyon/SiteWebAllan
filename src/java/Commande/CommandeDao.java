/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commande;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Stateless
public class CommandeDao {
    
    @PersistenceContext(unitName = "SiteWebAllanPU")
    private EntityManager em;

    public void persist(Commande Commande) {
        em.persist(Commande);
    }

    public List <Commande> getAllCommande() {
        Query query = em.createNamedQuery("Commande.findAll");
        return query.getResultList();
    }
    
    public Commande getCommandeById(int id) {
        TypedQuery<Commande> query = em.createNamedQuery("Commande.findByIdCommande",Commande.class);
        query.setParameter("idCommande",id);
        return(Commande) query.getSingleResult();
    }
    
    public Commande getCommande() {
        Query query = em.createNamedQuery("Commande.findByIdCommande");
        return(Commande) query.getSingleResult();
    }
        
    public void update(Commande Commande) {
        try {
            em.merge(Commande);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void delete(Commande Commande) {
        try {
            em.remove(em.merge(Commande));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void save(Commande Commande) {
        try {
            em.persist(Commande);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}
