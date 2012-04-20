package eu.alertproject.iccs.events.alert;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * User: fotis
 * Date: 22/03/12
 * Time: 17:26
 */
@XStreamAlias("o:mdservice")
public class MdServiceITS {
    
    @XStreamAlias("o:issueUri")
    private String uri;
    
    @XStreamImplicit(itemFieldName = "o:issueComment")
    private List<Comment> comment;

    @XStreamImplicit(itemFieldName = "o:issueActivity")
    private List<Activity> activity;

    @XStreamAlias("o:issueAuthorUri")
    private String authorUri;
    
    @XStreamAlias("o:issueProduct")
    private Product product;
    
    @XStreamAlias("o:issueComputerSystem")
    private CommputerSystem commputerSystem;

    @XStreamAlias("o:issueAssignedToUri")
    private String assignedToUri;
    
    @XStreamImplicit(itemFieldName = "o:issueCCPersonUri")
    private List<String> ccPersonUri;

    @XStreamAlias("o:issueDependsOnUri")
    private String dependsOnUri;

    @XStreamAlias("o:issueBlocksUri")
    private String blocksUri;

    @XStreamAlias("o:issueAttachment")
    private Attachment attachment;
    
    @XStreamAlias("o:issueTracker")
    private Tracker tracker;
    
    @XStreamAlias("o:issueMilestone")
    private Milestone milestone; 

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    public List<Activity> getActivity() {
        return activity;
    }

    public void setActivity(List<Activity> activity) {
        this.activity = activity;
    }

    public String getAuthorUri() {
        return authorUri;
    }

    public void setAuthorUri(String authorUri) {
        this.authorUri = authorUri;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public CommputerSystem getCommputerSystem() {
        return commputerSystem;
    }

    public void setCommputerSystem(CommputerSystem commputerSystem) {
        this.commputerSystem = commputerSystem;
    }

    public String getAssignedToUri() {
        return assignedToUri;
    }

    public void setAssignedToUri(String assignedToUri) {
        this.assignedToUri = assignedToUri;
    }

    public List<String> getCcPersonUri() {
        return ccPersonUri;
    }

    public void setCcPersonUri(List<String> ccPersonUri) {
        this.ccPersonUri = ccPersonUri;
    }

    public String getDependsOnUri() {
        return dependsOnUri;
    }

    public void setDependsOnUri(String dependsOnUri) {
        this.dependsOnUri = dependsOnUri;
    }

    public String getBlocksUri() {
        return blocksUri;
    }

    public void setBlocksUri(String blocksUri) {
        this.blocksUri = blocksUri;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public Tracker getTracker() {
        return tracker;
    }

    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }

    public static class Tracker{
        @XStreamAlias("o:issueTrackerUri")
        private String uri;

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }
    }
    public static class Attachment{
        
        @XStreamAlias("o:attachmentUri")
        private String uri;

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }
    }
    
    public static class CommputerSystem{

        @XStreamAlias("o:issueComputerSystemUri")
        private String uri;

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }
    }
    
    public static class Product{
        
        @XStreamAlias("o:productUri")
        private String uri;
        
        @XStreamAlias("o:productComponentUri")
        private String componentUri;

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getComponentUri() {
            return componentUri;
        }

        public void setComponentUri(String componentUri) {
            this.componentUri = componentUri;
        }
    }


    public static class Activity {
        
        @XStreamAlias("o:activityUri")
        private String uri;
        
        @XStreamAlias("o:activityWhoUri")
        private String whoUri;

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getWhoUri() {
            return whoUri;
        }

        public void setWhoUri(String whoUri) {
            this.whoUri = whoUri;
        }
    }
    
    public static class Comment{
        
        @XStreamAlias("o:commentUri")
        private String uri;
        
        @XStreamAlias("o:commentPersonUri")
        private String personUri;

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getPersonUri() {
            return personUri;
        }

        public void setPersonUri(String personUri) {
            this.personUri = personUri;
        }
    }
    
    public static class Milestone{

        @XStreamAlias("o:issueMilestoneUri")
        private String uri;

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }
    }
    
}
