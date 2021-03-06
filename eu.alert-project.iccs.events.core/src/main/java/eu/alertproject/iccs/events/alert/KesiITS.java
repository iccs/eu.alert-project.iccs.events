package eu.alertproject.iccs.events.alert;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import eu.alertproject.iccs.events.converters.KESIDateConverter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * User: fotis
 * Date: 24/02/12
 * Time: 14:47
 */

@XStreamAlias("s:kesi")
public class KesiITS implements Serializable {

    @XStreamAlias("s:issueId")
    private Integer Id;

    @XStreamAlias("s:issueUrl")
    private String url;

    @XStreamAlias("s:issueDependsOnId")
    private Integer dependsOnId;

    @XStreamAlias("s:issueBlocksId")
    private Integer blocksId;


    @XStreamAlias("s:issueTracker")
    private Tracker tracker;

    @XStreamAlias("s:issueAuthor")
    private Author author;

    // (Duplicate, Fixed, Invalid, ThirdParty, WontFix, WorksForMe, Later, Remind)
    @XStreamAlias("s:issueStatus")
    private String status;

    @XStreamAlias("s:issueResolution")
    private String resolution;

    @XStreamAlias("s:issueSummary")
    private String summary;

    @XStreamAlias("s:issueDescription")
    private String description;

    @XStreamAlias("s:issueDateOpened")
    @XStreamConverter(KESIDateConverter.class)
    private Date dateOpened;

    @XStreamAlias("s:issueAssignedTo")
    private Author assignedTo;

    @XStreamImplicit(itemFieldName = "s:issueCCPerson")
    private List<Author> ccPerson;

    @XStreamAlias("s:issuePriority")
    private String priority;

    @XStreamAlias("s:issueSeverity")
    private String severity;

    @XStreamAlias("s:issueProduct")
    private Product product;

    @XStreamAlias("s:issueComputerSystem")
    private ComputerSystem computerSystem;

    @XStreamAlias("s:issueKeyword")
    private String keyword;

    @XStreamAlias("s:issueMilestone")
    private Milestone milestone;



    @XStreamImplicit(itemFieldName="s:issueDuplicateOfId")
    private List<Integer> duplicateOfId;

    @XStreamImplicit(itemFieldName="s:issueMergedIntoId")
    private List<Integer> mergedIntoId;

    @XStreamAlias("s:issueLastModified")
    @XStreamConverter(KESIDateConverter.class)
    private Date lastModified;


    @XStreamImplicit(itemFieldName="s:issueComment")
    private List<Comment> comments;

    @XStreamImplicit(itemFieldName="s:issueAttachment")
    private List<Attachement> attachements;

    @XStreamImplicit(itemFieldName = "s:issueActivity")
    private List<Activity> activity;



    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
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

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public Author getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Author assignedTo) {
        this.assignedTo = assignedTo;
    }

    public List<Author> getCcPerson() {
        return ccPerson;
    }

    public void setCcPerson(List<Author> ccPerson) {
        this.ccPerson = ccPerson;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getDependsOnId() {
        return dependsOnId;
    }

    public void setDependsOnId(Integer dependsOnId) {
        this.dependsOnId = dependsOnId;
    }

    public Integer getBlocksId() {
        return blocksId;
    }

    public void setBlocksId(Integer blocksId) {
        this.blocksId = blocksId;
    }

    public List<Integer> getDuplicateOfId() {
        return duplicateOfId;
    }

    public void setDuplicateOfId(List<Integer> duplicateOfId) {
        this.duplicateOfId = duplicateOfId;
    }

    public List<Integer> getMergedIntoId() {
        return mergedIntoId;
    }

    public void setMergedIntoId(List<Integer> mergedIntoId) {
        this.mergedIntoId = mergedIntoId;
    }

    public Date getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(Date dateOpened) {
        this.dateOpened = dateOpened;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
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

    public List<Attachement> getAttachements() {
        return attachements;
    }

    public void setAttachements(List<Attachement> attachements) {
        this.attachements = attachements;
    }

    public List<Activity> getActivity() {
        return activity;
    }

    public void setActivity(List<Activity> activity) {
        this.activity = activity;
    }

    public Tracker getTracker() {
        return tracker;
    }

    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public static class Tracker implements Serializable{
        
        @XStreamAlias("s:issueTrackerId")
        private Integer id;
        
        @XStreamAlias("s:issueTrackerType")
        private String type;
        
        @XStreamAlias("s:issueTrackerURL")
        private String url;


        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class Activity implements Serializable{

        @XStreamAlias("s:activityAdded")
        private String activityAdded;

        @XStreamAlias("s:activityRemoved")
        private String activityRemoved;

        @XStreamAlias("s:activityWhat")
        private String activityWhat;

        @XStreamAlias("s:activityWho")
        private String who;
        
        @XStreamAlias("s:activityWhen")
        @XStreamConverter(KESIDateConverter.class)
        private Date date;
        
        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getActivityAdded() {
            return activityAdded;
        }

        public void setActivityAdded(String activityAdded) {
            this.activityAdded = activityAdded;
        }

        public String getActivityRemoved() {
            return activityRemoved;
        }

        public void setActivityRemoved(String activityRemoved) {
            this.activityRemoved = activityRemoved;
        }

        public String getActivityWhat() {
            return activityWhat;
        }

        public void setActivityWhat(String activityWhat) {
            this.activityWhat = activityWhat;
        }

    }

    public static class Attachement implements Serializable{
     
        @XStreamAlias("s:attachmentId")
        private Integer id;
        
        @XStreamAlias("s:attachmentType")
        private String type;

        @XStreamAlias("s:attachmentFilename")
        private String filename;

        @XStreamAlias("s:attachmentCreator")
        private Author creator;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public Author getCreator() {
            return creator;
        }

        public void setCreator(Author creator) {
            this.creator = creator;
        }
    }

    public static class Comment implements Serializable{

        @XStreamAlias("s:commentText")
        private String text;
        
        @XStreamAlias("s:commentPerson")
        private Author person;

        @XStreamAlias("s:commentDate")
        @XStreamConverter(KESIDateConverter.class)
        private Date date;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Author getPerson() {
            return person;
        }

        public void setPerson(Author person) {
            this.person = person;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }
    }

    public static class Milestone implements Serializable{
        
        @XStreamAlias("s:milestoneId")
        private String id;

        @XStreamAlias("s:milestoneTarget")
        @XStreamConverter(KESIDateConverter.class)
        private Date target;


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Date getTarget() {
            return target;
        }

        public void setTarget(Date target) {
            this.target = target;
        }
    }

    public static class ComputerSystem implements Serializable{

        @XStreamAlias("s:computerSystemId")
        private String id;

        @XStreamAlias("s:computerSystemPlatform")
        private String platform;

        @XStreamAlias("s:computerSystemOS")
        private String os;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public String getOs() {
            return os;
        }

        public void setOs(String os) {
            this.os = os;
        }
    }

    public static class Product implements Serializable{
        
        @XStreamAlias("s:productId")
        private String id;
        
        @XStreamAlias("s:productComponentId")
        private String componentId;
        
        @XStreamAlias("s:productVersion")
        private String version;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getComponentId() {
            return componentId;
        }

        public void setComponentId(String componentId) {
            this.componentId = componentId;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }

}
