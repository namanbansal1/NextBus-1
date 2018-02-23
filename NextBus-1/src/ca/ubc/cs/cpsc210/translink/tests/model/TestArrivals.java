package ca.ubc.cs.cpsc210.translink.tests.model;

import ca.ubc.cs.cpsc210.translink.model.Arrival;
import ca.ubc.cs.cpsc210.translink.model.Route;
import ca.ubc.cs.cpsc210.translink.model.RouteManager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test Arrivals
 */
public class TestArrivals {
    Route r;
    Arrival a;
    Arrival b;

    @Before
    public void setup() {
        r = RouteManager.getInstance().getRouteWithNumber("43");
        a = new Arrival(23, "Home", r);
        b = new Arrival(10, "cafe", r);
    }

    @Test
    public void testConstructor() {
        assertEquals(23, a.getTimeToStopInMins());
        assertEquals(r, a.getRoute());
        assertEquals("Home", a.getDestination());
        assertEquals("", a.getStatus());
        a.setStatus("early");
        assertEquals("early", a.getStatus());
        a.setStatus("late");
        assertEquals("late", a.getStatus());
        a.setStatus("on schedule");
        assertEquals("on schedule", a.getStatus());
        assertEquals(13, a.compareTo(b));
    }



}


