package com.catatan_10122703.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.catatan_10122703.model.Catatan;
import com.catatan_10122703.CatatanInterface;

public class DatabaseHelper extends SQLiteOpenHelper implements CatatanInterface { //10122703 - Mochammad Rizqi Maulana - IF1

    public DatabaseHelper(@Nullable Context context) {
        super(context, "db_catatan", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE t_note (id TEXT, title TEXT, category TEXT, description TEXT, date TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE t_note");
    }

    public Cursor read(){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM t_note", null);
    }

    public boolean create (Catatan catatan){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("INSERT INTO t_note VALUES ('"+catatan.getId()+"','"+catatan.getTitle()+"','"+catatan.getCategory()+"','"+catatan.getDesc()+"','"+catatan.getDate()+"')");
        return true;
    }

    public boolean update (Catatan catatan){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("UPDATE t_note SET title='"+catatan.getTitle()+"', category='"+catatan.getCategory()+"', description='"+catatan.getDesc()+"', date='"+catatan.getDate()+"' WHERE id='"+catatan.getId()+"'");
        return true;
    }

    public boolean delete(String id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM t_note WHERE id='"+id+"'");
        return true;
    }
}

