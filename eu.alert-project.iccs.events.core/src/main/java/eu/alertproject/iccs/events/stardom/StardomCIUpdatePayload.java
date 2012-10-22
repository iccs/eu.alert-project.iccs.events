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
public class StardomCIUpdatePayload {

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

        @XStreamImplicit(itemFieldName = "sm:ci")
        private List<CI> cis;

        @XStreamAlias("sm:metrics")
        private Metrics metrics;

        public Identity getIdentity() {
            return identity;
        }

        public void setIdentity(Identity identity) {
            this.identity = identity;
        }

        public List<CI> getCis() {
            return cis;
        }

        public void setCis(List<CI> cis) {
            this.cis = cis;
        }

        public Metrics getMetrics() {
            return metrics;
        }

        public void setMetrics(Metrics metrics) {
            this.metrics = metrics;
        }

        @XStreamAlias("sm:identity")
        public static class Identity{

            @XStreamAlias("sm:uuid")
            private String uuid;

            @XStreamImplicit(itemFieldName = "sm:person")
            private List<String> persons;

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


        public static class Metrics{

            @XStreamAlias("sm:fluency")
            private Fluency fluency;

            @XStreamAlias("sm:effectiveness")
            private Effectiveness effectiveness;

            @XStreamAlias("sm:contribution")
            private Contribution contribution;

            @XStreamAlias("sm:recency")
            private Recency recency;

            public Fluency getFluency() {
                return fluency;
            }

            public void setFluency(Fluency fluency) {
                this.fluency = fluency;
            }

            public Effectiveness getEffectiveness() {
                return effectiveness;
            }

            public void setEffectiveness(Effectiveness effectiveness) {
                this.effectiveness = effectiveness;
            }

            public Contribution getContribution() {
                return contribution;
            }

            public void setContribution(Contribution contribution) {
                this.contribution = contribution;
            }

            public Recency getRecency() {
                return recency;
            }

            public void setRecency(Recency recency) {
                this.recency = recency;
            }

            public static class Fluency{

                @XStreamAlias("sm:scmApiIntroducedMetric")
                private Integer scmApiIntroducedMetric;

                public Fluency() {
                }

                public Fluency(Integer scmApiIntroducedMetric) {
                    this.scmApiIntroducedMetric = scmApiIntroducedMetric;
                }

                public Integer getScmApiIntroducedMetric() {
                    return scmApiIntroducedMetric;
                }

                public void setScmApiIntroducedMetric(Integer scmApiIntroducedMetric) {
                    this.scmApiIntroducedMetric = scmApiIntroducedMetric;
                }
            }

            public static class Effectiveness{

                @XStreamAlias("sm:itsIssuesResolvedMetric")
                private Integer itsIssuesResolvedMetric;

                public Effectiveness() {
                }

                public Effectiveness(Integer itsIssuesResolvedMetric) {
                    this.itsIssuesResolvedMetric = itsIssuesResolvedMetric;
                }

                public Integer getItsIssuesResolvedMetric() {
                    return itsIssuesResolvedMetric;
                }

                public void setItsIssuesResolvedMetric(Integer itsIssuesResolvedMetric) {
                    this.itsIssuesResolvedMetric = itsIssuesResolvedMetric;
                }
            }


            public static class Contribution{

                @XStreamAlias("sm:scmActivityMetric")
                private Integer scmActivityMetric;

                @XStreamAlias("sm:itsActivityMetric")
                private Integer itsActivityMetric;

                @XStreamAlias("sm:communicationActivityMetric")
                private Integer communicationActivityMetric;

                public Contribution() {
                }

                public Contribution(Integer scmActivityMetric, Integer itsActivityMetric, Integer communicationActivityMetric) {
                    this.scmActivityMetric = scmActivityMetric;
                    this.itsActivityMetric = itsActivityMetric;
                    this.communicationActivityMetric = communicationActivityMetric;
                }

                public Integer getScmActivityMetric() {
                    return scmActivityMetric;
                }

                public void setScmActivityMetric(Integer scmActivityMetric) {
                    this.scmActivityMetric = scmActivityMetric;
                }

                public Integer getItsActivityMetric() {
                    return itsActivityMetric;
                }

                public void setItsActivityMetric(Integer itsActivityMetric) {
                    this.itsActivityMetric = itsActivityMetric;
                }

                public Integer getCommunicationActivityMetric() {
                    return communicationActivityMetric;
                }

                public void setCommunicationActivityMetric(Integer communicationActivityMetric) {
                    this.communicationActivityMetric = communicationActivityMetric;
                }
            }


            public static class Recency{

                @XStreamAlias("sm:scmTemporalMetric")
                private Integer scmTemporalMetric;


                @XStreamAlias("sm:itsTemporalMetric")
                private Integer itsTemporalMetric;

                @XStreamAlias("sm:communicationTemporalMetric")
                private Integer communicationTemporalMetric;

                public Recency() {
                }

                public Recency(Integer scmTemporalMetric, Integer itsTemporalMetric, Integer communicationTemporalMetric) {
                    this.scmTemporalMetric = scmTemporalMetric;
                    this.itsTemporalMetric = itsTemporalMetric;
                    this.communicationTemporalMetric = communicationTemporalMetric;
                }

                public Integer getScmTemporalMetric() {
                    return scmTemporalMetric;
                }

                public void setScmTemporalMetric(Integer scmTemporalMetric) {
                    this.scmTemporalMetric = scmTemporalMetric;
                }

                public Integer getItsTemporalMetric() {
                    return itsTemporalMetric;
                }

                public void setItsTemporalMetric(Integer itsTemporalMetric) {
                    this.itsTemporalMetric = itsTemporalMetric;
                }

                public Integer getCommunicationTemporalMetric() {
                    return communicationTemporalMetric;
                }

                public void setCommunicationTemporalMetric(Integer communicationTemporalMetric) {
                    this.communicationTemporalMetric = communicationTemporalMetric;
                }
            }


        }
        public static class CI{

            @XStreamAlias("sm:class")
            private String clazz;

            @XStreamAlias("sm:value")
            private Double value;

            public CI(String clazz, Double value) {
                this.clazz = clazz;
                this.value = value;
            }

            public String getClazz() {
                return clazz;
            }

            public void setClazz(String clazz) {
                this.clazz = clazz;
            }

            public Double getValue() {
                return value;
            }

            public void setValue(Double value) {
                this.value = value;
            }
        }

    }




}
