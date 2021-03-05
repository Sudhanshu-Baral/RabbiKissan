
package com.example.rabbikissan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyAddapter1  extends RecyclerView.Adapter<MyAddapter1.DealerViewHolder> {



    private List<Dealer_Data> nyDealerList;
    private Context nContext;

    public MyAddapter1(Context nContext ,List<Dealer_Data> nyDealerList) {
        this.nContext=nContext;
        this.nyDealerList = nyDealerList;
    }

    public void filteredList(ArrayList<Dealer_Data> filterList) {

        nyDealerList =filterList;
        notifyDataSetChanged ();

    }




    public class DealerViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView mName, mArea,mPhone,mId;
        CardView nCardView;

        public DealerViewHolder(View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.iv_dealerImage);
            mName=itemView.findViewById(R.id.txt_dealer_Name);
            mArea=itemView.findViewById(R.id.txt_area);
            mPhone=itemView.findViewById(R.id.txt_phone);
            mId=itemView.findViewById (R.id.txt_id);
            nCardView=itemView.findViewById(R.id.myCardView1);
        }
    }

    @Override
    public DealerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_row_item1,parent,false);

        return new DealerViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull DealerViewHolder holder, int position) {
        Glide.with (nContext)
                .load (nyDealerList.get (position).getDealerImage ())
                .into (holder.imageView);

      // holder.imageView.setImageResource(nyDealerList.get(position).getDealerImage ());
        holder.mName.setText(nyDealerList.get(position).getDealerName ());
        holder.mArea.setText(nyDealerList.get(position).getDealerArea ());
        holder.mPhone.setText(nyDealerList.get(position).getDealerNumber ());
        holder.mId.setText (nyDealerList.get (position).getDealerId ());
        holder.nCardView.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (nContext,DetailActivity.class);
                intent.putExtra ("Image",nyDealerList.get (holder.getAdapterPosition ()).getDealerImage ());
                intent.putExtra ("Name",nyDealerList.get (holder.getAdapterPosition ()).getDealerName ());
                intent.putExtra ("Area",nyDealerList.get (holder.getAdapterPosition ()).getDealerArea ());
                intent.putExtra ("Phone Number",nyDealerList.get (holder.getAdapterPosition ()).getDealerNumber ());
                intent.putExtra ("id",nyDealerList.get (holder.getAdapterPosition ()).getDealerId ());
                nContext.startActivity (intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return nyDealerList.size();
    }
}
