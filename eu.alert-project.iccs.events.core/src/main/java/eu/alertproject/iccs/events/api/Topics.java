package eu.alertproject.iccs.events.api;

/**
 * User: fotis
 * Date: 05/11/11
 * Time: 17:43
 */
public class Topics {

    private static String DOT= ".";
    private static String PARENT=  "ICCS";

    private static String ITS= "Its";
    private static String SCM= "Scm";
    private static String ML = "MailingList";


    public final static String IccsItsNewIssue=PARENT+DOT+ITS+DOT+"NewIssue";
    public final static String IccsItsNewComment=PARENT+DOT+ITS+DOT+"NewComment";
    public final static String IccsItsHistory=PARENT+DOT+ITS+DOT+"History";

    public final static String IccsScmNewIssue=PARENT+DOT+SCM+DOT+"NewCommit";

    public final static String IccsMlNewMail=PARENT+DOT+ML+DOT+"NewEmail";


    public static final String ALERT_STARDOM_Identity_Updated= "ALERT.STARDOM.Identity.Updated";
    public static final String ALERT_STARDOM_Issue_Updated= "ALERT.STARDOM.Issue.Updated";
    public static final String ALERT_STARDOM_New_Identity= "ALERT.STARDOM.Identity.New";
    public static final String ALERT_KEUI_CommendNew_Annotated = "ALERT.KEUI.CommentNew.Annotated";
    public static final String ALERT_KEUI_IssueNew_Annotated = "ALERT.KEUI.IssueNew.Annotated";
    public static final String ALERT_Metadata_IssueNew_Updated = "ALERT.Metadata.IssueNew.Updated";


}
