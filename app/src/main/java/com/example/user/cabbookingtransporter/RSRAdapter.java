package com.example.user.cabbookingtransporter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 22/07/2018.
 */

public class RSRAdapter extends ArrayAdapter<cardetails> {

    Activity con;
    int res;
    LayoutInflater l;
    ArrayList<cardetails> rsrdata;
    private static LayoutInflater inflater=null;

    public RSRAdapter(Activity context,int resource,ArrayList<cardetails> rsrData){
        super(context,resource,rsrData);



        this.con = context;
        this.res = resource;
        inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }
    public int getCount() {
        return rsrdata.size();
    }

    public cardetails getItem(cardetails position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {
        public TextView display_name;
        public TextView display_number;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        final ViewHolder holder;
        try {
            if (convertView == null) {
                vi = inflater.inflate(R.layout.customized, null);
                holder = new ViewHolder();

                holder.display_name = (TextView) vi.findViewById(R.id.e);
                holder.display_number = (TextView) vi.findViewById(R.id.cnm);


                vi.setTag(holder);
            } else {
                holder = (ViewHolder) vi.getTag();
            }



            holder.display_name.setText(rsrdata.get(position).empid);
            holder.display_number.setText(rsrdata.get(position).carname);


        } catch (Exception e) {


        }
        return vi;
    }
}