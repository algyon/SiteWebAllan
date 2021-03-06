/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cooling;

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

@Named(value = "CoolingControl")
@ViewScoped
public class CoolingControl implements Serializable{
    
    @EJB
    private CoolingDao CoolingDao;
    private Cooling CoolingSaisie;
    private Cooling SelectedCooling;
    private String SelectedCoolingNom;
    
    
    public CoolingControl() {
        CoolingSaisie = new Cooling();
    }

    public List<Cooling> getAllCoolings() {
        return CoolingDao.getAllCooling();
    }

    public Cooling getSaisie() {
        return CoolingSaisie;
    }

    public void setSaisie(Cooling CoolingSaisie) {
        this.CoolingSaisie = CoolingSaisie;
    }

    public String save() {
        CoolingDao.save(CoolingSaisie);
        return "liste";
    }

    public String delete() {
        CoolingDao.delete(CoolingSaisie);
        return "liste";
    }

    public String modify() {
        CoolingDao.update(CoolingSaisie);
        return "liste";
    }
    
    
    
    /*
    public void lireCooling(ComponentSystemEvent event) {
        CoolingSaisie = CoolingDao.getCooling();
    }*/

    public Cooling getSelectedCooling() {
        return SelectedCooling;
    }

    public String getSelectedCoolingNom() {
        return SelectedCoolingNom;
    }

    public void setSelectedCoolingNom(String SelectedCoolingNom) {
        this.SelectedCoolingNom = SelectedCoolingNom;
    }
    
    public void CoolingValueChanged() {
        try {
            SelectedCooling = CoolingDao.getCoolingByNom(SelectedCoolingNom);
        } catch (NullPointerException f) {
            System.err.println(f.getMessage());
        }
    }
}
