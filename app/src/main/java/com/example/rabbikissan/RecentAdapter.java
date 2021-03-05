package com.example.rabbikissan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class RecentAdapter extends RecyclerView.Adapter<RecentAdapter.RecentsViewHolder> {

    Context context;
    List<RecentData> recentDataList;

    public RecentAdapter(Context context, List<RecentData> recentDataList) {
        this.context = context;
        this.recentDataList = recentDataList;
    }
//    public RecentAdapter(BookedDealer bookedDealer, List<RecentData> recentDataList) {
//    }

    @NonNull
    @Override
    public RecentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from (context).inflate (R.layout.recents_row_item,parent,false);
        return new RecentsViewHolder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentsViewHolder holder, int position) {

        holder.dealerName.setText (recentDataList.get (position).getName ());
        holder.areaName.setText (recentDataList.get (position).getArea ());
        holder.id_no.setText (recentDataList.get (position).getId ());
        holder.dealerImg.setImageResource (recentDataList.get (position).getImageUrl ());
        holder.itemView.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent i=new Intent (context,Dealer_detail.class);
                context.startActivity (i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return recentDataList.size ();
    }

    public static final class RecentsViewHolder extends RecyclerView.ViewHolder{

        ImageView dealerImg;
        TextView dealerName,areaName,id_no;
        public RecentsViewHolder(@NonNull View itemView) {
            super (itemView);

            dealerImg=itemView.findViewById (R.id.imagedealer);
            dealerName=itemView.findViewById (R.id.dealerName);
            areaName=itemView.findViewById (R.id.dealerArea);
            id_no=itemView.findViewById (R.id.id);
        }
    }
}

