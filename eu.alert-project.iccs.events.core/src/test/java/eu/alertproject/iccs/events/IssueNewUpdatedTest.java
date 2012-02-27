package eu.alertproject.iccs.events;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.QNameMap;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * User: fotis
 * Date: 24/02/12
 * Time: 13:53
 */

public class IssueNewUpdatedTest {

    private Logger logger = LoggerFactory.getLogger(IssueNewUpdatedTest.class);

    @Test
    public void testFromIssueNewUpdatedXml() throws IOException {

        XStream xstream = new XStream(new DomDriver());
        xstream.processAnnotations(Envelope.class);

        InputStream resourceAsStream = this.getClass().getResourceAsStream("/ALERT.Metadata.IssueNew.Updated.xml");


        Envelope o = (Envelope) xstream.fromXML(resourceAsStream);


        Assert.assertNotNull(o);

        Assert.assertEquals(o.getBody().getNotify().getNotificationMessage().getMessage().getEvent().getPayload().getEventData().getKesiEvent().getId(),184671,0);
        Assert.assertEquals(o.getBody().getNotify().getNotificationMessage().getMessage().getEvent().getPayload().getEventData().getKeuiEvent().getSubjectConcepts().get(0).getUri(),
                "http://www.alert-project.eu/ontologies/alert_its.owl#Bug1");


        logger.trace("void testIssueNewUpdated() {}",o);

    }


    @Test
    public void testToIssueNewUpdatedXml() throws ClassNotFoundException, IOException {


        QNameMap qmap = new QNameMap();
        qmap.setDefaultNamespace("http://www.w3.org/2003/05/soap-envelope");
        qmap.setDefaultPrefix("s");


        XStream xstream = new XStream(new StaxDriver(qmap));
        xstream.processAnnotations(Envelope.class);

        ObjectInputStream ois = new ObjectInputStream(
                this.getClass().getResourceAsStream("/ALERT.Metadata.IssueNew.Updated.xml.data")
        );

        Envelope e  = (Envelope) ois.readObject();


        String result = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+xstream.toXML(e);
        String expected = IOUtils.toString(this.getClass().getResourceAsStream("/ALERT.Metadata.IssueNew.Updated.xml")).replaceAll("[\\n,\\t]","");
        expected =expected.replaceAll(">\\s+<","><");


        logger.trace("void testToIssueNewUpdatedXml() {} ",expected);

        Assert.assertEquals(result, expected);


    }
}
