package org.fouad.appandroid.ConnectDatabase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.fouad.appandroid.Clases.User;

import java.util.ArrayList;
import java.util.List;

public class Model {


    public SQLiteDatabase getConnection(Context context) {
        ConnectionToDataBase connectionToDataBase = new ConnectionToDataBase
                (context, "databasenow", null, 1);
        SQLiteDatabase db = connectionToDataBase.getWritableDatabase();
        return db;

    }

    public SQLiteDatabase getConnectiontoRead(Context context) {
        ConnectionToDataBase connectionToDataBase = new ConnectionToDataBase
                (context, "databasenow", null, 1);
        SQLiteDatabase db = connectionToDataBase.getReadableDatabase();
        return db;

    }

    public boolean insertUser(User user, Context context) {

        String isertSQL = "INSERT INTO USUARIOS VALUES('0','" + user.getName() + "'," +
                "'" + user.getApellido() + "')";
        SQLiteDatabase db = this.getConnection(context);
        db.execSQL(isertSQL);
        System.out.println("usuario insertado");
        return true;
    }

    public List<User> getUsers(Context context){
        List<User>usuariosList=new ArrayList<>();

        String SQLSelect="SELECT * FROM USUARIO";
        ConnectionToDataBase connection=new ConnectionToDataBase(context,"databaseusers",null,1);
        SQLiteDatabase db = connection.getReadableDatabase();
        Cursor cursor=db.rawQuery(SQLSelect,null);


        if(cursor.moveToFirst()){
            do{
                usuariosList.add(new User(cursor.getInt(1), cursor.getString(2),cursor.getString(3),cursor.getString(4)));
            }while (cursor.moveToNext());

        }


        return usuariosList;
    }
}
