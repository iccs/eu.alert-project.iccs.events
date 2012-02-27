package eu.alertproject.iccs.events;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

/**
 * User: fotis
 * Date: 24/02/12
 * Time: 14:48
 */
@XmlType(namespace = "s1")
public class KeuiEvent implements Serializable {
    
    
    @XStreamAlias("s1:subjectAnnotated")
    private String subjectAnnotated;
    
    @XStreamAlias("s1:subjectConcepts")
    private List<Concept> subjectConcepts;

    @XStreamAlias("s1:descriptionAnnotated")
    private String descriptionAnnotated;

    @XStreamAlias("s1:descriptionConcepts")
    private List<Concept> descriptionConcepts;

    public String getSubjectAnnotated() {
        return subjectAnnotated;
    }

    public void setSubjectAnnotated(String subjectAnnotated) {
        this.subjectAnnotated = subjectAnnotated;
    }

    public String getDescriptionAnnotated() {
        return descriptionAnnotated;
    }

    public void setDescriptionAnnotated(String descriptionAnnotated) {
        this.descriptionAnnotated = descriptionAnnotated;
    }

    public List<Concept> getSubjectConcepts() {
        return subjectConcepts;
    }

    public void setSubjectConcepts(List<Concept> subjectConcepts) {
        this.subjectConcepts = subjectConcepts;
    }

    public List<Concept> getDescriptionConcepts() {
        return descriptionConcepts;
    }

    public void setDescriptionConcepts(List<Concept> descriptionConcepts) {
        this.descriptionConcepts = descriptionConcepts;
    }

    @XStreamAlias("s1:concept")
    public static class Concept implements Serializable{
     
        @XStreamAlias("s1:uri")
        private String uri;
        
        @XStreamAlias("s1:count")
        private Integer count;

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }
    }
    
}
