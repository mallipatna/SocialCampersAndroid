package projects.android.socialcampers.model;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

/**
 * Created by nandinivishwas on 08/02/16.
 */

@DynamoDBTable(tableName = "Campground")
public class Campground {

    /*
    campgroundId, campgroundName,datesOpen,numberCampsites, bathroomType,  dumpStation, fee,
    reserveSite, rvHookup, shower
    */

    //private Integer campgroundId;
    private String campgroundName;
    private String parkName;
    private String datesOpen;
    private int numCampsites;
    private String bathroomType;
    private boolean dumpStation;
    private double fee;
    private boolean shower;
    private boolean reserveSite;
    private boolean rvHookup;

    @DynamoDBRangeKey(attributeName = "campgroundName")
    public String getCampgroundName() {
        return campgroundName;
    }

    public void setCampgroundName(String campgroundName) {
        this.campgroundName = campgroundName;
    }

    @DynamoDBHashKey(attributeName = "parkName")
    public String getParkName()
    {
        return parkName;
    }

    public void setParkName(String parkName){
        this.parkName = parkName;
    }

    @DynamoDBAttribute(attributeName = "datesOpen")
    public String getDatesOpen() {
        return datesOpen;
    }

    public void setDatesOpen(String datesOpen) {
        this.datesOpen = datesOpen;
    }

    @DynamoDBAttribute(attributeName = "numberCampsites")
    public int getNumCampsites() {
        return numCampsites;
    }

    public void setNumCampsites(int numCampsites) {
        this.numCampsites = numCampsites;
    }

    @DynamoDBAttribute(attributeName = "bathroomType")
    public String getBathroomType() {
        return bathroomType;
    }

    public void setBathroomType(String bathroomType) {
        this.bathroomType = bathroomType;
    }

    @DynamoDBAttribute(attributeName = "dumpStation")
    public boolean getDumpStation() {
        return dumpStation;
    }

    public void setDumpStation(boolean dumpStation) {
        this.dumpStation = dumpStation;
    }

    @DynamoDBAttribute(attributeName = "fee")
    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @DynamoDBAttribute(attributeName = "shower")
    public boolean getShower() {
        return shower;
    }

    public void setShower(boolean shower) {
        this.shower = shower;
    }

    @DynamoDBAttribute(attributeName = "reserveSite")
    public boolean getReserveSite() {
        return reserveSite;
    }

    public void setReserveSite(boolean reserveSite) {
        this.reserveSite = reserveSite;
    }

    @DynamoDBAttribute(attributeName = "rvHookup")
    public boolean getRvHookup() {
        return rvHookup;
    }

    public void setRvHookup(boolean rvHookup) {
        this.rvHookup = rvHookup;
    }
}
