/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildatoryPCK;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Alexandra
 */
@Entity
@Table(name = "stockage")
@NamedQueries({
    @NamedQuery(name = "Stockage.findAll", query = "SELECT s FROM Stockage s"),
    @NamedQuery(name = "Stockage.findByNomStockage", query = "SELECT s FROM Stockage s WHERE s.nomStockage = :nomStockage"),
    @NamedQuery(name = "Stockage.findByType", query = "SELECT s FROM Stockage s WHERE s.type = :type"),
    @NamedQuery(name = "Stockage.findByCapacite", query = "SELECT s FROM Stockage s WHERE s.capacite = :capacite"),
    @NamedQuery(name = "Stockage.findByInterface1", query = "SELECT s FROM Stockage s WHERE s.interface1 = :interface1"),
    @NamedQuery(name = "Stockage.findByFormat", query = "SELECT s FROM Stockage s WHERE s.format = :format"),
    @NamedQuery(name = "Stockage.findByVitesseRotation", query = "SELECT s FROM Stockage s WHERE s.vitesseRotation = :vitesseRotation"),
    @NamedQuery(name = "Stockage.findByImg", query = "SELECT s FROM Stockage s WHERE s.img = :img"),
    @NamedQuery(name = "Stockage.findByDescription", query = "SELECT s FROM Stockage s WHERE s.description = :description"),
    @NamedQuery(name = "Stockage.findByPrix", query = "SELECT s FROM Stockage s WHERE s.prix = :prix")})
public class Stockage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom_stockage")
    private String nomStockage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "capacite")
    private String capacite;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "interface")
    private String interface1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "format")
    private String format;
    @Size(max = 255)
    @Column(name = "vitesse_rotation")
    private String vitesseRotation;
    @Size(max = 255)
    @Column(name = "img")
    private String img;
    @Size(max = 1000)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prix")
    private float prix;
    @JoinColumn(name = "fabriquant_id", referencedColumnName = "fabriquant_id")
    @ManyToOne(optional = false)
    private Fabriquant fabriquantId;

    public Stockage() {
    }

    public Stockage(String nomStockage) {
        this.nomStockage = nomStockage;
    }

    public Stockage(String nomStockage, String type, String capacite, String interface1, String format, float prix) {
        this.nomStockage = nomStockage;
        this.type = type;
        this.capacite = capacite;
        this.interface1 = interface1;
        this.format = format;
        this.prix = prix;
    }

    public String getNomStockage() {
        return nomStockage;
    }

    public void setNomStockage(String nomStockage) {
        this.nomStockage = nomStockage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCapacite() {
        return capacite;
    }

    public void setCapacite(String capacite) {
        this.capacite = capacite;
    }

    public String getInterface1() {
        return interface1;
    }

    public void setInterface1(String interface1) {
        this.interface1 = interface1;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getVitesseRotation() {
        return vitesseRotation;
    }

    public void setVitesseRotation(String vitesseRotation) {
        this.vitesseRotation = vitesseRotation;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Fabriquant getFabriquantId() {
        return fabriquantId;
    }

    public void setFabriquantId(Fabriquant fabriquantId) {
        this.fabriquantId = fabriquantId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomStockage != null ? nomStockage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stockage)) {
            return false;
        }
        Stockage other = (Stockage) object;
        if ((this.nomStockage == null && other.nomStockage != null) || (this.nomStockage != null && !this.nomStockage.equals(other.nomStockage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "buildatoryPCK.Stockage[ nomStockage=" + nomStockage + " ]";
    }
    
}
