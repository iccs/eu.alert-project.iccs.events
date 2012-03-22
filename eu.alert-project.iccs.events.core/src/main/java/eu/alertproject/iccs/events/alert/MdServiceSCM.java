package eu.alertproject.iccs.events.alert;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * User: fotis
 * Date: 22/03/12
 * Time: 17:26
 */

public class MdServiceSCM {
    
    
    @XStreamAlias("o:commitUri")
    private String uri;
    
    @XStreamAlias("o:commitAuthorUri")
    private String authorUri;
    
    @XStreamAlias("o:commitCommitterUri")
    private String committerUri;
    
    @XStreamAlias("o:commitRepositoryUri")
    private String repositoryUri;
    
    @XStreamImplicit(itemFieldName = "o:commitFile")
    private List<File> files;


    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getAuthorUri() {
        return authorUri;
    }

    public void setAuthorUri(String authorUri) {
        this.authorUri = authorUri;
    }

    public String getCommitterUri() {
        return committerUri;
    }

    public void setCommitterUri(String committerUri) {
        this.committerUri = committerUri;
    }

    public String getRepositoryUri() {
        return repositoryUri;
    }

    public void setRepositoryUri(String repositoryUri) {
        this.repositoryUri = repositoryUri;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public static class File{

        @XStreamAlias("o:fileUri")
        private String uri;
        
        
        @XStreamImplicit(itemFieldName = "o:fileModules")
        private List<Module> modules;

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public List<Module> getModules() {
            return modules;
        }

        public void setModules(List<Module> modules) {
            this.modules = modules;
        }

        public static class Module{
            
            @XStreamAlias("o:moduleUri")
            private String uri;
            
            @XStreamImplicit(itemFieldName = "o:moduleMethods")
            private List<Method> methods;

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }

            public List<Method> getMethods() {
                return methods;
            }

            public void setMethods(List<Method> methods) {
                this.methods = methods;
            }

            public static class Method{

                @XStreamAlias("o:methodUri")
                private String uri;

                public String getUri() {
                    return uri;
                }

                public void setUri(String uri) {
                    this.uri = uri;
                }
            }
        }

    }
}
