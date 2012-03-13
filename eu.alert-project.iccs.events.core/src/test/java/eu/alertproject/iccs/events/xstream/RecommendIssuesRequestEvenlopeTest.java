package eu.alertproject.iccs.events.xstream;

import com.thoughtworks.xstream.XStream;
import eu.alertproject.iccs.events.api.EventFactory;
import eu.alertproject.iccs.events.api.Topics;
import eu.alertproject.iccs.events.socrates.RecommendIssuesEnvelope;
import eu.alertproject.iccs.events.socrates.RecommendIssuesPayload;
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

        RecommendIssuesEnvelope o = (RecommendIssuesEnvelope) xstream.fromXML(s);
        
        Assert.assertNotNull(o);
        Assert.assertEquals(Topics.ALERT_SEARCH_SOCRATES_Issue_Recommendation_Request,
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


        List<RecommendIssuesPayload.EventData.Identity> identities = o.getBody().getNotify().getNotificationMessage().getMessage().getEvent().getPayload().getEventData().getIdentities();

        Assert.assertNotNull(identities);
        Assert.assertEquals(3,identities.size(),0);

        Iterator<RecommendIssuesPayload.EventData.Identity> iterator = identities.iterator();
        
        Assert.assertEquals("51d8ecec1d6ea40106c6c71ffed13547010870b0ab57fe396f5fbb124967e0e1",iterator.next().getUuid().trim());
        Assert.assertEquals("51d8ecec1d6ea40106c6c71ffed13547010870b0ab57fe396f5fbb124967e0e2",iterator.next().getUuid().trim());
        Assert.assertEquals("51d8ecec1d6ea40106c6c71ffed13547010870b0ab57fe396f5fbb124967e0e3",iterator.next().getUuid().trim());
    }

    @Test
    public void testSerialize() throws IOException {
        List<RecommendIssuesPayload.EventData.Identity> identities =
                                                new ArrayList<RecommendIssuesPayload.EventData.Identity>();


        identities.add(new RecommendIssuesPayload.EventData.Identity("51d8ecec1d6ea40106c6c71ffed13547010870b0ab57fe396f5fbb124967e0e1","Fotis"));
        identities.add(new RecommendIssuesPayload.EventData.Identity("51d8ecec1d6ea40106c6c71ffed13547010870b0ab57fe396f5fbb124967e0e3","John"));
        identities.add(new RecommendIssuesPayload.EventData.Identity("51d8ecec1d6ea40106c6c71ffed13547010870b0ab57fe396f5fbb124967e0e4","Messi"));



                Assert.assertEquals(
                        EventFactory.createRecommendationIdentityEvent(
                                5748,
                                10001L,
                                10012L,
                                1,
                                identities),
                        IOUtils.toString(RecommendIdentitiesRequestEnvelopeTest.class.getResourceAsStream("/ALERT.Recommender.IdentityRecommendation.xml"))
                );
    }


}
