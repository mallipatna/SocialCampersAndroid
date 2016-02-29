package projects.android.socialcampers.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends Activity{

    private TextView login_result;
    private LoginButton fb_login;

    private CallbackManager callbackManager;

    // Called when the activity is first created
    @Override
    public void onCreate(Bundle savedInstance) {

        super.onCreate(savedInstance);

        FacebookSdk.sdkInitialize(getApplicationContext());

        callbackManager = CallbackManager.Factory.create();

        setContentView(R.layout.activity_main);

        login_result = (TextView) findViewById(R.id.login_result);
        fb_login = (LoginButton) findViewById(R.id.fb_login);

        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        if(accessToken!=null) {
            String userID = AccessToken.getCurrentAccessToken().getUserId();
            String authToken = AccessToken.getCurrentAccessToken().getToken();
            Intent intent = new Intent(getApplicationContext(), ParkActivity.class);
            intent.putExtra("userID", userID);
            intent.putExtra("authToken", authToken);
            startActivity(intent);
        }

        fb_login.setReadPermissions("me");
        fb_login.setReadPermissions("user_friends");

        fb_login.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {

                String userID = loginResult.getAccessToken().getUserId();
                String authToken = loginResult.getAccessToken().getToken();

                Intent intent = new Intent(getApplicationContext(), ParkActivity.class);
                intent.putExtra("userID",userID);
                intent.putExtra("authToken",authToken);
                startActivity(intent);
                /*login_result.setText("User ID: "
                                    + userID
                                    + "\nAuthToken: "
                                    + authToken); */
            }

            @Override
            public void onCancel() {
                login_result.setText("Login cancelled\nCan't proceed");
            }

            @Override
            public void onError(FacebookException error) {
                login_result.setText(error.toString());
            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

        /*
        Button btnClick = (Button) findViewById(R.id.fb_login);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ParkActivity.class);
                startActivityForResult(intent, 0);
            }
        });
        */


}
