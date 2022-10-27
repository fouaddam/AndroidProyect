package org.fouad.appandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.circularreveal.CircularRevealHelper;

import org.fouad.appandroid.Clases.User;
import org.fouad.appandroid.ConnectDatabase.Model;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    EditText txtname,txtapellido,txtPassword,txtEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtname=findViewById(R.id.textName);
        txtapellido=findViewById(R.id.textApellido);
        txtPassword=findViewById(R.id.textPassword);
        txtEmail=findViewById(R.id.textAddress);
        //String veces=getString(R.string.vecesPulsado);
       // Resources resources=getResources(); mirar pdf alberto y apuntes alba
        //String nombre=resources.getQuantityString("");
    }

    public void ClicktoPage1(View view) {


        String name =txtname.getText().toString();
        String apellido=txtapellido.getText().toString();
        String Email=txtEmail.getText().toString();

        Intent Intpage1=new Intent(this,Page1.class);
        Intpage1.putExtra("datos_name",name);
        Intpage1.putExtra("datos_apellido",apellido);
        Intpage1.putExtra("datos_email",Email);
        Intpage1.putExtra("datos_password",txtPassword.getText());

        startActivity(Intpage1);

        User user =new User(name,apellido,Email);
        System.out.println(user.toString());
        Model model=new Model();
        model.insertUser(user,this);

           List<User> lista=model.getUsers(this);

        System.out.println(lista.toString());

    }
}