package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Path;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    final int[] images = {R.drawable.puppies, R.drawable.puppy, R.drawable.puppy2, R.drawable.puppy3, R.drawable.puppy4, R.drawable.puppy5};
    Random rand = new Random();
    public int index = rand.nextInt(images.length);
    public int count = 0;
    public ArrayList<Integer> indexs = new ArrayList<Integer>();
    public Set<Integer> hset = new HashSet<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView dog = (ImageView) findViewById(R.id.Image);
        Button like = (Button) findViewById(R.id.Like);
        Button dislike = (Button) findViewById(R.id.Dislike);

        // gets the data but is only usable inside onDataChange
        // glide is not usable inside onDataChange
        /*
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("images").child("0");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                Backend doge = snapshot.getValue(Backend.class);
                System.out.printf("IMAGE PATH SNAPSHOT : %s\n", doge.image_path);

                //StorageReference storageReference = FirebaseStorage.getInstance().getReference(doge.image_path);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("FAILURE");
            }
        });
        */

        //// THIS WORKS but is hardcoded
        // this gets images reference
        StorageReference storageReference = FirebaseStorage.getInstance().getReference("images/n02085620_10131.jpg");
        Log.i("Storage REF", storageReference.getBucket());
        // This passes the image to the image view dog
        Glide.with(this /* context */).load(storageReference).into(dog);

            like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("MYapp", "This is log message");
                    if(count < images.length)
                    {
                        dog.setImageResource(images[count]);
                        count++;
                        index = nextIndex();
                    }
                    else
                    {
                        openNoDogs();
                    }
                }
            });

            dislike.setOnClickListener(new View.OnClickListener() {
              @Override
                public void onClick(View v) {
                  Log.i("MYapp", "This is log message");
                    //openNoDogs();
                  if(count < images.length)
                  {
                      dog.setImageResource(images[count]);
                      count++;
                      index = nextIndex();
                  }
                  else
                  {
                      openNoDogs();
                  }
                }
            });
    }

    public void openNoDogs() {
        Intent intent = new Intent(this, nodogs.class);
        startActivity(intent);
    }

    public int nextIndex()
    {
        hset.add(index);
        while(hset.contains(index))
        {
            index = rand.nextInt(images.length);
        }
        return index;
    }

}