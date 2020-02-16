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
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity2 extends AppCompatActivity {
    EditText emailid1,password1;
    Button btnSignIn1;
    TextView tvSignUp1;
    FirebaseAuth mFIrebaseAuth1;
    private FirebaseAuth.AuthStateListener mAuthStateListner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mFIrebaseAuth1 = FirebaseAuth.getInstance();
        emailid1=findViewById(R.id.editText);
        password1 = findViewById(R.id.editText2);
        btnSignIn1=findViewById(R.id.button);
        tvSignUp1=findViewById(R.id.textView);

        mAuthStateListner1 = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser =mFIrebaseAuth1.getCurrentUser();
                if( mFirebaseUser!=null){
                    Toast.makeText(LoginActivity2.this,"you are logged in",Toast.LENGTH_SHORT).show();;
                    Intent i =new Intent(LoginActivity2.this,HomeActivity2.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(LoginActivity2.this,"kar bai login",Toast.LENGTH_SHORT).show();
                }
            }
        };
        btnSignIn1.setOnClickListener(new View.OnClickListener() {
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
                    Toast.makeText(LoginActivity2.this,"Both are empty u fool",Toast.LENGTH_SHORT).show();
                }
                else  if (!(email.isEmpty() && pwd.isEmpty())){
                    mFIrebaseAuth1.signInWithEmailAndPassword(email,pwd).addOnCompleteListener(LoginActivity2.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()){
                                Toast.makeText(LoginActivity2.this,"Login error Please login again dear",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Intent intoHome =new Intent(LoginActivity2.this,HomeActivity2.class);
                                startActivity(intoHome);
                            }
                        }
                    });

                }
                else {
                    Toast.makeText(LoginActivity2.this,"Its an error contact aditya he likes errors",Toast.LENGTH_SHORT).show();

                }
            }
        });
        tvSignUp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intsignup = new Intent(LoginActivity2.this,HomeActivity2.class);
                startActivity(intsignup);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFIrebaseAuth1.addAuthStateListener(mAuthStateListner1);
    }
}
