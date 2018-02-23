package ca.ubc.cs.cpsc210.translink.tests.parsers;

import ca.ubc.cs.cpsc210.translink.model.RouteManager;
import ca.ubc.cs.cpsc210.translink.parsers.RouteParser;
import ca.ubc.cs.cpsc210.translink.parsers.exception.RouteDataMissingException;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the RouteParser
 */


public class TestRouteParser {
    @Before
    public void setup() {

    }


    @Test
    public void testRouteParserNormal() throws RouteDataMissingException, JSONException, IOException {
        RouteParser p = new RouteParser("allroutes.json");
        p.parse();
        assertEquals(229, RouteManager.getInstance().getNumRoutes());
    }

    @Test (expected = RouteDataMissingException.class)
    public void testRouteParserNormal1() throws RouteDataMissingException, JSONException, IOException {
        RouteParser p = new RouteParser("missingroutename.json");
        p.parse();
    }



    @Test (expected = RouteDataMissingException.class)
    public void testRouteParserNormal2() throws RouteDataMissingException, JSONException, IOException {
        RouteParser p = new RouteParser("missingroutenumber.json"); //line 5964
        p.parse();
    }




    @Test (expected = RouteDataMissingException.class)
    public void testRouteParserNormal13() throws RouteDataMissingException, JSONException, IOException {
        RouteParser p = new RouteParser("missingroutepatterns.json"); //line 11993
        p.parse();
    }




    @Test (expected = RouteDataMissingException.class)
    public void testRouteParserNormal14() throws RouteDataMissingException, JSONException, IOException {
        RouteParser p = new RouteParser("missingpatternno.json"); // line 12005
        p.parse();
    }


    @Test (expected = RouteDataMissingException.class)
    public void testRouteParserNormal15() throws RouteDataMissingException, JSONException, IOException {
        RouteParser p = new RouteParser("missingdestination.json");
        p.parse();
    }


    @Test (expected = RouteDataMissingException.class)
    public void testRouteParserNormal16() throws RouteDataMissingException, JSONException, IOException {
        RouteParser p = new RouteParser("missingdirection.json");
        p.parse();
    }

    @Test (expected = JSONException.class)    // missing name key
    public void testRouteParserNormal00() throws RouteDataMissingException, JSONException, IOException {
        RouteParser p = new RouteParser("jasonexp1.json");
        p.parse();
    }


    @Test (expected = JSONException.class)    // missing pattern value
    public void testRouteParserNormal01() throws RouteDataMissingException, JSONException, IOException {
        RouteParser p = new RouteParser("jasonexp2.json");
        p.parse();
    }

    @Test (expected = RouteDataMissingException.class)    // missing pattern value
    public void testRouteParserNormal012() throws RouteDataMissingException, JSONException, IOException {
        RouteParser p = new RouteParser("jsonnotarray.json");
        p.parse();
    }


}
