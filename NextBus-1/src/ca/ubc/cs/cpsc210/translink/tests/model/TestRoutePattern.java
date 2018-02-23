package ca.ubc.cs.cpsc210.translink.tests.model;

import ca.ubc.cs.cpsc210.translink.model.Route;
import ca.ubc.cs.cpsc210.translink.model.RouteManager;
import ca.ubc.cs.cpsc210.translink.model.RoutePattern;
import ca.ubc.cs.cpsc210.translink.util.LatLon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by naman on 2016-10-27.
 */
public class TestRoutePattern {

    RoutePattern routePattern1;
    RoutePattern routePattern2;
    RoutePattern routePattern3;
    Route r1;
    Route r2;
    List<LatLon> testlist;
    LatLon cord1;
    LatLon cord2;

    @Before
    public void setup() {
        r1 = RouteManager.getInstance().getRouteWithNumber("43");
        r2 = RouteManager.getInstance().getRouteWithNumber("23");
        cord1= new LatLon(33.2,21.2);
        cord2 = new LatLon(3.1,2.2);
        routePattern1 = new RoutePattern("maze","granvile","west",r1);
        routePattern2 =  new RoutePattern("grey","granvile","west",r2);
        routePattern3 = new RoutePattern("maze", "downtown", "east", r2);
        testlist = new ArrayList<>();
        testlist.add(cord1);
        testlist.add(cord2);

    }

    @Test

    public void TestConstructor(){
        Assert.assertEquals("maze",routePattern1.getName());
        Assert.assertEquals("granvile", routePattern1.getDestination());
        Assert.assertEquals("west",routePattern1.getDirection());
        routePattern1.setPath(testlist);
        Assert.assertEquals(testlist ,routePattern1.getPath());
        routePattern1.setDirection("south");
        Assert.assertEquals("south", routePattern1.getDirection());
        routePattern1.setDestination("macdonalds");
        Assert.assertEquals("macdonalds",routePattern1.getDestination());
    }

    @Test
    public void TestEquals() {

        Assert.assertTrue(routePattern1.equals(routePattern3));
        Assert.assertFalse(routePattern1.equals(routePattern2));
        Assert.assertFalse(routePattern1.equals(null));
        Assert.assertFalse(routePattern1.equals(r1));
    }

}
