package eu.alertproject.iccs.events.api;

import com.thoughtworks.xstream.XStream;
import eu.alertproject.iccs.events.IdentityPersons;
import eu.alertproject.iccs.events.stardom.StardomIdentityNewEnvelope;
import eu.alertproject.iccs.events.stardom.StardomIdentityNewPayload;
import eu.alertproject.iccs.events.stardom.StardomIdentityUpdatePayload;
import eu.alertproject.iccs.events.stardom.StardomIdentityUpdatedEnvelope;
import org.apache.commons.lang.math.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: fotis
 * Date: 13/03/12
 * Time: 17:57
 * To change this template use File | Settings | File Templates.
 */
public class EventFactory {

    private static String fixEvent(String str,boolean appendHeader){
        
        String eventStr = str.replace("<s:Envelope>","<s:Envelope xmlns:s=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:wsnt=\"http://docs.oasis-open.org/wsn/b-2\" xmlns:wsa=\"http://www.w3.org/2005/08/addressing\">");
        eventStr = eventStr.replace("<ns1:event>","<ns1:event xmlns:ns1=\"http://www.alert-project.eu/\"    xmlns:o=\"http://www.alert-project.eu/ontoevents-mdservice\" xmlns:r=\"http://www.alert-project.eu/rawevents-forum\" xmlns:r1=\"http://www.alert-project.eu/rawevents-mailinglist\" xmlns:r2=\"http://www.alert-project.eu/rawevents-wiki\" xmlns:s=\"http://www.alert-project.eu/strevents-kesi\" xmlns:sm=\"http://www.alert-project.eu/stardom\" xmlns:s1=\"http://www.alert-project.eu/strevents-keui\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.alert-project.eu/alert-root.xsd\">");

        if(appendHeader){
            eventStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+eventStr;
        }

        return eventStr;
    }

    private static String fixEvent(String str){
        return EventFactory.fixEvent(str, true);
    }


    public static String createStardomIdentityNew(String uuid, List<String> isPersons, List<String> isNotPersons){
        Head head = new Head();
        head.setSender("STARDOM");
        head.setTimestamp(System.currentTimeMillis());
        head.setSequenceNumber(RandomUtils.nextInt());

        StardomIdentityNewPayload.StardomIdentityNewEvent.Identity identity = new StardomIdentityNewPayload.StardomIdentityNewEvent.Identity();
        identity.setUuid(uuid);

        IdentityPersons identityPersons = new IdentityPersons();

        if(isPersons !=null && isPersons.size() > 0){
            identityPersons.setIs(new IdentityPersons.Persons(isPersons.toArray(new String[isPersons.size()])));
        }

        if(isNotPersons !=null && isNotPersons.size() > 0){
            identityPersons.setIsnt(new IdentityPersons.Persons(isNotPersons.toArray(new String[isNotPersons.size()])));
        }

        identity.setPersons(identityPersons);


        List<StardomIdentityNewPayload.StardomIdentityNewEvent.Identity> identities = new ArrayList<StardomIdentityNewPayload.StardomIdentityNewEvent.Identity>();
        identities.add(identity);

        StardomIdentityNewPayload.StardomIdentityNewEvent se = new StardomIdentityNewPayload.StardomIdentityNewEvent();
        se.setIdentities(identities);

        Meta meta = new Meta();
        meta.setEventName(Topics.ALERT_STARDOM_New_Identity);
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
        notificationMessage.setTopic(Topics.ALERT_STARDOM_New_Identity);
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

        return EventFactory.fixEvent(xstream.toXML(envelope));

    }

    public static String createStardomIdentityUpdate(
            StardomIdentityUpdatePayload.StardomIdentityUpdateEvent.Identity ... identities
    ){


        Head head = new Head();
        head.setSender("STARDOM");
        head.setTimestamp(System.currentTimeMillis());
        head.setSequenceNumber(RandomUtils.nextInt());


        StardomIdentityUpdatePayload.StardomIdentityUpdateEvent se = new StardomIdentityUpdatePayload.StardomIdentityUpdateEvent();
        se.setIdentities(Arrays.asList(identities));

        Meta meta = new Meta();
        meta.setEventName(Topics.ALERT_STARDOM_Issue_Updated);
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
        notificationMessage.setTopic(Topics.ALERT_STARDOM_Issue_Updated);
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

        return EventFactory.fixEvent(xstream.toXML(envelope));

    }
}
