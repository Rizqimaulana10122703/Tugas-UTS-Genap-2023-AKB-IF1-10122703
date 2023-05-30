package com.catatan_10122703.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.catatan_10122703.R;
import com.catatan_10122703.adapter.InfoFragmentAdapter;
import com.catatan_10122703.view.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class informasi1Fragment extends Fragment { //10122703 - Mochammad Rizqi Maulana - IF1
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private MainActivity mainActivity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_informasi1, container, false);

        viewPager = root.findViewById(R.id.view_pager_info);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        mainActivity = (MainActivity) getActivity();
        mainActivity.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        List<Fragment> list = new ArrayList<>();
        list.add(new Informasi2Fragment());

        pagerAdapter = new InfoFragmentAdapter(requireActivity().getSupportFragmentManager(), list);

        viewPager.setAdapter(pagerAdapter);
    }
}

