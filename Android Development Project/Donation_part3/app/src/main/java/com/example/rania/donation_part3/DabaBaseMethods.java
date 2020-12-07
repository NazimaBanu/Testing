package com.example.rania.donation_part3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rania on 12/4/2017.
 */

public class DabaBaseMethods {

private SQLiteDatabase database;
private DBHandler handler;

    public DabaBaseMethods(Context context) {
        handler = new DBHandler(context);
    }

    public  void open(){

        database = handler.getWritableDatabase();

    }

    public void close (){
        database.close();

    }


    public void add(DonationClass donation){
        ContentValues values = new ContentValues();
        values.put("amount",donation.getAmount());
        values.put("method",donation.getPaymentMethod());
        database.insert("donations",null,values);
    }


    public List<DonationClass> getAll(){
        List<DonationClass> allDonations = new ArrayList<DonationClass>();
        Cursor cursor = database.rawQuery("select * from donations",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            allDonations.add(toDonation(cursor));
            cursor.moveToNext();
        }

        cursor.close();
        return allDonations;
    }

    public DonationClass toDonation (Cursor cursor){
        DonationClass d = new DonationClass();
        d.setId(cursor.getInt(0));
        d.setAmount(cursor.getInt(1));
        d.setPaymentMethod(cursor.getString(2));
        return d;

    }

    public void getTotalDonaionAmount(){

        Cursor cursor = database.rawQuery("select SUM(amount) from donations",null);
        cursor.moveToFirst();
        if (!cursor.isAfterLast()){
            MainActivity.totalDonation = cursor.getInt(0);

        }

    }

    public void getTotalDonationNumber(){
        Cursor cursor = database.rawQuery("select COUNT(*) from donations",null);
        cursor.moveToFirst();
        if (!cursor.isAfterLast()){
            MainActivity.numberofDonation = cursor.getInt(0);

        }


    }

    public void reset(){
        database.delete("donations",null,null);

    }

}
