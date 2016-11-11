/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cpu;

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
public class CpuDao {

    @PersistenceContext(unitName = "SiteWebAllanPU")
    private EntityManager em;

    public void persist(Cpu Cpu) {
        em.persist(Cpu);
    }
    
    public List<Cpu> getAllCpu() {
        Query query = em.createNamedQuery("Cpu.findAll");
        return query.getResultList();
    }

    /**public Cpu getCpu() {
        Query query = em.createNamedQuery("Cpu.findByNomCpu");
        return(Cpu) query.getSingleResult();
    }*/
    
    public Cpu getCpuByNom(String cpuNom) {
        TypedQuery<Cpu> query = em.createNamedQuery("Cpu.findByNomCpu", Cpu.class);
        query.setParameter("nomCpu", cpuNom);
        return(Cpu) query.getSingleResult();
    }

    public void update(Cpu Cpu) {
        try {
            em.merge(Cpu);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void delete(Cpu Cpu) {
        try {
            em.remove(em.merge(Cpu));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void save(Cpu Cpu) {
        try {
            em.persist(Cpu);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}

