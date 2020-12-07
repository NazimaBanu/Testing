package com.example.rania.donation_part3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Rania on 12/4/2017.
 */

public class DBHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "donations.db";
    private static final int VERSION = 1;
    private static final String CREATE_TABLE_STATMENT = "create table donations "+
            "(id integer primary key autoincrement,"+
            "amount integer not null,"+
            "method text not null);";



    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_STATMENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS donations");
        onCreate(db);
    }
}
