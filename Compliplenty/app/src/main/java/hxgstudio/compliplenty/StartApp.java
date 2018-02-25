package hxgstudio.compliplenty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class StartApp extends AppCompatActivity {

    private TextView info;
    private LoginButton loginButton;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_startapp);

        Button profile, logout, contacts, up, share, down, question, random;
        profile = (Button) findViewById(R.id.icon_profile);

        callbackManager = CallbackManager.Factory.create();
        loginButton = (LoginButton)findViewById(R.id.login_button);
        info = (TextView)findViewById(R.id.info);

        contacts = (Button) findViewById(R.id.icon_contacts);
        up = (Button) findViewById(R.id.icon_up);
        share = (Button) findViewById(R.id.icon_share);
        down = (Button) findViewById(R.id.icon_down);
        question = (Button) findViewById(R.id.icon_question);
        random = (Button) findViewById(R.id.icon_random);

        profile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(StartApp.this, Profile.class);
                StartApp.this.startActivity(intent);
            }
        });

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Intent intent;
                intent = new Intent(StartApp.this, LogIn.class);
                StartApp.this.startActivity(intent);
            }

            @Override
            public void onCancel() {
                info.setText("Logout attempt canceled.");
            }

            @Override
            public void onError(FacebookException e) {
                info.setText("Logout attempt failed.");
            }
        });

        contacts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(StartApp.this, ContactsList.class);
                StartApp.this.startActivity(intent);
            }
        });
        up.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(StartApp.this, "Upvoted!!", Toast.LENGTH_SHORT).show();
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(StartApp.this, "Share", Toast.LENGTH_SHORT).show();

            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(StartApp.this, "Downvoted!!", Toast.LENGTH_SHORT).show();
            }
        });
        question.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent;

                intent = new Intent(StartApp.this, Question.class);
                StartApp.this.startActivity(intent);
            }
        });
        random.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(StartApp.this, "Random Compliment (Change text above)", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
