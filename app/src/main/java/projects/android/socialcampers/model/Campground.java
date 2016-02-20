package projects.android.socialcampers.model;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBScanExpression;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.PaginatedScanList;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

import java.util.List;

/**
 * Created by nandinivishwas on 08/02/16.
 */

@DynamoDBTable(tableName = "Campground")
public class Campground {

    /* ToDo: Set up a data model for Campground, info to include are campground name, number of campsites,
    campgroundId, campgroundName,datesOpen,numberCampsites, bathroomType,  dumpStation, fee,  reserveSite, rvHookup, shower
    */

    private Integer campgroundId;
    private String campgroundName;
    private String datesOpen;
    private Integer numCampsites;
    private String bathroomType;
    private Boolean dumpStation;
    private Integer fee;
    private Boolean shower;
    private Boolean reserveSite;
    private String rvHookup;

    @DynamoDBAttribute(attributeName = "campgroundId")
    public Integer getCampgroundId() {
        return campgroundId;
    }

    public void setCampgroundId(Integer campgroundId) {
        this.campgroundId = campgroundId;
    }

    @DynamoDBAttribute(attributeName = "campgroundName")
    public String getCampgroundName() {
        return campgroundName;
    }

    public void setCampgroundName(String campgroundName) {
        this.campgroundName = campgroundName;
    }

    @DynamoDBAttribute(attributeName = "datesOpen")
    public String getDatesOpen() {
        return datesOpen;
    }

    public void setDatesOpen(String datesOpen) {
        this.datesOpen = datesOpen;
    }

    @DynamoDBAttribute(attributeName = "numberCampsites")
    public Integer getNumCampsites() {
        return numCampsites;
    }

    public void setNumCampsites(Integer numCampsites) {
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
    public Boolean getDumpStation() {
        return dumpStation;
    }

    public void setDumpStation(Boolean dumpStation) {
        this.dumpStation = dumpStation;
    }

    @DynamoDBAttribute(attributeName = "fee")
    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    @DynamoDBAttribute(attributeName = "shower")
    public Boolean getShower() {
        return shower;
    }

    public void setShower(Boolean shower) {
        this.shower = shower;
    }

    @DynamoDBAttribute(attributeName = "reserveSite")
    public Boolean getReserveSite() {
        return reserveSite;
    }

    public void setReserveSite(Boolean reserveSite) {
        this.reserveSite = reserveSite;
    }

    @DynamoDBAttribute(attributeName = "rvHookup")
    public String getRvHookup() {
        return rvHookup;
    }

    public void setRvHookup(String rvHookup) {
        this.rvHookup = rvHookup;
    }
}
