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
public abstract class AbstractActiveMQListener implements MessageListener{

    private Logger logger = LoggerFactory.getLogger(AbstractActiveMQListener.class);


    private final long stared = System.currentTimeMillis();
    private AtomicInteger messageSent = new AtomicInteger(0);
    private AtomicInteger messageTotal = new AtomicInteger(0);

    private long start = System.currentTimeMillis();

    private boolean processDisabled= false;


    @Override
    public void onMessage(Message message) {

        logger.trace("void onMessage() {} ",message);

        if(!(message instanceof TextMessage)){

            logger.warn("I can't handle this message {} ",message);
            return;
        }


        //save
        //store the message
        try {


            String messageStr = ((TextMessage) message).getText();

            int messageCount = messageSent.get();
            if(StringUtils.isEmpty(messageStr)){
                logger.warn("Message {} was empty, not creating file ", messageCount);
                return;
            }

            float processSpeed = (messageTotal.get()/(System.currentTimeMillis()-start));
            String fileName = String.format("/tmp/iccs/%s-%s-%s.txt",
                    String.valueOf(stared),
                    this.getClass(),
                    messageCount);


            File file = new File("/tmp/iccs");
            if(!file.isDirectory()){
                file.mkdir();
            }


            IOUtils.write(messageStr, new FileOutputStream(new File(fileName)));
            logger.info("void process([message]) Speed {} o/s ({}) - file={} ",new Object[]{processSpeed,messageCount,fileName});

            int count = messageSent.incrementAndGet();

            if(!StringUtils.isEmpty(messageStr) && !processDisabled){
               logger.debug("Processing message {} ",count);
                process(message);
            }

        } catch (IOException e) {
            logger.warn("Couldn't handle and translate the message content {}",e);
        } catch (JMSException e) {
            logger.warn("Couldn't retrieve the message content {}", e);
        } finally {
            messageTotal.incrementAndGet();
        }
    }

    public abstract void process(Message message) throws IOException, JMSException;


    public boolean isProcessDisabled() {
        return processDisabled;
    }

    public void setProcessDisabled(boolean processDisabled) {
        this.processDisabled = processDisabled;
    }

    public Integer getMessageCount() {
        return messageTotal.get();
    }

    public Integer getMessageSentCount(){
        return messageSent.get();
    }



}
