/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stockage;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author David
 * 
 */

@Named(value = "StockageControl")
@ViewScoped
public class StockageControl implements Serializable{
    
    @EJB
    private StockageDao StockageDao;
    private Stockage StorageSaisie;
    private Stockage SelectedStockage;
    private String SelectedStockageNom;
    
    
    public StockageControl() {
        StorageSaisie = new Stockage();
    }

    @PostConstruct
    public void init() {
        SelectedStockage = StockageDao.getStockageByNom("Samsung Série 750 EVO, 250 Go, SATA III");
    }
    
    public List<Stockage> getAllStockages() {
        return StockageDao.getAllStockage();
    }

    public Stockage getSaisie() {
        return StorageSaisie;
    }

    public void setSaisie(Stockage StorageSaisie) {
        this.StorageSaisie = StorageSaisie;
    }

    public String save() {
        StockageDao.save(StorageSaisie);
        return "liste";
    }

    public String delete() {
        StockageDao.delete(StorageSaisie);
        return "liste";
    }

    public String modify() {
        StockageDao.update(StorageSaisie);
        return "liste";
    }

    public Stockage getSelectedStockage() {
        return SelectedStockage;
    }

    public String getSelectedStockageNom() {
        return SelectedStockageNom;
    }

    public void setSelectedStockageNom(String SelectedStockageNom) {
        this.SelectedStockageNom = SelectedStockageNom;
    }
      
    /**
    public void lireStockage(ComponentSystemEvent event) {
        StorageSaisie = StockageDao.getStockage();
    }*/
}
