package eu.alertproject.iccs.events;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.QNameMap;
import eu.alertproject.iccs.events.api.EventFactory;
import eu.alertproject.iccs.events.api.Head;
import eu.alertproject.iccs.events.api.Meta;
import eu.alertproject.iccs.events.api.ProducerReference;
import eu.alertproject.iccs.events.stardom.StardomIdentityNewEnvelope;
import eu.alertproject.iccs.events.stardom.StardomIdentityNewPayload;
import eu.alertproject.iccs.events.stardom.StardomIdentityUpdatePayload;
import eu.alertproject.iccs.events.stardom.StardomIdentityUpdatedEnvelope;
import org.apache.commons.lang.math.RandomUtils;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: fotis
 * Date: 13/03/12
 * Time: 13:44
 * To change this template use File | Settings | File Templates.
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

        StardomIdentityUpdatePayload.StardomIdentityUpdateEvent.Identity identity = new StardomIdentityUpdatePayload.StardomIdentityUpdateEvent.Identity();
        identity.setUuid("46daed6d-19f4-49ac-822c-3903e31daa18");
        identity.setAdd(add);
        identity.setRemove(remove);

        final  String identityUpdate = EventFactory.createStardomIdentityUpdate(identity);

        jmsTemplate.send("ALERT.Stardom.IdentityNew",
                new MessageCreator() {
                    @Override
                    public Message createMessage(Session session) throws JMSException {
                        return session.createTextMessage(identityUpdate);
                    }
                });

    }
}
