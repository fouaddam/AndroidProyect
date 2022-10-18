package org.fouad.appandroid.ConnectDatabase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.fouad.appandroid.Clases.User;

public class Model {


    public SQLiteDatabase getConnection(Context context) {
        ConnectionToDataBase connectionToDataBase = new ConnectionToDataBase
                (context, "databaseUsuario", null, 1);
        SQLiteDatabase db = connectionToDataBase.getWritableDatabase();
        return db;

    }

    public SQLiteDatabase getConnectiontoRead(Context context) {
        ConnectionToDataBase connectionToDataBase = new ConnectionToDataBase
                (context, "databaseUsuario", null, 1);
        SQLiteDatabase db = connectionToDataBase.getReadableDatabase();
        return db;

    }

    public boolean insertUser(User user, Context context) {

        String isertSQL = "INSERT INTO USUARIO VALUES('0','" + user.getName() + "'," +
                "'" + user.getApellido() + "')";
        SQLiteDatabase db = this.getConnection(context);
        db.execSQL(isertSQL);
        System.out.println("usuario insertado");
        return true;
    }

    public void getUsers(Context context) {
        String getUserSQL = "select * from USUARIO";
        SQLiteDatabase db = this.getConnection(context);
        Cursor cursor = db.rawQuery(getUserSQL, null, null);

        while (cursor.moveToNext()) {


        }


    }
}
