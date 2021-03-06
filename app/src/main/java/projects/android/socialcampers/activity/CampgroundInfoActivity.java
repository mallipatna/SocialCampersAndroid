package projects.android.socialcampers.activity;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

import projects.android.socialcampers.DBOperations.GetCampground;

public class CampgroundInfoActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campground_info);

        Intent intent = getIntent();
        final String campgroundName = intent.getExtras().getString("campgroundname");
        final String parkName = intent.getExtras().getString("parkname");
        final String username = intent.getExtras().getString("username");
        final String userId = intent.getExtras().getString("userId");
        final String authToken = intent.getExtras().getString("authToken");

        TextView tv_campground_name = (TextView) findViewById(R.id.campground_name_info);
        tv_campground_name.setText(campgroundName.toUpperCase() + " CAMPGROUND DETAILS\n" + parkName.toUpperCase());

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
            fee = e.toString();
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

        // Get AvgRating from GetCampground
        AsyncTask<Void,Void,Double> task9 = new AsyncTask<Void, Void, Double>() {
            @Override
            protected Double doInBackground(Void... params) {
                GetCampground getCampground = new GetCampground();
                return getCampground.avgRating(parkName+":"+campgroundName);
            }
        };

        // Start the method running in background
        String average;
        try {
            average = task9.execute().get().toString();
        }catch (Exception e){
            average = e.toString();
        }

        // Set average to textview rb_rating_bar
        TextView rbAvgRating = (TextView) findViewById(R.id.tv_avg_rating);
        rbAvgRating.setText(average);


        // On Button click go to Review Activity
        Button button = (Button) findViewById(R.id.button_view_review);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get parkName and campgroundName and pass on to next (Review) activity
                Intent intent1 = new Intent(getApplicationContext(), ReviewActivity.class);
                intent1.putExtra("parkName", parkName);
                intent1.putExtra("campgroundName", campgroundName);
                intent1.putExtra("username", username);
                intent1.putExtra("userId", userId);
                intent1.putExtra("authToken", authToken);
                Toast.makeText(getApplicationContext(), "Reviews for " + campgroundName +
                        " Campground\n" + parkName, Toast.LENGTH_LONG).show();
                startActivity(intent1);
            }
        });

        // Go back to campground list activity
        Button button1 = (Button) findViewById(R.id.button_back_camp_list);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), CampgroundListActivity.class);
                intent2.putExtra("parkname",parkName);
                intent2.putExtra("campgroundname",campgroundName);
                intent2.putExtra("username",username);
                intent2.putExtra("userId",userId);
                intent2.putExtra("authToken", authToken);
                startActivity(intent2);
            }
        });

        // On click recommend to a friend using FB api
/*
        Button button2 = (Button) findViewById(R.id.button_fb_share);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTask<Void,Void,Void> fb_task = new AsyncTask<Void,Void,Void>() {

                    @Override
                    protected Void doInBackground(Void... params){

                        FacebookSdk.sdkInitialize(getApplicationContext());
                        //CallbackManager callbackManager = CallbackManager.Factory.create();
                        ShareDialog shareDialog = new ShareDialog(get);
                        if(ShareDialog.canShow(ShareLinkContent.class)){
                            ShareLinkContent linkContent = new ShareLinkContent.Builder()
                                    .setContentTitle("Hello facebook")
                                    .setContentDescription("Implementing facebook share")
                                    .setContentUrl(Uri.parse("http://developers.facebook.com/android"))
                                    .build();
                            shareDialog.show(linkContent);
                        }
                        return null;
                    }

                };
                fb_task.execute();
            }

        });
*/
    }

}
