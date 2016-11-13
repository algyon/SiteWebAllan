/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuration;

import CarteMere.CarteMere;
import CarteGraphique.CarteGraphique;
import Boitier.Boitier;
import Alimentation.Alimentation;
import Cooling.Cooling;
import Cpu.Cpu;
import Ram.Ram;
import Stockage.Stockage;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author David
 */
@Entity
@Table(name = "configuration")
@NamedQueries({
    @NamedQuery(name = "Configuration.findAll", query = "SELECT c FROM Configuration c"),
    @NamedQuery(name = "Configuration.findByNomConfig", query = "SELECT c FROM Configuration c WHERE c.nomConfig = :nomConfig"),
    @NamedQuery(name = "Configuration.findByImg", query = "SELECT c FROM Configuration c WHERE c.img = :img")})
public class Configuration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom_config")
    private String nomConfig;
    @Size(max = 255)
    @Column(name = "img")
    private String img;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "nom_alim", referencedColumnName = "nom_alim")
    @ManyToOne(optional = false)
    private Alimentation nomAlim;
    @JoinColumn(name = "nom_boitier", referencedColumnName = "nom_boitier")
    @ManyToOne(optional = false)
    private Boitier nomBoitier;
    @JoinColumn(name = "nom_cg", referencedColumnName = "nom_cg")
    @ManyToOne(optional = false)
    private CarteGraphique nomCg;
    @JoinColumn(name = "nom_cm", referencedColumnName = "nom_cm")
    @ManyToOne(optional = false)
    private CarteMere nomCm;
    @JoinColumn(name = "nom_cooling", referencedColumnName = "nom_cooling")
    @ManyToOne(optional = false)
    private Cooling nomCooling;
    @JoinColumn(name = "nom_cpu", referencedColumnName = "nom_cpu")
    @ManyToOne(optional = false)
    private Cpu nomCpu;
    @JoinColumn(name = "nom_ram", referencedColumnName = "nom_ram")
    @ManyToOne(optional = false)
    private Ram nomRam;
    @JoinColumn(name = "nom_stockage", referencedColumnName = "nom_stockage")
    @ManyToOne(optional = false)
    private Stockage nomStockage;

    public Configuration() {
    }

    public Configuration(String nomConfig) {
        this.nomConfig = nomConfig;
    }

    public String getNomConfig() {
        return nomConfig;
    }

    public void setNomConfig(String nomConfig) {
        this.nomConfig = nomConfig;
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

    public Alimentation getNomAlim() {
        return nomAlim;
    }

    public void setNomAlim(Alimentation nomAlim) {
        this.nomAlim = nomAlim;
    }

    public Boitier getNomBoitier() {
        return nomBoitier;
    }

    public void setNomBoitier(Boitier nomBoitier) {
        this.nomBoitier = nomBoitier;
    }

    public CarteGraphique getNomCg() {
        return nomCg;
    }

    public void setNomCg(CarteGraphique nomCg) {
        this.nomCg = nomCg;
    }

    public CarteMere getNomCm() {
        return nomCm;
    }

    public void setNomCm(CarteMere nomCm) {
        this.nomCm = nomCm;
    }

    public Cooling getNomCooling() {
        return nomCooling;
    }

    public void setNomCooling(Cooling nomCooling) {
        this.nomCooling = nomCooling;
    }

    public Cpu getNomCpu() {
        return nomCpu;
    }

    public void setNomCpu(Cpu nomCpu) {
        this.nomCpu = nomCpu;
    }

    public Ram getNomRam() {
        return nomRam;
    }

    public void setNomRam(Ram nomRam) {
        this.nomRam = nomRam;
    }

    public Stockage getNomStockage() {
        return nomStockage;
    }

    public void setNomStockage(Stockage nomStockage) {
        this.nomStockage = nomStockage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomConfig != null ? nomConfig.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Configuration)) {
            return false;
        }
        Configuration other = (Configuration) object;
        if ((this.nomConfig == null && other.nomConfig != null) || (this.nomConfig != null && !this.nomConfig.equals(other.nomConfig))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomConfig;
    }

}
