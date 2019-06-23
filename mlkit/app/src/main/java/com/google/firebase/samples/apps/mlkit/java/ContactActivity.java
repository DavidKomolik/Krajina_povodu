package com.google.firebase.samples.apps.mlkit.java;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.firebase.samples.apps.mlkit.R;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {
private RecyclerView recyclerView;
private RecyclerView.Adapter adapter;
private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Kontakt");

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ArrayList<ContactItem> contactItems = new ArrayList<>();
        contactItems.add(new ContactItem(R.drawable.ic_email,"Line 1","Line 2"));
        contactItems.add(new ContactItem(R.drawable.ic_facebook,"Line 3","Line 4"));

        recyclerView =  findViewById(R.id.recViewContacts);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ContactsAdapter(contactItems);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}
