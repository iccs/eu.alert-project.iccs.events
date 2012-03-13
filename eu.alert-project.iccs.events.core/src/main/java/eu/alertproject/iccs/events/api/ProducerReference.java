package eu.alertproject.iccs.events.api;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

public class ProducerReference implements Serializable {

    @XStreamAlias("wsa:Address")
    private String address;


    public ProducerReference() {

    }

    public ProducerReference(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}