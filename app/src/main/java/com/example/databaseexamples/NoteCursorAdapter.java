package com.example.databaseexamples;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NoteCursorAdapter extends CursorAdapter {

    public NoteCursorAdapter(Context context, Cursor c) {

        super(context, c, true);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note , parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView titleTextView= view.findViewById(R.id.title);
        TextView bodyTextView= view.findViewById(R.id.body);
        TextView dateTextView= view.findViewById(R.id.date);
        titleTextView.setText(cursor.getString(cursor.getColumnIndexOrThrow(NoteDatabaseContract.NoteTable.COLUMN_TITLE)));
        bodyTextView.setText(cursor.getString(cursor.getColumnIndexOrThrow(NoteDatabaseContract.NoteTable.COLUMN_BODY)));
        dateTextView.setText(cursor.getString(cursor.getColumnIndexOrThrow(NoteDatabaseContract.NoteTable.COLUMN_DATE)));
    }
}