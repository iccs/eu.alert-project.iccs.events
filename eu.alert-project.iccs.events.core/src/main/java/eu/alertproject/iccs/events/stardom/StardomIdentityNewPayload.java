package eu.alertproject.iccs.events.stardom;

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

@XmlAccessorType(XmlAccessType.FIELD)
public class StardomIdentityNewPayload{

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

        @XStreamAlias("sm:identities")
        private List<Identity> identities;


        public List<Identity> getIdentities() {
            return identities;
        }

        public void setIdentities(List<Identity> identities) {
            this.identities = identities;
        }

        @XStreamAlias("sm:identity")
        public static class Identity{

            @XStreamAlias("sm:uuid")
            private String uuid;

            @XStreamAlias("sm:persons")
            private IdentityPersons persons;

            public Identity() {
            }

            public Identity(String uuid, IdentityPersons persons) {
                this.uuid = uuid;
                this.persons = persons;
            }

            public String getUuid() {
                return uuid;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }

            public IdentityPersons getPersons() {
                return persons;
            }

            public void setPersons(IdentityPersons persons) {
                this.persons = persons;
            }
        }
    }

}
