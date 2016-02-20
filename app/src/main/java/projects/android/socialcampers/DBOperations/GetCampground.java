package projects.android.socialcampers.DBOperations;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBScanExpression;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.PaginatedScanList;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

import java.util.List;

import projects.android.socialcampers.credentials.Credentials;
import projects.android.socialcampers.model.Campground;
import projects.android.socialcampers.model.Park;

/**
 * Created by nandinivishwas on 08/02/16.
 * data model for campground
 */

public class GetCampground {

    // Scan Campground table look for campgroundName

/*    Credentials c = new Credentials();

    public List<Campground> scanCampgrounds(String parkName) {
        AmazonDynamoDBClient ddbClient = new AmazonDynamoDBClient(c.getCredentials());
        DynamoDBMapper mapper = new DynamoDBMapper(ddbClient);
        ddbClient.setRegion(Region.getRegion(Regions.US_WEST_2));

        PaginatedScanList<Park> result = mapper.scan(Park.class, new DynamoDBScanExpression());
        return result;
    }
*/

}
