package eu.alertproject.iccs.events.api;

/**
 * User: fotis
 * Date: 05/11/11
 * Time: 17:43
 */
public class Topics {


    public static final String ICCS_STARDOM_Identity_Updated= "ICCS.IdentityUpdated";
    public static final String ICCS_STARDOM_Issue_Updated= "ICCS.IssueUpdated";


    public static final String ALERT_STARDOM_Identity_Updated= "ALERT.STARDOM.IdentityUpdated";
    public static final String ALERT_STARDOM_New_Identity= "ALERT.STARDOM.IdentityNew";
    public static final String ALERT_STARDOM_Issue_Updated= "ALERT.STARDOM.IssueUpdated";
    public static final String ALERT_STARDOM_TextToAnnotate ="ALERT.STARDOM.TextToAnnotate";
    public static final String ALERT_STARDOM_LoginVerify="ALERT.STARDOM.LoginVerify";


    public static final String ALERT_ALL_STARDOM_LoginVerifyRequest="ALERT.*.LoginVerifyRequest";
    public static final String ALERT_ALL_SOCRATES_Issue_Recommendation_Request = "ALERT.*.Recommender.IssueRecommendationRequest";
    public static final String ALERT_ALL_SOCRATES_Identity_Recommendation_Request= "ALERT.*.Recommender.IdentitiesRecommendationRequest";
    public static final String ALERT_ALL_SOCRATES_Identity_Verification_Request= "ALERT.*.Recommender.VerifyIdentitiesRequest";

    public static final String ALERT_SEARCH_SOCRATES_Identity_Recommendation_Request= "ALERT.*.Recommender.RecommendationRequest";

    public static final String ALERT_SOCRATES_Issue_Recommendation= "ALERT.Recommender.IssueRecommendation";
    public static final String ALERT_SOCRATES_Identity_Recommendation= "ALERT.Recommender.IdentityRecommendation";
    public static final String ALERT_SOCRATES_Identity_Verification= "ALERT.Recommender.IdentityVerification";


    public static final String ALERT_KEUI_TextToAnnotate_Annotated ="ALERT.KEUI.TextToAnnotate.Annotated";
    public static final String ALERT_KEUI_CommitNew_Annotated ="ALERT.KEUI.CommitNew.Annotated";
    public static final String ALERT_KEUI_MailNew_Annotated ="ALERT.KEUI.MailNew.Annotated";
    public static final String ALERT_KEUI_IssueNew_Annotated ="ALERT.KEUI.IssueNew.Annotated";
    public static final String ALERT_KEUI_IssueUpdate_Annotated ="ALERT.KEUI.IssueUpdate.Annotated";
    public static final String ALERT_KEUI_ForumPost_Annotated ="ALERT.KEUI.ForumPost.Annotated";

    public static final String ALERT_MLSensor_Mail_New ="ALERT.MLSensor.MailNew";


}
