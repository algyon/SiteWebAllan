/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cpu;

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
@Table(name = "cpu")
@NamedQueries({
    @NamedQuery(name = "Cpu.findAll", query = "SELECT c FROM Cpu c"),
    @NamedQuery(name = "Cpu.findByNomCpu", query = "SELECT c FROM Cpu c WHERE c.nomCpu = :nomCpu"),
    @NamedQuery(name = "Cpu.findBySerie", query = "SELECT c FROM Cpu c WHERE c.serie = :serie"),
    @NamedQuery(name = "Cpu.findByFrequence", query = "SELECT c FROM Cpu c WHERE c.frequence = :frequence"),
    @NamedQuery(name = "Cpu.findByNbCoeur", query = "SELECT c FROM Cpu c WHERE c.nbCoeur = :nbCoeur"),
    @NamedQuery(name = "Cpu.findByMemoireCache", query = "SELECT c FROM Cpu c WHERE c.memoireCache = :memoireCache"),
    @NamedQuery(name = "Cpu.findBySocket", query = "SELECT c FROM Cpu c WHERE c.socket = :socket"),
    @NamedQuery(name = "Cpu.findByImg", query = "SELECT c FROM Cpu c WHERE c.img = :img"),
    @NamedQuery(name = "Cpu.findByDescription", query = "SELECT c FROM Cpu c WHERE c.description = :description"),
    @NamedQuery(name = "Cpu.findByPrix", query = "SELECT c FROM Cpu c WHERE c.prix = :prix")})
public class Cpu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom_cpu")
    private String nomCpu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "serie")
    private String serie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "frequence")
    private String frequence;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nb_coeur")
    private String nbCoeur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "memoire_cache")
    private String memoireCache;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "socket")
    private String socket;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nomCpu")
    private Collection<Configuration> configurationCollection;
    @JoinColumn(name = "fabriquant_id", referencedColumnName = "fabriquant_id")
    @ManyToOne(optional = false)
    private Fabriquant fabriquantId;

    public Cpu() {
    }

    public Cpu(String nomCpu) {
        this.nomCpu = nomCpu;
    }

    public Cpu(String nomCpu, String serie, String frequence, String nbCoeur, String memoireCache, String socket, float prix) {
        this.nomCpu = nomCpu;
        this.serie = serie;
        this.frequence = frequence;
        this.nbCoeur = nbCoeur;
        this.memoireCache = memoireCache;
        this.socket = socket;
        this.prix = prix;
    }

    public String getNomCpu() {
        return nomCpu;
    }

    public void setNomCpu(String nomCpu) {
        this.nomCpu = nomCpu;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getFrequence() {
        return frequence;
    }

    public void setFrequence(String frequence) {
        this.frequence = frequence;
    }

    public String getNbCoeur() {
        return nbCoeur;
    }

    public void setNbCoeur(String nbCoeur) {
        this.nbCoeur = nbCoeur;
    }

    public String getMemoireCache() {
        return memoireCache;
    }

    public void setMemoireCache(String memoireCache) {
        this.memoireCache = memoireCache;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
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
        hash += (nomCpu != null ? nomCpu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cpu)) {
            return false;
        }
        Cpu other = (Cpu) object;
        if ((this.nomCpu == null && other.nomCpu != null) || (this.nomCpu != null && !this.nomCpu.equals(other.nomCpu))) {
            return false;
        }
        return true;
    }
    
    
      @Override
    public String toString() {
        return nomCpu;
    }
    
}
