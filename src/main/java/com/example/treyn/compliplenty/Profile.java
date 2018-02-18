<<<<<<< HEAD
package com.example.treyn.compliplenty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Profile extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);

        Button editProfile, contacts, viewLikeList;

        editProfile = (Button) findViewById(R.id.icon_settings);
        contacts = (Button) findViewById(R.id.icon_contacts);
        viewLikeList = (Button) findViewById(R.id.icon_likelist);
        TextView txtView = (TextView) findViewById(R.id.icon_profile_picture);
        String s = getIntent().getStringExtra("NEW_BIO");
        txtView.setText(s);

        editProfile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    Intent intent;
                    intent = new Intent(Profile.this, EditProfile.class);
                    Profile.this.startActivity(intent);
            }
        });

        contacts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(Profile.this, ContactsList.class);
                Profile.this.startActivity(intent);
            }
        });

        viewLikeList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(Profile.this, "Like List", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
=======
package com.example.treyn.compliplenty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Profile extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);

        Button editProfile, contacts, viewLikeList;

        editProfile = (Button) findViewById(R.id.icon_settings);
        contacts = (Button) findViewById(R.id.icon_contacts);
        viewLikeList = (Button) findViewById(R.id.icon_likelist);
        TextView txtView = (TextView) findViewById(R.id.icon_profile_picture);
        String s = getIntent().getStringExtra("NEW_BIO");
        txtView.setText(s);

        editProfile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    Intent intent;
                    intent = new Intent(Profile.this, EditProfile.class);
                    Profile.this.startActivity(intent);
            }
        });

        contacts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(Profile.this, ContactsList.class);
                Profile.this.startActivity(intent);
            }
        });

        viewLikeList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(Profile.this, "Like List", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
>>>>>>> bbf0a9bd50bef39a3125b84005b78408e6a7ca07
