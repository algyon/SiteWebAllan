/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commande;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author algyo
 */
@Entity
@Table(name = "commande")
@NamedQueries({
    @NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c"),
    @NamedQuery(name = "Commande.findByIdCommande", query = "SELECT c FROM Commande c WHERE c.idCommande = :idCommande"),
    @NamedQuery(name = "Commande.findByDateCommande", query = "SELECT c FROM Commande c WHERE c.dateCommande = :dateCommande"),
    @NamedQuery(name = "Commande.findByNomCpu", query = "SELECT c FROM Commande c WHERE c.nomCpu = :nomCpu"),
    @NamedQuery(name = "Commande.findByNomCm", query = "SELECT c FROM Commande c WHERE c.nomCm = :nomCm"),
    @NamedQuery(name = "Commande.findByNomCg", query = "SELECT c FROM Commande c WHERE c.nomCg = :nomCg"),
    @NamedQuery(name = "Commande.findByNomRam", query = "SELECT c FROM Commande c WHERE c.nomRam = :nomRam"),
    @NamedQuery(name = "Commande.findByNomStockage", query = "SELECT c FROM Commande c WHERE c.nomStockage = :nomStockage"),
    @NamedQuery(name = "Commande.findByNomCooling", query = "SELECT c FROM Commande c WHERE c.nomCooling = :nomCooling"),
    @NamedQuery(name = "Commande.findByNomBoitier", query = "SELECT c FROM Commande c WHERE c.nomBoitier = :nomBoitier"),
    @NamedQuery(name = "Commande.findByNomAlim", query = "SELECT c FROM Commande c WHERE c.nomAlim = :nomAlim"),
    @NamedQuery(name = "Commande.findByMontage", query = "SELECT c FROM Commande c WHERE c.montage = :montage"),
    @NamedQuery(name = "Commande.findByExpedition", query = "SELECT c FROM Commande c WHERE c.expedition = :expedition"),
    @NamedQuery(name = "Commande.findByNomU", query = "SELECT c FROM Commande c WHERE c.nomU = :nomU"),
    @NamedQuery(name = "Commande.findByPrenomU", query = "SELECT c FROM Commande c WHERE c.prenomU = :prenomU"),
    @NamedQuery(name = "Commande.findByTelephoneU", query = "SELECT c FROM Commande c WHERE c.telephoneU = :telephoneU"),
    @NamedQuery(name = "Commande.findByMailU", query = "SELECT c FROM Commande c WHERE c.mailU = :mailU"),
    @NamedQuery(name = "Commande.findByAdresseU", query = "SELECT c FROM Commande c WHERE c.adresseU = :adresseU"),
    @NamedQuery(name = "Commande.findByPrixTotal", query = "SELECT c FROM Commande c WHERE c.prixTotal = :prixTotal")})
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCommande")
    private Integer idCommande;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateCommande")
    @Temporal(TemporalType.DATE)
    private Date dateCommande;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nomCpu")
    private String nomCpu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nomCm")
    private String nomCm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nomCg")
    private String nomCg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nomRam")
    private String nomRam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nomStockage")
    private String nomStockage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nomCooling")
    private String nomCooling;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nomBoitier")
    private String nomBoitier;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nomAlim")
    private String nomAlim;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montage")
    private int montage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expedition")
    private int expedition;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nomU")
    private String nomU;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "prenomU")
    private String prenomU;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telephoneU")
    private int telephoneU;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "mailU")
    private String mailU;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "adresseU")
    private String adresseU;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prix_total")
    private float prixTotal;

    public Commande() {
    }

    public Commande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public Commande(Integer idCommande, Date dateCommande, String nomCpu, String nomCm, String nomCg, String nomRam, String nomStockage, String nomCooling, String nomBoitier, String nomAlim, int montage, int expedition, String nomU, String prenomU, int telephoneU, String mailU, String adresseU, float prixTotal) {
        this.idCommande = idCommande;
        this.dateCommande = dateCommande;
        this.nomCpu = nomCpu;
        this.nomCm = nomCm;
        this.nomCg = nomCg;
        this.nomRam = nomRam;
        this.nomStockage = nomStockage;
        this.nomCooling = nomCooling;
        this.nomBoitier = nomBoitier;
        this.nomAlim = nomAlim;
        this.montage = montage;
        this.expedition = expedition;
        this.nomU = nomU;
        this.prenomU = prenomU;
        this.telephoneU = telephoneU;
        this.mailU = mailU;
        this.adresseU = adresseU;
        this.prixTotal = prixTotal;
    }

    public Integer getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getNomCpu() {
        return nomCpu;
    }

    public void setNomCpu(String nomCpu) {
        this.nomCpu = nomCpu;
    }

    public String getNomCm() {
        return nomCm;
    }

    public void setNomCm(String nomCm) {
        this.nomCm = nomCm;
    }

    public String getNomCg() {
        return nomCg;
    }

    public void setNomCg(String nomCg) {
        this.nomCg = nomCg;
    }

    public String getNomRam() {
        return nomRam;
    }

    public void setNomRam(String nomRam) {
        this.nomRam = nomRam;
    }

    public String getNomStockage() {
        return nomStockage;
    }

    public void setNomStockage(String nomStockage) {
        this.nomStockage = nomStockage;
    }

    public String getNomCooling() {
        return nomCooling;
    }

    public void setNomCooling(String nomCooling) {
        this.nomCooling = nomCooling;
    }

    public String getNomBoitier() {
        return nomBoitier;
    }

    public void setNomBoitier(String nomBoitier) {
        this.nomBoitier = nomBoitier;
    }

    public String getNomAlim() {
        return nomAlim;
    }

    public void setNomAlim(String nomAlim) {
        this.nomAlim = nomAlim;
    }

    public int getMontage() {
        return montage;
    }

    public void setMontage(int montage) {
        this.montage = montage;
    }

    public int getExpedition() {
        return expedition;
    }

    public void setExpedition(int expedition) {
        this.expedition = expedition;
    }

    public String getNomU() {
        return nomU;
    }

    public void setNomU(String nomU) {
        this.nomU = nomU;
    }

    public String getPrenomU() {
        return prenomU;
    }

    public void setPrenomU(String prenomU) {
        this.prenomU = prenomU;
    }

    public int getTelephoneU() {
        return telephoneU;
    }

    public void setTelephoneU(int telephoneU) {
        this.telephoneU = telephoneU;
    }

    public String getMailU() {
        return mailU;
    }

    public void setMailU(String mailU) {
        this.mailU = mailU;
    }

    public String getAdresseU() {
        return adresseU;
    }

    public void setAdresseU(String adresseU) {
        this.adresseU = adresseU;
    }

    public float getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(float prixTotal) {
        this.prixTotal = prixTotal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCommande != null ? idCommande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.idCommande == null && other.idCommande != null) || (this.idCommande != null && !this.idCommande.equals(other.idCommande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Commande.Commande[ idCommande=" + idCommande + " ]";
    }
    
}
