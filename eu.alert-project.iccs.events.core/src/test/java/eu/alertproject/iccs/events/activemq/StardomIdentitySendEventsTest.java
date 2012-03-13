package eu.alertproject.iccs.events.activemq;

import eu.alertproject.iccs.events.IdentityPersons;
import eu.alertproject.iccs.events.api.EventFactory;
import eu.alertproject.iccs.events.stardom.StardomIdentityUpdatePayload;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.IOException;
import java.util.Arrays;

/**
 * User: fotis
 * Date: 13/03/12
 * Time: 13:44
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class StardomIdentitySendEventsTest {


    private Logger logger = LoggerFactory.getLogger(StardomIdentitySendEventsTest.class);

    @Autowired
    JmsTemplate jmsTemplate;


    @Test
    public void testNewIdentity() throws ClassNotFoundException, IOException {

        final String toSend = EventFactory.createStardomIdentityNew(
                1842532476,
                1331675010274L,
                1331675010274L,
                900866641,
                "46daed6d-19f4-49ac-822c-3903e31daa18",
                Arrays.asList(
                        "http://www.alert-project.eu/ontologies/alert_scm.owl#Person12",
                        "http://www.alert-project.eu/ontologies/alert_scm.owl#Person1"
                ),
                null
        );


        jmsTemplate.send("ALERT.Stardom.IdentityNew",
                new MessageCreator() {
                    @Override
                    public Message createMessage(Session session) throws JMSException {
                        return session.createTextMessage(toSend);
                    }
                });

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

        jmsTemplate.send("ALERT.Stardom.IdentityNew",
                new MessageCreator() {
                    @Override
                    public Message createMessage(Session session) throws JMSException {
                        return session.createTextMessage(identityUpdate);
                    }
                });

    }
}
