package projects.android.socialcampers.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import projects.android.socialcampers.DBOperations.GetCampground;
import projects.android.socialcampers.DBOperations.GetReview;
import projects.android.socialcampers.model.Campground;
import projects.android.socialcampers.model.Review;

public class ReviewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        Intent intent = getIntent();
        final String parkName = intent.getExtras().getString("parkName");
        final String campgroundName = intent.getExtras().getString("campgroundName");

        TextView textView_parkName = (TextView) findViewById(R.id.park_name_in_review);
        textView_parkName.setText(parkName);

        TextView textView_campgroundName = (TextView) findViewById(R.id.campground_name_in_review);
        textView_campgroundName.setText(campgroundName + " Campground");

        final String parkCampgroundName = parkName + ":" + campgroundName;

        // Populate list with reviews from DynamoDB
        AsyncTask<Void, Void, List<Review>> task = new AsyncTask<Void, Void, List<Review>>() {
            @Override
            protected List<Review> doInBackground(Void... params) {
                GetReview getReview = new GetReview();
                List<Review> reviewList = getReview.scanReviews(parkCampgroundName);

                List<Integer> reviewIdList = new ArrayList<>();
                for (Review review : reviewList){
                    reviewIdList.add(review.getReviewId());
                }
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

        // Get position of item clicked
       /* listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            // Click on an element in view and it should go to another activity
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Click on an element in view and it should go to another activity
                String tag = listView.getAdapter().getItem(position).toString();
                Toast.makeText(getApplicationContext(),tag , Toast.LENGTH_LONG).show();

            }

        });
       */

    }

}
