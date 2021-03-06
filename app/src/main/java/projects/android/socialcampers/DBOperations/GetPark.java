package projects.android.socialcampers.DBOperations;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBScanExpression;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.PaginatedScanList;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

import java.util.List;

import projects.android.socialcampers.credentials.Credentials;
import projects.android.socialcampers.model.Park;

/**
 * Created by nandinivishwas on 06/02/16.
 */

public class GetPark extends BaseDdbOperation {

    // Get the list of all parks in the park table
    public List<Park> scanParks() {
        PaginatedScanList<Park> result = mapper.scan(Park.class, new DynamoDBScanExpression());
        return result;
    }

    // Get the about information mapped to parkName
    public String about(String parkName) {
        List<Park> parkList = scanParks();
        for (Park park:parkList){
            if (park.getParkName().equals(parkName)){
                return park.getAbout();
            }
        }
        return "Not found";
    }

    // Get the location mapped to parkName
    public String location(String parkName) {
        List<Park> parkList = scanParks();
        for (Park park:parkList){
            if (park.getParkName().equals(parkName)){
                return park.getLocation();
            }
        }
        return "Not found";
    }

    // Get bestTimeToVisit from parkName
    public String bestTimeToVisit(String parkName) {
        List<Park> parkList = scanParks();
        for (Park park:parkList){
            if (park.getParkName().equals(parkName)){
                return park.getBest_time_to_visit();
            }
        }
        return "Not found";
    }

    // Get thingsToDo from parkName
    public String thingsToDo(String parkName) {
        List<Park> parkList = scanParks();
        for (Park park:parkList){
            if (park.getParkName().equals(parkName)){
                return park.getThings_to_do();
            }
        }
        return "Not found";
    }

    // Get placesToGo from parkName
    public String placesToGo(String parkName) {
        List<Park> parkList = scanParks();
        for (Park park:parkList){
            if (park.getParkName().equals(parkName)){
                return park.getPlaces_to_go();
            }
        }
        return "Not found";
    }
}
