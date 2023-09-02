package com.example.deliverybottleapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    private EditText editTextUserName;
    private EditText editTextPassWord;
    private EditText editTextEmail;
    private EditText editTextPhoneNo;
    private View arrowWelcomeActivity;


    ProgressBar progressBar;

    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        arrowWelcomeActivity = findViewById(R.id.arrow_to_welcome_activity);
        editTextUserName =(EditText)findViewById(R.id.et_user_name);
        editTextPassWord = (EditText)findViewById(R.id.password_editText);
        editTextEmail = (EditText)findViewById(R.id.et_email);
        editTextPhoneNo =(EditText)findViewById(R.id.et_number);

        progressBar = (ProgressBar)findViewById(R.id.progressbar_bar);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();


    }
    public void signupButtonClicked(View v ){
        String txtUserName = editTextUserName.getText().toString().trim();
        String txtPassword = editTextPassWord.getText().toString().trim();
        String txtPhoneNo = editTextPhoneNo.getText().toString().trim();
        String txtEmail = editTextEmail.getText().toString().trim();

        if(txtUserName.isEmpty()) {
            editTextUserName.setError("Please enter UserName");
            editTextUserName.requestFocus();
        }
        if(txtPassword.isEmpty() || txtPassword.length() < 6) {
            editTextPassWord.setError("Please Enter Password Containing six Character");
            editTextPassWord.requestFocus();
        }
        if(txtPhoneNo.isEmpty()) {
            editTextPhoneNo.setError("Please enter Mobile No");
            editTextPhoneNo.requestFocus();
        }
        if(txtEmail.isEmpty()) {
            editTextEmail.setError("Please Enter Valid email");
            editTextEmail.requestFocus();
        }
        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(txtEmail,txtPassword)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()) {


                            User  user = new User(txtUserName, txtPassword, txtPhoneNo,txtEmail);

                            FirebaseDatabase.getInstance().getReference("User")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()) {

                                                Toast.makeText(SignUpActivity.this, "User Registered is Successfully", Toast.LENGTH_SHORT).show();
                                                progressBar.setVisibility(View.GONE);

                                            }
                                            else{

                                                Toast.makeText(SignUpActivity.this, "User Failed Registered", Toast.LENGTH_SHORT).show();
                                                progressBar.setVisibility(View.GONE);
                                            }
                                        }
                                    });
                        }

                        Toast.makeText(SignUpActivity.this, "User Failed Registered", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                });



    }

}