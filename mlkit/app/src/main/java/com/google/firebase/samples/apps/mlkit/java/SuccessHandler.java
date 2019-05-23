package com.google.firebase.samples.apps.mlkit.java;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.samples.apps.mlkit.R;
import com.google.firebase.samples.apps.mlkit.java.barcodescanning.BarcodeScanningProcessor;


public class SuccessHandler {
    private SQLiteDatabase databazka;
    private BarcodeScanningProcessor context;

    public SuccessHandler(SQLiteDatabase databazka, BarcodeScanningProcessor context) {
        this.databazka = databazka;
        this.context = context;
    }

    public void spracujVysledok(String rawValue, LivePreviewActivity context) {
        Cursor c = databazka.rawQuery("SELECT KRAJINA FROM EAN_KOD WHERE _id = " + (rawValue.substring(0,3)),null);
        c.moveToFirst();
        String vysledok = c.getString(0);
        Intent intent = new Intent(context, SuccessActivity.class);
        intent.putExtra("krajina",vysledok);
        context.startActivity(intent);
    }
}
