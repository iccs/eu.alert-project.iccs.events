package eu.alertproject.iccs.events.xstream;

import com.thoughtworks.xstream.XStream;
import eu.alertproject.iccs.events.alert.*;
import eu.alertproject.iccs.events.api.EventFactory;
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
        
        String s = IOUtils.toString(ItsUpdateAnnotatedEnvelopeTest.class.getResourceAsStream("/ALERT.KEUI.IssueUpdate.Annotated.xml"));
//        String s = IOUtils.toString(ItsUpdateAnnotatedEnvelopeTest.class.getResourceAsStream("/ALERT.KESI.IssueUpdated.xml"));
        IssueUpdateAnnotatedPayload.EventData eventData = EventFactory
                .<IssueUpdateAnnotatedEnvelope>fromXml(s, IssueUpdateAnnotatedEnvelope.class)
                .getBody()
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

        List<Keui.Comment> issueComment = keui.getIssueComment();


        Keui.Comment next = issueComment.iterator().next();

        Assert.assertEquals("<concept id=\"http://ailab.ijs.si/alert/resource/r18520\">Version</concept>: (using <concept id=\"http://ailab.ijs.si/alert/resource/r14859\">KDE</concept> Devel) <concept id=\"http://ailab.ijs.si/alert/resource/installed\">Installed</concept> from: <concept id=\"http://ailab.ijs.si/alert/resource/r17256\">Compiled</concept> <concept id=\"http://ailab.ijs.si/alert/resource/r17290\">sources</concept> OS: <concept id=\"http://ailab.ijs.si/alert/resource/r14937\">Linux</concept> There are many settings that depend on your <concept id=\"http://ailab.ijs.si/alert/resource/r16273\">computer</concept> ' <concept id=\"http://ailab.ijs.si/alert/resource/r16797\">s</concept> <concept id=\"http://ailab.ijs.si/alert/resource/r18444\">performance</concept>. The <concept id=\"http://ailab.ijs.si/alert/resource/r12142\">user</concept> should not have to bother adapting the default settings to the <concept id=\"http://ailab.ijs.si/alert/resource/r364\">hardware</concept>, e.<concept id=\"http://ailab.ijs.si/alert/resource/r18431\">g</concept>. for kwin+composite, <concept id=\"http://ailab.ijs.si/alert/resource/r15163\">eye-candy</concept> in general (<concept id=\"http://ailab.ijs.si/alert/resource/r7859\">plasma</concept>). Further even less obviously <concept id=\"http://ailab.ijs.si/alert/resource/r7566\">related</concept> <concept id=\"http://ailab.ijs.si/alert/resource/r2004\">applications</concept> will have serious <concept id=\"http://ailab.ijs.si/alert/resource/r16372\">usability</concept>-bugs if there is no possibility to adapt default settings. An example: Dolphin uses a default <concept id=\"http://ailab.ijs.si/alert/resource/r14650\">setting</concept> for creating <concept id=\"http://ailab.ijs.si/alert/resource/r9178\">previews</concept> that restricts that <concept id=\"http://ailab.ijs.si/alert/resource/r14957\">functionality</concept> to <concept id=\"http://ailab.ijs.si/alert/resource/r309\">files</concept> smaller than 1MB. As a result by default no <concept id=\"http://ailab.ijs.si/alert/resource/r309\">file</concept> that is larger than 1MB will be <concept id=\"http://ailab.ijs.si/alert/resource/r17072\">displayed</concept> as <concept id=\"http://ailab.ijs.si/alert/resource/r17559\">image</concept>-<concept id=\"http://ailab.ijs.si/alert/resource/r18382\">thumbnail</concept> when the <concept id=\"http://ailab.ijs.si/alert/resource/r12142\">user</concept> <concept id=\"http://ailab.ijs.si/alert/resource/r3772\">clicks</concept> on \" <concept id=\"http://ailab.ijs.si/alert/resource/r9178\">preview</concept> \" . The most useful <concept id=\"http://ailab.ijs.si/alert/resource/r9178\">preview</concept> concerns pictures, i.e. photos. Today <concept id=\"http://ailab.ijs.si/alert/resource/r15655\">digital-cameras</concept> provide at least a <concept id=\"http://ailab.ijs.si/alert/resource/r1184\">resolution</concept> of 4 <concept id=\"http://ailab.ijs.si/alert/resource/r3985\">Megapixel</concept> or more. This means that the <concept id=\"http://ailab.ijs.si/alert/resource/r12142\">user</concept> will not be able to use the <concept id=\"http://ailab.ijs.si/alert/resource/r9178\">preview</concept> <concept id=\"http://ailab.ijs.si/alert/resource/r14957\">functionality</concept> with its default settings for photos. Which is pretty bad from a <concept id=\"http://ailab.ijs.si/alert/resource/r16372\">usability</concept> point of <concept id=\"http://ailab.ijs.si/alert/resource/r17533\">view</concept>. Of course this <concept id=\"http://ailab.ijs.si/alert/resource/r14650\">setting</concept> <concept id=\"http://ailab.ijs.si/alert/resource/r6204\">does</concept> <concept id=\"http://ailab.ijs.si/alert/resource/r1458\">make</concept> sense for old <concept id=\"http://ailab.ijs.si/alert/resource/r364\">hardware</concept> (very old indeed). So it becomes obvious that a lot of default-settings depend on the <concept id=\"http://ailab.ijs.si/alert/resource/r16273\">computer</concept> ' <concept id=\"http://ailab.ijs.si/alert/resource/r16797\">s</concept> <concept id=\"http://ailab.ijs.si/alert/resource/r364\">hardware</concept>. In order to avoid these kind of issues there should be a central point that <concept id=\"http://ailab.ijs.si/alert/resource/r2004\">applications</concept> can <concept id=\"http://ailab.ijs.si/alert/resource/r4586\">query</concept> in order to adjust their settings accordingly. Minimal <concept id=\"http://ailab.ijs.si/alert/resource/r3541\">implementation</concept>: Provide a place where the <concept id=\"http://ailab.ijs.si/alert/resource/r12142\">user</concept> can manually <concept id=\"http://ailab.ijs.si/alert/resource/r14650\">set</concept> the <concept id=\"http://ailab.ijs.si/alert/resource/r364\">hardware</concept> ' <concept id=\"http://ailab.ijs.si/alert/resource/r16797\">s</concept> <concept id=\"http://ailab.ijs.si/alert/resource/r18444\">performance</concept>-level. At least one would not have to modify each and every <concept id=\"http://ailab.ijs.si/alert/resource/r2004\">application</concept> on its own. <concept id=\"http://ailab.ijs.si/alert/resource/r18444\">PERFORMANCE</concept> <concept id=\"http://ailab.ijs.si/alert/resource/r17367\">Graphics</concept>: low/medium/high <concept id=\"http://ailab.ijs.si/alert/resource/r18328\">CPU</concept>: low/medium/high <concept id=\"http://ailab.ijs.si/alert/resource/r15637\">RAM</concept>: < 512/ < 1024/ > 1024MB Optimal <concept id=\"http://ailab.ijs.si/alert/resource/r3541\">implementation</concept>: Check <concept id=\"http://ailab.ijs.si/alert/resource/r364\">hardware</concept> automatically and provide a <concept id=\"http://ailab.ijs.si/alert/resource/r18252\">button</concept> to re-check. Rate <concept id=\"http://ailab.ijs.si/alert/resource/r17367\">graphics</concept>/(-<concept id=\"http://ailab.ijs.si/alert/resource/r17629\">driver</concept>), <concept id=\"http://ailab.ijs.si/alert/resource/r15637\">RAM</concept> and <concept id=\"http://ailab.ijs.si/alert/resource/r18328\">CPU</concept> and <concept id=\"http://ailab.ijs.si/alert/resource/r6680\">assign</concept> a <concept id=\"http://ailab.ijs.si/alert/resource/r17525\">number</concept> to each. An overall value would not be enough since some <concept id=\"http://ailab.ijs.si/alert/resource/r2004\">applications</concept> might only need a lot of <concept id=\"http://ailab.ijs.si/alert/resource/r15637\">RAM</concept> but no <concept id=\"http://ailab.ijs.si/alert/resource/r17367\">graphics</concept>-<concept id=\"http://ailab.ijs.si/alert/resource/r18444\">performance</concept>. As a result Dolphin would use e.<concept id=\"http://ailab.ijs.si/alert/resource/r18431\">g</concept>. 5MB as default <concept id=\"http://ailab.ijs.si/alert/resource/r14650\">setting</concept> for <concept id=\"http://ailab.ijs.si/alert/resource/r9178\">preview</concept> on recent <concept id=\"http://ailab.ijs.si/alert/resource/r364\">hardware</concept> but lower the <concept id=\"http://ailab.ijs.si/alert/resource/r14650\">setting</concept> automatically on older <concept id=\"http://ailab.ijs.si/alert/resource/r364\">hardware</concept>. Kwin as well as <concept id=\"http://ailab.ijs.si/alert/resource/r7859\">plasma</concept> would adjust the effects used, <concept id=\"http://ailab.ijs.si/alert/resource/r15156\">openGL</concept> <concept id=\"http://ailab.ijs.si/alert/resource/r6651\">screensavers</concept> would be excluded/<concept id=\"http://ailab.ijs.si/alert/resource/r18129\">included</concept> etc.",
                next.getAnnotatedText());

        List<Keui.Concept> commentTextConcepts = next.getConcepts();
        Assert.assertEquals(43,commentTextConcepts.size(),0);
        
        //if we get the middle one we are ok
        Assert.assertEquals("http://ailab.ijs.si/alert/resource/r17256",commentTextConcepts.get(3).getUri());
        Assert.assertEquals(1,commentTextConcepts.get(3).getWeight(),0);

        Assert.assertEquals(0,keui.getThreadId().iterator().next(),0);
    }


    private void assertMdService(MdServiceITS mdService){

        Assert.assertEquals("http://www.alert-project.eu/ontologies/alert_its.owl#Bug1",
                            mdService.getUri());
        Assert.assertEquals("http://www.ifi.uzh.ch/ddis/evoont/2008/11/bom#Comment1",
                mdService.getComment().iterator().next().getUri().trim());
        Assert.assertEquals(
                "http://www.alert-project.eu/ontologies/alert_scm.owl#Person1",
                mdService.getComment().iterator().next().getPersonUri().trim()

        );
        
        Assert.assertEquals(7,mdService.getActivity().size(),0);


        Assert.assertEquals("http://www.ifi.uzh.ch/ddis/evoont/2008/11/bom#Activity2",
                mdService.getActivity().get(1).getUri().trim());
        Assert.assertEquals("http://www.alert-project.eu/ontologies/alert_scm.owl#Person3",
                mdService.getActivity().get(1).getWhoUri().trim());

    }

    private void assertKesi(KesiITS kesi) {
        
        Assert.assertEquals(147934,kesi.getId(),0);

        Assert.assertEquals("Resolved",kesi.getStatus());
        Assert.assertEquals("DUPLICATE",kesi.getResolution());
        Assert.assertEquals("2010-10-02 00:00:00",
                DateFormatUtils.format(kesi.getLastModified(),"yyyy-MM-dd HH:mm:ss"));

        List<KesiITS.Comment> comments = kesi.getComments();

        Assert.assertEquals(
                "There is already such a possibility, though we need to investigate that further. " +
                "The best move would be writing in kde-devel mailing list I suppose",
                comments.get(1).getText());

        Assert.assertEquals(comments.get(0).getPerson().getName(),"S. Burmeister");
        Assert.assertEquals(comments.get(0).getPerson().getId(),"sven.burmeister");
        Assert.assertEquals(comments.get(0).getPerson().getEmail(),"sven.burmeister");


        Assert.assertEquals(
                "2007-07-16 00:00:00",
                DateFormatUtils.format(comments.get(0).getDate(),"yyyy-MM-dd HH:mm:ss")
                );


        List<KesiITS.Activity> activity = kesi.getActivity();
        Assert.assertEquals(7,activity.size(),0);


        KesiITS.Activity activity1 = activity.get(6);
        Assert.assertEquals("ervin",activity1.getWho());
        Assert.assertEquals("2010-10-02 12:49:18",
                DateFormatUtils.format(activity1.getDate(), "yyyy-MM-dd HH:mm:ss"));


    }


}
