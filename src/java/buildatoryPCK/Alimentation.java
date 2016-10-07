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
@Table(name = "alimentation")
@NamedQueries({
    @NamedQuery(name = "Alimentation.findAll", query = "SELECT a FROM Alimentation a"),
    @NamedQuery(name = "Alimentation.findByNomAlim", query = "SELECT a FROM Alimentation a WHERE a.nomAlim = :nomAlim"),
    @NamedQuery(name = "Alimentation.findByWattsTotal", query = "SELECT a FROM Alimentation a WHERE a.wattsTotal = :wattsTotal"),
    @NamedQuery(name = "Alimentation.findByModulaire", query = "SELECT a FROM Alimentation a WHERE a.modulaire = :modulaire"),
    @NamedQuery(name = "Alimentation.findByCertification", query = "SELECT a FROM Alimentation a WHERE a.certification = :certification"),
    @NamedQuery(name = "Alimentation.findByImg", query = "SELECT a FROM Alimentation a WHERE a.img = :img"),
    @NamedQuery(name = "Alimentation.findByDescription", query = "SELECT a FROM Alimentation a WHERE a.description = :description"),
    @NamedQuery(name = "Alimentation.findByPrix", query = "SELECT a FROM Alimentation a WHERE a.prix = :prix")})
public class Alimentation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom_alim")
    private String nomAlim;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "watts_total")
    private String wattsTotal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "modulaire")
    private String modulaire;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "certification")
    private String certification;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nomAlim")
    private Collection<Configuration> configurationCollection;
    @JoinColumn(name = "fabriquant_id", referencedColumnName = "fabriquant_id")
    @ManyToOne(optional = false)
    private Fabriquant fabriquantId;

    public Alimentation() {
    }

    public Alimentation(String nomAlim) {
        this.nomAlim = nomAlim;
    }

    public Alimentation(String nomAlim, String wattsTotal, String modulaire, String certification, float prix) {
        this.nomAlim = nomAlim;
        this.wattsTotal = wattsTotal;
        this.modulaire = modulaire;
        this.certification = certification;
        this.prix = prix;
    }

    public String getNomAlim() {
        return nomAlim;
    }

    public void setNomAlim(String nomAlim) {
        this.nomAlim = nomAlim;
    }

    public String getWattsTotal() {
        return wattsTotal;
    }

    public void setWattsTotal(String wattsTotal) {
        this.wattsTotal = wattsTotal;
    }

    public String getModulaire() {
        return modulaire;
    }

    public void setModulaire(String modulaire) {
        this.modulaire = modulaire;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
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
        hash += (nomAlim != null ? nomAlim.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alimentation)) {
            return false;
        }
        Alimentation other = (Alimentation) object;
        if ((this.nomAlim == null && other.nomAlim != null) || (this.nomAlim != null && !this.nomAlim.equals(other.nomAlim))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "buildatoryPCK.Alimentation[ nomAlim=" + nomAlim + " ]";
    }
    
}
