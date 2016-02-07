package projects.android.socialcampers.activity;

import android.app.Activity;
import android.os.Bundle;

public class ParkInfoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_info);

        // ToDo: Pass parkName and get all park info from DynamoDB

    }

}
