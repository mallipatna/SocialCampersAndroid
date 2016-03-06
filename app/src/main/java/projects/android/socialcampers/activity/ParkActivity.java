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

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.Profile;

import java.util.ArrayList;
import java.util.List;

import projects.android.socialcampers.DBOperations.GetPark;
import projects.android.socialcampers.model.Park;

public class ParkActivity extends Activity {

    /* Called when btnClick is called */
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park);

        final Intent intent = getIntent();
        final String userId = intent.getExtras().getString("userID");
        final String authToken = intent.getExtras().getString("authToken");
        Profile profile = Profile.getCurrentProfile();
        // final String username = intent.getExtras().getString("username");
       final String username = profile.getFirstName() + " " + profile.getLastName();
        /* make the API call
        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/{userId}/friendlists",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {

                        
                    }
                }
        ).executeAsync();
        */

        // TODO: Populate list with user's friends from Facebook

        // Populate list with parks from DynamoDB
        AsyncTask<Void,Void,List<String>> task = new AsyncTask<Void, Void, List<String>>() {
            @Override
            protected List<String> doInBackground(Void... params) {
                GetPark getPark = new GetPark();
                List<Park> parksList = getPark.scanParks();
                List<String> parkNameList = new ArrayList<>();
                for (Park park : parksList) {
                    parkNameList.add(park.getParkName());
                }
                return parkNameList;
            }
        };

        List<String> parkNames;
        try {
            parkNames = task.execute().get();
        } catch (Exception e) {
            parkNames = new ArrayList<>();
        }

        // Build an adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,                                   // Context for the activity
                android.R.layout.simple_list_item_1,    // Layout to use (create)
                parkNames);                             // Items to be displayed

        // Configure the list view
        final ListView listView = (ListView) findViewById(R.id.list_view_park);
        listView.setAdapter(adapter);

        // Get position of item clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            // Click on an element in view and it should go to another activity
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String tag = listView.getAdapter().getItem(position).toString();
                // Click on an element in view and it should go to another activity
                Intent intent1 = new Intent(view.getContext(), ParkInfoActivity.class);
                intent1.putExtra("parkname",tag);
                intent1.putExtra("username",username);
                Toast.makeText(getApplicationContext(), tag + "\nUser: " + username , Toast.LENGTH_LONG).show();
                startActivity(intent1);
            }
        });

        Button button = (Button) findViewById(R.id.button_back_main);
        button.setClickable(true);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(),MainActivity.class);
                intent2.putExtra("userId",userId);
                intent2.putExtra("authToken",authToken);
                intent2.putExtra("username",username);
                startActivity(intent2);
            }
        });
    }
}
