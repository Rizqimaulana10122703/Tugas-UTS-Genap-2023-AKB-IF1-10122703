package com.catatan_10122703.view.activity;


import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.catatan_10122703.view.fragment.informasi1Fragment;
import com.catatan_10122703.view.fragment.CatatanFragment;
import com.catatan_10122703.view.fragment.ProfileFragment ;
import com.catatan_10122703.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {//10122703 - Mochammad Rizqi Maulana - IF1

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        //menampilkan halaman yang pertama muncul
        getFragmentPage(new CatatanFragment());

        //insialisasi bottom nav
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()){
                    case
                            R.id.info:
                        fragment = new informasi1Fragment();
                        break;
                    case
                            R.id.note:
                        fragment = new CatatanFragment();
                        break;
                    case
                            R.id.profile:
                        fragment = new ProfileFragment();
                        break;
                }
                return getFragmentPage(fragment);
            }
        });
    }

    private boolean getFragmentPage(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.page_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}

