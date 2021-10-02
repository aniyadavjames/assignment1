package com.e.assignment1;

import androidx.lifecycle.ViewModelProviders;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYGraphWidget;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.Arrays;

public class first extends Fragment {

    private FirstViewModel mViewModel;
    XYPlot xyPlot;
    

    public static first newInstance() {
        return new first();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.first_fragment, container, false);
        xyPlot=(XYPlot) view.findViewById(R.id.plot);

        final  Number[] domainlabel= {1,2,3,4,5,6,7};
        Number [] series1 = {2, 1, 1, 2, 3, 2, 4}; 





        XYSeries xySeries = new SimpleXYSeries(Arrays.asList(series1), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY,"series");

        LineAndPointFormatter lineAndPointFormatter = new LineAndPointFormatter( Color.RED,Color.GREEN,null,null);

        xyPlot.addSeries(xySeries,lineAndPointFormatter);

        xyPlot.getGraph().getLineLabelStyle(XYGraphWidget.Edge.BOTTOM).setFormat(new Format() {
            @Override
            public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {


                int i = Math.round(((Number)obj).floatValue());
                return toAppendTo.append(domainlabel[i]);
            }

            @Override
            public Object parseObject(String source, ParsePosition pos) {
                return null;
            }
        });

        return view;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FirstViewModel.class);
        // TODO: Use the ViewModel


    }

}