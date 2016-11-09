/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildatoryPCK;

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

@Named(value = "CarteMereControl")
@ViewScoped
public class CarteMereControl implements Serializable{
    
    @EJB
    private CarteMereDao CarteMereDao;
    private CarteMere CMSaisie;
    private CarteMere SelectedCM;
    private String SelectedCMNom;
    
    
    public CarteMereControl() {
        CMSaisie = new CarteMere();
        SelectedCM = new CarteMere();
    }

    @PostConstruct
    public void init() {
        SelectedCM = CarteMereDao.getCMByNom("Asus MAXIMUS VIII RANGER");
    }
    
    public List<CarteMere> getAllCarteMeres() {
        return CarteMereDao.getAllCarteMere();
    }

    public CarteMere getSaisie() {
        return CMSaisie;
    }

    public void setSaisie(CarteMere CMSaisie) {
        this.CMSaisie = CMSaisie;
    }

    public String save() {
        CarteMereDao.save(CMSaisie);
        return "liste";
    }

    public String delete() {
        CarteMereDao.delete(CMSaisie);
        return "liste";
    }

    public String modify() {
        CarteMereDao.update(CMSaisie);
        return "liste";
    }
     
    /*
    public void lireCarteMere(ComponentSystemEvent event) {
        CMSaisie = CarteMereDao.getCarteMere();
    }*/

    public String getSelectedCMNom() {
        return SelectedCMNom;
    }

    public void setSelectedCMNom(String SelectedCMNom) {
        this.SelectedCMNom = SelectedCMNom;
    }
    
    public CarteMere getSelectedCM() {
        return SelectedCM;
    }
    
    public void CMValueChanged() {
        try {
            SelectedCM = CarteMereDao.getCMByNom(SelectedCMNom);
        } catch (NullPointerException f) {
            System.err.println(f.getMessage());
        }
    }
    
}
