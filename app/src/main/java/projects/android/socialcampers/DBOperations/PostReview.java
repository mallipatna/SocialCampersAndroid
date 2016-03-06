package projects.android.socialcampers.DBOperations;

import projects.android.socialcampers.model.Review;

public class PostReview extends BaseDdbOperation{

    public void postReview(String parkName, String campgroundName,
                           String timestamp, String reviewText, Integer rating){

        Review review = new Review();
        review.setParkNamecampgroundName(parkName+":"+campgroundName);
        review.setTimestamp(timestamp);
        review.setReviewText(reviewText);
        review.setRating(rating);
        mapper.save(review);

    }

}
