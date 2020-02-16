package com.example.food1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class first extends AppCompatActivity {
    Button buttn;
    Button butn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        buttn=findViewById(R.id.butt);
        butn=findViewById(R.id.butto);
        buttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inter =new Intent(first.this,MainActivity.class);
                startActivity(inter);
            }
        });
        butn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inter1 =new Intent(first.this,MainActivity2.class);
                startActivity(inter1);
            }
        });
    }
}
