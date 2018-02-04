package com.example.admin.attendee;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;

import static com.github.mikephil.charting.utils.ColorTemplate.COLORFUL_COLORS;

public class bargraph extends AppCompatActivity {

    BarChart barChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        barChart = (BarChart)findViewById(R.id.barchart);

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1,80f));
        barEntries.add(new BarEntry(2,65f));
        barEntries.add(new BarEntry(3,83f));
        barEntries.add(new BarEntry(4,92f));
        barEntries.add(new BarEntry(5,75f));
        barEntries.add(new BarEntry(6,88f));
        BarDataSet barDataSet =new BarDataSet(barEntries,"Dates");
        barDataSet.setColors(COLORFUL_COLORS);

        BarData theData = new BarData(barDataSet);
        theData.setBarWidth(1.0f);
        barChart.setData(theData);
       /* barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setScaleXEnabled(true);
        barChart.setScaleYEnabled(true);
        barChart.setPinchZoom(true);
        barChart.setDoubleTapToZoomEnabled(true);*/

        YAxis yAxis = barChart.getAxisLeft();
        LimitLine ll = new LimitLine(7.5f, "");
        ll.setLineColor(Color.BLACK);
        ll.setLineWidth(4f);
        ll.setTextColor(Color.BLACK);
        ll.setTextSize(12f);
        yAxis.addLimitLine(ll);
        String[] write = new String[]{"EVS","DS","OS","SS","TOC","CO"};
        XAxis xAxis = barChart.getXAxis();
        xAxis.setDrawLabels(true);
        xAxis.setValueFormatter(new MyXAxisValueformatter(write));
        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);


    }

    public class MyXAxisValueformatter implements IAxisValueFormatter {
        private String[] mvalues;
        public MyXAxisValueformatter(String[] values){
            this.mvalues=values;
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            if(value >0)
                return mvalues[(int) value-1];
            else
                return mvalues[0];
        }
    }
}
