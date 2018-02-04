package com.example.admin.attendee;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class editableshedule extends AppCompatActivity
{

    public SQLiteDatabase db;
    public Cursor cr;
    int p;

    public DataBaseHelper DBH;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        DBH = new DataBaseHelper(this);


        LinearLayout MLL = new LinearLayout(this);

        this.setContentView(MLL, new LinearLayoutCompat.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        //==================================================================

        //------------------- DATA BASE


        //=========================================================================


        ScrollView sv = new ScrollView(this);

        HorizontalScrollView hsv = new HorizontalScrollView(this);


        //############################################################################3333

        TableLayout.LayoutParams TLP = new TableLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        TableLayout TL = new TableLayout(this);
        TL.setBackgroundColor(Color.BLACK);
        TL.setLayoutParams(TLP);

        TableRow.LayoutParams TRP = new TableRow.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        TRP.setMargins(30, 30, 30, 30);
        TRP.weight = 1;


        for (int j = 0; j < 8; j++) {
            TableRow TR = new TableRow(this);
            TR.setBackgroundColor(Color.CYAN);

            //TR.setId(j);

            TR.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    int cid=view.getId();

                    String S=Integer.toString(cid);

                    Toast.makeText(getApplicationContext(),S,Toast.LENGTH_LONG).show();

                    Intent I=new Intent(view.getContext(),editlecture.class);

                    I.putExtra("passed",cid);

                    startActivity(I);



                }
            });



            LinearLayout LL = new LinearLayout(getApplicationContext());

            LL.setBackgroundColor(Color.YELLOW);

            LL.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));


            //our class data----------------temporary database--------

            String[] arr = {" ", "EVS", "DS", "SS", "CC", "DSlab"};
            int[] start = {0, 30, 80, 130, 210, 370};
            int[] span = {0, 50, 50, 50, 50, 210};


            String S = "";

            //=========================TOP TIME HOURS========================================
            if (j == 0) {
                for (int i = -1; i <= 10; i++) {

                    TextView TV = new TextView(this);

                    TV.setBackgroundColor(Color.BLUE);

                    //TV.isClickable;

                    // TV.setOnClickListener(OCL);

                    int t;


                    if (i == -1) {
                        S = "DATE";
                        TV.setText(S);
                        TV.setTextColor(Color.WHITE);
                        TV.setTextSize(20);
                        LinearLayout.LayoutParams LP = new LinearLayout.LayoutParams(200, 50);
                        LP.setMargins(10, 20, 10, 10);
                        LL.addView(TV, LP);

                        continue;
                    } else if (i >= 0 && i < 5) {
                        t = i + 8;

                        S = Integer.toString(t);

                        S = S + " AM";

                    } else {
                        t = (i - 5) + 1;

                        S = Integer.toString(t);

                        S = S + " PM";

                    }

                    TV.setText(S);
                    TV.setTextColor(Color.WHITE);
                    TV.setTextSize(20);
                    LinearLayout.LayoutParams LP = new LinearLayout.LayoutParams(120, 50);
                    LP.setMargins(10, 20, 10, 10);
                    LL.addView(TV, LP);
                }


            }

            //===============================================================

            else {

                switch (j) {
                    case 1:
                        S = "Monday";
                        break;
                    case 2:
                        S = "Tuesday";
                        break;
                    case 3:
                        S = "Wednesday";
                        break;
                    case 4:
                        S = "Thrusday";
                        break;
                    case 5:
                        S = "Friday";
                        break;
                    case 6:
                        S = "Saturday";
                        break;
                    case 7:
                        S = "Sunday";
                        break;
                }
                TextView TVo = new TextView(this);

                TVo.setBackgroundColor(Color.BLUE);
                TVo.setText(S);
                TVo.setTextSize(18);
                TVo.setTextColor(Color.WHITE);
                LinearLayout.LayoutParams LPo = new LinearLayout.LayoutParams(200, 100);
                LPo.setMargins(10, 20, 10, 10);
                LL.addView(TVo, LPo);

                // String D="";

              /*  switch (j) {
                    case 1:
                        cr = DBH.ReadOpen("Monday");
                        break;
                    case 2:
                        cr = DBH.ReadOpen("Tuesday");
                        break;
                    case 3:
                        cr = DBH.ReadOpen("Wednesday");
                        break;
                    case 4:
                        cr = DBH.ReadOpen("Thursday");
                        break;
                    case 5:
                        cr = DBH.ReadOpen("Friday");
                        break;
                    case 6:
                        cr = DBH.ReadOpen("Saturday");
                        break;
                    case 7:
                        cr = DBH.ReadOpen("Sunday");
                        break;
                }
                */




                //  String H="Monday"




                  //  cr = DBH.getAllDataDay(j);




                //cr=DBH.ReadOpen(S);
                //p = DBH.checkN(D);
                p=cr.getCount();
                cr.moveToFirst();

               // Toast.makeText(getApplicationContext(), Integer.toString(p), Toast.LENGTH_LONG).show();



              /*  if (cr.getCount() != 0) {
                    p = DBH.checkN("Monday");
                    cr.moveToFirst();

                    for (int f = 1; f <= p; f++) {
                        String N = cr.getString(1);
                        int s = cr.getInt(2);
                        int o = cr.getInt(3);

                        TextView TV = new TextView(this);


                        TV.setBackgroundColor(Color.GREEN);
                        TV.setText(N);
                        LinearLayout.LayoutParams LP = new LinearLayout.LayoutParams((s - o) * 2 + 20, 100);
                        LP.setMargins(10 + (s) * 2, 20, 10, 10);
                        LL.addView(TV, LP);

                        cr.moveToNext();

                    }
                }
                */

                cr.moveToFirst();


                while(p>0)
                {

                    String N = cr.getString(1);
                    int s = cr.getInt(2);
                    int o = cr.getInt(3);

                  //  Toast.makeText(getApplicationContext(),Integer.toString(s), Toast.LENGTH_LONG).show();

                    TextView TV = new TextView(this);


                    TV.setBackgroundColor(Color.GREEN);
                    TV.setText(N);
                    LinearLayout.LayoutParams LP = new LinearLayout.LayoutParams((o-s) * 2 + 20, 100);
                    LP.setMargins(10+s*2, 20, 10, 10);
                    LL.addView(TV, LP);

                    cr.moveToNext();
                    p--;

                }

                cr.close();



               /* for (int i = 1; i < 6; i++)
                {
                    TextView TV = new TextView(this);




                    TV.setBackgroundColor(Color.GREEN);
                    TV.setText(arr[i]);
                    LinearLayout.LayoutParams LP = new LinearLayout.LayoutParams(span[i]*2+20, 100);
                    LP.setMargins(10+(start[i]-(start[i-1]+span[i-1]))*2, 20, 10, 10);
                    LL.addView(TV, LP);

                }
                */
            }



            TR.addView(LL, TRP);


            TL.addView(TR, TLP);
        }


        //############################################################################


        sv.addView(hsv);
        hsv.addView(TL);

        MLL.addView(sv);


    }











/*
    View.OnClickListener OCL=new View.OnClickListener()
    {
        @Override
        public void onClick(View view) {

            int cid=view.getId();

            String S=Integer.toString(cid);

            Toast.makeText(getApplicationContext(),S,Toast.LENGTH_LONG);

        }
    };

    */


}

