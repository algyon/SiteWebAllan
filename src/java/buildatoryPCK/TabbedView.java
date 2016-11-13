/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildatoryPCK;

import Alimentation.Alimentation;
import Alimentation.AlimentationDao;
import Cpu.Cpu;
import Cpu.CpuDao;
import Cooling.Cooling;
import Cooling.CoolingDao;
import Ram.Ram;
import Ram.RamDao;
import Stockage.Stockage;
import Stockage.StockageDao;
import CarteMere.CarteMereDao;
import CarteMere.CarteMere;
import CarteGraphique.CarteGraphiqueDao;
import CarteGraphique.CarteGraphique;
import Boitier.BoitierDao;
import Boitier.Boitier;
import Configuration.Configuration;
import Configuration.ConfigurationDao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class TabbedView {
    
    private String nomConfig;

    // Cpu
    private List<Cpu> CpuList;
    @EJB
    private CpuDao CpuDao;

    //Carte Mere
    private List<CarteMere> CmList;
    @EJB
    private CarteMereDao CmDao;

    //Carte Graphique
    private List<CarteGraphique> CgList;
    @EJB
    private CarteGraphiqueDao CgDao;

    // Ram
    private List<Ram> RamList;
    @EJB
    private RamDao RamDao;

    // Stockage
    private List<Stockage> StockageList;
    @EJB
    private StockageDao StockageDao;

    // Cooling
    private List<Cooling> CoolingList;
    @EJB
    private CoolingDao CoolingDao;

    // Boitier
    private List<Boitier> BoitierList;
    @EJB
    private BoitierDao BoitierDao;

    //Alim
    private List<Alimentation> AlimList;
    @EJB
    private AlimentationDao AlimentationDao;

    private List<Configuration> ConfigList;
    @EJB
    private ConfigurationDao configDao;

    @PostConstruct
    public void init() {
        CpuList = new ArrayList<>();
        CpuList = CpuDao.getAllCpu();

        CmList = new ArrayList<>();
        CmList = CmDao.getAllCarteMere();

        CgList = new ArrayList<>();
        CgList = CgDao.getAllCarteGraphique();

        RamList = new ArrayList<>();
        RamList = RamDao.getAllRam();

        StockageList = new ArrayList<>();
        StockageList = StockageDao.getAllStockage();

        CoolingList = new ArrayList<>();
        CoolingList = CoolingDao.getAllCooling();

        BoitierList = new ArrayList<>();
        BoitierList = BoitierDao.getAllBoitier();

        AlimList = new ArrayList<>();
        AlimList = AlimentationDao.getAllAlimentation();
        
        ConfigList = new ArrayList<>();
        ConfigList = configDao.getAllConfiguration();

    }

    public List<Cpu> getCpu() {
        return CpuList;
    }

    public List<CarteMere> getCM() {
        return CmList;
    }

    public List<CarteGraphique> getCG() {
        return CgList;
    }

    public List<Ram> getRam() {
        return RamList;
    }

    public List<Stockage> getStockage() {
        return StockageList;
    }

    public List<Cooling> getCooling() {
        return CoolingList;
    }

    public List<Boitier> getBoitier() {
        return BoitierList;
    }

    public List<Alimentation> getAlimentation() {
        return AlimList;
    }

    public List<Configuration> getConfiguration() {
        return ConfigList;
    }

    public String getParamValueNameConfig(FacesContext fc) {

        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        return params.get("nomConfig");
    }
    
    public String getNameConfig (){
        FacesContext fc = FacesContext.getCurrentInstance();
        this.nomConfig = getParamValueNameConfig(fc);
        return this.nomConfig;
    }
}
