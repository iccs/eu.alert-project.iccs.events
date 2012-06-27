package eu.alertproject.iccs.events.internal;

import eu.alertproject.iccs.events.alert.Keui;

import java.io.Serializable;
import java.util.List;

/**
 * User: fotis
 * Date: 25/02/12
 * Time: 14:43
 */
public class ComponentUpdated extends ArtefactUpdated {

    private String component;

    public void setComponent(String component){
        this.component = component;
    }
    
    public String getComponent(){
        return this.component;
        
    }
    

}
