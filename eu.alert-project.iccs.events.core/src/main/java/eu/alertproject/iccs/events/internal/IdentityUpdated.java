package eu.alertproject.iccs.events.internal;

import java.util.List;
import java.util.Map;

/**
 * User: fotis
 * Date: 27/02/12
 * Time: 12:23
 */
public class IdentityUpdated extends ArtefactUpdated{
    private Map<String, Double> cis;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Double> getCis() {
        return cis;
    }

    public void setCis(Map<String, Double> cis) {
        this.cis = cis;
    }

}
