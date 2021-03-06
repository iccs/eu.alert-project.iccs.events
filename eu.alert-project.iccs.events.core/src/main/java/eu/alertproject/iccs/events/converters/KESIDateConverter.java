package eu.alertproject.iccs.events.converters;

import com.thoughtworks.xstream.converters.basic.DateConverter;
import org.apache.commons.lang.StringUtils;

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
public class KESIDateConverter extends DateConverter {

    public KESIDateConverter() {
        super(
            "yyyy-MM-dd HH:mm:ss.S z",
            new String[] {
                "yyyy-MM-dd HH:mm:ssZ",
                "yyyy-MM-dd HH:mm:ss",
                "yyyy-MM-dd HH:mm:ss.S a",
                "yyyy-MM-dd HH:mm:ssz", "yyyy-MM-dd HH:mm:ss z", // JDK 1.3 needs both versions
                "yyyy-MM-dd HH:mm",
                "yyyy-MM-dd HH:mm:ssa" },  // backwards compatibility
                true);
    }

    @Override
    public Object fromString(String str) {
        if(StringUtils.isEmpty(str)){
            return null;
        }
        return super.fromString(str.replace("T"," "));    //To change body of overridden methods use File | Settings | File Templates.
    }
}
