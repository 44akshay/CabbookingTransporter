package com.example.user.cabbookingtransporter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class approved extends AppCompatActivity {
    List<appvehicles> appvehicle;
    RecyclerView recyclerView;
    cardetails a;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approved);
      recyclerView=(RecyclerView)findViewById(R.id.rel);
      recyclerView.setHasFixedSize(true);
      recyclerView.setLayoutManager(new LinearLayoutManager(this));
      appvehicle= new ArrayList<>();
        Bundle extras=getIntent().getExtras();
        String empid=extras.getString("empid");
        String carno=extras.getString("carno");
        String carname=extras.getString("carname");
      appvehicle.add(new appvehicles(empid,carno,carname));
      caradapter caradapter=new caradapter(this,appvehicle);
      recyclerView.setAdapter(caradapter);


    }
}
