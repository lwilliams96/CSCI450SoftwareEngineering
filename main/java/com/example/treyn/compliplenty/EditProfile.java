package com.example.treyn.compliplenty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.treyn.compliplenty.R.id.editBio;

public class EditProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
    }

    public void editBio(View v){
        EditText newBio = (EditText)findViewbyId(editBio);
    }
}
