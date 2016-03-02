package projects.android.socialcampers.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by nandinivishwas on 28/02/16.
 */
public class CampgroundInfoActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campground_info);
        Intent intent = getIntent();
        final String campgroundName = intent.getExtras().getString("campgroundname");
        final String parkName = intent.getExtras().getString("parkname");

        TextView tv_parkName = (TextView) findViewById(R.id.park_name);
        tv_parkName.setText(parkName);

        TextView tv_campground_name = (TextView) findViewById(R.id.campground_name_info);
        tv_campground_name.setText(campgroundName + " Campground Information");


    }

}
