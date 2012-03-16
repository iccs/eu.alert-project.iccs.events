package eu.alertproject.iccs.events.socrates;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("sc:identity")
public  class Identity{


    @XStreamAlias("sc:uuid")
    private String uuid;

    @XStreamAlias("sc:name")
    private String name;

    public Identity() {
    }

    public Identity(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}