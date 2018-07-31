package com.example.user.cabbookingtransporter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Transporter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transporter);
        TextView vehicle=(TextView)findViewById(R.id.vehiclerequest);
        vehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Transporter.this,vehiclerequest.class);
                startActivity(intent);

            }
        });
        TextView approved=(TextView)findViewById(R.id.app);
        approved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Transporter.this,approved.class);
                startActivity(intent);
            }
        });
        TextView contact =(TextView)findViewById(R.id.contact);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Transporter.this,contsctus.class);
                startActivity(intent);
            }
        });

    }
}
