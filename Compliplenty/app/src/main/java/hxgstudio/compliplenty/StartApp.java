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
import com.facebook.login.LoginManager;
import com.facebook.login.widget.LoginButton;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareButton;
import com.facebook.share.widget.ShareDialog;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;



public class StartApp extends AppCompatActivity {

    private TextView info, mainCompliment;
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private ShareDialog shareDialog;







    public static final String COMPLIMENT = "compliments";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callbackManager = CallbackManager.Factory.create();
        shareDialog = new ShareDialog(this);

        setContentView(R.layout.activity_startapp);
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Bundle bundle = getIntent().getExtras();
        String qCompliment= bundle.getString("compliment");



        mainCompliment = (TextView)findViewById(R.id.main_compliment);
        if(qCompliment != null)
            mainCompliment.setText(qCompliment);


        Button profile, logout, contacts, up, share, down, question, random;
        profile = (Button) findViewById(R.id.icon_profile);

        callbackManager = CallbackManager.Factory.create();
        logout = (LoginButton) findViewById(R.id.login_button);
        info = (TextView) findViewById(R.id.info);

        contacts = (Button) findViewById(R.id.icon_contacts);
        up = (Button) findViewById(R.id.icon_up);

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

        logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                LoginManager.getInstance().logOut();
                Intent login = new Intent(StartApp.this, LogIn.class);
                        startActivity(login);
                finish();
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
                Toast.makeText(StartApp.this, "Upvoted!!", Toast.LENGTH_SHORT).show();//TODO
                String pulledQuote = "you perty";
                Intent intent = new Intent(getBaseContext(), LikeList.class);
                intent.putExtra("quote",pulledQuote);
                startActivity(intent);
            }
        });

        ShareButton shareButton = (ShareButton) findViewById(R.id.icon_share);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareLinkContent content = new ShareLinkContent.Builder().build();
                shareDialog.show(content);

                    /*if (ShareDialog.canShow(ShareLinkContent.class)) {
                    ShareLinkContent content = new ShareLinkContent.Builder()
                            .setShareHashtag(new ShareHashtag.Builder()
                                    .setHashtag("#Compliplenty")
                            .build())
                            .setQuote("A compliment a day, keeps the sadness at bay")
                            .build();
                    shareDialog.show(content);*/
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
    //delimiter for
    public void AddCompliment(){
        Map<String, Object> compliment = new HashMap<>();
        compliment.put(COMPLIMENT, "test string");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }


    private FacebookCallback<Sharer.Result> callback = new FacebookCallback<Sharer.Result>() {
        @Override
        public void onSuccess(Sharer.Result result) {
        }

        @Override
        public void onCancel() {
        }

        @Override
        public void onError(FacebookException error) {
        }
    };
}
