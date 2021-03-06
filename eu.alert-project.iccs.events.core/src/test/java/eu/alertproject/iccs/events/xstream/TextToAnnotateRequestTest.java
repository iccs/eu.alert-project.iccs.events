package eu.alertproject.iccs.events.xstream;

import eu.alertproject.iccs.events.alert.TextToAnnotateRequestEnvelope;
import eu.alertproject.iccs.events.alert.TextToAnnotateRequestPayload;
import eu.alertproject.iccs.events.api.EventFactory;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * User: fotis
 * Date: 14/03/12
 * Time: 22:07
 */

public class TextToAnnotateRequestTest {


    @Test
    public void testSerialize() throws IOException {

        TextToAnnotateRequestEnvelope textToAnnotateRequestEnvelope =
                EventFactory.<TextToAnnotateRequestEnvelope>fromXml(
                        IOUtils.toString(TextToAnnotateRequestTest.class.getResourceAsStream("/ALERT.Stardom.TextToAnnotate.xml")),
                        TextToAnnotateRequestEnvelope.class);

        TextToAnnotateRequestPayload.EventData eventData = textToAnnotateRequestEnvelope
                .getBody()
                .getNotify()
                .getNotificationMessage()
                .getMessage()
                .getEvent()
                .getPayload()
                .getEventData();

        Assert.assertEquals("qt amarok annotate me", eventData.getGeneralText().getText());
        Assert.assertEquals("stardom", eventData.getGeneralText().getSource());



    }


    @Test
    public void testDeserialize() throws IOException {

        String textToAnnotateRequestEvent = EventFactory.createTextToAnnotateRequestEvent(
                9999,
                123456,
                78910,
                1,
                "qt amarok annotate me");

        
        Assert.assertEquals(
                IOUtils.toString(TextToAnnotateRequestTest.class.getResourceAsStream("/ALERT.Stardom.TextToAnnotate.xml")),
                textToAnnotateRequestEvent
        );



    }


}
