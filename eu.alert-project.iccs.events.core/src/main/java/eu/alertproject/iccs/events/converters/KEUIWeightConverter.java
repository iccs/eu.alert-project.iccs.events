package eu.alertproject.iccs.events.converters;

import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import org.apache.commons.lang.StringUtils;

import javax.swing.text.StringContent;

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
public class KEUIWeightConverter extends AbstractSingleValueConverter{

    public KEUIWeightConverter() {

    }

    @Override
    public boolean canConvert(Class aClass) {
        return aClass.equals(Integer.class);  //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override
    public Object fromString(String str) {
        if(StringUtils.isEmpty(str)){
            return 0;
        }

        if(str.matches("0?,\\d+")){
            return 1;
        }

        return Integer.valueOf(str);
    }
}
