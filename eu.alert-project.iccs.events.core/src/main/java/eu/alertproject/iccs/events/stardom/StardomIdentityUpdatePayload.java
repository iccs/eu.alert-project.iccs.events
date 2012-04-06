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
public class StardomIdentityUpdatePayload{

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

            @XStreamAlias("sm:add")
            private IdentityPersons add;

            @XStreamAlias("sm:remove")
            private IdentityPersons remove;

            public String getUuid() {
                return uuid;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }

            public IdentityPersons getAdd() {
                return add;
            }

            public void setAdd(IdentityPersons add) {
                this.add = add;
            }

            public IdentityPersons getRemove() {
                return remove;
            }

            public void setRemove(IdentityPersons remove) {
                this.remove = remove;
            }
        }
    }


}
