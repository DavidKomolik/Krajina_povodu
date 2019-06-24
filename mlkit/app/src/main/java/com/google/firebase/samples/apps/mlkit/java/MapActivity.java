package com.google.firebase.samples.apps.mlkit.java;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.maps.MapFragment;
import com.google.firebase.samples.apps.mlkit.R;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Nastavenia");

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        if (findViewById(R.id.map_container) != null) {
            if (savedInstanceState != null) return;

            getFragmentManager().beginTransaction().add(R.id.map_container,new MapFragment()).commit();
        }
        }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    }

