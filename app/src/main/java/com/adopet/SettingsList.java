package com.adopet;

import android.os.Bundle;
import android.text.Layout;

import androidx.preference.PreferenceFragmentCompat;

import com.example.adopet.R;

public class SettingsList extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        //super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }
}
