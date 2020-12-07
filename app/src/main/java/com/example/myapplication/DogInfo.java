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

/**
 * DogInfo class allows us to retrieve info from firebase.
 * The information from the database can the be accessed as an attribute of DogInfo.
 */
public class DogInfo {

    public String breed;
    public String coat;
    public String color;
    public String common_nicknames;
    public String height_cm;
    public String height_in;
    public String image_path;
    public String life_span;
    public String size;
    public String weight_kg;
    public String weight_lb;

    public DogInfo() {
     // empty constructor
    }

    public DogInfo(String breed,
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
        this.weight_kg = weightKg;
        this.weight_lb = weightLb;
    }

}
