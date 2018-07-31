package com.example.user.cabbookingtransporter;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class vehiclesending extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
    Button approve,reject;
    EditText carno,carname,cardriverno,remarks;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String emp_id,s;
    int p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehiclesending);
        getSupportActionBar().setTitle("Raysil Cab booking vehicle sending page");
        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        t3=(TextView)findViewById(R.id.t3);
        t4=(TextView)findViewById(R.id.t4);
        t5=(TextView)findViewById(R.id.t5);
        t6=(TextView)findViewById(R.id.t6);
        t7=(TextView)findViewById(R.id.t7);
        t8=(TextView)findViewById(R.id.t8);
        t9=(TextView)findViewById(R.id.t9);
        t10=(TextView)findViewById(R.id.t10);
        t11=(TextView)findViewById(R.id.t11);
        t12=(TextView)findViewById(R.id.t12);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();



        Bundle extras=getIntent().getExtras();
        String name=extras.getString("Name");
        final String empid=extras.getString("empid");
        emp_id=empid;
        String designation=extras.getString("designation");
        String jobband=extras.getString("jobband");
        String from=extras.getString("from");
        String to=extras.getString("to");
        String pickup=extras.getString("pickup");
        String no=extras.getString("No");
        String phnno=extras.getString("phnno");
        String fromdate=extras.getString("fromdate");
        String todate=extras.getString("todate");
        String type=extras.getString("type");
        int position=extras.getInt("position");
        p=position;
        t1.setText(name);
        t2.setText(empid);
        t3.setText(designation);
        t4.setText(jobband);
        t5.setText(from);
        t6.setText(to);
        t7.setText(pickup);
        t8.setText(no);
        t9.setText(phnno);
        t10.setText(fromdate);
        t11.setText(todate);
        t12.setText(type);
        carname=(EditText)findViewById(R.id.carname);
        carno=(EditText)findViewById(R.id.carno);
        cardriverno=(EditText)findViewById(R.id.cardriverno);
        remarks=(EditText)findViewById(R.id.remarks);
        approve=(Button)findViewById(R.id.approve);
        reject=(Button)findViewById(R.id.reject);
        approve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String carnam=carname.getText().toString();
                String carn=carno.getText().toString();
                String cardrive=cardriverno.getText().toString();
                String remark=remarks.getText().toString();
                sendtodb(carnam,carn,cardrive,remark);
                s="approve";
                Toast.makeText(vehiclesending.this,"You have successfully provided a vehicle",Toast.LENGTH_LONG).show();

                send(carn,carnam,emp_id);


            }
        });
    reject.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            String remark="Sorry! There is no car available ";
            String carnam="-";
            String carn="-";
            String cardrive="-";
            sendtodb(carnam,carn,cardrive,remark);
            Toast.makeText(vehiclesending.this,"You have Rejected the vehicle request",Toast.LENGTH_LONG).show();


        }
    });}
    public void send(String carnam,String carn,String empid)
    {
        cardetails a=new cardetails(carnam,carn,empid);
    }

public void sendtodb(String carname,String carno,String cardriverno,String remarks){
        String s=databaseReference.push().getKey();
        vehicle v= new vehicle(carname,carno,cardriverno,remarks);
        databaseReference.child("user").child(emp_id).child(s).setValue(v);

            Intent intent = new Intent();
            intent.setClass(vehiclesending.this, Transporter.class);
            startActivity(intent);





}

    }

