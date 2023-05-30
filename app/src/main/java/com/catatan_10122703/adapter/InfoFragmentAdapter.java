package com.catatan_10122703.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class InfoFragmentAdapter extends FragmentStatePagerAdapter {//10122703 - Mochammad Rizqi Maulana - IF1

    private List<Fragment> fragmentList;
    public InfoFragmentAdapter(@NonNull FragmentManager f, List<Fragment> fragmentList) {
        super(f);
        this.fragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        return fragmentList.get(position);
    }

    @Override
    public int getCount() {

        return fragmentList.size();
    }
}

