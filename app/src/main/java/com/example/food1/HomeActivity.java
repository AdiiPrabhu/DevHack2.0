package com.example.food1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {
    Button btnlogout;
    Button scanqr;
    Button generate;
    Button data;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStatelistner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        scanqr=findViewById(R.id.scanqr);
        data=findViewById(R.id.enterdata);
        generate=findViewById(R.id.generate);
      /*btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   FirebaseAuth.getInstance().signOut();
                Intent intomain = new Intent(HomeActivity.this,first.class);
                startActivity(intomain);
            }
        });*/
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it =new Intent(HomeActivity.this,reader.class);
                startActivity(it);
            }
        });
        scanqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intscan = new Intent(HomeActivity.this,barcode.class);
                startActivity(intscan);
            }
        });
        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(HomeActivity.this,qr.class);
                startActivity(inte);
            }
        });
    }
}
