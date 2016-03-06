package projects.android.socialcampers.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import projects.android.socialcampers.DBOperations.GetReview;
import projects.android.socialcampers.model.Review;

public class ReviewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        Intent intent = getIntent();
        final String parkName = intent.getExtras().getString("parkName");
        final String campgroundName = intent.getExtras().getString("campgroundName");
        final String username = intent.getExtras().getString("username");

        TextView textView_parkName = (TextView) findViewById(R.id.reviews_for);
        textView_parkName.setText("LIST OF REVIEWS FOR\n"+campgroundName.toUpperCase()+" CAMPGROUND\n"+parkName.toUpperCase());

        final String parkCampgroundName = parkName + ":" + campgroundName;

        // Populate list with reviews from DynamoDB
        AsyncTask<Void, Void, List<Review>> task = new AsyncTask<Void, Void, List<Review>>() {
            @Override
            protected List<Review> doInBackground(Void... params) {
                GetReview getReview = new GetReview();
                List<Review> reviewList = getReview.scanReviews(parkCampgroundName);


                List<String> reviewTextList = new ArrayList<>();
                for (Review review:reviewList){
                    reviewTextList.add(review.getReviewText());
                }
                List<Integer> reviewRatingList = new ArrayList<>();
                for (Review review:reviewList){
                    reviewRatingList.add(review.getRating());
                }
                List<String> reviewUserNameList = new ArrayList<>();
                for (Review review:reviewList){
                    reviewUserNameList.add(review.getUserName());
                }

                return reviewList;
            }
        };


        List<Review> reviews;
        try {
            reviews = task.execute().get();
        } catch (Exception e) {
            reviews = new ArrayList<>();
        }

        // Build an adapter
        ArrayAdapter<Review> adapter = new ArrayAdapter<>(
                this,                                   // Context for the activity
                android.R.layout.simple_list_item_1,    // Layout to use (create)
                reviews);                               // Items to be displayed

        // Configure the list view
        final ListView listView = (ListView) findViewById(R.id.lv_review_list);
        listView.setAdapter(adapter);

        Button button = (Button) findViewById(R.id.button_write_review);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), WriteReviewActivity.class);
                intent1.putExtra("parkname",parkName);
                intent1.putExtra("campgroundname",campgroundName);
                intent1.putExtra("username",username);
                Toast.makeText(getApplicationContext(), "Review for "+
                        campgroundName + " Campground,\n" + parkName +".\nBy: "+ username,Toast.LENGTH_LONG).show();
                startActivity(intent1);
            }
        });

    }

}
