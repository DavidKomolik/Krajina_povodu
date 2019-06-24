package com.google.firebase.samples.apps.mlkit.java;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.google.firebase.samples.apps.mlkit.java.barcodescanning.BarcodeScanningProcessor;

/**
 * Class responsible for dealing with database and processing the barcode found resolut
 */
public class SuccessHandler {
    private SQLiteDatabase database;
    private BarcodeScanningProcessor context;

    public SuccessHandler(SQLiteDatabase sqLiteDatabase, BarcodeScanningProcessor context) {
        this.database = sqLiteDatabase;
        this.context = context;
    }

    public void processResult(String rawValue, LivePreviewActivity context) {
        Cursor c = database.rawQuery("SELECT KRAJINA FROM EAN_KOD WHERE _id = " + (rawValue.substring(0, 3)), null);
        if (c.getCount() == 0) {
            Intent intent = new Intent(context, SuccessActivity.class);
            intent.putExtra("krajina", "Nepodporovaný EAN");
            context.startActivity(intent);

        } else {
            c.moveToFirst();
            String result = c.getString(0);
            Intent intent = new Intent(context, SuccessActivity.class);
            intent.putExtra("krajina", result);
            context.startActivity(intent);
        }
    }
}
