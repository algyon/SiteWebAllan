/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildatoryPCK;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
 
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;


@ManagedBean
public class TabbedView {
    
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
    
    
    
 
    @PostConstruct
    public void init() {
        CpuList = new ArrayList<>();
        CpuList = CpuDao.getAllCpu();
        
        CmList = new ArrayList <>();
        CmList = CmDao.getAllCarteMere();
        
        CgList = new ArrayList <>();
        CgList = CgDao.getAllCarteGraphique();
        
        RamList = new ArrayList <>();
        RamList = RamDao.getAllRam();
        
        StockageList = new ArrayList <>();
        StockageList = StockageDao.getAllStockage();
        
        CoolingList = new ArrayList <>();
        CoolingList = CoolingDao.getAllCooling();
        
        BoitierList = new ArrayList <>();
        BoitierList = BoitierDao.getAllBoitier();      
        
    }
         
    public List <Cpu> getCpu(){
        return CpuList;
    }
    
    public List <CarteMere> getCM(){
        return CmList;
    }
    
    public List <CarteGraphique> getCG(){
        return CgList;
    }
    
    public List <Ram> getRam(){
        return RamList;
    }
    
    public List <Stockage> getStockage(){
        return StockageList;
    }
    
    public List <Cooling> getCooling(){
        return CoolingList;
    }
    
    public List <Boitier> getBoitier(){
        return BoitierList;
    }
    
}