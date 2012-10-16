package eu.alertproject.iccs.events.activemq;

import eu.alertproject.iccs.events.api.AbstractActiveMQHandler;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.commons.lang.StringUtils;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import javax.jms.ConnectionFactory;
import javax.jms.MessageListener;

/**
 * User: fotis
 * Date: 26/06/12
 * Time: 18:48
 */
public class ALERTDefaultMessageListenerContainer extends DefaultMessageListenerContainer {


    public ALERTDefaultMessageListenerContainer(
            String[] topic,
            MessageListener listener,
            ConnectionFactory jmsConnectionFactory,
            Integer recoveryInterval,
            Integer cacheLevel
    ) {

        super();
        this.setMessageListener(listener);
        this.setDestination(new ActiveMQTopic(StringUtils.join(topic,",")));
        this.setSubscriptionDurable(true);
        this.setDurableSubscriptionName(StringUtils.join(topic,","));

        this.setConnectionFactory(jmsConnectionFactory);
        this.setRecoveryInterval(recoveryInterval);
        this.setCacheLevel(cacheLevel);
    }


}
