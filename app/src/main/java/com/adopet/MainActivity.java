package com.adopet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.MenuItem;

import com.example.adopet.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.sdsmdg.tastytoast.TastyToast;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth userAuth;
    private FirebaseUser currentUser;
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedTab = null;
            switch (item.getItemId()){
                case R.id.navigation_home:
                    selectedTab = new HomeFragment();
                    break;
                case R.id.navigation_search:
                    selectedTab = new SearchFragment();
                    break;
                case R.id.navigation_info:
                    selectedTab = new InfoFragment();
                    break;
                case R.id.navigation_settings:
                    selectedTab = new SettingsFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.main_container, selectedTab).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Anonymous authentication
        userAuth = FirebaseAuth.getInstance();
        userAuth.signInAnonymously().addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    currentUser = userAuth.getCurrentUser();
                    String uid = currentUser.getUid();
                    TastyToast.makeText(getApplicationContext(), "Welcome " + uid, TastyToast.LENGTH_SHORT,TastyToast.SUCCESS);
                }
                else {
                    TastyToast.makeText(getApplicationContext(),"Ooops", TastyToast.LENGTH_SHORT,TastyToast.ERROR);
                }
            }
        });

        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navListener);
        bottomNavigation.setSelectedItemId(R.id.navigation_home);
    }

}