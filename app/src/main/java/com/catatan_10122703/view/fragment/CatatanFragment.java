package com.catatan_10122703.view.fragment;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.catatan_10122703.CatatanInterface;
import com.catatan_10122703.adapter.CatatanAdapter;
import com.catatan_10122703.database.DatabaseHelper;
import com.catatan_10122703.model.Catatan;
import com.catatan_10122703.view.activity.AddCatatanActivity;
import com.catatan_10122703.view.activity.MainActivity;
import com.catatan_10122703.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class CatatanFragment extends Fragment  {//10122703 - Mochammad Rizqi Maulana - IF1

    private MainActivity mainActivity;
    private List<Catatan> catatans;
    private CatatanInterface catatanInterface;
    private RecyclerView recyclerView;
    private com.catatan_10122703.adapter.CatatanAdapter catatanAdapter;
    private FloatingActionButton addButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView =  inflater.inflate(R.layout.fragment_catatan, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mainActivity = (MainActivity) getActivity();
        mainActivity.getSupportActionBar().show();

        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.Catatanku);
        addButton = view.findViewById(R.id.botton_add);
        addButton.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), AddCatatanActivity.class));
        });

        read();
    }

    @Override
    public void onResume() {
        super.onResume();
        read();
    }

    private void read() {
        catatans = new ArrayList<Catatan>();
        catatanInterface = new DatabaseHelper(getContext());
        Cursor cursor = catatanInterface.read();
        if (cursor.moveToFirst()){
            do {
                Catatan c = new Catatan(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                );

                catatans.add(c);
            } while (cursor.moveToNext());
        }

        catatanAdapter = new CatatanAdapter(catatans);
        recyclerView.setAdapter(catatanAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
    }
}

