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

public class LoginActivity extends AppCompatActivity {
    EditText emailid,password;
    Button btnSignIn;
    TextView tvSignUp;
    FirebaseAuth mFIrebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mFIrebaseAuth = FirebaseAuth.getInstance();
        emailid=findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        btnSignIn=findViewById(R.id.button);
        tvSignUp=findViewById(R.id.textView);

        mAuthStateListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser =mFIrebaseAuth.getCurrentUser();
                if( mFirebaseUser!=null){
                    Toast.makeText(LoginActivity.this,"you are logged in",Toast.LENGTH_SHORT).show();;
                    Intent i =new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(LoginActivity.this,"kar bai login",Toast.LENGTH_SHORT).show();
                }
            }
        };
        btnSignIn.setOnClickListener(new View.OnClickListener() {
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
                    Toast.makeText(LoginActivity.this,"Both are empty u fool",Toast.LENGTH_SHORT).show();
                }
                else  if (!(email.isEmpty() && pwd.isEmpty())){
                    mFIrebaseAuth.signInWithEmailAndPassword(email,pwd).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()){
                                Toast.makeText(LoginActivity.this,"Login error Please login again dear",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Intent intoHome =new Intent(LoginActivity.this,HomeActivity.class);
                                startActivity(intoHome);
                            }
                        }
                    });

                }
                else {
                    Toast.makeText(LoginActivity.this,"Its an error contact aditya he likes errors",Toast.LENGTH_SHORT).show();

                }
            }
        });
        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intsignup = new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(intsignup);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFIrebaseAuth.addAuthStateListener(mAuthStateListner);
    }
}
