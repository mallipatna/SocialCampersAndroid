package projects.android.socialcampers.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import java.sql.Timestamp;
import java.util.Date;

import projects.android.socialcampers.DBOperations.PostReview;
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

        Date date = new Date();
        TextView textView3 = (TextView) findViewById(R.id.tv_time);
        textView3.setText(new Timestamp(date.getTime()).toString());
        final String timestamp = textView3.getText().toString();

        TextView tv_review_text = (TextView) findViewById(R.id.tf_reviewtext);
        final String review = tv_review_text.getText().toString();

        //RatingBar rb_rating = (RatingBar) findViewById(R.id.rb_rating_write);
        //final Integer rating = rb_rating.getNumStars();
        final Integer rating = 4;

        Button button_submit = (Button) findViewById(R.id.button_submit_review);
        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( rating != 0 ) {
                    PostReview postReview = new PostReview();
                    postReview.postReview(parkname, campgroundname, timestamp, review, rating);
                }
            }
        });
    }
}
