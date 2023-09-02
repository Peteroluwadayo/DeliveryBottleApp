package com.example.deliverybottleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {

    EditText editTextUserName;
    EditText editTextPassword;

    TextView textViewForgotPassword;
    TextView textViewRegister;

    ProgressBar progressBar;


    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        editTextUserName = (EditText) findViewById(R.id.username_editTextSignInName);
        editTextPassword = (EditText) findViewById(R.id.editTextSignInPassword);


        textViewForgotPassword = (TextView) findViewById(R.id.txtSignInForgotPassword);
        textViewRegister = (TextView) findViewById(R.id.txtSignInRegister);

        progressBar = (ProgressBar)findViewById(R.id.progressbar_bar3);


        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();


    }

    public void txtSignInForgetPasswordClicked(View v) {
        Intent intent = new Intent(SignInActivity.this,ForgotPasswordActivity.class);
        startActivity(intent);


    }
    public void  txtSignInRegisterClicked(View v) {
        Intent intent = new Intent(SignInActivity.this,SignUpActivity.class);
        startActivity(intent);

    }
public void buttonSignInScrSignInClicked(View v){

        String userName = editTextUserName.getText().toString().trim();

   }

}