
package com.example.rabbikissan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAddapter extends RecyclerView.Adapter<MyAddapter.SchmeViewHolder>{


    private List<HomeData> mySchemeList;
    private Context mContext;

    public MyAddapter(Context mContext ,List<HomeData> mySchemeList) {
         this.mContext=mContext;
        this.mySchemeList = mySchemeList;
    }



    class SchmeViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView mTitle,mDescription;
        CardView mCardView;

        public SchmeViewHolder(View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.ivImage);
            mTitle=itemView.findViewById(R.id.tvTitle);
            mDescription=itemView.findViewById(R.id.tvDesciption);
            mCardView=itemView.findViewById(R.id.myCardView);
        }
    }

    @Override
    public SchmeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row_item,parent,false);

        return new SchmeViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull SchmeViewHolder holder, int position) {

        holder.imageView.setImageResource(mySchemeList.get(position).getSchmeImage());
        holder.mTitle.setText(mySchemeList.get(position).getSchemeName());
        holder.mDescription.setText(mySchemeList.get(position).getSchmeDesc());


    }

    @Override
    public int getItemCount() {
        return mySchemeList.size();
    }
}
