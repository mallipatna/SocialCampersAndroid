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

public class GetPark {

    Credentials c = new Credentials();

    // Create a DynamoDB client and object mapper

    public List<Park> scanParks() {
        AmazonDynamoDBClient ddbClient = new AmazonDynamoDBClient(c.getCredentials());
        DynamoDBMapper mapper = new DynamoDBMapper(ddbClient);
        ddbClient.setRegion(Region.getRegion(Regions.US_WEST_2));
        PaginatedScanList<Park> result = mapper.scan(Park.class, new DynamoDBScanExpression());
        return result;
    }

    /*public String Parks() {
        AmazonDynamoDBClient ddbClient = new AmazonDynamoDBClient(c.getCredentials());
        DynamoDBMapper mapper = new DynamoDBMapper(ddbClient);
        ddbClient.setRegion(Region.getRegion(Regions.US_WEST_2));
        PaginatedScanList<Park> result = mapper.scan(Park.class, new DynamoDBScanExpression());
        return result;
    }*/

}
