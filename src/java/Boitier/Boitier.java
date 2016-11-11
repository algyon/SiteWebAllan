/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boitier;

import Configuration.Configuration;
import Fabriquant.Fabriquant;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author David
 */
@Entity
@Table(name = "boitier")
@NamedQueries({
    @NamedQuery(name = "Boitier.findAll", query = "SELECT b FROM Boitier b"),
    @NamedQuery(name = "Boitier.findByNomBoitier", query = "SELECT b FROM Boitier b WHERE b.nomBoitier = :nomBoitier"),
    @NamedQuery(name = "Boitier.findByType", query = "SELECT b FROM Boitier b WHERE b.type = :type"),
    @NamedQuery(name = "Boitier.findByFormatCm", query = "SELECT b FROM Boitier b WHERE b.formatCm = :formatCm"),
    @NamedQuery(name = "Boitier.findByImg", query = "SELECT b FROM Boitier b WHERE b.img = :img"),
    @NamedQuery(name = "Boitier.findByDescription", query = "SELECT b FROM Boitier b WHERE b.description = :description"),
    @NamedQuery(name = "Boitier.findByPrix", query = "SELECT b FROM Boitier b WHERE b.prix = :prix")})
public class Boitier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom_boitier")
    private String nomBoitier;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "format_cm")
    private String formatCm;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nomBoitier")
    private Collection<Configuration> configurationCollection;

    public Boitier() {
    }

    public Boitier(String nomBoitier) {
        this.nomBoitier = nomBoitier;
    }

    public Boitier(String nomBoitier, String type, String formatCm, float prix) {
        this.nomBoitier = nomBoitier;
        this.type = type;
        this.formatCm = formatCm;
        this.prix = prix;
    }

    public String getNomBoitier() {
        return nomBoitier;
    }

    public void setNomBoitier(String nomBoitier) {
        this.nomBoitier = nomBoitier;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormatCm() {
        return formatCm;
    }

    public void setFormatCm(String formatCm) {
        this.formatCm = formatCm;
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

    public Collection<Configuration> getConfigurationCollection() {
        return configurationCollection;
    }

    public void setConfigurationCollection(Collection<Configuration> configurationCollection) {
        this.configurationCollection = configurationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomBoitier != null ? nomBoitier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boitier)) {
            return false;
        }
        Boitier other = (Boitier) object;
        if ((this.nomBoitier == null && other.nomBoitier != null) || (this.nomBoitier != null && !this.nomBoitier.equals(other.nomBoitier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomBoitier;
    }
    
}
