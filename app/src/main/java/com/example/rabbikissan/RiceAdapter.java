package com.example.rabbikissan;
        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;
        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;
        import java.util.ArrayList;

public class RiceAdapter extends RecyclerView.Adapter<RiceAdapter.Viewholder> {

    private Context dcontext;
    private ArrayList<RiceRate> riceRateArrayList;

    // Constructor
    public RiceAdapter(Context dcontext, ArrayList<RiceRate> riceRateArrayList) {
        this.dcontext = dcontext;
        this.riceRateArrayList = riceRateArrayList;
    }

    @NonNull
    @Override
    public RiceAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rice_rate, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RiceAdapter.Viewholder holder, int position) {
        // to set data to textview and imageview of each card layout
        RiceRate rate= riceRateArrayList.get(position);
        holder.cropDate.setText (rate.getDate ());
        holder.cropNameTV.setText(rate.getRice_name ());
        holder.cropType.setText( rate.getRice_type ());
        holder.cropRateTV.setText( rate.getRate ());
        holder.cropIV.setImageResource(rate.getRice_image ());
        holder.cropInc.setImageResource (rate.getInc_dec ());
    }

    @Override
    public int getItemCount() {
        // this method is used for showing number
        // of card items in recycler view.
        return riceRateArrayList.size();
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public class Viewholder extends RecyclerView.ViewHolder {
        private ImageView cropIV,cropInc;
        private TextView cropDate, cropNameTV,cropType, cropRateTV;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            cropIV = itemView.findViewById(R.id.idIVCourseImage);
            cropInc=itemView.findViewById (R.id.inc_dec);
            cropDate=itemView.findViewById (R.id.idCropdate);
            cropNameTV = itemView.findViewById(R.id.idCropsName);
            cropType = itemView.findViewById(R.id.idCropsType);
            cropRateTV=itemView.findViewById (R.id.idCropRate);
        }
    }
}
