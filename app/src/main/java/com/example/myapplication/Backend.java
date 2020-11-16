package com.example.myapplication;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.net.HttpURLConnection;
import java.io.BufferedInputStream;
import java.io.IOException;

public class Backend
{
    public String breed;
    public String coat;
    public String color;
    public String common_nicknames;
    public String height_cm;
    public String height_in;
    public String image_path;
    public String life_span;
    public String size;
    public String weightKg;
    public String weightLb;

    public Backend() {

    }
    public Backend(String breed,
                String coat,
                String color,
                String common_nicknames,
                String height_cm,
                String height_in,
                String image_path,
                String life_span,
                String size,
                String weightKg,
                String weightLb)
    {
        this.breed = breed;
        this.color = color;
        this.common_nicknames = common_nicknames;
        this.height_cm = height_cm;
        this.height_in = height_in;
        this.image_path = image_path;
        this.life_span = life_span;
        this.size = size;
        this.weightKg = weightKg;
        this.weightLb = weightLb;
    }
    /*
    public String getImagePath(int imgNum)
    {
        char num = (char) imgNum;

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dbRef = database.getReference();

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DogInfo info = snapshot.getValue(DogInfo.class);
                System.out.println(info);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("Database read failed: " + error.getCode());

            }
        });
        return "";
    }
     */
}
