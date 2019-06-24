package com.google.firebase.samples.apps.mlkit.java;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.google.firebase.samples.apps.mlkit.R;
import com.google.firebase.samples.apps.mlkit.java.settings.SettingsActivity;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {
private RecyclerView recyclerView;
private ContactsAdapter adapter;
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

        final ArrayList<ContactItem> contactItems = new ArrayList<>();
        contactItems.add(new ContactItem(R.drawable.ic_email,"Email","Kontaktujte nas Emailom"));
        contactItems.add(new ContactItem(R.drawable.ic_facebook,"Facebook","Sme aj na Facebooku"));
        contactItems.add(new ContactItem(R.drawable.ic_instagram,"Instagram","Dajte nám follow :)"));
        contactItems.add(new ContactItem(R.drawable.ic_twitter,"Twitter","Dajte nám follow :)"));
        contactItems.add(new ContactItem(R.drawable.ic_github,"Github","Pozrite si našu prácu"));
        contactItems.add(new ContactItem(R.drawable.ic_gplay,"Google Play","Pozrite si našu prácu"));
        contactItems.add(new ContactItem(R.drawable.ic_gplay,"Maps","Tu nás nájdete"));
        contactItems.add(new ContactItem(R.drawable.ic_youtube,"Youtube","Pozrite si našu prácu"));
        contactItems.add(new ContactItem(R.drawable.ic_github,"Github","Pozrite si našu prácu"));




        recyclerView =  findViewById(R.id.recViewContacts);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ContactsAdapter(contactItems);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickLietener(new ContactsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if (position == 0) {
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);
                    emailIntent.setData(Uri.parse("mailto:"));
                    emailIntent.setType("text/plain");
                    emailIntent.putExtra(Intent.EXTRA_EMAIL,new String[] {"Mrkvicka@gmail.com"});
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Ahoj");
                    startActivity(emailIntent);
                }

                if (position == 5) {

                    //startActivity(new Intent(this,ContactActivity.class));
                }
            }
        });

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
