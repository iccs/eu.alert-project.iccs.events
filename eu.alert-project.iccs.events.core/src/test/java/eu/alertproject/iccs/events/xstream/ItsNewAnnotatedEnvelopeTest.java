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
public class ItsNewAnnotatedEnvelopeTest {
    
    @Test
    public void desirialize() throws IOException {

        String s = IOUtils.toString(ItsNewAnnotatedEnvelopeTest.class.getResourceAsStream("/ALERT.KEUI.IssueNew.Annotated.xml"));
        IssueNewAnnotatedPayload.EventData eventData = EventFactory
                .<IssueNewAnnotatedEnvelope>fromXml(s,IssueNewAnnotatedEnvelope.class)
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

    @Test
    public void testDesirializeInvalidNodes() throws IOException{

        String s = IOUtils.toString(ItsNewAnnotatedEnvelopeTest.class.getResourceAsStream("/ALERT.KEUI.IssueNew.AnnotatedInvalidNodes.xml"));
        IssueNewAnnotatedPayload.EventData eventData = EventFactory
                .<IssueNewAnnotatedEnvelope>fromXml(s,IssueNewAnnotatedEnvelope.class)
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

        Assert.assertEquals("Notify <concept id=\"KDE/user\">user</concept> on <concept id=\"http://ailab.ijs.si/alert/resource/r364\">hardware</concept> changes <concept id=\"http://ailab.ijs.si/alert/resource/r17814\">2</concept>",
                keui.getIssueDescriptionAnnotated().replaceAll("[\\s\\t\\n]+"," ").trim());

        List<Keui.Concept> issueDescriptionConcepts = keui.getIssueDescriptionConcepts();
        Assert.assertEquals(3,issueDescriptionConcepts.size(),0);
        Iterator<Keui.Concept> iterator = issueDescriptionConcepts.iterator();

        Keui.Concept next = iterator.next();
        Assert.assertEquals("KDE/user",next.getUri());
        Assert.assertEquals(1,next.getWeight(),0);

        Keui.Concept next1 = iterator.next();
        Assert.assertEquals("http://ailab.ijs.si/alert/resource/r364",next1.getUri());
        Assert.assertEquals(1,next1.getWeight(),0);


        Keui.Concept next2 = iterator.next();
        Assert.assertEquals("http://ailab.ijs.si/alert/resource/r17814",next2.getUri());
        Assert.assertEquals(1,next2.getWeight(),0);

        
        Assert.assertEquals(
                "<concept id=\"http://ailab.ijs.si/alert/resource/r18520\">Version</concept>: (using <concept id=\"KDE/KDE_4\">KDE 4</concept>.<concept id=\"http://ailab.ijs.si/alert/resource/r17814\">2</concept>.0) OS: <concept id=\"http://ailab.ijs.si/alert/resource/r14937\">Linux</concept> <concept id=\"http://ailab.ijs.si/alert/resource/r18126\">Installed</concept> from: <concept id=\"http://ailab.ijs.si/alert/resource/r18117\">Ubuntu</concept> <concept id=\"http://ailab.ijs.si/alert/resource/r17650\">Packages</concept> It would be awesome if <concept id=\"KDE/KDE\">KDE</concept> notifies te <concept id=\"KDE/user\">user</concept> of newly <concept id=\"http://ailab.ijs.si/alert/resource/r18126\">installed</concept> <concept id=\"http://ailab.ijs.si/alert/resource/r364\">hardware</concept>, missing <concept id=\"http://ailab.ijs.si/alert/resource/r17629\">drivers</concept>, <concept id=\"KDE/programming\">programs</concept> to use the connected <concept id=\"KDE/devices\">device</concept>, etc.",
                keui.getCommentTextAnnotated().replaceAll("[\\s\\t\\n]+"," ").trim());

        List<Keui.Concept> commentTextConcepts = keui.getCommentTextConcepts();
        Assert.assertEquals(13,commentTextConcepts.size(),0);
        
        //if we get the middle one we are ok
        Assert.assertEquals("http://ailab.ijs.si/alert/resource/r17650",commentTextConcepts.get(6).getUri());
        Assert.assertEquals(1,commentTextConcepts.get(6).getWeight(),0);

        Assert.assertEquals(7805,keui.getItemId().iterator().next(),0);
        Assert.assertEquals(12,keui.getThreadId().iterator().next(),0);

    }


    private void assertMdService(MdServiceITS mdService){

        Assert.assertEquals("http://www.alert-project.eu/ontologies/alert_its.owl#Bug1",mdService.getUri().trim());
        Assert.assertEquals("http://www.alert-project.eu/ontologies/alert_scm.owl#Person1",mdService.getAuthorUri().trim());
        Assert.assertEquals("http://www.ifi.uzh.ch/ddis/evoont/2008/11/bom#Product1",mdService.getProduct().getUri().trim());
        Assert.assertEquals("http://www.ifi.uzh.ch/ddis/evoont/2008/11/bom#Component1",mdService.getProduct().getComponentUri().trim());
        Assert.assertEquals("http://www.ifi.uzh.ch/ddis/evoont/2008/11/bom#ComputerSystem1",mdService.getCommputerSystem().getUri().trim());
        Assert.assertEquals("http://www.alert-project.eu/ontologies/alert_scm.owl#Person2",mdService.getAssignedToUri().trim());
        Assert.assertEquals("http://www.alert-project.eu/ontologies/alert_scm.owl#Person3",mdService.getCcPersonUri().iterator().next().trim());
        Assert.assertEquals("http://www.alert-project.eu/ontologies/alert_its.owl#Bug2",mdService.getDependsOnUri().trim());
        Assert.assertEquals("http://www.alert-project.eu/ontologies/alert_its.owl#Bug3",mdService.getBlocksUri().trim());
        Assert.assertEquals("http://www.ifi.uzh.ch/ddis/evoont/2008/11/bom#Comment1",mdService.getComment().iterator().next().getUri().trim());
        Assert.assertEquals("http://www.alert-project.eu/ontologies/alert_scm.owl#Person1",mdService.getComment().iterator().next().getPersonUri().trim());
        Assert.assertEquals("http://www.ifi.uzh.ch/ddis/evoont/2008/11/bom#Attachment1",mdService.getAttachment().getUri().trim());
        Assert.assertEquals("http://www.alert-project.eu/ontologies/alert_its.owl#IssueTracker1",mdService.getTracker().getUri().trim());


    }

    private void assertKesi(KesiITS kesi) {
        
        Assert.assertEquals(184671,kesi.getId(),0);
            //<s:name>Alex Fiestas</s:name>;
        Assert.assertEquals("Alex Fiestas",kesi.getAuthor().getName());
            //<s:id>afiestas@kde.org</s:id>;
        Assert.assertEquals("afiestas@kde.org",kesi.getAuthor().getId());
            //<s:email>afiestas@kde.org</s:email>;
        Assert.assertEquals("afiestas@kde.org",kesi.getAuthor().getEmail());
        //<s:issueStatus>Assigned</s:issueStatus>;
        Assert.assertEquals("Assigned",kesi.getStatus());
        //<s:issueDescription>Notify user on hardware changes 2</s:issueDescription>;
        Assert.assertEquals("Notify user on hardware changes 2",kesi.getDescription());
        //<s:issueKeyword>keyword</s:issueKeyword>;
        Assert.assertEquals("keyword",kesi.getKeyword());
            //<s:productId>solid</s:productId>;
        Assert.assertEquals("solid",kesi.getProduct().getId());
            //<s:productComponentId>general</s:productComponentId>;
        Assert.assertEquals("general",kesi.getProduct().getComponentId());
            //<s:productVersion>unspecified</s:productVersion>;
        Assert.assertEquals("unspecified",kesi.getProduct().getVersion());
            //<s:computerSystemPlatform>Ubuntu Packages</s:computerSystemPlatform>;
        Assert.assertEquals("Ubuntu Packages",kesi.getComputerSystem().getPlatform());
            //<s:computerSystemOS>Linux</s:computerSystemOS>;
        Assert.assertEquals("Linux",kesi.getComputerSystem().getOs());
        //<s:issuePriority>4</s:issuePriority>;
        Assert.assertEquals("4",kesi.getPriority());

        //<s:issueSeverity>Blocker</s:issueSeverity>;
        Assert.assertEquals("Blocker",kesi.getSeverity());

        //<s:issueAssignedTo>
            //<s:name>Sander Pientka</s:name>;
        Assert.assertEquals("Sander Pientka",kesi.getAssignedTo().getName());
            //<s:id>cumulus0007@gmail.com</s:id>;
        Assert.assertEquals("cumulus0007@gmail.com",kesi.getAssignedTo().getId());
            //<s:email>cumulus0007@gmail.com</s:email>;
        Assert.assertEquals("cumulus0007@gmail.com",kesi.getAssignedTo().getEmail());
        //</s:issueAssignedTo>
        //<s:issueCCPerson>
            //<s:name>Angel Blue</s:name>;
        Assert.assertEquals("Angel Blue",kesi.getCcPerson().iterator().next().getName());
            //<s:id>angel_blue_co2004@yahoo.com</s:id>;
        Assert.assertEquals("angel_blue_co2004@yahoo.com",kesi.getCcPerson().iterator().next().getId());
            //<s:email>angel_blue_co2004@yahoo.com</s:email>;
        Assert.assertEquals("angel_blue_co2004@yahoo.com",kesi.getCcPerson().iterator().next().getEmail());
        //</s:issueCCPerson>
        //<s:issueUrl>https://bugs.kde.org/show_bug.cgi?id=184671</s:issueUrl>;
        Assert.assertEquals("https://bugs.kde.org/show_bug.cgi?id=184671",kesi.getUrl());
        //<s:issueDependsOnId>10001</s:issueDependsOnId>;
        Assert.assertEquals(10001,kesi.getDependsOnId(),0);
        //<s:issueBlocksId>20001</s:issueBlocksId>;
        Assert.assertEquals(20001,kesi.getBlocksId(),0);
        //<s:issueDateOpened>2009-02-17 16:31</s:issueDateOpened>;
        Assert.assertEquals("2009-02-17 16:31",
                DateFormatUtils.format(kesi.getDateOpened(),"yyyy-MM-dd HH:mm"));
        //<s:issueComment>
            //<s:commentNumber>0</s:commentNumber>;
        List<KesiITS.Comment> comments = kesi.getComments();
        Assert.assertEquals(1, comments.size(),0);

        Iterator<KesiITS.Comment> iterator = comments.iterator();
        KesiITS.Comment comment1 = iterator.next();
        Assert.assertEquals("Version: (using KDE 4.2.0) OS: Linux Installed from: Ubuntu " +
                "Packages It would be awesome if KDE notifies te user of newly installed " +
                "hardware, missing drivers, programs to use the connected device, etc.",
                comment1.getText().replaceAll("[\\s\\n\\t]+"," ").trim());

                //<s:name>Alex Fiestas</s:name>;
        Assert.assertEquals("Alex Fiestas",comment1.getPerson().getName());
                //<s:id>afiestas@kde.org</s:id>;
        Assert.assertEquals("afiestas@kde.org",
                comment1.getPerson().getId());
                //<s:email>afiestas@kde.org</s:email>;
        Assert.assertEquals("afiestas@kde.org",
                comment1.getPerson().getEmail());
            //<s:commentDate>2009-02-17 16:31:37</s:commentDate>;
        Assert.assertEquals(
                "2009-02-17 16:31:37",
                DateFormatUtils.format(comment1.getDate(),"yyyy-MM-dd HH:mm:ss")
                );


        List<KesiITS.Attachement> issueAttachments = kesi.getAttachements();
        Assert.assertEquals(1,issueAttachments.size(),0);

        KesiITS.Attachement next = issueAttachments.iterator().next();



        //<s:attachmentId>3532</s:attachmentId>;
        Assert.assertEquals(3532,next.getId(),0);
            //<s:attachmentFilename>name</s:attachmentFilename>;
        Assert.assertEquals("name",next.getFilename());
            //<s:attachmentType>doc</s:attachmentType>;
        Assert.assertEquals("doc",next.getType());

        //<s:name>Alex Fiestas</s:name>;
        Assert.assertEquals("Alex Fiestas",next.getCreator().getName());
        //<s:id>afiestas@kde.org</s:id>;
        Assert.assertEquals("afiestas@kde.org",next.getCreator().getId());
        //<s:email>afiestas@kde.org</s:email>;
        Assert.assertEquals("afiestas@kde.org",next.getCreator().getEmail());

            //<s:issueTrackerId>241</s:issueTrackerId>;
        Assert.assertEquals(241,kesi.getTracker().getId(),0);
            //<s:issueTrackerType>bugzilla</s:issueTrackerType>;
        Assert.assertEquals("bugzilla",kesi.getTracker().getType());
            //<s:issueTrackerURL>https://bugs.kde.org/</s:issueTrackerURL>;
        Assert.assertEquals("https://bugs.kde.org/",kesi.getTracker().getUrl());

    }
}
