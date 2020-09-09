package com.adopet;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.os.storage.StorageManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.adopet.classes.PetProfile;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        PetProfile profile;
        mainImg = findViewById(R.id.post_main_img);
        petName = findViewById(R.id.post_name_text);
        sourceName = findViewById(R.id.post_source_name);
        sourceAddress = findViewById(R.id.post_source_address);
        petAge = findViewById(R.id.post_age_text);
        petBreed = findViewById(R.id.post_breed_text);
        petDesc = findViewById(R.id.post_description_text);
        database = FirebaseFirestore.getInstance();
        storage = FirebaseStorage.getInstance("gs://adopetdb.appspot.com/");
        final DocumentReference docRef = database.collection("dog_profiles").document("Doggo1");
        final DocumentReference sourceRef;
        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot doc, @Nullable FirebaseFirestoreException error) {
                if (error == null){
                    StorageReference storageRef = storage.getReference("gs://adopetdb.appspot.com/dog_profile_images/Dog1.jpg");
                    storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            Picasso.get().load(uri.toString()).into(mainImg);
                        }
                    });
                    petName.setText(doc.getString(FieldPath.of("Name").toString()));
                }
            }
        });
    }
}