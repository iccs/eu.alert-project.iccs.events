package eu.alertproject.iccs.events.alert;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import eu.alertproject.iccs.events.converters.KESIDateConverter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * User: fotis
 * Date: 24/02/12
 * Time: 14:47
 */


public class KesiSCM implements Serializable {

    @XStreamAlias("s:commitRepositoryUri")
    private String repositoryUri;
    
    @XStreamAlias("s:commitRevisionTag")
    private String revisionTag;
    
    @XStreamAlias("s:commitAuthor")
    private Author author;
    
    @XStreamAlias("s:commitCommitter")
    private Author committer;
    
    @XStreamAlias("s:commitDate")
    @XStreamConverter(KESIDateConverter.class)
    private Date date;

    @XStreamAlias("s:commitMessageLog")
    private String messageLog;
    
    @XStreamImplicit(itemFieldName = "s:commitFile")
    private List<File> files;

    public String getRepositoryUri() {
        return repositoryUri;
    }

    public void setRepositoryUri(String repositoryUri) {
        this.repositoryUri = repositoryUri;
    }

    public String getRevisionTag() {
        return revisionTag;
    }

    public void setRevisionTag(String revisionTag) {
        this.revisionTag = revisionTag;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Author getCommitter() {
        return committer;
    }

    public void setCommitter(Author committer) {
        this.committer = committer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessageLog() {
        return messageLog;
    }

    public void setMessageLog(String messageLog) {
        this.messageLog = messageLog;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public static class File{

        @XStreamAlias("s:fileAction")
        private String action;

        @XStreamAlias("s:fileName")
        private String fileName;

        @XStreamAlias("s:fileBranch")
        private String branch;
        
        @XStreamImplicit(itemFieldName = "s:fileModules")
        private List<Module> modules;

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public String getBranch() {
            return branch;
        }

        public void setBranch(String branch) {
            this.branch = branch;
        }

        public List<Module> getModules() {
            return modules;
        }

        public void setModules(List<Module> modules) {
            this.modules = modules;
        }

        public static class Module{
            
            @XStreamAlias("s:moduleName")
            private String name;
            
            @XStreamAlias("s:moduleStartLine")
            private Integer startLine;
            
            @XStreamAlias("s:moduleEndLine")
            private Integer endLine;
            
            
            @XStreamImplicit(itemFieldName = "s:moduleMethods")
            private List<Methods> methods;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Integer getStartLine() {
                return startLine;
            }

            public void setStartLine(Integer startLine) {
                this.startLine = startLine;
            }

            public Integer getEndLine() {
                return endLine;
            }

            public void setEndLine(Integer endLine) {
                this.endLine = endLine;
            }

            public List<Methods> getMethods() {
                return methods;
            }

            public void setMethods(List<Methods> methods) {
                this.methods = methods;
            }

            public static class Methods{
                
                @XStreamAlias("s:methodName")
                private String name;
                
                @XStreamAlias("s:methodStartLine")
                private Integer startLine;
                
                @XStreamAlias("s:methodEndLine")
                private Integer endLine;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public Integer getStartLine() {
                    return startLine;
                }

                public void setStartLine(Integer startLine) {
                    this.startLine = startLine;
                }

                public Integer getEndLine() {
                    return endLine;
                }

                public void setEndLine(Integer endLine) {
                    this.endLine = endLine;
                }
            }
            
        }

    }

}
