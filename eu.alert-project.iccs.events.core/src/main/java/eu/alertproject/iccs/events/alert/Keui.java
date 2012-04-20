package eu.alertproject.iccs.events.alert;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;


public class Keui{
            
    @XStreamImplicit(itemFieldName = "s1:issueComment")
    private List<Comment> issueComment;

    @XStreamAlias("s1:textAnnotated")
    private String textAnnotated;

    @XStreamAlias("s1:textConcepts")
    private List<Concept> textConcepts;

    @XStreamAlias("s1:issueDescriptionAnnotated")
    private String issueDescriptionAnnotated;
    
    @XStreamAlias("s1:issueDescriptionConcepts")
    private List<Concept> issueDescriptionConcepts;

    @XStreamAlias("s1:issueDescriptionReferences")
    private List<References> issueDescriptionReferences;

    @XStreamAlias("s1:commentTextAnnotated")
    private String commentTextAnnotated;

    @XStreamAlias("s1:commentTextConcepts")
    private List<Concept> commentTextConcepts;

    @XStreamAlias("s1:contentAnnotated")
    private String contentAnnotated;

    @XStreamAlias("s1:contentReferences")
    private List<References> contentReferences;

    @XStreamAlias("s1:contentConcepts")
    private List<Concept> contentConcepts;

    @XStreamAlias("s1:commitMessageLogAnnotated")
    private String commitMessageLogAnnotated;

    @XStreamAlias("s1:commitMessageLogConcepts")
    private List<Concept> commitMessageLogConcepts;


    @XStreamAlias("s1:subjectAnnotated")
    private String subjectAnnotated;

    @XStreamAlias("s1:subjectConcepts")
    private List<Concept> subjectConcepts;

    @XStreamAlias("s1:subjectReferences")
    private List<References> subjectReferences;


    @XStreamImplicit(itemFieldName = "s1:itemId")
    private List<Integer> itemId;

    @XStreamImplicit(itemFieldName = "s1:threadId")
    private List<Integer> threadId;

    public List<Comment> getIssueComment() {
        return issueComment;
    }

    public void setIssueComment(List<Comment> issueComment) {
        this.issueComment = issueComment;
    }

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

    public List<References> getIssueDescriptionReferences() {
        return issueDescriptionReferences;
    }

    public void setIssueDescriptionReferences(List<References> issueDescriptionReferences) {
        this.issueDescriptionReferences = issueDescriptionReferences;
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

    public String getContentAnnotated() {
        return contentAnnotated;
    }

    public List<References> getContentReferences() {
        return contentReferences;
    }

    public void setContentReferences(List<References> contentReferences) {
        this.contentReferences = contentReferences;
    }

    public void setContentAnnotated(String contentAnnotated) {
        this.contentAnnotated = contentAnnotated;
    }

    public List<Concept> getContentConcepts() {
        return contentConcepts;
    }

    public void setContentConcepts(List<Concept> contentConcepts) {
        this.contentConcepts = contentConcepts;
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

    public String getSubjectAnnotated() {
        return subjectAnnotated;
    }

    public void setSubjectAnnotated(String subjectAnnotated) {
        this.subjectAnnotated = subjectAnnotated;
    }

    public List<Concept> getSubjectConcepts() {
        return subjectConcepts;
    }

    public void setSubjectConcepts(List<Concept> subjectConcepts) {
        this.subjectConcepts = subjectConcepts;
    }

    public List<References> getSubjectReferences() {
        return subjectReferences;
    }

    public void setSubjectReferences(List<References> subjectReferences) {
        this.subjectReferences = subjectReferences;
    }

    public List<Integer> getItemId() {
        return itemId;
    }

    public void setItemId(List<Integer> itemId) {
        this.itemId = itemId;
    }

    public List<Integer> getThreadId() {
        return threadId;
    }

    public void setThreadId(List<Integer> threadId) {
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


    public static class Comment{

        @XStreamAlias("s1:itemId")
        public Integer itemId;

        @XStreamAlias("s1:commentTextAnnotated")
        public String annotatedText;

        @XStreamAlias("s1:commentTextConcepts")
        public List<Concept> concepts;

        @XStreamAlias("s1:commentTextReferences")
        private List<References> references;

        public Integer getItemId() {
            return itemId;
        }

        public void setItemId(Integer itemId) {
            this.itemId = itemId;
        }

        public String getAnnotatedText() {
            return annotatedText;
        }

        public void setAnnotatedText(String annotatedText) {
            this.annotatedText = annotatedText;
        }

        public List<Concept> getConcepts() {
            return concepts;
        }

        public void setConcepts(List<Concept> concepts) {
            this.concepts = concepts;
        }


        public List<References> getReferences() {
            return references;
        }

        public void setReferences(List<References> references) {
            this.references = references;
        }
        
    }
    @XStreamAlias("s1:referenceUri")
    public static class References{

        private String references;

        public String getReferences() {
            return references;
        }

        public void setReferences(String references) {
            this.references = references;
        }
    }
}
