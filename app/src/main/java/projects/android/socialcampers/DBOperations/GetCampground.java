package projects.android.socialcampers.DBOperations;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBQueryExpression;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBScanExpression;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.PaginatedScanList;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

import java.util.ArrayList;
import java.util.List;
import projects.android.socialcampers.model.Campground;

/**
 * Created by nandinivishwas on 08/02/16.
 * data model for campground
 */

public class GetCampground extends BaseDdbOperation {

    // Scan Campground table look for campgroundName

    public List<Campground> scanCampgrounds(String parkName) {

        ArrayList<Object> itemsToGet = new ArrayList<>();
        Campground cg = new Campground();
        cg.setParkName(parkName);
        itemsToGet.add(cg);
        DynamoDBQueryExpression<Campground> query = new DynamoDBQueryExpression<Campground>().withHashKeyValues(cg);

        return mapper.query(Campground.class, query);
    }

}
