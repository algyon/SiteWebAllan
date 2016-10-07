/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildatoryPCK;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author David
 * 
 */

@Named(value = "AlimentationControl")
@ViewScoped
public class AlimentationControl implements Serializable{
    
    @EJB
    private AlimentationDao AlimentationDao;
    private Alimentation AlimSaisie;
    
    
    public AlimentationControl() {
        AlimSaisie = new Alimentation();
    }

    public List<Alimentation> getAllAlimentations() {
        return AlimentationDao.getAllAlimentation();
    }

    public Alimentation getSaisie() {
        return AlimSaisie;
    }

    public void setSaisie(Alimentation AlimSaisie) {
        this.AlimSaisie = AlimSaisie;
    }

    public String save() {
        AlimentationDao.save(AlimSaisie);
        return "liste";
    }

    public String delete() {
        AlimentationDao.delete(AlimSaisie);
        return "liste";
    }

    public String modify() {
        AlimentationDao.update(AlimSaisie);
        return "liste";
    }

    public void lireAlimentation(ComponentSystemEvent event) {
        AlimSaisie = AlimentationDao.getAlimentation();
    }
}
