package eu.alertproject.iccs.events.activemq;

import eu.alertproject.iccs.events.IdentityPersons;
import eu.alertproject.iccs.events.api.EventFactory;
import eu.alertproject.iccs.events.api.Topics;
import eu.alertproject.iccs.events.stardom.StardomIdentityUpdatePayload;
import org.apache.commons.io.IOUtils;
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
public class RecommenderIdentityRecommendationSendEventsTest {


    private Logger logger = LoggerFactory.getLogger(RecommenderIdentityRecommendationSendEventsTest.class);

    @Autowired
    JmsTemplate jmsTemplate;


    @Test
    public void testNewIdentity() throws ClassNotFoundException, IOException {

        jmsTemplate.send(Topics.ALERT_SOCRATES_Identity_Recommendation,
                new MessageCreator() {
                    @Override
                    public Message createMessage(Session session) throws JMSException {
                        Message m = null;
                        try {
                            m = session.createTextMessage(IOUtils.toString(RecommenderIdentityRecommendationSendEventsTest.class.getResourceAsStream("/SampleRecommendIdentityReply.xml")));
                        } catch (IOException e) {
                            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                        }

                        return  m;
                    }
                });


    }

}
