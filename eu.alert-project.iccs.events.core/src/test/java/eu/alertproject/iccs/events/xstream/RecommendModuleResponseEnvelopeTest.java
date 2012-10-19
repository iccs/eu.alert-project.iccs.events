package eu.alertproject.iccs.events.xstream;

import eu.alertproject.iccs.events.api.EventFactory;
import eu.alertproject.iccs.events.socrates.Module;
import eu.alertproject.iccs.events.socrates.RecommendModulesPayload;
import junit.framework.Assert;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fotis
 * Date: 10/19/12
 * Time: 5:08 PM
 */
public class RecommendModuleResponseEnvelopeTest {


    @Test
    public void recommendModules() throws IOException {

        List<Module> modules = new ArrayList<Module>();
        modules.add(new Module("Component1"));
        modules.add(new Module("Component2"));
        Assert.assertEquals(EventFactory.createRecommendationModuleEvent(
                "1",
                1350656522359L,
                1350656522359L,
                2,
                modules
        ),
        IOUtils.toString(RecommendIdentitiesRequestEnvelopeTest.class.getResourceAsStream("/ALERT.Recommender.ModuleRecommendation.xml")));
    }

}
