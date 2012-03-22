package eu.alertproject.iccs.events.xstream;

import com.thoughtworks.xstream.XStream;
import eu.alertproject.iccs.events.alert.*;
import eu.alertproject.iccs.events.socrates.RecommendIdentityEnvelope;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * User: fotis
 * Date: 22/03/12
 * Time: 18:20
 */
public class CommitNewAnnotatedEnvelopeTest {
    
    @Test
    public void desirialize() throws IOException {
        
        XStream xstream = new XStream();
        xstream.processAnnotations(CommitNewAnnotatedEnvelope.class);

        String s = IOUtils.toString(RecommendIdentitiesRequestEnvelopeTest.class.getResourceAsStream("/ALERT.KEUI.CommitNew.Annotated.xml"));

        CommitNewAnnotatedEnvelope o = (CommitNewAnnotatedEnvelope) xstream.fromXML(s);


        CommitNewAnnotatedPayload.EventData eventData = o.getBody()
                .getNotify()
                .getNotificationMessage()
                .getMessage()
                .getEvent()
                .getPayload()
                .getEventData();


        assertKesi(eventData.getKesi());

        assertMdService(eventData.getMdService());

        assertKeui(eventData.getKeui());

    }

    private void assertKeui(Keui keui) {
        
        Assert.assertEquals(
            "<concept id=\"http://ailab.ijs.si/alert/resource/r9475\">comment</concept> of <concept id=\"http://ailab.ijs.si/alert/resource/r18367\">commit</concept>",
            keui.getCommitMessageLogAnnotated().trim()
        );

        List<Keui.Concept> commitMessageLogConcepts = keui.getCommitMessageLogConcepts();
        Assert.assertEquals(2,commitMessageLogConcepts.size(),0);

        Iterator<Keui.Concept> iterator = commitMessageLogConcepts.iterator();

        Keui.Concept next = iterator.next();
        Assert.assertEquals(
                "http://ailab.ijs.si/alert/resource/r9475",
                next.getUri()
                );

        Assert.assertEquals(1,next.getWeight(),0);

        Keui.Concept next1 = iterator.next();
        Assert.assertEquals(
                "http://ailab.ijs.si/alert/resource/r18367",
                next1.getUri()
                );

        Assert.assertEquals(1,next1.getWeight(),0);

    }


    private void assertMdService(MdServiceSCM mdService){
        
        Assert.assertEquals(
                "http://www.alert-project.eu/ontologies/alert_scm.owl#Commit4",
                mdService.getUri().trim()
                );

        Assert.assertEquals(
                "http://www.alert-project.eu/ontologies/alert_scm.owl#Person1",
                mdService.getAuthorUri().trim()
                );

        Assert.assertEquals(
                "http://www.alert-project.eu/ontologies/alert_scm.owl#Person2",
                mdService.getCommitterUri().trim()
                );
        
        Assert.assertEquals(
                "http://www.alert-project.eu/ontologies/alert_scm.owl#Repository1",
                mdService.getRepositoryUri().trim()
        );

        List<MdServiceSCM.File> files = mdService.getFiles();
        Assert.assertEquals(2,files.size(),0);


        Iterator<MdServiceSCM.File> iterator = files.iterator();
        MdServiceSCM.File file1 = iterator.next();
        Assert.assertEquals(
                "http://www.alert-project.eu/ontologies/alert_scm.owl#File1",
                file1.getUri().trim());

        List<MdServiceSCM.File.Module> file1Modules = file1.getModules();
        Assert.assertEquals(2,file1Modules.size(),0);

        Iterator<MdServiceSCM.File.Module> iterator1 = file1Modules.iterator();

        MdServiceSCM.File.Module file1Module1 = iterator1.next();
        Assert.assertEquals(
                "http://www.alert-project.eu/ontologies/alert_scm.owl#Module1",
                file1Module1.getUri().trim());



    }

    private void assertKesi(KesiSCM kesi) {

        Assert.assertNotNull(kesi);
        Assert.assertEquals(
                "http://www.alert-project.eu/ontologies/alert_scm.owl#Repository1",
                kesi.getRepositoryUri().trim()
        );

        Assert.assertEquals(1, kesi.getRevisionTag(),0);

        Assert.assertEquals("Sasa Stojanovic",kesi.getAuthor().getName());
        Assert.assertEquals("sasa.stojanovic@cimcollege.rs",kesi.getAuthor().getId());
        Assert.assertEquals("sasa.stojanovic@cimcollege.rs",kesi.getAuthor().getEmail());

        Assert.assertEquals("Ivan Obradovic",kesi.getCommitter().getName());
        Assert.assertEquals("ivan.obradovic@cimcollege.rs",kesi.getCommitter().getId());
        Assert.assertEquals("ivan.obradovic@cimcollege.rs",kesi.getCommitter().getEmail());

        Assert.assertEquals(
                "2012-01-16 16:31",
                DateFormatUtils.format(kesi.getDate(), "yyyy-MM-dd HH:mm")
        );

        Assert.assertEquals(
                "comment of commit",
                kesi.getMessageLog().trim()
        );

        List<KesiSCM.File> files = kesi.getFiles();
        Assert.assertEquals(2,files.size());

        Iterator<KesiSCM.File> iterator = files.iterator();

        KesiSCM.File file1 = iterator.next();

        Assert.assertEquals(11111,file1.getId(),0);
        Assert.assertEquals("Add",file1.getAction());
        Assert.assertEquals("branch1",file1.getBranch());


        List<KesiSCM.File.Module> modules = file1.getModules();
        Assert.assertEquals(2,modules.size(),0);


        Iterator<KesiSCM.File.Module> fileModules1 = modules.iterator();
        KesiSCM.File.Module next = fileModules1.next();
        Assert.assertEquals(1111,next.getId(),0);
        Assert.assertEquals("Mod111",next.getName());
        Assert.assertEquals(100,next.getStartLine(),0);
        Assert.assertEquals(199,next.getEndLine(),0);

        List<KesiSCM.File.Module.Methods> methods = next.getMethods();

        Iterator<KesiSCM.File.Module.Methods> moduleMethods1 = methods.iterator();
        KesiSCM.File.Module.Methods mm1 = moduleMethods1.next();
        Assert.assertEquals(111,mm1.getId(),0);
        Assert.assertEquals("Meth111",mm1.getName());
        Assert.assertEquals(100,mm1.getStartLine(),0);
        Assert.assertEquals(149,mm1.getEndLine(),0);

        KesiSCM.File.Module.Methods mm2 = moduleMethods1.next();
        Assert.assertEquals(112,mm2.getId(),0);
        Assert.assertEquals("Meth112",mm2.getName());
        Assert.assertEquals(150,mm2.getStartLine(),0);
        Assert.assertEquals(199,mm2.getEndLine(),0);


        KesiSCM.File file2= iterator.next();

        Assert.assertEquals(21111,file2.getId(),0);
        Assert.assertEquals("Copy",file2.getAction());
        Assert.assertEquals("branch2",file2.getBranch());

        List<KesiSCM.File.Module> file2Modules = file2.getModules();
        Assert.assertEquals(1,file2Modules.size(),0);

        Iterator<KesiSCM.File.Module> file2ModulesIterator = file2Modules.iterator();
        KesiSCM.File.Module fm2i1 = file2ModulesIterator.next();

        Assert.assertEquals(2111,fm2i1.getId(),0);
        Assert.assertEquals("Mod2111",fm2i1.getName());
        Assert.assertEquals(300,fm2i1.getStartLine(),0);
        Assert.assertEquals(399,fm2i1.getEndLine(),0);

        List<KesiSCM.File.Module.Methods> fm2i1Methods = fm2i1.getMethods();
        Assert.assertEquals(1,fm2i1Methods.size(),0);

        Iterator<KesiSCM.File.Module.Methods> fm2iMethodsIterator = fm2i1Methods.iterator();

        KesiSCM.File.Module.Methods fm2im1 = fm2iMethodsIterator.next();
        Assert.assertEquals(211,fm2im1.getId(),0);
        Assert.assertEquals("Meth211",fm2im1.getName());
        Assert.assertEquals(300,fm2im1.getStartLine(),0);
        Assert.assertEquals(399,fm2im1.getEndLine(),0);


    }
}
