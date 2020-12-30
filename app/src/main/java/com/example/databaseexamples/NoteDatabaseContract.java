package com.example.databaseexamples;

import android.provider.BaseColumns;

public class NoteDatabaseContract {

    private NoteDatabaseContract() {}

    public static class NoteTable implements BaseColumns{

        public static final String TABLE_NAME = "note";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_BODY = "body";
        public static final String COLUMN_DATE = "date";

        public static final String CREATE_STATEMENT = "CREATE TABLE " + TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_TITLE + " TEXT," +
                COLUMN_BODY + " TEXT," +
                COLUMN_DATE + " TEXT" +
                ")";

        public static final String DROP_STATEMENT = "DROP TABLE IF EXIST " + TABLE_NAME;
    }

}