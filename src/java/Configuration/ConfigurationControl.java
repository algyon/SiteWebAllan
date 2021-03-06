/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuration;

import Alimentation.AlimentationDao;
import Boitier.BoitierDao;
import CarteGraphique.CarteGraphiqueDao;
import CarteMere.CarteMereDao;
import Cooling.CoolingDao;
import Cpu.CpuDao;
import Ram.RamDao;
import Stockage.StockageDao;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Alexandra
 * 
 */

@Named(value = "configurationControl")
@SessionScoped
public class ConfigurationControl implements Serializable {

    @EJB
    private CpuDao CpuDao;
    @EJB
    private AlimentationDao AlimDao;
    @EJB
    private BoitierDao BoitierDao;
    @EJB
    private CarteGraphiqueDao CgDao;
    @EJB
    private CarteMereDao CmDao;
    @EJB
    private CoolingDao CoolingDao;
    @EJB
    private RamDao RamDao;
    @EJB
    private StockageDao StockageDao;

    @EJB
    private ConfigurationDao ConfigurationDao;
    private Configuration ConfigurationSaisie;
    private Configuration SelectedConfig;
    private float PrixSelectedConfig;

    /**
     * Creates a new instance of ConfigurationControl
     */
    public ConfigurationControl() {
    }

    @PostConstruct
    public void init() {
        ConfigurationSaisie = new Configuration();
        SelectedConfig = new Configuration();
    }

    public List<Configuration> getAllConfigurations() {
        return ConfigurationDao.getAllConfiguration();
    }

    public Configuration getSaisie() {
        return ConfigurationSaisie;
    }

    public void setSaisie(Configuration ConfigurationSaisie) {
        this.ConfigurationSaisie = ConfigurationSaisie;
    }

    public String save() {
        ConfigurationDao.save(ConfigurationSaisie);
        return "liste";
    }

    public String delete() {
        ConfigurationDao.delete(ConfigurationSaisie);
        return "liste";
    }

    public String modify() {
        ConfigurationDao.update(ConfigurationSaisie);
        return "liste";
    }

    public Configuration getSelectedConfig() {
        if (SelectedConfig.getNomConfig() == null) {
            System.out.println("Selected config initialisé");
            SelectedConfig = ConfigurationDao.getConfigurationByNom(getNomConfig());
            this.setPrixBuild();
        }
        return SelectedConfig;
    }

    public void setSelectedConfig(Configuration SelectedConfig) {
        this.SelectedConfig = SelectedConfig;
    }

    public float getPrixSelectedConfig() {
        return PrixSelectedConfig;
    }

    public void setPrixSelectedConfig(float PrixSelectedConfig) {
        this.PrixSelectedConfig = PrixSelectedConfig;
    }

    public String getParamValueNameConfig(FacesContext fc) {

        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        return params.get("nomConfig");
    }

    public String getNomConfig() {
        FacesContext fc = FacesContext.getCurrentInstance();
        return getParamValueNameConfig(fc);
    }

    public void cpuValueChanged() {
        try {
            SelectedConfig.setNomCpu(CpuDao.getCpuByNom(SelectedConfig.getNomCpu().getNomCpu()));
            this.setPrixBuild();
        } catch (NullPointerException f) {
            System.err.println(f);
        }
    }

    public void cmValueChanged() {
        try {
            SelectedConfig.setNomCm(CmDao.getCMByNom(SelectedConfig.getNomCm().getNomCm()));
            this.setPrixBuild();
        } catch (NullPointerException f) {
            System.err.println(f);
        }
    }

    public void cgValueChanged() {
        try {
            SelectedConfig.setNomCg(CgDao.getCgByNom(SelectedConfig.getNomCg().getNomCg()));
            this.setPrixBuild();
        } catch (NullPointerException f) {
            System.err.println(f);
        }
    }

    public void stockageValueChanged() {
        try {
            SelectedConfig.setNomStockage(StockageDao.getStockageByNom(SelectedConfig.getNomStockage().getNomStockage()));
            this.setPrixBuild();
        } catch (NullPointerException f) {
            System.err.println(f);
        }
    }

    public void ramValueChanged() {
        try {
            SelectedConfig.setNomRam(RamDao.getRamByNom(SelectedConfig.getNomRam().getNomRam()));
            this.setPrixBuild();
        } catch (NullPointerException f) {
            System.err.println(f);
        }
    }

    public void coolingValueChanged() {
        try {
            SelectedConfig.setNomCooling(CoolingDao.getCoolingByNom(SelectedConfig.getNomCooling().getNomCooling()));
            this.setPrixBuild();
        } catch (NullPointerException f) {
            System.err.println(f);
        }
    }

    public void alimentationValueChanged() {
        try {
            SelectedConfig.setNomAlim(AlimDao.getAlimByNom(SelectedConfig.getNomAlim().getNomAlim()));
            this.setPrixBuild();
        } catch (NullPointerException f) {
            System.err.println(f);
        }
    }

    public void boitierValueChanged() {
        try {
            SelectedConfig.setNomBoitier(BoitierDao.getBoitierByNom(SelectedConfig.getNomBoitier().getNomBoitier()));
            this.setPrixBuild();
        } catch (NullPointerException f) {
            System.err.println(f);
        }
    }

    public String sliAvailable() {
        String SliYesNo = "";
        try {
            if (SelectedConfig.getNomCg().getSli() == 1) {
                SliYesNo = "Oui";
            } else {
                SliYesNo = "Non";
            }
        } catch (NullPointerException f) {
            System.err.println(f.getMessage());
        }
        return SliYesNo;
    }

    public String calculPrixDiff(float prixSelect, String nomElement) {
        float Prixcalc = 0;
        String StringPrixCalc;

        if (null != nomElement) {
            switch (nomElement) {
                case "stockage":
                    Prixcalc = prixSelect - this.getSelectedConfig().getNomStockage().getPrix();
                    break;
                case "cpu":
                    Prixcalc = prixSelect - this.getSelectedConfig().getNomCpu().getPrix();
                    break;
                case "cm":
                    Prixcalc = prixSelect - this.getSelectedConfig().getNomCm().getPrix();
                    break;
                case "cg":
                    Prixcalc = prixSelect - this.getSelectedConfig().getNomCg().getPrix();
                    break;
                case "alim":
                    Prixcalc = prixSelect - this.getSelectedConfig().getNomAlim().getPrix();
                    break;
                case "boitier":
                    Prixcalc = prixSelect - this.getSelectedConfig().getNomBoitier().getPrix();
                    break;
                case "ram":
                    Prixcalc = prixSelect - this.getSelectedConfig().getNomRam().getPrix();
                    break;
                case "cooling":
                    Prixcalc = prixSelect - this.getSelectedConfig().getNomCooling().getPrix();
                    break;
                default:
                    break;
            }
        }

        if (Prixcalc < 0.0) {
            StringPrixCalc = " " + BigDecimal.valueOf(Prixcalc).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        } else if (Prixcalc == 0.0) {
            StringPrixCalc = "0.0";
        } else {
            StringPrixCalc = " + " + BigDecimal.valueOf(Prixcalc).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        }
        return StringPrixCalc;
    }

    public float getPrix(String nomConfig) {
        float PrixConfig;
        PrixConfig = 0;
        try {
            PrixConfig = this.ConfigurationDao.getConfigurationByNom(nomConfig).getNomCpu().getPrix()
                    + this.ConfigurationDao.getConfigurationByNom(nomConfig).getNomCm().getPrix()
                    + this.ConfigurationDao.getConfigurationByNom(nomConfig).getNomCg().getPrix()
                    + this.ConfigurationDao.getConfigurationByNom(nomConfig).getNomRam().getPrix()
                    + this.ConfigurationDao.getConfigurationByNom(nomConfig).getNomStockage().getPrix()
                    + this.ConfigurationDao.getConfigurationByNom(nomConfig).getNomBoitier().getPrix()
                    + this.ConfigurationDao.getConfigurationByNom(nomConfig).getNomAlim().getPrix()
                    + this.ConfigurationDao.getConfigurationByNom(nomConfig).getNomCooling().getPrix();
        } catch (NullPointerException e) {
            e.getMessage();
        }

        return BigDecimal.valueOf(PrixConfig).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
    }

    public void setPrixBuild() {
        float PrixConfig;
        PrixConfig = 0;
        try {
            PrixConfig = SelectedConfig.getNomAlim().getPrix()
                    + SelectedConfig.getNomCpu().getPrix()
                    + SelectedConfig.getNomCg().getPrix()
                    + SelectedConfig.getNomCm().getPrix()
                    + SelectedConfig.getNomRam().getPrix()
                    + SelectedConfig.getNomCooling().getPrix()
                    + SelectedConfig.getNomBoitier().getPrix()
                    + SelectedConfig.getNomStockage().getPrix();
        } catch (NullPointerException e) {
            e.getMessage();
        }
        this.setPrixSelectedConfig(BigDecimal.valueOf(PrixConfig).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());
    }
}
