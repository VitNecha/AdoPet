package com.adopet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adopet.R;
import com.google.firebase.firestore.DocumentReference;

public class PostActivity extends EntryActivity {

    private ImageView mainImg;
    private TextView petName, sourceName, sourceAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        mainImg = findViewById(R.id.post_main_img);
        petName = findViewById(R.id.post_name_text);
        sourceName = findViewById(R.id.post_source_text);
        DocumentReference docRef = database.collection("dog_profiles").document("Doggo1");
        ;
    }
}