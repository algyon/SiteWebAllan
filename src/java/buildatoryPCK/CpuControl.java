/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildatoryPCK;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author David
 * 
 */

@Named(value = "CpuControl")
@ViewScoped
public class CpuControl implements Serializable{
    
    @EJB
    private CpuDao CpuDao;
    private Cpu CpuSaisie;
    
    
    public CpuControl() {
        CpuSaisie = new Cpu();
    }

    public List<Cpu> getAllCpus() {
        return CpuDao.getAllCpu();
    }

    public Cpu getSaisie() {
        return CpuSaisie;
    }

    public void setSaisie(Cpu CpuSaisie) {
        this.CpuSaisie = CpuSaisie;
    }

    public String save() {
        CpuDao.save(CpuSaisie);
        return "liste";
    }

    public String delete() {
        CpuDao.delete(CpuSaisie);
        return "liste";
    }

    public String modify() {
        CpuDao.update(CpuSaisie);
        return "liste";
    }

    public void lireCpu(ComponentSystemEvent event) {
        CpuSaisie = CpuDao.getCpu();
    }
}
