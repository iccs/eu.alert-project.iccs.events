package eu.alertproject.iccs.events.socrates;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("sc:issue")
public  class Issue{

    @XStreamAlias("sc:id")
    private String uuid;

    @XStreamAlias("o:bug")
    private String bug;

    @XStreamAlias("sc:subject")
    private String subject;


    public Issue() {
    }

    public Issue(String uuid, String bug,String subject) {
        this.uuid = uuid;
        this.bug = bug;
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getBug() {
        return bug;
    }

    public void setBug(String bug) {
        this.bug = bug;
    }
}