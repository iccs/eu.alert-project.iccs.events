package eu.alertproject.iccs.events.alert;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import eu.alertproject.iccs.events.converters.KESIDateConverter;
import eu.alertproject.iccs.events.converters.MailingListDateConverter;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * User: fotis
 * Date: 25/03/12
 * Time: 14:31
 */
public class MailingList {

    @XStreamAlias("r1:from")
    private String from;
    
    @XStreamAlias("r1:date")
    @XStreamConverter(MailingListDateConverter.class)
    private Date date;
    
    @XStreamAlias("r1:subject")
    private String subject;
    
    @XStreamAlias("r1:inReplyTo")
    private String inReplyTo;

    @XStreamAlias("r1:references")
    private String reference;
    
    @XStreamAlias("r1:messageId")
    private String messageId;
    
    @XStreamAlias("r1:attachments")
    private Attachments attachments;

    @XStreamAlias("r1:content")
    private String content;
    
    @XStreamAlias("r1:url")
    private String url;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getInReplyTo() {
        return inReplyTo;
    }

    public void setInReplyTo(String inReplyTo) {
        this.inReplyTo = inReplyTo;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Attachments getAttachments() {
        return attachments;
    }

    public void setAttachments(Attachments attachments) {
        this.attachments = attachments;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public static class Attachments{

        @XStreamImplicit(itemFieldName = "r1:attachment")
        private List<String> attachment;

        
        public Attachments() {
        }

        public Attachments(String ...attachment) {
            this.attachment = Arrays.asList(attachment);
        }

        public List<String> getAttachment() {
            return attachment;
        }

        public void setAttachment(List<String> attachment) {
            this.attachment = attachment;
        }
    }
    
    
}
