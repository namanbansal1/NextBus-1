package ca.ubc.cs.cpsc210.translink.tests.parsers;

import ca.ubc.cs.cpsc210.translink.model.Route;
import ca.ubc.cs.cpsc210.translink.model.RouteManager;
import ca.ubc.cs.cpsc210.translink.model.RoutePattern;
import ca.ubc.cs.cpsc210.translink.parsers.RouteMapParser;
import ca.ubc.cs.cpsc210.translink.util.LatLon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Test the parser for route pattern map information
 */



public class TestRouteMapParser {


    @Before
    public void setup() {
         RouteManager.getInstance().clearRoutes();
    }

    private int countNumRoutePatterns() {
        int count = 0;
        for (Route r : RouteManager.getInstance()) {
            for (RoutePattern rp : r.getPatterns()) {
                count++;
            }
        }
        return count;
    }

    private int countNumRoutePatterns1() {
        int count = 0;
        for (Route a : RouteManager.getInstance()) {
            for (RoutePattern rp : a.getPatterns()) {
                count++;
            }
        }
        return count;
    }



    @Test
    public void testRouteParserNormal1() {

        RouteMapParser a = new RouteMapParser("singlepoint.txt");
        a.parse();
        assertEquals(0, countNumRoutePatterns1());
    }



    @Test
    public void testRouteParserNormal2() {
        RouteMapParser b = new RouteMapParser("multiplepoint.txt");
        b.parse();
        assertEquals(1, countNumRoutePatterns1());
    }


    @Test
    public void testRouteParserNormal() {
        RouteMapParser p = new RouteMapParser("allroutemaps.txt");
        p.parse();
        assertEquals(1232, countNumRoutePatterns());
    }





    private  List<String> ListOfRoutePatternName() {
        List<String> list1 = new ArrayList<>();
        for (Route r : RouteManager.getInstance()) {
            for (RoutePattern rp : r.getPatterns()) {
                list1.add(rp.getName());
            }
        }
        return list1;
    }


    private List<String> ListOfRouteName() {
        List<String> list2 = new ArrayList<>();
        for (Route r : RouteManager.getInstance()) {
            list2.add(r.getNumber());
        }
        return list2;
    }


    private List<LatLon> ListofLatLon(){
        List<LatLon> listoflatlon = new ArrayList<>();
        for (Route r : RouteManager.getInstance()) {
            for (RoutePattern rp : r.getPatterns()) {
                for(LatLon l: rp.getPath()){
                    listoflatlon.add(l);
                }
            }
        }
        return listoflatlon;
    }


    @Test
    public void TestRouteAndPatternName() {
        RouteMapParser a = new RouteMapParser("allroutemaps.txt");
        a.parse();
        assertEquals(true, ListOfRoutePatternName().contains("EB2"));
        assertEquals(true, ListOfRoutePatternName().contains("WB2PK"));
        assertEquals(true, ListOfRoutePatternName().contains("EB5DT"));
        assertEquals(true, ListOfRoutePatternName().contains("EB6"));
        assertEquals(true, ListOfRoutePatternName().contains("EB1"));
        assertEquals(true, ListOfRoutePatternName().contains("EB3A"));
        assertEquals(true, ListOfRoutePatternName().contains("W1-71"));
        assertEquals(true, ListOfRoutePatternName().contains("EBLANG"));
        assertEquals(true, ListOfRoutePatternName().contains("W1"));
        assertEquals(true, ListOfRoutePatternName().contains("WBWKND4"));
        assertEquals(true, ListOfRoutePatternName().contains("N3"));
        assertEquals(false, ListOfRoutePatternName().contains("Eb3a"));


        assertEquals(true, ListOfRouteName().contains("007"));
        assertEquals(true, ListOfRouteName().contains("C43"));
        assertEquals(true, ListOfRouteName().contains("004"));
        assertEquals(true, ListOfRouteName().contains("006"));
        assertEquals(true, ListOfRouteName().contains("099"));
        assertEquals(true, ListOfRouteName().contains("100"));
        assertEquals(true, ListOfRouteName().contains("502"));
        assertEquals(true, ListOfRouteName().contains("410"));
        assertEquals(true, ListOfRouteName().contains("C98"));
        assertEquals(false, ListOfRoutePatternName().contains("0007"));
        assertEquals(false, ListOfRoutePatternName().contains("C55"));

    }

    @Test
    public void TestLatNLon() {
        RouteMapParser r = new RouteMapParser("allroutemaps.txt");
        r.parse();
        LatLon a = new LatLon(49.199658,-122.949611);
        assertEquals(true, ListofLatLon().contains(a));

        LatLon c = new LatLon(49.1468,-123.169814);
        assertEquals(true, ListofLatLon().contains(c));

        LatLon d = new LatLon(49.161658, 123.024261);
        assertEquals(false, ListofLatLon().contains(d));

        LatLon b = new LatLon(-122.949611,49.199658);
        assertEquals(false, ListofLatLon().contains(b));

    }
}
