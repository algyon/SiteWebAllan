/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabriquant;

import Cpu.Cpu;
import Cooling.Cooling;
import Ram.Ram;
import Stockage.Stockage;
import CarteMere.CarteMere;
import CarteGraphique.CarteGraphique;
import Boitier.Boitier;
import Alimentation.Alimentation;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "fabriquant")
@NamedQueries({
    @NamedQuery(name = "Fabriquant.findAll", query = "SELECT f FROM Fabriquant f"),
    @NamedQuery(name = "Fabriquant.findByFabriquantId", query = "SELECT f FROM Fabriquant f WHERE f.fabriquantId = :fabriquantId"),
    @NamedQuery(name = "Fabriquant.findByNomFabriquant", query = "SELECT f FROM Fabriquant f WHERE f.nomFabriquant = :nomFabriquant")})
public class Fabriquant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fabriquant_id")
    private Integer fabriquantId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom_fabriquant")
    private String nomFabriquant;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fabriquantId")
    private Collection<Stockage> stockageCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fabriquantId")
    private Collection<CarteMere> carteMereCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fabriquantId")
    private Collection<Boitier> boitierCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fabriquantId")
    private Collection<CarteGraphique> carteGraphiqueCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fabriquantId")
    private Collection<Alimentation> alimentationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fabriquantId")
    private Collection<Cooling> coolingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fabriquantId")
    private Collection<Cpu> cpuCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fabriquantId")
    private Collection<Ram> ramCollection;

    public Fabriquant() {
    }

    public Fabriquant(Integer fabriquantId) {
        this.fabriquantId = fabriquantId;
    }

    public Fabriquant(Integer fabriquantId, String nomFabriquant) {
        this.fabriquantId = fabriquantId;
        this.nomFabriquant = nomFabriquant;
    }

    public Integer getFabriquantId() {
        return fabriquantId;
    }

    public void setFabriquantId(Integer fabriquantId) {
        this.fabriquantId = fabriquantId;
    }

    public String getNomFabriquant() {
        return nomFabriquant;
    }

    public void setNomFabriquant(String nomFabriquant) {
        this.nomFabriquant = nomFabriquant;
    }

    public Collection<Stockage> getStockageCollection() {
        return stockageCollection;
    }

    public void setStockageCollection(Collection<Stockage> stockageCollection) {
        this.stockageCollection = stockageCollection;
    }

    public Collection<CarteMere> getCarteMereCollection() {
        return carteMereCollection;
    }

    public void setCarteMereCollection(Collection<CarteMere> carteMereCollection) {
        this.carteMereCollection = carteMereCollection;
    }

    public Collection<Boitier> getBoitierCollection() {
        return boitierCollection;
    }

    public void setBoitierCollection(Collection<Boitier> boitierCollection) {
        this.boitierCollection = boitierCollection;
    }

    public Collection<CarteGraphique> getCarteGraphiqueCollection() {
        return carteGraphiqueCollection;
    }

    public void setCarteGraphiqueCollection(Collection<CarteGraphique> carteGraphiqueCollection) {
        this.carteGraphiqueCollection = carteGraphiqueCollection;
    }

    public Collection<Alimentation> getAlimentationCollection() {
        return alimentationCollection;
    }

    public void setAlimentationCollection(Collection<Alimentation> alimentationCollection) {
        this.alimentationCollection = alimentationCollection;
    }

    public Collection<Cooling> getCoolingCollection() {
        return coolingCollection;
    }

    public void setCoolingCollection(Collection<Cooling> coolingCollection) {
        this.coolingCollection = coolingCollection;
    }

    public Collection<Cpu> getCpuCollection() {
        return cpuCollection;
    }

    public void setCpuCollection(Collection<Cpu> cpuCollection) {
        this.cpuCollection = cpuCollection;
    }

    public Collection<Ram> getRamCollection() {
        return ramCollection;
    }

    public void setRamCollection(Collection<Ram> ramCollection) {
        this.ramCollection = ramCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fabriquantId != null ? fabriquantId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fabriquant)) {
            return false;
        }
        Fabriquant other = (Fabriquant) object;
        if ((this.fabriquantId == null && other.fabriquantId != null) || (this.fabriquantId != null && !this.fabriquantId.equals(other.fabriquantId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomFabriquant;
    }
    
}
