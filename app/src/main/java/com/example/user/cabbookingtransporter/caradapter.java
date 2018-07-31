package com.example.user.cabbookingtransporter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 28/07/2018.
 */

public class caradapter extends RecyclerView.Adapter<caradapter.ViewHolder> {
    private Context mctx;
    private List<appvehicles> appvehicle;

    public caradapter(Context mctx, List<com.example.user.cabbookingtransporter.appvehicles> appvehicles) {
        this.mctx = mctx;
        this.appvehicle = appvehicles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflator=LayoutInflater.from(mctx);
        View view=inflator.inflate(R.layout.listview,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        appvehicles appvehicles=appvehicle.get(position);
        holder.empid.setText(appvehicles.getEmpid());
        holder.carno.setText(appvehicles.getCarno());
        holder.carname.setText(appvehicles.getCarname());


    }

    @Override
    public int getItemCount() {
        return appvehicle.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView empid, carno, carname;

        public ViewHolder(View itemView) {
            super(itemView);
            empid = itemView.findViewById(R.id.emid);
            carno = itemView.findViewById(R.id.crno);
            carname = itemView.findViewById(R.id.crname);

        }
    }
}

