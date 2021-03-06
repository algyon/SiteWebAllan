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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;

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
    private Commande SelectedCommande;
    private ConfigurationControl ConfigurationControl;
    private DataModel ListCommande = new ListDataModel();
    private boolean CommandeExpe;
    private boolean CommandeMontage;
    private float PrixTot;
    private int idSelectedCommande;

    public CommandeControl() {
        CommandeSaisie = new Commande();
        SelectedCommande = new Commande();
        idSelectedCommande = 0;
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
        SelectedCommande = CommandeDao.getCommande();
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

    public void updateExpe(int CommandeId) {
        Commande Commande;
        Commande = CommandeDao.getCommandeById(CommandeId);
        Commande.setIsExpedie(true);

        CommandeDao.update(Commande);
    }

    public void updateMontage(int CommandeId) {
        Commande Commande;
        Commande = CommandeDao.getCommandeById(CommandeId);
        Commande.setIsMonte(true);

        CommandeDao.update(Commande);
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
            MontageToString = "Montage";
        } else {
            MontageToString = "Pas de montage";
        }
        return MontageToString;
    }

    public float getPrixTot() {
        return PrixTot;
    }

    public void setPrixTot(float PrixTot) {
        this.PrixTot = PrixTot;
    }

    public List<Commande> CommandeToDisplay(int id) {
        System.out.println(idSelectedCommande);
        System.out.println(id);
        SelectedCommande = CommandeDao.getCommandeById(id);

        List<Commande> list = new ArrayList<Commande>();
        list.add(SelectedCommande);
        return list;
    }

    public int getIdSelectedCommande() {
        return idSelectedCommande;
    }

    public void setIdSelectedCommande(int idSelectedCommande) {
        this.idSelectedCommande = idSelectedCommande;
    }

    public Boolean rendered() {
        return idSelectedCommande == 0;
    }

    public Commande getSelectedCommande() {
        return SelectedCommande;
    }

    public void setSelectedCommande(Commande SelectedCommande) {
        this.SelectedCommande = SelectedCommande;
    }

    public void setSelectedCommandeById(int id) {
        System.out.println("Started");
        SelectedCommande = CommandeDao.getCommandeById(id);
        System.out.println("Done");
    }

    public boolean disableButtonExpedie(int id) {
        Commande Commande;
        Commande = CommandeDao.getCommandeById(id);
        if (Commande.getExpedition() == true) {
            if (Commande.getMontage() == true) {
                if (Commande.getIsMonte() == null && Commande.getIsExpedie() == null) {
                    return true;
                }
                if (Commande.getIsMonte() != null) {
                    if (Commande.getIsExpedie() != null) {
                        return true;
                    }
                    return false;
                }

            } else if (Commande.getIsExpedie() != null) {
                return true;
            }
            return false;
        }
        return true;
    }

    public boolean disableButtonMontage(int id) {
        Commande Commande;
        Commande = CommandeDao.getCommandeById(id);
        if (Commande.getMontage() == true) {
            if (Commande.getIsMonte() != null) {
                return true;
            }
            return false;
        }
        return true;
    }
}
