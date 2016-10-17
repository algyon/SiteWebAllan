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
 * @author Alexandra
 */
@Named(value = "fabriquantControl")
@ViewScoped
public class FabriquantControl implements Serializable{

    @EJB
    private FabriquantDao FabriquantDao;
    private Fabriquant FabriquantSaisie;
    /**
     * Creates a new instance of FabriquantControl
     */
    public FabriquantControl() {
        FabriquantSaisie = new Fabriquant();
    }

    public List<Fabriquant> getAllFabriquants() {
        return FabriquantDao.getAllFabriquant();
    }

    public Fabriquant getSaisie() {
        return FabriquantSaisie;
    }

    public void setSaisie(Fabriquant FabriquantSaisie) {
        this.FabriquantSaisie = FabriquantSaisie;
    }

    public String save() {
        FabriquantDao.save(FabriquantSaisie);
        return "liste";
    }

    public String delete() {
        FabriquantDao.delete(FabriquantSaisie);
        return "liste";
    }

    public String modify() {
        FabriquantDao.update(FabriquantSaisie);
        return "liste";
    }

    public void lireFabriquant(ComponentSystemEvent event) {
        FabriquantSaisie = FabriquantDao.getFabriquant();
    }
    
}
