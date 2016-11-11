/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarteMere;

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
@Table(name = "carte_mere")
@NamedQueries({
    @NamedQuery(name = "CarteMere.findAll", query = "SELECT c FROM CarteMere c"),
    @NamedQuery(name = "CarteMere.findByNomCm", query = "SELECT c FROM CarteMere c WHERE c.nomCm = :nomCm"),
    @NamedQuery(name = "CarteMere.findByChipset", query = "SELECT c FROM CarteMere c WHERE c.chipset = :chipset"),
    @NamedQuery(name = "CarteMere.findBySocket", query = "SELECT c FROM CarteMere c WHERE c.socket = :socket"),
    @NamedQuery(name = "CarteMere.findByNbEmpRam", query = "SELECT c FROM CarteMere c WHERE c.nbEmpRam = :nbEmpRam"),
    @NamedQuery(name = "CarteMere.findByNbPcie", query = "SELECT c FROM CarteMere c WHERE c.nbPcie = :nbPcie"),
    @NamedQuery(name = "CarteMere.findByNbSata", query = "SELECT c FROM CarteMere c WHERE c.nbSata = :nbSata"),
    @NamedQuery(name = "CarteMere.findByNbUsb", query = "SELECT c FROM CarteMere c WHERE c.nbUsb = :nbUsb"),
    @NamedQuery(name = "CarteMere.findByFormat", query = "SELECT c FROM CarteMere c WHERE c.format = :format"),
    @NamedQuery(name = "CarteMere.findByImg", query = "SELECT c FROM CarteMere c WHERE c.img = :img"),
    @NamedQuery(name = "CarteMere.findByDescription", query = "SELECT c FROM CarteMere c WHERE c.description = :description"),
    @NamedQuery(name = "CarteMere.findByPrix", query = "SELECT c FROM CarteMere c WHERE c.prix = :prix")})
public class CarteMere implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom_cm")
    private String nomCm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "chipset")
    private String chipset;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "socket")
    private String socket;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nb_emp_ram")
    private int nbEmpRam;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nb_pcie")
    private int nbPcie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nb_sata")
    private int nbSata;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nb_usb")
    private int nbUsb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "format")
    private String format;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nomCm")
    private Collection<Configuration> configurationCollection;

    public CarteMere() {
    }

    public CarteMere(String nomCm) {
        this.nomCm = nomCm;
    }

    public CarteMere(String nomCm, String chipset, String socket, int nbEmpRam, int nbPcie, int nbSata, int nbUsb, String format, float prix) {
        this.nomCm = nomCm;
        this.chipset = chipset;
        this.socket = socket;
        this.nbEmpRam = nbEmpRam;
        this.nbPcie = nbPcie;
        this.nbSata = nbSata;
        this.nbUsb = nbUsb;
        this.format = format;
        this.prix = prix;
    }

    public String getNomCm() {
        return nomCm;
    }

    public void setNomCm(String nomCm) {
        this.nomCm = nomCm;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public int getNbEmpRam() {
        return nbEmpRam;
    }

    public void setNbEmpRam(int nbEmpRam) {
        this.nbEmpRam = nbEmpRam;
    }

    public int getNbPcie() {
        return nbPcie;
    }

    public void setNbPcie(int nbPcie) {
        this.nbPcie = nbPcie;
    }

    public int getNbSata() {
        return nbSata;
    }

    public void setNbSata(int nbSata) {
        this.nbSata = nbSata;
    }

    public int getNbUsb() {
        return nbUsb;
    }

    public void setNbUsb(int nbUsb) {
        this.nbUsb = nbUsb;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
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
        hash += (nomCm != null ? nomCm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarteMere)) {
            return false;
        }
        CarteMere other = (CarteMere) object;
        if ((this.nomCm == null && other.nomCm != null) || (this.nomCm != null && !this.nomCm.equals(other.nomCm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomCm;
    }
    
}
