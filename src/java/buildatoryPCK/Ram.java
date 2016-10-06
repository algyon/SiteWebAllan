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
@Table(name = "ram")
@NamedQueries({
    @NamedQuery(name = "Ram.findAll", query = "SELECT r FROM Ram r"),
    @NamedQuery(name = "Ram.findByNomRam", query = "SELECT r FROM Ram r WHERE r.nomRam = :nomRam"),
    @NamedQuery(name = "Ram.findByCapacite", query = "SELECT r FROM Ram r WHERE r.capacite = :capacite"),
    @NamedQuery(name = "Ram.findByTypeRam", query = "SELECT r FROM Ram r WHERE r.typeRam = :typeRam"),
    @NamedQuery(name = "Ram.findByFrequence", query = "SELECT r FROM Ram r WHERE r.frequence = :frequence"),
    @NamedQuery(name = "Ram.findByImg", query = "SELECT r FROM Ram r WHERE r.img = :img"),
    @NamedQuery(name = "Ram.findByDescription", query = "SELECT r FROM Ram r WHERE r.description = :description"),
    @NamedQuery(name = "Ram.findByPrix", query = "SELECT r FROM Ram r WHERE r.prix = :prix")})
public class Ram implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom_ram")
    private String nomRam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "capacite")
    private String capacite;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "type_ram")
    private String typeRam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "frequence")
    private String frequence;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nomRam")
    private Collection<Configuration> configurationCollection;
    @JoinColumn(name = "fabriquant_id", referencedColumnName = "fabriquant_id")
    @ManyToOne(optional = false)
    private Fabriquant fabriquantId;

    public Ram() {
    }

    public Ram(String nomRam) {
        this.nomRam = nomRam;
    }

    public Ram(String nomRam, String capacite, String typeRam, String frequence, float prix) {
        this.nomRam = nomRam;
        this.capacite = capacite;
        this.typeRam = typeRam;
        this.frequence = frequence;
        this.prix = prix;
    }

    public String getNomRam() {
        return nomRam;
    }

    public void setNomRam(String nomRam) {
        this.nomRam = nomRam;
    }

    public String getCapacite() {
        return capacite;
    }

    public void setCapacite(String capacite) {
        this.capacite = capacite;
    }

    public String getTypeRam() {
        return typeRam;
    }

    public void setTypeRam(String typeRam) {
        this.typeRam = typeRam;
    }

    public String getFrequence() {
        return frequence;
    }

    public void setFrequence(String frequence) {
        this.frequence = frequence;
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
        hash += (nomRam != null ? nomRam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ram)) {
            return false;
        }
        Ram other = (Ram) object;
        if ((this.nomRam == null && other.nomRam != null) || (this.nomRam != null && !this.nomRam.equals(other.nomRam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "buildatoryPCK.Ram[ nomRam=" + nomRam + " ]";
    }

}
