package eu.alertproject.iccs.events.xstream;

import eu.alertproject.iccs.events.api.EventFactory;
import eu.alertproject.iccs.events.stardom.StardomCIUpdatePayload;
import junit.framework.Assert;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: fotis
 * Date: 10/21/12
 * Time: 4:13 PM
 */
public class StardomCIUpdatedEnvelopeTest {


    @Test
    public void testSerialize() throws IOException {


        String xml  = EventFactory.createCompetencyUpdateEvent(
                1697944231,
                1331675854818L,
                1331675854822L,
                2063254152,
                "51d8ecec1d6ea40106c6c71ffed13547010870b0ab57fe396f5fbb124967e0eb",
                Arrays.asList(
                        "http://www.alert-project.eu/ontologies/alert_scm.owl#Person1",
                        "http://www.alert-project.eu/ontologies/alert_scm.owl#Person2",
                        "http://www.alert-project.eu/ontologies/alert_scm.owl#Person3"
                ),
                Arrays.asList(
                        new StardomCIUpdatePayload.EventData.CI("Core Developers",23.0),
                        new StardomCIUpdatePayload.EventData.CI("Bug Triagers",0.0),
                        new StardomCIUpdatePayload.EventData.CI("Reviewers",3.0)
                ),
                new StardomCIUpdatePayload.EventData.Metrics.Fluency(0),
                new StardomCIUpdatePayload.EventData.Metrics.Effectiveness(1),
                new StardomCIUpdatePayload.EventData.Metrics.Contribution(2,3,4),
                new StardomCIUpdatePayload.EventData.Metrics.Recency(5,6,7));


        Assert.assertEquals(
                IOUtils.toString(StardomCIUpdatedEnvelopeTest.class.getResourceAsStream("/ALERT.STARDOM.CompetencyUpdate.xml")),
                xml
        );

    }
}
