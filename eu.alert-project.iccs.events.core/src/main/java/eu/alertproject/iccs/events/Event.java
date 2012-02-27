package eu.alertproject.iccs.events;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * User: fotis
 * Date: 24/02/12
 * Time: 14:19
 */
@XmlType(namespace="ns1")
@XmlRootElement(name = "event",namespace ="ns1" )
@XmlAccessorType(XmlAccessType.FIELD)
public class Event implements Serializable {

    @XStreamAlias("ns1:head")
    private Head head;

    @XStreamAlias("ns1:payload")
    private Payload payload;

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    static class Head implements Serializable {


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





}
