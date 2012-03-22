package eu.alertproject.iccs.events.alert;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;


public class Keui{
            
    @XStreamAlias("s1:textAnnotated")
    private String textAnnotated;

    @XStreamAlias("s1:textConcepts")
    private List<Concept> textConcepts;

    @XStreamAlias("s1:issueDescriptionAnnotated")
    private String issueDescriptionAnnotated;
    
    @XStreamAlias("s1:issueDescriptionConcepts")
    private List<Concept> issueDescriptionConcepts;

    @XStreamAlias("s1:commentTextAnnotated")
    private String commentTextAnnotated;

    @XStreamAlias("s1:commentTextConcepts")
    private List<Concept> commentTextConcepts;

    @XStreamAlias("s1:commitMessageLogAnnotated")
    private String commitMessageLogAnnotated;

    @XStreamAlias("s1:commitMessageLogConcepts")
    private List<Concept> commitMessageLogConcepts;

    @XStreamAlias("s1:itemId")
    private Integer itemId;

    @XStreamAlias("s1:threadId")
    private Integer threadId;

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

    public String getIssueDescriptionAnnotated() {
        return issueDescriptionAnnotated;
    }

    public void setIssueDescriptionAnnotated(String issueDescriptionAnnotated) {
        this.issueDescriptionAnnotated = issueDescriptionAnnotated;
    }

    public List<Concept> getIssueDescriptionConcepts() {
        return issueDescriptionConcepts;
    }

    public void setIssueDescriptionConcepts(List<Concept> issueDescriptionConcepts) {
        this.issueDescriptionConcepts = issueDescriptionConcepts;
    }

    public String getCommentTextAnnotated() {
        return commentTextAnnotated;
    }

    public void setCommentTextAnnotated(String commentTextAnnotated) {
        this.commentTextAnnotated = commentTextAnnotated;
    }

    public List<Concept> getCommentTextConcepts() {
        return commentTextConcepts;
    }

    public void setCommentTextConcepts(List<Concept> commentTextConcepts) {
        this.commentTextConcepts = commentTextConcepts;
    }

    public String getCommitMessageLogAnnotated() {
        return commitMessageLogAnnotated;
    }

    public void setCommitMessageLogAnnotated(String commitMessageLogAnnotated) {
        this.commitMessageLogAnnotated = commitMessageLogAnnotated;
    }

    public List<Concept> getCommitMessageLogConcepts() {
        return commitMessageLogConcepts;
    }

    public void setCommitMessageLogConcepts(List<Concept> commitMessageLogConcepts) {
        this.commitMessageLogConcepts = commitMessageLogConcepts;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getThreadId() {
        return threadId;
    }

    public void setThreadId(Integer threadId) {
        this.threadId = threadId;
    }

    @XStreamAlias("s1:concept")
    public static class Concept {

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
