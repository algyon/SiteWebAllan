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

@Named(value = "StockageControl")
@ViewScoped
public class StockageControl implements Serializable{
    
    @EJB
    private StockageDao StockageDao;
    private Stockage StorageSaisie;
    
    
    public StockageControl() {
        StorageSaisie = new Stockage();
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

    public void lireStockage(ComponentSystemEvent event) {
        StorageSaisie = StockageDao.getStockage();
    }
}
