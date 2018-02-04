package com.example.admin.attendee;


import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyCalendar {

    private  String time;
    private  int diff,month,day;
    
 	public void getTime()
 	{
        time = new SimpleDateFormat("yyyy//MM//dd_____HH//mm//ss").format(Calendar.getInstance().getTime());
        month = getmonth(time);
        day   = getday(time);
        diff = getdiff(month,day);
       
    }
    public int getmonth(String s){
        int temp;
        String q="";
        q+=s.charAt(6);
        q+=s.charAt(7);
        temp = Integer.parseInt(q);
        return(temp);
    }
    public int getday(String s){
        int temp;
        String q="";
        q+=s.charAt(10);
        q+=s.charAt(11);
        temp = Integer.parseInt(q);
        return(temp);
    }
    public int getdiff(int month, int day){
        int totday =0;
        int temp = 1;
        while(temp < month){
            if(temp==1||temp==3||temp==5||temp==7||temp==8||temp==10||temp==12)
                totday+=31;
            else if(temp==2)
                totday+=28;
            else if(temp==4||temp==6||temp==9||temp==11)
                totday+=30;
            temp+=1;
        }
        totday += day;
        totday -= 7;
        return (totday);
    }

}
