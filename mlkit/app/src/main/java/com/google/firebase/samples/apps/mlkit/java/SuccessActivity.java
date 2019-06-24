package com.google.firebase.samples.apps.mlkit.java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.google.firebase.samples.apps.mlkit.R;


/**
 * Activity which contains Success page.
 * Handles and gets result from database
 */
public class SuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        TextView countryNameView = findViewById(R.id.countryNameView);
        Intent intent = getIntent();
        String country = intent.getStringExtra("krajina");
        countryNameView.setText(country);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Výsledok");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
