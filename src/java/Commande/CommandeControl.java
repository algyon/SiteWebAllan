/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commande;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author David
 *
 */
@Named(value = "CommandeControl")
@ViewScoped
public class CommandeControl implements Serializable {

    @EJB
    private CommandeDao CommandeDao;
    private Commande CommandeSaisie;
    private boolean CommandeExpe;
    private boolean CommandeMontage;

    public CommandeControl() {
        CommandeSaisie = new Commande();
    }

    /*
    @PostConstruct
    public void init() {
        SelectedCM = CarteMereDao.getCMByNom("Asus MAXIMUS VIII RANGER");
    }*/
    public List<Commande> getAllCommande() {
        return CommandeDao.getAllCommande();
    }

    public Commande getSaisie() {
        return CommandeSaisie;
    }

    public void setSaisie(Commande Commande) {
        this.CommandeSaisie = Commande;
    }

    public String save() {
        CommandeDao.save(CommandeSaisie);
        return "Welcome";
    }

    public String delete() {
        CommandeDao.delete(CommandeSaisie);
        return "liste";
    }

    public String modify() {
        CommandeDao.update(CommandeSaisie);
        return "liste";
    }
    
    public void lireCommande(ComponentSystemEvent event) {
        CommandeSaisie = CommandeDao.getCommande();
    }

    public Commande getCommandeSaisie() {
        return CommandeSaisie;
    }

    public void setCommandeSaisie(Commande CommandeSaisie) {
        this.CommandeSaisie = CommandeSaisie;
    }

    public boolean isCommandeMontage() {
        return CommandeMontage;
    }

    public void setCommandeMontage(boolean CommandeMontage) {
        this.CommandeMontage = CommandeMontage;
    }

    public boolean isCommandeExpe() {
        return CommandeExpe;
    }

    public void setCommandeExpe(boolean CommandeExpe) {
        this.CommandeExpe = CommandeExpe;
    }
    
    
    
}
