package eu.alertproject.iccs.events;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamContainedType;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: fotis
 * Date: 13/03/12
 * Time: 15:24
 * To change this template use File | Settings | File Templates.
 */
public class IdentityPersons {

    @XStreamAlias("sm:is")
    private Persons is;

    @XStreamAlias("sm:isnt")
    private Persons isnt;


    public Persons getIs() {
        return is;
    }

    public void setIs(Persons is) {
        this.is = is;
    }

    public Persons getIsnt() {
        return isnt;
    }

    public void setIsnt(Persons isnt) {
        this.isnt = isnt;
    }

    public static class Persons{
        @XStreamImplicit(itemFieldName = "o:person")
        private List<String> persons;

        public Persons(String ... persons) {
            this.persons = Arrays.asList(persons);
        }

        public List<String> getPersons() {
            return persons;
        }

        public void setPersons(List<String> persons) {
            this.persons = persons;
        }

    }
}
