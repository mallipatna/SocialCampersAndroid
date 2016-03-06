package projects.android.socialcampers.DBOperations;

import projects.android.socialcampers.model.Review;

public class PostReview extends BaseDdbOperation{

    public void postReview(String parkName, String campgroundName,
                           String timestamp, String reviewText, Double rating, String username){

        Review review = new Review();
        review.setParkNamecampgroundName(parkName+":"+campgroundName);
        review.setTimestamp(timestamp);
        review.setReviewText(reviewText);
        review.setRating(rating);
        review.setUserName(username);
        mapper.save(review);

    }

}
