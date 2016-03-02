package projects.android.socialcampers.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import projects.android.socialcampers.DBOperations.GetCampground;

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

        // Get datesOpen from GetCampground
        AsyncTask<Void,Void,String> task1 = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                GetCampground getCampground = new GetCampground();
                return getCampground.datesOpen(parkName,campgroundName);
            }
        };

        // Start the method running in background
        String datesOpen;
        try {
            datesOpen = task1.execute().get();
        }catch (Exception e){
            datesOpen = e.getMessage();
        }

        // Set datesOpen to textview tv_dates_open
        TextView tvDatesOpen = (TextView) findViewById(R.id.tv_dates_open);
        tvDatesOpen.setText(datesOpen);


        // Get numberOfCampsites from GetCampground
        AsyncTask<Void,Void,Integer> task2 = new AsyncTask<Void, Void, Integer>() {
            @Override
            protected Integer doInBackground(Void... params) {
                GetCampground getCampground = new GetCampground();
                return getCampground.numOfCampsites(parkName, campgroundName);
            }
        };

        // Start the method running in background
        String numOfCampsites;
        try {
            numOfCampsites = task2.execute().get().toString();
        }catch (Exception e){
            numOfCampsites = e.getMessage();
        }

        // Set numOfCampsites to textview tv_num_campsites
        TextView tvNumCampsites = (TextView) findViewById(R.id.tv_num_campsites);
        tvNumCampsites.setText(numOfCampsites);


        // Get fee from GetCampground
        AsyncTask<Void,Void,Double> task3 = new AsyncTask<Void, Void, Double>() {
            @Override
            protected Double doInBackground(Void... params) {
                GetCampground getCampground = new GetCampground();
                return getCampground.fee(parkName, campgroundName);
            }
        };

        // Start the method running in background
        String fee;
        try {
            fee = task3.execute().get().toString();
        }catch (Exception e){
            fee = e.getMessage();
        }

        // Set fee to textview tv_fee
        TextView tvfee = (TextView) findViewById(R.id.tv_fee);
        tvfee.setText(fee);


        // Get reservations from GetCampground
        AsyncTask<Void,Void,Boolean> task4 = new AsyncTask<Void, Void, Boolean>() {
            @Override
            protected Boolean doInBackground(Void... params) {
                GetCampground getCampground = new GetCampground();
                return getCampground.reservation(parkName, campgroundName);
            }
        };

        // Start the method running in background
        String reservation;
        try {
            if(task4.execute().get().toString().equals("false")){
                reservation = "No";
            } else{
                reservation = "Yes";
            }

        }catch (Exception e){
            reservation = e.getMessage();
        }

        // Set reserveSite to textview tv_reservations
        TextView tvReservation = (TextView) findViewById(R.id.tv_reservations);
        tvReservation.setText(reservation);


        // Get BathroomType from GetCampground
        AsyncTask<Void,Void,String> task5 = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                GetCampground getCampground = new GetCampground();
                return getCampground.bathType(parkName, campgroundName);
            }
        };

        // Start the method running in background
        String bathType;
        try {
            bathType = task5.execute().get().toString();

        }catch (Exception e){
            bathType = e.getMessage();
        }

        // Set bathType to textview tv_bath_type
        TextView tvBathType = (TextView) findViewById(R.id.tv_bath_type);
        tvBathType.setText(bathType);


        // Get Shower from GetCampground
        AsyncTask<Void,Void,Boolean> task6 = new AsyncTask<Void, Void, Boolean>() {
            @Override
            protected Boolean doInBackground(Void... params) {
                GetCampground getCampground = new GetCampground();
                return getCampground.shower(parkName, campgroundName);
            }
        };

        // Start the method running in background
        String shower;
        try {
            if(task6.execute().get().toString().equals("false")){
                shower = "No";
            } else{
                shower = "Yes";
            }
        }catch (Exception e){
            shower = e.getMessage();
        }

        // Set shower to textview tv_shower
        TextView tvShower = (TextView) findViewById(R.id.tv_shower);
        tvShower.setText(shower);


        // Get RVHookup from GetCampground
        AsyncTask<Void,Void,Boolean> task7 = new AsyncTask<Void, Void, Boolean>() {
            @Override
            protected Boolean doInBackground(Void... params) {
                GetCampground getCampground = new GetCampground();
                return getCampground.rvHookup(parkName, campgroundName);
            }
        };

        // Start the method running in background
        String rvHookup;
        try {
            if(task7.execute().get().toString().equals("false")){
                rvHookup = "No";
            } else{
                rvHookup = "Yes";
            }
        }catch (Exception e){
            rvHookup = e.getMessage();
        }

        // Set rvHookup to textview tv_rvHookup
        TextView tvRvHookup = (TextView) findViewById(R.id.tv_rvHookup);
        tvRvHookup.setText(rvHookup);


        // Get DumpStation from GetCampground
        AsyncTask<Void,Void,Boolean> task8 = new AsyncTask<Void, Void, Boolean>() {
            @Override
            protected Boolean doInBackground(Void... params) {
                GetCampground getCampground = new GetCampground();
                return getCampground.dumpStation(parkName, campgroundName);
            }
        };

        // Start the method running in background
        String dumpStation;
        try {
            if(task8.execute().get().toString().equals("false")){
                dumpStation = "No";
            } else{
                dumpStation = "Yes";
            }
        }catch (Exception e){
            dumpStation = e.getMessage();
        }

        // Set dumpStation to textview tv_dump_station
        TextView tvdumpStation = (TextView) findViewById(R.id.tv_dump_station);
        tvdumpStation.setText(dumpStation);



    }

}
