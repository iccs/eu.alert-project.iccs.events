package eu.alertproject.iccs.events.jsi;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import eu.alertproject.iccs.events.KeuiEvent;
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
public class TextToAnnotateReplyPayload {

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


        @XStreamAlias("s1:generalText")
        private GeneralText generalText;

        @XStreamAlias("s1:keui")
        private Keui keui;
        
        public GeneralText getGeneralText() {
            return generalText;
        }

        public void setGeneralText(GeneralText generalText) {
            this.generalText = generalText;
        }

        public Keui getKeui() {
            return keui;
        }

        public void setKeui(Keui keui) {
            this.keui = keui;
        }

        public static class GeneralText{
            
            @XStreamAlias("s1:source")
            private String source;
            
            @XStreamAlias("s1:text")
            private String text;

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }
       
        
        public static class Keui{
            
            @XStreamAlias("s1:textAnnotated")
            private String textAnnotated;

            @XStreamAlias("s1:textConcepts")
            private List<Concept> textConcepts;


            public String getTextAnnotated() {
                return textAnnotated;
            }

            public void setTextAnnotated(String textAnnotated) {
                this.textAnnotated = textAnnotated;
            }

            public List<Concept> getTextConcepts() {
                return textConcepts;
            }

            public void setTextConcepts(List<Concept> textConcepts) {
                this.textConcepts = textConcepts;
            }

            @XStreamAlias("s1:concept")
            public static class Concept{

                @XStreamAlias("s1:uri")
                private String uri;
                
                @XStreamAlias("s1:weight")
                private Integer weight;

                public String getUri() {
                    return uri;
                }

                public void setUri(String uri) {
                    this.uri = uri;
                }

                public Integer getWeight() {
                    return weight;
                }

                public void setWeight(Integer weight) {
                    this.weight = weight;
                }
            }

        }
    }

}
