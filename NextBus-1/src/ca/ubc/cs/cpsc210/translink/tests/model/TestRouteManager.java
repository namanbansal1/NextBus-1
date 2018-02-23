package ca.ubc.cs.cpsc210.translink.tests.model;

import ca.ubc.cs.cpsc210.translink.model.Route;
import ca.ubc.cs.cpsc210.translink.model.RouteManager;
import ca.ubc.cs.cpsc210.translink.model.RoutePattern;
import ca.ubc.cs.cpsc210.translink.model.Stop;
import ca.ubc.cs.cpsc210.translink.util.LatLon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Test the RouteManager
 */
public class TestRouteManager {

    RoutePattern routePattern1;
    RoutePattern routePattern2;
    RoutePattern routePattern3;
    Route r1;
    Route r2;
    Route r3;
    List<LatLon> listoflatlon;
    LatLon cord1;
    LatLon cord2;
    List<RoutePattern> listofroutepattern;
    List<Stop> listofstops;
    Stop stop1;
    Stop stop2;
    Stop stop3;
    String routename;
    List<Stop> emptylist;

    @Before
    public void setup() {
        RouteManager.getInstance().clearRoutes();
        r1 = new Route("12");
        r2 = new Route("11");
        r3 = new Route("1");

        routePattern1 = new RoutePattern("maze", "granvile", "west", r1);
        routePattern2 = new RoutePattern("grey", "granvile", "west", r2);
        routePattern3 = new RoutePattern("maze", "downtown", "east", r2);
        listofroutepattern = new ArrayList<>();
        listofroutepattern.add(routePattern1);
        listofroutepattern.add(routePattern2);
        listofroutepattern.add(routePattern3);


        stop1 = new Stop(20, "universe", cord1);
        stop2 = new Stop(20, "university", cord2);
        stop3 = new Stop(2, "granvile", cord1);
        listofstops = new ArrayList<>();
        listofstops.add(stop1);
        listofstops.add(stop2);
        listofstops.add(stop3);

        emptylist = new ArrayList<>();

///////////////////////////////////////////////////////////////////////////////////
        listoflatlon = new ArrayList<>();
        listoflatlon.add(cord1);
        listoflatlon.add(cord2);
        cord1 = new LatLon(33.2, 21.2);
        cord2 = new LatLon(3.1, 2.2);
        //////////////////////////////////////////////////////////////////////////
    }

    @Test
    public void testBoring() {
        Route r43 = new Route("43");
        Route r = RouteManager.getInstance().getRouteWithNumber("43");
        assertEquals(r43, r);
    }

    @Test
    public void TestConstructor() {

        Assert.assertEquals(0, RouteManager.getInstance().getNumRoutes());
        RouteManager.getInstance().getRouteWithNumber("22");
        Assert.assertEquals(1, RouteManager.getInstance().getNumRoutes());
        Assert.assertEquals("", RouteManager.getInstance().getRouteWithNumber("22").getName());
        Assert.assertEquals("22", RouteManager.getInstance().getRouteWithNumber("22").getNumber());
        Assert.assertEquals(1, RouteManager.getInstance().getNumRoutes());
        RouteManager.getInstance().getRouteWithNumber("12");
        RouteManager.getInstance().getRouteWithNumber("112");
        Assert.assertEquals(3, RouteManager.getInstance().getNumRoutes());
        Assert.assertEquals(r1, RouteManager.getInstance().getRouteWithNumber("12"));
    }

    @Test
    public void TestMethod2() {

        RouteManager.getInstance().getRouteWithNumber("11","highway");
        Assert.assertEquals(1, RouteManager.getInstance().getNumRoutes());
        Assert.assertEquals("", RouteManager.getInstance().getRouteWithNumber("12","").getName());
        Assert.assertEquals("22", RouteManager.getInstance().getRouteWithNumber("22","d").getNumber());
        Assert.assertEquals(3, RouteManager.getInstance().getNumRoutes());
        Assert.assertEquals(r2, RouteManager.getInstance().getRouteWithNumber("11"));
        RouteManager.getInstance().clearRoutes();
        Assert.assertEquals(0, RouteManager.getInstance().getNumRoutes());
    }



}








