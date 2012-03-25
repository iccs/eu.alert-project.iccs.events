package eu.alertproject.iccs.events.xstream;

import eu.alertproject.iccs.events.alert.Keui;
import eu.alertproject.iccs.events.alert.TextToAnnotateReplyEnvelope;
import eu.alertproject.iccs.events.alert.TextToAnnotateReplyPayload;
import eu.alertproject.iccs.events.api.EventFactory;
import eu.alertproject.iccs.events.api.Topics;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * User: fotis
 * Date: 14/03/12
 * Time: 22:32
 */
public class TextToAnnotateReplyTest {

    @Test
    public void testSerialize() throws IOException {

        TextToAnnotateReplyEnvelope textToAnnotateReplyEnvelope =
                EventFactory.<TextToAnnotateReplyEnvelope>fromXml(
                            IOUtils.toString(TextToAnnotateReplyTest.class.getResourceAsStream("/ALERT.KEUI.TextToAnnotate.Annotated.xml")),
                            TextToAnnotateReplyEnvelope.class);

        
        Assert.assertEquals(
                textToAnnotateReplyEnvelope
                .getBody()
                .getNotify()
                .getNotificationMessage()
                .getMessage()
                .getEvent()
                .getPayload()
                .getMeta()
                .getEventName(),
                Topics.ALERT_KEUI_TextToAnnotate_Annotated
        );

        TextToAnnotateReplyPayload.EventData eventData = textToAnnotateReplyEnvelope
                .getBody()
                .getNotify()
                .getNotificationMessage()
                .getMessage()
                .getEvent()
                .getPayload()
                .getEventData();

        Assert.assertEquals("qt amarok annotate me", eventData.getGeneralText().getText());
        Assert.assertEquals("stardom", eventData.getGeneralText().getSource());


        List<Keui.Concept> textConcepts = eventData.getKeui().getTextConcepts();
        Assert.assertNotNull(textConcepts);
        
        Assert.assertEquals(textConcepts.size(),2);

        Iterator<Keui.Concept> iterator = textConcepts.iterator();

        Keui.Concept next = iterator.next();
        Assert.assertEquals("http://ailab.ijs.si/alert/resource/r18285",next.getUri());
        Assert.assertEquals(1,next.getWeight(),0);

        next = iterator.next();
        Assert.assertEquals("http://ailab.ijs.si/alert/resource/r18288",next.getUri());
        Assert.assertEquals(3,next.getWeight(),0);

    }


}
