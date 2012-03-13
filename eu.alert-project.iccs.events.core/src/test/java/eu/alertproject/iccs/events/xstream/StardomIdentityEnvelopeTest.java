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

        final String toSend = EventFactory.createStardomIdentityNew(
                1842532476,
                1331675010266L,
                1331675010274L,
                900866641,
                "46daed6d-19f4-49ac-822c-3903e31daa18",
                Arrays.asList(
                        "http://www.alert-project.eu/ontologies/alert_scm.owl#Person12",
                        "http://www.alert-project.eu/ontologies/alert_scm.owl#Person1"
                ),
                Arrays.asList(
                        "http://www.alert-project.eu/ontologies/alert_scm.owl#Person13",
                        "http://www.alert-project.eu/ontologies/alert_scm.owl#Person14"
                )
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

        Iterator<StardomIdentityNewPayload.EventData.Identity> iterator = identities.iterator();

        StardomIdentityNewPayload.EventData.Identity next = iterator.next();
        Assert.assertEquals("46daed6d-19f4-49ac-822c-3903e31daa18", next.getUuid());

        Iterator<String> isPersonsIterator = next.getPersons().getIs().getPersons().iterator();
        Assert.assertEquals("http://www.alert-project.eu/ontologies/alert_scm.owl#Person12",isPersonsIterator.next());
        Assert.assertEquals("http://www.alert-project.eu/ontologies/alert_scm.owl#Person1",isPersonsIterator.next());

        Iterator<String> isntPersonsIterator = next.getPersons().getIsnt().getPersons().iterator();
        Assert.assertEquals("http://www.alert-project.eu/ontologies/alert_scm.owl#Person13",isntPersonsIterator.next());
        Assert.assertEquals("http://www.alert-project.eu/ontologies/alert_scm.owl#Person14", isntPersonsIterator.next());

    }

    @Test
    public void testIdentityUpdated() throws ClassNotFoundException, IOException {

        IdentityPersons add = new IdentityPersons();
        add.setIsnt(new IdentityPersons.Persons("http://www.alert-project.eu/ontologies/alert_scm.owl#Person12"));

        IdentityPersons remove = new IdentityPersons();
        remove.setIs(new IdentityPersons.Persons("http://www.alert-project.eu/ontologies/alert_scm.owl#Person12"));

        StardomIdentityUpdatePayload.EventData.Identity identity = new StardomIdentityUpdatePayload.EventData.Identity();
        identity.setUuid("46daed6d-19f4-49ac-822c-3903e31daa18");
        identity.setAdd(add);
        identity.setRemove(remove);

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
