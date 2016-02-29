package projects.android.socialcampers.DBOperations;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

import projects.android.socialcampers.credentials.Credentials;

/**
 * Created by nandinivishwas on 28/02/16.
 */
public class BaseDdbOperation {

    // Create a DynamoDB client and object mapper
    protected final DynamoDBMapper mapper;

    public BaseDdbOperation() {
        Credentials c = new Credentials();
        AmazonDynamoDBClient ddbClient = new AmazonDynamoDBClient(c.getCredentials());
        mapper = new DynamoDBMapper(ddbClient);
        ddbClient.setRegion(Region.getRegion(Regions.US_EAST_1));
    }
}
