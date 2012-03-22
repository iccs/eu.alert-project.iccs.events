package eu.alertproject.iccs.events.alert;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

public class Author implements Serializable {
        
    @XStreamAlias("s:name")
    private String name;

    @XStreamAlias("s:id")
    private String id;

    @XStreamAlias("s:email")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}