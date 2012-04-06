package eu.alertproject.iccs.events.activemq;

import eu.alertproject.iccs.events.stardom.IdentityPersons;
import eu.alertproject.iccs.events.api.EventFactory;
import eu.alertproject.iccs.events.stardom.StardomIdentityNewPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

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
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:applicationContext.xml"})
public class StardomIdentitySendEventsTest {


    private Logger logger = LoggerFactory.getLogger(StardomIdentitySendEventsTest.class);

//    @Autowired
    JmsTemplate jmsTemplate;


//    @Test
    public void testNewIdentity() throws ClassNotFoundException, IOException {

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
                        Arrays.asList(p,p2),
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
        identity1.setPersons(new IdentityPersons(Arrays.asList(p3),null));



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
                identity,identity1,identity2);

        jmsTemplate.send("ALERT.Stardom.IdentityNew",
                new MessageCreator() {
                    @Override
                    public Message createMessage(Session session) throws JMSException {
                        return session.createTextMessage(toSend);
                    }
                });

    }

//    @Test
//    public void testIdentityUpdated() throws ClassNotFoundException, IOException {
//
//        IdentityPersons add = new IdentityPersons();
//        add.setIsnt(new IdentityPersons.Persons("http://www.alert-project.eu/ontologies/alert_scm.owl#Person12"));
//
//        IdentityPersons remove = new IdentityPersons();
//        remove.setIs(new IdentityPersons.Persons("http://www.alert-project.eu/ontologies/alert_scm.owl#Person12"));
//
//        StardomIdentityUpdatePayload.EventData.Identity identity = new StardomIdentityUpdatePayload.EventData.Identity();
//        identity.setUuid("46daed6d-19f4-49ac-822c-3903e31daa18");
//        identity.setAdd(add);
//        identity.setRemove(remove);
//
//        final  String identityUpdate = EventFactory.createStardomIdentityUpdate(
//                1697944231,
//                1331675854818L,
//                1331675854822L,
//                2063254152,
//                identity
//        );
//
//        jmsTemplate.send("ALERT.Stardom.IdentityNew",
//                new MessageCreator() {
//                    @Override
//                    public Message createMessage(Session session) throws JMSException {
//                        return session.createTextMessage(identityUpdate);
//                    }
//                });
//
//    }
}
