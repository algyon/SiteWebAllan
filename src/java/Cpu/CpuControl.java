/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cpu;

import Configuration.Configuration;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author David
 *
 */
@Named(value = "CpuControl")
@ViewScoped
public class CpuControl implements Serializable {

    @EJB
    private CpuDao CpuDao;
    private Cpu CpuSaisie;
    private Cpu SelectedCpu;
    private String SelectedCpuNom;
    private Configuration config;

    public CpuControl() {
        
    }

    @PostConstruct
    public void init() {
        SelectedCpu = CpuDao.getCpuByNom("Intel Core i5-6600K (3.5 GHz)");
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

    /**
     * public void lireCpu(ComponentSystemEvent event) { CpuSaisie =
     * CpuDao.getCpu(); }*
     */
    
    public String getSelectedCpuNom() {
        return SelectedCpuNom;
    }

    public void setSelectedCpuNom(String SelectedCpuNom) {
        this.SelectedCpuNom = SelectedCpuNom;
    }

    public Cpu getSelectedCpu() {
        return SelectedCpu;
    }
}
