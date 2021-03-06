package projects.android.socialcampers.model;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.*;

/**
 * Created by nandinivishwas on 06/02/16.
 * Park mapping class
 */

@DynamoDBTable(tableName = "Park")
public class Park {

    private String parkName;
    private String about;
    private String location;
    private String best_time_to_visit;
    private String things_to_do;
    private String places_to_go;

    // hash key =  Primary key.
    @DynamoDBHashKey(attributeName = "parkName")
    public String getParkName(){
        return parkName;
    }
    public void setParkName(String parkName){
        this.parkName = parkName;
    }

    @DynamoDBAttribute(attributeName = "about")
    public String getAbout()
    {
        return about;
    }
    public void setAbout(String about)
    {
        this.about = about;
    }

    @DynamoDBAttribute(attributeName = "location")
    public String getLocation()
    {
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

    @DynamoDBAttribute(attributeName = "placesToGo")
    public String getPlaces_to_go(){
        return places_to_go;
    }

    public void setPlaces_to_go(String places_to_go) {
        this.places_to_go = places_to_go;
    }
}
