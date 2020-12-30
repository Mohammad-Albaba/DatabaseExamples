package com.example.databaseexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private NoteCursorAdapter noteCursorAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.list_view);

        // **** ExternalDatabaseHelper SQLite *****
        ExternalDatabaseHelper databaseHelper = ExternalDatabaseHelper.getInstance(getApplicationContext());
        db = databaseHelper.getWritableDatabase();
        Cursor cursor = db.query(NoteDatabaseContract.NoteTable.TABLE_NAME,null, null, null, null, null, null);
        noteCursorAdapter = new NoteCursorAdapter(this, cursor);
        listView.setAdapter(noteCursorAdapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                int rowsNum = db.delete(NoteDatabaseContract.NoteTable.TABLE_NAME, NoteDatabaseContract.NoteTable._ID + " = ?", new String[] {String.valueOf(id)});
                if (rowsNum > 0){
                    Toast.makeText(MainActivity.this, "Delete Successfully!", Toast.LENGTH_SHORT).show();
                    reQuery();
                }
                return false;
            }
        });
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//              // بقدر استخدمها في اشي تاني
//            }
//        });



        // **** DatabaseHelper SQLite *****
//        DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
//        SQLiteDatabase readableDatabase = databaseHelper.getReadableDatabase();
//        Cursor cursor = readableDatabase.query(NoteDatabaseContract.NoteTable.TABLE_NAME,null, null, null, null, null, null);
//        NoteCursorAdapter noteCursorAdapter = new NoteCursorAdapter(this, cursor);
//        listView.setAdapter(noteCursorAdapter);



        // **** WritableDatabase SQLite *****
//        SQLiteDatabase db = databaseHelper.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(NoteDatabaseContract.NoteTable.COLUMN_TITLE, "Note title here");
//        contentValues.put(NoteDatabaseContract.NoteTable.COLUMN_BODY, "Just a simple note");
//        contentValues.put(NoteDatabaseContract.NoteTable.COLUMN_DATE, "2020-12-20 10:00");
//        long recordId = db.insert(NoteDatabaseContract.NoteTable.TABLE_NAME, null, contentValues);
//        if (recordId != -1){
//            Toast.makeText(this, "Added Successfully!", Toast.LENGTH_SHORT).show();
//        }


        // **** Delete SQLite *****
//        int rowsNum = db.delete(NoteDatabaseContract.NoteTable.TABLE_NAME, NoteDatabaseContract.NoteTable._ID + " = ?", new String[] {"1"});
//        if (rowsNum > 0){
//            Toast.makeText(this, "Delete Successfully!", Toast.LENGTH_SHORT).show();
//        }


        // **** Updated SQLite *****
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(NoteDatabaseContract.NoteTable.COLUMN_TITLE, "New title ");
//        contentValues.put(NoteDatabaseContract.NoteTable.COLUMN_DATE, "2020-12-25 12:30");
//        int rowsNumU = db.update(NoteDatabaseContract.NoteTable.TABLE_NAME, contentValues, NoteDatabaseContract.NoteTable._ID + " = ?", new String[] {"2"});
//        if (rowsNumU > 0){
//            Toast.makeText(this, "Updated Successfully!", Toast.LENGTH_SHORT).show();
//        }

        // **** ReadableDatabase SQLite *****
//        SQLiteDatabase readableDatabase = databaseHelper.getReadableDatabase();
//        Cursor cursor = readableDatabase.rawQuery("SELECT * FROM " + NoteDatabaseContract.NoteTable.TABLE_NAME, null);
////        Cursor cursor = readableDatabase.query(NoteDatabaseContract.NoteTable.TABLE_NAME,null, null, null, null, null, null);
//        while (cursor.moveToNext()){
//        String title = cursor.getString(cursor.getColumnIndexOrThrow(NoteDatabaseContract.NoteTable.COLUMN_TITLE));
//        String body = cursor.getString(cursor.getColumnIndexOrThrow(NoteDatabaseContract.NoteTable.COLUMN_BODY));
//        String date = cursor.getString(cursor.getColumnIndexOrThrow(NoteDatabaseContract.NoteTable.COLUMN_DATE));
//        textView.append(title + "\n" + body + "\n" + date + "\n\n");
//        }
//        cursor.close();
     }
     private void reQuery(){
         Cursor cursor = db.query(NoteDatabaseContract.NoteTable.TABLE_NAME,null, null, null, null, null, null);
         noteCursorAdapter.changeCursor(cursor);
     }
    }