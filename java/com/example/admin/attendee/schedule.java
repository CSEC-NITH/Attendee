package com.example.admin.attendee;


import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.DialogFragment;
import android.app.Activity;
import android.app.Dialog;
import android.view.Window;



public class schedule extends AppCompatActivity
{

    public int k=1;
    public int []classonday={0,5,4,4,2,3,0,0};

    String []arr1={" ","EVS","Data Struct","System softwareS","Computer \norganisation","CO","Computer organisation"};
    int []start1={0,30,80,130,180,230};
    int []span1={0,50,50,50,50,560};

    String []arr2={" ","EVS","Data /nStructure","System softwareS","CC","Data Structure lab"};
    int []start2={0,30,80,130,180,230};
    int []span2={0,50,50,50,50,560};

    String []arr3={" ","EVS","DS","SS","CC","DSlab"};
    int []start3={0,30,80,130,180,230};
    int []span3={0,50,50,50,50,560};

    String []arr4={" ","EVS","Computer Graphics","SS","CC","DSlab"};
    int []start4={0,30,90,240,400};
    int []span4={0,90,150,320,480};

    String []arr5={" ","EVS","DS","test","CC","DSlab"};
    int []start5={0,30,80,130,210,370};
    int []span5={0,50,50,50,50,210};



    public SQLiteDatabase db;
    public Cursor cr;
    int p;

    public DataBaseHelper DBH = new DataBaseHelper(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


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

          /*  TR.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view)
                                      {
                                          int cid=view.getId();

                                          String S=Integer.toString(cid);

                                          Toast.makeText(getApplicationContext(),S,Toast.LENGTH_LONG).show();


                                      }
                                  });
                                  */


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

            else//--
            {


                int ps=k; int dz;

                for (int i = 0; i <=classonday[ps]; i++)
                {
                    TextView TV = new TextView(this);



                    if(i==0)
                    {
                        S=Integer.toString(j)+"/1/2018\n";

                        if(k==1)
                        {  S+="Monday";  }

                        else if(k==2)
                        {    S+="Tuesday";  }
                        else if(k==3)
                        {   S+="Wednesday";  }
                        else if(k==4)
                        {   S+="Thursday";  }
                        else if(k==5)
                        {   S+="Friday";    }
                        else if(k==6)
                        {  S+="Saturday";   }
                        else
                        {
                            S+="Sunday";
                        }

                        TV.setBackgroundColor(Color.BLUE);
                        TV.setText(S);
                        TV.setTextSize(18);
                        TV.setTextColor(Color.WHITE);
                        LinearLayout.LayoutParams LP = new LinearLayout.LayoutParams(200, 100);
                        LP.setMargins(10, 20, 10, 10);
                        LL.addView(TV, LP);

                        if(k<7)
                            k++;

                        else
                            k=1;

                    }


                    else {

                        dz=k-1;


                        // TV.setId(j);

                      /*  TV.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view)
                            {
                                int cid=view.getId();

                                String S=Integer.toString(cid);

                                Toast.makeText(getApplicationContext(),S,Toast.LENGTH_SHORT).show();

                                TextView T=(TextView)(view);

                                //T.setBackgroundColor(Color.RED);
                              //  ViewDialog VD=new ViewDialog();
                              //  VD.showDialog(MainActivity.this,T);

                            }
                        });

                        */



                        if(dz==1)
                        {

                            TV.setBackgroundColor(Color.GREEN);
                            TV.setText(arr1[i]);
                            LinearLayout.LayoutParams LP = new LinearLayout.LayoutParams(span1[i] * 2 + 20, 100);
                            LP.setMargins(10 + (start1[i] - (start1[i - 1] + span1[i - 1])) * 2, 20, 10, 10);
                            LL.addView(TV, LP);
                        }

                        else if(dz==2)
                        {

                            TV.setBackgroundColor(Color.GREEN);
                            TV.setText(arr2[i]);
                            LinearLayout.LayoutParams LP = new LinearLayout.LayoutParams(span2[i] * 2 + 20, 100);
                            LP.setMargins(10 + (start2[i] - (start2[i - 1] + span2[i - 1])) * 2, 20, 10, 10);
                            LL.addView(TV, LP);
                        }

                        else if(dz==3)
                        {

                            TV.setBackgroundColor(Color.GREEN);
                            TV.setText(arr3[i]);
                            LinearLayout.LayoutParams LP = new LinearLayout.LayoutParams(span3[i] * 2 + 20, 100);
                            LP.setMargins(10 + (start3[i] - (start3[i - 1] + span3[i - 1])) * 2, 20, 10, 10);
                            LL.addView(TV, LP);
                        }

                        else if(dz==4)
                        {

                            TV.setBackgroundColor(Color.GREEN);
                            TV.setText(arr4[i]);
                            LinearLayout.LayoutParams LP = new LinearLayout.LayoutParams(span4[i] * 2 + 20, 100);
                            LP.setMargins(10 + (start4[i] - (start4[i - 1] + span4[i - 1])) * 2, 20, 10, 10);
                            LL.addView(TV, LP);
                        }

                        else if(dz==5)
                        {

                            TV.setBackgroundColor(Color.GREEN);
                            TV.setText(arr5[i]);
                            LinearLayout.LayoutParams LP = new LinearLayout.LayoutParams(span5[i] * 2 + 20, 100);
                            LP.setMargins(10 + (start5[i] - (start5[i - 1] + span5[i - 1])) * 2, 20, 10, 10);
                            LL.addView(TV, LP);
                        }




                    }
                }
            }


            TR.addView(LL, TRP);


            TL.addView(TR, TLP);
        }


        //############################################################################


        sv.addView(hsv);
        hsv.addView(TL);

        MLL.addView(sv);


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        TextView TV=(TextView)findViewById(R.id.textView);


        switch(item.getItemId())
        {
            case R.id.action_setting: {

                //  TV.setText("you clicked Settings ");

                Intent I=new Intent(this,logintochange.class);
                startActivity(I);

            }


        }

        return true;
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







