package eu.alertproject.iccs.events.xstream;

import com.thoughtworks.xstream.XStream;
import eu.alertproject.iccs.events.alert.MailingListAnnotatedEnvelope;
import eu.alertproject.iccs.events.api.EventFactory;
import eu.alertproject.iccs.events.api.Topics;
import eu.alertproject.iccs.events.socrates.Issue;
import eu.alertproject.iccs.events.socrates.RecommendIdentityEnvelope;
import eu.alertproject.iccs.events.socrates.RecommendIdentityPayload;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * User: fotis
 * Date: 13/03/12
 * Time: 22:47
 */

public class RecommendIdentitiesRequestEnvelopeTest {

    private Logger logger = LoggerFactory.getLogger(RecommendIdentitiesRequestEnvelopeTest.class);

    @Test
    public void testDeserializeRequest() throws ClassNotFoundException, IOException {
        
        XStream xstream = new XStream();
        xstream.processAnnotations(RecommendIdentityEnvelope.class);

        String s = IOUtils.toString(RecommendIdentitiesRequestEnvelopeTest.class.getResourceAsStream("/ALERT.ALL.Recommender.IdentitiesRecommendationRequest.xml"));

        RecommendIdentityEnvelope o =EventFactory
                        .<RecommendIdentityEnvelope>fromXml(s, RecommendIdentityEnvelope.class);

        Assert.assertNotNull(o);
        Assert.assertEquals(Topics.ALERT_ALL_SOCRATES_Identity_Recommendation_Request,
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

        List<Issue> identities = o.getBody()
                                                                            .getNotify()
                                                                            .getNotificationMessage()
                                                                            .getMessage()
                                                                            .getEvent()
                                                                            .getPayload()
                                                                            .getEventData()
                                                                            .getIssues();

        Assert.assertNotNull(identities);
        Assert.assertEquals(4,identities.size(),0);

        Iterator<Issue> iterator = identities.iterator();

        Issue next = iterator.next();
        Assert.assertEquals("274", next.getUuid().trim());
        Assert.assertEquals("owl#1", next.getBug().trim());


        next = iterator.next();
        Assert.assertEquals("2050", next.getUuid().trim());
        Assert.assertEquals("owl#2", next.getBug().trim());


        next = iterator.next();
        Assert.assertEquals("2030", next.getUuid().trim());
        Assert.assertEquals("owl#3", next.getBug().trim());


        next = iterator.next();
        Assert.assertEquals("2040", next.getUuid().trim());
        Assert.assertEquals("owl#4", next.getBug().trim());

    }

    @Test
    public void testSerialize() throws IOException {
        
        List<Issue> issues =new ArrayList<Issue>();


        issues.add(new Issue("1010","owl#1"));
        issues.add(new Issue("2050","owl#2"));
        issues.add(new Issue("2030","owl#3"));
        issues.add(new Issue("2040","owl#4"));

        Assert.assertEquals(
                EventFactory.createRecommendationIssuesEvent(
                        1818516212,
                        1331676396932L,
                        1331676396937L,
                        570749432,
                        issues),
                IOUtils.toString(RecommendIdentitiesRequestEnvelopeTest.class.getResourceAsStream("/ALERT.Recommender.IssueRecommendation.xml"))
        );

    }


}
