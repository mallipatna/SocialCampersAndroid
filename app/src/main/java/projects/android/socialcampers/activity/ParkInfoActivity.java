package projects.android.socialcampers.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import projects.android.socialcampers.DBOperations.GetCampground;
import projects.android.socialcampers.DBOperations.GetPark;
import projects.android.socialcampers.model.Campground;
import projects.android.socialcampers.model.Park;

public class ParkInfoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_info);

        // Get parkname from prev (Park) Activity
        final Intent intent = getIntent();
        final String parkname = intent.getExtras().getString("parkname");
        final String username = intent.getExtras().getString("username");
        final String userId = intent.getExtras().getString("userId");
        final String authToken = intent.getExtras().getString("authToken");

        TextView parknameininfo = (TextView) findViewById(R.id.park_name_in_info);
        parknameininfo.setText(parkname.toUpperCase());

        // Get about for parkname
        AsyncTask<Void,Void,String> task1 = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                GetPark getPark = new GetPark();
                String about = getPark.about(parkname);
                return about;
            }
        };

        String about;

        // execute method running in background
        try {
            about = task1.execute().get();
        } catch (Exception e){
            about = e.getMessage();
        }

        // Set the output to textview within ScrollView in layout
        TextView aboutview = (TextView) findViewById(R.id.textView1);
        aboutview.setMovementMethod(new ScrollingMovementMethod());
        aboutview.append("\n"+about);

        // Get location for parkname
        AsyncTask<Void,Void,String> task2 = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                GetPark getPark = new GetPark();
                String location = getPark.location(parkname);
                return location;
            }
        };

        String location;

        // execute method running in background
        try {
            location = task2.execute().get();
        } catch (Exception e){
            location = e.getMessage();
        }

        // Set the output to textview in layout
        TextView locationview = (TextView) findViewById(R.id.textView2);
        locationview.setText(location);

        // Get bestTimeToVisit for parkname
        AsyncTask<Void,Void,String> task3 = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                GetPark getPark = new GetPark();
                String bestTimeToVisit = getPark.bestTimeToVisit(parkname);
                return bestTimeToVisit;
            }
        };

        String bestTimeToVisit;

        // execute method running in background
        try {
            bestTimeToVisit = task3.execute().get();
        } catch (Exception e){
            bestTimeToVisit = e.getMessage();
        }

        // Set the output to textview in layout
        TextView bestTimeToVisitview = (TextView) findViewById(R.id.textView3);
        bestTimeToVisitview.setText(bestTimeToVisit);

        // Get thingsToDo for parkname
        AsyncTask<Void,Void,String> task4 = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                GetPark getPark = new GetPark();
                String thingsToDo = getPark.thingsToDo(parkname);
                return thingsToDo;
            }
        };

        String thingsToDo;

        // execute method running in background
        try {
            thingsToDo = task4.execute().get();
        } catch (Exception e){
            thingsToDo = e.getMessage();
        }

        // Set the output to textview in layout
        TextView thingsToDoview = (TextView) findViewById(R.id.textView4);
        thingsToDoview.setMovementMethod(new ScrollingMovementMethod());
        thingsToDoview.append(thingsToDo+"\n" );

        // Get places_to_go for parkname
        AsyncTask<Void,Void,String> task5 = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                GetPark getPark = new GetPark();
                String placesToGo = getPark.placesToGo(parkname);
                return placesToGo;
            }
        };

        String placesToGo;

        // execute method running in background
        try {
            placesToGo = task5.execute().get();
        } catch (Exception e){
            placesToGo = e.getMessage();
        }

        // Set the output to textview in layout
        TextView placesToGoview = (TextView) findViewById(R.id.textView5);
        placesToGoview.setMovementMethod(new ScrollingMovementMethod());
        placesToGoview.append(placesToGo + "\n");


        Button button = (Button) findViewById(R.id.button_view_campgrounds_list);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(getApplicationContext(), CampgroundListActivity.class);
                intent1.putExtra("parkname", parkname);
                intent1.putExtra("username",username);
                intent1.putExtra("userId",userId);
                intent1.putExtra("authToken",authToken);
                Toast.makeText(getApplicationContext(), parkname, Toast.LENGTH_SHORT).show();
                startActivity(intent1);

            }
        });

        Button button1 = (Button) findViewById(R.id.button_back_park_list);
        button1.setClickable(true);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(),ParkActivity.class);
                intent2.putExtra("parkname",parkname);
                intent2.putExtra("username",username);
                intent2.putExtra("userId",userId);
                intent2.putExtra("authToken",authToken);
                startActivity(intent2);
            }
        });




    }

}
