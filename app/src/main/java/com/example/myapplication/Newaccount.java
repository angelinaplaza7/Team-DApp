package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Newaccount extends AppCompatActivity {
    EditText emailId, password;
    Button btnSignUp;
    TextView tvSignIn;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newaccount);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        btnSignUp = findViewById(R.id.button);
        tvSignIn = findViewById(R.id.textView2);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailId.getText().toString();
                String pwd = password.getText().toString();
                if(email.isEmpty()) {
                    emailId.setError("Please enter your email id");
                    emailId.requestFocus();
                }
                else if(pwd.isEmpty()) {
                    password.setError("Please enter your password");
                    password.requestFocus();
                }
                else if(email.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(Newaccount.this,"Fields are Empty!",Toast.LENGTH_SHORT).show();
                }
                else if(!(email.isEmpty() && pwd.isEmpty())) {
                    mFirebaseAuth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(Newaccount.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()) {
                                Toast.makeText(Newaccount.this,"SignUp Unsuccessful, Please check the format of your email and password!",Toast.LENGTH_LONG).show();

                            }
                            else {
                                startActivity(new Intent( Newaccount.this,MainActivity.class));
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(Newaccount.this,"Error Occurred!",Toast.LENGTH_SHORT).show();

                }
            }
        });

        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Newaccount.this,LogInscreen.class);
                startActivity(i);
            }
        });
    }
}