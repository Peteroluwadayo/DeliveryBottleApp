package com.example.deliverybottleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.deliverybottleapp.databinding.ActivityCustomerBinding;

public class CustomerActivity extends DrawerBaseMainActivity {

    ActivityCustomerBinding activityCustomerBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCustomerBinding = ActivityCustomerBinding.inflate(getLayoutInflater());
        setContentView(activityCustomerBinding.getRoot());
        allocateActivityTitle("Customers");
    }
}