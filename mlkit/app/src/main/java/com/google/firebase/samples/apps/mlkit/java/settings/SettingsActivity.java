package com.google.firebase.samples.apps.mlkit.java.settings;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.google.firebase.samples.apps.mlkit.R;

/**
 * Activity which contains Settings page
 * Settings are "dummy" so far, because there is nothing to set, but its prepared for future use
 */
public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Nastavenia");

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        if (findViewById(R.id.fragment_cont) != null) {
            if (savedInstanceState != null)
                return;

            getFragmentManager().beginTransaction().add(R.id.fragment_cont, new SettingsFragment()).commit();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
