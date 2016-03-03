package projects.android.socialcampers.DBOperations;


import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBQueryExpression;

import java.util.ArrayList;
import java.util.List;

import projects.android.socialcampers.model.Review;

public class GetReview extends BaseDdbOperation{

    // Scan Review table look for parkNamecampgroundName Partition (Hash) key to get list of all reviews

    public List<Review> scanReviews(String parkNamecampgroundName) {

        ArrayList<Object> itemsToGet = new ArrayList<>();
        Review review = new Review();
        review.setParkNamecampgroundName(parkNamecampgroundName);
        itemsToGet.add(review);
        DynamoDBQueryExpression<Review> query = new DynamoDBQueryExpression<Review>().withHashKeyValues(review);

        return mapper.query(Review.class, query);
    }


}
