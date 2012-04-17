package eu.alertproject.iccs.events.socrates;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * User: fotis
 * Date: 17/04/12
 * Time: 17:06
 */
public class IssueIdentities {

    @XStreamAlias("sc:issue")
    Issue issue;


    @XStreamImplicit(itemFieldName = "sc:identity")
    List<Identity> identities;

    public IssueIdentities() {
    }

    public IssueIdentities(Issue issue, List<Identity> identities) {
        this.identities = identities;
        this.issue = issue;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public List<Identity> getIdentities() {
        return identities;
    }

    public void setIdentities(List<Identity> identities) {
        this.identities = identities;
    }
}
