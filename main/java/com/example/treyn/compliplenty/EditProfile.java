<<<<<<< HEAD
package com.example.treyn.compliplenty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.treyn.compliplenty.R.id.editBio;

public class EditProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        Button saveChanges, takeNewProfilePic, chooseNewPic;

        takeNewProfilePic = (Button) findViewById(R.id.takeNewProfilePic);
        chooseNewPic = (Button) findViewById(R.id.choosePhoto);

        takeNewProfilePic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent;
                intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent);
            }
        });

        chooseNewPic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
            }
        });
    }

    public void saveChanges(View v){
        String newBio = findViewById(R.id.editBio);
        Intent intent = new Intent(EditProfile.this, Profile.class);
        intent.putExtra("NEW_BIO", newBio);
    }


}
=======
package com.example.treyn.compliplenty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.treyn.compliplenty.R.id.editBio;

public class EditProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        Button saveChanges, takeNewProfilePic, chooseNewPic;

        takeNewProfilePic = (Button) findViewById(R.id.takeNewProfilePic);
        chooseNewPic = (Button) findViewById(R.id.choosePhoto);

        takeNewProfilePic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent;
                intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent);
            }
        });

        chooseNewPic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
            }
        });
    }

    public void saveChanges(View v){
        String newBio = findViewById(R.id.editBio);
        Intent intent = new Intent(EditProfile.this, Profile.class);
        intent.putExtra("NEW_BIO", newBio);
    }


}
>>>>>>> bbf0a9bd50bef39a3125b84005b78408e6a7ca07
