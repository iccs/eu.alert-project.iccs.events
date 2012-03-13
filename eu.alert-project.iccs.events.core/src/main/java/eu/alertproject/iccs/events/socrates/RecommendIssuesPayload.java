package eu.alertproject.iccs.events.socrates;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import eu.alertproject.iccs.events.api.Meta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.util.List;

/**
 * User: fotis
 * Date: 24/02/12
 * Time: 14:39
 */

public class RecommendIssuesPayload {

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

        @XStreamAlias("sc:identities")
        private List<Identity> identities;


        public List<Identity> getIdentities() {
            return identities;
        }

        public void setIdentities(List<Identity> identities) {
            this.identities = identities;
        }

        @XStreamAlias("sc:identity")
        public static class Identity{


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
    }

}
