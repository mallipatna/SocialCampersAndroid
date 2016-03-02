package projects.android.socialcampers.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
        Intent intent = getIntent();
        final String parkname = intent.getExtras().getString("parkname");

        TextView parknameininfo = (TextView) findViewById(R.id.park_name_in_info);
        parknameininfo.setText(parkname);

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
        //aboutview.setText(about);
        aboutview.setMovementMethod(new ScrollingMovementMethod());
        aboutview.append("\n"+about);
        //ScrollView aboutScrollView = (ScrollView) findViewById(R.id.ScrollView1);
        //aboutScrollView.addView(aboutview);

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
        //TextView thingsToDoview = (TextView) findViewById(R.id.textView4);
        //thingsToDoview.setText(thingsToDo);

        // Set the output to textview within ScrollView in layout
        //ScrollView thingsToDoScrollView = (ScrollView) findViewById(R.id.ScrollView4);
        TextView thingsToDoview = (TextView) findViewById(R.id.textView4);
        thingsToDoview.setMovementMethod(new ScrollingMovementMethod());
        thingsToDoview.append("\n" + thingsToDo);
        //thingsToDoview.setText(thingsToDo);
        //thingsToDoScrollView.addView(thingsToDoview);

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
        //ScrollView placesToGoScrollview = (ScrollView) findViewById(R.id.ScrollView5);
        TextView placesToGoview = (TextView) findViewById(R.id.textView5);
        placesToGoview.setMovementMethod(new ScrollingMovementMethod());
        placesToGoview.append("\n"+placesToGo);
        //placesToGoview.setText(placesToGo);
        //placesToGoScrollview.addView(placesToGoview);


        // Populate list with campgrounds from DynamoDB
       AsyncTask<Void,Void,List<String>> task = new AsyncTask<Void, Void, List<String>>() {
            @Override
            protected List<String> doInBackground(Void... params) {
                //GetPark getPark = new GetPark();
                GetCampground getCampground = new GetCampground();
                List<Campground> campgroundList = getCampground.scanCampgrounds(parkname);
                List<String> campgroundNameList = new ArrayList<>();
                for (Campground campground: campgroundList){
                    campgroundNameList.add(campground.getCampgroundName());
                }
                //List<Park> parksList = getPark.scanParks();
                return campgroundNameList;
            }
        };

        List<String> campgroundNames;
        try{
            campgroundNames = task.execute().get();
        } catch (Exception e){
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
            String tag1 = listView.getAdapter().getItem(position).toString();
            Intent intent = new Intent(view.getContext(), CampgroundInfoActivity.class);
            intent.putExtra("campgroundname",tag1);
            intent.putExtra("parkname",parkname);
            Toast.makeText(getApplicationContext(), tag1+":"+parkname, Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
    });

}

}
