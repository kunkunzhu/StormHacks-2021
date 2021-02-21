package com.example.heartmony;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;

import com.github.mikephil.charting.data.Entry;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;
import java.util.List;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        //For chart
        LineChart chart = (LineChart) findViewById(R.id.chart);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users/self");
        DatabaseReference myRef2 = database.getReference("users/friend");


        //was unable to deploy a listener
        List<Entry> entries = new ArrayList<Entry>();
        List<Entry> entries2 = new ArrayList<Entry>();
        entries.add(new Entry(Float.parseFloat(myRef.child("hourlyHeartRate").child("6").getKey()), 54));
        entries.add(new Entry(Float.parseFloat(myRef.child("hourlyHeartRate").child("7").getKey()), 60));
        entries.add(new Entry(Float.parseFloat(myRef.child("hourlyHeartRate").child("8").getKey()), 72));
        entries.add(new Entry(Float.parseFloat(myRef.child("hourlyHeartRate").child("9").getKey()), 87));
        entries.add(new Entry(Float.parseFloat(myRef.child("hourlyHeartRate").child("10").getKey()), 58));
        entries.add(new Entry(Float.parseFloat(myRef.child("hourlyHeartRate").child("11").getKey()), 65));
        entries.add(new Entry(Float.parseFloat(myRef.child("hourlyHeartRate").child("12").getKey()), 62));

        entries2.add(new Entry(Float.parseFloat(myRef2.child("hourlyHeartRate").child("6").getKey()), 54));
        entries2.add(new Entry(Float.parseFloat(myRef2.child("hourlyHeartRate").child("7").getKey()), 70));
        entries2.add(new Entry(Float.parseFloat(myRef2.child("hourlyHeartRate").child("8").getKey()), 60));
        entries2.add(new Entry(Float.parseFloat(myRef2.child("hourlyHeartRate").child("9").getKey()), 95));
        entries2.add(new Entry(Float.parseFloat(myRef2.child("hourlyHeartRate").child("10").getKey()), 67));
        entries2.add(new Entry(Float.parseFloat(myRef2.child("hourlyHeartRate").child("11").getKey()), 54));
        entries2.add(new Entry(Float.parseFloat(myRef2.child("hourlyHeartRate").child("12").getKey()), 45));


        LineDataSet dataSet1 = new LineDataSet(entries, "Heart Rate (self)");
        LineData lineData = new LineData(dataSet1);
        LineDataSet dataSet2 = new LineDataSet(entries2, "Heart Rate (friend)");
        dataSet2.setColor(Color.rgb(139, 69, 19));
        lineData.addDataSet(dataSet2);
        chart.setData(lineData);
        chart.invalidate();
    }
}