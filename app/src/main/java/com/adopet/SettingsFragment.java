package com.adopet;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.adopet.R;

import java.util.Locale;

public class SettingsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getChildFragmentManager().beginTransaction().add(R.id.settings_container, new SettingsList()).commit();
        Configuration configuration = getResources().getConfiguration();
        configuration.setLayoutDirection(new Locale("rtl"));
        configuration.setLocale(new Locale("heb"));
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
        return inflater.inflate(R.layout.fragment_settings, container,false);
    }
}
