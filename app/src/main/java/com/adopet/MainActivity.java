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
        initLang();
        database = FirebaseFirestore.getInstance();
        anonymousAuth();

        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navListener);
        bottomNavigation.setSelectedItemId(R.id.navigation_home);
    }

    // Language and text direction initialization
    private void initLang(){
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