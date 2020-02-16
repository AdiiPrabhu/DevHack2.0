package com.example.food1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText emailid,password;
    Button btnSignUp;
    TextView tvSignIn;
    FirebaseAuth mFIrebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFIrebaseAuth = FirebaseAuth.getInstance();
        emailid=findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        btnSignUp=findViewById(R.id.button);
        tvSignIn=findViewById(R.id.textView);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email =emailid.getText().toString();
                String pwd =password.getText().toString();
                if (email.isEmpty()){
                    emailid.setError("please enter an email id");
                    emailid.requestFocus();
                }
                else if (pwd.isEmpty()){
                    password.setError("enter password bro");
                    password.requestFocus();
                }
                else  if (email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(MainActivity.this,"Both are empty u fool",Toast.LENGTH_SHORT).show();
                }
                else  if (!(email.isEmpty() && pwd.isEmpty())){
                    mFIrebaseAuth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()){
                                Toast.makeText(MainActivity.this,"Sign up unsuccesfull.please try again",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                startActivity(new Intent(MainActivity.this,HomeActivity.class));

                            }

                        }
                    });

                }
                else {
                    Toast.makeText(MainActivity.this,"Its an error contact aditya he likes errors",Toast.LENGTH_SHORT).show();

                }
            }
        });
        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });
    }
}
