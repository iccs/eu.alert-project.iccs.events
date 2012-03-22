package eu.alertproject.iccs.events.api;

import com.thoughtworks.xstream.XStream;
import eu.alertproject.iccs.events.alert.TextToAnnotateRequestEnvelope;
import eu.alertproject.iccs.events.alert.TextToAnnotateRequestPayload;
import eu.alertproject.iccs.events.socrates.*;
import eu.alertproject.iccs.events.stardom.StardomIdentityNewEnvelope;
import eu.alertproject.iccs.events.stardom.StardomIdentityNewPayload;
import eu.alertproject.iccs.events.stardom.StardomIdentityUpdatePayload;
import eu.alertproject.iccs.events.stardom.StardomIdentityUpdatedEnvelope;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: fotis
 * Date: 13/03/12
 * Time: 17:57
 */
public class EventFactory {

    private static String fixEvent(String str,boolean appendHeader){
        
        String eventStr = str.replace("<s:Envelope>","<s:Envelope xmlns:s=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:wsnt=\"http://docs.oasis-open.org/wsn/b-2\" xmlns:wsa=\"http://www.w3.org/2005/08/addressing\">");
        eventStr = eventStr.replace("<ns1:event>","<ns1:event xmlns:ns1=\"http://www.alert-project.eu/\" xmlns:o=\"http://www.alert-project.eu/ontoevents-mdservice\" xmlns:r=\"http://www.alert-project.eu/rawevents-forum\" xmlns:r1=\"http://www.alert-project.eu/rawevents-mailinglist\" xmlns:r2=\"http://www.alert-project.eu/rawevents-wiki\" xmlns:s=\"http://www.alert-project.eu/strevents-kesi\" xmlns:sm=\"http://www.alert-project.eu/stardom\" xmlns:s1=\"http://www.alert-project.eu/strevents-keui\" xmlns:sc=\"http://www.alert-project.eu/socrates\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.alert-project.eu/alert-root.xsd\">");

        if(appendHeader){
            eventStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+eventStr;
        }

        return eventStr;
    }

    private static String fixEvent(String str){
        return EventFactory.fixEvent(str, true);
    }


    public static String createStardomIdentityNew(Integer eventId,
                                                  long start,
                                                  long end,
                                                  int sequence,
                                                  StardomIdentityNewPayload.EventData.Identity ... identities){
        Head head = new Head();
        head.setSender("STARDOM");
        head.setTimestamp(start);
        head.setSequenceNumber(sequence);

        List<StardomIdentityNewPayload.EventData.Identity> identityList = new ArrayList<StardomIdentityNewPayload.EventData.Identity>();
        Collections.addAll(identityList,identities);


        StardomIdentityNewPayload.EventData se = new StardomIdentityNewPayload.EventData();
        se.setIdentities(identityList);

        Meta meta = new Meta();
        meta.setEventName(Topics.ALERT_STARDOM_New_Identity);
        meta.setStartTime(start);
        meta.setEndTime(end);
        meta.setEventId(eventId);
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
            Integer eventId, long start,long end, int sequence,
            StardomIdentityUpdatePayload.EventData.Identity ... identities
    ){


        Head head = new Head();
        head.setSender("STARDOM");
        head.setTimestamp(start);
        head.setSequenceNumber(sequence);


        List<StardomIdentityUpdatePayload.EventData.Identity> identityList = new ArrayList<StardomIdentityUpdatePayload.EventData.Identity>();
        Collections.addAll(identityList,identities);


        StardomIdentityUpdatePayload.EventData se = new StardomIdentityUpdatePayload.EventData();
        se.setIdentities(identityList);

        Meta meta = new Meta();
        meta.setEventName(Topics.ALERT_STARDOM_Issue_Updated);
        meta.setStartTime(start);
        meta.setEndTime(end);
        meta.setEventId(eventId);
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

    public static String createRecommendationIssuesEvent(
            Integer eventId, long start,long end, int sequence,
            List<Issue> issues) {

        Head head = new Head();
        head.setSender("SOCRATES");
        head.setTimestamp(start);
        head.setSequenceNumber(sequence);


        RecommendIdentityPayload.EventData se = new RecommendIdentityPayload.EventData();
        se.setIssues(issues);

        Meta meta = new Meta();
        meta.setEventName(Topics.ALERT_SOCRATES_Issue_Recommendation);
        meta.setStartTime(start);
        meta.setEndTime(end);
        meta.setEventId(eventId);
        meta.setType("Reply");

        RecommendIdentityPayload payload = new RecommendIdentityPayload();
        payload.setMeta(meta);
        payload.setEventData(se);

        RecommendIdentityEnvelope.Body.Notify.NotificationMessage.Message.Event event = new RecommendIdentityEnvelope.Body.Notify.NotificationMessage.Message.Event();
        event.setHead(head);
        event.setPayload(payload);


        RecommendIdentityEnvelope.Body.Notify.NotificationMessage.Message message = new RecommendIdentityEnvelope.Body.Notify.NotificationMessage.Message();
        message.setEvent(event);

        ProducerReference producerReference = new ProducerReference();
        producerReference.setAddress("http://www.alert-project.eu/socrates");

        RecommendIdentityEnvelope.Body.Notify.NotificationMessage notificationMessage = new RecommendIdentityEnvelope.Body.Notify.NotificationMessage();
        notificationMessage.setTopic(Topics.ALERT_SOCRATES_Issue_Recommendation);
        notificationMessage.setProducerReference(producerReference);
        notificationMessage.setMessage(message);

        RecommendIdentityEnvelope.Body.Notify notify = new RecommendIdentityEnvelope.Body.Notify();
        notify.setNotificationMessage(notificationMessage);

        RecommendIdentityEnvelope.Body body = new RecommendIdentityEnvelope.Body();
        body.setNotify(notify);

        RecommendIdentityEnvelope envelope = new RecommendIdentityEnvelope();
        envelope.setBody(body);
        envelope.setHeader("Header");

        XStream xstream = new XStream();
        xstream.processAnnotations(RecommendIdentityEnvelope.class);

        return EventFactory.fixEvent(xstream.toXML(envelope));


    }

    public static String createRecommendationIdentityEvent(
            Integer eventId, long start,long end, int sequence,
            List<Identity> identities) {

        Head head = new Head();
        head.setSender("SOCRATES");
        head.setTimestamp(start);
        head.setSequenceNumber(sequence);


        RecommendIssuesPayload.EventData se = new RecommendIssuesPayload.EventData();
        se.setIdentities(identities);

        Meta meta = new Meta();
        meta.setEventName(Topics.ALERT_SOCRATES_Identity_Recommendation);
        meta.setStartTime(start);
        meta.setEndTime(end);
        meta.setEventId(eventId);
        meta.setType("Reply");

        RecommendIssuesPayload payload = new RecommendIssuesPayload();
        payload.setMeta(meta);
        payload.setEventData(se);

        RecommendIssuesEnvelope.Body.Notify.NotificationMessage.Message.Event event = new RecommendIssuesEnvelope.Body.Notify.NotificationMessage.Message.Event();
        event.setHead(head);
        event.setPayload(payload);


        RecommendIssuesEnvelope.Body.Notify.NotificationMessage.Message message = new RecommendIssuesEnvelope.Body.Notify.NotificationMessage.Message();
        message.setEvent(event);

        ProducerReference producerReference = new ProducerReference();
        producerReference.setAddress("http://www.alert-project.eu/socrates");

        RecommendIssuesEnvelope.Body.Notify.NotificationMessage notificationMessage = new RecommendIssuesEnvelope.Body.Notify.NotificationMessage();
        notificationMessage.setTopic(Topics.ALERT_SOCRATES_Identity_Recommendation);
        notificationMessage.setProducerReference(producerReference);
        notificationMessage.setMessage(message);

        RecommendIssuesEnvelope.Body.Notify notify = new RecommendIssuesEnvelope.Body.Notify();
        notify.setNotificationMessage(notificationMessage);

        RecommendIssuesEnvelope.Body body = new RecommendIssuesEnvelope.Body();
        body.setNotify(notify);

        RecommendIssuesEnvelope envelope = new RecommendIssuesEnvelope();
        envelope.setBody(body);
        envelope.setHeader("Header");

        XStream xstream = new XStream();
        xstream.processAnnotations(RecommendIssuesEnvelope.class);

        return EventFactory.fixEvent(xstream.toXML(envelope));


    }

    public static String createTextToAnnotateRequestEvent(
            Integer eventId, long start,long end, int sequence,
            String text) {

        Head head = new Head();
        head.setSender("STARDOM");
        head.setTimestamp(start);
        head.setSequenceNumber(sequence);


        TextToAnnotateRequestPayload.EventData.GeneralText ge = new TextToAnnotateRequestPayload.EventData.GeneralText();

        ge.setSource("stardom");
        ge.setText(text);

        TextToAnnotateRequestPayload.EventData se = new TextToAnnotateRequestPayload.EventData();

        se.setGeneralText(ge);

        Meta meta = new Meta();
        meta.setEventName(Topics.ALERT_STARDOM_TextToAnnotate);
        meta.setStartTime(start);
        meta.setEndTime(end);
        meta.setEventId(eventId);
        meta.setType("Request");
        
        TextToAnnotateRequestPayload payload = new TextToAnnotateRequestPayload();
        payload.setMeta(meta);
        payload.setEventData(se);

        TextToAnnotateRequestEnvelope.Body.Notify.NotificationMessage.Message.Event event = new TextToAnnotateRequestEnvelope.Body.Notify.NotificationMessage.Message.Event();
        event.setHead(head);
        event.setPayload(payload);
        
        
        TextToAnnotateRequestEnvelope.Body.Notify.NotificationMessage.Message message = new TextToAnnotateRequestEnvelope.Body.Notify.NotificationMessage.Message();
        message.setEvent(event);

        ProducerReference producerReference = new ProducerReference();
        producerReference.setAddress("http://www.alert-project.eu/stardom");
        
        TextToAnnotateRequestEnvelope.Body.Notify.NotificationMessage notificationMessage = new TextToAnnotateRequestEnvelope.Body.Notify.NotificationMessage();
        notificationMessage.setTopic(Topics.ALERT_STARDOM_TextToAnnotate);
        notificationMessage.setProducerReference(producerReference);
        notificationMessage.setMessage(message);
        
        TextToAnnotateRequestEnvelope.Body.Notify notify = new TextToAnnotateRequestEnvelope.Body.Notify();
        notify.setNotificationMessage(notificationMessage);
        
        TextToAnnotateRequestEnvelope.Body body = new TextToAnnotateRequestEnvelope.Body();
        body.setNotify(notify);
        
        TextToAnnotateRequestEnvelope envelope = new TextToAnnotateRequestEnvelope();
        envelope.setBody(body);
        envelope.setHeader("Header");

        XStream xstream = new XStream();
        xstream.processAnnotations(TextToAnnotateRequestEnvelope.class);

        return EventFactory.fixEvent(xstream.toXML(envelope));


    }
    
    
    public static String createVerifyIdentityEvent(
            Integer eventId, 
            long start,
            long end, 
            int sequence,
            Identity identity,
            Issue issue,
            boolean verified) {

        Head head = new Head();
        head.setSender("SOCRATES");
        head.setTimestamp(start);
        head.setSequenceNumber(sequence);


        VerifyIdentityPayload.EventData se = new VerifyIdentityPayload.EventData();
        
        se.setIdentity(identity);
        se.setIssue(issue);
        se.setRespone(verified ? "yes":"no");


        Meta meta = new Meta();
        meta.setEventName(Topics.ALERT_SOCRATES_Identity_Verification);
        meta.setStartTime(start);
        meta.setEndTime(end);
        meta.setEventId(eventId);
        meta.setType("Reply");
        
        VerifyIdentityPayload payload = new VerifyIdentityPayload();
        payload.setMeta(meta);
        payload.setEventData(se);

        VerifyIdentityEnvelope.Body.Notify.NotificationMessage.Message.Event event = new VerifyIdentityEnvelope.Body.Notify.NotificationMessage.Message.Event();
        event.setHead(head);
        event.setPayload(payload);
        
        
        VerifyIdentityEnvelope.Body.Notify.NotificationMessage.Message message = new VerifyIdentityEnvelope.Body.Notify.NotificationMessage.Message();
        message.setEvent(event);

        ProducerReference producerReference = new ProducerReference();
        producerReference.setAddress("http://www.alert-project.eu/stardom");
        
        VerifyIdentityEnvelope.Body.Notify.NotificationMessage notificationMessage = new VerifyIdentityEnvelope.Body.Notify.NotificationMessage();
        notificationMessage.setTopic(Topics.ALERT_SOCRATES_Identity_Verification);
        notificationMessage.setProducerReference(producerReference);
        notificationMessage.setMessage(message);
        
        VerifyIdentityEnvelope.Body.Notify notify = new VerifyIdentityEnvelope.Body.Notify();
        notify.setNotificationMessage(notificationMessage);
        
        VerifyIdentityEnvelope.Body body = new VerifyIdentityEnvelope.Body();
        body.setNotify(notify);
        
        VerifyIdentityEnvelope envelope = new VerifyIdentityEnvelope();
        envelope.setBody(body);
        envelope.setHeader("Header");

        XStream xstream = new XStream();
        xstream.processAnnotations(VerifyIdentityEnvelope.class);

        return EventFactory.fixEvent(xstream.toXML(envelope));


    }
}
