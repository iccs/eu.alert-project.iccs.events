package eu.alertproject.iccs.events.stardom;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
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
public class StardomIdentitySnapshotPayload {

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

    @XStreamAlias("ns1:eventData")
    public static class EventData implements Serializable {

        @XStreamAlias("sm:identity")
        private Identity identity;

        public Identity getIdentity() {
            return identity;
        }

        public void setIdentity(Identity identity) {
            this.identity = identity;
        }

        @XStreamAlias("sm:identity")
        public static class Identity{

            @XStreamAlias("sm:uuid")
            private String uuid;

            @XStreamImplicit(itemFieldName = "sm:person")
            private List<String> persons;

            public Identity() {
            }

            public Identity(String uuid, List<String> persons) {
                this.uuid = uuid;
                this.persons = persons;
            }

            public String getUuid() {
                return uuid;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }

            public List<String> getPersons() {
                return persons;
            }

            public void setPersons(List<String> persons) {
                this.persons = persons;
            }
        }
    }


}
