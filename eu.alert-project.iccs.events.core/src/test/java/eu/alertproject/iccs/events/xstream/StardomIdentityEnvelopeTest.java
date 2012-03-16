package eu.alertproject.iccs.events.xstream;

import com.thoughtworks.xstream.XStream;
import eu.alertproject.iccs.events.IdentityPersons;
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
 * Created by IntelliJ IDEA.
 * User: fotis
 * Date: 13/03/12
 * Time: 13:44
 * To change this template use File | Settings | File Templates.
 */
public class StardomIdentityEnvelopeTest {


    private Logger logger = LoggerFactory.getLogger(StardomIdentityEnvelopeTest.class);



    @Test
    public void testSerializeIdentityNew() throws ClassNotFoundException, IOException {

        logger.trace("void testSerializeIdentityNew() {} = {} ",new Date(), System.currentTimeMillis());

        IdentityPersons.Persons.Person p = new IdentityPersons.Persons.Person();
        p.setUri("http://www.alert-project.eu/ontologies/alert_scm.owl#Person1");
        p.setId("fotis@gmail.com");
        p.setFirstname("Fotis");
        p.setLastname("Paraskevopoulos");
        p.setEmail("fotis@gmail.com");
        p.setUsername("fotakis");

        IdentityPersons.Persons.Person p1 = new IdentityPersons.Persons.Person();
        p1.setUri("http://www.alert-project.eu/ontologies/alert_scm.owl#Person2");

        IdentityPersons.Persons.Person p2 = new IdentityPersons.Persons.Person();
        p2.setUri("http://www.alert-project.eu/ontologies/alert_scm.owl#Person3");

        StardomIdentityNewPayload.EventData.Identity identity = new StardomIdentityNewPayload.EventData.Identity();
        identity.setUuid("51d8ecec1d6ea40106c6c71ffed13547010870b0ab57fe396f5fbb124967e0eb");
        identity.setPersons(
                new IdentityPersons(
                        Arrays.asList(p,p1),
                        Arrays.asList(p2)
                )
        );

        IdentityPersons.Persons.Person p3 = new IdentityPersons.Persons.Person();
        p3.setFirstname("Sasa");
        p3.setLastname("Stojanovic");
        p3.setEmail("sasa.stojanovic@gmail.com");
        p3.setUsername("sasas");

        StardomIdentityNewPayload.EventData.Identity identity1 = new StardomIdentityNewPayload.EventData.Identity();
        identity1.setUuid("e0b2d72cdd7cc4c80a0a57f7462aece5341b228b139d6ccbfa093853b6a16b6b");
        identity1.setPersons(new IdentityPersons(null,Arrays.asList(p3)));



        IdentityPersons.Persons.Person p4 = new IdentityPersons.Persons.Person();
        p4.setUri("http://www.alert-project.eu/ontologies/alert_scm.owl#Person3");

        StardomIdentityNewPayload.EventData.Identity identity2 = new StardomIdentityNewPayload.EventData.Identity();
        identity2.setUuid("779c5c45ae3932a3fc92d36a3d33f106c99eeaba9e953689a47effdb683247eb");
        identity2.setPersons(new IdentityPersons(Arrays.asList(p4),null));
        
        final String toSend = EventFactory.createStardomIdentityNew(
                1842532476,
                1331675010266L,
                1331675010274L,
                900866641,
                identity
                ,identity1,identity2
        );

        Assert.assertEquals(IOUtils.toString(this.getClass().getResourceAsStream("/ALERT.Stardom.IdentityNew.xml")), toSend);

    }

    @Test
    public void testDeSerializeIdentityNew() throws ClassNotFoundException, IOException {

        XStream xStream = new XStream();
        xStream.processAnnotations(StardomIdentityNewEnvelope.class);

        StardomIdentityNewEnvelope o = (StardomIdentityNewEnvelope) xStream.fromXML(this.getClass().getResourceAsStream("/ALERT.Stardom.IdentityNew.xml"));


        List<StardomIdentityNewPayload.EventData.Identity> identities = o.getBody()
                .getNotify()
                .getNotificationMessage()
                .getMessage()
                .getEvent()
                .getPayload()
                .getEventData()
                .getIdentities();

        Assert.assertNotNull(identities);
        Assert.assertEquals(3,identities.size(),1);



        Iterator<StardomIdentityNewPayload.EventData.Identity> identityIterator1 = identities.iterator();
        StardomIdentityNewPayload.EventData.Identity next = identityIterator1.next();
        Assert.assertEquals("51d8ecec1d6ea40106c6c71ffed13547010870b0ab57fe396f5fbb124967e0eb", next.getUuid());

        Iterator<IdentityPersons.Persons.Person> isPersonIterator = next.getPersons().getIs().getPersons().iterator();
        IdentityPersons.Persons.Person next1 = isPersonIterator.next();
        Assert.assertEquals("http://www.alert-project.eu/ontologies/alert_scm.owl#Person1", next1.getUri());
        Assert.assertEquals("fotis@gmail.com", next1.getId());
        Assert.assertEquals("Fotis", next1.getFirstname());
        Assert.assertEquals("Paraskevopoulos", next1.getLastname());
        Assert.assertEquals("fotis@gmail.com", next1.getEmail());
        Assert.assertEquals("fotakis", next1.getUsername());

        IdentityPersons.Persons.Person next2 = isPersonIterator.next();
        Assert.assertEquals("http://www.alert-project.eu/ontologies/alert_scm.owl#Person2", next2.getUri());
        Assert.assertNull(next2.getId());
        Assert.assertNull(next2.getFirstname());
        Assert.assertNull(next2.getLastname());
        Assert.assertNull(next2.getEmail());
        Assert.assertNull(next2.getUsername());


        Iterator<IdentityPersons.Persons.Person> isntPersonIterator = next.getPersons().getIsnt().getPersons().iterator();
        IdentityPersons.Persons.Person next3 = isntPersonIterator.next();
        Assert.assertEquals("http://www.alert-project.eu/ontologies/alert_scm.owl#Person3", next3.getUri());
        Assert.assertNull(next3.getId());
        Assert.assertNull(next3.getFirstname());
        Assert.assertNull(next3.getLastname());
        Assert.assertNull(next3.getEmail());
        Assert.assertNull(next3.getUsername());

        StardomIdentityNewPayload.EventData.Identity identity2 = identityIterator1.next();
        Iterator<IdentityPersons.Persons.Person> isntPersonIterator2 = identity2.getPersons().getIsnt().getPersons().iterator();
        IdentityPersons.Persons.Person person21 = isntPersonIterator2.next();
        Assert.assertNull(person21.getUri());
        Assert.assertNull(person21.getId());
        Assert.assertEquals("Sasa", person21.getFirstname());
        Assert.assertEquals("Stojanovic", person21.getLastname());
        Assert.assertEquals("sasa.stojanovic@gmail.com", person21.getEmail());
        Assert.assertEquals("sasas", person21.getUsername());


        StardomIdentityNewPayload.EventData.Identity identity3 = identityIterator1.next();

        Iterator<IdentityPersons.Persons.Person> isPersonIterator3 = identity3.getPersons().getIs().getPersons().iterator();
        IdentityPersons.Persons.Person person31 = isPersonIterator3.next();
        Assert.assertEquals("http://www.alert-project.eu/ontologies/alert_scm.owl#Person3", person31.getUri());
        Assert.assertNull(person31.getId());
        Assert.assertNull(person31.getFirstname());
        Assert.assertNull(person31.getLastname());
        Assert.assertNull(person31.getEmail());
        Assert.assertNull(person31.getUsername());

    }

    @Test
    public void testIdentityUpdated() throws ClassNotFoundException, IOException {

        IdentityPersons.Persons.Person p = new IdentityPersons.Persons.Person();
        p.setUri("http://www.alert-project.eu/ontologies/alert_scm.owl#Person1");
        p.setId("fotis@gmail.com");
        p.setFirstname("Fotis");
        p.setLastname("Paraskevopoulos");
        p.setEmail("fotis@gmail.com");
        p.setUsername("fotakis");
        IdentityPersons.Persons.Person p1 = new IdentityPersons.Persons.Person();
        p1.setUri("http://www.alert-project.eu/ontologies/alert_scm.owl#Person2");

        IdentityPersons.Persons.Person p2 = new IdentityPersons.Persons.Person();
        p2.setUri("http://www.alert-project.eu/ontologies/alert_scm.owl#Person12");

        StardomIdentityUpdatePayload.EventData.Identity identity = new StardomIdentityUpdatePayload.EventData.Identity();
        identity.setUuid("51d8ecec1d6ea40106c6c71ffed13547010870b0ab57fe396f5fbb124967e0eb");
        identity.setAdd(
                new IdentityPersons(
                        Arrays.asList(p,p1),
                        Arrays.asList(p2)
                )
        );


        IdentityPersons.Persons.Person p3 = new IdentityPersons.Persons.Person();
        p3.setUri("http://www.alert-project.eu/ontologies/alert_scm.owl#Person12");

        identity.setRemove(new IdentityPersons(Arrays.asList(p3),null));

        final  String identityUpdate = EventFactory.createStardomIdentityUpdate(
                1697944231,
                1331675854818L,
                1331675854822L,
                2063254152,
                identity
        );

        Assert.assertEquals(IOUtils.toString(this.getClass().getResourceAsStream("/ALERT.Stardom.IdentityUpdated.xml")), identityUpdate);

    }
}
