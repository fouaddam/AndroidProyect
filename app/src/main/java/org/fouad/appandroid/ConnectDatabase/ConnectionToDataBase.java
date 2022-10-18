package org.fouad.appandroid.ConnectDatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConnectionToDataBase extends SQLiteOpenHelper {


    String Tabl_users="CREATE TABLE USUARIOS(id INTEGER,name TEXT,apellido TEXT)";

    public ConnectionToDataBase(@Nullable Context context,
                                @Nullable String name,
                                @Nullable SQLiteDatabase.CursorFactory factory, int version) {

        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    db.execSQL(Tabl_users);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
