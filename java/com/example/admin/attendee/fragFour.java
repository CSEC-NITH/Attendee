package com.example.admin.attendee;



import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class fragFour extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        View myView= inflater.inflate(R.layout.frag4, container, false);
        Button b1=(Button) myView.findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(),AddNew.class);
                startActivity(i);
            }
        });



        View myyView = inflater.inflate(R.layout.frag4, container,false);
        Button b2=(Button) myyView.findViewById(R.id.button3);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(),accuracy.class);
                startActivity(i);
            }
        });

    }
}
