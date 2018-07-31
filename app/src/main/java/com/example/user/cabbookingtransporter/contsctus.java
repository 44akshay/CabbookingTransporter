package com.example.user.cabbookingtransporter;

import android.*;
import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;

import java.security.Permissions;

public class contsctus extends AppCompatActivity {
    Button button;
    private  static final int call=1;
    private static String[] PERMISSION={
            Manifest.permission.CALL_PHONE,
    };
    public static void check(Activity activity)
    {
int permission = ActivityCompat.checkSelfPermission(activity,Manifest.permission.CALL_PHONE);
if(permission!= PackageManager.PERMISSION_GRANTED)
{
    ActivityCompat.requestPermissions(activity,PERMISSION,call);
}

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contsctus);
        check(contsctus.this);
        button=(Button)findViewById(R.id.call);
        final int permission = ActivityCompat.checkSelfPermission(contsctus.this,Manifest.permission.CALL_PHONE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(permission!= PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(contsctus.this,PERMISSION,call);
                }
                else
                {
                    Intent intent=new Intent();
                    intent.setData(Uri.parse("tel:9824496797"));
                    startActivity(intent);
                }


            }
        });
//        if(ContextCompat.checkSelfPermission(contsctus.this,Manifest.permission.C))
    }
}
