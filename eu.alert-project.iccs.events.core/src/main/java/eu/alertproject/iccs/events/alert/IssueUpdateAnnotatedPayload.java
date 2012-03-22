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
public class IssueUpdateAnnotatedPayload {

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
        private KesiITS kesi;

        @XStreamAlias("o:mdservice")
        private MdServiceITS mdService;

        @XStreamAlias("s1:keui")
        private Keui keui;

        public KesiITS getKesi() {
            return kesi;
        }

        public void setKesi(KesiITS kesi) {
            this.kesi = kesi;
        }

        public MdServiceITS getMdService() {
            return mdService;
        }

        public void setMdService(MdServiceITS mdService) {
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
