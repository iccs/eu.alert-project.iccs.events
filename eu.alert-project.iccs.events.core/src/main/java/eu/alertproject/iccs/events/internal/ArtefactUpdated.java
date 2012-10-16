package eu.alertproject.iccs.events.internal;

import eu.alertproject.iccs.events.alert.Keui;

import java.io.Serializable;
import java.util.List;

/**
 * User: fotis
 * Date: 25/02/12
 * Time: 14:43
 */
public class ArtefactUpdated implements Serializable {
    
    private String id;
    private List<Keui.Concept> concepts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Keui.Concept> getConcepts() {
        return concepts;
    }

    public void setConcepts(List<Keui.Concept> concepts) {
        this.concepts = concepts;
    }

    @Override
    public String toString() {
        return "ArtefactUpdated{" +
                "id='" + id + '\'' +
                ", concepts=" + concepts +
                '}';
    }
}
