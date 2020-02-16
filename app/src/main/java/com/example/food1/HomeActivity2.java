package com.example.food1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity2 extends AppCompatActivity {
    Button btnlogout1;
    Button butt;
    FirebaseAuth mFirebaseAuth1;
    private FirebaseAuth.AuthStateListener mAuthStatelistner1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        butt=findViewById(R.id.button2);
        btnlogout1=findViewById(R.id.logout);
        /*btnlogout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intomain = new Intent(HomeActivity2.this,first.class);
                startActivity(intomain);
            }
        });*/
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itt= new Intent(HomeActivity2.this,barcode.class);
                startActivity(itt);
            }
        });
    }
}
