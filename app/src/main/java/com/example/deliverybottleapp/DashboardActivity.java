package com.example.deliverybottleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.deliverybottleapp.databinding.ActivityDashboardBinding;

public class DashboardActivity extends DrawerBaseMainActivity {

    ActivityDashboardBinding activityDashboardBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDashboardBinding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(activityDashboardBinding.getRoot());
        allocateActivityTitle("Dashboard");
    }
}