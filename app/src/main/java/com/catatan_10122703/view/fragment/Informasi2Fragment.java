package com.catatan_10122703.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.catatan_10122703.R;

public class Informasi2Fragment extends Fragment { //10122703 - Mochammad Rizqi Maulana - IF1
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_informasi2, container, false);
        return rootView;
    }
}

