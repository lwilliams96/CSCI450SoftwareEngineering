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
import java.util.Random;


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
        final String qCompliment= bundle.getString("compliment");


        String quescomp = getIntent().getStringExtra("compliment");
        mainCompliment = (TextView)findViewById(R.id.main_compliment);
        if(quescomp != null){
            mainCompliment.setText(quescomp);
            //Toast.makeText(StartApp.this, "working", Toast.LENGTH_SHORT).show();
        }
        //if(qCompliment != null) {
            //String backup = mainCompliment.getText().toString();
        //}


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
                String pulledQuote;
                if(qCompliment == null){
                    String backup = mainCompliment.getText().toString();
                    pulledQuote = backup;
                }else {
                    //Toast.makeText(StartApp.this, "Upvoted!!" + qCompliment, Toast.LENGTH_SHORT).show();//TODO
//                String pulledQuote = "you perty";
                    pulledQuote = qCompliment;
                }


                Intent intent = new Intent(getBaseContext(), LikeList.class);
                intent.putExtra("quote", pulledQuote);
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
        random.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                int randValue;
                Random r = new Random();
                randValue = (r.nextInt(51 - 1) + 1);

                switch (randValue) {
                    case 0:

                        mainCompliment.setText("I just wanted to tell you that you’re absolutely gorgeous and I hope you have a great day! I would’ve felt horrible if I missed the opportunity to tell you that!");
                        break;

                    case 1:

                        mainCompliment.setText("You should be so proud of who you are. Not many people out there are as genuine or have the kind of heart that you do. Be so proud of that, and realize anyone in this world would be lucky enough to have you in theirs.");
                        break;
                    case 2:

                        mainCompliment.setText("You are the light that guides my way ");
                        break;

                    case 3:

                        mainCompliment.setText("Your voice is music to my ears ");
                        break;

                    case 4:

                        mainCompliment.setText("You shine bright like a diamond");
                        break;

                    case 5:

                        mainCompliment.setText("Everyone should be more like you!");
                        break;

                    case 6:

                        mainCompliment.setText("You just be you, and everything will work out.");
                        break;

                    case 7:

                        mainCompliment.setText("Most people have to work to be cool, you just are.");
                        break;

                    case 8:

                        mainCompliment.setText("Don’t let the haters get you down, they’re just jealous.");
                        break;

                    case 9:

                        mainCompliment.setText("Not every compliment you'll get will be great, unlike you.");
                        break;

                    case 10:

                        mainCompliment.setText("Birds fly, sun shines, grass grows, and you, you win.");
                        break;

                    case 11:

                        mainCompliment.setText("This box isn’t large enough to list all your positive features.");
                        break;

                    case 12:

                        mainCompliment.setText("Anything you set your mind to is within your grasp, you're just that good.");
                        break;

                    case 13:

                        mainCompliment.setText("Mirrors give you a great view.");
                        break;

                    case 14:

                        mainCompliment.setText("Everyday with you is perfect");
                        break;

                    case 15:

                        mainCompliment.setText("If you were a compliment, you’d be the best one on our list");
                        break;

                    case 16:

                        mainCompliment.setText("Not everyone is a gem, but not everyone is you");
                        break;

                    case 17:

                        mainCompliment.setText("The stars have nothing on how bright you shine");
                        break;

                    case 18:

                        mainCompliment.setText("You’re so great, this app can’t process your greatness!");
                        break;

                    case 19:

                        mainCompliment.setText("With you, every loss is a win, and every win is all the more sweeter");
                        break;

                    case 20:

                        mainCompliment.setText("Every moment is a Kodak moment with you");
                        break;

                    case 21:

                        mainCompliment.setText("I’ll never run out of nice things to say about someone like you");
                        break;

                    case 22:

                        mainCompliment.setText("You are the sun that brightens my world.");
                        break;

                    case 23:

                        mainCompliment.setText("I forget a million things each day, but I could never forget you");
                        break;

                    case 24:

                        mainCompliment.setText("You are the wind beneath my wings, you make me soar gracefully");
                        break;

                    case 25:

                        mainCompliment.setText("I’d go anywhere just to see you ");
                        break;

                    case 26:

                        mainCompliment.setText("I hope you never stop smiling because when you smile I smile");
                        break;

                    case 27:

                        mainCompliment.setText("You’re plans are the best");
                        break;

                    case 28:

                        mainCompliment.setText("Paradise is wherever you are");
                        break;

                    case 29:

                        mainCompliment.setText("When your around, I know things will turn out alright");
                        break;

                    case 30:

                        mainCompliment.setText("The stars have nothing on how bright you shine");
                        break;

                    case 31:

                        mainCompliment.setText("You are a star");
                        break;

                    case 32:

                        mainCompliment.setText("You’re like caffeine, addictive, and satisfying at all times");
                        break;

                    case 33:

                        mainCompliment.setText("You are the morning sun on my cloudiest of days");
                        break;

                    case 34:

                        mainCompliment.setText("You must be a rock concert, because you rock my world");
                        break;

                    case 35:

                        mainCompliment.setText("Let me spell it out for you: Y O U A R E T H E B E S T");
                        break;

                    case 36:

                        mainCompliment.setText("You are the morning sun on my cloudiest of days");
                        break;

                    case 37:

                        mainCompliment.setText("Sometimes I want to shrink you down and put you in my pocket and carry you around, and hopefully not forget you there when I wash it ");
                        break;

                    case 38:

                        mainCompliment.setText("You shine bright like a diamond ");
                        break;

                    case 39:

                        mainCompliment.setText("You are like the swan, majestic, and royal");
                        break;

                    case 40: //Romantic Lines

                        mainCompliment.setText("Baby you’re picture perfect");
                        break;

                    case 41:

                        mainCompliment.setText("If this was tennis everything would be all love");
                        break;

                    case 42:

                        mainCompliment.setText("If it was you and me I’d be happy for a lifetime ");
                        break;

                    case 43:

                        mainCompliment.setText("Are you the sun? Because you’re the center of my universe");
                        break;

                    case 44:

                        mainCompliment.setText("If there was a ruler to measure our love it would stretch to pluto and back ");
                        break;

                    case 45:

                        mainCompliment.setText("They say every rose has its thorns, but you are more like a silk rose");
                        break;

                    case 46:

                        mainCompliment.setText("If you were a movie it would be called love actually ");
                        break;

                    case 47:

                        mainCompliment.setText("You are the spark, that ignites my soul");
                        break;

                    case 48:

                        mainCompliment.setText("Are you the sun? Because you’re the center of my universe");
                        break;

                    case 49:

                        mainCompliment.setText("If I could rearrange the alphabet, I’d put U and I together");
                        break;

                    case 50:

                        mainCompliment.setText("You’re like the hope diamond, beautiful, and valuable");
                        break;


                    default:
                        mainCompliment.setText("Compliment Display Error");

                }
                //Toast.makeText(StartApp.this, "Random Compliment (Change text above)", Toast.LENGTH_SHORT).show();

            };
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
