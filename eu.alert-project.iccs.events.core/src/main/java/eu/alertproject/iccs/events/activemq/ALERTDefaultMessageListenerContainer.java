package eu.alertproject.iccs.events.activemq;

import eu.alertproject.iccs.events.api.AbstractActiveMQListener;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import javax.annotation.PostConstruct;
import javax.jms.ConnectionFactory;
import java.util.Properties;

/**
 * User: fotis
 * Date: 26/06/12
 * Time: 18:48
 */
public class ALERTDefaultMessageListenerContainer extends DefaultMessageListenerContainer {


    public ALERTDefaultMessageListenerContainer(
            String topic,
            AbstractActiveMQListener listener,
            ConnectionFactory jmsConnectionFactory,
            Integer recoveryInterval,
            Integer cacheLevel
    ) {

        super();
        this.setMessageListener(listener);
        this.setDestination(new ActiveMQTopic(topic));
        this.setSubscriptionDurable(true);
        this.setDurableSubscriptionName(topic);

        this.setConnectionFactory(jmsConnectionFactory);
        this.setRecoveryInterval(recoveryInterval);
        this.setCacheLevel(cacheLevel);
    }


}
