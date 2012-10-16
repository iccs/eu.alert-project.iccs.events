package eu.alertproject.iccs.events.api;

import org.springframework.jms.core.MessageCreator;

/**
 * Created with IntelliJ IDEA.
 * User: fotis
 * Date: 10/11/12
 * Time: 3:48 PM
 */
public interface DataMessageCreator extends  MessageCreator {
    public String getRawData();
}
