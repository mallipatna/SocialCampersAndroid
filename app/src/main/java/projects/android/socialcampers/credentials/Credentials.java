package projects.android.socialcampers.credentials;

// AWS Dynamo DB imports

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.internal.StaticCredentialsProvider;

public class Credentials  {

    public AWSCredentialsProvider getCredentials() {
        AWSCredentials credentials = new BasicAWSCredentials("AKIAJXONVB7TI2WMVR7A", "Bjn+bFv0PFmZXIuEdsc2CUbdDFrlQC5c2K4VA6TW");
        AWSCredentialsProvider credentialsProvider = new StaticCredentialsProvider(credentials);
        return credentialsProvider;
    }

    // Create a DynamoDB client and object mapper

    /*public List<Park> scanParks() {
        AmazonDynamoDBClient ddbClient = new AmazonDynamoDBClient(getCredentials());
        DynamoDBMapper mapper = new DynamoDBMapper(ddbClient);
        ddbClient.setRegion(Region.getRegion(Regions.US_WEST_2));
        PaginatedScanList<Park> result = mapper.scan(Park.class, new DynamoDBScanExpression());
        return result;
    }
    */

}
