/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commande;

import Configuration.Configuration;
import Configuration.ConfigurationControl;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;

/**
 *
 * @author David
 *
 */
@Named(value = "CommandeControl")
@SessionScoped
public class CommandeControl implements Serializable {

    @EJB
    private CommandeDao CommandeDao;

    private Commande CommandeSaisie;
    private ConfigurationControl ConfigurationControl;

    private boolean CommandeExpe;
    private boolean CommandeMontage;
    private float PrixTot;

    public CommandeControl() {
        CommandeSaisie = new Commande();
    }

    public List<Commande> getAllCommande() {
        return CommandeDao.getAllCommande();
    }

    public Commande getSaisie() {
        return CommandeSaisie;
    }

    public void setSaisie(Commande Commande) {
        this.CommandeSaisie = Commande;
    }

    public String calcPrixTotal(float prix) {
        if (CommandeSaisie.getExpedition()) {
            prix += 15.0;
        }

        if (CommandeSaisie.getMontage()) {
            prix += 30.0;
        }
        this.setPrixTot(prix);
        return "Paiement";
    }

    public String save(Configuration config) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String dateString;
        dateString = sdf.format(date);
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        CommandeSaisie.setNomCpu(config.getNomCpu().getNomCpu());
        CommandeSaisie.setNomCm(config.getNomCm().getNomCm());
        CommandeSaisie.setNomCg(config.getNomCg().getNomCg());
        CommandeSaisie.setNomRam(config.getNomRam().getNomRam());
        CommandeSaisie.setNomStockage(config.getNomStockage().getNomStockage());
        CommandeSaisie.setNomCooling(config.getNomCooling().getNomCooling());
        CommandeSaisie.setNomBoitier(config.getNomBoitier().getNomBoitier());
        CommandeSaisie.setNomAlim(config.getNomAlim().getNomAlim());
        CommandeSaisie.setDateCommande(date);
        CommandeSaisie.setPrixTotal(PrixTot);

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

    public String getLivraisonToString() {
        String livraisonToString;
        if (CommandeSaisie.getExpedition() == true) {
            livraisonToString = "Livraison ";
        } else {
            livraisonToString = " Pas de Livraison ";
        }
        return livraisonToString;
    }

    public String getMontageToString() {
        String MontageToString;
        if (CommandeSaisie.getMontage() == true) {
            MontageToString = "Montage de la configuration";
        } else {
            MontageToString = "Pas de montage de la configuration";
        }
        return MontageToString;
    }
    
    public String updateExpe (int CommandeId) {
        Commande Commande;
        Commande = CommandeDao.getCommandeById(CommandeId);
        Commande.setExpedition(true);
        
        CommandeDao.update(Commande);
        return "Admin";
    }
    
    public String getLivraisonToString_ADM(boolean bool) {
        String livraisonToString;
        if (bool == true) {
            livraisonToString = "Livraison ";
        } else {
            livraisonToString = " Pas de Livraison ";
        }
        return livraisonToString;
    }
    
    public String getMontageToString_ADM(boolean bool) {
        String MontageToString;
        if (bool == true) {
            MontageToString = "Montage de la configuration";
        } else {
            MontageToString = "Pas de montage de la configuration";
        }
        return MontageToString;
    }

    public float getPrixTot() {
        return PrixTot;
    }

    public void setPrixTot(float PrixTot) {
        this.PrixTot = PrixTot;
    }

}
