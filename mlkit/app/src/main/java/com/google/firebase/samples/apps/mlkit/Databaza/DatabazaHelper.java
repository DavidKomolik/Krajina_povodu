package com.google.firebase.samples.apps.mlkit.Databaza;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import androidx.annotation.Nullable;

public class DatabazaHelper extends SQLiteAssetHelper {
    public static final String db_nazov = "databaza.db";
    public static final String db_cesta = "/data/data/com.google.firebase.samples.apps.mlkit/databases/";
    private  Context mContext;
    private  SQLiteDatabase databaza;

    public DatabazaHelper(@Nullable Context context) {
        super(context, db_nazov, null, 1);
        this.mContext = context;
        //kopirujDatabazu(context);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public  void otvorDatabazu() {
        String cesta = mContext.getDatabasePath(db_nazov).getPath();
        if (databaza != null && databaza.isOpen()){
            return;
        }
         databaza = SQLiteDatabase.openDatabase(db_cesta,null,SQLiteDatabase.OPEN_READWRITE);

    }

    public  void zavriDatabazu(){
        if (databaza != null) {
           // databaza.close();
        }
    }

    private static boolean kopirujDatabazu(Context context){
        try {
            InputStream inputStream = context.getAssets().open(DatabazaHelper.db_nazov);
            String nazovSuboru = DatabazaHelper.db_cesta + DatabazaHelper.db_nazov;
            OutputStream outputStream = new FileOutputStream(nazovSuboru);
            byte[] buffer = new byte[1024];
            int dlzka = 0;
            while ((dlzka = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer,0,dlzka);
            }
            Log.v("Main","Databazka skopirovana");
            outputStream.flush();
            outputStream.close();
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public  String getKrajina(String id){
       // otvorDatabazu();
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT KRAJINA FROM EAN_KOD WHERE _id = "+id + ";",null);
        cursor.moveToFirst();
        String vysledok = cursor.getString(1);
        cursor.close();
        zavriDatabazu();
        return vysledok;
    }
}
