package projects.android.socialcampers.credentials;

// AWS Dynamo DB imports

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.internal.StaticCredentialsProvider;

import java.io.File;

public class Credentials  {

    public AWSCredentialsProvider getCredentials() {

        try {
            AWSCredentials credentials = new BasicAWSCredentials(AwsCred.awsAccessKey, AwsCred.awsSecretKey);
            AWSCredentialsProvider credentialsProvider = new StaticCredentialsProvider(credentials);
            return credentialsProvider;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
