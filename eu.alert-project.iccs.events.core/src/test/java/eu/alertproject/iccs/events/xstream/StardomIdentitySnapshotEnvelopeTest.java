package eu.alertproject.iccs.events.xstream;

import eu.alertproject.iccs.events.api.EventFactory;
import eu.alertproject.iccs.events.stardom.*;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * User: fotis
 * Date: 13/03/12
 * Time: 13:44
 */
public class StardomIdentitySnapshotEnvelopeTest {


    private Logger logger = LoggerFactory.getLogger(StardomIdentitySnapshotEnvelopeTest.class);



    @Test
    public void testSerializeIdentitySnapshot() throws ClassNotFoundException, IOException {

        logger.trace("void testSerializeIdentityNew() {} = {} ",new Date(), System.currentTimeMillis());


        IdentityPersons.Persons.Person p = new IdentityPersons.Persons.Person();
        p.setUri("http://www.alert-project.eu/ontologies/alert_scm.owl#Person1");


        IdentityPersons.Persons.Person p1 = new IdentityPersons.Persons.Person();
        p1.setUri("http://www.alert-project.eu/ontologies/alert_scm.owl#Person2");

        IdentityPersons.Persons.Person p2 = new IdentityPersons.Persons.Person();
        p2.setUri("http://www.alert-project.eu/ontologies/alert_scm.owl#Person3");


        StardomIdentitySnapshotPayload.EventData.Identity identity = new StardomIdentitySnapshotPayload.EventData.Identity();
        identity.setUuid("51d8ecec1d6ea40106c6c71ffed13547010870b0ab57fe396f5fbb124967e0eb");
        identity.setPersons(Arrays.asList(
                "http://www.alert-project.eu/ontologies/alert_scm.owl#Person1",
                "http://www.alert-project.eu/ontologies/alert_scm.owl#Person2",
                "http://www.alert-project.eu/ontologies/alert_scm.owl#Person3"));

        final String toSend = EventFactory.createStardomIdentitySnapshot(
                1842532476,
                1331675010266L,
                1331675010274L,
                900866641,
                identity);

        Assert.assertEquals(IOUtils.toString(this.getClass().getResourceAsStream("/ALERT.Stardom.IdentitySnapshot.xml")), toSend);

    }

    @Test
    public void testDeSerializeIdentityNew() throws ClassNotFoundException, IOException {

        StardomIdentitySnapshotEnvelope o =
                EventFactory.fromXml(
                        IOUtils.toString(this.getClass().getResourceAsStream("/ALERT.Stardom.IdentitySnapshot.xml")),
                        StardomIdentitySnapshotEnvelope.class
                );


        StardomIdentitySnapshotPayload.EventData.Identity identity = o.getBody()
                .getNotify()
                .getNotificationMessage()
                .getMessage()
                .getEvent()
                .getPayload()
                .getEventData()
                .getIdentity();

        Assert.assertNotNull(identity);

        Iterator<String> iterator = identity.getPersons().iterator();
        Assert.assertEquals("http://www.alert-project.eu/ontologies/alert_scm.owl#Person1", iterator.next());
        Assert.assertEquals("http://www.alert-project.eu/ontologies/alert_scm.owl#Person2", iterator.next());
        Assert.assertEquals("http://www.alert-project.eu/ontologies/alert_scm.owl#Person3", iterator.next());


    }


}
