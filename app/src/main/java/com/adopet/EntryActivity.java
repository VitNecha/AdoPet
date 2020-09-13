package com.adopet;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.adopet.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.sdsmdg.tastytoast.TastyToast;

import java.util.Locale;

public class EntryActivity extends AppCompatActivity {
    protected FirebaseAuth userAuth;
    protected FirebaseUser currentUser;
    protected FirebaseFirestore database;
    protected FirebaseStorage storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = FirebaseFirestore.getInstance();
        storage = FirebaseStorage.getInstance();
        initLang();
        anonymousAuth();
    }

    // Language and text direction initialization
    protected void initLang(){
        //Language configuration
        Configuration configuration = getResources().getConfiguration();
        configuration.setLayoutDirection(new Locale("rtl"));
        configuration.setLocale(new Locale("heb"));
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
    }

    //Anonymous authentication
    private void anonymousAuth(){
        userAuth = FirebaseAuth.getInstance();
        userAuth.signInAnonymously().addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    currentUser = userAuth.getCurrentUser();
                    String uid = currentUser.getUid(); // (TEMP - Delete before release)
                    TastyToast.makeText(getApplicationContext(), "Welcome ", TastyToast.LENGTH_SHORT,TastyToast.SUCCESS);
                }
                else {
                    TastyToast.makeText(getApplicationContext(),"Ooops", TastyToast.LENGTH_SHORT,TastyToast.ERROR);
                }
            }
        });
    }
}