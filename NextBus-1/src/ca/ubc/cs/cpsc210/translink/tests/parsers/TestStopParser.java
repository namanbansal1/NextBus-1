package ca.ubc.cs.cpsc210.translink.tests.parsers;


import ca.ubc.cs.cpsc210.translink.model.StopManager;
import ca.ubc.cs.cpsc210.translink.parsers.StopParser;
import ca.ubc.cs.cpsc210.translink.parsers.exception.StopDataMissingException;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the StopParser
 */

// TODO: Write more tests

public class TestStopParser {
    @Before
    public void setup() {

    }

    @Test
    public void testStopParserNormal() throws StopDataMissingException, JSONException, IOException {
        StopParser p = new StopParser("stops.json");
        p.parse();
        assertEquals(9232, StopManager.getInstance().getNumStops());
    }

    @Test (expected = JSONException.class)
    public void Test() throws StopDataMissingException, JSONException, IOException {
        StopParser p = new StopParser("stopsjasonexp.json");
        p.parse();
    }


    @Test (expected = StopDataMissingException.class)
    public void Test2() throws StopDataMissingException, JSONException, IOException {
        StopParser p = new StopParser("missingstopno.json");
        p.parse();
    }


}
