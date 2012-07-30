package eu.alertproject.iccs.events.api;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.ReaderWrapper;
import com.thoughtworks.xstream.io.xml.*;
import com.thoughtworks.xstream.mapper.CannotResolveClassException;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import eu.alertproject.iccs.events.alert.*;
import eu.alertproject.iccs.events.socrates.*;
import eu.alertproject.iccs.events.stardom.*;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: fotis
 * Date: 13/03/12
 * Time: 17:57
 */
public class EventFactory {

    private static String fixEvent(String str,boolean appendHeader,String ...namespaces){


        String namespacesStr = " "+StringUtils.join(namespaces," ")+" ";
        
        String namespace = 
                String.format(
                "<ns1:event " +
                    "xmlns:ns1=\"http://www.alert-project.eu/\" " +
                    "xmlns:o=\"http://www.alert-project.eu/ontoevents-mdservice\" " +
                "xmlns:r=\"http://www.alert-project.eu/rawevents-forum\" " +
                "xmlns:r1=\"http://www.alert-project.eu/rawevents-mailinglist\" " +
                "xmlns:r2=\"http://www.alert-project.eu/rawevents-wiki\" " +
                "xmlns:s=\"http://www.alert-project.eu/strevents-kesi\" " +
                "xmlns:sm=\"http://www.alert-project.eu/stardom\" " +
                "xmlns:s1=\"http://www.alert-project.eu/strevents-keui\" " +
                "xmlns:sc=\"http://www.alert-project.eu/socrates\" " +
                "xmlns:p=\"http://www.alert-project.eu/panteon\" " +
                "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" " +
                "xsi:schemaLocation=\"http://www.alert-project.eu/alert-root.xsd\"" +
                "%s>",namespacesStr);
        
        String eventStr = str.replace("<soap:Envelope>","<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:wsnt=\"http://docs.oasis-open.org/wsn/b-2\" xmlns:wsa=\"http://www.w3.org/2005/08/addressing\">");
        eventStr = eventStr.replace("<ns1:event>",namespace);

        if(appendHeader){
            eventStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+eventStr;
        }

        return eventStr;
    }

    private static String fixEvent(String str){
        return EventFactory.fixEvent(str, true);
    }
    
    private static XStream getMarshaller(Class<?> ...clazz){


        XStream x = new XStream(
                new XppDomDriver(){
                    @Override
                    public HierarchicalStreamReader createReader(Reader xml) {
                        return new ReaderWrapper(super.createReader(xml)){
                            @Override
                            public String getValue() {

                                String value = super.getValue();

                                value = value.replaceAll("[\\s\\n]+"," ");
                                value = value.trim();

                                return value;
                            }
                        };
                    }
                }
        ){
			protected MapperWrapper wrapMapper(MapperWrapper next) {
			        return new MapperWrapper(next) {
			            @SuppressWarnings("unchecked")
			            public boolean shouldSerializeMember(Class definedIn, String fieldName) {
			                try {
			                    return definedIn != Object.class || realClass(fieldName) != null;
			                } catch(CannotResolveClassException cnrce) {
			                    return false;
			                }
			            }
			        };
			    }
		};
        x.processAnnotations(clazz);

        return x;
    }

    
    @SuppressWarnings("unchecked")
    public static  <T>  T fromXml(String xml, Class<? extends T>...clazz){
        return (T) getMarshaller(clazz).fromXML(xml);
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
        Collections.addAll(identityList, identities);


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
        Collections.addAll(identityList, identities);


        StardomIdentityUpdatePayload.EventData se = new StardomIdentityUpdatePayload.EventData();
        se.setIdentities(identityList);

        Meta meta = new Meta();
        meta.setEventName(Topics.ALERT_STARDOM_Identity_Updated);
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
        notificationMessage.setTopic(Topics.ALERT_STARDOM_Identity_Updated);
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
            String patternId,
            List<IssueIdentities> identities) {

        Head head = new Head();
        head.setSender("SOCRATES");
        head.setTimestamp(start);
        head.setSequenceNumber(sequence);


        RecommendIssuesPayload.EventData se = new RecommendIssuesPayload.EventData();
        se.setIssueIdentities(identities);
        se.setPatternId(patternId);

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
            String patternId,
            boolean verified) {

        Head head = new Head();
        head.setSender("SOCRATES");
        head.setTimestamp(start);
        head.setSequenceNumber(sequence);


        VerifyIdentityPayload.EventData se = new VerifyIdentityPayload.EventData();
        
        se.setIdentity(identity);
        se.setIssue(issue);
        se.setRespone(verified ? "yes":"no");
        se.setPatternId(patternId);


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


    public static String createMlSensorMailNewEvent(
            Integer eventId,
            long start,
            long end,
            int sequence,
            MailingList mail) {

        Head head = new Head();
        head.setSender("MLSensor");
        head.setTimestamp(start);
        head.setSequenceNumber(sequence);


        MailingListNewPayload.EventData se = new MailingListNewPayload.EventData();

        //fix cdata
//        mail.setSubject("<[CDATA["+mail.getSubject()+"]]>");
//        mail.setContent("<[CDATA[" + mail.getContent() + "]]>");
//        mail.setInReplyTo("<[CDATA[" + mail.getInReplyTo() + "]]>");
//        mail.setReference("<[CDATA[" + mail.getReference() + "]]>");
//        mail.setMessageId("<[CDATA[" + mail.getMessageId() + "]]>");
//        mail.setContent("<[CDATA[" + mail.getContent() + "]]>");

        se.setMailingList(mail);


        Meta meta = new Meta();
        meta.setEventName(Topics.ALERT_MLSensor_Mail_New);
        meta.setStartTime(start);
        meta.setEndTime(end);
        meta.setEventId(eventId);
        meta.setType("Request");

        MailingListNewPayload payload = new MailingListNewPayload();
        payload.setMeta(meta);
        payload.setEventData(se);

        MailingListNewEnvelope.Body.Notify.NotificationMessage.Message.Event event = new MailingListNewEnvelope.Body.Notify.NotificationMessage.Message.Event();
        event.setHead(head);
        event.setPayload(payload);


        MailingListNewEnvelope.Body.Notify.NotificationMessage.Message message = new MailingListNewEnvelope.Body.Notify.NotificationMessage.Message();
        message.setEvent(event);

        ProducerReference producerReference = new ProducerReference();
        producerReference.setAddress("http://www.alert-project.eu/MLSensor");

        MailingListNewEnvelope.Body.Notify.NotificationMessage notificationMessage = new MailingListNewEnvelope.Body.Notify.NotificationMessage();
        notificationMessage.setTopic(Topics.ALERT_MLSensor_Mail_New);
        notificationMessage.setProducerReference(producerReference);
        notificationMessage.setMessage(message);

        MailingListNewEnvelope.Body.Notify notify = new MailingListNewEnvelope.Body.Notify();
        notify.setNotificationMessage(notificationMessage);

        MailingListNewEnvelope.Body body = new MailingListNewEnvelope.Body();
        body.setNotify(notify);

        MailingListNewEnvelope envelope = new MailingListNewEnvelope();
        envelope.setBody(body);
        envelope.setHeader("Header");

        XStream xstream = new XStream(

            new XppDomDriver() {
                public HierarchicalStreamWriter createWriter(Writer out) {
                    return new PrettyPrintWriter(out) {

                        boolean cdata = false;

                        //http://oktryitnow.com/?p=11
                        public void startNode(String name, Class clazz) {
                            super.startNode(name, clazz);
                            cdata = (
                                    ArrayUtils.contains(
                                            new String[]{
                                                "r1:subject",
                                                "r1:inReplyTo",
                                                "r1:references",
                                                "r1:messageId",
                                                "r1:content"
                                            },
                                            name
                                    ));

                        }

                        protected void writeText(QuickWriter writer, String text) {
                            if (cdata) {
                                writer.write("<![CDATA[");
                                writer.write(text);
                                writer.write("]]>");
                            } else {
                                writer.write(text);
                            }
                        }
                    };
                }
            }
        );
        xstream.processAnnotations(MailingListNewEnvelope.class);

        return EventFactory.fixEvent(xstream.toXML(envelope));

    }

    public static String createMlSensorForumNewEvent(
            Integer eventId,
            long start,
            long end,
            int sequence,
            MailingList mail) {

        Head head = new Head();
        head.setSender("MLSensor");
        head.setTimestamp(start);
        head.setSequenceNumber(sequence);


        MailingListNewPayload.EventData se = new MailingListNewPayload.EventData();

        //fix cdata
//        mail.setSubject("<[CDATA["+mail.getSubject()+"]]>");
//        mail.setContent("<[CDATA[" + mail.getContent() + "]]>");
//        mail.setInReplyTo("<[CDATA[" + mail.getInReplyTo() + "]]>");
//        mail.setReference("<[CDATA[" + mail.getReference() + "]]>");
//        mail.setMessageId("<[CDATA[" + mail.getMessageId() + "]]>");
//        mail.setContent("<[CDATA[" + mail.getContent() + "]]>");

        se.setMailingList(mail);


        Meta meta = new Meta();
        meta.setEventName(Topics.ALERT_MLSensor_Forum_Post_New);
        meta.setStartTime(start);
        meta.setEndTime(end);
        meta.setEventId(eventId);
        meta.setType("Request");

        MailingListNewPayload payload = new MailingListNewPayload();
        payload.setMeta(meta);
        payload.setEventData(se);

        MailingListNewEnvelope.Body.Notify.NotificationMessage.Message.Event event = new MailingListNewEnvelope.Body.Notify.NotificationMessage.Message.Event();
        event.setHead(head);
        event.setPayload(payload);


        MailingListNewEnvelope.Body.Notify.NotificationMessage.Message message = new MailingListNewEnvelope.Body.Notify.NotificationMessage.Message();
        message.setEvent(event);

        ProducerReference producerReference = new ProducerReference();
        producerReference.setAddress("http://www.alert-project.eu/MLSensor");

        MailingListNewEnvelope.Body.Notify.NotificationMessage notificationMessage = new MailingListNewEnvelope.Body.Notify.NotificationMessage();
        notificationMessage.setTopic(Topics.ALERT_MLSensor_Forum_Post_New);
        notificationMessage.setProducerReference(producerReference);
        notificationMessage.setMessage(message);

        MailingListNewEnvelope.Body.Notify notify = new MailingListNewEnvelope.Body.Notify();
        notify.setNotificationMessage(notificationMessage);

        MailingListNewEnvelope.Body body = new MailingListNewEnvelope.Body();
        body.setNotify(notify);

        MailingListNewEnvelope envelope = new MailingListNewEnvelope();
        envelope.setBody(body);
        envelope.setHeader("Header");

        XStream xstream = new XStream(

            new XppDomDriver() {
                public HierarchicalStreamWriter createWriter(Writer out) {
                    return new PrettyPrintWriter(out) {

                        boolean cdata = false;

                        //http://oktryitnow.com/?p=11
                        public void startNode(String name, Class clazz) {
                            super.startNode(name, clazz);
                            cdata = (
                                    ArrayUtils.contains(
                                            new String[]{
                                                "r1:subject",
                                                "r1:inReplyTo",
                                                "r1:references",
                                                "r1:messageId",
                                                "r1:content"
                                            },
                                            name
                                    ));

                        }

                        protected void writeText(QuickWriter writer, String text) {
                            if (cdata) {
                                writer.write("<![CDATA[");
                                writer.write(text);
                                writer.write("]]>");
                            } else {
                                writer.write(text);
                            }
                        }
                    };
                }
            }
        );
        xstream.processAnnotations(MailingListNewEnvelope.class);

        return EventFactory.fixEvent(xstream.toXML(envelope));

    }


    public static String createStardomLoginVerifyEnvelope(
            Integer eventId,
            long start,
            long end,
            int sequence,
            String username,
            String email,
            String uuid) {



        Head head = new Head();
        head.setSender("STARDOM");
        head.setTimestamp(start);
        head.setSequenceNumber(sequence);


        LoginVerifyPayload.EventData se = new LoginVerifyPayload.EventData();


        LoginVerifyPayload.EventData.Login login = new LoginVerifyPayload.EventData.Login();
        login.setEmail(email);
        login.setUsername(username);
        login.setIdentity(new Identity(uuid,null));

        
        se.setLogin(login);

        Meta meta = new Meta();
        meta.setEventName(Topics.ALERT_STARDOM_LoginVerify);
        meta.setStartTime(start);
        meta.setEndTime(end);
        meta.setEventId(eventId);
        meta.setType("Request");

        LoginVerifyPayload payload = new LoginVerifyPayload();
        payload.setMeta(meta);
        payload.setEventData(se);

        LoginVerifyEnvelope.Body.Notify.NotificationMessage.Message.Event event = new LoginVerifyEnvelope.Body.Notify.NotificationMessage.Message.Event();
        event.setHead(head);
        event.setPayload(payload);


        LoginVerifyEnvelope.Body.Notify.NotificationMessage.Message message = new LoginVerifyEnvelope.Body.Notify.NotificationMessage.Message();
        message.setEvent(event);

        ProducerReference producerReference = new ProducerReference();
        producerReference.setAddress("http://www.alert-project.eu/stardom");

        LoginVerifyEnvelope.Body.Notify.NotificationMessage notificationMessage = new LoginVerifyEnvelope.Body.Notify.NotificationMessage();
        notificationMessage.setTopic(Topics.ALERT_STARDOM_LoginVerify);
        notificationMessage.setProducerReference(producerReference);
        notificationMessage.setMessage(message);

        LoginVerifyEnvelope.Body.Notify notify = new LoginVerifyEnvelope.Body.Notify();
        notify.setNotificationMessage(notificationMessage);

        LoginVerifyEnvelope.Body body = new LoginVerifyEnvelope.Body();
        body.setNotify(notify);

        LoginVerifyEnvelope envelope = new LoginVerifyEnvelope();
        envelope.setBody(body);
        envelope.setHeader("Header");


        XStream x = new XStream();
        x.processAnnotations(LoginVerifyEnvelope.class);

        return EventFactory.fixEvent(
                x.toXML(envelope),
                true,
                "xmlns:as=\"http://www.alert-project.eu/actionservice\""
        );


    }
}
