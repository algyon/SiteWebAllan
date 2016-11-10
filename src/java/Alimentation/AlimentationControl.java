/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alimentation;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author David
 * 
 */

@Named(value = "AlimentationControl")
@SessionScoped
public class AlimentationControl implements Serializable{
    
    @EJB
    private AlimentationDao AlimentationDao;
    private Alimentation AlimSaisie;
    private Alimentation SelectedAlim;
    private String SelectedAlimNom;
    
    
    public AlimentationControl() {
        AlimSaisie = new Alimentation();
    }

    @PostConstruct
    public void init() {
        SelectedAlim = AlimentationDao.getAlimByNom("Cooler Master V550, 550 W");
    }
    
    public List<Alimentation> getAllAlimentations() {
        return AlimentationDao.getAllAlimentation();
    }

    public Alimentation getSaisie() {
        return AlimSaisie;
    }

    public void setSaisie(Alimentation AlimSaisie) {
        this.AlimSaisie = AlimSaisie;
    }

    public String save() {
        AlimentationDao.save(AlimSaisie);
        return "liste";
    }

    public String delete() {
        AlimentationDao.delete(AlimSaisie);
        return "liste";
    }

    public String modify() {
        AlimentationDao.update(AlimSaisie);
        return "liste";
    }
    
    /*
    public void lireAlimentation(ComponentSystemEvent event) {
        AlimSaisie = AlimentationDao.getAlimentation();
    */

    public Alimentation getSelectedAlim() {
        return SelectedAlim;
    }

    public void setSelectedAlim(Alimentation SelectedAlim) {
        this.SelectedAlim = SelectedAlim;
    }

    public String getSelectedAlimNom() {
        return SelectedAlimNom;
    }

    public void setSelectedAlimNom(String SelectedAlimNom) {
        this.SelectedAlimNom = SelectedAlimNom;
    }
    
    public void AlimValueChanged() {
        try {
            SelectedAlim = AlimentationDao.getAlimByNom(SelectedAlimNom);
        } catch (NullPointerException f) {
            System.err.println(f);
        }
    }
}
