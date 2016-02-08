package projects.android.socialcampers.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String tag = listView.getAdapter().getItem(position).toString();
                Toast.makeText(getApplicationContext(), tag , Toast.LENGTH_SHORT).show();
                // Click on an element in view and it should go to another activity
                Intent intent = new Intent(view.getContext(), ParkInfoActivity.class);
                intent.putExtra("parkname",tag);
                startActivity(intent);
            }
        });

        //displayParkInfo();
    }


    // Click on an element in view and it should go to another activity
    //public void displayParkInfo(){}


}
