package eu.alertproject.iccs.events.converters;

import com.thoughtworks.xstream.converters.basic.DateConverter;

/**
 *
 * Created an extension so that we can parse dates from the KESI
 * payload
 *
 *
 * User: fotis
 * Date: 24/02/12
 * Time: 16:01
 */
public class MailingListDateConverter extends DateConverter {

    public MailingListDateConverter() {
        super(
            "EEE, dd MMM yyyy HH:mm:ss Z",
            new String[] {
                    "EEE, d MMM yyyy HH:mm:ss Z",
                    "EEE, dd MMM yyyy HH:mm:ss Z",
            },true);
    }
}
