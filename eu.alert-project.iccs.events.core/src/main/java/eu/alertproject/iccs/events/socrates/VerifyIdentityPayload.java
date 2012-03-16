package eu.alertproject.iccs.events.socrates;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import eu.alertproject.iccs.events.api.Meta;

import java.io.Serializable;
import java.util.List;

/**
 * User: fotis
 * Date: 24/02/12
 * Time: 14:39
 */

public class VerifyIdentityPayload {

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

        @XStreamAlias("sc:issue")
        private Issue issue;

        @XStreamAlias("sc:identity")
        private Identity identity;

        @XStreamAlias("sc:response")
        private String respone;

        public Issue getIssue() {
            return issue;
        }

        public void setIssue(Issue issue) {
            this.issue = issue;
        }

        public Identity getIdentity() {
            return identity;
        }

        public void setIdentity(Identity identity) {
            this.identity = identity;
        }

        public String getRespone() {
            return respone;
        }

        public void setRespone(String respone) {
            this.respone = respone;
        }
    }

}
