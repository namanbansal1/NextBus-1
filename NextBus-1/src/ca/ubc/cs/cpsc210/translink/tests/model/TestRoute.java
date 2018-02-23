package ca.ubc.cs.cpsc210.translink.tests.model;

import ca.ubc.cs.cpsc210.translink.model.*;
import ca.ubc.cs.cpsc210.translink.util.LatLon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;



public class TestRoute {

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
        //  r1 = RouteManager.getInstance().getRouteWithNumber("43");
        //   r2 = RouteManager.getInstance().getRouteWithNumber("23");
        r1 = new Route("22");
        r2 = new Route("1");
        r3 = new Route("1");

        routePattern1 = new RoutePattern("maze", "granvile", "west", r1);
        routePattern2 = new RoutePattern("grey", "granvile", "west", r2);
        routePattern3 = new RoutePattern("maze", "downtown", "east", r1);
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
    public void TestConstructor() {


        Assert.assertEquals("22", r1.getNumber());
        Assert.assertEquals(emptylist, r1.getStops());
        r1.setName("route1");
        Assert.assertEquals("route1", r1.getName());

        r1.addPattern(routePattern1);
        r1.addPattern(routePattern2);
        r1.addPattern(routePattern3);

        Assert.assertEquals(2, r1.getPatterns().size());

        r1.addPattern(routePattern1);
        Assert.assertEquals(2, r1.getPatterns().size());

        r2.addStop(stop1);
        r2.addStop(stop2);
        r2.addStop(stop3);
       Assert.assertEquals(2, r2.getStops().size());

        r2.addStop(stop1);
        Assert.assertEquals(2, r2.getStops().size());

    }

    @Test
    public void Test2() {


        r2.addStop(stop1);
        r2.addStop(stop2);
        r2.addStop(stop3);
        r2.removeStop(stop1);
        Assert.assertEquals(1, r2.getStops().size());
    }

    @Test
    public void Test3() {

        r2.addStop(stop1);
        r2.addStop(stop2);
        Assert.assertFalse(r2.hasStop(stop3));
        Assert.assertTrue(r2.hasStop(stop1));

    }

    @Test
    public void TestEquals() {

        Assert.assertFalse(r1.equals(r2));
        Assert.assertTrue(r2.equals(r3));
        Assert.assertFalse(r1.equals(null));
        Assert.assertFalse(r2.equals(stop1));
    }

    @Test
    public void TestGetPattern() {

        r1.addPattern(routePattern1);
        r1.addPattern(routePattern2);
        r1.addPattern(routePattern3);


        Assert.assertEquals(2,r1.getPatterns().size());

        Assert.assertEquals("london", r1.getPattern("grey", "london", "south").getDestination());
        Assert.assertEquals("south", r1.getPattern("grey", "london", "south").getDirection());
        Assert.assertEquals(2,r1.getPatterns().size());


    }

    @Test
    public void TestGetPattern2() {

        r1.getPattern("yellow","New york", "northeast");
        Assert.assertEquals(1,r1.getPatterns().size());
        Assert.assertEquals("New york", r1.getPattern("yellow","New york", "northeast").getDestination());
        Assert.assertEquals("northeast", r1.getPattern("yellow","New york", "northeast").getDirection());

    }
    ///////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void TestGetPattern1(){

        r1.addPattern(routePattern1);
        r1.addPattern(routePattern2);
        r1.addPattern(routePattern3);


        Assert.assertEquals(2,r1.getPatterns().size());

        Assert.assertEquals("grey", r1.getPattern("grey").getName());
//         r1.getPattern("yellow");
 //       Assert.assertEquals(3,r1.getPatterns().size());

  //      Assert.assertEquals("", r1.getPattern("yellow").getDestination());
  //      Assert.assertEquals("", r1.getPattern("yellow").getDirection());

    }

}
