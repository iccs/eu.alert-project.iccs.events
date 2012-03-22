package eu.alertproject.iccs.events.xstream;

import com.thoughtworks.xstream.XStream;
import eu.alertproject.iccs.events.alert.*;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * User: fotis
 * Date: 22/03/12
 * Time: 18:20
 */
public class ItsUpdateAnnotatedEnvelopeTest {
    
    @Test
    public void desirialize() throws IOException {
        
        XStream xstream = new XStream();
        xstream.processAnnotations(IssueUpdateAnnotatedEnvelope.class);

        String s = IOUtils.toString(ItsUpdateAnnotatedEnvelopeTest.class.getResourceAsStream("/ALERT.KEUI.IssueUpdate.Annotated.xml"));

        IssueUpdateAnnotatedEnvelope o = (IssueUpdateAnnotatedEnvelope) xstream.fromXML(s);


        IssueUpdateAnnotatedPayload.EventData eventData = o.getBody()
                .getNotify()
                .getNotificationMessage()
                .getMessage()
                .getEvent()
                .getPayload()
                .getEventData();


        assertKesi(eventData.getKesi());

        assertMdService(eventData.getMdService());

        assertKeui(eventData.getKeui());

    }

    private void assertKeui(Keui keui) {

        Assert.assertEquals("If a <concept id=\"http://ailab.ijs.si/alert/resource/r17629\">driver</concept> is missing, <concept id=\"http://ailab.ijs.si/alert/resource/r3772\">clicking</concept> on the <concept id=\"http://ailab.ijs.si/alert/resource/r17717\">notification</concept> should <concept id=\"http://ailab.ijs.si/alert/resource/r3964\">open</concept> the <concept id=\"http://ailab.ijs.si/alert/resource/r16296\">package manager</concept> (by default) so the <concept id=\"KDE/user\">user</concept> can <concept id=\"KDE/find\">find</concept> a <concept id=\"http://ailab.ijs.si/alert/resource/r17629\">driver</concept>",
                keui.getCommentTextAnnotated().replaceAll("[\\s\\t\\n]+"," ").trim());


        List<Keui.Concept> commentTextConcepts = keui.getCommentTextConcepts();
        Assert.assertEquals(7,commentTextConcepts.size(),0);
        
        //if we get the middle one we are ok
        Assert.assertEquals("http://ailab.ijs.si/alert/resource/r3964",commentTextConcepts.get(3).getUri());
        Assert.assertEquals(1,commentTextConcepts.get(3).getWeight(),0);

        Assert.assertEquals(7805,keui.getItemId(),0);
        Assert.assertEquals(12,keui.getThreadId(),0);
    }


    private void assertMdService(MdServiceITS mdService){

        Assert.assertEquals("http://www.alert-project.eu/ontologies/alert_its.owl#Bug1",
                            mdService.getUri());
        Assert.assertEquals("http://www.ifi.uzh.ch/ddis/evoont/2008/11/bom#Comment2",
                            mdService.getComment().getUri().trim());
        Assert.assertEquals(
                "http://www.alert-project.eu/ontologies/alert_scm.owl#Person2",
                mdService.getComment().getPersonUri().trim()
                
                );
        
        Assert.assertEquals(2,mdService.getActivity().size(),0);


        Assert.assertEquals("http://www.ifi.uzh.ch/ddis/evoont/2008/11/bom#Activity2",
                mdService.getActivity().get(1).getUri().trim());
        Assert.assertEquals("http://www.alert-project.eu/ontologies/alert_scm.owl#Person2",
                mdService.getActivity().get(1).getWhoUri().trim());

    }

    private void assertKesi(KesiITS kesi) {
        
        Assert.assertEquals(184671,kesi.getId(),0);

        Assert.assertEquals("Resolved",kesi.getStatus());
        Assert.assertEquals("Fixed",kesi.getResolution());
        Assert.assertEquals("2011-04-15 10:55:57",
                DateFormatUtils.format(kesi.getLastModified(),"yyyy-MM-dd HH:mm:ss"));

        List<KesiITS.Comment> comments = kesi.getComments();

        Assert.assertEquals(1,comments.get(0).getNumber(),0);
        Assert.assertEquals(
                "If a driver is missing, clicking on the notification should open " +
                "the package manager (by default) so the user can find a driver",
                comments.get(0).getText().replaceAll("[\\s\\n\\t]+"," ").trim());

        Assert.assertEquals(comments.get(0).getPerson().getName(),"Sander Pientka");
        Assert.assertEquals(comments.get(0).getPerson().getId(),"cumulus0007@gmail.com");
        Assert.assertEquals(comments.get(0).getPerson().getEmail(),"cumulus0007@gmail.com");


        Assert.assertEquals(
                "2009-03-04 18:11:19",
                DateFormatUtils.format(comments.get(0).getDate(),"yyyy-MM-dd HH:mm:ss")
                );




        Assert.assertEquals(4125,kesi.getActivity().getId(),0);
        Assert.assertEquals("cumulus0007@gmail.com",kesi.getActivity().getWho());
        Assert.assertEquals("2009-03-04 18:11:19",
                DateFormatUtils.format(kesi.getActivity().getDate(),"yyyy-MM-dd HH:mm:ss"));

        List<KesiITS.Activity.ActivityWRA> activityWRAs = kesi.getActivity().getActivityWRAs();


        Assert.assertEquals("Status",activityWRAs.get(0).getWhat());
        Assert.assertEquals("Assigned",activityWRAs.get(0).getRemoved());
        Assert.assertEquals("Resolved",activityWRAs.get(0).getAdded());

    }


}
