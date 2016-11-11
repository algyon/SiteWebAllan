/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarteGraphique;

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
@Table(name = "carte_graphique")
@NamedQueries({
    @NamedQuery(name = "CarteGraphique.findAll", query = "SELECT c FROM CarteGraphique c"),
    @NamedQuery(name = "CarteGraphique.findByNomCg", query = "SELECT c FROM CarteGraphique c WHERE c.nomCg = :nomCg"),
    @NamedQuery(name = "CarteGraphique.findByGpu", query = "SELECT c FROM CarteGraphique c WHERE c.gpu = :gpu"),
    @NamedQuery(name = "CarteGraphique.findByGpuClock", query = "SELECT c FROM CarteGraphique c WHERE c.gpuClock = :gpuClock"),
    @NamedQuery(name = "CarteGraphique.findByCapaciteMemoire", query = "SELECT c FROM CarteGraphique c WHERE c.capaciteMemoire = :capaciteMemoire"),
    @NamedQuery(name = "CarteGraphique.findByTypeMemoire", query = "SELECT c FROM CarteGraphique c WHERE c.typeMemoire = :typeMemoire"),
    @NamedQuery(name = "CarteGraphique.findBySli", query = "SELECT c FROM CarteGraphique c WHERE c.sli = :sli"),
    @NamedQuery(name = "CarteGraphique.findByImg", query = "SELECT c FROM CarteGraphique c WHERE c.img = :img"),
    @NamedQuery(name = "CarteGraphique.findByDescription", query = "SELECT c FROM CarteGraphique c WHERE c.description = :description"),
    @NamedQuery(name = "CarteGraphique.findByPrix", query = "SELECT c FROM CarteGraphique c WHERE c.prix = :prix")})
public class CarteGraphique implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom_cg")
    private String nomCg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "gpu")
    private String gpu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "gpu_clock")
    private String gpuClock;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "capacite_memoire")
    private String capaciteMemoire;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "type_memoire")
    private String typeMemoire;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sli")
    private int sli;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nomCg")
    private Collection<Configuration> configurationCollection;
    @JoinColumn(name = "fabriquant_id", referencedColumnName = "fabriquant_id")
    @ManyToOne(optional = false)
    private Fabriquant fabriquantId;

    public CarteGraphique() {
    }

    public CarteGraphique(String nomCg) {
        this.nomCg = nomCg;
    }

    public CarteGraphique(String nomCg, String gpu, String gpuClock, String capaciteMemoire, String typeMemoire, int sli, float prix) {
        this.nomCg = nomCg;
        this.gpu = gpu;
        this.gpuClock = gpuClock;
        this.capaciteMemoire = capaciteMemoire;
        this.typeMemoire = typeMemoire;
        this.sli = sli;
        this.prix = prix;
    }

    public String getNomCg() {
        return nomCg;
    }

    public void setNomCg(String nomCg) {
        this.nomCg = nomCg;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getGpuClock() {
        return gpuClock;
    }

    public void setGpuClock(String gpuClock) {
        this.gpuClock = gpuClock;
    }

    public String getCapaciteMemoire() {
        return capaciteMemoire;
    }

    public void setCapaciteMemoire(String capaciteMemoire) {
        this.capaciteMemoire = capaciteMemoire;
    }

    public String getTypeMemoire() {
        return typeMemoire;
    }

    public void setTypeMemoire(String typeMemoire) {
        this.typeMemoire = typeMemoire;
    }

    public int getSli() {
        return sli;
    }

    public void setSli(int sli) {
        this.sli = sli;
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
        hash += (nomCg != null ? nomCg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarteGraphique)) {
            return false;
        }
        CarteGraphique other = (CarteGraphique) object;
        if ((this.nomCg == null && other.nomCg != null) || (this.nomCg != null && !this.nomCg.equals(other.nomCg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomCg;
    }
    
}
