package eu.alertproject.iccs.events.xstream;

import com.thoughtworks.xstream.XStream;
import eu.alertproject.iccs.events.api.EventFactory;
import eu.alertproject.iccs.events.api.Topics;
import eu.alertproject.iccs.events.socrates.*;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * User: fotis
 * Date: 13/03/12
 * Time: 22:47
 */

public class RecommendIssuesRequestEvenlopeTest {

    @Test
    public void testDeserializeRequest() throws ClassNotFoundException, IOException {
        
        XStream xstream = new XStream();
        xstream.processAnnotations(RecommendIssuesEnvelope.class);

        String s = IOUtils.toString(RecommendIssuesRequestEvenlopeTest.class.getResourceAsStream("/ALERT.ALL.Recommender.IssueRecommendationRequest.xml"));

        RecommendIssuesEnvelope o = EventFactory
                                .<RecommendIssuesEnvelope>fromXml(s, RecommendIssuesEnvelope.class);

        Assert.assertNotNull(o);
        Assert.assertEquals(Topics.ALERT_ALL_SOCRATES_Issue_Recommendation_Request,
                                        o.getBody()
                                        .getNotify()
                                        .getNotificationMessage()
                                        .getMessage()
                                        .getEvent()
                                        .getPayload()
                                        .getMeta()
                                        .getEventName());

        Assert.assertEquals("Request",
                                o.getBody()
                                .getNotify()
                                .getNotificationMessage()
                                .getMessage()
                                .getEvent()
                                .getPayload()
                                .getMeta()
                                .getType());


        List<IssueIdentities> issueIdentitieses = o.getBody().getNotify().getNotificationMessage().getMessage().getEvent().getPayload().getEventData().getIssueIdentities();

        Assert.assertNotNull(issueIdentitieses);
        Assert.assertEquals(1,issueIdentitieses.size(),0);

        Iterator<IssueIdentities> iterator = issueIdentitieses.iterator();

        IssueIdentities first = iterator.next();
        List<Identity> identities = first.getIdentities();

        Iterator<Identity> identityIterator = identities.iterator();

        Assert.assertEquals("51d8ecec1d6ea40106c6c71ffed13547010870b0ab57fe396f5fbb124967e0e1",identityIterator.next().getUuid().trim());
        Assert.assertEquals("51d8ecec1d6ea40106c6c71ffed13547010870b0ab57fe396f5fbb124967e0e2",identityIterator.next().getUuid().trim());
        Assert.assertEquals("51d8ecec1d6ea40106c6c71ffed13547010870b0ab57fe396f5fbb124967e0e3",identityIterator.next().getUuid().trim());
    }

    @Test
    public void testSerialize() throws IOException {
        List<Identity> identities =new ArrayList<Identity>();
        identities.add(new Identity("51d8ecec1d6ea40106c6c71ffed13547010870b0ab57fe396f5fbb124967e0e1","Fotis"));
        identities.add(new Identity("51d8ecec1d6ea40106c6c71ffed13547010870b0ab57fe396f5fbb124967e0e3","John"));
        identities.add(new Identity("51d8ecec1d6ea40106c6c71ffed13547010870b0ab57fe396f5fbb124967e0e4","Messi"));

        IssueIdentities issueIdentities = new IssueIdentities(
                new Issue("274", "owl#1"),
                identities);



        List<Identity> identities1 =new ArrayList<Identity>();
        identities1.add(new Identity("51d8ecec1d6ea40106c6c71ffed13547010870b0ab57fe396f5fbb124967e0e1","Fotis"));
        identities1.add(new Identity("51d8ecec1d6ea40106c6c71ffed13547010870b0ab57fe396f5fbb124967e0e3","John"));
        identities1.add(new Identity("51d8ecec1d6ea40106c6c71ffed13547010870b0ab57fe396f5fbb124967e0e4","Messi"));

        IssueIdentities issueIdentities1 = new IssueIdentities(
                new Issue("2050","owl#2"),
                identities1
        );


        List<IssueIdentities> issueIdentitieses = new ArrayList<IssueIdentities>();
        issueIdentitieses.add(issueIdentities);
        issueIdentitieses.add(issueIdentities1);


        Assert.assertEquals(
                        EventFactory.createRecommendationIdentityEvent(
                                5748,
                                10001L,
                                10012L,
                                1,
                                null,
                                issueIdentitieses),
                        IOUtils.toString(RecommendIdentitiesRequestEnvelopeTest.class.getResourceAsStream("/ALERT.Recommender.IdentityRecommendation.xml"))
                );
    }


}
