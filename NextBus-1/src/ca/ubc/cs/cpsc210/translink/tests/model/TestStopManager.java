package ca.ubc.cs.cpsc210.translink.tests.model;


import ca.ubc.cs.cpsc210.translink.model.Stop;
import ca.ubc.cs.cpsc210.translink.model.StopManager;
import ca.ubc.cs.cpsc210.translink.model.exception.StopException;
import ca.ubc.cs.cpsc210.translink.util.LatLon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Test the StopManager
 */
public class TestStopManager {

    private Map<Integer, Stop> CollectionofStops;
    private Stop StopSelected;
    private Stop stop1;
    private Stop stop2;
    private Stop stop3;
    private Stop stop4;
    private LatLon cord1;
    private LatLon cord2;
    private LatLon cord3;
    private LatLon cord4;
    private LatLon anyloctest;

    private LatLon a;
    private LatLon b;
    private LatLon c;



    @Before
    public void setup() {

        StopManager.getInstance().clearStops();

        stop1 = new Stop(22, "universe", cord1);
        stop2 = new Stop(10, "university", cord2);
        stop3 = new Stop(30, "granvile", cord1);
        stop4 = new Stop(40, "granvile", cord1);

        anyloctest = new LatLon(12.1, 22.1);
        cord1 = new LatLon(33000.2, 21000.2);
        cord2 = new LatLon(30000.1, 20000.2);
        cord3 = new LatLon(2, 10);
        cord4 = new LatLon(0.22, 0.2);

    }


    @Test
    public void TestConstructor() {

        Assert.assertEquals(null, StopManager.getInstance().getSelected());
        Assert.assertEquals(0, StopManager.getInstance().getNumStops());

        StopManager.getInstance().getStopWithId(22);
        StopManager.getInstance().getStopWithId(10);
        StopManager.getInstance().getStopWithId(2);
        Assert.assertEquals(3, StopManager.getInstance().getNumStops());
        Assert.assertEquals("", StopManager.getInstance().getStopWithId(22).getName());
        Assert.assertEquals(22, StopManager.getInstance().getStopWithId(22).getNumber());
        Assert.assertEquals(anyloctest, StopManager.getInstance().getStopWithId(22).getLocn());
        Assert.assertEquals(stop1, StopManager.getInstance().getStopWithId(22));
        StopManager.getInstance().clearStops();
        Assert.assertEquals(0, StopManager.getInstance().getNumStops());

    }

    @Test
    public void TestOtherMethod() {

        StopManager.getInstance().getStopWithId(22, "london", anyloctest);
        StopManager.getInstance().getStopWithId(10, "la", anyloctest);
        StopManager.getInstance().getStopWithId(10, "eastvan", anyloctest);
        Assert.assertEquals(2, StopManager.getInstance().getNumStops());
        Assert.assertEquals("london", StopManager.getInstance()
                .getStopWithId(22, "london", anyloctest).getName());
        Assert.assertEquals(10, StopManager.getInstance()
                .getStopWithId(10, "eastvan", anyloctest).getNumber());
        Assert.assertEquals(anyloctest, StopManager.getInstance()
                .getStopWithId(10, "eastvan", anyloctest).getLocn());
        Assert.assertEquals(stop1, StopManager.getInstance()
                .getStopWithId(22, "london", anyloctest));
    }

    @Test
    public void TestOtherMethod2() {

        StopManager.getInstance().getStopWithId(22, "london", anyloctest);
        StopManager.getInstance().getStopWithId(10, "la", anyloctest);
        try {
            StopManager.getInstance().setSelected(stop1);
        } catch (StopException e) {
            fail(e.getMessage());
        }
        Assert.assertEquals(stop1, StopManager.getInstance().getSelected());
        StopManager.getInstance().clearSelectedStop();
        Assert.assertEquals(null, StopManager.getInstance().getSelected());
    }

    @Test(expected = StopException.class)
    public void TestOtherMethod3() throws StopException {
        StopManager.getInstance().setSelected(stop1);
    }

    @Test
    public void TestOtherMethod4() {

        StopManager.getInstance().getStopWithId(22, "london", cord1);
        StopManager.getInstance().getStopWithId(10, "la", cord2);
        LatLon passinglatlon = new LatLon(0, 0);
       Assert.assertEquals(null, StopManager.getInstance().findNearestTo(passinglatlon));
        StopManager.getInstance().getStopWithId(30, "eastvan", cord3);
        Assert.assertEquals(stop3, StopManager.getInstance().findNearestTo(passinglatlon));
        StopManager.getInstance().getStopWithId(40, "eastvan", cord4);
        Assert.assertEquals(stop4, StopManager.getInstance().findNearestTo(passinglatlon));

    }


    @Test
    public void testBoring() {
        Stop s9999 = new Stop(9999, "My house", new LatLon(-49.2, 123.2));
        Stop r = StopManager.getInstance().getStopWithId(9999);
        assertEquals(s9999, r);

    }

    @Test
    public void TestOtherMethod5() {

        LatLon passinglatlon = new LatLon(0, 0);
        StopManager.getInstance().getStopWithId(40, "eastvan", cord1);
        StopManager.getInstance().getStopWithId(30, "eastvan", cord3);
        Assert.assertEquals(stop3, StopManager.getInstance().findNearestTo(passinglatlon));

    }
}



