package hxgstudio.compliplenty;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class LikeList extends AppCompatActivity {
    ListView likeListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like_list);
        //makes listview and array of compliments that appear in the view
        likeListView = (ListView) findViewById(R.id.likeListView);
        ArrayList<String> arrayOfLikes = new ArrayList<String>();

        //brings in upvoted compliment from the main screen
        String quote = getIntent().getStringExtra("quote");
        //Toast.makeText(LikeList.this, quote, Toast.LENGTH_SHORT).show();//TODO

        /*load past liked compliments
        SharedPreferences loadArray = PreferenceManager.getDefaultSharedPreferences(this);
        arrayOfLikes.clear();
        int loadSize = loadArray.getInt("Status_Size", 0);
        if(loadSize > 0) {
            for(int i = 0; i < loadSize; i++)
                arrayOfLikes.add(loadArray.getString("Status_" + i, null));
        }*/

        //adds upvoted compliment at the bottom of the listview AFTER loading already liked compliments
        if(quote != null)
            arrayOfLikes.add(quote);

        //makes array appear on screen in the listview
        ArrayAdapter<String> likeListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, arrayOfLikes);
        //arrayOfLikes.add(quote);
        likeListView.setAdapter(likeListAdapter);

        //saves the array so it appears when user returns to listview
        SharedPreferences saveArray = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = saveArray.edit();
        editor.putInt("Status_Size", arrayOfLikes.size());
        for(int i = 0; i < arrayOfLikes.size(); i++) {
            editor.remove("Status_" + i);
            editor.putString("Status_" + i, arrayOfLikes.get(i));
        }
        //editor.apply();
        //editor.clear().apply();

        //shows position and content of a clicked compliment
        likeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                int likePosition = position + 1;
                String compliment = (String) likeListView.getItemAtPosition(position);

                Toast.makeText(getApplicationContext(), "Position: " + likePosition + "\tCompliment: " + compliment, Toast.LENGTH_LONG).show();
            }
        });
    }
}
        /*String quote = getIntent().getStringExtra("quote");
        //Toast.makeText(LikeList.this, quote, Toast.LENGTH_SHORT).show();//TODO

        likeListView = (ListView) findViewById(R.id.likeListView);

        ArrayList<String> arrayOfLikes = new ArrayList<String>();
        Bundle extraGetter = getIntent().getExtras();

        int amountOfLikes = 100;

        if (extraGetter != null) {
            String getExtraHelper;
            for (int i = 0; i < amountOfLikes; i++) {
                getExtraHelper = "Liked ";
                getExtraHelper = getExtraHelper + i;
                arrayOfLikes.add(getExtraHelper);
            }
        }

        ArrayAdapter<String> likeListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, arrayOfLikes);
        arrayOfLikes.add(quote);
        likeListView.setAdapter(likeListAdapter);


        likeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                int likePosition = position++;
                String compliment = (String) likeListView.getItemAtPosition(position);

                Toast.makeText(getApplicationContext(), "Position: " + likePosition + "\tCompliment: " + compliment, Toast.LENGTH_LONG).show();
            }
        });
    }*/
