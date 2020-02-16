package com.example.food1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class reader extends AppCompatActivity {
    EditText name,phone,medhis,med;
    Button subm;
    DatabaseReference reff;
    Medical medical;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);
        name=findViewById(R.id.name);
        phone=findViewById(R.id.Phone);
        medhis=findViewById(R.id.medhis);
        med=findViewById(R.id.med);
        subm=findViewById(R.id.submit);
        medical= new Medical();
        reff= FirebaseDatabase.getInstance().getReference().child("Medical");
subm.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Long Ph=Long.parseLong(phone.getText().toString().trim());
        medical.setName(name.getText().toString().trim());
        medical.setMed(med.getText().toString().trim());
        medical.setMedhis(medhis.getText().toString().trim());
        medical.setPhone(Ph);
    reff.child("medical").setValue(medical);
        Toast.makeText(reader.this,"succesfully stored",Toast.LENGTH_LONG).show();
    }
});
subm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itn =new Intent(reader.this,HomeActivity.class);
                startActivity(itn);
            }
        });
    }
}
