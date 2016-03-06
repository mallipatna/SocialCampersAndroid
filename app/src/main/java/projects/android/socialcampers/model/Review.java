package projects.android.socialcampers.model;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

@DynamoDBTable(tableName = "Review")
public class Review {

    private String parkNamecampgroundName;
    private String timestamp;
    private String userName;
    private String reviewText;
    private int rating;

    @DynamoDBHashKey(attributeName = "parkName:campgroundName")
    public String getParkNamecampgroundName() {
        return parkNamecampgroundName;
    }

    public void setParkNamecampgroundName(String parkNamecampgroundName) {
        this.parkNamecampgroundName = parkNamecampgroundName;
    }

    @DynamoDBRangeKey(attributeName = "timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @DynamoDBAttribute(attributeName = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @DynamoDBAttribute(attributeName = "reviewText")
    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    @DynamoDBAttribute(attributeName = "rating")
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format("Review by %s\nRating: %d\n%s", userName, rating, reviewText);
    }
}
