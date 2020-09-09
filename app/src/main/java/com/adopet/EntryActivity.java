package com.adopet;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.adopet.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

import java.util.Locale;

public class EntryActivity extends AppCompatActivity {
    protected FirebaseAuth userAuth;
    protected FirebaseUser currentUser;
    protected FirebaseFirestore database;
    protected FirebaseStorage storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initLang();
    }

    // Language and text direction initialization
    protected void initLang(){
        //Language configuration
        Configuration configuration = getResources().getConfiguration();
        configuration.setLayoutDirection(new Locale("rtl"));
        configuration.setLocale(new Locale("heb"));
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
    }
}