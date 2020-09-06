package com.adopet;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.adopet.R;

public class HomeFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container,false);
        v.findViewById(R.id.test_button).setOnClickListener(this);
        return v;


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.test_button:
                startActivity(new Intent(getActivity(),PostActivity.class));
                break;
        }
        /*
        if (v.getId() == R.id.test_button) {
            startActivity(new Intent(getActivity(),PostActivity.class));
        }
        */
    }
}
