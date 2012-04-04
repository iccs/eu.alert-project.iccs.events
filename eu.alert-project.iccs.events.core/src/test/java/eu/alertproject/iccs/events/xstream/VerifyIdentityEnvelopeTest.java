package eu.alertproject.iccs.events.xstream;

import com.thoughtworks.xstream.XStream;
import eu.alertproject.iccs.events.api.EventFactory;
import eu.alertproject.iccs.events.api.Topics;
import eu.alertproject.iccs.events.socrates.*;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * User: fotis
 * Date: 16/03/12
 * Time: 18:16
 */
public class VerifyIdentityEnvelopeTest {

    @Test
    public void serialize() throws IOException {

        String s = IOUtils.toString(VerifyIdentityEnvelopeTest.class.getResourceAsStream("/ALERT.ALL.Recommender.VerifyIdentitiesRequest.xml"));

        VerifyIdentityEnvelope o = EventFactory.<VerifyIdentityEnvelope>fromXml(s,VerifyIdentityEnvelope.class);

        Assert.assertNotNull(o);

        VerifyIdentityPayload payload = o.getBody()
                .getNotify()
                .getNotificationMessage()
                .getMessage()
                .getEvent()
                .getPayload();


        Assert.assertEquals(Topics.ALERT_ALL_SOCRATES_Identity_Verification_Request,payload.getMeta().getEventName());

        VerifyIdentityPayload.EventData eventData = payload.getEventData();


        Assert.assertEquals("51d8ecec1d6ea40106c6c71ffed13547010870b0ab57fe396f5fbb124967e0e1",eventData.getIdentity().getUuid());
        Assert.assertEquals("274",eventData.getIssue().getUuid());
        Assert.assertEquals("owl#1",eventData.getIssue().getBug());
        Assert.assertEquals("1234",eventData.getPatternId());


    }

    @Test
    public void deserialize() throws IOException {

        XStream xstream = new XStream();
        xstream.processAnnotations(VerifyIdentityEnvelope.class);


        String s = EventFactory.createVerifyIdentityEvent(
                5748,
                10000L,
                10010L,
                1,
                new Identity("51d8ecec1d6ea40106c6c71ffed13547010870b0ab57fe396f5fbb124967e0e1",null),
                new Issue("274","owl#1"),
                "1234",
                true);

        Assert.assertEquals(
            IOUtils.toString(VerifyIdentityEnvelopeTest.class.getResourceAsStream("/ALERT.Recommender.IdentityVerification.xml")),
            s);


    }
}
