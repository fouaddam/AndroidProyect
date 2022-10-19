package org.fouad.appandroid.ConnectDatabase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.fouad.appandroid.Clases.Producto;
import org.fouad.appandroid.Clases.User;

import java.util.ArrayList;
import java.util.List;

public class Model {


    public ConnectionToDataBase getConnection(Context context) {
        ConnectionToDataBase connection = new ConnectionToDataBase
                (context, "databasenow", null, 1);

        return connection;

    }


    public boolean insertUser(User user, Context context) {

        String isertSQL = "INSERT INTO USUARIO VALUES('0','" + user.getName() + "'," +
                "'" + user.getApellido() + "')";
        ConnectionToDataBase connection = this.getConnection(context);
        SQLiteDatabase db = connection.getWritableDatabase();
        db.execSQL(isertSQL);
        System.out.println("usuario insertado");
        return true;
    }

   /* public boolean insertProducto(Producto  producto, Context context) {
        ConnectionToDataBase connectionToDataBase = new ConnectionToDataBase
                (context, "databasenow", null, 1);
        SQLiteDatabase db = connectionToDataBase.getWritableDatabase();


        String isertSQL = "INSERT INTO Producto VALUES('" + producto.getId()+"','" + producto.getNombre() + "'," +
                "'" + producto.getDescp() + "')";

        db.execSQL(isertSQL);
        System.out.println("Producto insertado ");
        return true;
    }

    */


    public List<User> getUsers(Context context){
        List<User>usuariosList=new ArrayList<>();
        String SQLSelect="SELECT * FROM USUARIO";

        ConnectionToDataBase connection = this.getConnection(context);
        SQLiteDatabase db = connection.getReadableDatabase();
        Cursor cursor=db.rawQuery(SQLSelect,null);

        if(cursor!=null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    usuariosList.add(new User(cursor.getString(0),
                            cursor.getString(1),
                            cursor.getString(2)));
                } while (cursor.moveToNext());
                cursor.close();
            }

        }





        return usuariosList;
    }
}
