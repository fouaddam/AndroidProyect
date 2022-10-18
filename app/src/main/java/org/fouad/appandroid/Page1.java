package org.fouad.appandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Page1 extends AppCompatActivity {


    TextView txtviewName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);
        txtviewName=findViewById(R.id.textViewName);
        String name=getIntent().getStringExtra("datos_name");
        txtviewName.setText(name);
    }


    public void onClickBack(View view) {

        Intent intentToPrincipal=new Intent(this,MainActivity.class);

        startActivity(intentToPrincipal);
    }
}