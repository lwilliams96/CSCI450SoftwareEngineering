package hxgstudio.compliplenty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.AccessToken;

public class Initialize extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AccessToken token;
        token = AccessToken.getCurrentAccessToken();

        Intent intent;

        if (token == null) {
            intent = new Intent(Initialize.this, LogIn.class);
            Initialize.this.startActivity(intent);
        }
        else{
            intent = new Intent(Initialize.this, StartApp.class);
            Initialize.this.startActivity(intent);
        }
    }
}
