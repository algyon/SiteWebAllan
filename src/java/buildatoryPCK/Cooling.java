/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildatoryPCK;

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
@Table(name = "cooling")
@NamedQueries({
    @NamedQuery(name = "Cooling.findAll", query = "SELECT c FROM Cooling c"),
    @NamedQuery(name = "Cooling.findByNomCooling", query = "SELECT c FROM Cooling c WHERE c.nomCooling = :nomCooling"),
    @NamedQuery(name = "Cooling.findByType", query = "SELECT c FROM Cooling c WHERE c.type = :type"),
    @NamedQuery(name = "Cooling.findByHeatSinkMat", query = "SELECT c FROM Cooling c WHERE c.heatSinkMat = :heatSinkMat"),
    @NamedQuery(name = "Cooling.findByImg", query = "SELECT c FROM Cooling c WHERE c.img = :img"),
    @NamedQuery(name = "Cooling.findByDescription", query = "SELECT c FROM Cooling c WHERE c.description = :description"),
    @NamedQuery(name = "Cooling.findByPrix", query = "SELECT c FROM Cooling c WHERE c.prix = :prix")})
public class Cooling implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom_cooling")
    private String nomCooling;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "heat_sink_mat")
    private String heatSinkMat;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nomCooling")
    private Collection<Configuration> configurationCollection;
    @JoinColumn(name = "fabriquant_id", referencedColumnName = "fabriquant_id")
    @ManyToOne(optional = false)
    private Fabriquant fabriquantId;

    public Cooling() {
    }

    public Cooling(String nomCooling) {
        this.nomCooling = nomCooling;
    }

    public Cooling(String nomCooling, String type, String heatSinkMat, float prix) {
        this.nomCooling = nomCooling;
        this.type = type;
        this.heatSinkMat = heatSinkMat;
        this.prix = prix;
    }

    public String getNomCooling() {
        return nomCooling;
    }

    public void setNomCooling(String nomCooling) {
        this.nomCooling = nomCooling;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHeatSinkMat() {
        return heatSinkMat;
    }

    public void setHeatSinkMat(String heatSinkMat) {
        this.heatSinkMat = heatSinkMat;
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

    public Collection<Configuration> getConfigurationCollection() {
        return configurationCollection;
    }

    public void setConfigurationCollection(Collection<Configuration> configurationCollection) {
        this.configurationCollection = configurationCollection;
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
        hash += (nomCooling != null ? nomCooling.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cooling)) {
            return false;
        }
        Cooling other = (Cooling) object;
        if ((this.nomCooling == null && other.nomCooling != null) || (this.nomCooling != null && !this.nomCooling.equals(other.nomCooling))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomCooling;
    }
    
}
