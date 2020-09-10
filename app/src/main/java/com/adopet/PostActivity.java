package com.adopet;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.os.storage.StorageManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.adopet.classes.PetProfile;
import com.adopet.classes.SourceProfile;
import com.example.adopet.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldPath;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.PicassoProvider;

public class PostActivity extends EntryActivity {

    private ImageView mainImg;
    private TextView petName, sourceName, sourceAddress, petAge, petBreed, petDesc;
    private PetProfile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        //
        mainImg = findViewById(R.id.post_main_img);
        petName = findViewById(R.id.post_name_text);
        petAge = findViewById(R.id.post_age_text);
        petBreed = findViewById(R.id.post_breed_text);
        petDesc = findViewById(R.id.post_description_text);
        sourceName = findViewById(R.id.post_source_name);
        sourceAddress = findViewById(R.id.post_source_address);
        //

    }
    private void extractProfile(){
        final DocumentReference docRef = database.collection("dog_profiles").document("Doggo1");

        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot docSnap) {
                if (docSnap.exists()){
                    //Set pet profile
                    profile.setName(docSnap.getString("Name"));
                    profile.setAge(docSnap.getDouble("AgeNum").intValue(),docSnap.getString("AgeType"));
                    profile.setBreed(docSnap.getString("Breed"));
                    profile.setDescription(docSnap.getString("Description"));

                    //Set source profile
                    DocumentReference srcRef = docSnap.getDocumentReference("Source");
                    srcRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot srcDocSnap) {
                            if (srcDocSnap.exists()) {
                                profile.getSource().setName(srcDocSnap.getString("Name"));
                                profile.getSource().setAddress(srcDocSnap.getString("Address"));
                                //TODO//
                            }
                        }
                    });
                }
            }
        });

    }
}