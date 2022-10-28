package org.fouad.appandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Page1 extends AppCompatActivity {


    TextView txtviewName;
    Button buttonList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);
        txtviewName=findViewById(R.id.textViewName);
        String name=getIntent().getStringExtra("datos_name");
        txtviewName.setText(name);
        //buttonList=findViewById(R.id.button3ID);??????????
    }


    public void onClickBack(View view) {
        Intent intentToPrincipal=new Intent(this,MainActivity.class);
        startActivity(intentToPrincipal);
    }

    public void ClickTolist(View view) {
        Intent intent=new Intent(this, listView.class);
        startActivity(intent);

    }
}