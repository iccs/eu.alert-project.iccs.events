package eu.alertproject.iccs.events.internal;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: fotis
 * Date: 8/28/12
 * Time: 10:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class IssueUpdated extends ArtefactUpdated {

    private String subject;
    private Date date;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "IssueUpdated{" +
                "parent"+super.toString()+
                "date=" + date +
                ", subject='" + subject + '\'' +
                '}';
    }
}
