package eu.alertproject.iccs.events.api;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: fotis
 * Date: 16/12/11
 * Time: 22:14
 */
public abstract class AbstractActiveMQHandler {

    public abstract void process(ActiveMQMessageBroker broker, Message message) throws IOException, JMSException;

}
