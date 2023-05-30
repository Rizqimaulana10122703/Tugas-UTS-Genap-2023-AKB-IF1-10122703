package com.catatan_10122703.view.activity;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.catatan_10122703.CatatanInterface;
import com.catatan_10122703.database.DatabaseHelper;
import com.catatan_10122703.model.Catatan;
import com.catatan_10122703.R;

import java.util.Date;

public class AddCatatanActivity extends AppCompatActivity { //10122703 - Mochammad Rizqi Maulana - IF1

    ImageButton button;
    EditText editTitle;
    EditText editCategory;
    EditText editDesc;
    Button addButton;
    Button deleteButton;
    TextView titleAdd;

    private CatatanInterface catatanInterface;
    Catatan catatan = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_catatan);
        getSupportActionBar().hide();
        catatan = (Catatan) getIntent().getSerializableExtra("Catatan");
        button = findViewById(R.id.back);
        editTitle = findViewById(R.id.title);
        editCategory = findViewById(R.id.category);
        editDesc = findViewById(R.id.txt_desc);
        addButton = findViewById(R.id.buttonAdd);
        deleteButton = findViewById(R.id.buttonDelete);
        titleAdd = findViewById(R.id.txt_add);
        catatanInterface = new DatabaseHelper(this);

        button.setOnClickListener(v -> {
            finish();
        });

        if (catatan == null){
            deleteButton.setVisibility(View.GONE);

            addButton.setOnClickListener(v -> {
                if (editTitle.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Note title cannot be empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (editCategory.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Note category cannot be empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (editDesc.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Note content cannot be empty!", Toast.LENGTH_SHORT).show();
                }
                Date d = new Date();
                CharSequence date = DateFormat.format("EEEE, d MMM yyyy HH:mm", d.getTime());
                Catatan n = new Catatan(
                        d.getTime() + "",
                        editTitle.getText().toString(),
                        editCategory.getText().toString(),
                        editDesc.getText().toString() ,
                        "created on " + date + ""
                );

                catatanInterface.create(n);
                finish();
                Toast.makeText(this, "Catatan Berhasil Ditambah", Toast.LENGTH_SHORT).show();
            });
        } else {
            editTitle.setText(catatan.getTitle());

            editCategory.setText(catatan.getCategory());

            editDesc.setText(catatan.getDesc());

            deleteButton.setVisibility(View.VISIBLE);
            titleAdd.setText("Change note");

            addButton.setOnClickListener(v -> {
                if (editTitle.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Judul Catatan Tidak Boleh Kosong!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (editCategory.getText().toString().isEmpty()) {
                    Toast.makeText(this, "kategori Catatan Tidak Boleh Kosong!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (editDesc.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Kategori Catatan Tidak Boleh Kosong!", Toast.LENGTH_SHORT).show();
                }

                Date d = new Date();
                CharSequence date = DateFormat.format("EEEE, d MMMM yyyy HH:mm",d.getTime());

                catatan.setTitle(editTitle.getText().toString());
                catatan.setCategory(editCategory.getText().toString());
                catatan.setDesc(editDesc.getText().toString());
                catatan.setDate("last modified " + date + "");
                catatanInterface.update(catatan);
                finish();
                Toast.makeText(this, "Catatan Berhasil Diubah", Toast.LENGTH_SHORT).show();
            });
        }

        deleteButton.setOnClickListener(v-> {
            catatanInterface.delete(catatan.getId());
            finish();
            Toast.makeText(this, "Catatan Berhasil Dihapus", Toast.LENGTH_SHORT).show();
        });
    }
}


