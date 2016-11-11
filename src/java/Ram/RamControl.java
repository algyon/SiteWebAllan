/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ram;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author David
 *
 */

@Named(value = "RamControl")
@ViewScoped
public class RamControl implements Serializable {

    @EJB
    private RamDao RamDao;
    private Ram RamSaisie;
    private Ram SelectedRam;
    private String SelectedRamNom;

    public RamControl() {
        RamSaisie = new Ram();
    }
    
    @PostConstruct
    public void init() {
        SelectedRam = RamDao.getRamByNom("DDR4 Ballistix Sport LT, 2 x 4 Go, 2400 MHz, CAS 16");
    }

    public List<Ram> getAllRams() {
        return RamDao.getAllRam();
    }

    public Ram getSaisie() {
        return RamSaisie;
    }

    public void setSaisie(Ram RamSaisie) {
        this.RamSaisie = RamSaisie;
    }

    public String save() {
        RamDao.save(RamSaisie);
        return "liste";
    }

    public String delete() {
        RamDao.delete(RamSaisie);
        return "liste";
    }

    public String modify() {
        RamDao.update(RamSaisie);
        return "liste";
    }

    /*
    public void lireRam(ComponentSystemEvent event) {
        RamSaisie = RamDao.getRam();
    }*/

    public Ram getSelectedRam() {
        return SelectedRam;
    }

    public String getSelectedRamNom() {
        return SelectedRamNom;
    }

    public void setSelectedRamNom(String SelectedRamNom) {
        this.SelectedRamNom = SelectedRamNom;
    }
    
    public void RamValueChanged() {
        try {
            SelectedRam = RamDao.getRamByNom(SelectedRamNom);
            // F param
            // .Stream.filter 
        } catch (NullPointerException f) {
            System.err.println(f);
        }
    }
}