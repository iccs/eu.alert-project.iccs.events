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


        @XStreamAlias("sc:ranking")
        private Double ranking;


        @XStreamImplicit(itemFieldName = "sc:identities")
        private List<IssueIdentities> identities;

        @XStreamAlias("p:patternId")
        private String patternId;

        public Double getRanking() {
            return ranking;
        }

        public void setRanking(Double ranking) {
            this.ranking = ranking;
        }

        public List<IssueIdentities> getIssueIdentities() {
            return identities;
        }

        public void setIssueIdentities(List<IssueIdentities> identities) {
            this.identities = identities;
        }

        public String getPatternId() {
            return patternId;
        }

        public void setPatternId(String patternId) {
            this.patternId = patternId;
        }
    }

}
