/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuration;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.event.ComponentSystemEvent;

/**
 *
 * @author Alexandra
 */

@Named(value = "configurationControl")
@Dependent
public class ConfigurationControl implements Serializable {

    @EJB
    private ConfigurationDao ConfigurationDao;
    private Configuration ConfigurationSaisie;
    

    /**
     * Creates a new instance of ConfigurationControl
     */
    public ConfigurationControl() {
        ConfigurationSaisie = new Configuration();
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

    public void lireConfiguration(ComponentSystemEvent event) {
        ConfigurationSaisie = ConfigurationDao.getConfiguration();
    }
    
}
