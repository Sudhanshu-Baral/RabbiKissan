package com.example.rabbikissan;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageAdapterViewHolder> {


    Context context;
    List<ChatData> chatData;
    DatabaseReference databaseReference;

    public MessageAdapter(Context context,List<ChatData> chatData,DatabaseReference databaseReference){
        this.context=context;
        this.chatData=chatData;
        this.databaseReference=databaseReference;

    }

    @NonNull
    @Override
    public MessageAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from (context).inflate (R.layout.item_message,parent,false);
        return new MessageAdapterViewHolder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapterViewHolder holder, int position) {

        ChatData chatData1=chatData.get (position);
        if (chatData1.getMessageUser ().equals (AllMethods.name)){
            holder.tvTitle.setText ("You :" + chatData1.getMessageText ());
            holder.tvTitle.setGravity (Gravity.START);
            holder.l1.setBackgroundColor (Color.parseColor ("EP9E73"));
        }
        else {
            holder.tvTitle.setText (chatData1.getMessageUser ()+ ""+chatData1.getMessageText ());
            holder.ibDelete.setVisibility (View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return chatData.size ();
    }

    public class MessageAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageButton ibDelete;

         LinearLayout l1;

        public MessageAdapterViewHolder(@NonNull View itemView) {
            super (itemView);
            tvTitle=(TextView)itemView.findViewById (R.id.tv1title);
            ibDelete=(ImageButton)itemView.findViewById (R.id.delete);
            l1=(LinearLayout)itemView.findViewById (R.id.message11);
            ibDelete.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    databaseReference.child (chatData.get (getAdapterPosition ()).getKey ()).removeValue ();
                }
            });
        }
    }
}
