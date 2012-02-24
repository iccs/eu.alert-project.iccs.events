package eu.alertproject.events;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;

/**
 * User: fotis
 * Date: 24/02/12
 * Time: 14:39
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class Payload implements Serializable {

    @XStreamAlias("ns1:meta")
    private Meta meta;

    @XStreamAlias("ns1:eventData")
    private EventData eventData;

    public EventData getEventData() {
        return eventData;
    }

    public void setEventData(EventData eventData) {
        this.eventData = eventData;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    static class Meta implements Serializable{

        @XStreamAlias("ns1:startTime")
        private Long startTime;

        @XStreamAlias("ns1:endTime")
        private Long endTime;

        @XStreamAlias("ns1:eventName")
        private String eventName;

        @XStreamAlias("ns1:eventId")
        private Integer eventId;

        @XStreamAlias("ns1:eventType")
        private String type;


        public Long getStartTime() {
            return startTime;
        }

        public void setStartTime(Long startTime) {
            this.startTime = startTime;
        }

        public Long getEndTime() {
            return endTime;
        }

        public void setEndTime(Long endTime) {
            this.endTime = endTime;
        }

        public String getEventName() {
            return eventName;
        }

        public void setEventName(String eventName) {
            this.eventName = eventName;
        }

        public Integer getEventId() {
            return eventId;
        }

        public void setEventId(Integer eventId) {
            this.eventId = eventId;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }


}
