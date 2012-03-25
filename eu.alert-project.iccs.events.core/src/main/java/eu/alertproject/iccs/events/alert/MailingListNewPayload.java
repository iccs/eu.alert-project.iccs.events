package eu.alertproject.iccs.events.alert;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import eu.alertproject.iccs.events.api.Meta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;

/**
 * User: fotis
 * Date: 24/02/12
 * Time: 14:39
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class MailingListNewPayload {

    @XStreamAlias("ns1:meta")
    private Meta meta;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }


    @XStreamAlias("ns1:eventData")
    private EventData eventData;

    public EventData getEventData() {
        return eventData;
    }

    public void setEventData(EventData eventData) {
        this.eventData = eventData;
    }

    public static class EventData implements Serializable {

        @XStreamAlias("r1:message")
        private MailingList mailingList;

        public MailingList getMailingList() {
            return mailingList;
        }

        public void setMailingList(MailingList mailingList) {
            this.mailingList = mailingList;
        }
    }

}
