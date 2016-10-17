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

@Named(value = "RamControl")
@ViewScoped
public class RamControl implements Serializable {

    @EJB
    private RamDao RamDao;
    private Ram RamSaisie;

    public RamControl() {
        RamSaisie = new Ram();
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

    public void lireRam(ComponentSystemEvent event) {
        RamSaisie = RamDao.getRam();
    }
}