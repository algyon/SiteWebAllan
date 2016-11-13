/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarteGraphique;

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
@Named(value = "CarteGraphiqueControl")
@ViewScoped
public class CarteGraphiqueControl implements Serializable {

    @EJB
    private CarteGraphiqueDao CarteGraphiqueDao;
    private CarteGraphique CGSaisie;
    private CarteGraphique SelectedCG;
    private String SelectedCgNom;

    public CarteGraphiqueControl() {
        CGSaisie = new CarteGraphique();
    }

    @PostConstruct
    public void init() {
        SelectedCG = CarteGraphiqueDao.getCgByNom("Asus GeForce GTX 1070 ROG STRIX, 8 Go");
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

    /*
    public void lireCarteGraphique(ComponentSystemEvent event) {
        CGSaisie = CarteGraphiqueDao.getCarteGraphique();
    }
     */
    public CarteGraphique getSelectedCG() {
        return SelectedCG;
    }

    public void setSelectedCG(CarteGraphique SelectedCG) {
        this.SelectedCG = SelectedCG;
    }

    public String getSelectedCgNom() {
        return SelectedCgNom;
    }

    public void setSelectedCgNom(String SelectedCgNom) {
        this.SelectedCgNom = SelectedCgNom;
    }
    
    

}
