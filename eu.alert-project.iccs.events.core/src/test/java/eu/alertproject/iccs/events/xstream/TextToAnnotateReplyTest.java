package eu.alertproject.iccs.events.xstream;

import com.thoughtworks.xstream.XStream;
import eu.alertproject.iccs.events.api.Topics;
import eu.alertproject.iccs.events.jsi.TextToAnnotateReplyEnvelope;
import eu.alertproject.iccs.events.jsi.TextToAnnotateReplyPayload;
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

        XStream xStream = new XStream();
        xStream.processAnnotations(TextToAnnotateReplyEnvelope.class);

        TextToAnnotateReplyEnvelope textToAnnotateReplyEnvelope =
                (TextToAnnotateReplyEnvelope) xStream.fromXML(
                        IOUtils.toString(
                                TextToAnnotateReplyEnvelope.class.getResourceAsStream("/ALERT.KEUI.TextToAnnotate.Annotated.xml")));

        
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


        List<TextToAnnotateReplyPayload.EventData.Keui.Concept> textConcepts = eventData.getKeui().getTextConcepts();
        Assert.assertNotNull(textConcepts);
        
        Assert.assertEquals(textConcepts.size(),2);

        Iterator<TextToAnnotateReplyPayload.EventData.Keui.Concept> iterator = textConcepts.iterator();

        TextToAnnotateReplyPayload.EventData.Keui.Concept next = iterator.next();
        Assert.assertEquals("http://ailab.ijs.si/alert/resource/r18285",next.getUri());
        Assert.assertEquals(1,next.getWeight(),0);

        next = iterator.next();
        Assert.assertEquals("http://ailab.ijs.si/alert/resource/r18288",next.getUri());
        Assert.assertEquals(3,next.getWeight(),0);

    }


}
