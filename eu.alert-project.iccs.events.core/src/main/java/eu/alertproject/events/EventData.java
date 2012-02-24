package eu.alertproject.events;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * User: fotis
 * Date: 24/02/12
 * Time: 15:32
 */
public class EventData implements Serializable{


    @XStreamAlias("s:kesi")
    private KesiEvent kesiEvent;

    @XStreamAlias("o:mdservice")
    private MdService mdService;

    @XStreamAlias("s1:keui")
    private KeuiEvent keuiEvent;


    public KesiEvent getKesiEvent() {
        return kesiEvent;
    }

    public void setKesiEvent(KesiEvent kesiEvent) {
        this.kesiEvent = kesiEvent;
    }

    public MdService getMdService() {
        return mdService;
    }

    public void setMdService(MdService mdService) {
        this.mdService = mdService;
    }

    public KeuiEvent getKeuiEvent() {
        return keuiEvent;
    }

    public void setKeuiEvent(KeuiEvent keuiEvent) {
        this.keuiEvent = keuiEvent;
    }
            
}
