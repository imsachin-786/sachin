package com.example.reservationsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class  database extends SQLiteOpenHelper  {
    private static  final String dbname="signup.db";
    public database(@Nullable Context context) {
        super(context,dbname, null, 1);
    }

    @Override    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String q="create table users (id integer primary key autoincrement, name text ,username text ,password text)";
        sqLiteDatabase.execSQL(q);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists users");
        onCreate(sqLiteDatabase);
    }
    public boolean insert_data(String name,String username,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("name",name);
        c.put("username",username);
        c.put("password",password);
        long r = db.insert("users",null,c);
        if(r==-1) {
            return false;
        }
        else {
            return true;
        }

    }
    public Boolean checkusername(String username){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where{ username =?",new String[]{username});

        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean checkpassword(String username ,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username=? and  password =?",new String[]{username,password});

        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }


}

