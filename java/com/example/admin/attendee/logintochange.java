package com.example.admin.attendee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class logintochange extends AppCompatActivity
{
    String N="sckorpio";
    String P="vansika";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logintochange);
    }

    public void FUN(View view)
    {
        EditText name=(EditText)findViewById(R.id.editname);
        EditText pwd=(EditText)findViewById(R.id.editpwd);

        String ni=name.getText().toString();
        String pi=pwd.getText().toString();

        if((pi.equals(P))&&(ni.equals(N)))
        {
            Toast.makeText(getApplicationContext(),"you can edit record!!!",Toast.LENGTH_LONG).show();

            Intent I=new Intent(this,editablerecord.class);

            startActivity(I);
        }

        else
        {
            Toast.makeText(getApplicationContext(),"Wrong!!!",Toast.LENGTH_LONG).show();
        }
    }
}
