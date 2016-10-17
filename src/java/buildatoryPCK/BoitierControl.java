/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildatoryPCK;

/**
 *
 * @author David
 */

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "BoitierControl")
@ViewScoped
public class BoitierControl implements Serializable{
    
    @EJB
    private BoitierDao BoitierDao;
    private Boitier BoitierSaisie;
    
    
    public BoitierControl() {
        BoitierSaisie = new Boitier();
    }

    public List<Boitier> getAllBoitiers() {
        return BoitierDao.getAllBoitier();
    }

    public Boitier getSaisie() {
        return BoitierSaisie;
    }

    public void setSaisie(Boitier BoitierSaisie) {
        this.BoitierSaisie = BoitierSaisie;
    }

    public String save() {
        BoitierDao.save(BoitierSaisie);
        return "liste";
    }

    public String delete() {
        BoitierDao.delete(BoitierSaisie);
        return "liste";
    }

    public String modify() {
        BoitierDao.update(BoitierSaisie);
        return "liste";
    }

    public void lireBoitier(ComponentSystemEvent event) {
        BoitierSaisie = BoitierDao.getBoitier();
    }
}