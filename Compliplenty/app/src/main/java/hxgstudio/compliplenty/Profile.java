package hxgstudio.compliplenty;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static com.facebook.FacebookSdk.getApplicationContext;

public class Profile extends FragmentActivity implements OptionDialog.OptionDialogListener {


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
                DialogFragment newFragment = new OptionDialog();
                newFragment.show(getSupportFragmentManager(), "missiles");
            }
        });

        contacts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(Profile.this, ContactsList.class);
                Profile.this.startActivity(intent);
            }
        });

        final Intent profileToLikeList = new Intent(this, LikeList.class);
        viewLikeList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String putExtraHelper;
                ArrayList<String> listOfLikes = new ArrayList<String>();
                for (int i = 0; i < listOfLikes.size(); i++) {
                    putExtraHelper = "Compliment ";
                    putExtraHelper = putExtraHelper + i;
                    profileToLikeList.putExtra(putExtraHelper, "" + listOfLikes.get(i));
                }
                Toast.makeText(Profile.this, "Like List", Toast.LENGTH_SHORT).show();
                startActivity(profileToLikeList);
            }
        });

    }

    public void showNoticeDialog() {
        // Create an instance of the dialog fragment and show it
        DialogFragment dialog = new OptionDialog();
        dialog.show(getSupportFragmentManager(), "NoticeDialogFragment");
    }

    // The dialog fragment receives a reference to this Activity through the
    // Fragment.onAttach() callback, which it uses to call the following methods
    // defined by the NoticeDialogFragment.NoticeDialogListener interface
    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        // User touched the dialog's positive button
        Intent intent;
        intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        // User touched the dialog's negative button
        Intent i = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        final int ACTIVITY_SELECT_IMAGE = 1234;
        startActivityForResult(i, ACTIVITY_SELECT_IMAGE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 1234:
                if (resultCode == RESULT_OK) {
                    try {
                        final Uri imageUri = data.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        ImageView img = (ImageView) findViewById(R.id.imageView_profile);
                        img.setImageBitmap(selectedImage);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        Toast.makeText(Profile.this, "Something went wrong", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(Profile.this, "You haven't picked Image", Toast.LENGTH_LONG).show();
                }
        }
        ;
    }
}
