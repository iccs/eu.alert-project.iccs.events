package eu.alertproject.iccs.events;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.QNameMap;
import eu.alertproject.iccs.events.api.Head;
import eu.alertproject.iccs.events.api.Meta;
import eu.alertproject.iccs.events.api.ProducerReference;
import eu.alertproject.iccs.events.stardom.*;
import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: fotis
 * Date: 13/03/12
 * Time: 13:44
 * To change this template use File | Settings | File Templates.
 */
public class StardomIdentitySerializeTest {


    private Logger logger = LoggerFactory.getLogger(StardomIdentitySerializeTest.class);



    @Test
    public void testNewIdentity() throws ClassNotFoundException, IOException {


        Head head = new Head();
        head.setSender("STARDOM");
        head.setTimestamp(System.currentTimeMillis());
        head.setSequenceNumber(RandomUtils.nextInt());


        IdentityPersons  identityPersons = new IdentityPersons();
        identityPersons.setIs(new IdentityPersons.Persons(
                "http://www.alert-project.eu/ontologies/alert_scm.owl#Person12",
                "http://www.alert-project.eu/ontologies/alert_scm.owl#Person1"
        ));

        StardomIdentityNewPayload.StardomIdentityNewEvent.Identity identity = new StardomIdentityNewPayload.StardomIdentityNewEvent.Identity();
        identity.setUuid("46daed6d-19f4-49ac-822c-3903e31daa18");
        identity.setPersons(identityPersons);

        List<StardomIdentityNewPayload.StardomIdentityNewEvent.Identity> identities = new ArrayList<StardomIdentityNewPayload.StardomIdentityNewEvent.Identity>();
        identities.add(identity);

        StardomIdentityNewPayload.StardomIdentityNewEvent se = new StardomIdentityNewPayload.StardomIdentityNewEvent();
        se.setIdentities(identities);

        Meta meta = new Meta();
        meta.setEventName("ALERT.Stardom.IdentityNew");
        meta.setStartTime(System.currentTimeMillis());
        meta.setEndTime(System.currentTimeMillis());
        meta.setEventId(RandomUtils.nextInt());
        meta.setType("Request");


        StardomIdentityNewPayload payload = new StardomIdentityNewPayload();
        payload.setMeta(meta);
        payload.setEventData(se);

        StardomIdentityNewEnvelope.Body.Notify.NotificationMessage.Message.Event event = new StardomIdentityNewEnvelope.Body.Notify.NotificationMessage.Message.Event();
        event.setHead(head);
        event.setPayload(payload);


        StardomIdentityNewEnvelope.Body.Notify.NotificationMessage.Message message = new StardomIdentityNewEnvelope.Body.Notify.NotificationMessage.Message();
        message.setEvent(event);

        ProducerReference producerReference = new ProducerReference();
        producerReference.setAddress("http://www.alert-project.eu/stardom");

        StardomIdentityNewEnvelope.Body.Notify.NotificationMessage notificationMessage = new StardomIdentityNewEnvelope.Body.Notify.NotificationMessage();
        notificationMessage.setTopic("ALERT.Stardom.IdentityNew");
        notificationMessage.setProducerReference(producerReference);
        notificationMessage.setMessage(message);

        StardomIdentityNewEnvelope.Body.Notify notify = new StardomIdentityNewEnvelope.Body.Notify();
        notify.setNotificationMessage(notificationMessage);

        StardomIdentityNewEnvelope.Body body = new StardomIdentityNewEnvelope.Body();
        body.setNotify(notify);

        StardomIdentityNewEnvelope envelope = new StardomIdentityNewEnvelope();
        envelope.setBody(body);
        envelope.setHeader("Header");

        XStream xstream = new XStream();
        xstream.processAnnotations(StardomIdentityNewEnvelope.class);


        String eventStr = xstream.toXML(envelope);
        eventStr = eventStr.replace("<s:Envelope>","<s:Envelope xmlns:s=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:wsnt=\"http://docs.oasis-open.org/wsn/b-2\" xmlns:wsa=\"http://www.w3.org/2005/08/addressing\">");
        eventStr = eventStr.replace("<ns1:event>","<ns1:event xmlns:ns1=\"http://www.alert-project.eu/\"    xmlns:o=\"http://www.alert-project.eu/ontoevents-mdservice\" xmlns:r=\"http://www.alert-project.eu/rawevents-forum\" xmlns:r1=\"http://www.alert-project.eu/rawevents-mailinglist\" xmlns:r2=\"http://www.alert-project.eu/rawevents-wiki\" xmlns:s=\"http://www.alert-project.eu/strevents-kesi\" xmlns:sm=\"http://www.alert-project.eu/stardom\" xmlns:s1=\"http://www.alert-project.eu/strevents-keui\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.alert-project.eu/alert-root.xsd\">");

        String result = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+eventStr;

        logger.trace("void testToIssueNewUpdatedXml() {} ",result);

    }

    @Test
    public void testIdentityUpdated() throws ClassNotFoundException, IOException {


        QNameMap qmap = new QNameMap();
        qmap.setDefaultNamespace("http://www.w3.org/2003/05/soap-envelope");
        qmap.setDefaultPrefix("s");


        Head head = new Head();
        head.setSender("STARDOM");
        head.setTimestamp(System.currentTimeMillis());
        head.setSequenceNumber(RandomUtils.nextInt());

        IdentityPersons add = new IdentityPersons();
        add.setIsnt(new IdentityPersons.Persons("http://www.alert-project.eu/ontologies/alert_scm.owl#Person12"));

        IdentityPersons remove = new IdentityPersons();
        remove.setIs(new IdentityPersons.Persons("http://www.alert-project.eu/ontologies/alert_scm.owl#Person12"));

        StardomIdentityUpdatePayload.StardomIdentityUpdateEvent.Identity identity = new StardomIdentityUpdatePayload.StardomIdentityUpdateEvent.Identity();
        identity.setUuid("46daed6d-19f4-49ac-822c-3903e31daa18");
        identity.setAdd(add);
        identity.setRemove(remove);

        List<StardomIdentityUpdatePayload.StardomIdentityUpdateEvent.Identity> identities = new ArrayList<StardomIdentityUpdatePayload.StardomIdentityUpdateEvent.Identity>();
        identities.add(identity);

        StardomIdentityUpdatePayload.StardomIdentityUpdateEvent se = new StardomIdentityUpdatePayload.StardomIdentityUpdateEvent();
        se.setIdentities(identities);

        Meta meta = new Meta();
        meta.setEventName("ALERT.Stardom.IdentityUpdate");
        meta.setStartTime(System.currentTimeMillis());
        meta.setEndTime(System.currentTimeMillis());
        meta.setEventId(RandomUtils.nextInt());
        meta.setType("Request");


        StardomIdentityUpdatePayload payload = new StardomIdentityUpdatePayload();
        payload.setMeta(meta);
        payload.setEventData(se);

        StardomIdentityUpdatedEnvelope.Body.Notify.NotificationMessage.Message.Event event = new StardomIdentityUpdatedEnvelope.Body.Notify.NotificationMessage.Message.Event();
        event.setHead(head);
        event.setPayload(payload);


        StardomIdentityUpdatedEnvelope.Body.Notify.NotificationMessage.Message message = new StardomIdentityUpdatedEnvelope.Body.Notify.NotificationMessage.Message();
        message.setEvent(event);

        ProducerReference producerReference = new ProducerReference();
        producerReference.setAddress("http://www.alert-project.eu/stardom");

        StardomIdentityUpdatedEnvelope.Body.Notify.NotificationMessage notificationMessage = new StardomIdentityUpdatedEnvelope.Body.Notify.NotificationMessage();
        notificationMessage.setTopic("ALERT.Stardom.IdentityUpdate");
        notificationMessage.setProducerReference(producerReference);
        notificationMessage.setMessage(message);

        StardomIdentityUpdatedEnvelope.Body.Notify notify = new StardomIdentityUpdatedEnvelope.Body.Notify();
        notify.setNotificationMessage(notificationMessage);

        StardomIdentityUpdatedEnvelope.Body body = new StardomIdentityUpdatedEnvelope.Body();
        body.setNotify(notify);

        StardomIdentityUpdatedEnvelope envelope = new StardomIdentityUpdatedEnvelope();
        envelope.setBody(body);
        envelope.setHeader("Header");

        XStream xstream = new XStream();
        xstream.processAnnotations(StardomIdentityUpdatedEnvelope.class);


        String eventStr = xstream.toXML(envelope);
        eventStr = eventStr.replace("<s:Envelope>","<s:Envelope xmlns:s=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:wsnt=\"http://docs.oasis-open.org/wsn/b-2\" xmlns:wsa=\"http://www.w3.org/2005/08/addressing\">");
        eventStr = eventStr.replace("<ns1:event>","<ns1:event xmlns:ns1=\"http://www.alert-project.eu/\"    xmlns:o=\"http://www.alert-project.eu/ontoevents-mdservice\" xmlns:r=\"http://www.alert-project.eu/rawevents-forum\" xmlns:r1=\"http://www.alert-project.eu/rawevents-mailinglist\" xmlns:r2=\"http://www.alert-project.eu/rawevents-wiki\" xmlns:s=\"http://www.alert-project.eu/strevents-kesi\" xmlns:sm=\"http://www.alert-project.eu/stardom\" xmlns:s1=\"http://www.alert-project.eu/strevents-keui\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.alert-project.eu/alert-root.xsd\">");

        String result = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+eventStr;

        logger.trace("void testIdentityUpdated() {}",result);

    }
}
