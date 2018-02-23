package ca.ubc.cs.cpsc210.translink.tests.parsers;


import ca.ubc.cs.cpsc210.translink.model.Stop;
import ca.ubc.cs.cpsc210.translink.model.StopManager;
import ca.ubc.cs.cpsc210.translink.parsers.ArrivalsParser;
import ca.ubc.cs.cpsc210.translink.parsers.exception.ArrivalsDataMissingException;
import ca.ubc.cs.cpsc210.translink.providers.DataProvider;
import ca.ubc.cs.cpsc210.translink.providers.FileDataProvider;
import ca.ubc.cs.cpsc210.translink.util.LatLon;
import org.json.JSONException;
import org.junit.Test;

import java.io.IOException;

public class TestArrivalsParser {

    private String filename;

    @Test
    public void test1() throws JSONException, ArrivalsDataMissingException, IOException {
        LatLon a = new LatLon(22.2, 11.2);
        Stop s = StopManager.getInstance().getStopWithId(22, "s", a);
        DataProvider dataProvider = new FileDataProvider("arrivals.json");
        ArrivalsParser.parseArrivals(s,dataProvider.dataSourceToString());


    }

    @Test (expected = ArrivalsDataMissingException.class)
    public void test2() throws JSONException, ArrivalsDataMissingException, IOException {

        LatLon a = new LatLon(22.2, 11.2);
        Stop s = StopManager.getInstance().getStopWithId(24, "s3", a);
        DataProvider dataProvider = new FileDataProvider("incompleteallarrivals.json");
        ArrivalsParser.parseArrivals(s,dataProvider.dataSourceToString());
    }
    @Test (expected = JSONException.class)
    public void test3() throws JSONException, ArrivalsDataMissingException, IOException {
        LatLon a = new LatLon(22.2, 11.2);
        Stop s = StopManager.getInstance().getStopWithId(24, "s3", a);
        DataProvider dataProvider = new FileDataProvider("jsonexparrival.json");
        ArrivalsParser.parseArrivals(s,dataProvider.dataSourceToString());

    }

}





