package projects.android.socialcampers.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import projects.android.socialcampers.DBOperations.GetPark;

public class ParkInfoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_info);
        Intent intent = getIntent();
        final String parkname = intent.getExtras().getString("parkname");

        TextView parknameininfo = (TextView) findViewById(R.id.park_name_in_info);
        parknameininfo.setText(parkname);

        // Get location for parkname
        AsyncTask<Void,Void,String> task1 = new AsyncTask<Void, Void, String>() {
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
            location = task1.execute().get();
        } catch (Exception e){
            location = e.getMessage();
        }

        // Set the output to textview in layout
        TextView locationview = (TextView) findViewById(R.id.textView1);
        locationview.setText(location);

        // Get bestTimeToVisit for parkname
        AsyncTask<Void,Void,String> task2 = new AsyncTask<Void, Void, String>() {
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
            bestTimeToVisit = task2.execute().get();
        } catch (Exception e){
            bestTimeToVisit = e.getMessage();
        }

        // Set the output to textview in layout
        TextView bestTimeToVisitview = (TextView) findViewById(R.id.textView2);
        bestTimeToVisitview.setText(bestTimeToVisit);

        // Get thingsToDo for parkname
        AsyncTask<Void,Void,String> task3 = new AsyncTask<Void, Void, String>() {
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
            thingsToDo = task3.execute().get();
        } catch (Exception e){
            thingsToDo = e.getMessage();
        }

        // Set the output to textview in layout
        TextView thingsToDoview = (TextView) findViewById(R.id.textView3);
        thingsToDoview.setText(thingsToDo);

    }

}
