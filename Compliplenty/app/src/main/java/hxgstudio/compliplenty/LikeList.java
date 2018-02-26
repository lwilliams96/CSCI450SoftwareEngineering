package hxgstudio.compliplenty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LikeList extends AppCompatActivity {
    ListView likeListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like_list);

        likeListView = (ListView) findViewById(R.id.likeListView);

        ArrayList<String> arrayOfLikes = new ArrayList<String>();
        Bundle extraGetter = getIntent().getExtras();

        int amountOfLikes = 100;

        if(extraGetter != null) {
            String getExtraHelper;
            for(int i = 0; i < amountOfLikes; i++) {
                getExtraHelper = "Liked ";
                getExtraHelper = getExtraHelper + i;
                arrayOfLikes.add(getExtraHelper);
            }
        }

        ArrayAdapter<String> likeListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, arrayOfLikes);

        likeListView.setAdapter(likeListAdapter);

        likeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                int likePosition = position;
                String compliment = (String) likeListView.getItemAtPosition(position);

                Toast.makeText(getApplicationContext(), "Position: " + likePosition + "\tCompliment: " + compliment, Toast.LENGTH_LONG).show();
            }
        });
    }
}
