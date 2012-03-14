package eu.alertproject.iccs.events.activemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * User: fotis
 * Date: 14/03/12
 * Time: 14:59
 */
public class TextMessageCreator implements MessageCreator {
    private Logger logger = LoggerFactory.getLogger(TextMessageCreator.class);

    private String message;

    public TextMessageCreator(String message) {

        this.message = message;
    }

    @Override
    public Message createMessage(Session session) throws JMSException {


        TextMessage textMessage = session.createTextMessage(message);

        logger.trace("Message createMessage() {} ",textMessage);

        return textMessage;
    }
}
