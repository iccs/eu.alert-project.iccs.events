package eu.alertproject.events;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.io.Serializable;
import java.util.List;

/**
 * User: fotis
 * Date: 24/02/12
 * Time: 14:48
 */
public class MdService implements Serializable {


    @XStreamAlias("o:issueUri")
    private String issueUri;

    @XStreamAlias("o:issueAuthorUri")
    private String issueAuthorUri;

    @XStreamAlias("o:issueProduct")
    private Product product;

    @XStreamAlias("o:issueComputerSystem")
    private ComputerSystem computerSystem;
    
    @XStreamAlias("o:issueAssignedToUri")
    private String assignedToUri;
    
    @XStreamImplicit(itemFieldName="o:issueCCPersonUri")
    private List<String> ccPersonUris;
    
    @XStreamAlias("o:issueDependsOnUri")
    private String dependsOnUri;
    
    @XStreamAlias("o:issueBlocksUri")
    private String blocksUri;
    
    @XStreamAlias("o:issueDuplicateOfUri")
    private String duplicateOfUri;
    
    @XStreamAlias("o:issueMergedIntoUri")
    private String mergedIntoUri;

    @XStreamAlias("o:issueMilestone")
    private Milestone milestone;

    @XStreamImplicit(itemFieldName="o:issueComment")
    private List<Comment> comments;

    @XStreamImplicit(itemFieldName="o:issueAttachment")
    private List<Attachment> attachments;

    @XStreamImplicit(itemFieldName="o:issueActivity")
    private List<Activity> activities;

    @XStreamAlias("o:issueTracker")
    private Tracker tracker;


    public String getIssueUri() {
        return issueUri;
    }

    public void setIssueUri(String issueUri) {
        this.issueUri = issueUri;
    }

    public String getIssueAuthorUri() {
        return issueAuthorUri;
    }

    public void setIssueAuthorUri(String issueAuthorUri) {
        this.issueAuthorUri = issueAuthorUri;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ComputerSystem getComputerSystem() {
        return computerSystem;
    }

    public void setComputerSystem(ComputerSystem computerSystem) {
        this.computerSystem = computerSystem;
    }

    public String getAssignedToUri() {
        return assignedToUri;
    }

    public void setAssignedToUri(String assignedToUri) {
        this.assignedToUri = assignedToUri;
    }

    public List<String> getCcPersonUris() {
        return ccPersonUris;
    }

    public void setCcPersonUris(List<String> ccPersonUris) {
        this.ccPersonUris = ccPersonUris;
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

    public String getDuplicateOfUri() {
        return duplicateOfUri;
    }

    public void setDuplicateOfUri(String duplicateOfUri) {
        this.duplicateOfUri = duplicateOfUri;
    }

    public String getMergedIntoUri() {
        return mergedIntoUri;
    }

    public void setMergedIntoUri(String mergedIntoUri) {
        this.mergedIntoUri = mergedIntoUri;
    }

    public Milestone getMilestone() {
        return milestone;
    }

    public void setMilestone(Milestone milestone) {
        this.milestone = milestone;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public Tracker getTracker() {
        return tracker;
    }

    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }

    static class Tracker implements Serializable{

        @XStreamAlias("o:issueTrackerUri")
        private String uri;


        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }
    }

    static class Attachment implements Serializable{

        @XStreamAlias("o:attachmentUri")
        private String uri;


        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }
    }

    static class Activity implements Serializable{

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


    static class Comment implements Serializable{

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

    static class Milestone implements Serializable{

        @XStreamAlias("o:milestoneUri")
        private String uri;

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }
    }

    static class ComputerSystem implements Serializable{
        
        @XStreamAlias("o:computerSystemUri")
        private String Uri;

        public String getUri() {
            return Uri;
        }

        public void setUri(String uri) {
            Uri = uri;
        }
    }
    
    static class Product implements Serializable{
        
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



}
