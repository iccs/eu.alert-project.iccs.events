package eu.alertproject.iccs.events.activemq;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * User: fotis
 * Date: 22/04/12
 * Time: 00:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class IssueNewTest {

    @Autowired
    JmsTemplate jmsTemplate;

    @Test
    public void sendIssueUpdated() throws IOException {

        jmsTemplate.send(
                "ALERT.KESI.IssueNew",
                new TextMessageCreator(
                    IOUtils.toString(this.getClass().getResourceAsStream("/ALERT.KESI.IssueNew.Review.xml"))
                )
        );
    }
}
