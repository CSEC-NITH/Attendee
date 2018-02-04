package com.example.admin.attendee;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

public class editlecture extends AppCompatActivity
{


    public SQLiteDatabase db;
    public Cursor cr;
    int p;

    public DataBaseHelper DBH;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editlecture);
    }

    public void FUN(View view)
    {
        EditText E1=(EditText)findViewById(R.id.lecname);
        EditText Ea1=(EditText)findViewById(R.id.tihr);
        EditText Ea2=(EditText)findViewById(R.id.timin);
        EditText Eb1=(EditText)findViewById(R.id.tohr);
        EditText Eb2=(EditText)findViewById(R.id.tomin);


        String S=E1.getText().toString();

        int St=(Integer.parseInt(Ea1.getText().toString())*60+Integer.parseInt(Ea2.getText().toString()));

        St=St-8*60;

        int Ov=(Integer.parseInt(Eb1.getText().toString())*60+Integer.parseInt(Eb2.getText().toString()));

        Ov=Ov-8*60;

        Intent I=getIntent();

        int x=I.getIntExtra("passed",0);


       // cr=DBH.ReadOpen("Monday");


        Toast.makeText(getApplicationContext(),Integer.toString(St)+" "+Integer.toString(Ov),Toast.LENGTH_LONG).show();

       // DBH.InsertData("Monday",S,St,Ov);
       // boolean b=DBH.InsertData("Monday",S,St,Ov);


      //  boolean b=DBH.InsertData("Monday","naveen",St,Ov);

        //Cursor c=DBH.ReadOpen("Monday");

       /* ContentValues contentValues = new ContentValues();
        contentValues.put("Name",S);
        contentValues.put("Start",St);
        contentValues.put("Over",Ov);

        SQLiteDatabase db=DBH.getWritableDatabase();

        long result = db.insert("Monday",null ,contentValues);

     */

      // DBH.InsertData("Monday",S,St,Ov);

      //DBH.insertDataDay(x,S,St,Ov);



    }
}
