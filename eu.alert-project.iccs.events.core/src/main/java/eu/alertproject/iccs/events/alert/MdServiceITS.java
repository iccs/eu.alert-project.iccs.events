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
    private String issueUri;
    
    @XStreamAlias("o:issueComment")
    private Comment issueComment;

    @XStreamImplicit(itemFieldName = "o.issueActivity")
    private List<IssueActivity> issueActivity;

    @XStreamAlias("o:issueAuthorUri")
    private String issueAuthorUri;
    
    @XStreamAlias("o:issueProduct")
    private Product issueProduct; 
    
    @XStreamAlias("o:issueComputerSystem")
    private CommputerSystem issueCommputerSystem;

    @XStreamAlias("o:issueAssignedToUri")
    private String issueAssignedToUri;
    
    @XStreamAlias("o:issueCCPersonUri")
    private String issueCCPersonUri;

    @XStreamAlias("o:issueDependsOnUri")
    private String issueDependsOnUri;

    @XStreamAlias("o:issueBlocksUri")
    private String issueBlocksUri;

    @XStreamAlias("o:issueAttachment")
    private Attachment issueAttachment;
    
    @XStreamAlias("o:issueTracker")
    private Tracker issueTracker;

    public String getIssueUri() {
        return issueUri;
    }

    public void setIssueUri(String issueUri) {
        this.issueUri = issueUri;
    }

    public Comment getIssueComment() {
        return issueComment;
    }

    public void setIssueComment(Comment issueComment) {
        this.issueComment = issueComment;
    }

    public List<IssueActivity> getIssueActivity() {
        return issueActivity;
    }

    public void setIssueActivity(List<IssueActivity> issueActivity) {
        this.issueActivity = issueActivity;
    }

    public String getIssueAuthorUri() {
        return issueAuthorUri;
    }

    public void setIssueAuthorUri(String issueAuthorUri) {
        this.issueAuthorUri = issueAuthorUri;
    }

    public Product getIssueProduct() {
        return issueProduct;
    }

    public void setIssueProduct(Product issueProduct) {
        this.issueProduct = issueProduct;
    }

    public CommputerSystem getIssueCommputerSystem() {
        return issueCommputerSystem;
    }

    public void setIssueCommputerSystem(CommputerSystem issueCommputerSystem) {
        this.issueCommputerSystem = issueCommputerSystem;
    }

    public String getIssueAssignedToUri() {
        return issueAssignedToUri;
    }

    public void setIssueAssignedToUri(String issueAssignedToUri) {
        this.issueAssignedToUri = issueAssignedToUri;
    }

    public String getIssueCCPersonUri() {
        return issueCCPersonUri;
    }

    public void setIssueCCPersonUri(String issueCCPersonUri) {
        this.issueCCPersonUri = issueCCPersonUri;
    }

    public String getIssueDependsOnUri() {
        return issueDependsOnUri;
    }

    public void setIssueDependsOnUri(String issueDependsOnUri) {
        this.issueDependsOnUri = issueDependsOnUri;
    }

    public String getIssueBlocksUri() {
        return issueBlocksUri;
    }

    public void setIssueBlocksUri(String issueBlocksUri) {
        this.issueBlocksUri = issueBlocksUri;
    }

    public Attachment getIssueAttachment() {
        return issueAttachment;
    }

    public void setIssueAttachment(Attachment issueAttachment) {
        this.issueAttachment = issueAttachment;
    }

    public Tracker getIssueTracker() {
        return issueTracker;
    }

    public void setIssueTracker(Tracker issueTracker) {
        this.issueTracker = issueTracker;
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

        @XStreamAlias("o:computerSystemUri")
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


    public static class IssueActivity{
        
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
    
}
