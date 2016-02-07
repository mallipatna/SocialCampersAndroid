package projects.android.socialcampers.model;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.*;

/**
 * Created by nandinivishwas on 06/02/16.
 * Park mapping class
 */

@DynamoDBTable(tableName = "Park")
public class Park {

    private String parkName;
    private String location;
    private String best_time_to_visit;
    private String things_to_do;

    // hash key =  Primary key.
    @DynamoDBHashKey(attributeName = "parkName")
    public String getParkName(){
        return parkName;
    }
    public void setParkName(String parkName){
        this.parkName = parkName;
    }

    @DynamoDBAttribute(attributeName = "location")
    public String getLocation(){
        return location;
    }
    public void setLocation(String location){
        this.location = location;
    }

    @DynamoDBAttribute(attributeName = "bestTimeToVisit")
    public String getBest_time_to_visit(){
        return best_time_to_visit;
    }
    public void setBest_time_to_visit(String best_time_to_visit){
        this.best_time_to_visit = best_time_to_visit;
    }

    @DynamoDBAttribute(attributeName = "thingsToDo")
    public String getThings_to_do(){
        return things_to_do;
    }
    public void setThings_to_do(String things_to_do){
        this.things_to_do = things_to_do;
    }

}
