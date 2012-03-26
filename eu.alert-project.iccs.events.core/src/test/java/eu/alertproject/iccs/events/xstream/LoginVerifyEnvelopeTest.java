package eu.alertproject.iccs.events.xstream;

import eu.alertproject.iccs.events.api.EventFactory;
import eu.alertproject.iccs.events.stardom.LoginVerifyEnvelope;
import eu.alertproject.iccs.events.stardom.LoginVerifyPayload;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: fotis
 * Date: 26/03/12
 * Time: 15:40
 * To change this template use File | Settings | File Templates.
 */
public class LoginVerifyEnvelopeTest{

    @Test
    public void serialize() throws IOException {

        LoginVerifyEnvelope verifyEnvelope = EventFactory.<LoginVerifyEnvelope>fromXml(
                IOUtils.toString(this.getClass().getResourceAsStream("/ALERT.ALL.LoginVerifyRequest.xml")),
                LoginVerifyEnvelope.class);


        LoginVerifyPayload.EventData eventData = verifyEnvelope
                .getBody()
                .getNotify()
                .getNotificationMessage()
                .getMessage()
                .getEvent()
                .getPayload()
                .getEventData();


        LoginVerifyPayload.EventData.Login login = eventData.getLogin();


        Assert.assertEquals("junma@fzi.de", login.getEmail());
        Assert.assertEquals("jun ma", login.getUsername());
        Assert.assertNull(login.getIdentity());


    }

    @Test
    public void testCreate() throws IOException, SAXException {

        String verifyEnvelope = EventFactory.createStardomLoginVerifyEnvelope(
                5748,
                10000L,
                10010L,
                1,
                "jun ma",
                "junma@fzi.de",
                "9e3d2a64-ff8d-45a2-8034-55d7699caa08"
        );


        String control = IOUtils.toString(this.getClass().getResourceAsStream("/ALERT.Stardom.LoginVerify.xml"));
        String test = verifyEnvelope;

        Assert.assertEquals(
                control,
                test
        );


    }


}
