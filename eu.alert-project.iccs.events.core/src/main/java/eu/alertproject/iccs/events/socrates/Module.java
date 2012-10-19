package eu.alertproject.iccs.events.socrates;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("sc:module")
public class Module{


    @XStreamAlias("sc:id")
    private String id;

    public Module() {
    }

    public Module(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}