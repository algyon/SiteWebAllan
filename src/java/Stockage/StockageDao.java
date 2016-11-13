/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stockage;

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
public class StockageDao {

    @PersistenceContext(unitName = "SiteWebAllanPU")
    private EntityManager em;

    public void persist(Stockage Storage) {
        em.persist(Storage);
    }

    public List<Stockage> getAllStockage() {
        Query query = em.createNamedQuery("Stockage.findAll");
        return query.getResultList();
    }
    
    public Stockage getStockageByNom(String stockageNom) {
        TypedQuery<Stockage> query = em.createNamedQuery("Stockage.findByNomStockage", Stockage.class);
        query.setParameter("nomStockage", stockageNom);
        return(Stockage) query.getSingleResult();
    }
    
    /*
    public Stockage getStockage() {
        Query query = em.createNamedQuery("Stockage.findByNomStorage");
        return(Stockage) query.getSingleResult();
    }*/

    public void update(Stockage Storage) {
        try {
            em.merge(Storage);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void delete(Stockage Storage) {
        try {
            em.remove(em.merge(Storage));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void save(Stockage Storage) {
        try {
            em.persist(Storage);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}