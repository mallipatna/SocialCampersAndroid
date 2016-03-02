package projects.android.socialcampers.DBOperations;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBQueryExpression;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBScanExpression;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.PaginatedScanList;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

import java.util.ArrayList;
import java.util.List;
import projects.android.socialcampers.model.Campground;

/**
 * Created by nandinivishwas on 08/02/16.
 * data model for campground
 */

public class GetCampground extends BaseDdbOperation {

    // Scan Campground table look for campgroundName

    public List<Campground> scanCampgrounds(String parkName) {

        ArrayList<Object> itemsToGet = new ArrayList<>();
        Campground cg = new Campground();
        cg.setParkName(parkName);
        itemsToGet.add(cg);
        DynamoDBQueryExpression<Campground> query = new DynamoDBQueryExpression<Campground>().withHashKeyValues(cg);

        return mapper.query(Campground.class, query);
    }

    // Get datesOpen for (parkName + campgroundName) combination from Campground table.

    public String datesOpen(String parkName, String campgroundName) {

        List<Campground> campgroundList = scanCampgrounds(parkName);
        for (Campground campground : campgroundList) {
            if (campground.getCampgroundName().equals(campgroundName)) {
                return campground.getDatesOpen();
            }
        }
        return "Not found";
    }

    // Get Number of Campsites for (parkName + campgroundName) combination from Campground table.

    public int numOfCampsites(String parkName, String campgroundName){

        List<Campground> campgroundList = scanCampgrounds(parkName);
        for (Campground campground : campgroundList) {
            if (campground.getCampgroundName().equals(campgroundName)) {
                return campground.getNumCampsites();
            }
        }
        return 0;
    }

    // Get Fee for (parkName + campgroundName) combination from Campground table.

    public double fee(String parkName, String campgroundName){

        List<Campground> campgroundList = scanCampgrounds(parkName);
        for (Campground campground : campgroundList) {
            if (campground.getCampgroundName().equals(campgroundName)) {
                return campground.getFee();
            }
        }
        return 0;
    }

    // Get Reservation? for (parkName + campgroundName) combination from Campground table.

    public boolean reservation(String parkName, String campgroundName){

        List<Campground> campgroundList = scanCampgrounds(parkName);
        for (Campground campground : campgroundList) {
            if (campground.getCampgroundName().equals(campgroundName)) {
                return campground.getReserveSite();
            }
        }
        return false;
    }

    // Get Bathroom Type for (parkName + campgroundName) combination from Campground table.

    public String bathType(String parkName, String campgroundName){

        List<Campground> campgroundList = scanCampgrounds(parkName);
        for (Campground campground : campgroundList) {
            if (campground.getCampgroundName().equals(campgroundName)) {
                return campground.getBathroomType();
            }
        }
        return "Not found";
    }

    // Get Shower? for (parkName + campgroundName) combination from Campground table.

    public boolean shower(String parkName, String campgroundName){

        List<Campground> campgroundList = scanCampgrounds(parkName);
        for (Campground campground : campgroundList) {
            if (campground.getCampgroundName().equals(campgroundName)) {
                return campground.getShower();
            }
        }
        return false;
    }

    // Get RVhookup? for (parkName + campgroundName) combination from Campground table.

    public boolean rvHookup(String parkName, String campgroundName){

        List<Campground> campgroundList = scanCampgrounds(parkName);
        for (Campground campground : campgroundList) {
            if (campground.getCampgroundName().equals(campgroundName)) {
                return campground.getRvHookup();
            }
        }
        return false;
    }
    // Get Dump station? for (parkName + campgroundName) combination from Campground table.

    public boolean dumpStation(String parkName, String campgroundName){

        List<Campground> campgroundList = scanCampgrounds(parkName);
        for (Campground campground : campgroundList) {
            if (campground.getCampgroundName().equals(campgroundName)) {
                return campground.getDumpStation();
            }
        }
        return false;
    }
}
