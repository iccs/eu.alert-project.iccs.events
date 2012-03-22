package eu.alertproject.iccs.events.alert;

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
public class CommitNewAnnotatedPayload {

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

        @XStreamAlias("s:kesi")
        private KesiSCM kesi;

        @XStreamAlias("o:mdservice")
        private MdServiceSCM mdService;

        @XStreamAlias("s1:keui")
        private Keui keui;

        public KesiSCM getKesi() {
            return kesi;
        }

        public void setKesi(KesiSCM kesi) {
            this.kesi = kesi;
        }

        public MdServiceSCM getMdService() {
            return mdService;
        }

        public void setMdService(MdServiceSCM mdService) {
            this.mdService = mdService;
        }

        public Keui getKeui() {
            return keui;
        }

        public void setKeui(Keui keui) {
            this.keui = keui;
        }
    }

}
