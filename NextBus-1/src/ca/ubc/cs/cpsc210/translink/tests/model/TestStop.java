package ca.ubc.cs.cpsc210.translink.tests.model;

import ca.ubc.cs.cpsc210.translink.model.*;
import ca.ubc.cs.cpsc210.translink.util.LatLon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by naman on 2016-10-30.
 */
public class TestStop {

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
    Arrival a;
    Arrival b;
    Arrival c;


    @Before
    public void setup() {

       ////////////////////////////////

        listoflatlon = new ArrayList<>();
        listoflatlon.add(cord1);
        listoflatlon.add(cord2);
        cord1 = new LatLon(33.2, 21.2);
        cord2 = new LatLon(3.1, 2.2);

        r1 = RouteManager.getInstance().getRouteWithNumber("43");
        r1.addStop(stop1);

        r2 = RouteManager.getInstance().getRouteWithNumber("23");
        r2.addStop(stop2);
        r2.addStop(stop1);

        stop1 = StopManager.getInstance().getStopWithId(20, "universe", cord1);
        stop1.addRoute(r1);
        stop2 = StopManager.getInstance().getStopWithId(20,"university",cord2);

        stop3 = StopManager.getInstance().getStopWithId(2,"granvile",cord1);
        listofstops = new ArrayList<>();
        listofstops.add(stop1);
        listofstops.add(stop2);
        listofstops.add(stop3);

        a = new Arrival(23, "Home", r1);
        b = new Arrival(10, "cafe", r2);
        c = new Arrival(5, "hom", r2);


        routePattern1 = new RoutePattern("maze", "granvile", "west", r1);
        routePattern2 = new RoutePattern("grey", "granvile", "west", r2);
        routePattern3 = new RoutePattern("maze", "downtown", "east", r2);
        listofroutepattern = new ArrayList<>();
        listofroutepattern.add(routePattern1);
        listofroutepattern.add(routePattern2);
        listofroutepattern.add(routePattern3);
    }


    @Test
    public void TestConstructor() {
        Assert.assertEquals(20, stop1.getNumber());
      Assert.assertEquals("universe", stop1.getName());
        Assert.assertEquals(cord1, stop1.getLocn());
        Assert.assertEquals(1, stop1.getRoutes().size());

        stop1.addRoute(r1);
        stop1.addRoute(r2);
        Assert.assertEquals(2, stop1.getRoutes().size());
        stop1.removeRoute(r2);
        Assert.assertEquals(1, stop1.getRoutes().size());

        stop1.addArrival(a);
        stop1.addArrival(b);



       Assert.assertTrue(stop1.onRoute(r1));
//        Assert.assertTrue(stop1.onRoute(r2));



        Assert.assertTrue(stop1.equals(stop2));
        Assert.assertFalse(stop2.equals(stop3));
        Assert.assertFalse(stop1.equals(null));
        Assert.assertFalse(stop1.equals(r1));
        stop1.setName("ye");
        Assert.assertEquals("ye", stop1.getName());
        stop1.setLocn(cord2);
        Assert.assertEquals(cord2, stop1.getLocn());

        stop1.addArrival(a);
        stop1.addArrival(b);
        stop1.addArrival(c);
    }

}



