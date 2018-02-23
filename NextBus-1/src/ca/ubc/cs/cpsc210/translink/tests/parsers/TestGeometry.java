package ca.ubc.cs.cpsc210.translink.tests.parsers;

import ca.ubc.cs.cpsc210.translink.util.Geometry;
import ca.ubc.cs.cpsc210.translink.util.LatLon;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by naman on 2016-11-14.
 */
public class TestGeometry {


    @Test
    public void testrectangle1() {
        LatLon p1 = new LatLon(1,1);
        LatLon p2 = new LatLon(3,3);
        LatLon point1 = new LatLon(3,3);

        Assert.assertEquals(true,Geometry.rectangleContainsPoint(p1,p2,point1));

    }

    @Test
    public void testrectangle2() {
        LatLon p1 = new LatLon(1,1);
        LatLon p2 = new LatLon(3,3);
        LatLon point1 = new LatLon(0,0);
        LatLon point2 = new LatLon(3,2);
        Assert.assertEquals(true,Geometry.rectangleIntersectsLine(p1,p2,point1,point2));
    }

    @Test
    public void testrectangle1010() {
        LatLon p1 = new LatLon(1,1);
        LatLon p2 = new LatLon(3,3);
        LatLon point1 = new LatLon(0,1);
        LatLon point2 = new LatLon(5,1);
        Assert.assertEquals(true,Geometry.rectangleIntersectsLine(p1,p2,point1,point2));
    }

}
