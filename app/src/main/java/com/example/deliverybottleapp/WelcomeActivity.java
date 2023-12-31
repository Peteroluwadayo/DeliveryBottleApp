package com.example.deliverybottleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class WelcomeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

     //   signUpButton = findViewById(R.id.sign_up);
      //  signInButton = findViewById(R.id.sign_in);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Coding Pursuits");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("DELIVERY_BOTTLE_APP", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("DELIVERY_BOTTLE_APP", "Failed to read value.", error.toException());
            }
        });


        }
    public void onButtonSignUpClicked(View view) {
        Intent intent = new Intent(WelcomeActivity.this,SignUpActivity.class);
        startActivity(intent);

    }

    public void onButtonSignInClicked(View view){
        Intent intent = new Intent (WelcomeActivity.this,SignInActivity.class);
        startActivity(intent);
    }


}



