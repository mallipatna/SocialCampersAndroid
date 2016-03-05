package projects.android.socialcampers.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import projects.android.socialcampers.activity.R;

public class WriteReviewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_review);

        Intent intent = getIntent();
        final String parkname = intent.getExtras().getString("parkname");
        final String campgroundname = intent.getExtras().getString("campgroundname");
        final String username = intent.getExtras().getString("username");

        TextView textView1 = (TextView) findViewById(R.id.tv_review_for);
        textView1.setText("WRITE REVIEW FOR\n"+campgroundname.toUpperCase()+" CAMPGROUND,\n "+parkname.toUpperCase());

        TextView textView2 = (TextView) findViewById(R.id.tv_username);
        textView2.setText(username);

        // TODO: Capture review text, rating from click of submit button
        // TODO: Add parkname:campgroundname, reviewID, reviewtext, rating,
        // TODO: username attributes to DynamoDB through PostReview class

      }

}
