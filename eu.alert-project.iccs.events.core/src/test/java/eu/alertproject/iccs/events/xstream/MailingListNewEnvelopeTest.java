package eu.alertproject.iccs.events.xstream;

import eu.alertproject.iccs.events.alert.MailingList;
import eu.alertproject.iccs.events.api.EventFactory;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;

/**
 * User: fotis
 * Date: 25/03/12
 * Time: 23:01
 */
public class MailingListNewEnvelopeTest {
    @Test
    public void serialize() throws IOException, ParseException {


        MailingList ml = new MailingList();
        ml.setFrom("sasa.stojanovic@cimcollege.rs");
        ml.setDate(DateUtils.parseDate("Sat, 05 Nov 2011 17:50:11 +0100",
                new String[]{
                        "EEE, dd MMM yyyy HH:mm:ss Z"
                }));
        ml.setSubject("[Kde-hardware-devel] Identifying iPod and iPhone-like devices using Solid (was: Amarok review request)");
        ml.setInReplyTo("<CAMnMsSdoax0S14_fQe4woSLDhJYR0vc8wuZjKvsKqe7gVx1kxQ@mail.gmail.com>");
        ml.setReference("<20111025132029.15876.89012@vidsolbach.de><9102909.qJX79ctmp1@edgy><CAMnMsSdoax0S14_fQe4woSLDhJYR0vc8wuZjKvsKqe7gVx1kxQ@mail.gmail.com>");
        ml.setMessageId("<3674981.yjiqPb6iju@edgy>");
        ml.setAttachments(new
                MailingList.Attachments(
                "http://mail.kde.org/pipermail/kde-hardware-devel/attachments/20111109/564d5259/attachment.html"
        ));
        ml.setContent(IOUtils.toString(this.getClass().getResourceAsStream("/MailingListMessage.txt")));

        String s = EventFactory.createMlSensorMailNewEvent(
                5748,
                10000L,
                10010L,
                1,
                ml);


        Assert.assertEquals(
            s,
            IOUtils.toString(this.getClass().getResourceAsStream("/ALERT.MLSensor.MailNew.xml"))
        );

    }
}
