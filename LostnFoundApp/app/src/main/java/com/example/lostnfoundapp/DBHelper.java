package com.example.lostnfoundapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "my_app_database.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_QUERY =
                "CREATE TABLE my_items (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "name TEXT, " +
                        "phone TEXT, " +
                        "description TEXT, " +
                        "location TEXT, " +
                        "item_type TEXT, " +
                        "date_added TEXT)";
        db.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS my_items");
        onCreate(db);
    }
}