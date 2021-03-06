package projects.android.socialcampers.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import projects.android.socialcampers.DBOperations.GetCampground;
import projects.android.socialcampers.model.Campground;

public class CampgroundListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campground_list);

        // Get parkname from prev (ParkInfo) Activity
        Intent intent = getIntent();
        final String parkname = intent.getExtras().getString("parkname");
        final String username = intent.getExtras().getString("username");
        final String userId = intent.getExtras().getString("userId");
        final String authToken = intent.getExtras().getString("authToken");

        TextView textView = (TextView) findViewById(R.id.campground_list_name);
        textView.setText("LIST OF CAMPGROUNDS IN\n" + parkname.toUpperCase());

        // Populate list with campgrounds from DynamoDB
        AsyncTask<Void, Void, List<String>> task = new AsyncTask<Void, Void, List<String>>() {
            @Override
            protected List<String> doInBackground(Void... params) {
                GetCampground getCampground = new GetCampground();
                List<Campground> campgroundList = getCampground.scanCampgrounds(parkname);
                List<String> campgroundNameList = new ArrayList<>();
                for (Campground campground : campgroundList) {
                    campgroundNameList.add(campground.getCampgroundName());
                }
                return campgroundNameList;
            }
        };

        List<String> campgroundNames;
        try {
            campgroundNames = task.execute().get();
        } catch (Exception e) {
            campgroundNames = new ArrayList<>();
        }

        // Build an adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,                                   // Context for the activity
                android.R.layout.simple_list_item_1,    // Layout to use (create)
                campgroundNames);                    // Items to be displayed

        // Configure the list view
        final ListView listView = (ListView) findViewById(R.id.lv_campgrounds_list);
        listView.setAdapter(adapter);

        // Get position of item clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            // Click on an element in view and it should go to another activity
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Click on an element in view and it should go to another activity
                String tag = listView.getAdapter().getItem(position).toString();
                Intent intent1 = new Intent(view.getContext(), CampgroundInfoActivity.class);
                intent1.putExtra("parkname", parkname);
                intent1.putExtra("campgroundname", tag);
                intent1.putExtra("username", username);
                intent1.putExtra("userId",userId);
                intent1.putExtra("authToken",authToken);
                Toast.makeText(getApplicationContext(), "Information for " +
                        tag + " Campground,\n" + parkname, Toast.LENGTH_LONG).show();
                startActivity(intent1);
            }

        });

        Button button = (Button) findViewById(R.id.button_back_park_info);
        button.setClickable(true);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), ParkInfoActivity.class);
                intent2.putExtra("parkname", parkname);
                intent2.putExtra("username", username);
                intent2.putExtra("userId",userId);
                intent2.putExtra("authToken",authToken);
                startActivity(intent2);
            }
        });

    }

}
