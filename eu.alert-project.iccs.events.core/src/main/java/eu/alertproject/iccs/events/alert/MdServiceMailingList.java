package eu.alertproject.iccs.events.alert;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * User: fotis
 * Date: 22/03/12
 * Time: 17:26
 */
public class MdServiceMailingList {
    
    @XStreamAlias("o:emailUri")
    private String emailUri;

    @XStreamAlias("o:fromUri")
    private String fromUri;

    @XStreamAlias("o:inReplyToUri")
    private String inReplyToUri;

    @XStreamImplicit(itemFieldName = "o:referencesUri")
    private List<String> referencesUris;

    public String getEmailUri() {
        return emailUri;
    }

    public void setEmailUri(String emailUri) {
        this.emailUri = emailUri;
    }

    public String getFromUri() {
        return fromUri;
    }

    public void setFromUri(String fromUri) {
        this.fromUri = fromUri;
    }

    public String getInReplyToUri() {
        return inReplyToUri;
    }

    public void setInReplyToUri(String inReplyToUri) {
        this.inReplyToUri = inReplyToUri;
    }

    public List<String> getReferencesUris() {
        return referencesUris;
    }

    public void setReferencesUris(List<String> referencesUris) {
        this.referencesUris = referencesUris;
    }
}
