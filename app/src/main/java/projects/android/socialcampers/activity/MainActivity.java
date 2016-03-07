package projects.android.socialcampers.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
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

        final AccessToken accessToken = AccessToken.getCurrentAccessToken();

        final Button btnClick = (Button) findViewById(R.id.button_click_continue);

        fb_login.setReadPermissions("me");
            fb_login.setReadPermissions("user_friends");

            fb_login.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

                @Override
                public void onSuccess(LoginResult loginResult) {

                    login_result.setText("Login success");

                    btnClick.setClickable(true);

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


            btnClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String userID = AccessToken.getCurrentAccessToken().getUserId();
                    String authToken = AccessToken.getCurrentAccessToken().getToken();
                    Intent intent = new Intent(getApplicationContext(), ParkActivity.class);
                    Profile profile = Profile.getCurrentProfile();
                    if (profile != null) {
                        String username = profile.getFirstName() + " " + profile.getLastName();
                        intent.putExtra("username", username);
                        login_result.setText("Logged in user: "+username);
                        Toast.makeText(getApplicationContext(),username, Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), " ", Toast.LENGTH_LONG).show();
                    }
                    intent.putExtra("userID", userID);
                    intent.putExtra("authToken", authToken);

                    startActivity(intent);

                }
            });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

}
