package com.example.consult;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>{

    ArrayList<model>dataholder;

    public myadapter(ArrayList<model> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.did.setText(dataholder.get(position).getSid());
        holder.dname.setText(dataholder.get(position).getSname());
        holder.dproblem.setText(dataholder.get(position).getSprob());
        holder.ddate.setText(dataholder.get(position).getDate());
        holder.dapp.setText(dataholder.get(position).getAppoint());

    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView did,dname,dproblem,ddate,dapp;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            did=(TextView)itemView.findViewById(R.id.asid);
            dname=(TextView)itemView.findViewById(R.id.aname);
            dproblem=(TextView)itemView.findViewById(R.id.aproblem);
            ddate=(TextView)itemView.findViewById(R.id.adate);
            dapp=(TextView)itemView.findViewById(R.id.aapp);
        }
    }
}
