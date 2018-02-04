package com.example.admin.attendee;
import android.content.Intent;
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



public class editablerecord extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        LinearLayout MLL=new LinearLayout(this);

        this.setContentView(MLL,new LinearLayoutCompat.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));



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





        for (int j = 0; j < 20; j++)
        {
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

            String []arr={" ","EVS","DS","SS","CC","DSlab"};
            int []start={0,30,80,130,210,370};
            int []span={0,50,50,50,50,210};



            String S;

            //=========================TOP TIME HOURS========================================
            if(j==0)
            {
                for(int i=-1;i<=10;i++)
                {

                    TextView TV=new TextView(this);

                    TV.setBackgroundColor(Color.BLUE);

                    //TV.isClickable;

                    // TV.setOnClickListener(OCL);

                    int t;



                    if(i==-1)
                    {
                        S="DATE";
                        TV.setText(S);
                        TV.setTextColor(Color.WHITE);
                        TV.setTextSize(20);
                        LinearLayout.LayoutParams LP=new LinearLayout.LayoutParams(200,50);
                        LP.setMargins(10,20,10,10);
                        LL.addView(TV,LP);

                        continue;
                    }

                    else if(i>=0&&i<5)
                    {
                        t = i + 8;

                        S = Integer.toString(t);

                        S=S+" AM";

                    }

                    else
                    {
                        t = (i-5) + 1;

                        S = Integer.toString(t);

                        S=S+" PM";

                    }

                    TV.setText(S);
                    TV.setTextColor(Color.WHITE);
                    TV.setTextSize(20);
                    LinearLayout.LayoutParams LP=new LinearLayout.LayoutParams(120,50);
                    LP.setMargins(10,20,10,10);
                    LL.addView(TV,LP);
                }


            }

            //===============================================================

            else
            {

                for (int i = 0; i < 6; i++)
                {
                    TextView TV = new TextView(this);

                    if(i==0)
                    {
                        S="1/1/2018\n";
                        S+="Monday";

                        TV.setBackgroundColor(Color.BLUE);
                        TV.setText(S);
                        TV.setTextSize(18);
                        TV.setTextColor(Color.WHITE);
                        LinearLayout.LayoutParams LP = new LinearLayout.LayoutParams(200, 100);
                        LP.setMargins(10, 20, 10, 10);
                        LL.addView(TV, LP);

                    }


                    else {


                         TV.setId(j);

                       TV.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view)
                            {
                                int cid=view.getId();

                                String S=Integer.toString(cid);

                                Toast.makeText(getApplicationContext(),S,Toast.LENGTH_SHORT).show();

                                TextView T=(TextView)(view);

                                //T.setBackgroundColor(Color.RED);
                               ViewDialog VD=new ViewDialog();
                               VD.showDialog(editablerecord.this,T);

                            }
                        });






                        TV.setBackgroundColor(Color.GREEN);
                        TV.setText(arr[i]);
                        LinearLayout.LayoutParams LP = new LinearLayout.LayoutParams(span[i]*2+20, 100);
                        LP.setMargins(10+(start[i]-(start[i-1]+span[i-1]))*2, 20, 10, 10);
                        LL.addView(TV, LP);
                    }
                }
            }


            TR.addView(LL,TRP);


            TL.addView(TR,TLP);
        }



        //############################################################################




        sv.addView(hsv);
        hsv.addView(TL);

        MLL.addView(sv);


    }

    /*


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

    */





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




    public static class ViewDialog  extends DialogFragment
    {

        public void showDialog(Activity activity, final TextView vx) {

            final Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.customdialog);




            Button PrB = (Button) dialog.findViewById(R.id.present);
            Button AbB = (Button) dialog.findViewById(R.id.absent);
             Button PxB = (Button) dialog.findViewById(R.id.proxy);
             Button MbB = (Button) dialog.findViewById(R.id.massbunk);
             Button OtB=(Button) dialog.findViewById(R.id.other);
             Button CnB=(Button) dialog.findViewById(R.id.cancel);

            PrB.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v)
                {
                    vx.setBackgroundColor(Color.GREEN);
                    dialog.dismiss();
                }
            });

            AbB.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v)
                {
                    vx.setBackgroundColor(Color.RED);
                    dialog.dismiss();
                }
            });


            PxB.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v)
                {
                    vx.setBackgroundColor(Color.CYAN);
                    dialog.dismiss();
                }
            });

            MbB.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v)
                {
                    vx.setBackgroundColor(Color.YELLOW);
                    dialog.dismiss();
                }
            });


            OtB.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v)
                {
                    vx.setBackgroundColor(Color.GRAY);
                    dialog.dismiss();
                }
            });

            CnB.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v)
                {

                    dialog.dismiss();
                }
            });

            dialog.show();

        }
    }









}

