package com.example.admin.attendee;

/**
 * Created by krixz kartik on 2/4/18.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "DATAX";
    public static final String T_MONDAY = "Monday";
    public static final String T_TUESDAY = "Tuesday";
    public static final String T_WEDNESDAY = "Wednesday";
    public static final String T_THURSDAY = "Thursday";
    public static final String T_FRIDAY = "Friday";

    public static final String T_LECTURE = "Lecture";



    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table " + T_MONDAY +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Start INTEGER,Over INTEGER,loc INTEGER)");

        db.execSQL("create table " + T_TUESDAY +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Start INTEGER,Over INTEGER,loc INTEGER)");

        db.execSQL("create table " + T_WEDNESDAY +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Start INTEGER,Over INTEGER,loc INTEGER)");

        db.execSQL("create table " + T_THURSDAY +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Start INTEGER,Over INTEGER,loc INTEGER)");

        db.execSQL("create table " + T_FRIDAY +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Start INTEGER,Over INTEGER,loc INTEGER)");

        db.execSQL("create table " + T_LECTURE +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Start INTEGER,Over INTEGER,loc INTEGER,status INTEGER)");
        
        
        db.execSQL("create table " + T_ATTENDANCEPERCENT +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Start INTEGER,status INTEGER)");
	
	
        db.execSQL("create table " + T_LOCATIONS +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,latitude INTEGER,longitude INTEGER,status INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+T_MONDAY+T_TUESDAY+T_WEDNESDAY+T_THURSDAY+T_FRIDAY+T_LECTURE);
        onCreate(db);
    }

    public boolean insertDataDay(int i,String name,Integer start,Integer over)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name",name);
        contentValues.put("Start",start);
        contentValues.put("Over",over);

        long result;

        result=-1;

        if(i==1)
         result = db.insert(T_MONDAY,null ,contentValues);

        else if(i==2)
            result = db.insert(T_TUESDAY,null ,contentValues);
        else if(i==3)
            result = db.insert(T_WEDNESDAY,null ,contentValues);
        else if(i==4)
            result = db.insert(T_THURSDAY,null ,contentValues);
        else if(i==5)
            result = db.insert(T_FRIDAY,null ,contentValues);

        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllDataDay(int i)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor res=null;
        if(i==1)
         res = db.rawQuery("select * from "+T_MONDAY,null);

        if(i==2)
            res = db.rawQuery("select * from "+T_TUESDAY,null);
        if(i==3)
            res = db.rawQuery("select * from "+T_WEDNESDAY,null);
        if(i==4)
            res = db.rawQuery("select * from "+T_THURSDAY,null);
        if(i==5)
            res = db.rawQuery("select * from "+T_FRIDAY,null);

        return res;
    }

    public boolean updateData(int i,String id,String name,int start,int over)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name",name);
        contentValues.put("Start",start);
        contentValues.put("Over",over);

        long result;

        result=-1;

        if(i==1)
            db.update(T_MONDAY, contentValues, "ID = ?",new String[] { id });
        else if(i==2)
            db.update(T_TUESDAY, contentValues, "ID = ?",new String[] { id });
        else if(i==3)
            db.update(T_WEDNESDAY, contentValues, "ID = ?",new String[] { id });
        else if(i==4)
            db.update(T_THURSDAY, contentValues, "ID = ?",new String[] { id });
        else if(i==5)
            db.update(T_FRIDAY, contentValues, "ID = ?",new String[] { id });

        if(result == -1)
            return false;
        else
            return true;
    }



    public Integer deleteData (int i,String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        if(i==1)
        return db.delete(T_MONDAY, "ID = ?",new String[] {id});

       else if(i==2)
            return db.delete(T_TUESDAY, "ID = ?",new String[] {id});
       else if(i==3)
            return db.delete(T_WEDNESDAY, "ID = ?",new String[] {id});
        else if(i==4)
            return db.delete(T_THURSDAY, "ID = ?",new String[] {id});
       else  if(i==5)
            return db.delete(T_FRIDAY, "ID = ?",new String[] {id});
       else
           return -1;
    }
}
