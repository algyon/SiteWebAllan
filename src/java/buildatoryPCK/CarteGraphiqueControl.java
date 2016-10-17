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

@Named(value = "CarteGraphiqueControl")
@ViewScoped
public class CarteGraphiqueControl implements Serializable{
    
    @EJB
    private CarteGraphiqueDao CarteGraphiqueDao;
    private CarteGraphique CGSaisie;
    
    
    public CarteGraphiqueControl() {
        CGSaisie = new CarteGraphique();
    }

    public List<CarteGraphique> getAllCarteGraphiques() {
        return CarteGraphiqueDao.getAllCarteGraphique();
    }

    public CarteGraphique getSaisie() {
        return CGSaisie;
    }

    public void setSaisie(CarteGraphique CGSaisie) {
        this.CGSaisie = CGSaisie;
    }

    public String save() {
        CarteGraphiqueDao.save(CGSaisie);
        return "liste";
    }

    public String delete() {
        CarteGraphiqueDao.delete(CGSaisie);
        return "liste";
    }

    public String modify() {
        CarteGraphiqueDao.update(CGSaisie);
        return "liste";
    }

    public void lireCarteGraphique(ComponentSystemEvent event) {
        CGSaisie = CarteGraphiqueDao.getCarteGraphique();
    }
}

