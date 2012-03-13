package eu.alertproject.iccs.events.api;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

public class Head implements Serializable {


    @XStreamAlias("ns1:sender")
    private String sender;

    @XStreamAlias("ns1:timestamp")
    private Long timestamp;

    @XStreamAlias("ns1:sequencenumber")
    private Integer sequenceNumber;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }
}