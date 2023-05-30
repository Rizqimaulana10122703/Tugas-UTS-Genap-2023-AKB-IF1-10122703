package com.catatan_10122703;

import android.database.Cursor;

import com.catatan_10122703.model.Catatan;

public interface CatatanInterface {

    public Cursor read();
    public boolean create(Catatan catatan);
    public boolean update(Catatan catatan);
    public boolean delete(String id);
}

