package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    public int count = 0;
    public int imageCount = 1170;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView dog = (ImageView) findViewById(R.id.Image);
        Button like = (Button) findViewById(R.id.Like);
        Button dislike = (Button) findViewById(R.id.Dislike);
        Button stop = (Button) findViewById(R.id.Stop);


        getImage(dog, "3");

            like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(count < imageCount)
                    {
                        String getImg = randomImage();
                        Log.i("IMGNUM", getImg);
                        getImage(dog, getImg);
                        count++;
                    }
                    else
                    {
                        openNoDogs();
                        count++;
                    }
                }
            });

            dislike.setOnClickListener(new View.OnClickListener() {
              @Override
                public void onClick(View v) {

                  if(count < imageCount)
                  {
                      String getImg = randomImage();
                      Log.i("IMGNUM", getImg);
                      getImage(dog, getImg);
                      count++;
                  }
                  else
                  {
                      openNoDogs();
                  }
                }
            });

        //stop showing following pictures
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = null;
                intent = new Intent(MainActivity.this,Newaccount.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"stop successfully!",Toast.LENGTH_SHORT).show();

            }
        });
    }

<<<<<<< HEAD
    /**
     * Gets an image from firebase and inserts it into the passed ImageView
     * @param iview - ImageView to pass image to.
     * @param img - image to get from firebase
     */
    public void getImage(final ImageView iview, String img) {
=======


    public void imagizer(final ImageView iview, String img) {
>>>>>>> 78d6900c3097112ec229e4e0a506acab9fc1fd25

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("images").child(img);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DogInfo doge = snapshot.getValue(DogInfo.class);
                setImage(iview, doge.image_path);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("FAILURE");
            }
        });

    }

    /**
     * Helper method for getImage that uses glide to set the image in the ImageView.
     * @param iview - image view to set
     * @param sref - image to get from firebase
     */
    public void setImage(final ImageView iview, String sref) {
        StorageReference storageReference = FirebaseStorage.getInstance().getReference(sref);
        Glide.with(this).load(storageReference).into(iview);
    }

    public void openNoDogs() {
        Intent intent = new Intent(this, nodogs.class);
        startActivity(intent);
    }

    /**
     * Images in firebase are indexed by a number that is a string ("0", "1", "2")
     * This function gets a random number and converts it to a string so a random entry
     * can be fetched from firebase
     * @return - random number as a string
     */
    public String randomImage() {
        int imgIndex = (int) (Math.random() * (imageCount - 1));
        return Integer.toString(imgIndex);
    }

}