package com.example.todo_today.LoginSignup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="register.db";
    public static final String TABLE_NAME ="registeruser";
    public static final String COL_1 ="ID";
    public static final String COL_2 ="username";
    public static final String COL_3 ="password";
    public static final String COL_4 ="email";
    public static final String COL_5 ="fullname";

    //modified constructor
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }



    //create table sql for sign_up form..
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       sqLiteDatabase.execSQL("CREATE TABLE registeruser (ID INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, email TEXT, password TEXT, fullname TEXT)");

    }

    //drop table sql...
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    //function to insert vales into database....

    public long addUser( String user, String email, String password, String fullname) {

        //inserting values into database from form..

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username" ,user);
        contentValues.put("password" ,password);
        contentValues.put("email" ,email);
        contentValues.put("fullname" ,fullname);
        //this inserts values into database...
        long res = db.insert("registeruser", null, contentValues);
        db.close();
        return res;
    }




    //function to check username and password..

    public boolean checkUser(String username, String password) {

        //checking username and password for matching...

        String[] columns = { COL_1 };

        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_2 + "=?" + " and " + COL_3 + "=?" ;
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query(TABLE_NAME, columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        //checking count if it's greater than zero 0...

        if(count>0)
            return true;
        else
            return false;

    }

    //fetching data
    //method
    public Cursor ViewData() {

        //creating sqLiteDatabase object
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        //creating cursor object
        String selectQuery = "SELECT  * FROM  registeruser  Where  ID   =   ID";

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);

        //returning cursor object.
        return cursor;
    }


}
