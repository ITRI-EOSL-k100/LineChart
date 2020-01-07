package com.example.chart_test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    LineChart mChart = (LineChart) findViewById(R.id.chart_line);
    mChart.setData(getLineData() );


    }

    private LineData getLineData(){
        final int DATA_COUNT = 5 ;

        LineDataSet dataSetA = new LineDataSet( getChartData(DATA_COUNT,1),"A" );
        LineDataSet dataSetB = new LineDataSet( getChartData(DATA_COUNT,2),"B" );

        dataSetA.setColor( getResources().getColor(R.color.pink));
        dataSetA.setCircleSize(10f);
        dataSetA.setDrawCircleHole(false);
        dataSetA.setDrawFilled(true);
        dataSetA.setFillColor(ColorTemplate.VORDIPLOM_COLORS[0]);
        dataSetA.setFillAlpha(100);

        List <LineDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataSetA);
        dataSets.add(dataSetB);

        LineData data = new LineData(getLabels(DATA_COUNT), dataSets);
        return data ;
    }

    private List<Entry> getChartData(int count, int ratio){

        List<Entry> chartData = new ArrayList<>();
        for (int i=0;i<count;i++){
            chartData.add(new Entry(i*2*ratio, i));
        }
        return chartData;
    }

    private List<String> getLabels(int count){
        List <String> chartLabels = new ArrayList<>();
        for (int i=0;i<count;i++){
            chartLabels.add("X" +i);
        }
        return chartLabels;
    }
}
