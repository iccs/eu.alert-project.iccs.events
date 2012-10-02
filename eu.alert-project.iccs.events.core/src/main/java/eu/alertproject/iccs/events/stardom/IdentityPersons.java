package eu.alertproject.iccs.events.stardom;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: fotis
 * Date: 13/03/12
 * Time: 15:24
 */
public class IdentityPersons {

    @XStreamAlias("sm:is")
    private Persons is;

    @XStreamAlias("sm:isnt")
    private Persons isnt;

    public IdentityPersons() {
    }

    public IdentityPersons(List<Persons.Person> is, List<Persons.Person> isnt) {
        
        if(is != null && is.size() > 0){
            this.is = new Persons(is.toArray(new Persons.Person[is.size()]));
        }

        if(isnt !=null && isnt.size() > 0){
            this.isnt = new Persons(isnt.toArray(new Persons.Person[isnt.size()]));
        }
    }


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
        @XStreamImplicit(itemFieldName = "sm:person")
        private List<Person> persons;

        public Persons(Person ... persons) {
            this.persons = Arrays.asList(persons);
        }

        public List<Person> getPersons() {
            return persons;
        }

        public void setPersons(List<Person> persons) {
            this.persons = persons;
        }
        
        public static class Person{
            
            /*
            <sm:uri>
                http://www.alert-project.eu/ontologies/alert_scm.owl#Person1
            </sm:uri>
            <sm:id>fotis@gmail.com</sm:id>
            <sm:firsname>Fotis</sm:firsname>
            <sm:lastname>Paraskevopoulos</sm:lastname>
            <sm:email>fotis@gmail.com</sm:email>
            <sm:username>fotakis</sm:username>
             */

            @XStreamAlias("sm:uri")
            private String uri;

            @XStreamAlias("sm:id")
            private String id;

            @XStreamAlias("sm:firstname")
            private String firstname;

            @XStreamAlias("sm:lastname")
            private String lastname;

            @XStreamAlias("sm:email")
            private String email;

            @XStreamAlias("sm:username")
            private String username;

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getFirstname() {
                return firstname;
            }

            public void setFirstname(String firstname) {
                this.firstname = firstname;
            }

            public String getLastname() {
                return lastname;
            }

            public void setLastname(String lastname) {
                this.lastname = lastname;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }
        }

    }
}
