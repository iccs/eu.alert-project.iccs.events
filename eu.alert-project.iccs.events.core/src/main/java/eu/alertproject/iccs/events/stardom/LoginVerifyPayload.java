package eu.alertproject.iccs.events.stardom;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import eu.alertproject.iccs.events.api.Meta;
import eu.alertproject.iccs.events.socrates.Identity;
import eu.alertproject.iccs.events.socrates.Issue;

import java.io.Serializable;

/**
 * User: fotis
 * Date: 24/02/12
 * Time: 14:39
 */

public class LoginVerifyPayload {

    @XStreamAlias("ns1:meta")
    private Meta meta;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }


    @XStreamAlias("ns1:eventData")
    private EventData eventData;

    public EventData getEventData() {
        return eventData;
    }

    public void setEventData(EventData eventData) {
        this.eventData = eventData;
    }


    public static class EventData implements Serializable {

        @XStreamAlias("as:login")
        private Login login;

        public Login getLogin() {
            return login;
        }

        public void setLogin(Login login) {
            this.login = login;
        }

        public static class Login{

            @XStreamAlias("sc:identity")
            private Identity identity;
            
            @XStreamAlias("as:username")
            private String username;
            
            @XStreamAlias("as:email")
            private String email;

            public Identity getIdentity() {
                return identity;
            }

            public void setIdentity(Identity identity) {
                this.identity = identity;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }
        }

    }

}
