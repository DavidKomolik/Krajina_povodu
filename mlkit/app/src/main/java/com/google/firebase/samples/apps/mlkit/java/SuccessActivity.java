package com.google.firebase.samples.apps.mlkit.java;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.google.firebase.samples.apps.mlkit.R;

public class SuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        TextView vypisKrajiny= findViewById(R.id.textViewNazovKrajiny);
        Intent intent = getIntent();
        String nazovKrajiny = intent.getStringExtra("krajina");
        vypisKrajiny.setText(nazovKrajiny);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Vysledok");
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
