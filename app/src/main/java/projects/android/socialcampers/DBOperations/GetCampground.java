package projects.android.socialcampers.DBOperations;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

/**
 * Created by nandinivishwas on 08/02/16.
 * data model for campground
 */

@DynamoDBTable(tableName = "Campground")
public class GetCampground {

    /* ToDo: Set up a data model for Campground, info to include are campground name, number of campsites,
       type of bathroom, shower facility, RV hookups.
    */
    private String campgroundName;
    private Integer numCampsites;
    private String bathroom;
    private String shower;
    private String rvHookup;
}
