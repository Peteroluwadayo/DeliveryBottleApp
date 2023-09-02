package com.example.deliverybottleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.deliverybottleapp.databinding.ActivityCustomerBinding;
import com.example.deliverybottleapp.databinding.ActivityOrderBinding;

public class OrderActivity extends DrawerBaseMainActivity {

    ActivityOrderBinding  activityOrderBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityOrderBinding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(activityOrderBinding.getRoot());
        allocateActivityTitle("Orders");
    }
}