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
public class AlimentationDao {

    @PersistenceContext(unitName = "AlimentationPU")
    private EntityManager em;

    public List<Alimentation> getAllAlimentation() {
        Query query = em.createNamedQuery("Alimentation.findAll");
        return query.getResultList();
    }

    public Alimentation getAlimentation() {
        Query query = em.createNamedQuery("Alimentation.findByNomAlim");
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
}
