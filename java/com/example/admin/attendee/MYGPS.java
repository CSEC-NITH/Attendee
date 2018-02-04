package com.example.admin.attendee;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MYGPS extends Service implements LocationListener
{

    boolean isGPSEnable = false;
    boolean isNetworkEnable = false;
    double latitude,longitude;
    LocationManager locationManager;
    Location location;
    private Handler mHandler = new Handler();
    private Timer mTimer = null;
    long notify_interval = 1000;
    public static String str_receiver = "kartik.service.receiver";
    Intent intent;


    MyCalendar MYC=new MyCalendar();                        // object of calendar helper class for checking day of lecture
    
    DatabaseHelper DBH=new DatabaseHelper();              // object of database helper for seeing schedule of lectures

    public MYGPS() {

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mTimer = new Timer();
        mTimer.schedule(new TimerTaskToGetLocation(),5,notify_interval);
        intent = new Intent(str_receiver);
//        fn_getlocation();
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    private void fn_getlocation()
    {
        locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);
        isGPSEnable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        isNetworkEnable = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        if (!isGPSEnable && !isNetworkEnable)
        {

        }
        
        else {

            if (isNetworkEnable){
                location = null;
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,1000,0,this);
                if (locationManager!=null){
                    location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                    if (location!=null){

                        Log.e("latitude",location.getLatitude()+"");
                        Log.e("longitude",location.getLongitude()+"");

                        latitude = location.getLatitude();
                        longitude = location.getLongitude();
                        fn_update(location);
                    }
                }

            }


            if (isGPSEnable){
                location = null;
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,0,this);
                if (locationManager!=null){
                    location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                    if (location!=null){
                        Log.e("latitude",location.getLatitude()+"");
                        Log.e("longitude",location.getLongitude()+"");
                        latitude = location.getLatitude();
                        longitude = location.getLongitude();
                        fn_update(location);
                    }
                }
            }


        }

    }

    private class TimerTaskToGetLocation extends TimerTask
    {
        @Override
        public void run() {

            mHandler.post(new Runnable()
             {
                @Override
                public void run() 
                {
                  
                     time = new SimpleDateFormat("yyyy//MM//dd_____HH//mm//ss").format(Calendar.getInstance().getTime());
                       text = (TextView)findViewById(R.id.text);
                      text2 = (TextView)findViewById(R.id.text2);
                      month = getmonth(time);
                      day   = getday(time);
                      diff = getdiff(month,day);
                      
                      hrs=gethrs(time);
                      min=getmin(time);
                      
                      totalmin=hrs*60+min;
                      
                      int X=MYC.getdiff(month,day);
                      
                      
                      Cursor c=DBH.getAllDataLectures();
                      
                      
                      while(c.movetonext())
                      {
                         if((DBH.checkinbetweenLectures(totalmin,day%7,latitude,longitude))==true)
                         {
                             DBH.updateLecture(c.getLecture(n),1)           // PRESENT
                      
                         }
                         
                         else
                         {
                           DBH.updateLecture(c.getLecture(n),0)          //ABSENT
                           
                          }
                         
                     }
                  
                      
                   

                    fn_getlocation();
                }
            });

        }
    }

    private void fn_update(Location location){

        intent.putExtra("latutide",location.getLatitude()+"");
        intent.putExtra("longitude",location.getLongitude()+"");
        sendBroadcast(intent);
    }


}
