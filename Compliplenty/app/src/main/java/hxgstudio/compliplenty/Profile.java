package hxgstudio.compliplenty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);

        Button editProfile, contacts, viewLikeList;

        editProfile = (Button) findViewById(R.id.icon_settings);
        contacts = (Button) findViewById(R.id.icon_contacts);
        viewLikeList = (Button) findViewById(R.id.icon_likelist);

        editProfile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(Profile.this, "Edit Profile", Toast.LENGTH_SHORT).show();
            }
        });

        contacts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(Profile.this, ContactsList.class);
                Profile.this.startActivity(intent);
            }
        });

        final Intent profileToLikeList = new Intent (this, LikeList.class);
        viewLikeList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String putExtraHelper;
                ArrayList<String> listOfLikes = new ArrayList<String>();
                for(int i = 0; i < listOfLikes.size(); i++) {
                    putExtraHelper = "Compliment ";
                    putExtraHelper = putExtraHelper + i;
                    profileToLikeList.putExtra(putExtraHelper, "" + listOfLikes.get(i));
                }
                Toast.makeText(Profile.this, "Like List", Toast.LENGTH_SHORT).show();
                startActivity(profileToLikeList);
            }
        });

    }
}
