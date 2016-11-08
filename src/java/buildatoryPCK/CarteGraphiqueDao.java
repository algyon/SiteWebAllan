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
import javax.persistence.TypedQuery;

/**
 * @author David
 */

@Stateless
public class CarteGraphiqueDao {

    @PersistenceContext(unitName = "SiteWebAllanPU")
    private EntityManager em;
    
    public void persist(CarteGraphique CG) {
        em.persist(CG);
    }

    public List<CarteGraphique> getAllCarteGraphique() {
        Query query = em.createNamedQuery("CarteGraphique.findAll");
        return query.getResultList();
    }
    
    /*
    public CarteGraphique getCarteGraphique() {
        Query query = em.createNamedQuery("CarteGraphique.findByNomCG");
        return(CarteGraphique) query.getSingleResult();
    }
    */
    
    public CarteGraphique getCgByNom(String cgNom) {
        TypedQuery<CarteGraphique> query = em.createNamedQuery("CarteGraphique.findByNomCg", CarteGraphique.class);
        query.setParameter("nomCm", cgNom);
        return(CarteGraphique) query.getSingleResult();
    }
    
    public void update(CarteGraphique CG) {
        try {
            em.merge(CG);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void delete(CarteGraphique CG) {
        try {
            em.remove(em.merge(CG));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void save(CarteGraphique CG) {
        try {
            em.persist(CG);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}
