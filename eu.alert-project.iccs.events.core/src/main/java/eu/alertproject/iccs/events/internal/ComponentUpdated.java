package eu.alertproject.iccs.events.internal;

import eu.alertproject.iccs.events.alert.Keui;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * User: fotis
 * Date: 25/02/12
 * Time: 14:43
 */
public class ComponentUpdated extends ArtefactUpdated {

    private List<String> components;


    public List<String> getComponents() {
        return components;
    }

    public void setComponents(List<String> component) {
        this.components = component;
    }

    public void setComponent(String ... component){
        this.components = Arrays.asList(component);
    }
}
