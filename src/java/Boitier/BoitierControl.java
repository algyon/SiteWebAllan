/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boitier;

/**
 *
 * @author David
 */

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

@Named(value = "BoitierControl")
@SessionScoped
public class BoitierControl implements Serializable{
    
    @EJB
    private BoitierDao BoitierDao;
    private Boitier BoitierSaisie;
    private Boitier SelectedBoitier;
    private String SelectedBoitierNom; 
    
    
    public BoitierControl() {
        BoitierSaisie = new Boitier();
    }
    
    @PostConstruct
    public void init() {
        SelectedBoitier = BoitierDao.getBoitierByNom("Zalman Z1");
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
    
    /*
    public void lireBoitier(ComponentSystemEvent event) {
        BoitierSaisie = BoitierDao.getBoitier();
    }*/

    public Boitier getSelectedBoitier() {
        return SelectedBoitier;
    }

    public void setSelectedBoitier(Boitier SelectedBoitier) {
        this.SelectedBoitier = SelectedBoitier;
    }

    public String getSelectedBoitierNom() {
        return SelectedBoitierNom;
    }

    public void setSelectedBoitierNom(String SelectedBoitierNom) {
        this.SelectedBoitierNom = SelectedBoitierNom;
    }
    
    public void BoitierValueChanged() {
        try {
            SelectedBoitier = BoitierDao.getBoitierByNom(SelectedBoitierNom);
        } catch (NullPointerException f) {
            System.err.println(f);
        }
    }
}