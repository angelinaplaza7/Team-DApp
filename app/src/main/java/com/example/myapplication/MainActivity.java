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

    //Random rand = new Random();
    public int count = 0;
    public int imageCount = 152;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView dog = (ImageView) findViewById(R.id.Image);
        Button like = (Button) findViewById(R.id.Like);
        Button dislike = (Button) findViewById(R.id.Dislike);
        Button stop = (Button) findViewById(R.id.Stop);

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


        imagizer(dog, "3");

            like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("MYapp", "This is log message");
                    if(count < imageCount)
                    {
                        String getImg = randomImage();
                        Log.i("IMGNUM", getImg);
                        imagizer(dog, getImg);
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

                  Log.i("MYapp", "This is log message");
                    //openNoDogs();
                  if(count < imageCount)
                  {
                      String getImg = randomImage();
                      imagizer(dog, getImg);
                      count++;
                  }
                  else
                  {
                      openNoDogs();
                  }
                }
            });
    }

    public void imagizer(final ImageView iview, String img) {

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("images").child(img);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                DogInfo doge = snapshot.getValue(DogInfo.class);
                setImage(iview, doge.image_path);
                //System.out.printf("IMAGE PATH SNAPSHOT : %s\n", doge.image_path);

                //StorageReference storageReference = FirebaseStorage.getInstance().getReference(doge.image_path);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("FAILURE");
            }
        });

    }
    public void setImage(final ImageView iview, String sref) {
        //String sref = "images/n02085620_3742.jpg";
        StorageReference storageReference = FirebaseStorage.getInstance().getReference(sref);
        Glide.with(this).load(storageReference).into(iview);
    }

    public void openNoDogs() {
        Intent intent = new Intent(this, nodogs.class);
        startActivity(intent);
    }

    public String randomImage()
    {
        int imgIndex = (int) (Math.random() * (151));
        return Integer.toString(imgIndex);
    }

}