package com.example.databaseexamples;

import android.content.Context;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ExternalDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "notes.db";
    private static final int DB_VERSION = 2 ;

    public static ExternalDatabaseHelper getInstance(Context context){
        File databaseFile = context.getDatabasePath(ExternalDatabaseHelper.DB_NAME);
        if (!databaseFile.exists()){
            copyDatabaseFile(context, databaseFile);
        }else {
            SQLiteDatabase db = SQLiteDatabase.openDatabase(databaseFile.getAbsolutePath(),null, 0);
            if (db.needUpgrade(ExternalDatabaseHelper.DB_VERSION)){
                if (databaseFile.delete()){
                    copyDatabaseFile(context, databaseFile);
                }
            }
        }
        return new ExternalDatabaseHelper(context);
    }


    private static void copyDatabaseFile(Context context, File databaseFile){
        try {
            InputStream input = context.getAssets().open(ExternalDatabaseHelper.DB_NAME);
            OutputStream output = new FileOutputStream(databaseFile);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = input.read(buffer)) > 0){
                output.write(buffer, 0, length);
            }
            output.flush();
            output.close();
            input.close();
        }catch (IOException mIOException){
            throw new Error("Error copying Database");
        }
    }

    private ExternalDatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
