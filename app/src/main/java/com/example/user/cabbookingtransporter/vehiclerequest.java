package com.example.user.cabbookingtransporter;

import android.content.Intent;
import android.service.autofill.Dataset;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.List;

public class vehiclerequest extends AppCompatActivity  {
    FirebaseDatabase f;
    DatabaseReference d;
    private RecyclerView recyclerView;
    FirebaseRecyclerAdapter<booking,ViewHolder> firebaseRecyclerAdapter;
    TextView empty;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehiclerequest);
        getSupportActionBar().setTitle("Raysil Cab booking vehicle request page");
        f = FirebaseDatabase.getInstance();
        d = f.getReference();
        f = FirebaseDatabase.getInstance();
        d = f.getReference("employee");
        d.keepSynced(true);

        recyclerView=(RecyclerView)findViewById(R.id.recycler);
        empty=(TextView)findViewById(R.id.empty);

        recyclerView.setLayoutManager(new LinearLayoutManager(vehiclerequest.this));
        firebaseRecyclerAdapter =new FirebaseRecyclerAdapter<booking, ViewHolder>(booking.class,android.R.layout.two_line_list_item,ViewHolder.class,d) {
            @Override
            protected void populateViewHolder(ViewHolder viewHolder, final booking model, final int position) {
                viewHolder.txt.setText("Emp_id :"+model.getEmpid()+"\n"+"Designation :"+model.getDesignation()+"\n"+"Jobband :"+model.getJobband()+"\n"+
                "Type :"+model.getType());
                viewHolder.view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       Intent intent=new Intent(vehiclerequest.this,vehiclesending.class);
                       intent.putExtra("Name",model.getName());
                        intent.putExtra("empid",model.getEmpid());
                        intent.putExtra("designation",model.getDesignation());
                        intent.putExtra("jobband",model.getJobband());
                        intent.putExtra("from",model.getFrom());
                        intent.putExtra("to",model.getTo());
                        intent.putExtra("pickup",model.getPickup());
                        intent.putExtra("No",model.getNo());
                        intent.putExtra("phnno",model.getPhn());
                        intent.putExtra("fromdate",model.getFromdate());
                        intent.putExtra("todate",model.getTodate());
                        intent.putExtra("type",model.getType());
                        intent.putExtra("position",position);
                       startActivity(intent);
                        DatabaseReference myref=firebaseRecyclerAdapter.getRef(position);
                        myref.removeValue();


                    }
                });
            }
        };
        if(recyclerView.getAdapter()!=null) {
            recyclerView.setVisibility(View.GONE);
            empty.setVisibility(View.VISIBLE);
        }
        empty.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);


        recyclerView.setAdapter(firebaseRecyclerAdapter);

    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt;
        View view;
        public ViewHolder(View itemview){
            super(itemview);
            txt=(TextView)itemview.findViewById(android.R.id.text1);
            view=itemview;
        }


    }
    public void delete(int position)
    {
        DatabaseReference myref=firebaseRecyclerAdapter.getRef(position);
        myref.removeValue();
    }
}

