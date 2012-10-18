package eu.alertproject.iccs.events.api;


import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: fotis
 * Date: 10/18/12
 * Time: 4:07 PM
 */
public class ActiveMQMessageBrokerTest {

    @Test
    public void testTopicMatch(){

        ActiveMQMessageBroker activeMQMessageBroker = new ActiveMQMessageBroker();

        Map<String,AbstractActiveMQHandler> list = new HashMap<String, AbstractActiveMQHandler>();
        list.put(Topics.ALERT_ALL_SOCRATES_Identity_Recommendation_Request,null);
        list.put(Topics.ALERT_ALL_SOCRATES_Issue_Recommendation_Request,null);
        list.put(Topics.ALERT_ALL_SOCRATES_Identity_Verification_Request,null);
        list.put(Topics.ALERT_STARDOM_Identity_Snapshot,null);
        activeMQMessageBroker.setListenerMap(list);

        Assert.assertEquals(
                activeMQMessageBroker.isListeningFor(
                        "ALERT.AlertUI.Recommender.IdentitiesRecommendationRequest"
                ),Topics.ALERT_ALL_SOCRATES_Identity_Recommendation_Request);


        Assert.assertEquals(
                activeMQMessageBroker.isListeningFor(
                "ALERT.Search.Recommender.IssueRecommendationRequest"),
                Topics.ALERT_ALL_SOCRATES_Issue_Recommendation_Request
        );

        Assert.assertEquals(
                activeMQMessageBroker.isListeningFor(
                        Topics.ALERT_STARDOM_Identity_Snapshot
                    ),Topics.ALERT_STARDOM_Identity_Snapshot
                );

        Assert.assertNull(activeMQMessageBroker.isListeningFor("ALERT.*.KEUI"));


    }
}
