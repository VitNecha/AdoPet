package com.adopet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
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
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.sdsmdg.tastytoast.TastyToast;

import java.util.Locale;

public class MainActivity extends EntryActivity {

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
        //initLang();

        //anonymousAuth();

        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navListener);
        bottomNavigation.setSelectedItemId(R.id.navigation_home);
    }

}