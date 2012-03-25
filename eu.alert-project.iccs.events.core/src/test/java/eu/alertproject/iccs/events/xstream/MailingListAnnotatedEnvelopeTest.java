package eu.alertproject.iccs.events.xstream;

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
 * Date: 25/03/12
 * Time: 14:57
 */
public class MailingListAnnotatedEnvelopeTest {

    @Test
    public void serialized() throws IOException {

        String s = IOUtils.toString(MailingListAnnotatedEnvelopeTest.class.getResourceAsStream("/ALERT.KEUI.MailNew.Annotated.xml"));

        MailingListAnnotatedPayload.EventData eventData =EventFactory
                .<MailingListAnnotatedEnvelope>fromXml(s, MailingListAnnotatedEnvelope.class)
                .getBody()
                .getNotify()
                .getNotificationMessage()
                .getMessage()
                .getEvent()
                .getPayload()
                .getEventData();


        assertMailingList(eventData.getMailingList());
        assertMdService(eventData.getMdService());
        assertKeeui(eventData.getKeui());

    }

    private void assertKeeui(Keui keui) {

        List<Keui.Concept> contentConcepts = keui.getContentConcepts();
        Assert.assertEquals(31,contentConcepts.size(),0);
        Assert.assertEquals("KDE/free",contentConcepts.get(14).getUri());
        Assert.assertEquals(2,contentConcepts.get(14).getWeight(),0);

        List<Keui.Concept> subjectConcepts = keui.getSubjectConcepts();
        Assert.assertEquals(7,subjectConcepts.size(),0);
        Assert.assertEquals("http://ailab.ijs.si/alert/resource/r17671",subjectConcepts.get(3).getUri());
        Assert.assertEquals(1,subjectConcepts.get(3).getWeight(),0);


    }

    private void assertMdService(MdServiceMailingList mdService) {
        
        Assert.assertEquals(
                "http://www.alert-project.eu/ontologies/alert.owl#Email1",
                mdService.getEmailUri()
        );
        
        Assert.assertEquals(
                "http://www.alert-project.eu/ontologies/alert_scm.owl#Person1",
                mdService.getFromUri()
        );
        
        Assert.assertEquals(
                "http://www.alert-project.eu/ontologies/alert.owl#Email2",
                mdService.getInReplyToUri()
        );

        List<String> referencesUris = mdService.getReferencesUris();
        
        Assert.assertEquals(3,referencesUris.size(),0);
        Iterator<String> iterator = referencesUris.iterator();

        Assert.assertEquals("http://www.alert-project.eu/ontologies/alert.owl#Email3",iterator.next());
        Assert.assertEquals("http://www.alert-project.eu/ontologies/alert.owl#Email4",iterator.next());
        Assert.assertEquals("http://www.alert-project.eu/ontologies/alert.owl#Email2",iterator.next());

        
    }

    private void assertMailingList(MailingList mailingList) throws IOException {


        Assert.assertEquals("sasa.stojanovic@cimcollege.rs",mailingList.getFrom());
        
        Assert.assertEquals(
            "Sat, 05 Nov 2011 18:50:11 +0200",
            DateFormatUtils.format(mailingList.getDate(),
                    "EEE, dd MMM yyyy HH:mm:ss Z")
        );
        
        Assert.assertEquals(
                "[Kde-hardware-devel] Identifying iPod and iPhone-like devices using Solid (was: Amarok review request)",
                mailingList.getSubject()
        );

        Assert.assertEquals(
                "<CAMnMsSdoax0S14_fQe4woSLDhJYR0vc8wuZjKvsKqe7gVx1kxQ@mail.gmail.com>",
                mailingList.getInReplyTo()
        );

        Assert.assertEquals(
                "<20111025132029.15876.89012@vidsolbach.de><9102909.qJX79ctmp1@edgy><CAMnMsSdoax0S14_fQe4woSLDhJYR0vc8wuZjKvsKqe7gVx1kxQ@mail.gmail.com>",
                mailingList.getReference()
        );
        
        Assert.assertEquals(
                "<3674981.yjiqPb6iju@edgy>",
                mailingList.getMessageId()
        );

        List<String> attachments = mailingList.getAttachments().getAttachment();
        Assert.assertEquals(1,attachments.size(), 0);
        
        Assert.assertEquals(
                "http://mail.kde.org/pipermail/kde-hardware-devel/attachments/20111109/564d5259/attachment.html",
                attachments.get(0)
        );
        
        Assert.assertEquals(
                IOUtils.toString(this.getClass().getResourceAsStream("/MailingListMessage.txt")),
                mailingList.getContent()
        );

    }
}
