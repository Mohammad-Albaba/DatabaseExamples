//package com.example.databaseexamples;
//
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import androidx.annotation.Nullable;
//
//public class DatabaseHelper extends SQLiteOpenHelper {
//
//    private static final String DB_NAME = "notes.db";
//    private static final int DB_VERSION = 1 ;
//
//    public DatabaseHelper(@Nullable Context context) {
//        super(context, DB_NAME, null, DB_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(NoteDatabaseContract.NoteTable.CREATE_STATEMENT);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL(NoteDatabaseContract.NoteTable.DROP_STATEMENT);
//        onCreate(db);
//    }
//}