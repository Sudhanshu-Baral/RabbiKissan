package com.example.rabbikissan;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class TopPlaceAdapter extends RecyclerView.Adapter<TopPlaceAdapter.TopPlaceViewHolder> {

    Context context;
    List<TopPlace> topPlaces;

    public TopPlaceAdapter(Context context, List<TopPlace> topPlaces) {
        this.context = context;
        this.topPlaces = topPlaces;
    }
//    public RecentAdapter(BookedDealer bookedDealer, List<RecentData> recentDataList) {
//    }

    @NonNull
    @Override
    public TopPlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from (context).inflate (R.layout.top_dealer_row,parent,false);
        return new TopPlaceViewHolder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopPlaceViewHolder holder, int position) {

        holder.dealerName.setText (topPlaces.get (position).getName ());
        holder.areaName.setText (topPlaces.get (position).getArea ());
        holder.id_no.setText (topPlaces.get (position).getId ());
        holder.dealerImg.setImageResource (topPlaces.get (position).getImageUrl ());


    }

    @Override
    public int getItemCount() {
        return topPlaces.size ();
    }

    public static final class TopPlaceViewHolder extends RecyclerView.ViewHolder{

        ImageView dealerImg;
        TextView dealerName,areaName,id_no;
        public TopPlaceViewHolder(@NonNull View itemView) {
            super (itemView);

            dealerImg=itemView.findViewById (R.id.image3);
            dealerName=itemView.findViewById (R.id.dealer_nm);
            areaName=itemView.findViewById (R.id.area_nm);
            id_no=itemView.findViewById (R.id.id_no);
        }
    }
}


