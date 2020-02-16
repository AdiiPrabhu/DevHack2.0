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

public class MainActivity2 extends AppCompatActivity {
    EditText emailid1,password1;
    Button btnSignUp1;
    TextView tvSignIn1;
    FirebaseAuth mFIrebaseAuth1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFIrebaseAuth1 = FirebaseAuth.getInstance();
        emailid1=findViewById(R.id.editText);
        password1 = findViewById(R.id.editText2);
        btnSignUp1=findViewById(R.id.button);
        tvSignIn1=findViewById(R.id.textView);
        btnSignUp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email =emailid1.getText().toString();
                String pwd =password1.getText().toString();
                if (email.isEmpty()){
                    emailid1.setError("please enter an email id");
                    emailid1.requestFocus();
                }
                else if (pwd.isEmpty()){
                    password1.setError("enter password bro");
                    password1.requestFocus();
                }
                else  if (email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(MainActivity2.this,"Both are empty u fool",Toast.LENGTH_SHORT).show();
                }
                else  if (!(email.isEmpty() && pwd.isEmpty())){
                    mFIrebaseAuth1.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(MainActivity2.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()){
                                Toast.makeText(MainActivity2.this,"Sign up unsuccesfull.please try again",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                startActivity(new Intent(MainActivity2.this,HomeActivity2.class));

                            }

                        }
                    });

                }
                else {
                    Toast.makeText(MainActivity2.this,"Its an error contact aditya he likes errors",Toast.LENGTH_SHORT).show();

                }
            }
        });
        tvSignIn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity2.this,HomeActivity2.class);
                startActivity(i);
            }
        });
    }
}
