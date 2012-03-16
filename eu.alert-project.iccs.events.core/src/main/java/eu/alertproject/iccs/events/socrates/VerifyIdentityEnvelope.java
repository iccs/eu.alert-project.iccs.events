package eu.alertproject.iccs.events.socrates;

/**
 * User: fotis
 * Date: 24/02/12
 * Time: 13:28
 */

import com.thoughtworks.xstream.annotations.XStreamAlias;
import eu.alertproject.iccs.events.api.Head;
import eu.alertproject.iccs.events.api.ProducerReference;

import java.io.Serializable;

@XStreamAlias("s:Envelope")
public class VerifyIdentityEnvelope implements Serializable{

    @XStreamAlias("s:Header")
    private String header;

    @XStreamAlias("s:Body")
    private Body body;


    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }


    public static class Body implements Serializable{

        @XStreamAlias("wsnt:Notify")
        private Notify notify;


        public Notify getNotify() {
            return notify;
        }

        public void setNotify(Notify notify) {
            this.notify = notify;
        }

        public static class Notify implements Serializable {


            @XStreamAlias("wsnt:NotificationMessage")
            private NotificationMessage notificationMessage;

            public NotificationMessage getNotificationMessage() {
                return notificationMessage;
            }

            public void setNotificationMessage(NotificationMessage notificationMessage) {
                this.notificationMessage = notificationMessage;
            }



            public static class NotificationMessage implements Serializable{

                @XStreamAlias("wsnt:Topic")
                private String topic;

                @XStreamAlias("wsnt:ProducerReference")
                private ProducerReference producerReference;

                @XStreamAlias("wsnt:Message")
                private Message message;


                public String getTopic() {
                    return topic;
                }

                public void setTopic(String topic) {
                    this.topic = topic;
                }

                public ProducerReference getProducerReference() {
                    return producerReference;
                }

                public void setProducerReference(ProducerReference producerReference) {
                    this.producerReference = producerReference;
                }

                public Message getMessage() {
                    return message;
                }

                public void setMessage(Message message) {
                    this.message = message;
                }

                public static class Message implements Serializable{

                    @XStreamAlias("ns1:event")
                    private Event event;

                    public Event getEvent() {
                        return event;
                    }

                    public void setEvent(Event event) {
                        this.event = event;
                    }

                    public static class Event{

                        @XStreamAlias("ns1:head")
                        private Head head;

                        @XStreamAlias("ns1:payload")
                        private VerifyIdentityPayload payload;

                        public Head getHead() {
                            return head;
                        }

                        public void setHead(Head head) {
                            this.head = head;
                        }

                        public VerifyIdentityPayload getPayload() {
                            return payload;
                        }

                        public void setPayload(VerifyIdentityPayload payload) {
                            this.payload = payload;
                        }


                    }
                }
            }
        }



    }


}
