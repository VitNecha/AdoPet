package com.adopet;

import androidx.annotation.NonNull;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
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
    private TextView petName, petSize, sourceName, sourceAddress, sourceInfo, sourcePhone, sourceRegion, petAge, petBreed, petDesc, publishDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        //
        mainImg = findViewById(R.id.post_main_img);
        petName = findViewById(R.id.post_name_text);
        petAge = findViewById(R.id.post_age_text);
        petSize = findViewById(R.id.post_size_text);
        petBreed = findViewById(R.id.post_breed_text);
        petDesc = findViewById(R.id.post_description_text);
        sourceName = findViewById(R.id.post_source_name);
        sourceAddress = findViewById(R.id.post_source_address);
        sourceInfo = findViewById(R.id.post_source_info);
        sourcePhone = findViewById(R.id.post_source_phone);
        sourceRegion = findViewById(R.id.post_region_text);
        publishDate = findViewById(R.id.post_date_text);
        //
        extractProfile();
        //

    }
    private void extractProfile(){
        final DocumentReference docRef = database.collection("dog_profiles").document("Doggo1");
        final StorageReference storageRef = storage.getReference("dog_profile_images");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()){
                    final PetProfile profile = task.getResult().toObject(PetProfile.class);
                    profile.getSource().get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if (task.isSuccessful()){
                                SourceProfile srcProfile = task.getResult().toObject(SourceProfile.class);
                                profile.setSourceProfile(srcProfile);
                                displayProfile(profile);
                            }
                        }
                    });
                }
            }
        });

    }

    private void displayProfile(PetProfile profile){
        petName.setText(profile.getName());
        petAge.setText(petAge.getText().toString() + " " + profile.getAgeNum() + " " + profile.getAgeType());
        petSize.setText(petSize.getText().toString() + " " + profile.getSize());
        petBreed.setText(petBreed.getText().toString() + " " + profile.getBreed());
        petDesc.setText(petDesc.getText().toString() + " " + profile.getDescription());
        publishDate.setText(profile.getPublishDate());
        sourceName.setText(sourceName.getText().toString() + " " + profile.getSourceProfile().getName());
        sourceAddress.setText(sourceAddress.getText().toString() + " " + profile.getSourceProfile().getAddress());
        sourcePhone.setText(sourcePhone.getText().toString() + " " + profile.getSourceProfile().getPhone());
        sourceRegion.setText(profile.getSourceProfile().getRegion());
        sourceInfo.setText(sourceInfo.getText().toString() + " " + profile.getSourceProfile().getInfo());
        Picasso.get().load(profile.getMainImg()).into(mainImg);
    }
}